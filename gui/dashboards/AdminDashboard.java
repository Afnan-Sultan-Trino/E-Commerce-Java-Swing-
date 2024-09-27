import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard implements ActionListener {
    private JFrame frame;
    private JPanel leftPanel, mainPanel;
    private JLabel welcomeLabel, shopNameLabel;
    private JButton dashButton, addUserButton, listUsersButton, deleteUserButton, addProductButton, listProductsButton,
            deleteProductButton, logoutButton;

    public AdminDashboard() {

        frame = new JFrame("Dashboard");
        frame.setSize(980, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Left panel for buttons
        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 240, 800);
        leftPanel.setBackground(Color.decode("#4B4B4B"));
        leftPanel.setLayout(null);

        // Main panel
        mainPanel = new JPanel();
        mainPanel.setBounds(240, 0, 740, 800);
        mainPanel.setBackground(Color.decode("#041a42"));
        mainPanel.setLayout(null); // Using setBounds

        frame.add(leftPanel);
        frame.add(mainPanel);

        // Welcome and Shop name labels
        welcomeLabel = new JLabel("Welcome to the Dashboard");
        welcomeLabel.setForeground(new Color(219, 226, 233));
        welcomeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        welcomeLabel.setBounds(200, 300, 500, 50); // Centered
        mainPanel.add(welcomeLabel);

        shopNameLabel = new JLabel("E-Cart", JLabel.CENTER);
        shopNameLabel.setForeground(new Color(255, 140, 0));
        shopNameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 45));
        shopNameLabel.setBounds(250, 350, 300, 60); // Centered
        mainPanel.add(shopNameLabel);

        // Creating buttons
        dashButton = createStyledButton("Dashboard", 100);
        addUserButton = createStyledButton("Add User", 180);
        listUsersButton = createStyledButton("List Users", 260);
        deleteUserButton = createStyledButton("Delete User", 340);
        addProductButton = createStyledButton("Add Product", 420);
        listProductsButton = createStyledButton("List Products", 500);
        deleteProductButton = createStyledButton("Delete Product", 580);
        logoutButton = createStyledButton("Log Out", 660);

        // Adding buttons to the left panel
        leftPanel.add(dashButton);
        leftPanel.add(addUserButton);
        leftPanel.add(listUsersButton);
        leftPanel.add(deleteUserButton);
        leftPanel.add(addProductButton);
        leftPanel.add(listProductsButton);
        leftPanel.add(deleteProductButton);
        leftPanel.add(logoutButton);

        // Buttons don't render without this unless you run your cursor over the area
        // once
        leftPanel.revalidate();
        leftPanel.repaint();
    }

    // Method to create a styled button
    private JButton createStyledButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(20, yPosition, 200, 50);
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Verdana", Font.BOLD, 16)); // Set to specified font
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 165, 0)); // Lighter orange on hover
                button.repaint();
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 140, 0)); // Back to original orange
                button.repaint();
            }
        });

        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashButton) {
            showDashboard();
        } else if (e.getSource() == addUserButton) {
            showAddUserPanel();
        } else if (e.getSource() == listUsersButton) {
            // showListUsersPanel();
        } else if (e.getSource() == deleteUserButton) {
            // showDeleteUserPanel();
        } else if (e.getSource() == addProductButton) {
            // showAddProductsPanel();
        } else if (e.getSource() == listProductsButton) {
            // showListProductsPanel();
        } else if (e.getSource() == deleteProductButton) {
            // showDeleteProductsPanel();
        } else if (e.getSource() == logoutButton) {
            frame.dispose();
            // new Login();
        }
    }

    private void showDashboard() {
        mainPanel.removeAll();
        welcomeLabel.setBounds(200, 300, 500, 50); // Centered
        shopNameLabel.setBounds(250, 350, 300, 60); // Centered
        mainPanel.add(welcomeLabel);
        mainPanel.add(shopNameLabel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showAddUserPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
    
        // Title label
        JLabel addUserLabel = new JLabel("Add User");
        addUserLabel.setFont(new Font("Serif", Font.BOLD, 30));
        addUserLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addUserLabel, gbc);
    
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
    
        // Name label and field
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);
    
        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(nameField, gbc);
    
        // Email label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(new Color(219, 226, 233));
        emailLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(emailLabel, gbc);
    
        gbc.gridx = 1;
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(emailField, gbc);
    
        // Password label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(219, 226, 233));
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(passwordLabel, gbc);
    
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(passwordField, gbc);
    
        // Confirm Password label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setForeground(new Color(219, 226, 233));
        confirmPasswordLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(confirmPasswordLabel, gbc);
    
        gbc.gridx = 1;
        JPasswordField confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(confirmPasswordField, gbc);
    
        // Role label and combo box
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setForeground(new Color(219, 226, 233));
        roleLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(roleLabel, gbc);
    
        gbc.gridx = 1;
        String[] roles = {"Admin", "Customer"};
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(roleComboBox, gbc);
    
        // Gender label and combo box
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(new Color(219, 226, 233));
        genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(genderLabel, gbc);
    
        gbc.gridx = 1;
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        genderComboBox.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(genderComboBox, gbc);
    
        // Contact No label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel contactNoLabel = new JLabel("Contact No:");
        contactNoLabel.setForeground(new Color(219, 226, 233));
        contactNoLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(contactNoLabel, gbc);
    
        gbc.gridx = 1;
        JTextField contactNoField = new JTextField(20);
        contactNoField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(contactNoField, gbc);
    
        // Address label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(new Color(219, 226, 233));
        addressLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(addressLabel, gbc);
    
        gbc.gridx = 1;
        JTextField addressField = new JTextField(20);
        addressField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(addressField, gbc);
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
