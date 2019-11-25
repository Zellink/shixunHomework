package mysql_enroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.swing.*;
 
public class login_db extends conn_db implements ActionListener {
	JTextField accT,nameT;
	JButton okB,registB;
	register re;
	ResultSet rs;
	
	public void setaccountT(JTextField a){
		accT = a;
	}
	public void setnameT(JTextField n){
		nameT = n;
	}
	public void setButton(JButton b1,JButton b2){
		okB = b1;
		registB = b2;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == okB){
			if(accT.getText().equals(""))			//判断用户输入是否为空；
				JOptionPane.showMessageDialog(null, "请填写账号！");
			else if(nameT.getText().equals(""))
				JOptionPane.showMessageDialog(null, "请输入姓名");
			else{
				String accountT = accT.getText();
				String namesT = nameT.getText();
				try {
					connection(); 		//加载conn_db类，连接数据库；
					boolean com = compareWithSql(accountT,namesT);
					if(com)
						JOptionPane.showMessageDialog(null, "登录成功");
					else{
						JOptionPane.showMessageDialog(null, "账号或姓名不正确，请重新输入");
						accT.setText("");
						nameT.setText("");
					}
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == registB){
			new JFrame().dispose();
			re = new register();
		}
	}
	
	//用户输入检查
	boolean compareWithSql(String accountT,String namesT) throws Exception{
		String sql;		
		Connection con = super.con;
		Statement stmt = con.createStatement();
		sql = "select * from my";
//		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		while(rs.next()){				//用户输入的信息和数据库中的信息做比较，判断输入是否正确；
			String acc = rs.getString(1);
			String names = rs.getString(2);
			if(acc.equals(accountT) && names.equals(namesT)){
				//break;
				return true;
			}
//			System.out.println(acc + "   " + names);
//			System.out.println(accountT + "   " + namesT);
			
		}
//		System.out.println("hahahaha");
		return false;
		
	}
	
}