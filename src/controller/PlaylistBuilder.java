package controller;

import model.Playlist;
import model.Song;

public class PlaylistBuilder {
	String playListName;
	
	public PlaylistBuilder setSongName(String playListName) {
		this.playListName = playListName;
		return this;
	}
	
	
	public Playlist getPlaylist()
	{
		return new Playlist(playListName);
	}
	
}
