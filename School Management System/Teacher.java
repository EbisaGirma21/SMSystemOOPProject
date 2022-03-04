
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