package Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class MusicPlaer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlaer frame = new MusicPlaer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MusicPlaer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MP3Player mp3player = new MP3Player(new File(filepath));
			    
			    mp3player.play();
			}
		});
		btnPlay.setBounds(314, 525, 89, 45);
		contentPane.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(413, 525, 89, 45);
		contentPane.add(btnPause);
		
		JButton btnNextSong = new JButton(">");
		btnNextSong.setBounds(526, 525, 89, 45);
		contentPane.add(btnNextSong);
		
		JButton btnPreviousSong = new JButton("<");
		btnPreviousSong.setBounds(196, 525, 89, 45);
		contentPane.add(btnPreviousSong);
		
		JList playlistList = new JList();
		playlistList.setBounds(53, 94, 175, 358);
		contentPane.add(playlistList);
		
		JList playlistSongList = new JList();
		playlistSongList.setBounds(257, 94, 299, 170);
		contentPane.add(playlistSongList);
		
		JButton btnPickPlaylist = new JButton("Pick Playlist");
		btnPickPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPickPlaylist.setBounds(53, 471, 89, 45);
		contentPane.add(btnPickPlaylist);
		
		JButton btnPickSong = new JButton("Add Song to Playlist");
		btnPickSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSong as = new AddSong();
				as.setVisible(true);
			}
		});
		btnPickSong.setBounds(590, 452, 190, 45);
		contentPane.add(btnPickSong);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(257, 300, 290, 146);
		textPane.setText("Song Name: \n"
						+ "Genre: \n");
		contentPane.add(textPane);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setBounds(267, 275, 89, 14);
		contentPane.add(lblSongInfo);
		
		JButton btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreatePlaylist.setBounds(53, 11, 118, 45);
		contentPane.add(btnCreatePlaylist);
		
		JButton btnUploadSong = new JButton("Upload Song");
		btnUploadSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUploadSong.setBounds(654, 11, 126, 45);
		contentPane.add(btnUploadSong);
		
		JList yourSongsList = new JList();
		yourSongsList.setBounds(580, 94, 194, 352);
		contentPane.add(yourSongsList);
		
		JLabel lblSongsInPlaylist = new JLabel("Songs in Playlist");
		lblSongsInPlaylist.setBounds(257, 69, 95, 14);
		contentPane.add(lblSongsInPlaylist);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(53, 69, 95, 14);
		contentPane.add(lblPlaylists);
		
		JLabel lblYourSongs = new JLabel("Your Songs");
		lblYourSongs.setBounds(587, 69, 95, 14);
		contentPane.add(lblYourSongs);
		
		JButton btnEditSong = new JButton("Edit Song");
		btnEditSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditSong.setBounds(544, 11, 89, 45);
		contentPane.add(btnEditSong);
	}
}
