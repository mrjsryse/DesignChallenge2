package model;
import java.io.File;
import javax.swing.*;
import javax.swing.JOptionPane;

import controller.PlaylistBuilder;
import controller.SongBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import view.LoggingInView;

public class Database{
	
	//"com.mysql.jdbc.Driver","jdbc:mysql://112.211.95.65:3306/","superuser","kathyemir","swdespa"
	//arielariel0
	private volatile static Database instance = null;
	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private String URL;
	private String USERNAME;
	private String PASSWORD;
	private String DATABASE;
	LoggingInView entrance;
	
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
		
		String query = "CREATE TABLE IF NOT EXISTS accounts (Username varchar(255) PRIMARY KEY, Password varchar(255));"; //creating table
		String query2 = "CREATE TABLE IF NOT EXISTS playlists(PlaylistID int NOT NULL AUTO_INCREMENT PRIMARY KEY, PlaylistName varchar(255), Username varchar(255));";
		String query3 = "CREATE TABLE IF NOT EXISTS songs(SongID int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, Title varchar(255), "
				+ "Artist varchar(255),Album varchar(255),Genre varchar(255), Year varchar(255), Username varchar(255), Play_Count int(11), Favorite varchar(255));";
		String query4 = "CREATE TABLE IF NOT EXISTS user_playlists(PlaylistID int NOT NULL AUTO_INCREMENT PRIMARY KEY,Username varchar(255), PlaylistName varchar(255), Favorite varchar(255), Privacy varchar(255));";
		String query5 = "CREATE TABLE IF NOT EXISTS songData(SongID int NOT NULL AUTO_INCREMENT PRIMARY KEY, data LONGBLOB);";
		String query6 = "CREATE TABLE IF NOT EXISTS songs_in_playlist(PlaylistID int PRIMARY KEY, PlaylistName varchar(255),SongID int(11), SongName varchar(255));";		
		
		String packetQuery = "SET GLOBAL max_allowed_packet=16777216;";
		
		String queryIncrement = "ALTER TABLE accounts auto_increment = 1";
		String queryIncrement2 = "ALTER TABLE playlists auto_increment = 1";
		String queryIncrement3 = "ALTER TABLE songs auto_increment = 1";
		String queryIncrement4 = "ALTER TABLE user_playlists auto_increment = 1";
		String queryIncrement5 = "ALTER TABLE songData auto_increment = 1";
//		String queryIncrement7 = "ALTER TABLE user_songs auto_increment = 1";
//		String queryIncrement6 = "ALTER TABLE song_in_playlist = 1";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			PreparedStatement ps2 = getConnection().prepareStatement(query2);
			ps2.execute();
			PreparedStatement ps3 = getConnection().prepareStatement(query3);
			ps3.execute();
			PreparedStatement ps4 = getConnection().prepareStatement(query4);
			ps4.execute();
			PreparedStatement ps5 = getConnection().prepareStatement(query5);
			ps5.execute();
			PreparedStatement ps6 = getConnection().prepareStatement(query6);
			ps6.execute();
//			PreparedStatement ps7 = getConnection().prepareStatement(query7);
//			ps7.execute();
			
			PreparedStatement pq = getConnection().prepareStatement(packetQuery);
			pq.execute();
			
			ps = getConnection().prepareStatement(queryIncrement);
			ps.execute();
			ps2 = getConnection().prepareStatement(queryIncrement2);
			ps2.execute();
			ps3 = getConnection().prepareStatement(queryIncrement3);
			ps3.execute();
			ps4 = getConnection().prepareStatement(queryIncrement4);
			ps4.execute();
			ps5 = getConnection().prepareStatement(queryIncrement5);
			ps5.execute();
//			ps6 = getConnection().prepareStatement(queryIncrement6);
//			ps6.execute();
//			ps7 = getConnection().prepareStatement(queryIncrement7);
//			ps7.execute();
			
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
	
