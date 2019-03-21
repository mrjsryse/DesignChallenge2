package model;

public class accountModel {
	
	private volatile static accountModel modelInstance = null;
	
	public static accountModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new accountModel();
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
