package model;

import java.util.ArrayList;

import controller.SongBuilder;
import view.LoggingInView;
import view.SigningUpView;

public class generalModel {

	private volatile static generalModel modelInstance = null;
	
	public static generalModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new generalModel();
        }
		return modelInstance;
	
	}
	
	public void getSongData(Song s)
	{
		int SongID = Database.getInstance().addingSong(s);
		Database.getInstance().writeBLOB(SongID, s.getPath());
	}
	
	public void getAccountData(account x) {
		if(Database.getInstance().addingAccount(x) == false) {
			SigningUpView.getInstance().signingSuccessful();
		}
		else {
			SigningUpView.getInstance().signingFailed();
		}
	}
	
	public void checkingAccountData(account w) { //LOGGING IN
		if(Database.getInstance().loggingAccount(w) == true) {
			LoggingInView.getInstance().entranceAllowed();
		}
		else {
			LoggingInView.getInstance().entranceDenied();
		}
	}
	
	public void getPlaylistData(Playlist p)
	{
		Database.getInstance().addingPlaylist(p);
	}
	
	public void getUserPlaylistData(Playlist p)
	{
		Database.getInstance().addingUserPlaylist(p);
	}
	
	public ArrayList<Song> gettingSongs(String t) {
		return Database.getInstance().getSongs(t);
	}
	
	public ArrayList<Playlist> gettingPlaylists(String t){
		return Database.getInstance().getPlaylist(t);
	}
	
	public void readSongData(int SongID) {
		Database.getInstance().readBLOB(SongID);
	}

	public void updateCount(int SongID) {
		Database.getInstance().countUpdate(SongID);
	}
	public void favoritingPlaylist(String PlaylistID) {
		Database.getInstance().favoritingPlaylist(PlaylistID);
	}


	
	public ArrayList<Song> getSongsByGenre()
	{
		return Database.getInstance().getSongsByGenre();
	}
	
	public ArrayList<Song> getSongsByAlbum()
	{
		return Database.getInstance().getSongsByAlbum();
	}
	
	public ArrayList<Song> getSongsByYear()
	{
		return Database.getInstance().getSongsByYear();
	}
	
	public ArrayList<Playlist> getUserPlaylist(String username)
	{
		return Database.getInstance().gettingUserPlaylist(username);
	}
	
	public ArrayList<Song> getSongStuff() {
		return Database.getInstance().gettingSongs();
	}
}

