import java.rmi.server.ServerCloneException;
import java.sql.SQLException;

public class Teacher extends User {
    Teacher(String firstName, String middleName, String lastName, String userId, String gender, String subject) {
        super(firstName, middleName, lastName, userId, gender);
        this.subject = subject;
    }

    void setTeacher(String firstName, String middleName, String lastName, String userId, String gender,
            String subject) {
        super.firstName = firstName;
        super.middleName = middleName;
        super.lastName = lastName;
        super.userId = userId;
        super.gender = gender;
        this.subject = subject;

    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
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
