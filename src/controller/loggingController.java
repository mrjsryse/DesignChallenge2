package controller;
import model.generalModel;
import model.loggingIn;

public class loggingController {
	private volatile static loggingController instance = null;
	
	public static loggingController getInstance() {
		if(instance == null) {
			instance = new loggingController();
		}
		return instance;
	}
	
	public void gettingRegisteredAccountData(String registeredUsername,String registeredPassword) {
		loggingIn registeredAccount = new loggingIn(registeredUsername, registeredPassword);
		generalModel.getInstance().checkingAccountData(registeredAccount);
	}
}
