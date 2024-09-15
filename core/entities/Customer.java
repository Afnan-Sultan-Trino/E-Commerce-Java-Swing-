package core.entities;

public class Customer extends User {

    private String gender;
    private String contactNo;
    private String address;

    public Customer(String name, String email, String password, String role, String gender, String contactNo, String address) {
        super(name, email, password, role);
        this.gender = gender;
        setContactNo(contactNo);
        this.address = address;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
        // Do Number Validation
    }

    public String getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getAddress() {
        return address;
    }
}
