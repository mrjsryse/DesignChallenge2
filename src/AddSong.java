import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class AddSong extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldArtistName;
	private JTextField textFieldAlbum;
	private JTextField textFieldGenre;
	JButton btnChooseFile, btnNewButton;
	private JTextField textFieldYear;
	String songName;
	private JTextField textFieldChosenFile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSong frame = new AddSong();
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
	public AddSong() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setBounds(0, 140, 86, 14);
		contentPane.add(lblArtistName);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(29, 194, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(29, 167, 46, 14);
		contentPane.add(lblAlbum);
		
		textFieldArtistName = new JTextField();
		textFieldArtistName.setBounds(87, 137, 86, 20);
		contentPane.add(textFieldArtistName);
		textFieldArtistName.setColumns(10);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		textFieldAlbum.setBounds(87, 164, 86, 20);
		contentPane.add(textFieldAlbum);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setColumns(10);
		textFieldGenre.setBounds(87, 191, 86, 20);
		contentPane.add(textFieldGenre);
		
		 btnNewButton = new JButton("Add Song");
		 btnNewButton.addActionListener(new btn_Add());
		btnNewButton.setBounds(306, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		 btnChooseFile = new JButton("Choose File");
		 btnChooseFile.addActionListener(new btn_ChooseFile());
		btnChooseFile.setBounds(33, 73, 140, 25);
		contentPane.add(btnChooseFile);
		
		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(87, 220, 86, 20);
		contentPane.add(textFieldYear);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(29, 221, 46, 14);
		contentPane.add(lblYear);
		
		textFieldChosenFile = new JTextField();
		textFieldChosenFile.setColumns(10);
		textFieldChosenFile.setBounds(29, 40, 144, 20);
		contentPane.add(textFieldChosenFile);
	}
	
	class btn_ChooseFile implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {
			 JFileChooser chooser = new JFileChooser();
			 chooser.showOpenDialog(null);
			 File f = chooser.getSelectedFile();
			  songName = f.getName();
		 }
		 
	 }
	
	class btn_Add implements ActionListener
	 {		
		 public void actionPerformed(ActionEvent e)
		 {

			 textFieldChosenFile.setText(songName);
			 String artistName = textFieldArtistName.getText();
			 String albumName = textFieldAlbum.getText();
			 String genre = textFieldGenre.getText();
			 String year = textFieldYear.getText();
			 
			 Song addedSong = new Song(songName, artistName, albumName, genre, year);
			 
			 SongList sList = new SongList();
			 sList.addEvent(addedSong);
			 int index = sList.getIndex(addedSong);
			 
			
			 
		 }
		 
	 }
}
