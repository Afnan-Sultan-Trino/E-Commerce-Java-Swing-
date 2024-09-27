package gui.components.customer;

import javax.swing.*;
import java.awt.*;

import core.entities.Customer;

public class PaymentFrame extends JFrame {

    public PaymentFrame(Customer customer) {
        // Set the frame properties
        setTitle("Payment");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel payIcon = new JLabel(new ImageIcon("/mnt/chromeos/MyFiles/Downloads/credit-card.png"));
        payIcon.setBounds(490, 18, 80, 40);


        JTextField cardNumberField = new JTextField( 20);
        cardNumberField.setToolTipText("Enter your 16-digit card number without spaces or dashes");
        cardNumberField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        cardNumberField.setBounds(210, 130, 545, 30);  // Adjusted width and height

        JLabel cardIcon = new JLabel(new ImageIcon("C:\\Users\\Emad\\Data\\Java\\E-CommerceManagementSystem\\E-CommerceManagementSystem\\assets\\images\\paymentAssets\\MasterCard.png"));
        cardIcon.setBounds(200, 170, 90, 40);

        JLabel cardIcon2 = new JLabel(new ImageIcon("/mnt/chromeos/MyFiles/Downloads/shopping (1).png"));
        cardIcon2.setBounds(270, 170, 90, 40);
        
        JLabel cardIcon3 = new JLabel(new ImageIcon("/mnt/chromeos/MyFiles/Downloads/american-express (1).png"));
        cardIcon3.setBounds(340, 170, 100, 40);
        
        JLabel cardIcon4 = new JLabel(new ImageIcon("/mnt/chromeos/MyFiles/Downloads/card (1).png"));
        cardIcon4.setBounds(420, 170, 90, 40);
        
        // Expiry date and security code side-by-side
        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateLabel.setBounds(50, 220, 130, 30);
        expiryDateLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        JTextField expiryDateField = new JTextField( 5);
        expiryDateField.setToolTipText("Enter the expiry date in MM/YY format");
        expiryDateField.setFont(new Font("Verdana", Font.PLAIN, 17));  
        expiryDateField.setBounds(210, 220, 160, 40);  // Set position and size


        JLabel securityIcon = new JLabel(new ImageIcon("/mnt/chromeos/MyFiles/Downloads/key-card.png"));
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

        // Billing Address Information
        JLabel billingInfoLabel = new JLabel("Billing Address Information");
        billingInfoLabel.setBounds(50, 430, 350, 30);
        billingInfoLabel.setForeground(Color.decode("#ff6600"));
        billingInfoLabel.setFont(new Font("Verdana", Font.BOLD, 21));
        JTextField newAddressField = new JTextField("Enter new address");
        newAddressField.setFont(new Font("Verdana", Font.PLAIN, 17));
        newAddressField.setBounds(50, 490, 715, 40);  // Set position and size
        

        // Two buttons: Pay Now and Clear
        JButton payNowButton = new JButton("Pay Now");
        payNowButton.setBounds(250, 570, 445, 40);  // Set position and size
        payNowButton.setBackground(Color.decode("#000000"));
        payNowButton.setForeground(Color.WHITE);
        payNowButton.setFont(new Font("Verdana", Font.BOLD, 17));
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(250, 620, 445, 40);  // Set position and size
        clearButton.setBackground(Color.decode("#e32f16"));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 17));

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
        add(payNowButton);
        add(clearButton);

        setVisible(true);
    }
}
