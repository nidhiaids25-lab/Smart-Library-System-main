package service;

import dao.UserDAO;
import Model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    // Account Register
    public void register(String userId, String name, String password, String role) {
        // Role check
        if (!role.equalsIgnoreCase("READER") && !role.equalsIgnoreCase("SELLER")) {
            System.out.println("❌ Invalid Role! Choose either READER or SELLER.");
            return;
        }

        User newUser = new User(userId, name, password, role.toUpperCase());
        boolean isSuccess = userDAO.registerUser(newUser);

        if (isSuccess) {
            System.out.println("✅ Registration Successful as " + role.toUpperCase() + "!");
        } else {
            System.out.println("❌ Registration Failed. User ID might already exist.");
        }
    }

    // Account Login
    public User login(String userId, String password) {
        User user = userDAO.loginUser(userId, password);
        if (user != null) {
            System.out.println("✅ Login Successful! Welcome " + user.getName() + " (" + user.getRole() + ")");
        } else {
            System.out.println("❌ Login Failed! Invalid User ID or Password.");
        }
        return user;
    }
}