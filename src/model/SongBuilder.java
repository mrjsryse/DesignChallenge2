package model;

public class SongBuilder 
{
	
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	
	public SongBuilder setSongName(String songName) {
		SongName = songName;
		return this;
	}
	public SongBuilder setArtistName(String artistName) {
		ArtistName = artistName;
		return this;
	}
	public SongBuilder setAlbum(String album) {
		Album = album;
		return this;
	}
	public SongBuilder setGenre(String genre) {
		Genre = genre;
		return this;
	}
	public SongBuilder setYear(String year) {
		Year = year;
		return this; 	
	}
	
	public Song getSong()
	{
		return new Song(SongName, ArtistName, Album, Genre, Year);
	}
	
	
	
}
