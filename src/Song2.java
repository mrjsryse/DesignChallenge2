
public class Song2 implements SongPlan{

	private String songName;
	private String artistName;
	private String albumName;
	private String songGenre;
	private String year;
	
	@Override
	public void setSongName(String songName) {
		// TODO Auto-generated method stub
		this.songName = songName;
	}

	@Override
	public void setSongArtistName(String artistName) {
		// TODO Auto-generated method stub
		this.artistName = artistName;
	}

	@Override
	public void setSongAlbum(String albumName) {
		// TODO Auto-generated method stub
		this.albumName = albumName;
	}

	@Override
	public void setSongGenre(String songGenre) {
		// TODO Auto-generated method stub
		this.songGenre = songGenre;
	}

	@Override
	public void setSongYear(String year) {
		// TODO Auto-generated method stub
		this.year = year;
	}

	public String getArtistName() {
		return artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getYear() {
		return year;
	}

	public String getSongName() {
		return songName;
	}

	public String getSongGenre() {
		return songGenre;
	}

}
