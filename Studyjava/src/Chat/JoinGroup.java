package Chat;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
//import java.util.
import dates.DBOperation;
import dates.MyDBConnection;


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class JoinGroup implements ActionListener {
	private JFrame jframe;
	private JTextField portText;
	private JTextField pswText;
	private JTextArea textArea ;
	//private JTextField textArea;
	JButton createButton = null;
	private MyDBConnection myDB=new MyDBConnection();
	//private Connection conn= new Connection(myDB);
	private DBOperation opr = new DBOperation(myDB);
	public JoinGroup(JFrame j) {
		jframe = new JFrame();
		jframe.setAlwaysOnTop(true);
		jframe.setResizable(false);
		jframe.setTitle("加入群聊");
		jframe.getContentPane().setLayout(new BorderLayout(0, 0));
		jframe.setSize(512, 396);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("群账号：");
		nameLabel.setBounds(67, 10, 79, 40);
		panel.add(nameLabel);
		
		JLabel passwordLabel = new JLabel("群密码:");
		passwordLabel.setBounds( 67,60,79,40);
		panel.add( passwordLabel);
		
		
		
		portText = new JTextField();
		portText.setText("在此处输入聊天室的账号");
		portText.setBounds(151, 10, 218, 40);
		panel.add(portText);
		//portText.setColumns(10);
		
		pswText = new JTextField();
		pswText.setText("请输入密码    //提示：群聊无密码，则为初始密码  1234");
		pswText.setBounds(151,60,218,40);
		panel.add(pswText);
		
		
		
		 createButton = new JButton("加入群聊");
		createButton.setBounds(151, 289, 218, 41);
		createButton.addActionListener(this );
		panel.add(createButton);
		
		
		
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				j.setEnabled(true);
			}
		});
		
		jframe.setVisible(true);
	}
	
	 public void actionPerformed(ActionEvent e) {  
		   if(e.getSource() == createButton) {
			   String  port = portText.getText( );
			   System.out.println(port );
			   String password = pswText.getText( );
			   System.out.println( password );
			   //String question = textArea.getText( );
			   System.out.println( port+" "+password+" ");
			   int portvalue = Integer.parseInt(port);
			   String passwordfromDB = opr.getPassword(portvalue);
			   System.out.println( passwordfromDB+" "+portvalue);
			   if(passwordfromDB.contentEquals(password)) {
				   System.out.println("启动客户端");
				   //启动客户端
			   }
			   else {
				   System.out.println( "密码错误");
				   //提示
			   }
		   }
	   }  
}
