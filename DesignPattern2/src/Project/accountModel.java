package Project;

public class accountModel {
	
	private volatile static accountModel modelInstance = null;
	
	public static accountModel getInstance() {
        if (modelInstance == null) {
        	modelInstance = new accountModel();
        }
		return modelInstance;
	
	}
	
	public void getAccountData(signingUp x) {
		Database.getInstance().addingAccount(x);
	}
	
	public void checkingAccountData(loggingIn w) {
		Database.getInstance().loggingAccount(w);
	}
}
