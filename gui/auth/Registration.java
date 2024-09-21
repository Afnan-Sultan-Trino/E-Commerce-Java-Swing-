package gui.auth;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

import controllers.UserManager;
import gui.auth.Registration;

import java.awt.event.*;
import java.io.*;

public class Registration implements ActionListener {
    private JFrame frame;
    private JTextField nameField, emailField, addressField, contactField;
    private JPasswordField passwordField, cpasswordField;
    private JComboBox<String> genderBox;
    private JCheckBox checkBox1;

    public Registration() {

        // Doesn't render properly on macOS, had to get cross-platform look and feel.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = new JFrame("Registration");
        frame.setSize(980, 800);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#041a42"));

        // This icon is for title-bar icon
        Image icon = Toolkit.getDefaultToolkit().getImage("../assets/images/authAssets/registerFrameBackground.png");
        frame.setIconImage(icon);

        /*
         * // This is the image on the frame
         * ImageIcon originalIcon = new
         * ImageIcon("../assets/images/authAssets/registerFrameBackground.png"); //
         * Update the path to your image file
         * Image originalImage = originalIcon.getImage();
         * 
         * Image scaledImage = originalImage.getScaledInstance(250, 200,
         * Image.SCALE_SMOOTH); // Set your desired width and height
         * ImageIcon scaledIcon = new ImageIcon(scaledImage); // Create and add JLabel
         * for the image
         * JLabel imageLabel = new JLabel(scaledIcon);
         * imageLabel.setBounds(310, 60, 200, 150);
         * frame.add(imageLabel);
         */

        JLabel fo = new JLabel("CREATE YOUR ACCOUNT");
        fo.setBounds(300, 30, 320, 30);
        Font foFont = new Font("Verdana", Font.BOLD, 23);
        fo.setFont(foFont);
        fo.setForeground(new Color(215, 210, 203));
        frame.add(fo);

        JLabel nameLabel = new JLabel("Name:");
        Font nameFont = new Font("Verdana", Font.PLAIN, 18);
        nameLabel.setFont(nameFont);
        nameLabel.setForeground(new Color(215, 210, 203));
        nameLabel.setBounds(150, 200, 100, 30);
        frame.add(nameLabel);

        // This image is for the name field
        ImageIcon nameIcon = new ImageIcon("../assets/images/authAssets/personIcon.png"); // Update the path to your
                                                                                          // image file
        Image nameImage = nameIcon.getImage();

        Image namescaledImage = nameImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                         // height
        ImageIcon namescaledIcon = new ImageIcon(namescaledImage); // Create and add JLabel for the image
        JLabel nameimageLabel = new JLabel(namescaledIcon);
        nameimageLabel.setBounds(355, 228, 30, 30);
        frame.add(nameimageLabel);

        // Border underneath icon
        JPanel nameIconBorder = new JPanel();
        nameIconBorder.setBounds(350, 258, 35, 2); // Adjust the position and size
        nameIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(nameIconBorder);

        nameField = new JTextField();
        nameField.setBounds(150, 230, 200, 30);
        Font namefieldFont = new Font("Times New Roman", Font.BOLD, 17);
        nameField.setFont(namefieldFont);
        nameField.setOpaque(false);
        nameField.setForeground(new Color(219, 226, 233));
        nameField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        nameField.setBorder(redBorder);
        frame.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        Font emailFont = new Font("Verdana", Font.PLAIN, 18);
        emailLabel.setFont(emailFont);
        emailLabel.setForeground(new Color(215, 210, 203));
        emailLabel.setBounds(150, 300, 100, 30);
        frame.add(emailLabel);

        // This image is for the email field
        ImageIcon emailIcon = new ImageIcon("../assets/images/authAssets/emailIcon.png"); // Update the path to your
                                                                                          // image file
        Image emailImage = emailIcon.getImage();
        Image emailscaledImage = emailImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                           // height
        ImageIcon emailscaledIcon = new ImageIcon(emailscaledImage); // Create and add JLabel for the image
        JLabel emailimageLabel = new JLabel(emailscaledIcon);
        emailimageLabel.setBounds(355, 330, 30, 30);
        frame.add(emailimageLabel);

        // Border underneath icon
        JPanel emailIconBorder = new JPanel();
        emailIconBorder.setBounds(350, 358, 35, 2); // Adjust the position and size
        emailIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(emailIconBorder);

        emailField = new JTextField();
        emailField.setBounds(150, 330, 200, 30);
        Font emailfieldFont = new Font("Times New Roman", Font.BOLD, 17);
        emailField.setFont(emailfieldFont);
        emailField.setOpaque(false);
        emailField.setForeground(new Color(219, 226, 233));
        emailField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        emailField.setBorder(redBorder2);
        frame.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(150, 400, 130, 30);
        Font passwordFont = new Font("Verdana", Font.PLAIN, 18);
        passwordLabel.setFont(passwordFont);
        passwordLabel.setForeground(new Color(215, 210, 203));
        // passwordLabel.setBounds(50, 150, 100, 30);
        frame.add(passwordLabel);

        // This image is for the password field
        ImageIcon passIcon = new ImageIcon("../assets/images/authAssets/passwordHiddenIcon.png"); // Update the path to
                                                                                                  // your image file
        Image passImage = passIcon.getImage();
        Image passscaledImage = passImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                         // height
        ImageIcon passscaledIcon = new ImageIcon(passscaledImage); // Create and add JLabel for the image
        JLabel passimageLabel = new JLabel(passscaledIcon);
        passimageLabel.setBounds(355, 430, 30, 30);
        frame.add(passimageLabel);

        // Border underneath icon
        JPanel passIconBorder = new JPanel();
        passIconBorder.setBounds(350, 458, 35, 2); // Adjust the position and size
        passIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(passIconBorder);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 430, 200, 30);
        Font passfieldFont = new Font("Verdana", Font.BOLD, 17);
        passwordField.setFont(passfieldFont);
        passwordField.setOpaque(false);
        passwordField.setForeground(new Color(219, 226, 233));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        passwordField.setBorder(redBorder3);
        passwordField.setEchoChar('*');
        frame.add(passwordField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(150, 480, 100, 30);
        Font genderFont = new Font("Verdana", Font.PLAIN, 18);
        genderLabel.setFont(genderFont);
        genderLabel.setForeground(new Color(215, 210, 203));
        // genderLabel.setBounds(50, 150, 100, 30);
        // genderLabel.setBounds(50, 200, 100, 30);
        frame.add(genderLabel);

        String[] genders = { "Male", "Female", "Other" };
        genderBox = new JComboBox<>(genders);
        Font genderbFont = new Font("Verdana", Font.BOLD, 17);
        genderBox.setFont(genderbFont);
        // genderBox.setOpaque(true);
        genderBox.setBackground(Color.decode("#041a42"));
        genderBox.setForeground(new Color(215, 210, 203));
        genderBox.setBorder(BorderFactory.createEmptyBorder(15, 3, 5, 3));
        Border redBorder4 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        genderBox.setBorder(redBorder4);
        genderBox.setBounds(150, 520, 200, 30);
        frame.add(genderBox);

        JLabel contactLabel = new JLabel("Contact:");
        Font contactFont = new Font("Verdana", Font.PLAIN, 18);
        contactLabel.setFont(contactFont);
        contactLabel.setForeground(new Color(215, 210, 203));
        contactLabel.setBounds(550, 300, 100, 30);
        frame.add(contactLabel);

        // This image is for the contact field
        ImageIcon callIcon = new ImageIcon("../assets/images/authAssets/phoneIcon.png"); // Update the path to your
                                                                                         // image file
        Image callImage = callIcon.getImage();
        Image callscaledImage = callImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                         // height
        ImageIcon callscaledIcon = new ImageIcon(callscaledImage); // Create and add JLabel for the image
        JLabel callimageLabel = new JLabel(callscaledIcon);
        callimageLabel.setBounds(755, 328, 30, 30);
        frame.add(callimageLabel);

        // Icon Border
        JPanel callIconBorder = new JPanel();
        callIconBorder.setBounds(750, 358, 35, 2); // Adjust the position and size
        callIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(callIconBorder);

        contactField = new JTextField();
        contactField.setBounds(550, 330, 200, 30);
        Font contactfieldFont = new Font("Times New Roman", Font.BOLD, 17);
        contactField.setFont(contactfieldFont);
        contactField.setOpaque(false);
        contactField.setForeground(new Color(219, 226, 233));
        contactField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        contactField.setBorder(redBorder5);
        frame.add(contactField);

        JLabel addressLabel = new JLabel("Address:");
        Font addressFont = new Font("Verdana", Font.PLAIN, 18);
        addressLabel.setFont(addressFont);
        addressLabel.setForeground(new Color(215, 210, 203));
        addressLabel.setBounds(550, 200, 100, 30);
        frame.add(addressLabel);

        // This image is for the address field
        ImageIcon addIcon = new ImageIcon("../assets/images/authAssets/locationIcon.png"); // Update the path to your
                                                                                           // image file
        Image addImage = addIcon.getImage();
        Image addscaledImage = addImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                       // height
        ImageIcon addscaledIcon = new ImageIcon(addscaledImage); // Create and add JLabel for the image
        JLabel addimageLabel = new JLabel(addscaledIcon);
        addimageLabel.setBounds(755, 228, 30, 30);
        frame.add(addimageLabel);

        JPanel addIconBorder = new JPanel();
        addIconBorder.setBounds(750, 258, 35, 2); // Adjust the position and size
        addIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(addIconBorder);

        addressField = new JTextField();
        addressField.setBounds(550, 230, 200, 30);
        Font addressfieldFont = new Font("Times New Roman", Font.BOLD, 17);
        addressField.setFont(addressfieldFont);
        addressField.setOpaque(false);
        addressField.setForeground(new Color(219, 226, 233));
        addressField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder6 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        // contactField.setBorder(redBorder6);
        addressField.setBorder(redBorder6);
        frame.add(addressField);

        JLabel cpasswordLabel = new JLabel("Confirm Password:");
        cpasswordLabel.setBounds(550, 400, 200, 30);
        Font cpasswordFont = new Font("Verdana", Font.PLAIN, 18);
        cpasswordLabel.setFont(cpasswordFont);
        cpasswordLabel.setForeground(new Color(215, 210, 203));
        // cpasswordLabel.setBounds(50, 150, 100, 30);
        frame.add(cpasswordLabel);

        // This iamge is for the confirm password field
        ImageIcon conIcon = new ImageIcon("../assets/images/authAssets/passwordHiddenIcon.png"); // Update the path to
                                                                                                 // your image file
        Image conImage = conIcon.getImage();
        Image conscaledImage = conImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH); // Set your desired width and
                                                                                       // height
        ImageIcon conscaledIcon = new ImageIcon(conscaledImage); // Create and add JLabel for the image
        JLabel conimageLabel = new JLabel(conscaledIcon);
        conimageLabel.setBounds(755, 430, 30, 30);
        frame.add(conimageLabel);

