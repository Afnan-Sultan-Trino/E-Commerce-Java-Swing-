package interfaces.entities;

public interface ICustomer {
    public void setContactNo(String contactNo);
    public void setGender(String gender);
    public void setAddress(String address);
    public String getContactNo();
    public String getGender();
    public String getAddress();
    public void addToCart(int id, int q);
    public void removeFromCart(int id);
    public void updateCartProductQuantity(int id, int q);
    public void clearCart();
    public double getCartTotal();
}
