import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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

    public Marks(Object object, Object object2, String sql, String sql2, String sql3, String sql4, String sql5,
            String sql6) {
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

    void setMarksCon(String sql) throws ClassNotFoundException, SQLException {
        Marks[] marks = new Marks[100];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = new Marks(null, null, sql, sql, sql, sql, sql, sql);
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
        System.out.println(
                "StudentId    SubjectCoode    Quiz     Assignment    Mid_Exam     Final-Exam     Total");
        for (int j = 0; j < i; j++) {
            System.out.printf(
                    "%s       %s        %s      %s       %s       %s     %s%n",
                    marks[j].getStudentId(), marks[j].getSubjectId(), marks[j].getQuiz(),
                    marks[j].getAssignment(), marks[j].getMidexam(),
                    marks[j].getFinalexam(),
                    marks[j].getTotal());
        }
    }

    void markInserting() throws SQLException, ClassNotFoundException {
        System.out.println("Enter student ID ");
        studentId = input.nextLine();
        System.out.println("Enter subject ID ");
        subjectId = input.nextLine();
        while (true) {
            System.out.println("Enter quiz ");
            String quizs = input.nextLine();
            if (!quizs.matches("[0-9]+")) {
                System.out.println("Invalid mark");
            } else {
                quiz = Integer.parseInt(quizs);
                break;
            }
        }
        while (true) {
            System.out.println("Enter assignment ");
            String assignments = input.nextLine();
            if (!assignments.matches("[0-9]+")) {
                System.out.println("Invalid mark");
            } else {
                assignment = Integer.parseInt(assignments);
                break;
            }
        }
        while (true) {
            System.out.println("Enter mid-exam ");
            String mid_exam = input.nextLine();
            if (!mid_exam.matches("[0-9]+")) {
                System.out.println("Invalid mark");
            } else {
                midexam = Integer.parseInt(mid_exam);
                break;
            }
        }

        while (true) {
            System.out.println("Enter final ");
            String final_exam = input.nextLine();
            if (!final_exam.matches("[0-9]+")) {
                System.out.println("Invalid mark");
            } else {
                finalexam = Integer.parseInt(final_exam);
                break;
            }
        }
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
                while (true) {
                    System.out.println("Please Enter another");
                    studentId = input.nextLine();
                    if (!studentId.matches("[0-9]+")) {
                        System.out.println("Invalid ID");
                    } else {
                        break;
                    }
                }
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

    String marksUpdate(String studentID) throws SQLException, ClassNotFoundException {
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
            info = "assignnment";
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

    }
}