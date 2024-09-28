package gui.components.customer;

import javax.swing.*;
import java.awt.*;

import core.entities.Customer;

public class PaymentFrame extends JFrame {

    private JTextField newAddressField;

    public PaymentFrame(Customer customer, CartFrame cartFrame) {

        // Set the frame properties
        setTitle("Payment");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);  // Use absolute layout (null layout)

        // Create a header
        JLabel header = new JLabel("Payment", JLabel.CENTER);
        header.setFont(new Font("Verdana", Font.BOLD, 25));
        header.setBounds(300, 20, 300, 30);  // Manually set position and size

        // Payment Details label
        JLabel paymentDetailsLabel = new JLabel("Payment Details");
        paymentDetailsLabel.setFont(new Font("Verdana", Font.BOLD, 21));
        paymentDetailsLabel.setForeground(Color.decode("#ff6600"));
        paymentDetailsLabel.setBounds(50, 80, 200, 30);

        // Card number input with placeholder and card icon
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 130, 150, 30);
        cardNumberLabel.setFont(new Font("Verdana", Font.PLAIN, 18));

        JLabel payIcon = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/creditCard.png"));
        payIcon.setBounds(490, 18, 80, 40);


        JTextField cardNumberField = new JTextField( 20);
        cardNumberField.setToolTipText("Enter your 16-digit card number without spaces or dashes");
        cardNumberField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        cardNumberField.setBounds(210, 130, 545, 30);  // Adjusted width and height

        
        JLabel cardIcon = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/VISA.png"));
        cardIcon.setBounds(200, 170, 90, 40);

        JLabel cardIcon2 = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/MasterCard.png"));
        cardIcon2.setBounds(270, 170, 90, 40);
        
        JLabel cardIcon3 = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/AMEX.png"));
        cardIcon3.setBounds(340, 170, 100, 40);
        
        JLabel cardIcon4 = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/PayPal.png"));
        cardIcon4.setBounds(420, 170, 90, 40);
        
        // Expiry date and security code side-by-side
        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateLabel.setBounds(50, 220, 130, 30);
        expiryDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        JTextField expiryDateField = new JTextField( 5);
        expiryDateField.setToolTipText("Enter the expiry date in MM/YY format");
        expiryDateField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        expiryDateField.setBounds(210, 220, 160, 40);  // Set position and size


        JLabel securityIcon = new JLabel(new ImageIcon("../../../assets/images/paymentAssets/CCV.png"));
        securityIcon.setBounds(690,225,80,30);


        JLabel securityCodeLabel = new JLabel("Security Code:");
        securityCodeLabel.setBounds(440, 220, 140, 30);
        securityCodeLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        JTextField securityCodeField = new JTextField( 3);
        securityCodeField.setToolTipText("3-digit code on the back of your card");
        securityCodeField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        securityCodeField.setBounds(600, 220, 155, 40);  // Set position and size

        // Name on card - Adjust size
        JLabel nameOnCardLabel = new JLabel("Name on Card:");
        nameOnCardLabel.setBounds(50, 270, 140, 30);
        nameOnCardLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        JTextField nameOnCardField = new JTextField();
        nameOnCardField.setToolTipText("Enter the exact name appears on card");
        nameOnCardField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        nameOnCardField.setBounds(210, 270, 545, 40);  // Set position and size

        // Billing address and checkbox
        JLabel billingAddressLabel = new JLabel("Billing Address:");
        billingAddressLabel.setBounds(50, 330, 200, 30);
        billingAddressLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        JCheckBox sameAsDelivery = new JCheckBox("Same as my delivery address");
        sameAsDelivery.setBounds(50, 370, 350, 30);
        sameAsDelivery.setFont(new Font("Verdana", Font.PLAIN, 18));
        sameAsDelivery.addActionListener(e -> {
            if (sameAsDelivery.isSelected()) {
                newAddressField.setText(customer.getAddress());
                newAddressField.setEditable(false);
            } else if (!sameAsDelivery.isSelected()) {
                newAddressField.setText("");
                newAddressField.setEditable(true);
            }
        });

        // Billing Address Information
        JLabel billingInfoLabel = new JLabel();
        billingInfoLabel.setBounds(50, 430, 350, 30);
        billingInfoLabel.setForeground(Color.decode("#ff6600"));
        billingInfoLabel.setFont(new Font("Verdana", Font.BOLD, 21));
        newAddressField = new JTextField("Enter new address");
        newAddressField.setFont(new Font("Verdana", Font.PLAIN, 17));
        newAddressField.setBounds(50, 490, 702, 40);  // Set position and size
        

        JLabel totalLabel = new JLabel("Total Cost:");
        totalLabel.setFont(new Font("Verdana", Font.BOLD, 21));
        totalLabel.setForeground(Color.decode("#000000"));
        totalLabel.setBounds(50, 550, 400, 30);

        JLabel amountLabel = new JLabel("$" + String.format("%.2f", customer.getCart().getTotal() * 1.13));
        amountLabel.setFont(new Font("Verdana", Font.BOLD, 21));
        amountLabel.setForeground(Color.decode("#ff221e"));
        amountLabel.setBounds(600, 550, 200, 30);


        // Two buttons: Pay Now and Clear
        JButton payNowButton = new JButton("Pay Now");
        payNowButton.setBounds(250, 640, 445, 40);  // Set position and size
        payNowButton.setBackground(Color.decode("#000000"));
        payNowButton.setForeground(Color.WHITE);
        payNowButton.setFont(new Font("Verdana", Font.BOLD, 17));
        payNowButton.addActionListener(e -> {
            // Validate the input fields
            if (cardNumberField.getText().length() != 16) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 16-digit card number", "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
            } else if (expiryDateField.getText().length() != 5) {
                JOptionPane.showMessageDialog(null, "Please enter a valid expiry date in MM/YY format", "Invalid Expiry Date", JOptionPane.ERROR_MESSAGE);
            } else if (securityCodeField.getText().length() != 3) {
                JOptionPane.showMessageDialog(null, "Please enter a valid 3-digit security code", "Invalid Security Code", JOptionPane.ERROR_MESSAGE);
            } else if (nameOnCardField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the name on the card", "Invalid Name", JOptionPane.ERROR_MESSAGE);
            } else if (newAddressField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the billing address", "Invalid Address", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Payment successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                cartFrame.paymentSuccessful();
                cartFrame.dispose();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 690, 445, 40);  // Set position and size
        clearButton.setBackground(Color.decode("#e32f16"));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 17));
        clearButton.addActionListener(e -> {
            cardNumberField.setText("");
            expiryDateField.setText("");
            securityCodeField.setText("");
            nameOnCardField.setText("");
            if (sameAsDelivery.isSelected()) {
                newAddressField.setText(customer.getAddress());
            } else {
                newAddressField.setText("");
            }
        });

        // Add components to the frame
        add(header);
        add(paymentDetailsLabel);
        add(cardNumberLabel);
        add(cardNumberField);
        add(payIcon);
        add(cardIcon);
        add(cardIcon2);
        add(cardIcon3);
        add(cardIcon4);
        add(securityIcon);
        add(expiryDateLabel);
        add(expiryDateField);
        add(securityCodeLabel);
        add(securityCodeField);
        add(nameOnCardLabel);
        add(nameOnCardField);
        add(billingAddressLabel);
        add(sameAsDelivery);
        add(billingInfoLabel);
        add(newAddressField);
        add(totalLabel);
        add(amountLabel);
        add(payNowButton);
        add(clearButton);

        setVisible(true);
    }
}
