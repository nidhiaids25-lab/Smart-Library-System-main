package dao;

import Model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Khaali list se shuru karenge
    private static List<User> userList = new ArrayList<>();

    // 1. REGISTER USER
    public boolean registerUser(User user) {
        for (User u : userList) {
            if (u.getUserId().equalsIgnoreCase(user.getUserId())) {
                return false; // Duplicate found
            }
        }
        userList.add(user);
        return true;
    }

    // 2. LOGIN USER
    public User loginUser(String userId, String password) {
        for (User u : userList) {
            if (u.getUserId().equals(userId) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}