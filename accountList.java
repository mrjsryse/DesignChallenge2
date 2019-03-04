package Project;
import java.util.ArrayList;


public class accountList {
	
	private static ArrayList<signingUp> accounts = new ArrayList<signingUp>();
	
	public void addAccount(signingUp sp) {
		accounts.add(sp);
	}
}
