
public class Mark {

    String studentId;
    String subjectId;

    int test;
    int midexam;
    int finalexam;
    int total;

    Mark(String studentId, String subjectId, int test, int midexam, int finalexam, int total) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.test = test;
        this.midexam = midexam;
        this.finalexam = finalexam;
        this.total = total;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getFinalexam() {
        return finalexam;
    }

    public void setFinalexam(int finalexam) {
        this.finalexam = finalexam;
    }

    public int getMidexam() {
        return midexam;
    }

    public void setMidexam(int midexam) {
        this.midexam = midexam;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getTotal() {
        return total;
    }
}