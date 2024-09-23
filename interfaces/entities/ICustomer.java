package interfaces.entities;

import controllers.Cart;

public interface ICustomer {
    public void setContactNo(String contactNo);
    public void setGender(String gender);
    public void setAddress(String address);
    public String getContactNo();
    public String getGender();
    public String getAddress();
    public Cart getCart();
}
