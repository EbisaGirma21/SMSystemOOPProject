import java.rmi.server.ServerCloneException;
import java.sql.SQLException;

public class Student extends User {
    String age;
    String year;
    String gradeNumber;
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
