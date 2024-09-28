package core.entities;

import java.util.regex.Pattern;

import interfaces.entities.IUser;

public abstract class User implements IUser {
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
    private void setEmail(String email) {
        if (validEmail(email)) {
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
        if (role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("Customer")
                || role.equalsIgnoreCase("SuperAdmin")) {
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

    private boolean validEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern p = Pattern.compile(emailRegex);
        return p.matcher(email).matches();
    }

}
