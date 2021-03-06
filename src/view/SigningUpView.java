package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.generalController;
import model.account;
import view.LoggingInView.confirmButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import java.awt.Font;
import java.awt.Toolkit;


import model.generalModel;


import model.Database;

import java.awt.Color;

public class SigningUpView extends JFrame{
	private volatile static SigningUpView instance = null;
	account signUp;
	generalController controller;
	private JTextField UsernameText;
	private JTextField PasswordText;
	
	
	public static SigningUpView getInstance() {
        if (instance == null) {
        	instance = new SigningUpView();
        }
		return instance;
	}
	
	public SigningUpView() {
		getContentPane().setBackground(new Color(254,254,250));
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuestView.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify");
		
		this.setSize(600, 450);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(100, 204, 89, 50);
		getContentPane().add(lblUsername);
		
		UsernameText = new JTextField();
		UsernameText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernameText.setBounds(189, 213, 295, 32);
		getContentPane().add(UsernameText);
		UsernameText.setColumns(10);
		
		PasswordText = new JPasswordField(40);
		PasswordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PasswordText.setColumns(10);
		PasswordText.setBounds(189, 251, 295, 32);
		getContentPane().add(PasswordText);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(100, 242, 89, 50);
		getContentPane().add(lblPassword);
		

		JButton btnConfirm = new JButton("SIGN UP");
		btnConfirm.addActionListener(new btn_Confirm());

		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirm.setBackground(new Color(254,254,250));
		btnConfirm.setBounds(375, 318, 109, 49);
		getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new btn_Confirm());
		
		JButton btnNotSoSpotify = new JButton("");
		btnNotSoSpotify.setBackground(new Color(254,254,250));
		btnNotSoSpotify.setIcon(new ImageIcon(LoggingInView.class.getResource("/images/spotify.png")));
		btnNotSoSpotify.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNotSoSpotify.setBounds(242, 11, 182, 153);
		btnNotSoSpotify.setBorder(null);
		getContentPane().add(btnNotSoSpotify);
		
		JLabel lblNewLabel = new JLabel("Not So");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(159, 51, 99, 86);
		getContentPane().add(lblNewLabel);

	}
	
	class btn_Confirm implements ActionListener
	{

		public void actionPerformed (ActionEvent account)
			{
				String username = UsernameText.getText();
				String password = PasswordText.getText();
				signUp = new account(username,password); 
				generalController.getInstance().gettingAccountData(username, password);
				HomeView.getInstance().setUserName(username);
				closingWindow();
				SelectAccount.getInstance().setVisible(false);
				
			}
		}
		
		public void signingSuccessful() {
			String username = UsernameText.getText();
			JOptionPane.showMessageDialog(null, "Signing Up Successful!");
			HomeView.getInstance().setVisible(true);
		}
		
		public void signingFailed() {
			JOptionPane.showMessageDialog(null, "Username already exisits! Please Try Again!");
		}
		
		public void closingWindow() {
			this.setVisible(false);
		}

}
