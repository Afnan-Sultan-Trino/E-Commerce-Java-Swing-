package controller;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import interfaces.entities.IUserManager;
import core.entities.User;
import core.entities.Admin;
import core.entities.Customer;

public class UserManager implements IUserManager {
    private ArrayList<User> userList;
    // private String userDataPath = "/Users/xyrophyte/Data/Code/Java/E-CommerceManagementSystem/database/userData.txt";

    public UserManager() {
        userList = new ArrayList<User>();
        loadUserToMemory();
    }

    private void loadUserToMemory() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/xyrophyte/Data/Code/Java/E-CommerceManagementSystem/database/userData.txt"));
            String l;
            while ((l = reader.readLine()) != null) {
                String[] parts = l.split(",");
                if (parts[3].equals("Admin")) {
                    Admin a = new Admin(parts[0], parts[1], parts[2], parts[3]);
                    userList.add(a);
                } else if (parts[3].equals("Customer")) {
                    Customer c = new Customer(parts[0], parts[1], parts[2], parts[3]);
                    userList.add(c);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String email) {
        for (User u : userList) {
            // Return "true" if user exist.
            if (u.getEmail().equals(email)) {
                return true;
            }
        } 
        // If no user exists, it'll exit the for loop and return "false".
        return false;
    }

    public boolean validCredentials(String email, String password) {
        for (User u : userList) {
            // Return "true" if valid credentials.
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        // Return "false" if invalid credentials.
        return false;
    }

}
