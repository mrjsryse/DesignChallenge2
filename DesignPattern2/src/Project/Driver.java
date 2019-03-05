package Project;

public class Driver {

	public static void main(String[] args) {
		//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.95.65:3306/","superuser","kathyemir","swdespa"
		
		//jdbc:mysql://127.0.0.1:3306/
		
		//test adding for Git REEEE
		String URL = "jdbc:mysql://localhost:3306/";
		String USERNAME = "root";
		String PASSWORD = "reee";
		String DATABASE = "swdespa";
		
		selectAccount sa = new selectAccount();
		Database.getInstance().setConnection(URL, USERNAME, PASSWORD, DATABASE);
		
	}

}
