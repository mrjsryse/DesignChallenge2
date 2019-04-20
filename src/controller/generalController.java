package controller;
import model.generalModel;
import model.Playlist;
import model.Song;
import model.account;

public class generalController {
	private volatile static generalController instance = null;
	
	public static generalController getInstance() {
        if(instance == null) {
        	instance = new generalController();
        }
		return instance;
	}
	
	public void gettingAccountData(String username, String password) { //SINGING UP
		account newAccount = new account(username, password);
		generalModel.getInstance().getAccountData(newAccount);
	}
	
	public void gettingRegisteredAccountData(String registeredUsername,String registeredPassword) { //LOGGING IN
		account registeredAccount = new account(registeredUsername, registeredPassword);
		generalModel.getInstance().checkingAccountData(registeredAccount);
	}
	
	public void gettingUserPlaylist(String username, String playlistName, String favorite,String privacy,String path,String description)
	{
		Playlist p = new Playlist(playlistName, username, favorite,privacy,path,description);
		generalModel.getInstance().getUserPlaylistData(p);
	}
}
