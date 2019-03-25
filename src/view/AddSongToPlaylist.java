package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Playlist;
import model.SongList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddSongToPlaylist extends JFrame {
	private volatile static AddSongToPlaylist instance = null;
	private JPanel contentPane;
	JButton btnAddToPlaylist;
	JComboBox comboBoxSongs;

	/**
	 * Launch the application.
	 */
	public static AddSongToPlaylist getInstance() {
        if (instance == null) {
        	instance = new AddSongToPlaylist();
        }
		return instance;
	}


	/**
	 * Create the frame.
	 */
	public AddSongToPlaylist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxSongs = new JComboBox();
		comboBoxSongs.setBounds(46, 40, 127, 28);
		contentPane.add(comboBoxSongs);
		
		JLabel lblSongs = new JLabel("Songs:");
		lblSongs.setBounds(46, 15, 58, 14);
		contentPane.add(lblSongs);
		
		btnAddToPlaylist = new JButton("Add to Playlist");
		btnAddToPlaylist.addActionListener(new btn_AddToPlaylist());
		btnAddToPlaylist.setBounds(436, 205, 107, 28);
		contentPane.add(btnAddToPlaylist);
	}
	
	class btn_AddToPlaylist implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 
			 
			if(comboBoxSongs.getSelectedItem() == Playlist.getInstance().getSongInPlaylist().get(0).getSongName())
			{
				
			}
			
		 }
	 }
}
