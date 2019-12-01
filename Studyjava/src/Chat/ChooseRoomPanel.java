package Chat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ChooseRoomPanel {
	
	private JFrame jframe;
	private JPanel southPanel;
	private JPanel northPanel;

	public static void main(String[] args) {
		new ChooseRoomPanel();
	}
	
	public ChooseRoomPanel() {
		jframe = new JFrame();
		jframe.setTitle("聊天室选择");
		jframe.setSize(512, 396);
		jframe.setIconImage(Toolkit.getDefaultToolkit().createImage(Server.class.getResource("qq.png")));
		southPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 5));
		
		JButton joinButton = new JButton("加入聊天室");
		southPanel.add(joinButton, BorderLayout.NORTH);
		jframe.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JButton refreshBotton = new JButton("刷新");
		northPanel.add(refreshBotton);
		
		JLabel k1 = new JLabel("");
		northPanel.add(k1);
		
		JLabel welcome = new JLabel("     聊天室");
		northPanel.add(welcome);
		
		JLabel k2 = new JLabel("");
		northPanel.add(k2);
		
		JButton loginoutBotton = new JButton("退出登录");
		northPanel.add(loginoutBotton);
		
		JButton findButton = new JButton("查询聊天室");
		southPanel.add(findButton, "South");
		
		JButton createButton = new JButton("创建聊天室");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				new CreateRoomPanel(jframe);
			}
		});
		southPanel.add(createButton);
		jframe.getContentPane().add(southPanel, BorderLayout.SOUTH);
		jframe.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setBorder(new TitledBorder("现有聊天室"));
		jframe.getContentPane().add(centerPanel);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("聊天室1");
		listModel.addElement("聊天室2");
		JList<String> list = new JList<String>(listModel);
		list.setBorder(null);
		centerPanel.setViewportView(list);
		
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);// 退出程序
			}
		});
		
		jframe.setVisible(true);
	}
}