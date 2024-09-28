package core.entities;

import interfaces.entities.ICustomer;

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

    // TODO: Ensure validation on front-end to avoid multiple genders.
    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid Gender.");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // TODO: Ensure validation on front-end to notify user for invalid contact
    public void setContactNo(String contactNo) {
        if (contactNo.length() >= 10 && (contactNo.startsWith("0") || contactNo.startsWith("+880"))) {
            this.contactNo = contactNo;
        } else {
            throw new IllegalArgumentException("Invalid Contact Number.");
        }
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

    // public void addToCart(int id, int q) {
    //     if (id > 0 && q > 0) {
    //         ProductManager pm = new ProductManager();
    //         Product p = pm.searchProduct(id);
    //         if (p != null) {
    //             userCart.addProductToCart(p, q);
    //         } else {
    //             throw new NoSuchElementException("Couldn't find product with ID: " + id);
    //         }
    //     } else {
    //         throw new IllegalArgumentException("Invalid Product ID or Quantity.");
    //     }
    // }

    // public void removeFromCart(int id) {
    //     if (id > 0) {
    //         ProductManager pm = new ProductManager();
    //         Product p = pm.searchProduct(id);
    //         if (p != null) {
    //             userCart.removeProductFromCart(p);
    //         } else {
    //             throw new NoSuchElementException("Couldn't find product with ID: " + id);
    //         }
    //     } else {
    //         throw new IllegalArgumentException("Invalid Product ID.");
    //     }
    // }

    // // TODO: Ensure validation on front-end to notify user avoid -ve quantity
    // public void updateCartProductQuantity(int id, int q) {
    //     if (id > 0 && q > 0) {
    //         ProductManager pm = new ProductManager();
    //         Product p = pm.searchProduct(id);
    //         if (p != null) {
    //             userCart.updateQuantity(p, q);
    //         } else {
    //             throw new NoSuchElementException("Couldn't find product with ID: " + id);
    //         }
    //     } else {
    //         throw new IllegalArgumentException("Invalid Product ID or Quantity.");
    //     }
    // }

    // public void clearCart() {
    //     userCart.clearCart();
    // }

    // public double getCartTotal() {
    //     return userCart.getTotal();
    // }

    public Cart getCart() {
        return userCart;
    }
}
