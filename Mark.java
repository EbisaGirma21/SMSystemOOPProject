public class Mark {
    String studentId;
    String subjectId;
    int quiz;
    int assignment;
    int midexam;
    int finalexam;
    int total;

    Mark(String studentId, String subjectId, int quiz, int assignment, int midexam, int finalexam, int total) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.quiz = quiz;
        this.assignment = assignment;
        this.midexam = midexam;
        this.finalexam = finalexam;
        this.total = total;
    }

    public Mark(Object object, Object object2, String sql, String sql2, String sql3, String sql4, String sql5,
            String sql6) {
    }

    void setMark(String studentId, String subjectId, int quiz, int assignment, int midexam, int finalexam, int total) {
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
}
