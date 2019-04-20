package model;


public class Account {
	String Username;
	String Password;
	String Path;
	
	public Account(String username, String password,String path) {
		
		super();
		Username = username;
		Password = password;
		Path = path;
	}

	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public String getPath() {
		return Path;
	}


}
