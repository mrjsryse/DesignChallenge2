package model;

public class generalModel {
	private volatile static generalModel modelInstance = null;
	
	public static generalModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new generalModel();
        }
		return modelInstance;
	
	}
	
	public void getAccountData(account x) {
		Database.getInstance().addingAccount(x);
	}
	
	public void checkingAccountData(account w) {
		Database.getInstance().loggingAccount(w);
	}
}
