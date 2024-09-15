package controller;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import interfaces.entities.IUserManager;
import core.entities.User;
import core.entities.Admin;
import core.entities.Customer;

public class UserManager implements IUserManager {
    private ArrayList<User> userList;
    private String userDataPath = "/Users/xyrophyte/Data/Code/Java/E-CommerceManagementSystem/database/userData.txt";

    public UserManager() {
        userList = new ArrayList<User>();
        loadUserToMemory();
    }

    private void loadUserToMemory() {

        // Try to create a file if it doesn't exist
        File file = new File(userDataPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(userDataPath));
            String l;
            while ((l = reader.readLine()) != null) {
                String[] parts = l.split(","); // Use StringBuffer / StringBuilder
                if (parts[3].equals("Admin")) {
                    Admin a = new Admin(parts[0], parts[1], parts[2], parts[3]);
                    userList.add(a);
                } else if (parts[3].equals("Customer")) {
                    Customer c = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                    userList.add(c);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check if user already exist
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

    // Check if credentials are valid
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

    // Add user. Method overloading cause of two types of User (this one if for Admin)
    public void addUser(String name, String email, String password, String role) {
        Admin a = new Admin(name, email, password, role);
        userList.add(a);
        dumpUserArrayListToFile();
    }

    // Add user. Method overloading cause of two types of User (this one if for Customer)
    public void addUser(String name, String email, String password, String role, String gender, String contactNo, String address) {
        Customer c = new Customer(name, email, password, role, gender, contactNo, address);
        userList.add(c);
        dumpUserArrayListToFile();
    }

    // Delete user
    public void deleteUser(String email) {
        for (User u : userList) {
            if (u.getEmail().equals(email)) {
                userList.remove(u);
                break;
            }
        }
        dumpUserArrayListToFile();
    }


    // Re-write the entire array list
    // Currently, everytime there's a change in userList, the contents are dumped to the txt file, prefer to do this only before app shutdown
    // For reduced IO operation, however, isn't a big deal for such a small project at the moment. Low priority.
    // TODO: Reduce IO Operations
    private void dumpUserArrayListToFile() {

        try {
            // Do not pass "true" to FileWriter as it'll overwrite the entire file. Passing "true" would just append to the file.
            BufferedWriter writer = new BufferedWriter(new FileWriter(userDataPath));
            for (User u : userList) {
                if (u instanceof Admin) {
                    // Type cast back to original object to run object specific methods
                    Admin a = (Admin) u;
                    String t = a.getName() + "," + a.getEmail() + "," + a.getPassword() + "," + a.getRole();
                    writer.write(t);
                    writer.newLine();
                } else if (u instanceof User) {
                    // Type cast back to original object to run object specific methods
                    Customer c = (Customer) u;
                    String t = c.getName() + "," + c.getEmail() + "," + c.getPassword() + "," + c.getRole() + "," + c.getGender() + "," + c.getContactNo() + "," + c.getAddress();
                    writer.write(t);
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
