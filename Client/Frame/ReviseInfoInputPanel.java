package Client.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Client.Frame.PopUp.SignUp_IDoverlap;
import Client.Frame.PopUp.SignUp_blank;
import Client.Frame.PopUp.SignUp_class;
import Client.Frame.PopUp.SignUp_phone;
import Client.Frame.PopUp.SignUp_phone11;
import Client.Frame.PopUp.SignUp_pwfail;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ReviseInfoInputPanel extends JPanel {
	JPanel rinfo_panel = new JPanel();
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	
	JButton home_btn;
	JLabel title_label;
	JLabel pw_label;
	JPasswordField pw_txt;
	JLabel pw_check_label;
	JPasswordField pw_check_txt;
	JLabel check_label;
	JLabel phone_label;
	JTextField phone_txt;
	JLabel address_label;
	JTextField address_txt;
	JLabel name_label;
	JTextField name_txt;
	JLabel tmp1_label;
	JLabel tmp2_label;
	JLabel tmp3_label;
	
	JButton phone_check;
	JButton revise_btn;
	
	public ReviseInfoInputPanel() {
		home_btn = new JButton("HOME");
		title_label = new JLabel("회원 정보 수정");
		pw_label = new JLabel("PassWord");
		pw_check_label = new JLabel("PassWord 확인");
		phone_label = new JLabel("전화번호");
		address_label = new JLabel("교육실");
		name_label = new JLabel("이름");
		pw_txt = new JPasswordField(10);
		pw_check_txt = new JPasswordField(10);
		phone_txt = new JTextField(10);
		address_txt = new JTextField(10);
		name_txt = new JTextField(10);
		revise_btn = new JButton("수정");
		phone_check = new JButton("중복확인");
		check_label = new JLabel("");
		tmp1_label = new JLabel("");
		tmp2_label = new JLabel("");
		tmp3_label = new JLabel("");
		rinfo_panel.setLayout(new BoxLayout(rinfo_panel, BoxLayout.Y_AXIS));
		
		// panel 0
		panel0.setLayout(new BorderLayout());
		home_btn.addActionListener(new ReviseAction());
		panel0.add(home_btn, BorderLayout.WEST);
		
		// panel 1
		title_label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel1.add(title_label);
		
		// panel 2
		panel2.setLayout(new GridLayout(3, 3, 10, 10));
		panel2.add(pw_label);
		pw_txt.addKeyListener(new CheckPWLabel2());
		panel2.add(pw_txt);
		panel2.add(tmp1_label);
		panel2.add(pw_check_label);
		pw_check_txt.addKeyListener(new CheckPWLabel2());
		panel2.add(pw_check_txt);
		panel2.add(check_label);
		panel2.add(phone_label);
		panel2.add(phone_txt);
		phone_check.setPreferredSize(new Dimension(0,10));
		phone_check.setBackground(new Color(255,102,102));
		phone_check.setForeground(Color.white);
		phone_check.setFont(phone_check.getFont().deriveFont(11.0f));
		phone_check.addActionListener(new ReviseAction());
		panel2.add(phone_check);
		
		// panel 3
		panel3.setLayout(new GridLayout(2,3,10,10));
		panel3.add(address_label);
		panel3.add(address_txt);
		panel3.add(tmp2_label);
		panel3.add(name_label);
		panel3.add(name_txt);
		panel3.add(tmp3_label);
		
		// panel 4
		revise_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		revise_btn.addActionListener(new ReviseAction());
		panel4.add(revise_btn);
		
		rinfo_panel.add(panel0);
		rinfo_panel.add(Box.createVerticalStrut(30));
		rinfo_panel.add(panel1);
		rinfo_panel.add(Box.createVerticalStrut(50));
		rinfo_panel.add(panel2);
		rinfo_panel.add(Box.createVerticalStrut(10));
		rinfo_panel.add(panel3);
		rinfo_panel.add(Box.createVerticalStrut(30));
		rinfo_panel.add(panel4);
		add(rinfo_panel);
	}
	class ReviseAction implements ActionListener{
		boolean pcheck = false; 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("HOME")) {
				pw_txt.setText("");
				pw_check_txt.setText("");
				check_label.setText("");
				phone_txt.setText("");
				address_txt.setText("");
				name_txt.setText("");
				setVisible(false);
				MainFrame.turnPanel("홈");
			}else if(e.getActionCommand().equals("중복확인")) {
				if(phone_txt.getText().equals("")) {
					new SignUp_blank();
					pcheck = false;
				}else {
					System.out.println("비밀번호 전송해서 중복여부 확인!");
					pcheck = true;
				}
			}else {
				if(pw_txt.getText().equals("") || pw_check_txt.getText().equals("")) {
					new SignUp_blank();
				}else if(check_label.getText().equals("불일치!")) {
					new SignUp_pwfail();
				}else if(phone_txt.getText().equals("") || address_txt.getText().equals("")|| name_txt.getText().equals("")) {
					new SignUp_blank();
				}else if(!isNumber(phone_txt.getText())) {
					new SignUp_phone();
				}else if(phone_txt.getText().length() != 11) {
					new SignUp_phone11();
				}else if(!isNumber(address_txt.getText())) {
					new SignUp_class();
				}else if(!pcheck) {
					new SignUp_IDoverlap();
				}else {
					// 서버로 넘기고 저장하기
					System.out.println("서버로 비밀번호 넘겨");
					pcheck = false;
				}
			}
		}
		public boolean isNumber(String str_num) {
			try {
				double str = Double.parseDouble(str_num);
			}catch(NumberFormatException e) {
				return false;
			}
			return true;
		}
	}
	class CheckPWLabel2 extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
			if(!pw_txt.getText().equals(pw_check_txt.getText())) {
				check_label.setForeground(Color.red);
				check_label.setText("불일치!");
			}else {
				check_label.setForeground(new Color(0,204,0));
				check_label.setText("일치!");
			}
		}
	}
}
