package core.entities;

import java.util.HashMap;

import interfaces.entities.ICart;

public class Cart implements ICart {
    private HashMap<Product, Integer> userCart;

    public Cart() {
        userCart = new HashMap<Product, Integer>();
    }

    // TODO: Validate quantity in front-end
    public void addProductToCart(Product p, int q) {
        if (q > 0) {
            if (!userCart.containsKey(p)) {
                userCart.put(p, q);
            } else {
                // If user clicks on item multiple times, add the quantity.
                userCart.put(p, userCart.get(p) + q);
            }
        } else {
            throw new IllegalArgumentException("Invalid Quantity.");
        }
    }

    public void removeProductFromCart(Product p) {
        userCart.remove(p);
    }

    // TODO: Validate quantity in front-end
    public void updateQuantity(Product p, int q) {
        if (q > 0) {
            userCart.put(p, q);
        } else if (q == 0) {
            removeProductFromCart(p);
        } else {
            throw new IllegalArgumentException("Invalid Quantity.");
        }
    }

    // Use this method for validating if product quantity in cart is greater than stock
    public int getProductQuantityInCart(Product p) {
        // In case the product is not in the cart, return 0
        return userCart.getOrDefault(p, 0);
    }

    public HashMap<Product, Integer> getCartHashMap() {
        return new HashMap<Product, Integer>(userCart);
    }

    public boolean isEmpty() {
        return userCart.isEmpty();
    }

    public double getTotal() {
        double total = 0;
        for (Product p : userCart.keySet()) {
            total += p.getPrice() * userCart.get(p);
        }
        return total;
    }

    public void clearCart() {
        userCart.clear();
    }
}
