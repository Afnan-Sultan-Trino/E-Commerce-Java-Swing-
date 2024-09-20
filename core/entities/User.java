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
        this.name = name;
    }

    // TODO: Validate email address in front-end
    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid Email Address.");
        }
    }

    // TODO: Validate password in front-end
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }

    // TODO: Validate role in front-end
    public void setRole(String role) {
        if (role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("Customer")) {
            this.role = role;
        } else {
            throw new IllegalArgumentException("Invalid Role.");
        }
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
