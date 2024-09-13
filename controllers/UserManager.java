package controllers;

import java.util.ArrayList;

import core.entities.User;

public class UserManager {
    private ArrayList<User> userList;

    public UserManager() {
        userList = new ArrayList<User>();
        loadUserToMemory();
    }

    private void loadUserToMemory() {
        // Load all the user from database to userList.
    }

    public boolean userExists(String email) {
        // Separate "size" var to prevent computation of size every iteration.
        int size = userList.size();
        for (int i = 0; i < size; i++) {
            // Return "true" if user exist.
            if (userList.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        
        // If no user exists, it'll exit the for loop and return "false".
        return false;
    }

}
