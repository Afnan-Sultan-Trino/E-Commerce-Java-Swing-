package gui.components.customer;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;

import core.entities.Customer;
import core.entities.Product;

public class CartItemPanel extends JPanel {

    private JButton removeButton;
    private JSpinner quantitySpinner;
    private JLabel totalPriceLabel;

    public CartItemPanel(CartFrame cartFrame, Customer customer, Product product, int initialQuantity) {

        // Set layout for the panel
        setLayout(new BorderLayout(15, 15));
        setBackground(Color.decode("#f9f9f9")); // Light gray background for the item

        // Product Image (Increased size)
        JLabel imageLabel = new JLabel(new ImageIcon(
                new ImageIcon(product.getImagePath()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
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
                totalPriceLabel.setText(
                        "Total: $" + String.format("%.2f", product.getPrice() * (int) quantitySpinner.getValue()));
                cartFrame.updatePriceLabels(customer);
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
        ImageIcon deleteIcon = new ImageIcon("../assets/images/otherAssets/rubbishBin.png");
        deleteIcon = new ImageIcon(deleteIcon.getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH));

        removeButton = new JButton("Remove", deleteIcon);
        removeButton.setBackground(Color.decode("#e32f16"));
        removeButton.setForeground(Color.WHITE);
        removeButton.setFocusPainted(false);
        removeButton.setMaximumSize(new Dimension(130, 32)); // Limit size for button
        removeButton.setAlignmentX(Component.RIGHT_ALIGNMENT);

        removeButton.addActionListener(e -> {
            customer.getCart().removeProductFromCart(product);
            cartFrame.updatePriceLabels(customer);
            Container parent = getParent();
            // Have to dispatch the EDT cause otherwise causes unwanted behavior
            SwingUtilities.invokeLater(() -> {
                parent.remove(this);
                parent.revalidate();
                parent.repaint();
            });
        });

        actionPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        actionPanel.add(removeButton);
        add(actionPanel, BorderLayout.EAST);

        // Set border and padding
        setBorder(BorderFactory.createMatteBorder(1, 1, 7, 1, Color.decode("#cccccc")));
        setPreferredSize(new Dimension(700, 180)); // Adjusted size for cart item to accommodate larger image
    }
}
