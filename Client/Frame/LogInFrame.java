package Client.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.Socket;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Client.Frame.PopUp.SignUp_ID;
import Client.Frame.PopUp.SignUp_IDoverlap;
import Client.Frame.PopUp.SignUp_blank;
import Client.Frame.PopUp.SignUp_class;
import Client.Frame.PopUp.SignUp_pass;
import Client.Frame.PopUp.SignUp_phone;
import Client.Frame.PopUp.SignUp_phone11;
import Client.Frame.PopUp.SignUp_pwfail;
import protocol.*;

public class LogInFrame extends JFrame{
	JPanel mainpanel = new JPanel();
	
	LogInPanel login_panel = new LogInPanel();
	SignupPanel signup_panel = new SignupPanel();
	FindID findid_panel = new FindID();
	FindPW findpw_panel = new FindPW();
	JPanel btn_panel = new JPanel();
	
	JButton login_btn = new JButton("로그인");
	JButton signup_btn = new JButton("회원가입");
	JButton Findid_btn = new JButton("ID 찾기");
	JButton Findpw_btn = new JButton("PW 찾기");
	
	public LogInFrame(boolean check) {
		if(check) setVisible(true);
	}
	
	public LogInFrame() {
		signup_panel.setVisible(false);
		findid_panel.setVisible(false);
		findpw_panel.setVisible(false);
		
		mainpanel.add(signup_panel);
		mainpanel.add(login_panel);
		mainpanel.add(findid_panel);
		mainpanel.add(findpw_panel);
		
		login_btn.setBackground(Color.green);
		login_btn.setForeground(Color.white);
		signup_btn.setBackground(new Color(0, 153, 255));
		signup_btn.setForeground(Color.white);
		Findid_btn.setBackground(new Color(102,102,102));
		Findid_btn.setForeground(Color.white);
		Findpw_btn.setBackground(new Color(102,102,102));
		Findpw_btn.setForeground(Color.white);
		login_btn.setFont(login_btn.getFont().deriveFont(15.0f));
		signup_btn.setFont(signup_btn.getFont().deriveFont(15.0f));
		Findid_btn.setFont(Findid_btn.getFont().deriveFont(15.0f));
		Findpw_btn.setFont(Findid_btn.getFont().deriveFont(15.0f));
		
		login_btn.addActionListener(new Loginaction());
		signup_btn.addActionListener(new Loginaction());
		Findid_btn.addActionListener(new Loginaction());
		Findpw_btn.addActionListener(new Loginaction());
		
		mainpanel.setBackground(new Color(240,240,240));
		
		btn_panel.setLayout(new GridLayout(2, 2, 10, 10));
		btn_panel.add(login_btn);
		btn_panel.add(signup_btn);
		btn_panel.add(Findid_btn);
		btn_panel.add(Findpw_btn);
		
		mainpanel.add(btn_panel);
		add(mainpanel);
		
		setSize(350, 500);
		// 화면 가운데 배치
		Dimension monitorsize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((monitorsize.width - this.getSize().width)/2 ,
				(monitorsize.height - this.getSize().height)/2);
		
		setBackground(new Color(240,240,240));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
	}
	class Loginaction implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("로그인")) {
				UserInfo p = new UserInfo();
				p.setProtocol("R01");
				p.setUserId(login_panel.ID_txt.getText());
				p.setPw(login_panel.PW_txt.getText());
				FrameManager.sender.Sender(p);
				// 프로토콜 받아서 성공하면 넘어가자
				login_panel.ID_txt.setText("");
				login_panel.PW_txt.setText("");
				FrameManager.turnFrame("main");
			}else if(e.getActionCommand().equals("회원가입")) {
				login_panel.setVisible(false);
				signup_panel.setVisible(true);
				btn_panel.setVisible(false);
			}else if(e.getActionCommand().equals("ID 찾기")) {
				System.out.println("ID 찾기");
				login_panel.setVisible(false);
				btn_panel.setVisible(false);
				findid_panel.setVisible(true);
			}else if(e.getActionCommand().equals("PW 찾기")) {
				System.out.println("Pw 찾기");
				login_panel.setVisible(false);
				btn_panel.setVisible(false);
				findpw_panel.setVisible(true);
			}
		}
	}
	
	public void reSizeFrame(int w, int h) {
		setSize(w, h);
		Dimension monitorsize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((monitorsize.width - this.getSize().width)/2 ,
				(monitorsize.height - this.getSize().height)/2);
	}
	
	class LogInPanel extends JPanel{
		JTextField ID_txt;
		JPasswordField PW_txt;
		public LogInPanel() {
			JPanel login_panel = new JPanel();
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JLabel title_label = new JLabel("MulCam Market");
			
			JLabel ID_label = new JLabel("ID");
			JLabel PW_label = new JLabel("PassWord");
			ID_txt = new JTextField(10);
			PW_txt = new JPasswordField(10);
			
			
			login_panel.setLayout(new BoxLayout(login_panel, BoxLayout.Y_AXIS));
			login_panel.setBackground(new Color(240,240,240));
			
			title_label.setForeground(new Color(0, 153, 255));
			title_label.setFont(new Font("Dialog", Font.BOLD, 30));
			// panel 1
			panel1.setBackground(new Color(240,240,240));
			panel1.add(title_label);
			
			// panel 2
			panel2.setBackground(new Color(240,240,240));
			panel2.setLayout(new GridLayout(2,2, 10, 10));
			panel2.add(ID_label);
			panel2.add(ID_txt);
			panel2.add(PW_label);
			panel2.add(PW_txt);
			
			login_panel.add(Box.createVerticalStrut(40));
			login_panel.add(panel1);
			login_panel.add(Box.createVerticalStrut(80));
			login_panel.add(panel2);
			login_panel.add(Box.createVerticalStrut(60));
			add(login_panel);
		}
	}
	
	class SignupPanel extends JPanel{
		JTextField ID_txt;
		JPasswordField PW_txt;
		JPasswordField checkPW_txt;
		JLabel checkPW_label_check;
		JTextField croom_txt;
		JTextField name_txt;
		JTextField phone_txt;
		boolean check = false;
		boolean pcheck = false;
		
		public SignupPanel() {
			JPanel signup_panel = new JPanel();
			JPanel panel0 = new JPanel();
			JPanel panel1 = new JPanel();
			JPanel panel2 = new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			JButton back_btn = new JButton("←");
			JLabel title_label = new JLabel("회원가입");
			JLabel ID_label = new JLabel("ID");
			JLabel PW_label = new JLabel("PassWord");
			JLabel checkPW_label = new JLabel("Password 확인");
			JLabel name_label = new JLabel("이름");
			JLabel phone_label = new JLabel("전화번호");
			JLabel croom_label = new JLabel("교육실");
			checkPW_label_check = new JLabel(" ");
			JLabel tmp1_label = new JLabel(" ");
			JLabel tmp2_label = new JLabel(" ");
			JLabel tmp3_label = new JLabel(" ");
			ID_txt = new JTextField(5);
			PW_txt = new JPasswordField(5);
			checkPW_txt = new JPasswordField(5);
			name_txt = new JTextField(5);
			phone_txt = new JTextField(5);
			
			croom_txt = new JTextField(5);
			JButton checkID_btn = new JButton("중복확인");
			JButton checkphone_btn = new JButton("중복확인 ");
			JButton signup_btn = new JButton("가입하기");
			
			signup_panel.setLayout(new BoxLayout(signup_panel, BoxLayout.Y_AXIS));

			// panel 0
			panel0.setLayout(new BorderLayout());
			back_btn.addActionListener(new SignUpAction());
			panel0.add(back_btn, BorderLayout.WEST);
			
			// panel 1
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(new Color(240,240,240));
			title_label.setForeground(new Color(0, 153,255));
			title_label.setFont(new Font("", Font.BOLD, 40));
			panel1.add(title_label);
			
			// panel 2
			panel2.setSize(500,500);
			panel2.setLayout(new GridLayout(3, 10, 10, 10));
			panel2.setBackground(new Color(240,240,240));
			panel2.add(ID_label);
			ID_txt.addKeyListener(new CheckID());
			panel2.add(ID_txt);
			checkID_btn.setPreferredSize(new Dimension(0,10));
			checkID_btn.setBackground(new Color(255,102,102));
			checkID_btn.setForeground(Color.white);
			checkID_btn.setFont(checkID_btn.getFont().deriveFont(11.0f));
			checkID_btn.addActionListener(new SignUpAction());
			panel2.add(checkID_btn);
			panel2.add(PW_label);
			PW_txt.addKeyListener(new CheckPWLabel());
			panel2.add(PW_txt);
			panel2.add(tmp1_label);
			panel2.add(checkPW_label);
			checkPW_txt.addKeyListener(new CheckPWLabel());
			panel2.add(checkPW_txt);
			panel2.add(checkPW_label_check);
			
			// panel 3
			panel3.setLayout(new GridLayout(3, 10, 10, 10));
			panel3.setBackground(new Color(240,240,240));
			panel3.add(name_label);
			panel3.add(name_txt);
			panel3.add(tmp2_label);
			panel3.add(phone_label);
			phone_txt.addKeyListener(new CheckPhone());
			panel3.add(phone_txt);
			checkphone_btn.setPreferredSize(new Dimension(0, 10));
			checkphone_btn.setBackground(new Color(255,102,102));
			checkphone_btn.setForeground(Color.white);
			checkphone_btn.setFont(checkID_btn.getFont().deriveFont(11.0f));
			checkphone_btn.addActionListener(new SignUpAction());
			panel3.add(checkphone_btn);
			panel3.add(croom_label);
			panel3.add(croom_txt);
			panel3.add(tmp3_label);
			
			// panel 4
			panel4.setBackground(new Color(240,240,240));
			signup_btn.setFont(new Font("", Font.BOLD, 20));
			signup_btn.setBackground(Color.green);
			signup_btn.setForeground(Color.white);
			signup_btn.addActionListener(new SignUpAction());
			panel4.add(signup_btn);
			
			signup_panel.add(panel0);
			signup_panel.add(Box.createVerticalStrut(20));
			signup_panel.add(panel1);
			signup_panel.add(Box.createVerticalStrut(50));
			signup_panel.add(panel2);
			signup_panel.add(Box.createVerticalStrut(10));
			signup_panel.add(panel3);
			signup_panel.add(Box.createVerticalStrut(40));
			signup_panel.add(panel4);
			add(signup_panel);
		}
		
		class SignUpAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("중복확인")) {
					if(ID_txt.getText().equals("")) {
						new SignUp_blank();
						check = false;
					}else if(checkID(ID_txt.getText()) == false) {
						new SignUp_ID();
						ID_txt.setText("");
						check = false;
					}else {
						// 입력정보 보내서 중복여부 확인하기
						// 중복여부 프레임 띄우기
						// 중복이 아니라면 check = true;
						UserInfo u = new UserInfo();
						u.setProtocol("R01");
						u.setUserId(ID_txt.getText());
						FrameManager.sender.Sender(u);
						check = true;
					}
				}else if(e.getActionCommand().equals("중복확인 ")){
					if(phone_txt.getText().equals("")) {
						new SignUp_blank();
						pcheck = false;
					}else if(phone_txt.getText().length() != 11) {
						phone_txt.setText("");
						new SignUp_phone11();
						pcheck = false;
					}else if(!isNumber(phone_txt.getText())) {
						phone_txt.setText("");
						pcheck = false;
						new SignUp_phone();
					}else {
						// 입력정보 보내서 중복여부 확인하기
						// 중복여부 프레임 띄우기
						// 중복이 아니라면 check = true;
						UserInfo u = new UserInfo();
						u.setProtocol("R02");
						u.setPhone(phone_txt.getText());
						FrameManager.sender.Sender(u);
						pcheck = true;
					}
				}else if(e.getActionCommand().equals("가입하기")){
					if(ID_txt.getText().equals("")) {
						new SignUp_blank();
					}else if(!check) {
						new SignUp_IDoverlap();
					}else if(checkID(ID_txt.getText()) == false) {
						new SignUp_ID();
						ID_txt.setText("");
					}else if(checkPW_label_check.getText().equals("불일치!")){
						 new SignUp_pwfail();
					}else if(name_txt.getText().equals("") || phone_txt.getText().equals("") || croom_txt.getText().equals("")){
						new SignUp_blank();
					}else if(phone_txt.getText().length() != 11) {
						new SignUp_phone11();
					}else if(!isNumber(phone_txt.getText())) {
						new SignUp_phone();
						phone_txt.setText("");
					}else if(!pcheck) {
						new SignUp_IDoverlap();
					}else if(!isNumber(croom_txt.getText())) {
						new SignUp_class();
						croom_txt.setText("");
					}else {
						UserInfo u = new UserInfo();
						u.setProtocol("R03");
						u.setUserId(ID_txt.getText());
						u.setPw(PW_txt.getText());
						Integer a =Integer.parseInt(croom_txt.getText()); 
						u.setcRoom(a);
						u.setPhone(phone_txt.getText());
						FrameManager.sender.Sender(u);
						ID_txt.setText("");
						PW_txt.setText("");
						checkPW_txt.setText("");
						checkPW_label_check.setText("");
						name_txt.setText("");
						phone_txt.setText("");
						croom_txt.setText("");
						check = false;
						pcheck = false;
						signup_panel.setVisible(false);
						login_panel.setVisible(true);
						btn_panel.setVisible(true);
						new SignUp_pass();
					}
				}else if(e.getActionCommand().equals("←")){
					ID_txt.setText("");
					PW_txt.setText("");
					checkPW_txt.setText("");
					checkPW_label_check.setText("");
					name_txt.setText("");
					phone_txt.setText("");
					croom_txt.setText("");
					signup_panel.setVisible(false);
					login_panel.setVisible(true);
					btn_panel.setVisible(true);
				}
			}
			public boolean checkID(String str) {
				boolean c = false;
				for(int i = 0; i < str.length(); i++) {
					int tmp = (int)str.charAt(i);
					if(tmp > 0)
						c = true;
					if((tmp >= 45 && tmp <= 57) || (tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122))
						c = true;
					else {
						c = false;
						break;
					}
				}
				return c;
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
		class CheckID extends KeyAdapter{
			public void keyReleased(KeyEvent e) {
				check = false;
			}
		}
		class CheckPhone extends KeyAdapter{
			public void keyReleased(KeyEvent e) {
				pcheck = false;
			}
		}
		class CheckPWLabel extends KeyAdapter{
			public void keyReleased(KeyEvent e) {
				if(!checkPW_txt.getText().equals(PW_txt.getText())) {
					checkPW_label_check.setForeground(Color.red);
					checkPW_label_check.setText("불일치!");
				}else {
					checkPW_label_check.setForeground(new Color(0,204,0));
					checkPW_label_check.setText("일치!");
				}
			}
		}
	}
	
	class FindID extends JPanel{
		JPanel findid_panel_ = new JPanel();
		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel title_label;
		JButton back_btn;
		JLabel fname_label;
		JLabel fphone_label;
		JTextField fname_txt;
		JTextField fphone_txt;
		JButton find_btn;
		
		public FindID() {
			title_label = new JLabel("ID 찾기");
			back_btn = new JButton("←");
			fname_label = new JLabel("이름");
			fphone_label = new JLabel("전화번호");
			fname_txt = new JTextField(10);
			fphone_txt = new JTextField(10);
			find_btn = new JButton("찾기");
			
			findid_panel_.setLayout(new BoxLayout(findid_panel_, BoxLayout.Y_AXIS));
			
			// panel 0
			panel0.setLayout(new BorderLayout());
			back_btn.addActionListener(new FindIdAction());
			panel0.add(back_btn, BorderLayout.WEST);
			
			// panel 1
			title_label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			panel1.add(title_label);
			
			// panel 2
			panel2.setLayout(new GridLayout(2, 2, 10, 15));
			panel2.add(fname_label);
			panel2.add(fname_txt);
			panel2.add(fphone_label);
			panel2.add(fphone_txt);
			
			// panel 3
			find_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			find_btn.addActionListener(new FindIdAction());
			panel3.add(find_btn);
			
			findid_panel_.add(panel0);
			findid_panel_.add(Box.createVerticalStrut(50));
			findid_panel_.add(panel1);
			findid_panel_.add(Box.createVerticalStrut(60));
			findid_panel_.add(panel2);
			findid_panel_.add(Box.createVerticalStrut(50));
			findid_panel_.add(panel3);
			add(findid_panel_);
		}
		class FindIdAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("←")) {
					fname_txt.setText("");
					fphone_txt.setText("");
					setVisible(false);
					login_panel.setVisible(true);
					btn_panel.setVisible(true);
				}else if(e.getActionCommand().equals("찾기")) {
					if(fname_txt.getText().equals("") || fphone_txt.equals("")) {
						new SignUp_blank();
					}else if(!isNumber(fphone_txt.getText())) {
						new SignUp_phone();
					}else if(fphone_txt.getText().length() != 11) {
						new SignUp_phone11();
					}else {
						System.out.println("서버로 전송해서 찾은 여부 확인하자");
						UserInfo u = new UserInfo();
						u.setProtocol("F01");
						u.setUserId(fname_txt.getText());
						u.setUname(fphone_txt.getText());
						FrameManager.sender.Sender(u);
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
	}
	class FindPW extends JPanel{
		JPanel findpw_panel_ = new JPanel();
		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel title_label;
		JButton back_btn;
		JLabel fid_label;
		JLabel fname_label;
		JLabel fphone_label;
		JTextField fid_txt;
		JTextField fname_txt;
		JTextField fphone_txt;
		JButton find_btn;
		
		public FindPW() {
			title_label = new JLabel("PW 찾기");
			back_btn = new JButton("←");
			fid_label = new JLabel("ID");
			fname_label = new JLabel("이름");
			fphone_label = new JLabel("전화번호");
			fid_txt = new JTextField(10);
			fname_txt = new JTextField(10);
			fphone_txt = new JTextField(10);
			find_btn = new JButton("찾기");
			
			findpw_panel_.setLayout(new BoxLayout(findpw_panel_, BoxLayout.Y_AXIS));
			
			// panel 0
			panel0.setLayout(new BorderLayout());
			back_btn.addActionListener(new FindPwAction());
			panel0.add(back_btn, BorderLayout.WEST);
			
			// panel 1
			title_label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			panel1.add(title_label);
			
			// panel 2
			panel2.setLayout(new GridLayout(3, 2, 10, 15));
			panel2.add(fid_label);
			panel2.add(fid_txt);
			panel2.add(fname_label);
			panel2.add(fname_txt);
			panel2.add(fphone_label);
			panel2.add(fphone_txt);
			
			// panel 3
			find_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			find_btn.addActionListener(new FindPwAction());
			panel3.add(find_btn);
			
			findpw_panel_.add(panel0);
			findpw_panel_.add(Box.createVerticalStrut(50));
			findpw_panel_.add(panel1);
			findpw_panel_.add(Box.createVerticalStrut(60));
			findpw_panel_.add(panel2);
			findpw_panel_.add(Box.createVerticalStrut(50));
			findpw_panel_.add(panel3);
			add(findpw_panel_);
		}
		class FindPwAction implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals("←")) {
					setVisible(false);
					fid_txt.setText("");
					fname_txt.setText("");
					fphone_txt.setText("");
					login_panel.setVisible(true);
					btn_panel.setVisible(true);
				}else if(e.getActionCommand().equals("찾기")) {
					if(fid_txt.getText().equals("") || fname_txt.getText().equals("") || fphone_txt.equals("")) {
						new SignUp_blank();
					}else if(!isNumber(fphone_txt.getText())) {
						new SignUp_phone();
					}else if(fphone_txt.getText().length() != 11) {
						new SignUp_phone11();
					}else {
						System.out.println("서버로 전송해서 찾은 여부 확인하자");
						UserInfo u = new UserInfo();
						u.setProtocol("F02");
						u.setUserId(fid_txt.getText());
						u.setUname(fname_txt.getText());
						u.setPhone(fphone_txt.getText());
						FrameManager.sender.Sender(u);
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
	}
}


