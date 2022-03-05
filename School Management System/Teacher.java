import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Teacher extends User {
    Scanner input = new Scanner(System.in);
    Student student = new Student(null, null, null, null, null, null, null, null);
    Marks marks = new Marks(null, null, 0, 0, 0, 0, 0);
    String subject;

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
      return null;
    }
    void userInserting() throws ClassNotFoundException, SQLException {
        System.out.println("Enter Teacher First Name");
        firstName = input.nextLine();
        System.out.println("Enter Teacher Middle Name");
        middleName = input.nextLine();
        System.out.println("Enter Teacher Last Name");
        lastName = input.nextLine();
        System.out.println("Enter Teacher ID ");
        userId = input.nextLine();
        userId = validityChecker(userId);
        System.out.println("Enter Teacher Gender ");
        gender = input.nextLine();
        System.out.println("Enter Subject of Teacher");
        subject = input.nextLine();
        String queryInsert = "insert into teacher values(?,?,?,?,?,?)";
        DataBaseAccess db = new DataBaseAccess();
        Connection con = db.Connection();
        PreparedStatement insert = con.prepareStatement(queryInsert);
        insert.setString(1, firstName);
        insert.setString(2, middleName);
        insert.setString(3, lastName);
        insert.setString(4, userId);
        insert.setString(5, gender);
        insert.setString(6, subject);
        insert.execute();
        System.out.println("Successfully Added");
    }