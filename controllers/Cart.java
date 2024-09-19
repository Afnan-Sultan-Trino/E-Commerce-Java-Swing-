package controllers;

import java.util.HashMap;

import interfaces.controllers.ICart;
import core.entities.Product;

public class Cart implements ICart {
    private HashMap<Product, Integer> userCart;

    public Cart() {
        userCart = new HashMap<Product, Integer>();
    }

    public void addProductToCart(Product p, int q) {
        if (!userCart.containsKey(p)) {
            userCart.put(p, q);
        } else {
            // If user clicks on item multiple times, add the quantity.
            userCart.put(p, userCart.get(p) + q);
        }
    }

    public void removeProductFromCart(Product p) {
        userCart.remove(p);
    }

    public void updateQuantity(Product p, int q) {
        userCart.put(p, q);
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
