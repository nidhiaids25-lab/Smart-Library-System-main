import Model.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        System.out.println("=== TESTING REGISTER & LOGIN ===\n");

        // 1. Reader Account Register
        userService.register("U101", "Nidhi", "pass123", "READER");

        // 2. Seller Account Register
        userService.register("U102", "Rahul", "seller123", "SELLER");

        System.out.println("\n-----------------------------------\n");

        // 3. Login Attempt (Correct Credentials)
        User loggedInUser = userService.login("U101", "pass123");

        // 4. Check Role Action
        if (loggedInUser != null) {
            if (loggedInUser.getRole().equals("SELLER")) {
                System.out.println("Action: You can ADD, UPDATE, or DELETE books.");
            } else if (loggedInUser.getRole().equals("READER")) {
                System.out.println("Action: You can SEARCH, BORROW, or RESERVE books.");
            }
        }
    }
}
