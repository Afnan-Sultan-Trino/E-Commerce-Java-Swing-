package interfaces.entities;

public interface IUserManager {
    public boolean userExists(String email);
    public boolean validCredentials(String email, String password);
}
