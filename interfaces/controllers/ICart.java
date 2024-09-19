package interfaces.controllers;

import core.entities.Product;

public interface ICart {
    public void addProductToCart(Product p, int q);
    public void removeProductFromCart(Product p);
    public void updateQuantity(Product p, int q);
    public double getTotal();
    public void clearCart();
}
