package model;

import view.loggingInView;

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
		if(Database.getInstance().loggingAccount(w) == true) {
			loggingInView.getInstance().entranceAllowed();
		}
		else {
			loggingInView.getInstance().entranceDenied();
		}
	}
}
