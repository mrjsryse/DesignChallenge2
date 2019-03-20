
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class selectAccount extends JFrame{
	private volatile static selectAccount instance = null;
	signingUpView signingUpViewing;
	signingUp signUpData;
	loggingIn registeredData;
	loggingInView loggingInViewing;
	public JButton btnSignUp,btnGuestAccount,btnRegisteredAccount;
	
	
	public static selectAccount getInstance() {
        if (instance == null) {
        	instance = new selectAccount();
        }
		return instance;
	}
	
	
	public selectAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(selectAccount.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify ");
		
		signingUpViewing = new signingUpView();
		loggingInViewing = new loggingInView();
		JPanel backgroundPanel = new JPanel();
		getContentPane().add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(null);
		
		
		JLabel applicationName = new JLabel("Not So");
		applicationName.setFont(new Font("Palatino Linotype", Font.PLAIN, 29));
		applicationName.setBackground(Color.WHITE);
		applicationName.setBounds(211, 47, 87, 62);
		backgroundPanel.add(applicationName);
		
		JLabel lblAreYouA = new JLabel("What do you want to do?");
		lblAreYouA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreYouA.setBounds(212, 223, 183, 14);
		backgroundPanel.add(lblAreYouA);
		
		btnGuestAccount = new JButton("Guest Account");
		btnGuestAccount.setBounds(212, 413, 183, 62);
		backgroundPanel.add(btnGuestAccount);
		
		btnRegisteredAccount = new JButton("Registered Account");
		btnRegisteredAccount.setBounds(212, 340, 183, 62);
		backgroundPanel.add(btnRegisteredAccount);
		
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(212, 267, 183, 62);
		backgroundPanel.add(btnSignUp);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(selectAccount.class.getResource("/images/spotify.png")));
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBackground(Color.WHITE);
		label.setBounds(328, 27, 129, 129);
		backgroundPanel.add(label);

		this.setVisible(true);
		this.setSize(625, 700);
		
		//Making the action listeners
		btnSignUp.addActionListener(new signUpButton());
		btnRegisteredAccount.addActionListener(new registeredButton());
		btnGuestAccount.addActionListener(new guestButton());

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
	
	class guestButton implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Click Three");
			guestView.getInstance().setVisible(true);
			System.out.println("After Click Three");
			JOptionPane.showMessageDialog(null,"Logged in as Guest!");
			closingWindow();
			
		}
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}

