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

    public void setSubjectCon(String sql) throws ClassNotFoundException, SQLException {
        Subject[] subject = new Subject[100];
        for (int i = 0; i < subject.length; i++) {
            subject[i] = new Subject(sql, sql, sql, sql);
        }
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        Statement statements = con.createStatement();
        ResultSet resultStore = statements.executeQuery(sql);
        int i = 0;
        while (resultStore.next()) {
            subject[i].setSubject(resultStore.getString(1), resultStore.getString(2),
                    resultStore.getString(3), resultStore.getString(4));
            i++;
        }
        if (i == 0) {
            System.out.println("There is no specified Student yet!");
        } else {
            System.out
                    .println("Subject Name    Subject Code    Teacher ID     Grade Number ");
            for (int j = 0; j < i; j++) {
                System.out.printf(
                        "%s       %s       %s       %s%n",
                        subject[j].getSubjectName(),
                        subject[j].getSubjectCode(),
                        subject[j].getTeacherId(),
                        subject[j].getGradeNumber());
            }
        }
    }
}
