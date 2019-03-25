package model;

import java.util.ArrayList;

import view.AddSong;

public class Playlist {
	private static ArrayList<Song> SongInPlaylist = new ArrayList<Song>();
	static String playlistName;
	private volatile static Playlist instance = null;

	public Playlist(ArrayList<Song> SongInPlaylist, String playlistName) {
		super();
		this.SongInPlaylist = SongInPlaylist;
		this.playlistName = playlistName;
	}
	
	public static Playlist getInstance() {
        if (instance == null) {
        	instance = new Playlist(SongInPlaylist, playlistName);
        }
		return instance;
	}
	
	public static ArrayList<Song> getSongInPlaylist() {
		return SongInPlaylist;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void addSongToPlaylist(Song song)
	{
		SongInPlaylist.add(song);
	}

	public static void setSongList(ArrayList<Song> songList) {
		Playlist.SongInPlaylist = songList;
	}
	
	public int getSongSize() {
		return SongInPlaylist.size();
	}

	public int getIndex(Song s) {
		return SongInPlaylist.indexOf(s);
	}

	public void printSongs() {
		for (int i = 0; i<SongInPlaylist.size(); i++)
		{
				System.out.print(SongInPlaylist.get(i).SongName);
				System.out.println("");
		}
	}
	
	
}
