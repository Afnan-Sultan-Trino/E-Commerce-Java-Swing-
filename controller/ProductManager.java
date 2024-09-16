package controller;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import core.entities.Product;


public class ProductManager {
    private ArrayList<Product> productList;

    public ProductManager() {
        productList = new ArrayList<Product>();
        loadProductToMemory();
    }

    private void loadProductToMemory() {
        // Try to create file if it doesn't exist
        File file = new File("../database/productData.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Read from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../database/productData.txt"));
            String l;
            while ((l = reader.readLine()) != null) {
                String[] parts = l.split(",");
                if (parts.length == 5) { // TODO: This statement becomes obsolete if we add a default image path to the Product constructor
                    Product p = new Product(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                    productList.add(p);
                } else if (parts.length == 6) {
                    Product p = new Product(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), parts[4], parts[5]);
                    productList.add(p);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    // Copying entire array list to text file
    private void dumpDataToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("../database/productData.txt"));
            for (Product p : productList) {
                String t = p.getID() + "," + p.getName() + "," + p.getPrice() + "," + p.getStock() + "," + p.getDescription() + "," + p.getImagePath();
                writer.write(t);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
