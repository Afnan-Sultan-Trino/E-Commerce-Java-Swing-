package gui.components.admin;

import javax.swing.*;

import controllers.ProductManager;
import core.entities.Product;

import java.awt.*;

public class ManageProductsPanel {
    private JPanel mainPanel;
    private ProductManager productManager;

    public ManageProductsPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        productManager = new ProductManager();
    }




    // Add product panel
    public void showAddProductPanel() {
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
        addButton.addActionListener(e -> {
            int productID;
            String productName = nameField.getText();
            int productStock = (int) stockSpinner.getValue();
            double productPrice;
            String productCategory = categoryField.getText();
            String productDescription = descriptionField.getText();
            String productImagePath = imagePathField.getText();

            try {
                productID = Integer.parseInt(idField.getText());
                productPrice = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the fields and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if product ID already exists
            if (productManager.productExists(productID)) {
                JOptionPane.showMessageDialog(null, "Product with ID " + productID + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if all fields are populated
            if (productName.isEmpty() || productCategory.isEmpty() || productDescription.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if price/stock are negative
            if (productPrice <= 0 || productStock < 0) {
                JOptionPane.showMessageDialog(null, "Price and stock cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed to add product
            if (productImagePath.isEmpty()) {
                productManager.addProduct(productID, productName, productPrice, productStock, productCategory, productDescription);
            } else {
                productManager.addProduct(productID, productName, productPrice, productStock, productCategory, productDescription, productImagePath);
            }

            JOptionPane.showMessageDialog(null, "Product with ID " + productID + " has been added.", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(addButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(220, 53, 69));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(e -> {
            idField.setText("");
            nameField.setText("");
            priceField.setText("");
            stockSpinner.setValue(0);
            categoryField.setText("");
            descriptionField.setText("");
            imagePathField.setText("");
        });
        mainPanel.add(clearButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }




    // Update product panel
    public void showUpdateProductPanel() {
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
        searchButton.addActionListener(e -> {

            // Check if ID is empty
            if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a product ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Parse ID
            int productID;
            try {
                productID = Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the fields and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if ID is valid
            if (!productManager.productExists(productID)) {
                JOptionPane.showMessageDialog(null, "Product with ID " + productID + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Fetch product details
            Product product = productManager.searchProduct(productID);

            // Populate fields
            nameField.setText(product.getName());
            priceField.setText(String.valueOf(product.getPrice()));
            stockSpinner.setValue(product.getStock());
            categoryField.setText(product.getCategory());
            descriptionField.setText(product.getDescription());
            imagePathField.setText(product.getImagePath());

        });

        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(220, 53, 69));
        updateButton.setForeground(Color.WHITE);
        updateButton.setFont(new Font("Verdana", Font.BOLD, 14));
        updateButton.setFocusPainted(false);
        updateButton.addActionListener(e -> {
            int productID;
            String productName = nameField.getText();
            int productStock = (int) stockSpinner.getValue();
            double productPrice;
            String productCategory = categoryField.getText();
            String productDescription = descriptionField.getText();
            String productImagePath = imagePathField.getText();

            try {
                productID = Integer.parseInt(idField.getText());
                productPrice = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the fields and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if all fields are populated
            if (productName.isEmpty() || productCategory.isEmpty() || productDescription.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if price/stock are negative
            if (productPrice <= 0 || productStock < 0) {
                JOptionPane.showMessageDialog(null, "Price and stock cannot be negative.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed to edit product
            if (productImagePath.isEmpty()) {
                productManager.editProduct(productID, productName, productPrice, productStock, productCategory, productDescription);
            } else {
                productManager.editProduct(productID, productName, productPrice, productStock, productCategory, productDescription, productImagePath);
            }

            JOptionPane.showMessageDialog(null, "Product with ID " + productID + " has been updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        mainPanel.add(updateButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }




    // Delete product panel
    public void showDeleteProductPanel() {
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
        searchButton.addActionListener(e -> {

            // Check if ID is empty
            if (idField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a product ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Parse ID
            int productID;
            try {
                productID = Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the fields and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if ID is valid
            if (!productManager.productExists(productID)) {
                JOptionPane.showMessageDialog(null, "Product with ID " + productID + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Fetch product details
            Product product = productManager.searchProduct(productID);

            // Populate fields
            nameField.setText(product.getName());
            priceField.setText(String.valueOf(product.getPrice()));
            stockSpinner.setValue(product.getStock());
            categoryField.setText(product.getCategory());
            descriptionField.setText(product.getDescription());
        });

        mainPanel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Verdana", Font.BOLD, 14));
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(e -> {
            int productID;
            try {
                productID = Integer.parseInt(idField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check the fields and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if ID is valid
            if (!productManager.productExists(productID)) {
                JOptionPane.showMessageDialog(null, "Product with ID " + productID + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed to delete product
            productManager.deleteProduct(productID);
            JOptionPane.showMessageDialog(null, "Product with ID " + productID + " has been deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
        mainPanel.add(deleteButton, gbc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }




    // List products panel
    public void showListProductsPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());

        // Title label
        JLabel listProductsLabel = new JLabel("List of Products");
        listProductsLabel.setFont(new Font("Serif", Font.BOLD, 30));
        listProductsLabel.setForeground(new Color(219, 226, 233));
        listProductsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(listProductsLabel, BorderLayout.NORTH);

        // Column names
        String[] columnNames = { "ID", "Name", "Price ($)", "Stock", "Category", "Description", "Image Path" };

        String[][] data = productManager.getDataForTable();

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
}
