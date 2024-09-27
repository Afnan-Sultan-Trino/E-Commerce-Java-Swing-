package gui.components.customer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

import core.entities.Customer;
import core.entities.Product;

public class CartFrame extends JFrame {
    private JLabel subTotalLabel, taxLabel, totalLabel;

    public CartFrame(Customer customer) {

        setTitle("Cart");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // North Panel (Header)
        JPanel northPanel = new JPanel();
        JLabel cartLabel = new JLabel("Your Cart");
        northPanel.setBackground(Color.decode("#c9f32a"));
        cartLabel.setFont(new Font("Arial", Font.BOLD, 24));
        northPanel.add(cartLabel);
        add(northPanel, BorderLayout.NORTH);

        // Center Panel for Cart Items (with scroll functionality)
        JPanel cartItemsPanel = new JPanel();
        cartItemsPanel.setLayout(new BoxLayout(cartItemsPanel, BoxLayout.Y_AXIS));
        cartItemsPanel.setBackground(Color.decode("#f9f9f9"));

        // ScrollPane to wrap cart items
        JScrollPane scrollPane = new JScrollPane(cartItemsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // Right Panel (Subtotal, Tax, and Total)
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(200, 600));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Subtotal, Tax, and Total Labels
        subTotalLabel = new JLabel();
        subTotalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        taxLabel = new JLabel();
        taxLabel.setFont(new Font("Arial", Font.BOLD, 16));

        totalLabel = new JLabel();
        totalLabel.setFont(new Font("Arial", Font.BOLD, 19));
        totalLabel.setForeground(Color.decode("#ff6600"));

        updatePriceLables(customer);

        rightPanel.add(subTotalLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        rightPanel.add(taxLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        rightPanel.add(totalLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Checkout Buttons
        JButton checkoutButton = new JButton("Proceed to Checkout");
        checkoutButton.setBackground(Color.decode("#ff881e"));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFocusPainted(false);
        checkoutButton.addActionListener(e -> {
            if (customer.getCart().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty!", "Empty Cart", JOptionPane.ERROR_MESSAGE);
            } else {
                new PaymentFrame(customer);
            }
        });

        JButton clearCartButton = new JButton("Clear Cart");
        clearCartButton.setBackground(Color.decode("#e32f16"));
        clearCartButton.setForeground(Color.WHITE);
        clearCartButton.setFocusPainted(false);
        clearCartButton.addActionListener(e -> {
            customer.getCart().clearCart();
            updatePriceLables(customer);
            cartItemsPanel.removeAll();
            cartItemsPanel.revalidate();
            cartItemsPanel.repaint();
        });

        JButton shopMoreButton = new JButton("Shop More");
        shopMoreButton.setBackground(Color.decode("#234d32"));
        shopMoreButton.setForeground(Color.WHITE);
        shopMoreButton.setFocusPainted(false);
        shopMoreButton.addActionListener(e -> dispose());

        rightPanel.add(checkoutButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        rightPanel.add(clearCartButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        rightPanel.add(shopMoreButton);
        add(rightPanel, BorderLayout.EAST);

        HashMap<Product, Integer> userCart = new HashMap<Product, Integer>(customer.getCart().getCartHashMap());
        for (Product p : userCart.keySet()) {
            cartItemsPanel.add(new CartItemPanel(this, customer, p, userCart.get(p)));
        }

        setVisible(true);
    }

    void updatePriceLables(Customer customer) {
        double subTotal = customer.getCart().getTotal();
        double tax = subTotal * 0.13; // 13% tax
        double total = subTotal + tax;

        subTotalLabel.setText("Subtotal: $" + String.format("%.2f", subTotal));
        taxLabel.setText("Tax (13%): $" + String.format("%.2f", tax));
        totalLabel.setText("Total: $" + String.format("%.2f", total));
    }
}
