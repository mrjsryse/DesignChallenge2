package Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database{
	
	//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.95.65:3306/","superuser","kathyemir","swdespa"
	private volatile static Database instance = null;
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private String URL;
	private String USERNAME;
	private String PASSWORD;
	private String DATABASE;
	
	public static Database getInstance() {
        if (instance == null) {
        	instance = new Database();
        }
		return instance;
	}
	
	public boolean setConnection(String URL, String USERNAME, String PASSWORD, String DATABASE) {

		this.URL = URL;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.DATABASE = DATABASE;
		
		if(getConnection() == null)
			return false;
		//CREATE TABLE IF NOT EXISTS
		
		String query = "CREATE TABLE IF NOT EXISTS slots (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,slotType varchar(255), doctor varchar(255), dateFrom DATETIME, dateTo DATETIME);";

		String query2 = "CREATE TABLE IF NOT EXISTS books (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,bookType varchar(255), client varchar(255), dateFrom DATETIME, dateTo DATETIME, slotsID int NOT NULL);";

		String query3 = "CREATE TABLE IF NOT EXISTS notifs (id int NOT NULL AUTO_INCREMENT PRIMARY KEY,client varchar(255), doctor varchar(255), dateFrom DATETIME, dateTo DATETIME);";

		String query4 = "ALTER TABLE slots auto_increment = 1";
		
		String query5 = "ALTER TABLE books auto_increment = 1";
		
		String query6 = "ALTER TABLE notifs auto_increment = 1";
		
		try {

			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			ps = getConnection().prepareStatement(query2);
			ps.execute();
			ps = getConnection().prepareStatement(query3);
			ps.execute();
			ps = getConnection().prepareStatement(query4);
			ps.execute();
			ps = getConnection().prepareStatement(query5);
			ps.execute();
			ps = getConnection().prepareStatement(query6);
			ps.execute();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return true;
	}
	
	public Connection getConnection () {
		try {
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(
					URL + 
					DATABASE + "?serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true&autoReconnect=true&useSSL=false", 
					USERNAME,
					PASSWORD);
			return connection;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected Database() {
		
	}

	public void queryTemplate(String parameters) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String query = null;
		//create string query
		query = "";
		
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			//transform set into list
			while(rs.next()) {
				System.out.println(rs);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		//return null;
	}	

}