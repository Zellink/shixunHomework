package Chat;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateRoomPanel {
	
	private JFrame jframe;
	private JTextField nameText;

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
		nameLabel.setBounds(67, 10, 79, 41);
		panel.add(nameLabel);
		
		JLabel introduceLabel = new JLabel("聊天室介绍：");
		introduceLabel.setBounds(67, 61, 79, 35);
		panel.add(introduceLabel);
		
		nameText = new JTextField();
		nameText.setText("在此处输入聊天室的名字");
		nameText.setBounds(151, 15, 218, 31);
		panel.add(nameText);
		nameText.setColumns(10);
		
		JButton createButton = new JButton("创建聊天室");
		createButton.setBounds(192, 289, 127, 41);
		panel.add(createButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("在此处输入聊天室的介绍");
		textArea.setLineWrap(true);
		textArea.setBounds(151, 66, 218, 197);
		panel.add(textArea);
		
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				j.setEnabled(true);
			}
		});
		
		jframe.setVisible(true);
	}
}
