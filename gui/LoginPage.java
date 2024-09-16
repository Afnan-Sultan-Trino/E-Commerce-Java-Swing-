package gui;

import javax.swing.*;
import javax.swing.border.Border;

import controller.UserManager;
import gui.temp.SignUpPage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginPage implements ActionListener {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel eyeLabel;
    private JButton signup;
	private Cursor cursor;
	private boolean passwordVisible=false;

    public LoginPage() {

        // Doesn't render properly on macOS, had to get cross-platform look and feel.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
    }

        frame = new JFrame("E-Commerce");
        frame.setSize(980, 800);
        frame.setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#041a42"));


		
        frame.setIconImage(loadIcon("C:/Users/sarke/Downloads/pngwing.com.png")); 
		
		
		ImageIcon originalIcon = new ImageIcon("../assets/images/authAssets/loginFrameBackground.jpeg"); // Update the path to your image file
		Image originalImage = originalIcon.getImage(); 
		Image scaledImage = originalImage.getScaledInstance(625, 800, Image.SCALE_SMOOTH); // Set your desired width and height
		ImageIcon scaledIcon = new ImageIcon(scaledImage); // Create and add JLabel for the image
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(0, 0, 500, 775); // Set the desired bounds for the image
		frame.add(imageLabel);
		
		
		JLabel lo=new JLabel("SIGN IN");
		lo.setBounds(550,250,200,30);
		Font loFont=new Font("Verdana",Font.BOLD,23);
		lo.setFont(loFont);
		lo.setForeground(new Color(215,210,203));
		frame.add(lo);
		
		
        ImageIcon emailIcon=new ImageIcon("C:/Users/sarke/AppData/Local/Temp/6698c115-0ae8-4ca5-b3f1-1fd1edbc5533_vecteezy_email-icon-png_31400781_259.zip.533/vecteezy_email-icon-png_31400781.jpg");
		JLabel emailIconLabel=new JLabel(emailIcon);
		
		
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(550, 300, 100, 30);
		Font emailFont=new Font("Verdana",Font.PLAIN,18);
		emailLabel.setFont(emailFont);
        emailLabel.setForeground(new Color(215,210,203));
        frame.add(emailLabel);

       
		emailField = new JTextField();
        emailField.setBounds(550, 328, 370, 30);
        Font emailfieldFont = new Font("Times New Roman", Font.BOLD, 17);
        emailField.setFont(emailfieldFont);
        emailField.setOpaque(false);
        emailField.setForeground(new Color(219, 226, 233));
        emailField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        emailField.setBorder(redBorder);
        frame.add(emailField);
		
		
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(550, 360, 100, 30);
		Font passwordFont=new Font("Verdana",Font.PLAIN,18);
		passwordLabel.setFont(passwordFont);
		passwordLabel.setForeground(new Color(215,210,203));
        frame.add(passwordLabel);

		
		passwordField = new JPasswordField();
        passwordField.setBounds(550, 388, 370, 30);
        Font passfieldFont = new Font("Verdana", Font.BOLD, 17);
        passwordField.setFont(passfieldFont);
        passwordField.setOpaque(false);
        passwordField.setForeground(new Color(219, 226, 233));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(179, 63, 64));
        passwordField.setBorder(redBorder2);
        passwordField.setEchoChar('*');
        frame.add(passwordField);
		
		
		
		
		// ImageIcon eyeIcon = new ImageIcon("C:/Users/sarke/Downloads/eye-close_1.png"); // Update the path to your image file
		// Image eyeImage = eyeIcon.getImage(); 
		// Image scaledEyeImage = eyeImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Set your desired width and height
		// ImageIcon scaledEyeIcon = new ImageIcon(scaledEyeImage); // Create and add JLabel for the image
		// JLabel imageEyeLabel = new JLabel(scaledEyeIcon);
		// imageEyeLabel.setBounds(40, 20, 500, 75); // Set the desired bounds for the image
		// frame.add(imageEyeLabel);
		
		
		
		
		
		// JPasswordField passwordField = new JPasswordField();
        // passwordField.setEchoChar('*'); // Default echo character

        // imageEyeLabel.addMouseListener(new MouseAdapter() {
        // @Override
        // public void mousePressed(MouseEvent e) {
        // passwordField.setEchoChar((char) 0); // Show password
         // }

        // @Override
        // public void mouseReleased(MouseEvent e) {
        // passwordField.setEchoChar('*'); // Hide password
        // }
        // });

		
		
		
		JButton forgotPassword = new JButton("Forgot Password?");
        forgotPassword.setBounds(800, 420, 120, 20);
		forgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPassword.setFocusPainted(false);
        Font forgotFont = new Font("Monospace", Font.BOLD, 12);
        forgotPassword.setBorder(BorderFactory.createEmptyBorder());
        forgotPassword.setFont(forgotFont);
        forgotPassword.setOpaque(false);
        forgotPassword.setForeground(new Color(179, 63, 64));
        forgotPassword.setOpaque(false);
        forgotPassword.setBackground(new Color(0, 0, 0, 0));
        frame.add(forgotPassword);
        // forgotPassword.setCursor(cursor);
		
		

        
        loginButton = new JButton("Sign In");
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFocusPainted(false);
		Font btnFont=new Font("Verdana",Font.BOLD,16);
		loginButton.setFont(btnFont);
        loginButton.setBounds(550, 450, 375, 33);
		loginButton.setBackground(Color.decode("#FC7F16"));
		loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        frame.add(loginButton);
		
		

        registerButton = new JButton("Register");
	    registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setFocusPainted(false);
		Font regFont=new Font("Verdana",Font.BOLD,12);
		registerButton.setFont(regFont);
        registerButton.setBounds(755, 506, 60, 20);
		registerButton.setBackground(Color.decode("#d61900"));
		registerButton.setForeground(Color.WHITE);

        registerButton.setOpaque(false);
        registerButton.setBorder(BorderFactory.createEmptyBorder());

        registerButton.addActionListener(this);
        frame.add(registerButton);
		
		JLabel signIn = new JLabel("Don't have an account?");
        signIn.setBounds(600, 490, 200, 50);
        Font signFont = new Font("Verdana", Font.PLAIN, 13);
        signIn.setFont(signFont);
        signIn.setForeground(new Color(215, 210, 203));
        frame.add(signIn);
		
		

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
	
	private Image loadIcon(String iconPath){
		ImageIcon icon = new ImageIcon(iconPath);
		Image scaledImage=icon.getImage().getScaledInstance(846,815,Image.SCALE_SMOOTH);
		return scaledImage;
	}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Logic to Login
            loginUser(emailField.getText(), new String(passwordField.getPassword()));
        } else if (e.getSource() == registerButton) {
            // Logic to Register
            new SignUpPage();
            frame.dispose();
        }
    }

    private void loginUser(String email, String pass) {
		if (email.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(frame, "Username or password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			UserManager userManager = new UserManager();
			if (userManager.validCredentials(email.toLowerCase(), pass)) {
				JOptionPane.showMessageDialog(frame, "Successfully logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
