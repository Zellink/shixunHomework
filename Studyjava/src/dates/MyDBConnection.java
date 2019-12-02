package dates;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MyDBConnection{//连接类
 
	private String DBDriver;
	private String DBURL;
	private String DBUser;
	private String DBPass;
	private Connection conn=null;
	private Statement stmt=null;
	public MyDBConnection(){
		DBDriver="com.mysql.cj.jdbc.Driver";
		DBURL="jdbc:mysql://localhost:3306/info";
		 // DBURL = "jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC";
		DBURL="jdbc:mysql://localhost:3306/info?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
		DBUser="root";//用户名
		DBPass="1234";//数据库密码
		try{
			Class.forName(DBDriver);//加载驱动程序
			System.out.println("数据库驱动程序加载成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			conn=DriverManager.getConnection(DBURL,DBUser,DBPass);//取得连接对象
			stmt=conn.createStatement();//取得SQL语句对象
			System.out.print("连接数据库成功");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getMyConnection(){
		return conn;
	}
	public Statement getMyStatement(){
		return stmt;
	}
	public void closeMyConnection(){//关闭数据库连接
		try{
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public String toString(){
		return "数据库驱动程序"+DBDriver+"，链接地址"+DBURL+"，用户名"+DBUser+"，密码"+DBPass;
	}
}
