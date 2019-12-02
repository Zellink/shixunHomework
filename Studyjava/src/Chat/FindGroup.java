package Chat;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
//import java.util.
import dates.DBOperation;
import dates.MyDBConnection;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;


public class FindGroup implements ActionListener {
	private JFrame jframe;
	private JTextField nameText;
	JButton createButton = null;
	private MyDBConnection myDB=new MyDBConnection();
	DefaultListModel<String> listModel = new DefaultListModel<String>();

	ArrayList<group> grp ;
	JScrollPane centerPanel = new JScrollPane();
	private DBOperation opr = new DBOperation(myDB);
	public FindGroup(JFrame j) {
		jframe = new JFrame();
		jframe.setAlwaysOnTop(true);
		jframe.setResizable(false);
		jframe.setTitle("查询群聊");
		jframe.getContentPane().setLayout(new BorderLayout(0, 0));
		jframe.setSize(512, 396);
		jframe.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		

		 centerPanel = new JScrollPane();
		centerPanel.setBorder(new TitledBorder("查询结果聊天室"));
		centerPanel.setPreferredSize(new Dimension(50,50));
		centerPanel.setLocation(80,80);
		centerPanel.setSize(300,200);
		jframe.getContentPane().add(centerPanel);
		 listModel = new DefaultListModel<String>();
		 grp = opr.loadGroup( );
		
		
		
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("群名：");
		nameLabel.setBounds(67, 10, 79, 40);
		panel.add(nameLabel);
		
		
		
		nameText = new JTextField();
		nameText.setText("在此处输入查询内容   关键字查询");
		nameText.setBounds(151, 10, 218, 40);
		panel.add(nameText);
		
		
		
			
		
		
		
		 createButton = new JButton("查询");
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
			   listModel.removeAllElements();
			   String name = nameText.getText( );
			   ArrayList<group> grp = opr.findGroupName( name);
			   for(int i=0;i<grp.size( );i++) {
				   System.out.println(grp.get(i ));
			   }
			   //
			   for(int i=0;i<grp.size();i++) {
				   String groupname = grp.get( i).groupname;
					String portvlue= grp.get(i).port+"";
					String s=String.format("群名:%-30s  账号：%-30s", groupname,portvlue);
					String que = "   群描述:"+grp.get(i ).question;
					listModel.addElement( s );
					listModel.addElement( que);
				}
				
				JList<String> list = new JList<String>(listModel);
				list.setBorder(null);
				centerPanel.setViewportView(list);
			   
		   }
	   }  
}
