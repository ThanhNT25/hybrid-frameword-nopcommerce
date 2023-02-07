package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {

	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPERESS";
		String dbName ="automationtest";
		String userName ="sa";
		String password ="pass";
		return getSQLServerConnection(hostName,sqlInstanceName,dbName,userName,password);
	}
	
	public static Connection getSQLServerConnection(String hostName,String sqlInstanceName, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.sourceforge.jtds.jdbc.Driver");
			String connectionURL = "jdbc:jtds:sqlserver://"+ hostName + ":1433/" + dbName + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL,userName,password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
