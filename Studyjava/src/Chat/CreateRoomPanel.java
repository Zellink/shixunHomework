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
public class CreateRoomPanel  implements ActionListener {
	
	private JFrame jframe;
	private JTextField nameText;
	private JTextField pswText;
	private JTextArea textArea ;
	//private JTextField textArea;
	JButton createButton = null;
	private MyDBConnection myDB=new MyDBConnection();
	//private Connection conn= new Connection(myDB);
	private DBOperation opr = new DBOperation(myDB);
	public CreateRoomPanel(JFrame j) {
		jframe = new JFrame();
		jframe.setAlwaysOnTop(true);
		jframe.setResizable(false);
		jframe.setTitle("创建聊天室");
		jframe.getContentPane().setLayout(new BorderLayout(0, 0));
		jframe.setSize(512, 396);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("聊天室名字：");
		nameLabel.setBounds(67, 10, 79, 40);
		panel.add(nameLabel);
		
		JLabel passwordLabel = new JLabel("群密码:");
		passwordLabel.setBounds( 67,60,79,40);
		panel.add( passwordLabel);
		
		JLabel introduceLabel = new JLabel("聊天室介绍：");
		introduceLabel.setBounds(67, 110, 79, 40);
		panel.add(introduceLabel);
		
		
		
		nameText = new JTextField();
		nameText.setText("在此处输入聊天室的名字");
		nameText.setBounds(151, 10, 218, 40);
		panel.add(nameText);
		nameText.setColumns(10);
		
		pswText = new JTextField();
		pswText.setText("请输入密码");
		pswText.setBounds(151,60,218,40);
		panel.add(pswText);
		
		textArea = new JTextArea();
		textArea.setText("在此处输入聊天室的介绍  或者  问题");
		textArea.setLineWrap(true);
		textArea.setBounds(151, 110, 218, 80);
		panel.add(textArea);
		
		 createButton = new JButton("创建聊天室");
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
			  // nameText.copy( );
			   //nameText.paste( );
			   String groupname = nameText.getText( );
			   System.out.println(groupname );
			   String password = pswText.getText( );
			   System.out.println( password );
			   String question = textArea.getText( );
			   System.out.println( groupname+" "+password+" "+question);
			   int port = (int)(Math.random( )*1000) +6000;
			   String groupowner = "null";
			   if(password.contentEquals("请输入密码")) {
				   password = "1234";
			   }
			   while(opr.findGroup(port)) {
				   port = (int)(Math.random( )*1000) +6000;
			   }
			   opr.createGroupChat(port, password, groupowner, groupname, question);
			   System.out.println(port+" "+opr.findGroup( port));
		   }
	   }  
}
