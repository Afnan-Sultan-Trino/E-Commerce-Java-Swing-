package interfaces.controllers;

import java.util.ArrayList;

import core.entities.Product;

public interface IProductManager {
    public boolean productExists(int id);

    public void addProduct(int id, String name, double price, int stock, String category, String desc);

    public void addProduct(int id, String name, double price, int stock, String category, String desc, String imagePath);
    
    public void editProduct(int id, String name, double price, int stock, String category, String desc);

    public void editProduct(int id, String name, double price, int stock, String category, String desc, String imagePath);

    public void deleteProduct(int id);

    public Product searchProduct(int id);

    public ArrayList<Product> getAllProducts();

    public String[] getAllCategories();

    public String[][] getDataForTable();

    public void deductStock(int id, int quantity);
}
