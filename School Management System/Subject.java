public class Subject {
    String subjectName;
    String subjectCode;
    String teacherId;
    String gradeNumber;

    Subject(String subjectName, String subjectCode, String teacherId, String gradeNumber) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.teacherId = teacherId;
        this.gradeNumber = gradeNumber;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getGradeNumber() {
        return gradeNumber;
    }
}