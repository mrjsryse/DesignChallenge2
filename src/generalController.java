public class generalController {
	private volatile static generalController instance = null;
	
	public static generalController getInstance() {
        if(instance == null) {
        	instance = new generalController();
        }
		return instance;
	}
	
	public void gettingAccountData(String username, String password) {
		signingUp account = new signingUp(username, password);
		accountModel.getInstance().getAccountData(account);
	}
}
