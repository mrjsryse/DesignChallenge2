package view;

import javax.swing.JFrame;


import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Playlist;
import model.PlaylistList;
import model.Song;
import model.SongList;
import model.generalModel;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;


public class RegisteredUserProfile extends JFrame{
	private volatile static RegisteredUserProfile instance = null;
	public String currentUser;
	public JLabel lblUser;
	private JButton btnRefresh,btnFavorite;
	ArrayList<Song> userSongs;
	ArrayList<Playlist> userPlaylists;
	PlaylistList pl;
	JList songJlist,playlistJList;
	boolean songChanged;
	
	public static RegisteredUserProfile getInstance() {
        if (instance == null) {
        	instance = new RegisteredUserProfile();
        }
		return instance;
	}
	
	public RegisteredUserProfile() {
		getContentPane().setLayout(null);
		
		lblUser = new JLabel("User:" + currentUser );
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 20));
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
		
		playlistJList = new JList();
		playlistJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				DefaultListModel DLM = new DefaultListModel();
				int i = playlistJList.getSelectedIndex();
				String SongName;
					for(int j = 0; j < pl.getPlaylistList().get(i).getSongSize();j++)
						DLM.addElement(pl.getPlaylistList().get(i).getSongInPlaylist().get(j).getSongName());
					
					songJlist.setModel(DLM);
			}
		});
		playlistJList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		playlistJList.setBounds(10, 173, 355, 430);
		getContentPane().add(playlistJList);
		
		songJlist = new JList();
		songJlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String s = songJlist.getName();
				songChanged = true;
			}
		});
		songJlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		songJlist.setBounds(726, 184, 355, 430);
		getContentPane().add(songJlist);
		
		btnFavorite = new JButton("Favorite");
		btnFavorite.setBounds(477, 256, 139, 53);
		getContentPane().add(btnFavorite);
		btnFavorite.addActionListener((ActionListener) new btn_Favorite());
		
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(477, 170, 139, 53);
		getContentPane().add(btnRefresh);
		btnRefresh.addActionListener((ActionListener) new btn_Refresh());
		
		this.setSize(1100, 700);
	}
	
	class btn_Refresh implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			userSongs = generalModel.getInstance().gettingSongs(currentUser);
			
			DefaultListModel DLM = new DefaultListModel();
			
			for(int x = 0; x < userSongs.size();x++)
				DLM.addElement(userSongs.get(x).getSongName());
			
			songJlist.setModel(DLM);
			
			PlaylistList pList = new PlaylistList();
			DefaultListModel DLM2 = new DefaultListModel();
			
			for(int x = 0; x <pList.getPlaylistSize();x++)
				DLM2.addElement(pList.getPlaylistList().get(x).getPlaylistName());
			
			playlistJList.setModel(DLM2);
			
			SongList sList = new SongList();
			
		}
	}
	
	class btn_Favorite implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String playlistOfUser = userPlaylists.get(playlistJList.getSelectedIndex()).getUsername();
			//userSongs = generalModel.getInstance().gettingSongs(currentUser);
			generalModel.getInstance().favoritingPlaylist(playlistOfUser);
		}
	}
	
	public void getUserName(String currentUser) {
		this.currentUser = currentUser;
		lblUser.setText("User: " + currentUser);
	}
}
