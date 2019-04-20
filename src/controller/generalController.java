package controller;
import model.generalModel;
import model.Playlist;
import model.Song;
import model.Account;

public class generalController {
	private volatile static generalController instance = null;
	
	public static generalController getInstance() {
        if(instance == null) {
        	instance = new generalController();
        }
		return instance;
	}
	
	public void gettingAccountData(String username, String password, String path) { //SINGING UP
		Account newAccount = new Account(username, password,path);
		generalModel.getInstance().getAccountData(newAccount);
	}
	
	public void gettingRegisteredAccountData(String registeredUsername,String registeredPassword,String registeredPath) { //LOGGING IN
		Account registeredAccount = new Account(registeredUsername, registeredPassword, registeredPath);
		generalModel.getInstance().checkingAccountData(registeredAccount);
	}
	
	public void gettingUserPlaylist(String username, String playlistName, String favorite)
	{
		Playlist p = new Playlist(playlistName, username, favorite);
		generalModel.getInstance().getUserPlaylistData(p);
	}
}
