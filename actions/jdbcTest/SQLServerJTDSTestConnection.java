package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTestConnection {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException{
		return SQLServerConnUtils.getSQLServerConnection();
		
	}
	
	public static void main (String[]args)throws SQLException, ClassNotFoundException{
		System.out.println("Get connection...");
		
		Connection conn = SQLServerJTDSTestConnection.getMyConnection();
		System.out.println("Opened connection: " + conn);
		Statement statement = conn.createStatement();
		String sql ="Select * From [automationtest].[dbo].[Product_type];";
		
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			//di chuyen con tro xuong ban ghi tiep theo
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			
			System.out.println("---------------");
			System.out.println("Emp FirstName:" + empFirstName);
			System.out.println("Emp LastName:" + empLastName);
		}
		
		conn.close();
		System.out.println("-----Closed connection");
	}

}