        JPanel conIconBorder = new JPanel();
        conIconBorder.setBounds(750, 458, 35, 2); // Adjust the position and size
        conIconBorder.setBackground(new Color(179, 63, 64));
        frame.add(conIconBorder);

        cpasswordField = new JPasswordField();
        cpasswordField.setBounds(550, 430, 200, 30);
        Font cpassfieldFont = new Font("Verdana", Font.BOLD, 17);
        cpasswordField.setFont(cpassfieldFont);
        cpasswordField.setOpaque(false);
        cpasswordField.setForeground(new Color(219, 226, 233));
        cpasswordField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder7 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        cpasswordField.setBorder(redBorder7);
        cpasswordField.setEchoChar('*');
        frame.add(cpasswordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(350, 620, 210, 40);
        registerButton.setFocusPainted(false);
        registerButton.setBackground(Color.decode("#FC7F16"));
        registerButton.setFont(new Font("Verdana", Font.BOLD, 16));
        registerButton.setForeground(Color.WHITE);
        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.addActionListener(this);
        frame.add(registerButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(550, 520, 238, 30);
        clearButton.setFocusPainted(false);
        clearButton.setBackground(Color.decode("#D9534F"));
        clearButton.setFont(new Font("Verdana", Font.BOLD, 16));
        clearButton.setForeground(Color.WHITE);
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this);
        frame.add(clearButton);

        checkBox1 = new JCheckBox("I agree to the terms and conditions.");
        checkBox1.setBounds(340, 580, 250, 30);
        checkBox1.setBackground(Color.decode("#041a42"));
        checkBox1.setFont(new Font("Verdana", Font.PLAIN, 12));
        checkBox1.setForeground(new Color(215, 210, 203));
        checkBox1.setFocusPainted(false);
        frame.add(checkBox1);

        JLabel loginLabel = new JLabel("Already Registered? Login");
        loginLabel.setForeground(Color.BLUE);
        loginLabel.setBounds(380, 680, 200, 30);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new LoginPage();
            }
        });
        frame.add(loginLabel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Register")) {
                register();
            } else if (button.getText().equals("Clear")) {
                clearFields();
            }
        }
    }

    private void register() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String cpassword = new String(cpasswordField.getPassword());
        String gender = (String) genderBox.getSelectedItem();
        String address = addressField.getText();
        String contact = contactField.getText();

        // Check if any field is empty
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty() || address.isEmpty()
                || contact.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(frame, "Invalid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters long.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if password and confirm password match
        if (!password.equals(cpassword)) {
            JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((contact.length() < 10) || (!contact.startsWith("0") && !contact.startsWith("+880"))) {
            // Using "AND" cause if "OR" is used, if starts with "+880", check for "0" becomes true so shows error.
            // Similar case when starts with "0".
            JOptionPane.showMessageDialog(frame, "Invalid contact number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if user agrees to terms & conditions
        if (!checkBox1.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Please agree to the terms and conditions", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserManager userManager = new UserManager();
        if (userManager.userExists(email)) {
            JOptionPane.showMessageDialog(frame, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            userManager.addUser(name, email, password, "Customer", gender, address, contact);
            JOptionPane.showMessageDialog(frame, "Registration Successful. Please Login", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new LoginPage();
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        addressField.setText("");
        contactField.setText("");
        genderBox.setSelectedIndex(0);
    }
}
