import java.rmi.server.ServerCloneException;
import java.sql.SQLException;
import java.util.Scanner;

public abstract class User {
    Scanner input = new Scanner(System.in);
    String firstName;
    String middleName;
    String lastName;
    String userId;
    String gender;

    User(String firstName, String middleName, String lastName, String userId, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userId = userId;
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getGender() {
        return gender;
    }

    abstract void setUserCon(String query) throws ClassNotFoundException, ServerCloneException;

    abstract String userUpdate(String userId) throws ClassNotFoundException, SQLException;

    abstract void userInserting() throws SQLException, ClassNotFoundException;

    void deleteUser(String sql, String userID) throws ClassNotFoundException, SQLException {

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
}
