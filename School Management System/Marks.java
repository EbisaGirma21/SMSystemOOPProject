import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Marks {
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
}