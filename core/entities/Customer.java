package core.entities;

import interfaces.entities.ICustomer;
import controllers.ProductManager;
import controllers.Cart;
import core.entities.Product;

public class Customer extends User implements ICustomer {

    private String gender;
    private String contactNo;
    private String address;
    private Cart userCart;


    public Customer(String name, String email, String password, String role, String gender, String contactNo, String address) {
        super(name, email, password, role);
        this.gender = gender;
        setContactNo(contactNo);
        this.address = address;
        userCart = new Cart();
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

    public void addToCart(int id, int q) {
        ProductManager pm = new ProductManager();
        Product p = pm.searchProduct(id);
        if (p != null) {
            userCart.addProductToCart(p, q);
        }
    }

    public void removeFromCart(int id) {
        ProductManager pm = new ProductManager();
        Product p = pm.searchProduct(id);
        if (p != null) {
            userCart.removeProductFromCart(p);
        }
    }

    public void updateCartProductQuantity(int id, int q) {
        // TODO: Ensure validation on front-end to avoid -ve quantity
        ProductManager pm = new ProductManager();
        Product p = pm.searchProduct(id);
        if (p != null) {
            userCart.updateQuantity(p, q);
        }
    }

    public void clearCart() {
        userCart.clearCart();
    }

    public double getCartTotal() {
        return userCart.getTotal();
    }
}
