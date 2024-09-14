package gui.temp;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controller.UserManager;

public class LoginPage extends JFrame implements ActionListener {

	private JLabel jLUsername;
	private JLabel jLPassword;
	private JTextField jTUsername;
	private JPasswordField jTPassword;
	private JButton jBLogin;
	private JButton jBSignUp;
	private JButton jBClear;

	public LoginPage() {

		// Instantiation
		jLUsername = new JLabel("User");
		jLPassword = new JLabel("Password");

		jTUsername = new JTextField();
		jTPassword = new JPasswordField();

		jBLogin = new JButton("Login");
		jBSignUp = new JButton("Signup");
		jBClear = new JButton("Clear");


		// Adding action listeners
	    jBClear.addActionListener(this);
	    jBLogin.addActionListener(this);
	    jBSignUp.addActionListener(this);


	    // Setting bounds
		jLUsername.setBounds(20, 20, 60, 30);
		jLPassword.setBounds(20, 50, 60, 30);

		jTUsername.setBounds(120, 20, 400, 30);
		jTPassword.setBounds(120, 50, 400, 30);

		jBLogin.setBounds(120, 80, 200, 40);
		jBSignUp.setBounds(320, 80, 100, 40);
		jBClear.setBounds(420, 80, 100, 40);

		// Add components to frame
		this.add(jLUsername);
		this.add(jLPassword);
		this.add(jTUsername);
		this.add(jTPassword);
		this.add(jBLogin);
		this.add(jBSignUp);
		this.add(jBClear);

		// Frame initialisation
		this.setSize(540, 160);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
	}


	// Event catching
	public void actionPerformed(ActionEvent e){  
            if (e.getSource() == jBClear) {
            	jTUsername.setText("");
            	jTPassword.setText("");
            } else if (e.getSource() == jBSignUp) {
            	// new SignUpPage();
            	this.dispose();
            } else if (e.getSource() == jBLogin) {
            	// getText() is depricated for JPasswordField, recommended to use getPassword(), which returns array of chars
            	loginUser(jTUsername.getText(), new String(jTPassword.getPassword()));
            }
		}

	// Validation for logging in user
	private void loginUser(String user, String pass) {
		if (user.equals("") || pass.equals("")) {
			JOptionPane.showMessageDialog(this, "Username or password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			UserManager userManager = new UserManager();
			if (userManager.validCredentials(user, pass)) {
				JOptionPane.showMessageDialog(this, "Successfully logged in.", "Success", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect username or password.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
