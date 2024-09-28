package gui.components.customer;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import core.entities.Customer;
import core.entities.Product;

public class ProductPanel extends JPanel implements ActionListener {
    private Customer customer;
    private Product product;
    private JLabel stockLabel;
    private JButton addToCartButton;
    private JSpinner quantitySpinner; // Quantity selector

    public ProductPanel(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        
        // Set layout and lighter background color
        setLayout(new BorderLayout(15, 15));
        setBackground(Color.decode("#ffffff")); // Lighter  background for the product panel

        // Create and configure the product image (larger size)
        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(160, 190, Image.SCALE_SMOOTH)));
        imageLabel.setPreferredSize(new Dimension(150, 150));
        add(imageLabel, BorderLayout.WEST); // Align image to the left

        // Create a panel for product details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false); // Set to transparent to show background

        // Product name label
        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Verdana", Font.BOLD, 17));
        nameLabel.setForeground(Color.decode("#070907")); // darker  text for better visibility
        detailsPanel.add(nameLabel);

        // Product ID label
        JLabel idLabel = new JLabel("Product ID: " + product.getID());
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        idLabel.setForeground(Color.decode("#817f85")); // Lighter gray text
        detailsPanel.add(idLabel);

        // Product price label
        JLabel priceLabel = new JLabel("Price: $" + product.getPrice());
        priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        priceLabel.setForeground(Color.decode("#FC7F16")); // Orange text
        detailsPanel.add(priceLabel);

        stockLabel = new JLabel();
        // Product stock label
        if (product.getStock() == 0) {
            stockLabel.setText("OUT OF STOCK");
            stockLabel.setForeground(Color.RED);
        } else {
            stockLabel.setText("Stock: " + product.getStock());
        }
        
        stockLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        stockLabel.setForeground(Color.decode("#1b1b1c")); // Lighter dark text
        detailsPanel.add(stockLabel);

        // Product description label
        JLabel descriptionLabel = new JLabel("Description: " + product.getDescription());
        descriptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        descriptionLabel.setForeground(Color.decode("#3c3c3b")); // Lighter gray text
        detailsPanel.add(descriptionLabel);

        // Add the details panel to the center of the ProductPanel
        add(detailsPanel, BorderLayout.CENTER);

        // Create the panel for quantity and button
        JPanel cartPanel = new JPanel();
        cartPanel.setOpaque(false); // Set to transparent
        cartPanel.setLayout(new BorderLayout(5, 5));

        // Create a spinner for quantity selection
        SpinnerNumberModel spinnerModel;
        if (product.getStock() > 0) {
            spinnerModel = new SpinnerNumberModel(1, 1, product.getStock(), 1);
        } else {
            spinnerModel = new SpinnerNumberModel(0, 0, 0, 0);
        }

        quantitySpinner = new JSpinner(spinnerModel);
        quantitySpinner.setPreferredSize(new Dimension(50, 30));
        cartPanel.add(quantitySpinner, BorderLayout.WEST); // Add spinner on the left side

        // Create the "Add to Cart" button
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setFocusPainted(false);  // Remove focus outline
        addToCartButton.setFont(new Font("Verdana", Font.BOLD, 14));
        addToCartButton.setBackground(Color.decode("#ccff04")); // Lighter green background
        addToCartButton.setForeground(Color.BLACK); // Black text color
        addToCartButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));  // Add padding inside button
        addToCartButton.addActionListener(this);
        cartPanel.add(addToCartButton, BorderLayout.EAST); // Add the button on the right side

        // Add the cart panel (spinner + button) to the bottom of the ProductPanel
        add(cartPanel, BorderLayout.SOUTH);

        // Set border for the entire ProductPanel
        Border panelBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#E57172")); // Lighter red border
        setBorder(panelBorder);

        // Increase overall height of the ProductPanel
        setPreferredSize(new Dimension(380, 250)); // Adjusted height for larger image and more details
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            // Get current & selected selected quantity
            int currentQuantity = customer.getCart().getProductQuantityInCart(product);
            int selectedQuantity = (int) quantitySpinner.getValue();

            // If the selected quantity is 0, show an error message
            if (selectedQuantity == 0) {
                JOptionPane.showMessageDialog(null, "Please select a quantity greater than 0.", "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if the selected quantity is within the stock limit
            if ((currentQuantity + selectedQuantity) <= product.getStock()) {
                customer.getCart().addProductToCart(product, selectedQuantity);
                // Update the spinner model to reflect the remaining stock
                int remainingStock = product.getStock() - customer.getCart().getProductQuantityInCart(product);
                if (remainingStock > 0) {
                    SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, remainingStock, 1);
                    quantitySpinner.setModel(spinnerModel);
                } else {
                    quantitySpinner.setEnabled(false);
                    addToCartButton.setEnabled(false);
                    stockLabel.setText("OUT OF STOCK");
                    stockLabel.setForeground(Color.RED);
                }
                
                JOptionPane.showMessageDialog(null, "Product added to cart: " + product.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Maximum quantity you can buy is: " + product.getStock(), "No More in Stock", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

/*
    // Getter method to retrieve the product information
    public Product getProduct() {
        return product;
    }

    // Method to get the Add to Cart button
    public JButton getAddToCartButton() {
        return addToCartButton;
    }

    // Method to get the selected quantity
    public int getSelectedQuantity() {
        return (int) quantitySpinner.getValue();
    }
*/
}
