package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.generalModel;

import java.awt.Font;
import javax.swing.JButton;

public class infoSong extends JFrame{
	
	AddSong song;
	String songTitle,artistName,albumName,genreName,yearDate;
	
	public infoSong() {
		
		this.setSize(650, 700);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 614, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(gettingSong(songTitle));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 69, 604, 49);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblArtist = new JLabel("Artist:");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArtist.setBounds(10, 168, 614, 23);
		getContentPane().add(lblArtist);
		
		JLabel lblArtistName = new JLabel(gettingArtist(artistName));
		lblArtistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblArtistName.setBounds(20, 182, 604, 49);
		getContentPane().add(lblArtistName);
		
		JLabel lblAlbumName = new JLabel("Album Name");
		lblAlbumName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbumName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAlbumName.setBounds(20, 280, 604, 49);
		getContentPane().add(lblAlbumName);
		
		JLabel lblAlbum = new JLabel(gettingAlbum(albumName));
		lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlbum.setBounds(10, 266, 614, 23);
		getContentPane().add(lblAlbum);
		
		JLabel lblGenreName = new JLabel("Genre Name");
		lblGenreName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenreName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGenreName.setBounds(20, 375, 604, 49);
		getContentPane().add(lblGenreName);
		
		JLabel lblGenre = new JLabel(gettingGenre(genreName));
		lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenre.setBounds(10, 361, 614, 23);
		getContentPane().add(lblGenre);
		
		JLabel lblYearOfRelease = new JLabel("Year of Release");
		lblYearOfRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearOfRelease.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblYearOfRelease.setBounds(20, 490, 604, 49);
		getContentPane().add(lblYearOfRelease);
		
		JLabel lblReleaseDate = new JLabel(gettingYear(yearDate));
		lblReleaseDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReleaseDate.setBounds(10, 476, 614, 23);
		getContentPane().add(lblReleaseDate);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(496, 597, 89, 23);
		getContentPane().add(btnNewButton);
	}

	private String gettingYear(String e) {
		String year = e;
		return year;
	}

	private String gettingGenre(String d) {
		String genre = d;
		return genre;
	}

	private String gettingAlbum(String c) {
		String album = c;
		return album;
	}

	private String gettingArtist(String b) {
		String artist = b;
		return artist;
	}

	private String gettingSong(String a) {
		String title = a;
		return title;
	}

}
