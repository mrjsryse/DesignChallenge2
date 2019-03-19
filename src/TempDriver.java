
public class TempDriver {
	public static void main (String[] args)
	{
		Song song = new SongBuilder()
				.setSongName("Song")
				.setArtistName("Artist")
				.setAlbum("Album")
				.setGenre("Genre")
				.setYear("Year")
				.getSong();
		
		System.out.print(song);
	}
}
