package model;

import controller.SongBuilder;

public class generalModel {
	
	private volatile static generalModel modelInstance = null;
	
	public static generalModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new generalModel();
        }
		return modelInstance;
	
	}
	
	public void getAccountData(signingUp x) {
		Database.getInstance().addingAccount(x);
	}
	
	public void checkingAccountData(loggingIn w) {
		Database.getInstance().loggingAccount(w);
	}
	
	public void getSongData(Song s)
	{
		Database.getInstance().addingSong(s);
	}
}
