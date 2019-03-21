package model;
import java.awt.*;
public class Song {
	
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	
	public Song(String songName, String artistName, String album, String genre, String year) {
		super();
		SongName = songName;
		ArtistName = artistName;
		Album = album;
		Genre = genre;
		Year = year;
	}

	public String getSongName()
	{
		return SongName;
	}
	
	public String getArtistName()
	{
		return ArtistName;
	}
	
	public String getAlbum()
	{
		return Album;
	}
	
	public String getGenre()
	{
		return Genre;
	}
	
	public String getYear()
	{
		return Year;
	}
	
	@Override
	public String toString() {
		return "Song [SongName=" + SongName + ", ArtistName=" + ArtistName + ", Album=" + Album + ", Genre=" + Genre
				+ ", Year=" + Year + "]";
	}
	
	
}
