package interfaces.entities;

public interface IUser {
    public void setName(String name);

    public void setPassword(String password);

    public void setRole(String role);

    public String getName();

    public String getEmail();

    public String getPassword();

    public String getRole();
}
