package gui.temp;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.*;

import core.entities.Customer;
import core.entities.Product;

public class CartItemPanel extends JPanel {
    // private Customer customer;
    // private Product product;
    private JButton removeButton;
    private JSpinner quantitySpinner;
    private JLabel totalPriceLabel;

    public CartItemPanel(Customer customer, Product product, int initialQuantity) {
        // this.customer = customer;
        // this.product = product;

        // Set layout for the panel
        setLayout(new BorderLayout(15, 15));
        setBackground(Color.decode("#f9f9f9")); // Light gray background for the item

        // Product Image (Increased size)
        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon(product.getImagePath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        imageLabel.setPreferredSize(new Dimension(150, 150)); // Increased image size
        add(imageLabel, BorderLayout.WEST);

        // Product Details Panel
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false); // Transparent background

        // Product Name Label
        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Verdana", Font.BOLD, 18)); // Slightly larger font for name
        nameLabel.setForeground(Color.decode("#333333"));
        detailsPanel.add(nameLabel);

        // Product Price Label
        JLabel priceLabel = new JLabel("Price: $" + String.format("%.2f", product.getPrice()));
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        priceLabel.setForeground(Color.decode("#ff6600"));
        detailsPanel.add(priceLabel);

        // Stock Label
        JLabel stockLabel = new JLabel("Stock: " + product.getStock());
        stockLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        stockLabel.setForeground(Color.decode("#555555"));
        detailsPanel.add(stockLabel);

        // Quantity Panel (Label + Spinner)
        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0)); // Align components left with small gap
        quantityPanel.setOpaque(false); // Transparent background for the quantity panel

        JLabel quantityLabel = new JLabel("Quantity: ");
        quantityLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(initialQuantity, 1, product.getStock(), 1));
        quantitySpinner.setPreferredSize(new Dimension(60, 25)); // Set smaller spinner size
        quantitySpinner.setMaximumSize(new Dimension(60, 25)); // Limit max size

        quantitySpinner.addChangeListener(new ChangeListener() {
           public void stateChanged(ChangeEvent e) {
                customer.getCart().updateQuantity(product, (int) quantitySpinner.getValue());
                totalPriceLabel.setText("Total: $" + String.format("%.2f", product.getPrice() * (int) quantitySpinner.getValue()));
            } 
        });

        quantityPanel.add(quantityLabel); // Add the quantity label
        quantityPanel.add(quantitySpinner); // Add the spinner

        detailsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add a small vertical space
        detailsPanel.add(quantityPanel); // Add quantity panel

        add(detailsPanel, BorderLayout.CENTER);

        // Panel for Remove Button and Total Price
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBackground(Color.decode("#f9f9f9"));

        // Total Price Label
        totalPriceLabel = new JLabel("Total: $" + String.format("%.2f", product.getPrice() * initialQuantity));
        totalPriceLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        totalPriceLabel.setAlignmentX(Component.RIGHT_ALIGNMENT); // Align to right
        actionPanel.add(totalPriceLabel);

        // Remove Button
        removeButton = new JButton("Remove");
        removeButton.setBackground(Color.decode("#ff5c5c"));
        removeButton.setForeground(Color.WHITE);
        removeButton.setMaximumSize(new Dimension(100, 25)); // Limit size for button
        removeButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        actionPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        actionPanel.add(removeButton);

        add(actionPanel, BorderLayout.EAST);

        // Set border and padding
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#cccccc")));
        setPreferredSize(new Dimension(700, 180)); // Adjusted size for cart item to accommodate larger image
    }
}