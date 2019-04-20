package model;
import java.util.ArrayList;


public class AccountList {
	
private static ArrayList<Account> accountList = new ArrayList<Account>();
	
	public void addAccount(Account account)
	{
		accountList.add(account);
	}

	public static ArrayList<Account> getaccountList() {
		return accountList;
	}

	public static void setaccountList(ArrayList<Account> accountList) {
		AccountList.accountList = accountList;
	}
	
	public int getaccountSize() {
		return accountList.size();
	}
	
	public int getaccountListSize() {
		return accountList.size();
	}

	public int getIndex(Account s) {
		return accountList.indexOf(s);
	}

	public void printaccounts() {
		for (int i = 0; i<accountList.size(); i++)
		{
				System.out.print(accountList.get(i).Username);
				System.out.println("");
		}
	}
}
