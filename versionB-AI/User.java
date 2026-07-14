public class User {
    private int userId;
    private String userName;
    private String userEmail;
    private String userPassword;

    public User(int userId, String userName, String userEmail, String userPassword) {
        setUserId(userId);
        setUserName(userName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    private void setUserId(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be greater than zero.");
        }
        this.userId = userId;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty.");
        }
        this.userName = userName.trim();
    }

    private void setUserEmail(String userEmail) {
        if (userEmail == null || userEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        if (!userEmail.contains("@") || !userEmail.contains(".")) {
            throw new IllegalArgumentException("Please enter a valid email address.");
        }
        this.userEmail = userEmail.trim();
    }

    private void setUserPassword(String userPassword) {
        if (userPassword == null || userPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        if (userPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
        this.userPassword = userPassword;
    }

    public void login() {
        printAction("logged in");
    }

    public void register() {
        printAction("registered");
    }

    private void printAction(String action) {
        System.out.println("User " + userName + " " + action);
    }
}
