package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DAOConnector {
	
	public Connection conn;
	public static DAOConnector db;
	
	private DAOConnector()
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Rapizz";
		String driver = "com.mysql.jdbc.Driver";
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");
		
		try {
	            Class.forName(driver).newInstance();
	            this.conn = (Connection)DriverManager.getConnection(url+dbName,properties);
	        }
	        catch (Exception sqle) {
	            sqle.printStackTrace();
	        }
	 }
	
	public static synchronized DAOConnector getConnection() {
        if ( db == null ) {
            db = new DAOConnector();
        }
        return db;
    }
	
}
	

