public class User {
    private final int userId;
    private final String userName;
    private final String userEmail;
    private final String userPassword;

    public User(int userId, String userName, String userEmail, String userPassword) {
        this.userId = validateUserId(userId);
        this.userName = validateUserName(userName);
        this.userEmail = validateUserEmail(userEmail);
        this.userPassword = validateUserPassword(userPassword);
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

    private static int validateUserId(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("User ID must be greater than zero.");
        }
        return userId;
    }

    private static String validateUserName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty.");
        }
        String trimmed = userName.trim();
        if (!trimmed.matches("[A-Za-z\\s]+")) {
            throw new IllegalArgumentException("User name should contain only letters and spaces.");
        }
        return trimmed;
    }

    private static String validateUserEmail(String userEmail) {
        if (userEmail == null || userEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty.");
        }
        String email = userEmail.trim();
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Please enter a valid email address.");
        }
        return email;
    }

    private static String validateUserPassword(String userPassword) {
        if (userPassword == null || userPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        if (userPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }
        return userPassword;
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
