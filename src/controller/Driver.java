package controller;
import model.Database;
import view.selectAccount;

public class Driver {

	public static void main(String[] args) {
		//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.95.65:3306/","superuser","arielariel0","swdespa"
		
		//jdbc:mysql://192.168.0.110:3306/
		
		//test adding for Git REEEE
		String URL = "jdbc:mysql://127.0.0.1:3306/";
		String USERNAME = "root";
		String PASSWORD = "1234";
		String DATABASE = "swdespa";

		Database.getInstance().setConnection(URL, USERNAME, PASSWORD, DATABASE);
		//Database.getInstance().testerTemplate();
		selectAccount sa = new selectAccount();
		
	}

}