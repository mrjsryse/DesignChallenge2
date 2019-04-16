package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class RegisteredUserProfile extends JFrame{
	private volatile static RegisteredUserProfile instance = null;
	public String currentUser;
	public JLabel lblUser;
	
	public static RegisteredUserProfile getInstance() {
        if (instance == null) {
        	instance = new RegisteredUserProfile();
        }
		return instance;
	}
	
	public RegisteredUserProfile() {
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User:" + currentUser );
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setBounds(10, 34, 1071, 53);
		getContentPane().add(lblUser);
		
		JLabel lblPlaylists = new JLabel("Playlist/s");
		lblPlaylists.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylists.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlaylists.setBounds(84, 133, 202, 53);
		getContentPane().add(lblPlaylists);
		
		JLabel lblSongs = new JLabel("Song/s");
		lblSongs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSongs.setBounds(765, 133, 202, 53);
		getContentPane().add(lblSongs);
		
		JList playlistJList = new JList();
		playlistJList.setBounds(10, 173, 355, 430);
		getContentPane().add(playlistJList);
		
		JList songJList = new JList();
		songJList.setBounds(726, 184, 355, 430);
		getContentPane().add(songJList);
		
		this.setSize(1100, 700);
	}
	
	public void getUserName(String currentUser) {
		this.currentUser = currentUser;
		lblUser.setText("User: " + currentUser);
	}
}
