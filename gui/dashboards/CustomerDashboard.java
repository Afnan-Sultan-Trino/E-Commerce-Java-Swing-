package gui.dashboards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import core.entities.Product;
import core.entities.Customer;
import controllers.ProductManager;
import controllers.UserManager;
import gui.components.ProductPanel;
import gui.auth.LoginPage;
import gui.components.CustomerEditFrame;

public class CustomerDashboard extends JFrame {
    // private JPanel sidebar;
    // private JPanel content;
    // private boolean isDarkTheme = true; // Flag to track the current theme
    private ArrayList<Product> productList;
    private ArrayList<ProductPanel> productPanels;
    String customerEmail;
    Customer c;

    public CustomerDashboard(String customerEmail) {
        // Initialize the product list and product panels
        productList = new ProductManager().getAllProducts();
        productPanels = new ArrayList<ProductPanel>();
        this.customerEmail = customerEmail;
        updateCustomerObject(customerEmail);

        // Set basic JFrame properties
        setTitle("Customer Dashboard");
        setSize(1420, 1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // North Panel (Top panel containing logo, text, search bar, icons)
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.decode("#a2ba07")); // Background color

        // Left side: App logo and text ("E-Cart")
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.decode("#a2ba07"));
        JLabel titleIcon = new JLabel(new ImageIcon("../assets/images/authAssets/shoppingCart.png"));
        JLabel titleLabel = new JLabel("E-Cart");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        leftPanel.add(titleIcon);
        leftPanel.add(titleLabel);

        // Center: Search bar with search icon
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        searchPanel.setBackground(Color.decode("#a2ba07"));
        JLabel searchIcon = new JLabel(new ImageIcon("../assets/images/authAssets/magnifyingGlass.png"));
        searchIcon.setBackground(Color.decode("#7a8928"));
        JTextField searchBar = new JTextField("Search for products or categories", 30);
        searchBar.setForeground(Color.GRAY);
        searchBar.setPreferredSize(new Dimension(400, 30)); // Adjust to center
        searchPanel.add(searchIcon);
        searchPanel.add(searchBar);

