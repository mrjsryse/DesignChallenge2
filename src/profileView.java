import jaco.mp3.player.MP3Player; 
import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class profileView extends JFrame {

	MP3Player mp3 = new MP3Player(new File("C:\\Users\\Nello Santos\\Desktop\\Music\\DecAve.mp3"));
	private JPanel contentPane;
	JButton btnPickPlaylist, btnPickSong, btnCreatePlaylist, btnUploadSong, btnEditSong, btnPlay, btnPause, btnNextSong, btnPreviousSong;
	JList yourSongsList;
	JTextPane txtpnSongNameGenre;
	private JButton btnRefresh;

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
	public profileView() {

		MP3Player mp3 = new MP3Player(new File("C:\\Users\\Nello Santos\\Desktop\\Music\\DecAve.mp3"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 1189, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnPlay = new JButton("Play");
		btnPlay.addActionListener(new btn_Play());
		btnPlay.setBounds(492, 681, 89, 45);
		contentPane.add(btnPlay);
		
		 btnPause = new JButton("Pause");
		btnPause.addActionListener(new btn_Pause());
		btnPause.setBounds(593, 681, 89, 45);
		contentPane.add(btnPause);
		
		 btnNextSong = new JButton(">");
		btnNextSong.setBounds(705, 681, 89, 45);
		contentPane.add(btnNextSong);
		
		 btnPreviousSong = new JButton("<");
		btnPreviousSong.setBounds(380, 681, 89, 45);
		contentPane.add(btnPreviousSong);
		
		JList playlistList = new JList();
		playlistList.setBounds(25, 93, 322, 558);
		contentPane.add(playlistList);
		
		JList playlistSongList = new JList();
		playlistSongList.setBounds(403, 139, 375, 224);
		contentPane.add(playlistSongList);
		
		 btnPickPlaylist = new JButton("Pick Playlist");
		btnPickPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPickPlaylist.setBounds(53, 664, 136, 45);
		contentPane.add(btnPickPlaylist);
		
		 btnPickSong = new JButton("Add Song to Playlist");
		btnPickSong.setBounds(898, 664, 190, 45);
		contentPane.add(btnPickSong);
		
		 txtpnSongNameGenre = new JTextPane();
		txtpnSongNameGenre.setBounds(403, 405, 375, 209);
		txtpnSongNameGenre.setText("Song Name: \r\nGenre: \r\n");
		contentPane.add(txtpnSongNameGenre);
		
		JLabel lblSongInfo = new JLabel("Song Info");
		lblSongInfo.setBounds(403, 373, 95, 26);
		contentPane.add(lblSongInfo);
		
		 btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreatePlaylist.setBounds(53, 11, 118, 45);
		contentPane.add(btnCreatePlaylist);
		
		 btnUploadSong = new JButton("Upload Song");
		btnUploadSong.addActionListener(new btn_UploadSong());
		btnUploadSong.setBounds(1021, 11, 126, 45);
		contentPane.add(btnUploadSong);
		
		 yourSongsList = new JList();
		yourSongsList.setBounds(806, 94, 341, 557);
		contentPane.add(yourSongsList);
		
		JLabel lblSongsInPlaylist = new JLabel("Songs in Playlist");
		lblSongsInPlaylist.setBounds(403, 112, 101, 26);
		contentPane.add(lblSongsInPlaylist);
		
		JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(53, 69, 95, 14);
		contentPane.add(lblPlaylists);
		
		JLabel lblYourSongs = new JLabel("Your Songs");
		lblYourSongs.setBounds(825, 69, 95, 14);
		contentPane.add(lblYourSongs);
		
		 btnEditSong = new JButton("Edit Song");
		btnEditSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditSong.setBounds(905, 11, 89, 45);
		contentPane.add(btnEditSong);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new btn_Refresh());
		btnRefresh.setBounds(760, 21, 97, 25);
		contentPane.add(btnRefresh);
	}
	
	 class btn_Play implements ActionListener 
	 {

	     public void actionPerformed(ActionEvent e) 
	     {
	        mp3.play();

	     }
	 }
	 
	 class btn_Pause implements ActionListener 
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 mp3.pause();
		 }
	 }
	 
	 class btn_UploadSong implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 AddSong as = new AddSong();
			 as.setVisible(true);
			 
		 }
	 }
	 
	 class btn_Refresh implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 {
			 SongList sList = new SongList();
			 DefaultListModel DLM = new DefaultListModel();
			 
			 for(int x = 0; x < sList.getSongSize(); x++)
			 DLM.addElement(sList.getSongList().get(x).ArtistName);
			 
			 yourSongsList.setModel(DLM);
			 
			 
			 
		 }
	 }
}