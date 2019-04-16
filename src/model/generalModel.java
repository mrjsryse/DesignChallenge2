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
	
	public void readSongData(int SongID) {
		Database.getInstance().readBLOB(SongID);
	}
	public void updateCount(int SongID) {
		Database.getInstance().countUpdate(SongID);
	}
}
