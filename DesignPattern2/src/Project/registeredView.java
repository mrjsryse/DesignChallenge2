package Project;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class registeredView extends JFrame{
	private volatile static registeredView instance = null;
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	loggingIn entering;
	
	public static registeredView getInstance() {
        if (instance == null) {
        	instance = new registeredView();
        }
		return instance;	
	}
	public registeredView() {
		getContentPane().setLayout(null);
		
		JLabel lblLoggingIn = new JLabel("Logging In");
		lblLoggingIn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLoggingIn.setBounds(244, 67, 129, 69);
		getContentPane().add(lblLoggingIn);
		
		JLabel lblWhatAreYour = new JLabel("What Are Your Account Details");
		lblWhatAreYour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWhatAreYour.setBounds(180, 124, 322, 34);
		getContentPane().add(lblWhatAreYour);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		UsernameTextField.setBounds(56, 246, 317, 69);
		getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(56, 205, 205, 41);
		getContentPane().add(lblUsername);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		PasswordTextField.setColumns(10);
		PasswordTextField.setBounds(56, 367, 317, 69);
		getContentPane().add(PasswordTextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(56, 326, 205, 41);
		getContentPane().add(lblPassword);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(483, 488, 89, 23);
		getContentPane().add(btnProceed);
		btnProceed.addActionListener(new proceedButton());
		
		this.setSize(650, 700);
	}
	
	class proceedButton implements ActionListener
	{
		public void actionPerformed (ActionEvent registeredAccount)
		{
			String username = UsernameTextField.getText();
			String password = PasswordTextField.getText();
			entering = new loggingIn(username,password);
			
			closingWindow();
		}
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}
