package Client.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Client.Frame.PopUp.SignUp_blank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoRevisePanel extends JPanel {
	JPanel infor_panel = new JPanel();
	
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JButton home_btn;
	JLabel infor_title;
	JLabel input_label;
	JPasswordField pw_txt;
	JButton ok_btn;
	
	public InfoRevisePanel() {
		home_btn = new JButton("HOME");
		infor_title = new JLabel("비밀번호를 입력해주세요");
		input_label = new JLabel("비밀번호");
		pw_txt = new JPasswordField(10);
		ok_btn = new JButton("확인");
		
		infor_panel.setLayout(new BoxLayout(infor_panel, BoxLayout.Y_AXIS));
		
		// panel 0
		panel0.setLayout(new BorderLayout());
		home_btn.addActionListener(new InforAction());
		panel0.add(home_btn, BorderLayout.WEST);
		
		// panel 1
		panel1.setPreferredSize(new Dimension(450, 50));
		infor_title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel1.add(infor_title);
		
		// panel 2
		input_label.setFont(new Font("굴림", Font.PLAIN, 15));
		panel2.add(input_label);
		panel2.add(pw_txt);
		
		// panel 3
		ok_btn.addActionListener(new InforAction());
		panel3.add(ok_btn);
		
		infor_panel.add(panel0);
		infor_panel.add(Box.createVerticalStrut(80));
		infor_panel.add(panel1);
		infor_panel.add(Box.createVerticalStrut(30));
		infor_panel.add(panel2);
		infor_panel.add(Box.createVerticalStrut(30));
		infor_panel.add(panel3);
		add(infor_panel);
	}
	class InforAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("HOME")) {
				pw_txt.setText("");
				setVisible(false);
				MainFrame.turnPanel("홈");
			}else if(e.getActionCommand().equals("확인")) {
				if(pw_txt.getText().equals("")) {
					new SignUp_blank();
				}else {
					pw_txt.setText("");
					setVisible(false);
					MainFrame.turnPanel("정보수정입력");
					System.out.println("비밀번호 비교해서 ㅇㅇ");
				}
			}
		}
	}
}
