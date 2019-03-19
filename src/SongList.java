import java.util.ArrayList;


public class SongList {
	
private static ArrayList<Song> songList = new ArrayList<Song>();
	
	public void addEvent(Song song)
	{
		songList.add(song);
	}

	public static ArrayList<Song> getSongList() {
		return songList;
	}

	public static void setSongList(ArrayList<Song> songList) {
		SongList.songList = songList;
	}
	
	public int getSongSize() {
		return songList.size();
	}

	public int getIndex(Song s) {
		return songList.indexOf(s);
	}

	public void printSongs() {
		for (int i = 0; i<songList.size(); i++)
		{
				System.out.print(songList.get(i).getSongName());
				System.out.println("");
		}
	}
}
