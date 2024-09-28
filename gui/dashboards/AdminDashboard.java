import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard implements ActionListener {
    private JFrame frame;
    private JPanel leftPanel, mainPanel;
    private JLabel welcomeLabel, shopNameLabel;
    private JButton dashButton, addUserButton, deleteUserButton, updateUserButton, listUsersButton, addProductButton,
            deleteProductButton, updateProductButton, listProductsButton, logoutButton;

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

        dashButton = createStyledButton("Dashboard", 5);
        addUserButton = createStyledButton("Add User", 75);
        updateUserButton = createStyledButton("Update User", 155);
        deleteUserButton = createStyledButton("Delete User", 235);
        listUsersButton = createStyledButton("List Users", 315);
        addProductButton = createStyledButton("Add Product", 395);
        updateProductButton = createStyledButton("Update Product", 475);
        deleteProductButton = createStyledButton("Delete Product", 555);
        listProductsButton = createStyledButton("List Products", 635);
        logoutButton = createStyledButton("Log Out", 715);

        // Adding buttons to the left panel
        leftPanel.add(dashButton);
        leftPanel.add(addUserButton);
        leftPanel.add(updateUserButton);
        leftPanel.add(deleteUserButton);
        leftPanel.add(listUsersButton);
        leftPanel.add(addProductButton);
        leftPanel.add(updateProductButton);
        leftPanel.add(deleteProductButton);
        leftPanel.add(listProductsButton);
        leftPanel.add(logoutButton);

        // Doesn't render properly sometimes
        mainPanel.revalidate();
        mainPanel.repaint();
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
        } else if (e.getSource() == updateUserButton) {
            showUpdateUserPanel();
        } else if (e.getSource() == deleteUserButton) {
            showDeleteUserPanel();
        } else if (e.getSource() == listUsersButton) {
            showListUsersPanel();
        } else if (e.getSource() == addProductButton) {
            showAddProductPanel();
        } else if (e.getSource() == updateProductButton) {
            showUpdateProductPanel();
        } else if (e.getSource() == deleteProductButton) {
            showDeleteProductPanel();
        } else if (e.getSource() == listProductsButton) {
            showListProductsPanel();
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
        String[] roles = { "Admin", "Customer" };
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
        String[] genders = { "Male", "Female", "Other" };
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

        // Add and Clear buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Verdana", Font.BOLD, 14));
        addButton.setFocusPainted(false);
        mainPanel.add(addButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(220, 53, 69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
        clearButton.setFocusPainted(false);
        mainPanel.add(clearButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showUpdateUserPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
    
        // Title label
        JLabel updateUserLabel = new JLabel("Update User");
        updateUserLabel.setFont(new Font("Serif", Font.BOLD, 30));
        updateUserLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(updateUserLabel, gbc);
    
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
    
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
    
        // Add vertical padding between emailField and nameField
        gbc.insets = new Insets(50, 10, 10, 10);
    
        // Name label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);
    
        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(nameField, gbc);
    
        // Reset insets for the rest of the fields
        gbc.insets = new Insets(10, 10, 10, 10);
    
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
        String[] roles = { "Admin", "Customer" };
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
        String[] genders = { "Male", "Female", "Other" };
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
    
        // Search and Update button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons
    
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(0, 123, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Verdana", Font.BOLD, 14));
        searchButton.setFocusPainted(false);
        mainPanel.add(searchButton, gbc);
    
        gbc.gridx = 1;
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(220, 53, 69));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Verdana", Font.BOLD, 14));
        updateButton.setFocusPainted(false);
        mainPanel.add(updateButton, gbc);
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showDeleteUserPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Title label
        JLabel deleteUserLabel = new JLabel("Delete User");
        deleteUserLabel.setFont(new Font("Serif", Font.BOLD, 30));
        deleteUserLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(deleteUserLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

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

        // Add vertical padding between emailField and nameField
        gbc.insets = new Insets(50, 10, 10, 10);

        // Name label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        nameField.setDisabledTextColor(Color.GRAY);
        nameField.setEnabled(false);
        mainPanel.add(nameField, gbc);

        // Reset insets for the rest of the fields
        gbc.insets = new Insets(10, 10, 10, 10);

        // Role label and combo box
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setForeground(new Color(219, 226, 233));
        roleLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(roleLabel, gbc);

        gbc.gridx = 1;
        String[] roles = { "Admin", "Customer" };
        JComboBox<String> roleComboBox = new JComboBox<>(roles);
        roleComboBox.setPreferredSize(new Dimension(225, 30));
        roleComboBox.setEnabled(false);
        mainPanel.add(roleComboBox, gbc);

        // Gender label and combo box
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(new Color(219, 226, 233));
        genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        String[] genders = { "Male", "Female", "Other" };
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        genderComboBox.setPreferredSize(new Dimension(225, 30));
        genderComboBox.setEnabled(false);
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
        contactNoField.setDisabledTextColor(Color.GRAY);
        contactNoField.setEnabled(false);
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
        addressField.setDisabledTextColor(Color.GRAY);
        addressField.setEnabled(false);
        mainPanel.add(addressField, gbc);

        // Search and Delete buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(0, 123, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Verdana", Font.BOLD, 14));
        searchButton.setFocusPainted(false);
        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 14));
        deleteButton.setFocusPainted(false);
        mainPanel.add(deleteButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void showListUsersPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
    
        // Title label
        JLabel listUsersLabel = new JLabel("List of Users");
        listUsersLabel.setFont(new Font("Serif", Font.BOLD, 30));
        listUsersLabel.setForeground(new Color(219, 226, 233));
        listUsersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(listUsersLabel, BorderLayout.NORTH);
    
        // Column names
        String[] columnNames = {"Name", "Email", "Role", "Gender", "Contact", "Address"};
    
        // Sample data
        Object[][] data = {
            {"John Doe", "john@example.com", "Admin", "Male", "1234567890", "123 Main St"},
            {"Jane Smith", "jane@example.com", "User", "Female", "0987654321", "456 Elm St"},
            // Add more sample data as needed
        };
    
        // Create table with data
        JTable userTable = new JTable(data, columnNames);
        userTable.setFillsViewportHeight(true);
    
        // Make table scrollable
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setPreferredSize(new Dimension(800, 600)); // Set preferred size for the scroll pane
    
        // Add scroll pane to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showAddProductPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Title label
        JLabel addProductLabel = new JLabel("Add Product");
        addProductLabel.setFont(new Font("Serif", Font.BOLD, 30));
        addProductLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addProductLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Product ID label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("Product ID:");
        idLabel.setForeground(new Color(219, 226, 233));
        idLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(idField, gbc);

        // Product Name label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(nameField, gbc);

        // Product Price label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(new Color(219, 226, 233));
        priceLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        JTextField priceField = new JTextField(20);
        priceField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(priceField, gbc);

        // Product Stock label and spinner
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel stockLabel = new JLabel("Stock:");
        stockLabel.setForeground(new Color(219, 226, 233));
        stockLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(stockLabel, gbc);

        gbc.gridx = 1;
        JSpinner stockSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        stockSpinner.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(stockSpinner, gbc);

        // Product Category label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setForeground(new Color(219, 226, 233));
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(categoryLabel, gbc);

        gbc.gridx = 1;
        JTextField categoryField = new JTextField(20);
        categoryField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(categoryField, gbc);

        // Product Description label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(new Color(219, 226, 233));
        descriptionLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(descriptionField, gbc);

        // Product Image Path label and file chooser button
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel imagePathLabel = new JLabel("Image Path:");
        imagePathLabel.setForeground(new Color(219, 226, 233));
        imagePathLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(imagePathLabel, gbc);

        gbc.gridx = 1;
        JPanel imagePathPanel = new JPanel(new BorderLayout());
        imagePathPanel.setPreferredSize(new Dimension(225, 30));
        JTextField imagePathField = new JTextField(15);
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                imagePathField.setText(fileChooser.getSelectedFile().getPath());
            }
        });
        imagePathPanel.add(imagePathField, BorderLayout.CENTER);
        imagePathPanel.add(browseButton, BorderLayout.EAST);
        mainPanel.add(imagePathPanel, gbc);

        // Add and Clear buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Verdana", Font.BOLD, 14));
        addButton.setFocusPainted(false);
        mainPanel.add(addButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(220, 53, 69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
        clearButton.setFocusPainted(false);
        mainPanel.add(clearButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showUpdateProductPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
    
        // Title label
        JLabel updateProductLabel = new JLabel("Update Product");
        updateProductLabel.setFont(new Font("Serif", Font.BOLD, 30));
        updateProductLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(updateProductLabel, gbc);
    
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
    
        // Product ID label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("Product ID:");
        idLabel.setForeground(new Color(219, 226, 233));
        idLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(idLabel, gbc);
    
        gbc.gridx = 1;
        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(idField, gbc);
    
        // Add vertical padding between fields
        gbc.insets = new Insets(50, 10, 10, 10);
    
        // Product Name label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);
    
        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(nameField, gbc);
    
        // Reset insets for the rest of the fields
        gbc.insets = new Insets(10, 10, 10, 10);
    
        // Product Price label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(new Color(219, 226, 233));
        priceLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(priceLabel, gbc);
    
        gbc.gridx = 1;
        JTextField priceField = new JTextField(20);
        priceField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(priceField, gbc);
    
        // Product Stock label and spinner
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel stockLabel = new JLabel("Stock:");
        stockLabel.setForeground(new Color(219, 226, 233));
        stockLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(stockLabel, gbc);
    
        gbc.gridx = 1;
        JSpinner stockSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        stockSpinner.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(stockSpinner, gbc);
    
        // Product Category label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setForeground(new Color(219, 226, 233));
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(categoryLabel, gbc);
    
        gbc.gridx = 1;
        JTextField categoryField = new JTextField(20);
        categoryField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(categoryField, gbc);
    
        // Product Description label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(new Color(219, 226, 233));
        descriptionLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(descriptionLabel, gbc);
    
        gbc.gridx = 1;
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(descriptionField, gbc);
    
        // Product Image Path label and file chooser button
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel imagePathLabel = new JLabel("Image Path:");
        imagePathLabel.setForeground(new Color(219, 226, 233));
        imagePathLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(imagePathLabel, gbc);
    
        gbc.gridx = 1;
        JPanel imagePathPanel = new JPanel(new BorderLayout());
        imagePathPanel.setPreferredSize(new Dimension(225, 30));
        JTextField imagePathField = new JTextField(15);
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                imagePathField.setText(fileChooser.getSelectedFile().getPath());
            }
        });
        imagePathPanel.add(imagePathField, BorderLayout.CENTER);
        imagePathPanel.add(browseButton, BorderLayout.EAST);
        mainPanel.add(imagePathPanel, gbc);
    
        // Update and Clear buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons
    
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(0, 123, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Verdana", Font.BOLD, 14));
        searchButton.setFocusPainted(false);
        mainPanel.add(searchButton, gbc);
    
        gbc.gridx = 1;
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(220, 53, 69));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Verdana", Font.BOLD, 14));
        updateButton.setFocusPainted(false);
        mainPanel.add(updateButton, gbc);
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showDeleteProductPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Title label
        JLabel deleteProductLabel = new JLabel("Delete Product");
        deleteProductLabel.setFont(new Font("Serif", Font.BOLD, 30));
        deleteProductLabel.setForeground(new Color(219, 226, 233));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(deleteProductLabel, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Product ID label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel idLabel = new JLabel("Product ID:");
        idLabel.setForeground(new Color(219, 226, 233));
        idLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(idField, gbc);

        // Add vertical padding between fields
        gbc.insets = new Insets(50, 10, 10, 10);

        // Product Name label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel nameLabel = new JLabel("Product Name:");
        nameLabel.setForeground(new Color(219, 226, 233));
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(225, 30));
        nameField.setDisabledTextColor(Color.GRAY);
        nameField.setEnabled(false);
        mainPanel.add(nameField, gbc);

        // Reset insets for the rest of the fields
        gbc.insets = new Insets(10, 10, 10, 10);

        // Product Price label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(new Color(219, 226, 233));
        priceLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(priceLabel, gbc);

        gbc.gridx = 1;
        JTextField priceField = new JTextField(20);
        priceField.setPreferredSize(new Dimension(225, 30));
        priceField.setDisabledTextColor(Color.GRAY);
        priceField.setEnabled(false);
        mainPanel.add(priceField, gbc);

        // Product Stock label and spinner
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel stockLabel = new JLabel("Stock:");
        stockLabel.setForeground(new Color(219, 226, 233));
        stockLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(stockLabel, gbc);

        gbc.gridx = 1;
        JSpinner stockSpinner = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        stockSpinner.setPreferredSize(new Dimension(225, 30));
        stockSpinner.setEnabled(false);
        mainPanel.add(stockSpinner, gbc);

        // Product Category label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setForeground(new Color(219, 226, 233));
        categoryLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(categoryLabel, gbc);

        gbc.gridx = 1;
        JTextField categoryField = new JTextField(20);
        categoryField.setPreferredSize(new Dimension(225, 30));
        categoryField.setDisabledTextColor(Color.GRAY);
        categoryField.setEnabled(false);
        mainPanel.add(categoryField, gbc);

        // Product Description label and field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setForeground(new Color(219, 226, 233));
        descriptionLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        JTextField descriptionField = new JTextField(20);
        descriptionField.setPreferredSize(new Dimension(225, 30));
        descriptionField.setDisabledTextColor(Color.GRAY);
        descriptionField.setEnabled(false);
        mainPanel.add(descriptionField, gbc);

        // Search and Delete buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10); // Add some padding above the buttons

        JButton searchButton = new JButton("Search");
        searchButton.setBackground(new Color(0, 123, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Verdana", Font.BOLD, 14));
        searchButton.setFocusPainted(false);
        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 14));
        deleteButton.setFocusPainted(false);
        mainPanel.add(deleteButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showListProductsPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
    
        // Title label
        JLabel listProductsLabel = new JLabel("List of Products");
        listProductsLabel.setFont(new Font("Serif", Font.BOLD, 30));
        listProductsLabel.setForeground(new Color(219, 226, 233));
        listProductsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(listProductsLabel, BorderLayout.NORTH);
    
        // Column names
        String[] columnNames = {"ID", "Name", "Price", "Stock", "Category", "Description", "Image Path"};
    
        // Sample data
        Object[][] data = {
            {"1", "Product A", "$10.00", "100", "Category 1", "Description A", "/path/to/imageA.jpg"},
            {"2", "Product B", "$20.00", "200", "Category 2", "Description B", "/path/to/imageB.jpg"},
            // Add more sample data as needed
        };
    
        // Create table with data
        JTable productTable = new JTable(data, columnNames);
        productTable.setFillsViewportHeight(true);
        productTable.setBackground(new Color(240, 240, 240)); // Set background color for the table
    
        // Make table scrollable
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setPreferredSize(new Dimension(800, 600)); // Set preferred size for the scroll pane
    
        // Add scroll pane to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
    
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
