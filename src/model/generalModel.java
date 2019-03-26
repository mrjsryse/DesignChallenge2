package model;

import controller.SongBuilder;
import view.LoggingInView;

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
		Database.getInstance().addingAccount(x);
	}
	
	public void checkingAccountData(account w) {
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
}
