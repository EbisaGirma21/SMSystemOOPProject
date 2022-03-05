import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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

    Scanner input = new Scanner(System.in);

    void checkValidity() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Your User Name");
        String adminUserName = input.nextLine();
        System.out.println("Enter your Password");
        String adminPassword = input.nextLine();
        System.out.println("Loading...");
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        Statement statements = con.createStatement();
        String sql = "select userName , Password from admin";
        ResultSet resultStore = statements.executeQuery(sql);
        while (resultStore.next()) {
            setUserName(resultStore.getString(1));
            setPassword(resultStore.getString(2));
        }
        if (adminUserName.equals(getUserName()) && adminPassword.equals(getPassword())) {
            this.validity = 1;
        } else {
            this.validity = 0;
        }
    }
}