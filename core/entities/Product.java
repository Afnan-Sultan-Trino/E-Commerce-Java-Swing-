package core.entities;

import interfaces.entities.IProduct;

public class Product implements IProduct {
    private int id; // TODO: Ensure validation on front-end to avoid -ve id
    private String name;
    private double price;
    private int stock;
    private String category;
    private String desc;
    private String imagePath = "../assets/images/productAssets/deafultProductIcon.jpg"; // Default image


    // Call this constructor if image path is not provided (will use default image)
    public Product(int id, String name, double price, int stock, String category, String desc) {
        this.id = id;
        setName(name);
        setPrice(price); // TODO: Ensure validation on front-end to avoid -ve price
        setStock(stock); // TODO: Ensure validation on front-end to avoid -ve stock
        this.category = category;
        setDescription(desc);
    }

    // Call this constructor if image path is provided
    public Product(int id, String name, double price, int stock, String category, String desc, String imagePath){
        this.id = id; // TODO: Ensure validation on front-end to avoid -ve id
        setName(name);
        setPrice(price); // TODO: Ensure validation on front-end to avoid -ve price
        setStock(stock); // TODO: Ensure validation on front-end to avoid -ve stock
        this.category = category;
        setDescription(desc);
        setImagePath(imagePath);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return desc;
    }

    public String getImagePath() {
        return imagePath;
    }
    
}
