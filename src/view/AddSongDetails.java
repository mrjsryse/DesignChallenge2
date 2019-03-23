package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
public class AddSongDetails extends JFrame{
	private JTextField SongTextField;
	private JTextField ArtistTextField;
	private JTextField GenreTextField;
	private JTextField DateTextField;
	private JTextField AlbumTextField;
	public AddSongDetails() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Song Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(659, 31, 212, 76);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSongTitle = new JLabel("Song Title");
		lblSongTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSongTitle.setBounds(39, 128, 116, 54);
		getContentPane().add(lblSongTitle);
		
		SongTextField = new JTextField();
		SongTextField.setBounds(39, 184, 403, 83);
		getContentPane().add(SongTextField);
		SongTextField.setColumns(10);
		
		ArtistTextField = new JTextField();
		ArtistTextField.setColumns(10);
		ArtistTextField.setBounds(39, 364, 403, 83);
		getContentPane().add(ArtistTextField);
		
		JLabel lblArtist = new JLabel("Artist ");
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtist.setBounds(39, 308, 116, 54);
		getContentPane().add(lblArtist);
		
		GenreTextField = new JTextField();
		GenreTextField.setColumns(10);
		GenreTextField.setBounds(39, 547, 403, 83);
		getContentPane().add(GenreTextField);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGenre.setBounds(39, 491, 116, 54);
		getContentPane().add(lblGenre);
		
		DateTextField = new JTextField();
		DateTextField.setColumns(10);
		DateTextField.setBounds(39, 726, 403, 83);
		getContentPane().add(DateTextField);
		
		JLabel lblDateMade = new JLabel("Date Made");
		lblDateMade.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDateMade.setBounds(39, 670, 116, 54);
		getContentPane().add(lblDateMade);
		
		AlbumTextField = new JTextField();
		AlbumTextField.setColumns(10);
		AlbumTextField.setBounds(557, 184, 403, 83);
		getContentPane().add(AlbumTextField);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAlbum.setBounds(557, 128, 116, 54);
		getContentPane().add(lblAlbum);
	}
}
