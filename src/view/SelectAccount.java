package view;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.account;

import javax.swing.ImageIcon;

public class SelectAccount extends JFrame{
	private volatile static SelectAccount instance = null;
	SigningUpView signingUpViewing;
	account signUpData,registeredData;
	LoggingInView loggingInViewing;
	ArtistLoggingInView artistLoginView;
	public JButton btnSignUp,btnGuestAccount,btnRegisteredAccount, btnArtistAccount;
	
	
	public static SelectAccount getInstance() {
        if (instance == null) {
        	instance = new SelectAccount();
        }
		return instance;
	}
	
	
	public SelectAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelectAccount.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify ");
		
		signingUpViewing = new SigningUpView();
		loggingInViewing = new LoggingInView();
		artistLoginView = new ArtistLoggingInView();
		JPanel backgroundPanel = new JPanel();
		getContentPane().add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(null);
		
		
		JLabel applicationName = new JLabel("Not So");
		applicationName.setFont(new Font("Palatino Linotype", Font.PLAIN, 29));
		applicationName.setBackground(Color.WHITE);
		applicationName.setBounds(162, 55, 87, 62);
		backgroundPanel.add(applicationName);
		
		btnGuestAccount = new JButton("Guest Account");
		btnGuestAccount.setBounds(440, 343, 127, 38);
		backgroundPanel.add(btnGuestAccount);
		
		btnRegisteredAccount = new JButton("Registered Account");

		btnRegisteredAccount.setBounds(70, 268, 183, 62);

		backgroundPanel.add(btnRegisteredAccount);
		
		btnArtistAccount = new JButton("Artist Account");
		btnArtistAccount.setBounds(290, 268, 183, 62);
		backgroundPanel.add(btnArtistAccount);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(440, 196, 127, 38);
		backgroundPanel.add(btnSignUp);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SelectAccount.class.getResource("/images/spotify.png")));
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBackground(Color.WHITE);
		label.setBounds(279, 35, 129, 129);
		backgroundPanel.add(label);
		
		JButton ArtistAccountbtn = new JButton("Artist Account");
		ArtistAccountbtn.setBounds(440, 294, 127, 38);
		backgroundPanel.add(ArtistAccountbtn);

		this.setVisible(true);
		this.setSize(593, 485);
		
		//Making the action listeners
		btnSignUp.addActionListener(new signUpButton());
		btnRegisteredAccount.addActionListener(new registeredButton());
		btnGuestAccount.addActionListener(new guestButton());
		btnArtistAccount.addActionListener(new artistButton());

	}
	
	class signUpButton implements ActionListener
	{
	public void actionPerformed (ActionEvent e)
		{
		System.out.println("Click");
		signingUpViewing.setVisible(true);
		System.out.println("After Click");
		}
}
	public void addAccount(SigningUpView signingUpViewing) {
		this.signingUpViewing = signingUpViewing;
	}
	
	class registeredButton implements ActionListener //LOGGING IN
	{
	public void actionPerformed (ActionEvent e)
		{
		System.out.println("Click Two");
		loggingInViewing.setVisible(true);
		System.out.println("After Click Two");
		}
}
	public void loggingInAccount(LoggingInView loggingInViewing) {
		this.loggingInViewing = loggingInViewing;
	}
	
	class guestButton implements ActionListener //SIGNING UP
	{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Click Three");
			GuestView.getInstance().setVisible(true);
			System.out.println("After Click Three");
			JOptionPane.showMessageDialog(null,"Logged in as Guest!");
			closingWindow();
			
		}
	}
	
	class artistButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Artist login");
			artistLoginView.setVisible(true);
		}
		
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}

