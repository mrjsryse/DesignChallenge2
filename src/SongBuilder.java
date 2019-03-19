
public class SongBuilder {
	String SongName;
	String ArtistName;
	String Album;
	String Genre;
	String Year;
	
	Song song;
	
	
	public SongBuilder()
	{
		this.song = new Song();

	}
	
	public void buldSongName(AddSong as)
	{
		song.setSongName(as.songName);
	}
	
	
	 
}
