package model;

import controller.SongBuilder;
import view.loggingInView;

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
		Database.getInstance().addingSong(s);
	}
	
	public void getAccountData(account x) {
		Database.getInstance().addingAccount(x);
	}
	
	public void checkingAccountData(account w) {
		if(Database.getInstance().loggingAccount(w) == true) {
			loggingInView.getInstance().entranceAllowed();
		}
		else {
			loggingInView.getInstance().entranceDenied();
		}
	}
	
	public void getPlaylistData(Playlist p)
	{
		Database.getInstance().addingPlaylist(p);
	}
}
