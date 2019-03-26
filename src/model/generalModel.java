package model;

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
}
