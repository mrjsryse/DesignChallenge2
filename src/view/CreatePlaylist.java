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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CreatePlaylist extends JFrame {
	private volatile static CreatePlaylist instance = null;
	private JPanel contentPane;
	private JTextField textFieldEnterPlaylistName;
	JButton btnCreatePlaylist;
	private JTextField textField;

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
		setBounds(100, 100, 463, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldEnterPlaylistName = new JTextField();
		textFieldEnterPlaylistName.setBounds(30, 39, 407, 20);
		contentPane.add(textFieldEnterPlaylistName);
		textFieldEnterPlaylistName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Playlist Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 14, 112, 14);
		contentPane.add(lblNewLabel);
		
		btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new btn_CreatePlaylist());
		btnCreatePlaylist.setBounds(336, 228, 101, 23);
		contentPane.add(btnCreatePlaylist);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 95, 187, 122);
		contentPane.add(textField);
		
		JLabel label = new JLabel("Description:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(312, 70, 80, 14);
		contentPane.add(label);
		
		JButton btnChooseImg = new JButton("Choose Image");
		btnChooseImg.setBounds(30, 228, 101, 23);
		contentPane.add(btnChooseImg);
		
		JLabel PlaylistImagelbl = new JLabel("Image:");
		PlaylistImagelbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PlaylistImagelbl.setBounds(60, 66, 56, 23);
		contentPane.add(PlaylistImagelbl);
		
		JLabel lblNewLabel_1 = new JLabel("Playlist Image here");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 91, 160, 126);
		contentPane.add(lblNewLabel_1);
	}
	
	class btn_CreatePlaylist implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 String playlistName = textFieldEnterPlaylistName.getText();
			 String username = RegisteredUserView.getInstance().currentUser;

			 
			 boolean isTrue = true;
			 

			 String favorite = "0";
			 String privacy = "0";

			 Playlist addedPlaylist = new PlaylistBuilder()
					 .setPlaylistName(playlistName)
					 .setUsername(username)
					 .setFavorite(favorite)
					 .setPrivacy(privacy)
					 .getPlaylist();

			 PlaylistList pList = new PlaylistList();
			 
			 for(int i = 0; i < generalModel.getInstance().getUserPlaylist(username).size();i++)
			 {
				 if(playlistName.equals(generalModel.getInstance().getUserPlaylist(username).get(i).getPlaylistName()))
				 {
					 JOptionPane.showMessageDialog(null,"Playlist already exists");
					 dispose();
					 isTrue = false;
				 }
			 }
			 
			 if(isTrue != false)
			 {
				 pList.addEvent(addedPlaylist);
				 int index = pList.getIndex(addedPlaylist);
			 
				 generalModel.getInstance().getPlaylistData(addedPlaylist);
				 generalController.getInstance().gettingUserPlaylist(username, playlistName, favorite,privacy);
				 JOptionPane.showMessageDialog(null, "Added " + playlistName + " playlist!");
			 
				 
				 dispose();
			 
			 }
			 


		 }
		 }
	 
	
	public void closingWindow() {
		this.setVisible(false);
	}
 }
 //songID, username, songName,artistName,albumName,genre,year,path,count,favorite
