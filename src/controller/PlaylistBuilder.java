package controller;


import java.util.ArrayList;

import model.Playlist;
import model.Song;

public class PlaylistBuilder
{
	ArrayList<Song> SongInPlaylist = new ArrayList<Song>();
	String playlistName;
	String username;
	String favorite;
	String privacy;
	
	
	public PlaylistBuilder setSongs(ArrayList<Song> SongInPlaylist) {
		this.SongInPlaylist = SongInPlaylist;
		return this;
	}
	public PlaylistBuilder setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
		return this;
	}
	
	public PlaylistBuilder setUsername(String username){
		this.username = username;
		return this;
	}
	
	public PlaylistBuilder setFavorite(String favorite) {
		this.favorite = favorite;
		return this;
	}
	
	public PlaylistBuilder setPrivacy(String privacy) {
		this.privacy = privacy;
		return this;
	}
	
	public Playlist getPlaylist()
	{
		return new Playlist(playlistName, username, favorite, privacy);
	}
	
	

}