	public boolean addingAccount(account newAccount){ //Signing Up
		String x,y;
		boolean unique = false;
		//get getConnection() from db
		Connection cnt = getConnection();
		x = newAccount.getUsername();
		y = newAccount.getPassword();
		
		
		String query2 = "SELECT * FROM swdespa.accounts WHERE username =('"+newAccount.getUsername()+"') AND password = ('"+newAccount.getPassword()+"')";

		//create string query
		
		try {
			
			PreparedStatement ps2 = getConnection().prepareStatement(query2);
		
			
			ResultSet rs = ps2.executeQuery();
	
			if(rs.next()) { //User already exists
				unique = true;
			}
			else {
				unique = false;
				String query = "insert into accounts values ('"+x+"','"+y+"')";
				PreparedStatement ps = getConnection().prepareStatement(query);
				ps.execute();		
				ps.close();
			}
			
			//close all the resources
			
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unique;
	}
	
	public boolean loggingAccount(account registeredAccount) { //Logging In
		Connection cnt = getConnection(); 
		boolean loggedIn = false;
		
		String query = "SELECT * FROM swdespa.accounts WHERE username = ('"+registeredAccount.getUsername()+"') AND password = ('"+registeredAccount.getPassword()+"');";
		
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				loggedIn = true;
			}
			else {
				loggedIn = false;
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return loggedIn;
		
	}
	
	public boolean artistloggingAccount(account registeredAccount)
	{
		Connection cnt = getConnection(); 
		boolean loggedIn = false;
		
		String query = "SELECT * FROM udc.artist WHERE username = ('"+registeredAccount.getUsername()+"') AND password = ('"+registeredAccount.getPassword()+"');";
		
		try {
			//create prepared statement
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				loggedIn = true;
			}
			else {
				loggedIn = false;
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			
		

		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return loggedIn;
		
	}

	public void writeBLOB(int SongID, String path) {
			
			Connection cnt = getConnection();
			FileInputStream input = null;
			PreparedStatement myStatement = null;
			
			String query = "INSERT INTO songData VALUES (?,?)";
			
			//create string qu
			
			try {
				myStatement = cnt.prepareStatement(query);
				
				File theSongFile = new File(path); //Place instead of song.getSongName()
				input = new FileInputStream(theSongFile);
				myStatement.setBinaryStream(2, input);
				myStatement.setInt(1, SongID);
				
				System.out.println("Reading the MP3 file: " + theSongFile.getAbsolutePath());
				System.out.println("Storing MP3 into the database " + theSongFile);
				System.out.println(query);
				
				myStatement.execute();
				
				myStatement.close();
	
			} catch (Exception ecx) {
				ecx.printStackTrace();
			} 
			
		}
	
	public void readBLOB(int SongID) {
		Connection cnt = getConnection();
		PreparedStatement myReadingStatement = null;
		
		String query = "SELECT data FROM songData WHERE SongID = ?;";
		ResultSet rs = null;
		
		try {
			myReadingStatement = cnt.prepareStatement(query);
			myReadingStatement.setInt(1, SongID);
			
			rs = myReadingStatement.executeQuery();
			
			File file = new File("currentSong.mp3");
			FileOutputStream output = new FileOutputStream(file);
			
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("data");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                input.close();
            }
            
            myReadingStatement.close();
            output.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}
	

	public void queryTemplate(String parameters) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String query = "SELECT * FROM accounts";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			//transform set into list
			while(rs.next()) {
				System.out.println(rs.getString("Username"));
				System.out.println(rs.getString("Password"));
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
	public ArrayList<Song> getSongs(String username) {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String query = "SELECT * FROM songs WHERE username = '"+username+"';";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Song> sl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Song newSong = new SongBuilder()
						 .setSongID(rs.getInt("SongID"))
						 .setUserName(rs.getString("Username"))
						 .setSongName(rs.getString("Title"))
						 .setArtistName(rs.getString("Artist"))
						 .setAlbum(rs.getString("Album"))
						 .setGenre(rs.getString("Genre"))
						 .setYear(rs.getString("Year"))
						 .setPath("")
						 .setCount(0)
						 .getSong();
				 sl.add(newSong);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return sl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public ArrayList<Playlist> getPlaylist(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				
				String query = "SELECT * FROM playlists WHERE username = '"+username+"';";
				//create string qu
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Playlist> pl = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Playlist newPlaylist = new PlaylistBuilder()
								 .setPlaylistName(rs.getString("playlistName"))
								 .setUsername(rs.getString("username"))
								 .getPlaylist();
						 pl.add(newPlaylist);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return pl;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}
	
	public ArrayList<Playlist> getFavoritePlaylist(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				String y = "1";
				String query = "SELECT * FROM user_playlists WHERE username = ('"+username+"') AND Favorite = ('"+y+"');";
				//create string query
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Playlist> pl = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Playlist newPlaylist = new PlaylistBuilder()
								 .setPlaylistName(rs.getString("playlistName"))
								 .setUsername(rs.getString("username"))
								 .getPlaylist();
						 pl.add(newPlaylist);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return pl;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}
	
	public ArrayList<Playlist> getPrivatePlaylist(String username){
		//get getConnection() from db
		Connection cnt = getConnection();
		String y = "1";
		String query = "SELECT * FROM user_playlists WHERE username = ('"+username+"') AND Privacy = ('"+y+"');";
		//create string query
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Playlist> pl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Playlist newPlaylist = new PlaylistBuilder()
						 .setPlaylistName(rs.getString("playlistName"))
						 .setUsername(rs.getString("username"))
						 .getPlaylist();
				 pl.add(newPlaylist);
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return pl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public ArrayList<Song> getFavoriteSong(String username){
		//get getConnection() from db
				Connection cnt = getConnection();
				String y = "1";
				String query = "SELECT * FROM songs WHERE username = ('"+username+"') AND Favorite = ('"+y+"');";
				//create string query
				
				try {
					//create prepared statement	
					PreparedStatement ps = cnt.prepareStatement(query);
					
					//get result and store in result set
					ResultSet rs = ps.executeQuery();
					
					ArrayList<Song> s = new ArrayList<>();
					//transform set into list
					while(rs.next()) {
						 Song newSong = new SongBuilder()
								 //.setSongName(rs.getString("songName"))
								 //.setUsername(rs.getString("username"))
								 .setSongName(rs.getString("title"))
								 .setUserName(rs.getString("username"))
								 .getSong();
						 s.add(newSong);
					}
					
					//close all the resources
					ps.close();
					rs.close();
					cnt.close();
					
					return s;

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null; 
	}

	public int addingSong(Song s){ //Signing Up
		String getSongName, getArtistName, getAlbumName, getGenre;
		String getYear, getUsername;
		int getCount;
		//get getConnection() from db
		Connection cnt = getConnection();
		getSongName = s.getSongName();
		getArtistName = s.getArtistName();
		getAlbumName = s.getAlbum();
		getGenre = s.getGenre();
		getYear = s.getYear();
		getUsername = s.getUserName();
		getCount = s.getCount();
		String x = s.getFavorite();
		
		
		String query = "insert into songs values ("+0+",'"+getSongName+"','" 
															+getArtistName+"','" 
															+getAlbumName+ "','"
															+getGenre+ "','"
															+getYear+"','"
															+getUsername+"','"
															+getCount+"','"
															+x+"')"; 
		

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int pk = rs.getInt(1);
			System.out.println(pk);
			//close all the resources
			ps.close();
			cnt.close();
			
			return pk;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public void countUpdate(int SongID) {
		Connection cnt = getConnection();
		PreparedStatement myReadingStatement = null;
		int ID = SongID;
		String query = "UPDATE swdespa.songs SET Play_Count = Play_Count + 1 WHERE SongID = ('"+ID+"');";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			
		}
	}

	
	public void addingPlaylist(Playlist p){
		String getPlaylistName, getUsername;
		
		
		//get getConnection() from db
		Connection cnt = getConnection();
		getPlaylistName = p.getPlaylistName();
		getUsername = p.getUsername();
		String x = "0";
		int y = 0;
		
		String query = "insert into playlists values ('"+y+"','"+getPlaylistName+"','"+getUsername+"')";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	
	public void addingUserPlaylist(Playlist p){ 
		String getPlaylistName, getUsername;
		int y = 0;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		getPlaylistName = p.getPlaylistName();
		getUsername = p.getUsername();
		String x = p.getFavorite(); // if favorite or not
		String z = p.getPrivacy();
		
		String query = "insert into user_playlists values ('"+y+"','"+getUsername+"','"+getPlaylistName+"','"+x+"', '"+z+"')";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void favoritingPlaylist(String PlaylistID, String PlaylistName){ 
		String ID = PlaylistID;
		String Name = PlaylistName;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if favorite or not
		String y = "1";
		
		
		String query = "UPDATE swdespa.user_playlists SET Favorite = ('"+y+"') WHERE Username = ('"+ID+"') AND PlaylistName = ('"+Name+"');";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void privacyPlaylist(String PlaylistIDPrivate, String PlaylistNamePrivate) {
		String ID = PlaylistIDPrivate;
		String Name = PlaylistNamePrivate;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if private or not
		String y = "1";
		
		
		String query = "UPDATE swdespa.user_playlists SET Privacy = ('"+y+"') WHERE Username = ('"+ID+"') AND PlaylistName = ('"+Name+"');";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	public void favoritingSong(String SongID, String SongName){ 
		String ID = SongID;
		String Name = SongName;
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
		String x = "0"; // if favorite or not
		String y = "1";
		
		
		String query = "UPDATE swdespa.songs SET Favorite = ('"+y+"') WHERE Username = ('"+ID+"') AND Title = ('"+Name+"');";
		System.out.println(ID);
		System.out.println(Name);

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
	//======================================================================================All editing
	public void editSongName(String username,String oldSongName, String newSongName){
		String userName = username;
		String oldSong = oldSongName;
		String newSong = newSongName;
		
	
		
		
		String query = "UPDATE swdespa.songs SET Title = ('"+newSong+"') WHERE username = ('"+username+"') AND Title = ('"+oldSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			//get result and store in result set
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editArtistName(String username,String oldSongName,String newSongName, String newArtistName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newArtist = newArtistName;
		
		String query = "UPDATE swdespa.songs SET Artist = ('"+newArtist+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editAlbumName(String username,String oldSongName, String newSongName, String newAlbumName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newAlbum = newAlbumName;
		
		String query = "UPDATE swdespa.songs SET Album = ('"+newAlbum+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editGenreName(String username,String oldSongName, String newSongName, String newGenreName){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newGenre = newGenreName;
		
		String query = "UPDATE swdespa.songs SET Genre = ('"+newGenre+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editYearDate(String username,String oldSongName, String newSongName, String newYearDate){
		String userName = username;
		String newSong = newSongName;
		String oldSong = oldSongName;
		String newYear = newYearDate;
		
		String query = "UPDATE swdespa.songs SET Year = ('"+newYear+"') WHERE username = ('"+username+"') AND Title = ('"+newSong+"');";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//======================================================================================All editing
	
	
	public void addingSongsInPlaylist(Playlist p, Song s){ 	
		int getPlaylistID;
		int getSongID; 
		String getPlaylistName;
		String getSongName;
		
		
		//get getConnection() from db
		Connection cnt = getConnection();
		
	//	getPlaylistID = 0;
		getPlaylistName = p.getPlaylistName();
		getSongID = 0;
		getSongName = s.getSongName();
		
		String query = "insert into user_playlists values ('"+0+"','"
																+getPlaylistName+"','"
																+getSongID+"','"
																+getSongName+"')";

		System.out.print(query);
		//create string query
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(query);
			ps.execute();
			
			//close all the resources
			ps.close();
			cnt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}
	
public ArrayList<Song> getSongsByGenre() {
		
		//get getConnection() from db
		Connection cnt = getConnection();
		String query = "SELECT * FROM songs ORDER BY genre";
		//create string qu
		
		try {
			//create prepared statement	
			PreparedStatement ps = cnt.prepareStatement(query);
			
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Song> sl = new ArrayList<>();
			//transform set into list
			while(rs.next()) {
				 Song newSong = new SongBuilder()
						 .setSongID(rs.getInt("SongID"))
						 .setUserName(rs.getString("Username"))
						 .setSongName(rs.getString("Title"))
						 .setArtistName(rs.getString("Artist"))
						 .setAlbum(rs.getString("Album"))
						 .setGenre(rs.getString("Genre"))
						 .setYear(rs.getString("Year"))
						 .setPath("")
						 .setCount(0)
						 .getSong();
				 sl.add(newSong);
				
			}
			
			//close all the resources
			ps.close();
			rs.close();
			cnt.close();
			
			return sl;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
	
public ArrayList<Song> getSongsByAlbum() {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs ORDER BY album";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> getSongsByYear() {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs ORDER BY year";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> getMostPlayed() {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs ORDER BY Play_Count DESC";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Playlist> gettingUserPlaylist(String username) {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM swdespa.user_playlists WHERE username = '"+username+"';";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Playlist> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Playlist newPlaylist = new PlaylistBuilder()
					 .setUsername(rs.getString("Username"))
					 .setPlaylistName(rs.getString("PlaylistName"))
					 .getPlaylist();
					 
			 sl.add(newPlaylist);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}

public ArrayList<Song> gettingSongs() {
	
	//get getConnection() from db
	Connection cnt = getConnection();
	
	String query = "SELECT * FROM songs";
	//create string qu
	
	try {
		//create prepared statement	
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//get result and store in result set
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Song> sl = new ArrayList<>();
		//transform set into list
		while(rs.next()) {
			 Song newSong = new SongBuilder()
					 .setSongID(rs.getInt("SongID"))
					 .setUserName(rs.getString("Username"))
					 .setSongName(rs.getString("Title"))
					 .setArtistName(rs.getString("Artist"))
					 .setAlbum(rs.getString("Album"))
					 .setGenre(rs.getString("Genre"))
					 .setYear(rs.getString("Year"))
					 .setPath("")
					 .setCount(0)
					 .getSong();
			 sl.add(newSong);
		}
		
		//close all the resources
		ps.close();
		rs.close();
		cnt.close();
		
		return sl;

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null; 
	
}
//	public void testerTemplate() {
//		String x = "dad";
//		String y = "d";
//		Connection cnt = getConnection(); 
//		String query = "SELECT * FROM accounts WHERE Username = ('"+x+"') AND Password = ('"+y+"')"; 
//		
//		try {
//			//create prepared statement
//			PreparedStatement ps = cnt.prepareStatement(query);
//			
//			//get result and store in result set
//			ResultSet rs = ps.executeQuery();
//			
//			//transform set into list
//			while(rs.next()) {
//				System.out.println(rs.getString("Username"));
//				System.out.println(rs.getString("Password"));
//			}
//			
//			//close all the resources
//			ps.close();
//			rs.close();
//			cnt.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//	}

}