import java.awt.*;
public class Song {
	
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	
	public Song(String SongName, String ArtistName, String Album, String Genre, String Year)
	{
		setSong(SongName, ArtistName, Album, Genre, Year);
	}
	
	public void setSong(String SongName, String ArtistName, String Album, String Genre, String Year)
	{
		this.SongName = SongName;
		this.ArtistName = ArtistName;
		this.Album = Album;
		this.Genre = Genre;
		this.Year = Year;
	}

	public String getSongName() {
		return SongName;
	}

	public void setSongName(String songName) {
		SongName = songName;
	}

	public String getArtistName() {
		return ArtistName;
	}

	public void setArtistName(String artistName) {
		ArtistName = artistName;
	}

	public String getAlbum() {
		return Album;
	}

	public void setAlbum(String album) {
		Album = album;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}
	
}
