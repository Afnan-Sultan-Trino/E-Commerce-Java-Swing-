package interfaces.entities;

public interface IProduct {
    public int getID();

    public String getName();

    public double getPrice();

    public int getStock();

    public String getCategory();

    public String getDescription();

    public String getImagePath();

    public void setName(String name);

    public void setPrice(double price);

    public void setStock(int stock);

    public void setCategory(String category);

    public void setDescription(String desc);

    public void setImagePath(String imagePath);

    public void setImagePath();
}
