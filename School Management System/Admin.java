import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Admin extends User {
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