        // Right side: Profile, cart, and logout icons
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 5));
        rightPanel.setBackground(Color.decode("#a2ba07"));
        JLabel profileIcon = new JLabel(new ImageIcon("../assets/images/authAssets/user.png"));
        profileIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                updateCustomerObject(customerEmail);
                new CustomerEditFrame(c);
            }

            public void mouseEntered(MouseEvent e) {
                profileIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        JLabel cartIcon = new JLabel(new ImageIcon("../assets/images/authAssets/groceryStore.png"));
        cartIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // TODO: Open cart frame
                JOptionPane.showMessageDialog(null, "Cart Frame under Construction", "Error", JOptionPane.INFORMATION_MESSAGE);
            }

            public void mouseEntered(MouseEvent e) {
                cartIcon.setCursor(new Cursor (Cursor.HAND_CURSOR));
            }
        });

        JLabel logoutIcon = new JLabel(new ImageIcon("../assets/images/authAssets/logOut.png"));
        logoutIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginPage();
            }
            
            public void mouseEntered(MouseEvent e) {
                logoutIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        rightPanel.add(cartIcon);
        rightPanel.add(profileIcon);
        rightPanel.add(logoutIcon);

        // Add left, center, and right panels to the northPanel
        northPanel.add(leftPanel, BorderLayout.WEST);
        northPanel.add(searchPanel, BorderLayout.CENTER);
        northPanel.add(rightPanel, BorderLayout.EAST);

        // Add the northPanel to the frame
        add(northPanel, BorderLayout.NORTH);

        // West Panel (Sidebar)
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.decode("#041a42"));
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

        // Create sidebar buttons styled as in the image
        JButton dashboardButton = createSidebarButton("Dashboard");
        JButton productButton = createSidebarButton("Products");
        JButton helpButton = createSidebarButton("Help Center");

        JCheckBox checkbox1 = new JCheckBox("BDT 3K-4K");
        checkbox1.setBackground(Color.decode("#041a42"));
        checkbox1.setForeground(Color.WHITE);
        checkbox1.setBounds(0, 230, 120, 50);
        JCheckBox checkbox2 = new JCheckBox("BDT 5K-7K");
        checkbox2.setBackground(Color.decode("#041a42"));
        checkbox2.setForeground(Color.WHITE);
        checkbox2.setBounds(0, 260, 120, 50);

        JCheckBox checkbox3 = new JCheckBox("BDT 8K-10K");
        checkbox3.setBackground(Color.decode("#041a42"));
        checkbox3.setForeground(Color.WHITE);
        checkbox3.setBounds(0, 290, 120, 50);
        JCheckBox checkbox4 = new JCheckBox("BDT 10K-20K");
        checkbox4.setBackground(Color.decode("#041a42"));
        checkbox4.setForeground(Color.WHITE);
        checkbox4.setBounds(0, 320, 120, 50);

        JCheckBox checkbox5 = new JCheckBox("BDT 30K-50K");
        checkbox5.setBackground(Color.decode("#041a42"));
        checkbox5.setForeground(Color.WHITE);
        checkbox5.setBounds(0, 350, 120, 50);
        JCheckBox checkbox6 = new JCheckBox("BDT 70K-90K");
        checkbox6.setBackground(Color.decode("#041a42"));
        checkbox6.setForeground(Color.WHITE);
        checkbox6.setBounds(0, 380, 120, 50);

        JCheckBox checkbox7 = new JCheckBox("BDT 90K+");
        checkbox7.setBackground(Color.decode("#041a42"));
        checkbox7.setForeground(Color.WHITE);
        checkbox7.setBounds(0, 410, 120, 50);

        add(checkbox1);
        add(checkbox2);
        add(checkbox3);
        add(checkbox4);
        add(checkbox5);
        add(checkbox6);
        add(checkbox7);

        JButton rangeButton = createSidebarButton("Price Range");

        JButton switchThemeButton = createSidebarButton("Switch Theme");

        JLabel backIcon = new JLabel(new ImageIcon("../assets/images/authAssets/backButton.png"));
        backIcon.setBounds(28, 540, 60, 35);
        backIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginPage();
            }

            public void mouseEntered(MouseEvent e) {
                backIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        add(backIcon);

        // Add buttons to the westPanel
        westPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Top padding
        westPanel.add(dashboardButton);
        westPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons
        westPanel.add(productButton);
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(helpButton);
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(rangeButton);
        westPanel.add(Box.createVerticalGlue()); // Push the switch theme button to the bottom
        westPanel.add(switchThemeButton);
        westPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Bottom padding

        // Add westPanel to the frame
        add(westPanel, BorderLayout.WEST);

        // Centre Panel with ScrollPane (Keeping previous configuration intact)
        // The bannerPanel and productSpace remain unchanged.
        JPanel centrePanel = new JPanel(new BorderLayout());

        // Banner Panel (Top of centrePanel)
        JPanel bannerPanel = new JPanel(null); // Using null layout for manual positioning
        bannerPanel.setPreferredSize(new Dimension(1250, 900));
        bannerPanel.setBackground(Color.decode("#0c0b10"));

        // Text for bannerPanel
        JLabel bannerText = new JLabel(
                "<html><h1 style='color:#c9c6c1'>Welcome to Your E-Cart Dashboard, " + c.getName() + "!</h1><p>Discover the latest tech at unbeatable prices.</p><p>We bring you the best in cutting-edge technology. Browse our extensive catalog, view detailed product information, and experience a seamless shopping experience.</p></html>");
        Font bannerFont = new Font("open sans", Font.BOLD, 18);
        bannerText.setFont(bannerFont);
        bannerText.setForeground(Color.decode("#D3D3D3"));
        bannerText.setBounds(750, 210, 390, 280); // Manually setting bounds

        // Image for bannerPanel
        JLabel bannerImage = new JLabel(new ImageIcon("../assets/images/authAssets/banner.jpg"));
        bannerImage.setBounds(0, 0, 735, 670); // Manually setting bounds for image

        // Horizontal Panel inside bannerPanel
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new GridLayout(1, 3, 20, 0)); // 3 columns, horizontal layout with spacing
        horizontalPanel.setBounds(10, 670, 1200, 250); // Setting position and size for horizontal panel
        horizontalPanel.setBackground(Color.decode("#050507")); // Background color for horizontal panel

        // Create a panel for "Exclusive Deals" with heading, icon, and text
        JPanel exclusiveDealsPanel = new JPanel();
        exclusiveDealsPanel.setLayout(new BoxLayout(exclusiveDealsPanel, BoxLayout.Y_AXIS));
        exclusiveDealsPanel.setBackground(Color.decode("#0c0b10")); // Match background color

        // Add an icon to the label
        ImageIcon dealsIcon = new ImageIcon("../assets/images/authAssets/financialDeal.png");
        JLabel dealsLabel = new JLabel("<html><h2 style='color:#ff881e'>Exclusive Deals</h2></html>", dealsIcon,
                SwingConstants.CENTER);
        Font dealsHeadingFont = new Font("Georgia", Font.BOLD, 18);
        dealsLabel.setFont(dealsHeadingFont);
        dealsLabel.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text below the icon
        dealsLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // Position text below the icon
        dealsLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the label

        exclusiveDealsPanel.add(dealsLabel);

        // Add the descriptive text for "Exclusive Deals"
        JLabel dealsText = new JLabel(
                "<html><h2 style='color:#c9c6c1'>Unlock unbeatable savings with our daily exclusive deals! Discover limited-time offers, flash sales, and discounts on top-rated products across all categories.</h2></html>",
                SwingConstants.CENTER);
        dealsText.setBounds(westPanel.getWidth() + 10, dealsText.getY(), dealsText.getWidth(), dealsText.getHeight()); // Add 10 pixels of padding
                                                                                                                     
        Font dealsFont = new Font("open sans", Font.PLAIN, 18);
        dealsText.setFont(dealsFont);
        dealsText.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center
        exclusiveDealsPanel.add(dealsText);

        // Create a panel for "Safe and Secure Payment" with heading, icon, and text
        JPanel securePaymentPanel = new JPanel();
        securePaymentPanel.setLayout(new BoxLayout(securePaymentPanel, BoxLayout.Y_AXIS));
        securePaymentPanel.setBackground(Color.decode("#0c0b10")); // Match background color

        // Add an icon to the label
        ImageIcon secureIcon = new ImageIcon("../assets/images/authAssets/creditCard.png");
        JLabel reviewsLabel = new JLabel("<html><h2 style='color:#ff881e'>Safe and Secure Payment</h2></html>",
                secureIcon, SwingConstants.CENTER);
        Font reviewFont = new Font("Georgia", Font.BOLD, 18);
        reviewsLabel.setFont(reviewFont);
        reviewsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        reviewsLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        reviewsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        securePaymentPanel.add(reviewsLabel);

        // Add the descriptive text for "Safe and Secure Payment"
        JLabel securePaymentText = new JLabel(
                "<html><h2 style='color:#c9c6c1'>Shop confidently with our trusted and secure payment methods. We safeguard your personal information </h2></html>",
                SwingConstants.CENTER);
        securePaymentText.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center
        securePaymentPanel.add(securePaymentText);

        // Create a panel for "24/7 Customer Support" with heading, icon, and text
        JPanel customerSupportPanel = new JPanel();
        customerSupportPanel.setLayout(new BoxLayout(customerSupportPanel, BoxLayout.Y_AXIS));
        customerSupportPanel.setBackground(Color.decode("#0c0b10")); // Match background color

        // Add an icon to the label
        ImageIcon supportIcon = new ImageIcon("../assets/images/authAssets/customerService.png");
        JLabel customerSupportLabel = new JLabel("<html><h2 style='color:#ff881e'>24/7 Customer Support</h2></html>",
                supportIcon, SwingConstants.CENTER);
        Font customerSupportFont = new Font("Georgia", Font.BOLD, 18);
        customerSupportLabel.setFont(customerSupportFont);
        customerSupportLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        customerSupportLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        customerSupportLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        customerSupportPanel.add(customerSupportLabel);

        // Add the descriptive text for "24/7 Customer Support"
        JLabel customerSupportText = new JLabel(
                "<html><h2 style='color:#c9c6c1'>We're here to assist you anytime, any day!</h2></html>",
                SwingConstants.CENTER);
        customerSupportText.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center
        customerSupportPanel.add(customerSupportText);

        // Adding panels to the horizontalPanel
        horizontalPanel.add(exclusiveDealsPanel);
        horizontalPanel.add(securePaymentPanel);
        horizontalPanel.add(customerSupportPanel);

        // Adding components to bannerPanel
        bannerPanel.add(horizontalPanel); // Adding the new horizontal panel

        // Add text and image to bannerPanel
        bannerPanel.add(bannerText);
        bannerPanel.add(bannerImage);

        // Product Space (Bottom of centrePanel)
        JPanel productSpace = new JPanel();
        productSpace.setLayout(new BoxLayout(productSpace, BoxLayout.Y_AXIS)); // Vertically stack products
        productSpace.setBackground(Color.LIGHT_GRAY);

        for (Product product : productList) {
            ProductPanel productPanel = new ProductPanel(product);
            productSpace.add(productPanel);
            productPanels.add(productPanel);
        }

        // Add bannerPanel and productSpace to centrePanel
        centrePanel.add(bannerPanel, BorderLayout.NORTH);
        centrePanel.add(productSpace, BorderLayout.CENTER);

        // Wrap the centrePanel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(centrePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the scrollPane to the main frame's centre
        add(scrollPane, BorderLayout.CENTER);

        // Set the frame visible
        setVisible(true);
    }

    // Method to style sidebar buttons
    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false); // Remove focus outline
        button.setForeground(Color.WHITE);
        button.setBackground(Color.decode("#041a42"));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align in BoxLayout
        return button;
    }

    // Update the Customer object
    private void updateCustomerObject(String customerEmail) {
        UserManager userManager = new UserManager();
        c = (Customer) userManager.searchUser(customerEmail);
    }
}
