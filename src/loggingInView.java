import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class loggingInView extends JFrame{
	private JTextField UsernameTextField;
	private JTextField PasswordTextField;
	loggingIn logIn;
	public loggingInView() {
		this.setSize(650, 700);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Logging In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(237, 68, 125, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What Are Your Account Detials?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(192, 127, 233, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(40, 204, 218, 50);
		getContentPane().add(lblUsername);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernameTextField.setBounds(40, 249, 443, 70);
		getContentPane().add(UsernameTextField);
		UsernameTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordTextField.setColumns(10);
		PasswordTextField.setBounds(40, 419, 443, 70);
		getContentPane().add(PasswordTextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(40, 374, 218, 50);
		getContentPane().add(lblPassword);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(462, 584, 89, 23);
		getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new confirmButton());
	}
	class confirmButton implements ActionListener
	{
	public void actionPerformed (ActionEvent account)
		{
			String registeredUsername = UsernameTextField.getText();
			String registeredPassword = PasswordTextField.getText();
			logIn = new loggingIn(registeredUsername,registeredPassword);
			loggingController.getInstance().gettingRegisteredAccountData(registeredUsername, registeredPassword);
			closingWindow();
		}
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}