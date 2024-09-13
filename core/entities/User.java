package core.entities;

import interfaces.entities.IUser;

public abstract class User implements IUser{
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String name, String email, String password, String role) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
