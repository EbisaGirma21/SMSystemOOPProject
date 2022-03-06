import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Admin extends User {
    Scanner input = new Scanner(System.in);
    Student student = new Student(null, null, null, null, null, null, null, null);
    Teacher teacher = new Teacher(null, null, null, null, null, null);
    String userName;
    String password;
    int validity;

    Admin(String firstName, String middleName, String lastName, String userId, String gender, String password,
            String userName) {
        super(firstName, middleName, lastName, userId, gender);
        this.password = password;
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getValidity() {
        return validity;
    }

    void checkValidity() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Your User Name");
        String adminUserName = input.nextLine();
        System.out.println("Enter your Password");
        String adminPassword = input.nextLine();
        System.out.println("Loading...");
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        Statement statements = con.createStatement();
        String sql = "select userName , Password from admin";
        ResultSet resultStore = statements.executeQuery(sql);
        while (resultStore.next()) {
            setUserName(resultStore.getString(1));
            setPassword(resultStore.getString(2));
        }
        if (adminUserName.equals(getUserName()) && adminPassword.equals(getPassword())) {
            this.validity = 1;
        } else {
            this.validity = 0;
        }
    }

    void adminPort()
            throws InterruptedException, IOException, ClassNotFoundException, SQLException, ServerCloneException {
        /// initialazation of query as local variable in this method
        String query = "";
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        /// admin option is initialyy by zero since it is used by many method
        int adminOption = 0;
        while (adminOption != -1) {
            //// this count can count number of try of the user
            int count = 0;
            if (count == 3)
                break;
            checkValidity();
            if (getValidity() == 1) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("1. To View Student Information");
                System.out.println("2. To View Staffs information");
                System.out.println("3. To Assign Teacher for the Grade");
                System.out.println("press -1 to exit ");
                String adOption = input.nextLine();
                adminOption = Integer.parseInt(adOption);
                while (adminOption != -1) {
                    if (adminOption == 1) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("1. To Search student by Their identification number");
                        System.out.println("2. To Search student by their Grade");
                        System.out.println("3. To View your all student");
                        System.out.println("4. To Update Students information");
                        System.out.println("5. To Add Students information");
                        System.out.println("6. To Delete student");
                        System.out.println("press -1 to exit ");
                        String admin2Option = input.nextLine();
                        int adminSecondOption = Integer.parseInt(admin2Option);
                        while (adminSecondOption != -1) {
                            if (adminSecondOption == 1) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter student ID number");
                                String studentId = input.nextLine();
                                studentId = validityChecker(studentId);
                                query = "select * from students where studentID = " + studentId;
                                student.setUserCon(query);

                            } else if (adminSecondOption == 2) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter Your student Grade");
                                String gradeNumber = input.nextLine();
                                gradeNumber = validityChecker(gradeNumber);
                                query = "select * from students where gradeNumber = " + gradeNumber;
                                student.setUserCon(query);

                            } else if (adminSecondOption == 3) {
                                query = "select * from students";
                                student.setUserCon(query);
                            } else if (adminSecondOption == 4) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter student ID number you want to update");
                                String studentId = input.nextLine();
                                if (!studentId.matches("[0-9]+")) {
                                    System.out.println("Invalid ID");
                                } else {
                                    query = "select * from students where studentID = " + studentId;
                                    student.setUserCon(query);
                                    System.out.println(student.userUpdate(studentId));
                                }

                            } else if (adminSecondOption == 5) {
                                student.userInserting();
                            } else if (adminSecondOption == 6) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter student ID number");
                                String studentId = input.nextLine();
                                if (!studentId.matches("[0-9]+")) {
                                    System.out.println("Invalid ID");
                                } else {
                                    query = "delete from students where studentID =? ";
                                    student.deleteUser(query, studentId);
                                }
                            } else {
                                System.out.println("Please Enter correct option");
                            }
                            System.out.println("1. To search student by Their identification number");
                            System.out.println("2. To search student by their Grade");
                            System.out.println("3. To View your all student");
                            System.out.println("4. To Update Students information");
                            System.out.println("5. To Add Students information");
                            System.out.println("6. To Delete student");
                            System.out.println("press -1 to exit ");
                            admin2Option = input.nextLine();
                            adminSecondOption = Integer.parseInt(admin2Option);
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        }

                    } else if (adminOption == 2) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("1. To Search Teacher by Their identification number");
                        System.out.println("2. To Search student by their Subject");
                        System.out.println("3. To View all Teacher ");
                        System.out.println("4. To update Teachers Information ");
                        System.out.println("5. To Add Teacher information");
                        System.out.println("6. To Delete Teacher information");
                        System.out.println("press -1 to exit ");
                        String admin2Option = input.nextLine();
                        int adminSecondOption = Integer.parseInt(admin2Option);
                        while (adminSecondOption != -1) {
                            if (adminSecondOption == 1) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter Teacher ID number");
                                String teacherID = input.nextLine();
                                teacherID = validityChecker(teacherID);
                                query = "select * from teacher where teacherID = " + teacherID;
                                teacher.setUserCon(query);

                            } else if (adminSecondOption == 2) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter Your Teacher Subject");
                                String teacherSubject = input.nextLine();
                                if (!teacherSubject.matches("[A-z]+")) {
                                    System.out.println("Invalid Subject");
                                } else {
                                    query = "select * from teacher where subject = " + teacherSubject;
                                    teacher.setUserCon(query);
                                }
                            } else if (adminSecondOption == 3) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                query = "select * from teacher";
                                teacher.setUserCon(query);

                            } else if (adminSecondOption == 4) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter Teacher ID number you want to update");
                                String teacherID = input.nextLine();
                                teacherID = validityChecker(teacherID);
                                query = "select * from teacher where teacherID = " + teacherID;
                                teacher.setUserCon(query);
                                System.out.println(teacher.userUpdate(teacherID));
                            } else if (adminSecondOption == 5) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                teacher.userInserting();
                            } else if (adminSecondOption == 6) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("Enter teacher ID number");
                                String teacherID = input.nextLine();
                                teacherID = validityChecker(teacherID);
                                query = "delete from teacher where teacherID =? ";
                                teacher.deleteUser(query, teacherID);

                            } else {
                                System.out.println("Please Enter correct option");
                            }
                            System.out.println("1. To Search Teacher by Their identification number");
                            System.out.println("2. To Search your student by their Subject");
                            System.out.println("3. To Add your all Teacher ");
                            System.out.println("4. To Update  Teachers Information ");
                            System.out.println("5. To Add Teacher information");
                            System.out.println("6. To Delete Teacher information");
                import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Marks {

    Scanner input = new Scanner(System.in);
    String studentId;
    String subjectId;
    int quiz;
    int assignment;
    int midexam;
    int finalexam;
    int total;

    Marks(String studentId, String subjectId, int quiz, int assignment, int midexam, int finalexam, int total) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.quiz = quiz;
        this.assignment = assignment;
        this.midexam = midexam;
        this.finalexam = finalexam;
        this.total = total;
    }

    public Marks(Object object, Object object2, Object object3, Object object4, Object object5, Object object6,
            Object object7, Object object8) {
    }

    void setMarks(String studentId, String subjectId, int quiz, int assignment, int midexam, int finalexam, int total) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.quiz = quiz;
        this.assignment = assignment;
        this.midexam = midexam;
        this.finalexam = finalexam;
        this.total = total;
    }

    public int getAssignment() {
        return assignment;
    }

    public int getFinalexam() {
        return finalexam;
    }

    public int getMidexam() {
        return midexam;
    }

    public int getQuiz() {
        return quiz;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getTotal() {
        return total;
    }

    String validityChecker(String Checkable) {
        while (true) {
            if (!Checkable.matches("[0-9]+")) {
                System.out.println("Invalid Grade");
                System.out.println("Please Enter another");
                Checkable = input.nextLine();
            } else {
                break;
            }
        }
        return Checkable;
    }

    // Getting the marks from the database through DataBaseAccess class
    void setMarksCon(String sql) throws ClassNotFoundException, SQLException {
        Marks[] marks = new Marks[100];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = new Marks(null, null, null, null, null, null, null, null);
        }
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        Statement statements = con.createStatement();
        ResultSet resultStore = statements.executeQuery(sql);

        int i = 0;
        while (resultStore.next()) {
            marks[i].setMarks(resultStore.getString(1), resultStore.getString(2),
                    resultStore.getInt(3), resultStore.getInt(4),
                    resultStore.getInt(5),
                    resultStore.getInt(6), resultStore.getInt(7));
            i++;
        }
        if (i == 0) {
            System.out.println("There is no specified student yet!");
        } else {
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");
            System.out.printf("%10s %15s %15s %15s %15s %15s %15s",
                    "StudentId", "SubjectCoode", "Quiz", "Assignment", "Mid_Exam", "Final-Exam", "Total");
            System.out.println();
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");
            for (int j = 0; j < i; j++) {
                System.out.format("%10s %15s %15s %15s %15s %15s %15s",
                        marks[j].getStudentId(), marks[j].getSubjectId(), marks[j].getQuiz(),
                        marks[j].getAssignment(), marks[j].getMidexam(),
                        marks[j].getFinalexam(),
                        marks[j].getTotal());
                System.out.println();
            }
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------");

        }
    }

    // Inserthing Marks of students
    void markInserting() throws SQLException, ClassNotFoundException {
        System.out.println("Enter student ID ");
        studentId = input.nextLine();
        System.out.println("Enter subject ID ");
        subjectId = input.nextLine();
        System.out.println("Enter quiz ");
        String quizs = input.nextLine();
        quizs = validityChecker(quizs);
        quiz = Integer.parseInt(quizs);
        System.out.println("Enter assignment ");
        String assignments = input.nextLine();
        assignments = validityChecker(assignments);
        assignment = Integer.parseInt(assignments);
        System.out.println("Enter mid-exam ");
        String mid_exam = input.nextLine();
        mid_exam = validityChecker(mid_exam);
        midexam = Integer.parseInt(mid_exam);
        System.out.println("Enter final ");
        String final_exam = input.nextLine();
        final_exam = validityChecker(final_exam);
        finalexam = Integer.parseInt(final_exam);
        total = quiz + assignment + midexam + finalexam;
        String queryInsert = "insert into marks values(?,?,?,?,?,?,?)";
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        Statement statements = con.createStatement();
        String[] existanceOfId = new String[100];
        ResultSet resultStore = statements.executeQuery("select * from students");
        int i = 0;
        while (resultStore.next()) {
            existanceOfId[i] = resultStore.getString(4);
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (studentId.equals(existanceOfId[j])) {
                break;
            } else {
                System.out.println("There is no student with this ID ");
                System.out.println("Please Enter another");
                studentId = input.nextLine();
                studentId = validityChecker(studentId);

            }
        }
        resultStore = statements.executeQuery("select * from subject");
        i = 0;
        while (resultStore.next()) {
            existanceOfId[i] = resultStore.getString(2);
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (subjectId.equals(existanceOfId[j])) {
                break;
            } else {
                System.out.println("There is no subject with this ID ");
                System.out.println("Please Enter another");
                subjectId = input.nextLine();
            }
        }

        PreparedStatement insert = con.prepareStatement(queryInsert);
        insert.setString(1, studentId);
        insert.setString(2, subjectId);
        insert.setInt(3, quiz);
        insert.setInt(4, assignment);
        insert.setInt(5, midexam);
        insert.setInt(6, finalexam);
        insert.setInt(7, total);
        insert.execute();
        System.out.println("Successfully inserted");
    }

    // Updating marks of student
    String marksUpdate(String studentID) throws SQLException, ClassNotFoundException {
        try {
            DataBaseAccess db = new DataBaseAccess();
            Connection con = db.Connection();
            Statement statements = con.createStatement();
            System.out.println("1.Quiz  2.Assignment  3.Mid-Exam  5.Final Exam  ");
            String info = "";
            String updatedInfo = "";
            int uptoDate;
            String opt = input.nextLine();
            int options = Integer.parseInt(opt);
            if (options == 1) {
                info = "quiz";
                System.out.println("Enter  quiz");
                updatedInfo = input.nextLine();
                uptoDate = Integer.parseInt(updatedInfo);
            } else if (options == 2) {
                info = "assignment";
                System.out.println("Enter assignment");
                updatedInfo = input.nextLine();
                uptoDate = Integer.parseInt(updatedInfo);
            } else if (options == 3) {
                info = "midExam";
                System.out.println("Enter Mid-Exam");
                updatedInfo = input.nextLine();
                uptoDate = Integer.parseInt(updatedInfo);
            } else if (options == 4) {
                info = "finalExam";
                System.out.println("Enter Final-Exam");
                updatedInfo = input.nextLine();
                uptoDate = Integer.parseInt(updatedInfo);
            } else {
                System.out.println("Incorrect input");
                return "This is Hidden!";
            }

            String queryUpdate = "update marks set " + info + " = ? where studentID = ?";
            PreparedStatement update = con.prepareStatement(queryUpdate);
            update.setInt(1, uptoDate);
            update.setString(2, studentID);
            update.executeUpdate();
            ResultSet resultStore = statements.executeQuery("select * from marks where studentID=" + studentID);
            while (resultStore.next())
                total = resultStore.getInt(3) + resultStore.getInt(4) + resultStore.getInt(5) + resultStore.getInt(6);
            queryUpdate = "update marks set total = ? where studentID = ?";
            update = con.prepareStatement(queryUpdate);
            update.setInt(1, total);
            update.setString(2, studentID);
            update.executeUpdate();
            return "Successfully Updated!";

        } catch (

        Exception e) {
            System.out.println("This is Hidden please Try Again");
            return " not Successfully Updated!";

        }
    }

}
            System.out.println("press -1 to exit ");
                            admin2Option = input.nextLine();
                            adminSecondOption = Integer.parseInt(admin2Option);
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        }
                    } else {
                        System.out.println("Please Enter the correct option\n");
                    }
                    System.out.println("1. To View student Information");
                    System.out.println("2. To View Staffs information");
                    System.out.println("press -1 to exit ");
                    adOption = input.nextLine();
                    adminOption = Integer.parseInt(adOption);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                }
            } else {
                count++;
                System.out.println("Please Enter Correct User Name and Password");

            }
        }
    }

    @Override
    void setUserCon(String query) throws ClassNotFoundException, ServerCloneException {
        // TODO Auto-generated method stub

    }

    @Override
    String userUpdate(String userId) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    void userInserting() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

    }
}
