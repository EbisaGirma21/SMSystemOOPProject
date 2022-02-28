public abstract class User {
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

}
