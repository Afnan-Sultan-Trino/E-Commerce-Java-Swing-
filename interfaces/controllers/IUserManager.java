package interfaces.controllers;

import core.entities.User;

public interface IUserManager {
    public boolean userExists(String email);
    public boolean validCredentials(String email, String password);
    public void addUser(String name, String email, String password, String role);
    public void addUser(String name, String email, String password, String role, String gender, String contactNo, String address);
    public void deleteUser(String email);
    public User searchUser(String email);
    public String getUserRole(String email);
}