package mysql_enroll;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.*;
 
public class register extends JFrame{
	JLabel accountLabel,nameLabel;
	JButton okButton,resetButton;
	JTextField accountText,nameText;
	Box baseBox1,baseBox2, box1,box2,box3;		 //此注册页面采用Box布局方式；
	//JPanel pane1,pane2;
	
	register_db regist;
	
	register(){
		init();
	}
	
	
	void init(){
		setLayout(new FlowLayout());
		accountLabel = new JLabel("账号");
		nameLabel= new JLabel("姓名");
		accountText = new JTextField(10);
		nameText = new JTextField(20);
		okButton = new JButton("确定");
		resetButton = new JButton("重置");
		
		regist = new register_db();
		
//		lab = new JLabel("用户注册页面");
		
		box1 = Box.createVerticalBox();
		box1.add(accountLabel);
		box1.add(Box.createVerticalStrut(8));
		box1.add(nameLabel);
		box2 = Box.createVerticalBox();
		box2.add(accountText);
		box2.add(Box.createVerticalStrut(8));
		box2.add(nameText);
		box3 = Box.createHorizontalBox();
		box3.add(okButton);
		box3.add(Box.createHorizontalStrut(15));
		box3.add(resetButton);
		baseBox1 = Box.createHorizontalBox();
		baseBox1.add(box1);
		baseBox1.add(Box.createHorizontalStrut(8));
		baseBox1.add(box2);
		baseBox2 = Box.createVerticalBox();
		baseBox2.add(baseBox1);
		baseBox2.add(Box.createVerticalStrut(10));
		baseBox2.add(box3);
		add(baseBox2);
		
		okButton.addActionListener(regist);
		resetButton.addActionListener(regist);
		
		
		regist.setaccountField(accountText);
		regist.setnameField(nameText);
		regist.setokButton(okButton);
		regist.setresetButton(resetButton);
		
		setBounds(200,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("用户注册界面");
	}
	
//	void registAction(){
//		
//	}
	
	
//	public static void main(String[] args) {
//		register re = new register();
//	}
	
}
