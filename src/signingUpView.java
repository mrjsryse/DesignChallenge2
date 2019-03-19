import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class signingUpView extends JFrame{
	private volatile static signingUpView instance = null;
	private JTextField usernameField;
	private JTextField passwordField;
	signingUp signUp;
	generalController controller;
	registeredUserView profileViewing;
	public static signingUpView getInstance() {
        if (instance == null) {
        	instance = new signingUpView();
        }
		return instance;
	}
	
	public signingUpView() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(guestView.class.getResource("/images/spotify.png")));
		setTitle("Not So Spotify");
		
		JPanel backgroundPanel = new JPanel();
		getContentPane().add(backgroundPanel, BorderLayout.CENTER);
		backgroundPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Signing Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(242, 49, 117, 76);
		backgroundPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 174, 122, 37);
		backgroundPanel.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(27, 293, 122, 37);
		backgroundPanel.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameField.setBounds(27, 209, 390, 61);
		backgroundPanel.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setColumns(10);
		passwordField.setBounds(27, 329, 390, 61);
		backgroundPanel.add(passwordField);
		
		JLabel lblWhatDoYyou = new JLabel("What Do You Want Your Account Details To Be?");
		lblWhatDoYyou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWhatDoYyou.setBounds(141, 108, 313, 44);
		backgroundPanel.add(lblWhatDoYyou);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(453, 441, 109, 23);
		backgroundPanel.add(btnConfirm);
		this.setVisible(false);
		btnConfirm.addActionListener(new confirmButton());
		
		this.setSize(650, 700);
	}
	
	class confirmButton implements ActionListener
	{
	public void actionPerformed (ActionEvent account)
		{
			String username = usernameField.getText();
			String password = passwordField.getText();
			signUp = new signingUp(username,password); //signUp is the account detials
			generalController.getInstance().gettingAccountData(username, password);;
			
			registeredUserView.getInstance().setVisible(true);
			closingWindow();
		}
	}
	
	public void closingWindow() {
		this.setVisible(false);
	}
}
