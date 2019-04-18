package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.PlaylistBuilder;
import controller.SongBuilder;
import controller.generalController;
import model.Playlist;
import model.PlaylistList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CreatePlaylist extends JFrame {
	private volatile static CreatePlaylist instance = null;
	private JPanel contentPane;
	private JTextField textFieldEnterPlaylistName;
	JButton btnCreatePlaylist;

	/**
	 * Launch the application.
	 */
	public static CreatePlaylist getInstance() {
        if (instance == null) {
        	instance = new CreatePlaylist();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	public CreatePlaylist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 272, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEnterPlaylistName = new JTextField();
		textFieldEnterPlaylistName.setBounds(30, 39, 112, 20);
		contentPane.add(textFieldEnterPlaylistName);
		textFieldEnterPlaylistName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Playlist Name:");
		lblNewLabel.setBounds(30, 14, 136, 14);
		contentPane.add(lblNewLabel);
		
		btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setBounds(135, 110, 101, 23);
		contentPane.add(btnCreatePlaylist);
	}
	
	class btn_CreatePlaylist implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String playlistName = textFieldEnterPlaylistName.getText();
			 String username = RegisteredUserView.getInstance().currentUser;
			 String favorite = "0";

			 Playlist addedPlaylist = new PlaylistBuilder()
					 .setPlaylistName(playlistName)
					 .setUsername(username)
					 .setFavorite(favorite)
					 .getPlaylist();

			 PlaylistList pList = new PlaylistList();
			 pList.addEvent(addedPlaylist);
			 int index = pList.getIndex(addedPlaylist);
			 
			 generalModel.getInstance().getPlaylistData(addedPlaylist);
			 
			 generalController.getInstance().gettingUserPlaylist(username, playlistName, favorite);
		
		 }
		
	 }
}
