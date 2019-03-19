import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class selectAccount extends JFrame{
	signingUpView signingUpViewing;
	signingUp signUpData;
	loggingIn registeredData;
	loggingInView loggingInViewing;
	public JButton btnSignUp,btnGuestAccount,btnRegisteredAccount;
	
	
	
	public selectAccount() {
		
		signingUpViewing = new signingUpView();
		loggingInViewing = new loggingInView();
		
		JPanel backgroundPanel = new JPanel();
		getContentPane().add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(null);
		
		
		JLabel applicationName = new JLabel("Not So Spotify");
		applicationName.setFont(new Font("Tahoma", Font.PLAIN, 29));
		applicationName.setBackground(Color.WHITE);
		applicationName.setBounds(212, 47, 183, 62);
		backgroundPanel.add(applicationName);
		
		JLabel lblAreYouA = new JLabel("What do you want to do?");
		lblAreYouA.setBounds(245, 223, 125, 14);
		backgroundPanel.add(lblAreYouA);
		
		btnGuestAccount = new JButton("Guest Account");
		btnGuestAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuestAccount.setBounds(212, 413, 183, 62);
		backgroundPanel.add(btnGuestAccount);
		
		btnRegisteredAccount = new JButton("Registered Account");
		btnRegisteredAccount.setBounds(212, 340, 183, 62);
		backgroundPanel.add(btnRegisteredAccount);
		
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(212, 267, 183, 62);
		backgroundPanel.add(btnSignUp);

		this.setVisible(true);
		this.setSize(625, 700);
		
		//Making the action listeners
		btnSignUp.addActionListener(new signUpButton());
		btnRegisteredAccount.addActionListener(new registeredButton());

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
	public void addAccount(signingUpView signingUpViewing) {
		this.signingUpViewing = signingUpViewing;
	}
	
	class registeredButton implements ActionListener
	{
	public void actionPerformed (ActionEvent e)
		{
		System.out.println("Click Two");
		loggingInViewing.setVisible(true);
		System.out.println("After Click Two");
		}
}
	public void loggingInAccount(loggingInView loggingInViewing) {
		this.loggingInViewing = loggingInViewing;
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
	
	
	
	
}

