package core.entities;

import interfaces.entities.IProduct;

public class Product implements IProduct {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String category;
    private String desc;
    private String imagePath = "../assets/images/productAssets/deafultProductIcon.jpg"; // Default image


    // Call this constructor if image path is not provided (will use default image)
    public Product(int id, String name, double price, int stock, String category, String desc) {
        setID(id); // TODO: Ensure validation on front-end to avoid -ve id
        setName(name);
        setPrice(price); // TODO: Ensure validation on front-end to avoid -ve price
        setStock(stock); // TODO: Ensure validation on front-end to avoid -ve stock
        setCategory(category);
        setDescription(desc);
    }

    // Call this constructor if image path is provided
    public Product(int id, String name, double price, int stock, String category, String desc, String imagePath){
        setID(id); // TODO: Ensure validation on front-end to avoid -ve id
        setName(name);
        setPrice(price); // TODO: Ensure validation on front-end to avoid -ve price
        setStock(stock); // TODO: Ensure validation on front-end to avoid -ve stock
        setCategory(category);
        setDescription(desc);
        setImagePath(imagePath);
    }

    private void setID(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    // TODO: Ensure validation on front-end to avoid -ve price
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Invalid Price.");
        }
    }

    // TODO: Ensure validation on front-end to avoid -ve stock
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("Invalid Stock.");
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    // If image path is provided
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // If image path isn't provided
    public void setImagePath() {
        this.imagePath = "../assets/images/productAssets/deafultProductIcon.jpg";
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
