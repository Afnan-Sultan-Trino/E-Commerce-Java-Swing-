package gui.temp;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.LoginPage;
import controller.UserManager;

public class SignUpPage extends JFrame implements ActionListener {

	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel passLabel;
	private JLabel rptPassLabel;
	private JLabel genderLabel;
	private JLabel contactNoLabel;
	private JLabel addressLabel;
	private JTextField nameField;
	private JTextField emailField;
	private JPasswordField passField;
	private JPasswordField rptPassField;
	private JTextField genderField;
	private JTextField contactNoField;
	private JTextField addressField;
	private JButton loginBtn;
	private JButton signUpBtn;
	private JButton clearBtn;

	public SignUpPage() {

		// Instantiation
		nameLabel = new JLabel("Name");
		emailLabel = new JLabel("Email");
		passLabel = new JLabel("Password");
		rptPassLabel = new JLabel("Confirm Password");
		genderLabel = new JLabel("Gender");
		contactNoLabel = new JLabel("Contact");
		addressLabel = new JLabel("Address");

		nameField = new JTextField();
		emailField = new JTextField();
		passField = new JPasswordField();
		rptPassField = new JPasswordField();
		genderField = new JTextField();
		contactNoField = new JTextField();
		addressField = new JTextField();

		loginBtn = new JButton("Login");
		signUpBtn = new JButton("Signup");
		clearBtn = new JButton("Clear");


		// Adding action listeners
	    clearBtn.addActionListener(this);
	    loginBtn.addActionListener(this);
	    signUpBtn.addActionListener(this);


	    // Setting bounds
		nameLabel.setBounds(20, 0, 120, 30);
		emailLabel.setBounds(20, 30, 120, 30);
		passLabel.setBounds(20, 60, 120, 30);
		rptPassLabel.setBounds(20, 90, 120, 30);
		genderLabel.setBounds(20, 120, 120, 30);
		contactNoLabel.setBounds(20, 150, 120, 30);
		addressLabel.setBounds(20, 180, 120, 30);

		nameField.setBounds(150, 0, 400, 30);
		emailField.setBounds(150, 30, 400, 30);
		passField.setBounds(150, 60, 400, 30);
		rptPassField.setBounds(150, 90, 400, 30);
		genderField.setBounds(150, 120, 400, 30);
		contactNoField.setBounds(150, 150, 400, 30);
		addressField.setBounds(150, 180, 400, 30);;

		signUpBtn.setBounds(150, 220, 200, 40);
		loginBtn.setBounds(350, 220, 100, 40);
		clearBtn.setBounds(450, 220, 100, 40);

		// Add components to frame
		this.add(nameLabel);
		this.add(emailLabel);
		this.add(passLabel);
		this.add(rptPassLabel);
		this.add(genderLabel);
		this.add(contactNoLabel);
		this.add(addressLabel);
		this.add(nameField);
		this.add(emailField);
		this.add(passField);
		this.add(rptPassField);
		this.add(genderField);
		this.add(contactNoField);
		this.add(addressField);
		this.add(loginBtn);
		this.add(signUpBtn);
		this.add(clearBtn);

		// Frame initialisation
		this.setSize(600, 300);
		// this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
	}


	// Event catching
	public void actionPerformed(ActionEvent e){  
            if (e.getSource() == clearBtn) {
            	emailField.setText("");
            	passField.setText("");
            	rptPassField.setText("");
				genderField.setText("");
				contactNoField.setText("");
				addressField.setText("");
            } else if (e.getSource() == loginBtn) {
            	new LoginPage();
            	this.dispose();
        	} else if (e.getSource() == signUpBtn) {
        		// getText() is depricated for JPasswordField, recommended to use getPassword(), which returns array of chars
        		createUser(nameField.getText(), emailField.getText(), new String(passField.getPassword()), new String(rptPassField.getPassword()), genderField.getText(), contactNoField.getText(), addressField.getText());
        	}
		}

	// Validation for creating user
	private void createUser(String name, String email, String pass, String rptPass, String gender, String contactNo, String address) {

		// TODO: Validations
		// 1. Check if email is valid
		// 2. Check if password is strong
		// 3. Check if contact number is valid
		// 4. Check if name is valid (no numbers) (regex) (optional)

		if (email.equals("") || pass.equals("") || rptPass.equals("")) {
			JOptionPane.showMessageDialog(this, "Username or Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (pass.equals(rptPass)) {
				UserManager userManager = new UserManager();
				if (!userManager.userExists(email.toLowerCase())) {
					// Proceed to user creation
					userManager.addUser(name, email.toLowerCase(), pass, "Customer", gender, contactNo, address);
					JOptionPane.showMessageDialog(this, "Successfully created user.", "Success", JOptionPane.INFORMATION_MESSAGE);
					new LoginPage();
					this.dispose();
				} else {
					// User already exist
					JOptionPane.showMessageDialog(this, "User already exists.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				// Passwords don't match
				// First argument hints the parent (SignUpPage frame in this context, so will show centred on that frame)
				JOptionPane.showMessageDialog(this, "Passwords don't match.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
