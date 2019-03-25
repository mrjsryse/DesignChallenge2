package model;

import java.util.ArrayList;

public class PlaylistList {
		
	private static ArrayList<Playlist> songList = new ArrayList<Playlist>();
			
		public void addEvent(Playlist playlist)
		{
			songList.add(playlist);
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
					System.out.print(songList.get(i).SongName);
					System.out.println("");
			}
			
		}
}