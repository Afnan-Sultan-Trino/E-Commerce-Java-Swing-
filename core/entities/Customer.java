package core.entities;

import interfaces.entities.ICustomer;

public class Customer extends User implements ICustomer {

    private String gender;
    private String contactNo;
    private String address;

    public Customer(String name, String email, String password, String role, String gender, String contactNo, String address) {
        super(name, email, password, role);
        this.gender = gender;
        setContactNo(contactNo);
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;  // TODO: Ensure validation on front-end to avoid multiple genders.
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNo(String contactNo) {
        // TODO:  Do Number Validation
        this.contactNo = contactNo;
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
