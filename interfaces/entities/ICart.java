package interfaces.entities;

import java.util.HashMap;

import core.entities.Product;

public interface ICart {
    public void addProductToCart(Product p, int q);

    public void removeProductFromCart(Product p);

    public void updateQuantity(Product p, int q);

    public int getProductQuantityInCart(Product p);

    public HashMap<Product, Integer> getCartHashMap();

    public boolean isEmpty();

    public double getTotal();

    public void clearCart();
}
