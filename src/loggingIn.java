public class loggingIn {
	private String registeredUsername,registeredPassword;
	
	public loggingIn(String username, String password) {
		this.registeredUsername = registeredUsername;
		this.registeredPassword = registeredPassword;
	}

	public String getRegisteredUsername() {
		return registeredUsername;
	}

	public void setRegisteredUsername(String registeredUsername) {
		this.registeredUsername = registeredUsername;
	}

	public String getRegisteredPassword() {
		return registeredPassword;
	}

	public void setRegisteredPassword(String registeredPassword) {
		this.registeredPassword = registeredPassword;
	}
}
