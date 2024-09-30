package gui.components.admin;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

import controllers.UserManager;
import core.entities.User;
import core.entities.Admin;
import core.entities.Customer;
import core.entities.SuperAdmin;

public class ManageUsersPanel {
    private JPanel mainPanel;
    private User user;
    private UserManager userManager;

    public ManageUsersPanel(JPanel mainPanel, User user) {
        this.mainPanel = mainPanel;
        this.user = user;
        userManager = new UserManager();
    }

    // Add Users Panel
    public void showAddUserPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new GridBagLayout());

        // Declaring some components here so that they can be accessed from the action
        // listener
        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = { "Male", "Female", "Other" };
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        JLabel contactNoLabel = new JLabel("Contact No:");
        JTextField contactNoField = new JTextField(20);
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField(20);

        // Layout
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
        roleComboBox.setSelectedIndex(1);

        // Prevent admin from creating another admin
        roleComboBox.addActionListener(e -> {
            if (roleComboBox.getSelectedItem().equals("Admin")) {
                if (this.user instanceof Admin) {
                    JOptionPane.showMessageDialog(mainPanel, "Admin cannot create another admin.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    roleComboBox.setSelectedIndex(1);
                } else {
                    // If super admin is adding another admin, disable irrelevant fields
                    // TODO: After implementing SuperAdmin class, check if User is an instance of
                    // SuperAdmin
                    genderLabel.setVisible(false);
                    genderComboBox.setVisible(false);
                    contactNoLabel.setVisible(false);
                    contactNoField.setVisible(false);
                    addressLabel.setVisible(false);
                    addressField.setVisible(false);
                }
            } else if (roleComboBox.getSelectedItem().equals("Customer")) {
                genderLabel.setVisible(true);
                genderComboBox.setVisible(true);
                contactNoLabel.setVisible(true);
                contactNoField.setVisible(true);
                addressLabel.setVisible(true);
                addressField.setVisible(true);
            }
        });

        mainPanel.add(roleComboBox, gbc);

        // Gender label and combo box
        gbc.gridx = 0;
        gbc.gridy++;
        // JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(new Color(219, 226, 233));
        genderLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        // String[] genders = { "Male", "Female", "Other" };
        // JComboBox<String> genderComboBox = new JComboBox<>(genders);
        genderComboBox.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(genderComboBox, gbc);

        // Contact No label and field
        gbc.gridx = 0;
        gbc.gridy++;
        // JLabel contactNoLabel = new JLabel("Contact No:");
        contactNoLabel.setForeground(new Color(219, 226, 233));
        contactNoLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(contactNoLabel, gbc);

        gbc.gridx = 1;
        // contactNoField = new JTextField(20);
        contactNoField.setPreferredSize(new Dimension(225, 30));
        mainPanel.add(contactNoField, gbc);

        // Address label and field
        gbc.gridx = 0;
        gbc.gridy++;
        // JLabel addressLabel = new JLabel("Address:");
        addressLabel.setForeground(new Color(219, 226, 233));
        addressLabel.setFont(new Font("Serif", Font.BOLD, 16));
        mainPanel.add(addressLabel, gbc);

        gbc.gridx = 1;
        // addressField = new JTextField(20);
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
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String role = (String) roleComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();
            String contactNo = contactNoField.getText();
            String address = addressField.getText();

            // Validations

            // Check if any field is empty
            if (role.equals("Customer")) {

                // Check for all fields
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                        || address.isEmpty() || contactNo.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if contact number is valid
                if ((contactNo.length() < 10) || (!contactNo.startsWith("0") &&
                        !contactNo.startsWith("+880"))) {
                    // Using "AND" cause if "OR" is used, if starts with "+880", check for "0"
                    // becomes true so shows error.
                    // Similar case when starts with "0".
                    JOptionPane.showMessageDialog(mainPanel, "Invalid contact number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } else if (role.equals("Admin")) {

                // Only check for name, password, and confirm password
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Check if email is valid
            if (!validEmail(email)) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if password is at least 8 characters long
            if (password.length() < 8) {
                JOptionPane.showMessageDialog(mainPanel, "Password must be at least 8 characters long.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if password and confirm password match
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(mainPanel, "Passwords do not match.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if user already exists
            if (userManager.userExists(email)) {
                JOptionPane.showMessageDialog(mainPanel, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed to add user based on role after validations
            if (role.equals("Admin")) {
                userManager.addUser(name, email, password, role);
                JOptionPane.showMessageDialog(mainPanel, "Added user successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                userManager.addUser(name, email, password, role, gender, contactNo, address);
                JOptionPane.showMessageDialog(mainPanel, "Added user successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            // Clear fields after adding user
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            roleComboBox.setSelectedIndex(1);
            genderComboBox.setSelectedIndex(0);
            contactNoField.setText("");
            addressField.setText("");
        });

        mainPanel.add(addButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(220, 53, 69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
        clearButton.setFocusPainted(false);

        clearButton.addActionListener(e -> {
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            roleComboBox.setSelectedIndex(0);
            genderComboBox.setSelectedIndex(0);
            contactNoField.setText("");
            addressField.setText("");
        });

        mainPanel.add(clearButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Update Users Panel
    public void showUpdateUserPanel() {
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
        roleComboBox.setEnabled(false); // Disable changing roles
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
        searchButton.addActionListener(e -> {
            String email = emailField.getText();

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Please enter an email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!validEmail(email)) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!userManager.userExists(email)) {
                JOptionPane.showMessageDialog(mainPanel, "User does not exist.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = userManager.searchUser(email);
            if (user instanceof Admin || user instanceof SuperAdmin) {
                nameField.setText(user.getName());
                passwordField.setText(user.getPassword());
                confirmPasswordField.setText(user.getPassword());
                roleComboBox.setSelectedItem(user.getRole());

                // Hide irrelevant fields
                genderLabel.setVisible(false);
                genderComboBox.setVisible(false);
                contactNoLabel.setVisible(false);
                contactNoField.setVisible(false);
                addressLabel.setVisible(false);
                addressField.setVisible(false);

            } else if (user instanceof Customer) {
                Customer customer = (Customer) user;
                nameField.setText(customer.getName());
                passwordField.setText(customer.getPassword());
                confirmPasswordField.setText(customer.getPassword());
                roleComboBox.setSelectedItem(customer.getRole());
                genderComboBox.setSelectedItem(customer.getGender());
                contactNoField.setText(customer.getContactNo());
                addressField.setText(customer.getAddress());

                genderLabel.setVisible(true);
                genderComboBox.setVisible(true);
                contactNoLabel.setVisible(true);
                contactNoField.setVisible(true);
                addressLabel.setVisible(true);
                addressField.setVisible(true);
            }
        });

        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(220, 53, 69));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Verdana", Font.BOLD, 14));
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String role = (String) roleComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();
            String contactNo = contactNoField.getText();
            String address = addressField.getText();

            // Validations

            User user = userManager.searchUser(email);

            // Empty field check
            if (user instanceof Admin || user instanceof SuperAdmin) {
                // Only check for name, password, and confirm password
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else if (user instanceof Customer) {
                // Check for all fields
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                        || contactNo.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Contact number validation
                if ((contactNo.length() < 10) || (!contactNo.startsWith("0") && !contactNo.startsWith("+880"))) {
                    // Using "AND" cause if "OR" is used, if starts with "+880", check for "0"
                    // becomes true so shows error.
                    // Similar case when starts with "0".
                    JOptionPane.showMessageDialog(mainPanel, "Invalid contact number.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Valid email check
            if (!validEmail(email)) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if password is at least 8 characters long
            if (password.length() < 8) {
                JOptionPane.showMessageDialog(mainPanel, "Password must be at least 8 characters long.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if password and confirm password match
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(mainPanel, "Passwords do not match.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed to update user based on role after validations
            if (user instanceof Admin) {
                if (this.user instanceof SuperAdmin) {
                    userManager.updateUser(name, email, password, role);
                    JOptionPane.showMessageDialog(mainPanel, "Updated user successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Cannot update admin or super-admin.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else if (user instanceof Customer) {
                userManager.updateUser(name, email, password, role, gender, contactNo, address);
                JOptionPane.showMessageDialog(mainPanel, "Updated user successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (user instanceof SuperAdmin) {
                JOptionPane.showMessageDialog(mainPanel, "Cannot update super-admin.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Clear fields after updating user
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            roleComboBox.setSelectedIndex(0);
            genderComboBox.setSelectedIndex(0);
            contactNoField.setText("");
            addressField.setText("");

        });

        mainPanel.add(updateButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Delete Users Panel
    public void showDeleteUserPanel() {
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
        searchButton.addActionListener(e -> {
            String email = emailField.getText();

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Please enter an email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!validEmail(email)) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!userManager.userExists(email)) {
                JOptionPane.showMessageDialog(mainPanel, "User does not exist.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            User user = userManager.searchUser(email);
            if (user instanceof Admin || user instanceof SuperAdmin) {
                nameField.setText(user.getName());
                roleComboBox.setSelectedItem(user.getRole());

                // Hide irrelevant fields
                genderLabel.setVisible(false);
                genderComboBox.setVisible(false);
                contactNoLabel.setVisible(false);
                contactNoField.setVisible(false);
                addressLabel.setVisible(false);
                addressField.setVisible(false);

            } else if (user instanceof Customer) {
                Customer customer = (Customer) user;
                nameField.setText(customer.getName());
                roleComboBox.setSelectedItem(customer.getRole());
                genderComboBox.setSelectedItem(customer.getGender());
                contactNoField.setText(customer.getContactNo());
                addressField.setText(customer.getAddress());

                genderLabel.setVisible(true);
                genderComboBox.setVisible(true);
                contactNoLabel.setVisible(true);
                contactNoField.setVisible(true);
                addressLabel.setVisible(true);
                addressField.setVisible(true);
            }
        });

        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 14));
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(e -> {
            String email = emailField.getText();

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Please enter an email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!validEmail(email)) {
                JOptionPane.showMessageDialog(mainPanel, "Invalid email address.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!userManager.userExists(email)) {
                JOptionPane.showMessageDialog(mainPanel, "User does not exist.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userManager.searchUser(email) instanceof SuperAdmin) {
                JOptionPane.showMessageDialog(mainPanel, "Cannot delete super-admin.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if (userManager.searchUser(email) instanceof Admin) {
                if (this.user instanceof SuperAdmin) {
                    userManager.deleteUser(email);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Cannot delete admin.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                userManager.deleteUser(email);
            }

            JOptionPane.showMessageDialog(mainPanel, "Deleted user successfully.", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(deleteButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // List Users Panel
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
        String[] columnNames = { "Name", "Email", "Role", "Gender", "Contact", "Address" };

        // Sample data
        String[][] data = userManager.getDataForTable();

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

    private boolean validEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern p = Pattern.compile(emailRegex);
        return p.matcher(email).matches();
    }
}
