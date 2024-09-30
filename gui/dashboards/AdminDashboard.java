package gui.dashboards;

import javax.swing.*;

import controllers.UserManager;
import core.entities.User;

import java.awt.*;
import java.awt.event.*;

import gui.auth.LoginPage;
import gui.components.admin.ManageUsersPanel;
import gui.components.admin.ManageProductsPanel;

public class AdminDashboard implements ActionListener {
    private User user;
    private JFrame frame;
    private JPanel leftPanel, mainPanel;
    private JLabel welcomeLabel, shopNameLabel;
    private JButton dashButton, addUserButton, deleteUserButton, updateUserButton, listUsersButton, addProductButton,
            deleteProductButton, updateProductButton, listProductsButton, logoutButton;

    private ManageUsersPanel userPanel;
    private ManageProductsPanel productPanel;

    public AdminDashboard(String email) {
        UserManager userManager = new UserManager();
        user = userManager.searchUser(email);

        frame = new JFrame("Dashboard");
        frame.setSize(980, 810);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 240, 800);
        leftPanel.setBackground(Color.decode("#4B4B4B"));
        leftPanel.setLayout(null);

        mainPanel = new JPanel();
        mainPanel.setBounds(240, 0, 740, 800);
        mainPanel.setBackground(Color.decode("#041a42"));
        mainPanel.setLayout(null);

        frame.add(leftPanel);
        frame.add(mainPanel);

        welcomeLabel = new JLabel("Welcome to the Dashboard");
        welcomeLabel.setForeground(new Color(219, 226, 233));
        welcomeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        welcomeLabel.setBounds(200, 300, 500, 50);
        mainPanel.add(welcomeLabel);

        shopNameLabel = new JLabel("E-Cart", JLabel.CENTER);
        shopNameLabel.setForeground(new Color(255, 140, 0));
        shopNameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 45));
        shopNameLabel.setBounds(250, 350, 300, 60);
        mainPanel.add(shopNameLabel);

        // Initialize buttons and add them to the left panel
        initializeButtons();

        // Initialize the panels
        userPanel = new ManageUsersPanel(mainPanel, user);
        productPanel = new ManageProductsPanel(mainPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
        leftPanel.revalidate();
        leftPanel.repaint();
    }

    private void initializeButtons() {
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
    }

    private JButton createStyledButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(20, yPosition, 200, 50);
        button.setBackground(new Color(255, 140, 0));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Verdana", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 165, 0));
                button.repaint();
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 140, 0));
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
            userPanel.showAddUserPanel();
        } else if (e.getSource() == updateUserButton) {
            userPanel.showUpdateUserPanel();
        } else if (e.getSource() == deleteUserButton) {
            userPanel.showDeleteUserPanel();
        } else if (e.getSource() == listUsersButton) {
            userPanel.showListUsersPanel();
        } else if (e.getSource() == addProductButton) {
            productPanel.showAddProductPanel();
        } else if (e.getSource() == updateProductButton) {
            productPanel.showUpdateProductPanel();
        } else if (e.getSource() == deleteProductButton) {
            productPanel.showDeleteProductPanel();
        } else if (e.getSource() == listProductsButton) {
            productPanel.showListProductsPanel();
        } else if (e.getSource() == logoutButton) {
            frame.dispose();
            new LoginPage();
        }
    }

    public void showDashboard() {
        mainPanel.removeAll();
        welcomeLabel.setBounds(200, 300, 500, 50);
        shopNameLabel.setBounds(250, 350, 300, 60);
        mainPanel.add(welcomeLabel);
        mainPanel.add(shopNameLabel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
