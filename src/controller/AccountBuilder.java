package controller;

import model.Account;

public class AccountBuilder 
{
	String Username;
	String Password;
	String Path;

	

	public AccountBuilder setUsername(String username) {
		Username = username;
		return this;
	}



	public AccountBuilder setPassword(String password) {
		Password = password;
		return this;
	}



	public AccountBuilder setPath(String path) {
		Path = path;
		return this;
	}



	public Account getAccount()
	{
		return new Account(Username,Password,Path);
	}
	
	
	
}
