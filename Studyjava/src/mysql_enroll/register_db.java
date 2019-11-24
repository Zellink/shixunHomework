package mysql_enroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.swing.*;
 
public class register_db extends conn_db implements ActionListener{
 
	JTextField textacc,textname;
	JButton okButton,resetButton;
	Statement stmt;
	ResultSet rs;
//	double acc;
//	String name;
//	Connection con = null;
	
	public void setaccountField(JTextField a){
		textacc = a;
	}
	public void setnameField(JTextField n){
		textname = n;
	}
	public void setokButton(JButton b1){
		okButton = b1;
	}
	public void setresetButton(JButton b2){
		resetButton = b2;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == okButton){
			if(textacc.getText().equals(""))			//判断用户输入是否为空；
				JOptionPane.showMessageDialog(null, "请输入账号","警告对话框",JOptionPane.WARNING_MESSAGE);
			else if(textname.getText().equals(""))
				JOptionPane.showMessageDialog(null,"请输入姓名","警告对话框",JOptionPane.WARNING_MESSAGE);
			else{
				String acc = textacc.getText();
				String name = textname.getText();
				try {
					connection();
					writeInSql(acc,name);
				} catch (Exception e1) {
					System.out.println("插入失败");
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == resetButton){
			textacc.setText("");
			textname.setText("");
		}
	}
	
	void writeInSql(String acc,String name) throws Exception{
		String sql;
		
		Connection con = super.con;
		Statement stmt = con.createStatement();
		
		//创建并检查数据库表，若没有"my"表，则创建表并执行插入操作，若表已存在，则直接执行操作，插入数据
		sql = "create table if not exists my(account varchar(10),name varchar(20))";
		
		stmt.executeUpdate(sql);
//		System.out.println(sql);		//查错；
		System.out.println("创建表成功");	
		
		//插入存文本框中获取的数据；
		sql = "insert into my(account,name) values('"+acc+"','"+name+"')";
		int rw = stmt.executeUpdate(sql);
//		System.out.println(sql);
		if(rw <= 0){				//判断数据是否插入成功
			JOptionPane.showMessageDialog(null,"注册失败");
		}
		else{
			JOptionPane.showMessageDialog(null, "注册成功");
		}
	}
}
