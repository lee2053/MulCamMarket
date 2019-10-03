package Client.Frame;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Client.Frame.PopUp.Register_nocategory;
import Client.Frame.PopUp.Register_nodetail;
import Client.Frame.PopUp.Register_notitle;
import Client.Frame.PopUp.Sale_Status;
import Client.Frame.PopUp.Sale_price;

import javax.swing.JComboBox;

public class SaleRegisterPanel extends JPanel {
	private final String category[] = {"선택하세요", "교재", "식권", "필기도구", "전자기기", "기타"};
	String ct;
	
	JPanel salereg_panel = new JPanel();
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JButton home_btn;
	JLabel salereg_title;
	JButton reg_btn;
	JButton cancel_btn;
	private JTextField rtitle_txt;
	private JTextField rprice_txt;
	private JTextField rstate_txt;
	JTextArea detailarea;
	JComboBox comboBox;
	
	
	public SaleRegisterPanel() {
		salereg_panel.setLayout(new BoxLayout(salereg_panel, BoxLayout.Y_AXIS));
		home_btn = new JButton("HOME");
		salereg_title = new JLabel("판매 등록");
		reg_btn = new JButton("등록");
		cancel_btn = new JButton("취소");
		
		
		JLabel rtitle_label = new JLabel("제목");
		JLabel rcategory_label = new JLabel("카테고리");
		JLabel rprice_label = new JLabel("가격");
		JLabel rstate_label = new JLabel("상태");
		JLabel grade = new JLabel("/ 10");
		JLabel rdetail_label = new JLabel("세부내용");
		JLabel rdetail2_label = new JLabel("(500자 이하)");
		rtitle_txt = new JTextField();
		rprice_txt = new JTextField();
		rstate_txt = new JTextField();
		
		
		// panel 0
		panel0.setLayout(new BorderLayout());
		home_btn.addActionListener(new RegAction());
		panel0.add(home_btn, BorderLayout.WEST);
		
		// panel 1
		salereg_title.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		panel1.add(salereg_title);
		
		// panel 2
		panel2.setLayout(null);
		panel2.setPreferredSize(new Dimension(400,300));
		
		rtitle_label.setFont(new Font("새굴림", Font.BOLD, 15));
		rcategory_label.setFont(new Font("새굴림", Font.BOLD, 15));
		rprice_label.setFont(new Font("새굴림", Font.BOLD, 15));
		rstate_label.setFont(new Font("새굴림", Font.BOLD, 15));
		grade.setFont(new Font("새굴림", Font.BOLD, 15));
		rdetail_label.setFont(new Font("새굴림", Font.BOLD, 15));
		rdetail2_label.setFont(new Font("새굴림", Font.BOLD, 13));
		
		rtitle_label.setBounds(49, 22, 30, 40);
		rcategory_label.setBounds(32, 72, 70, 30);
		rprice_label.setBounds(49, 112, 30, 30);
		rstate_label.setBounds(49, 152, 30, 30);
		grade.setBounds(172, 160, 57, 15);
		rdetail_label.setBounds(32, 192, 70, 30);
		rdetail2_label.setBounds(22, 215, 91, 30);
		
		rtitle_txt.setBounds(114, 32, 235, 21);
		rprice_txt.setBounds(114, 117, 80, 21);
		rstate_txt.setBounds(114, 157, 46, 21);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 200, 274, 100);
		
		detailarea = new JTextArea();
		scrollPane.setViewportView(detailarea);
		detailarea.setBackground(Color.white);
		detailarea.setEditable(true);
		
		comboBox = new JComboBox(category);
		comboBox.setBounds(114, 77, 91, 21);
		comboBox.addActionListener(new SelectComboAction());
		
		panel2.add(rtitle_label);
		panel2.add(rcategory_label);
		panel2.add(rprice_label);
		panel2.add(rstate_label);
		panel2.add(grade);
		panel2.add(rdetail_label);
		panel2.add(rdetail2_label);
		panel2.add(rtitle_txt);
		panel2.add(rprice_txt);
		panel2.add(rstate_txt);
		panel2.add(scrollPane);
		panel2.add(comboBox);
		
		
		// panel 3
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		
		reg_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		reg_btn.setForeground(new Color(255, 255, 255));
		reg_btn.setBackground(new Color(102, 153, 255));
		cancel_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cancel_btn.setForeground(new Color(255, 255, 255));
		cancel_btn.setBackground(new Color(255, 51, 51));
		
		reg_btn.addActionListener(new RegAction());
		cancel_btn.addActionListener(new RegAction());
		
		panel3.add(reg_btn);
		panel3.add(Box.createHorizontalStrut(40));
		panel3.add(cancel_btn);
		
		
		salereg_panel.add(panel0);
		salereg_panel.add(panel1);
		salereg_panel.add(panel2);
		salereg_panel.add(Box.createVerticalStrut(30));
		salereg_panel.add(panel3);
		add(salereg_panel);
	}
	class RegAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("등록")) {
				if(rtitle_txt.getText().equals("")) {
					new Register_notitle();
				}else if(!isNumber(rprice_txt.getText())) {
					new Sale_price();
				}else if(!checkState(rstate_txt.getText())) {
					new Sale_Status();
				}else if(detailarea.getText().equals("")){
					new Register_nodetail();
				}else if(ct == null) {
					new Register_nocategory();
				}else {
					System.out.println("등록 완료!");
					// 서버로 전송하기
					rtitle_txt.setText("");
					rprice_txt.setText("");
					rstate_txt.setText("");
					detailarea.setText("");
					comboBox.setSelectedIndex(0);
				}
			}else if(e.getActionCommand().equals("취소") || e.getActionCommand().equals("HOME")) {
				rtitle_txt.setText("");
				rprice_txt.setText("");
				rstate_txt.setText("");
				detailarea.setText("");
				comboBox.setSelectedIndex(0);
				setVisible(false);
				MainFrame.turnPanel("홈");
			}
		}
		public boolean isNumber(String str_num) {
			try {
				if(!str_num.isEmpty()) {
					double str = Double.parseDouble(str_num);
				}
			}catch(NumberFormatException e) {
				return false;
			}
			return true;
		}
		public boolean checkState(String str_num) {
			try {
				if(!str_num.isEmpty()) {
					double str = Double.parseDouble(str_num);
					if(str >= 0 && str <= 10) return true;
					else return false;
				}else return true;
			}catch(NumberFormatException e) {
				return false;
			}
		}
	}
	class SelectComboAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox jcb = (JComboBox)e.getSource();
			int index = jcb.getSelectedIndex();
			if(index == 0) {
				ct = null;
				System.out.println("카테고리 선택!!");
			}
			else if(index == 1) {			// 교재
				ct = "교재";
				System.out.println(ct);
			}else if(index == 2) {			// 식권
				ct = "식권";
				System.out.println(ct);
			}else if(index == 3) {			// 필기도구
				ct = "필기도구";
				System.out.println(ct);
			}else if(index == 4) {			// 전자기기
				ct = "전자기기";
				System.out.println(ct);
			}else if(index == 5) {			// 기타
				ct = "기타";
				System.out.println(ct);
			}
		}
	}
}
