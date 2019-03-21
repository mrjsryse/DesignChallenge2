package controller;
import model.accountModel;
import model.account;

public class generalController {
	private volatile static generalController instance = null;
	
	public static generalController getInstance() {
        if(instance == null) {
        	instance = new generalController();
        }
		return instance;
	}
	
	public void gettingAccountData(String username, String password) {
		account newAccount = new account(username, password);
		accountModel.getInstance().getAccountData(newAccount);
	}
	
	public void gettingRegisteredAccountData(String registeredUsername,String registeredPassword) {
		account registeredAccount = new account(registeredUsername, registeredPassword);
		accountModel.getInstance().checkingAccountData(registeredAccount);
	}
}
