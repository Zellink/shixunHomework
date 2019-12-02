package dates;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import Chat.*;
import Chat.group;
public class DBOperation{
	private MyDBConnection myDB=null;
	private Connection conn=null;
	private Statement stmt=null;
	private int scores;
	private int number1=0;
	private int number2=0;
	private String name;
	private String password;
	PreparedStatement pstmt=null;
	public DBOperation(MyDBConnection myDB){
		conn=myDB.getMyConnection();//取得对象
		stmt=myDB.getMyStatement();//取得sql语句
	}
	/*
	public static void findName(String s) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from player where name =?");
			pstmt.setString(1, s);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString( "password");
				System.out.println(name+"  "+password);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace( );
		}
		
		
	}*/
	public void createGroupChat(int port,String password ,String groupowner,String groupname,String question) {
		//PreparedStatement pstmt = conn.prepareStatement("insert into groupChat values(?,?,?,?); " );
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into groupChat values(?,?,?,?,?); " );
			pstmt.setInt( 1, port);
			pstmt.setString( 2, password);
			pstmt.setString( 3, groupowner);
			pstmt.setString(4, groupname);
			pstmt.setString(5,question);
			if(findGroup(port)) {
				System.out.print("创建群失败，群已经创建过");
				return ;
			}
			pstmt.execute( );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	public ArrayList<group> loadGroup(){
		ArrayList<group> gro= new ArrayList<group>();
		try {
			String sql = "select port,password,groupowner,groupname ,question from groupChat;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next( )) {
				int por = rs.getInt("port");
				String paw = rs.getString("password");
				String gon = rs.getString("groupowner");
				String gna = rs.getString( "groupname");
				String que = rs.getString("question");
				//group g = new group(por,paw,gon,gna,que);
				gro.add(new group(por,paw,gon,gna,que));
				//group(int por,String paw,String gon,String gna,String que)
			}
			return gro;
		}
		catch(Exception e) {
			e.printStackTrace( );
		}
		return gro;
	}
	public  boolean findGroup(int port) {
		try {
			pstmt = conn.prepareStatement( "select * from groupChat where port = ?");
			pstmt.setInt(1,port);
			ResultSet rs = pstmt.executeQuery( );
			if(rs.next()) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			e.printStackTrace( );
		}
		return false;
	}
	
	public  String getPassword(int port) {
		try {
			pstmt = conn.prepareStatement( "select * from groupChat where port = ?");
			pstmt.setInt(1,port);
			ResultSet rs = pstmt.executeQuery( );
			if(rs.next()) {
				String psw = rs.getString( "password");
				return psw;
			}
			return null;
		}
		catch(Exception e) {
			e.printStackTrace( );
		}
		return null;
	}
	public boolean deleteGroup(int port) {
		try {
			pstmt = conn.prepareStatement( "delete from groupChat where port = ?");
			if(this.findGroup( port)) {
				System.out.println("无端口号");
			}
			pstmt.setInt( 1, port);
			pstmt.execute( );
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<group> findGroupName(String name) {
		ArrayList<group> gro = new ArrayList<group>();
		try {
			pstmt = conn.prepareStatement("select * from groupChat where groupname like ?");
			name = '%'+name +'%';
			//System.out.println(name);
			pstmt.setString( 1, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next( )) {
				int por = rs.getInt("port");
				String paw = rs.getString("password");
				String gon = rs.getString("groupowner");
				String gna = rs.getString( "groupname");
				String que = rs.getString("question");
				gro.add(new group(por,paw,gon,gna,que));
			}
			return gro;
		}
		catch(Exception e) {
			e.printStackTrace( );
		}
		return gro;
	}
	public void insertData(String name,String password,int scores){
		try{
			String newType1=new String(name.getBytes(),"GBK");//字节转码
			String newType2=new String(password.getBytes(),"GBK");
			String sql="INSERT INTO player(scores,name,password)VALUES("+scores+",'"+newType1+"','"+newType2+"')";
			//System.out.println( sql);
			stmt.executeUpdate(sql);//更新语句
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}
	public void deleteData(int scores){
		String sql="DELETE FROM player WHERE scores="+scores+"";
		System.out.print(sql);
		try{
			stmt.executeUpdate(sql);
			//System.out.println("一条记录被删除");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void updateData(int mscores,int scores,String name,String password){//修改
		String sql="UPDATE player SET scores="+scores+",name='"+name+"',password='"+password+"'where scores="+mscores+"&&name='"+name+"'&&password='"+password+"'";
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public boolean  selectPassword(String mpassword){//查询密码
		String sql="SELECT scores,name,password FROM player";
		try{
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				password=rs.getString("password");
				number2++;
				//System.out.print(rs.getString("password")+"  ");
				if(password.equals(mpassword)&&(number2==number1)){
					//System.out.print("number2:"+number2);
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean selectName(String mname){//查询id
		String sql="SELECT scores,name,password FROM player";
		try{
			ResultSet rs=stmt.executeQuery(sql);//返回结果集
			while(rs.next()){//指针向后移动
				name=rs.getString("name");
				number1++;
				if(name.equals(mname)){
					//System.out.print("number1:"+number1);
					return true;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public int getScores(){
		return scores;
	}
	public String getName(){
		return name;
	}
	public String getPassword(){
		return password;
	}
	
	public void setNumber1(){
		number1=0;
	}
	public void setNumber2(){
		number2=0;
	}
	/*
	public static void main(String [] args) {
		MyDBConnection my=new MyDBConnection();
		DBOperation myopr = new DBOperation(my);
		
		//myopr.showtable("ktj");
		System.out.println(myopr.findGroup( 2222));
		myopr.deleteGroup( 2222);
		System.out.println(myopr.findGroup( 2222));
		myopr.createGroupChat(2222,"1234","aaa","bbb","1+1=?");
		System.out.println(myopr.findGroup( 2222));
		ArrayList<group> gro = myopr.loadGroup( );
		gro = myopr.findGroupName("a");
		for(int i=0;i<gro.size( );i++) {
			System.out.println(gro.get(i ));
		}
		
		//myopr.showtable("");
		my.closeMyConnection( );
	}*/
}