package mysql_enroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class conn_db{
	Connection con;
	String url = null;
	//Statement stmt;
	
	public void connection() throws ClassNotFoundException{
		url = "jdbc:mysql://localhost:3306/wang?"
				+ "user=root & password=883883 & useUnicode=true & characterEnunicode=UTF8";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			System.out.println("连接成功");
			//stmt = con.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) throws ClassNotFoundException {
//		conn_db conn = new conn_db();
//		conn.connection();
//		
//	}
}
