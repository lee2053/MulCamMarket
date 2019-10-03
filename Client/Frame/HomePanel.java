package Client.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class HomePanel extends JPanel {
	JLabel title_label = new JLabel("멀캠마켓");
	JButton buy_btn;
	JButton sale_btn;
	JButton mypage_btn;
	JButton logout_btn;
	public HomePanel() {
		JPanel home_panel = new JPanel();
		
		JPanel panel0 = new JPanel();
		JPanel panel1 = new JPanel();
		buy_btn = new JButton("구매");
		sale_btn = new JButton("판매등록");
		mypage_btn = new JButton("마이페이지");
		logout_btn = new JButton("로그아웃");
		home_panel.setLayout(new BoxLayout(home_panel, BoxLayout.Y_AXIS));
		
		
		// panel1
		title_label.setForeground(new Color(102, 153, 255));
		title_label.setFont(new Font("휴먼모음T", Font.BOLD, 40));
		panel0.add(title_label);
		
		// panel2
		panel1.setLayout(new GridLayout(2, 2, 50, 30));
		buy_btn.setPreferredSize(new Dimension(100, 50));
		buy_btn.setBackground(new Color(204, 204, 204));
		buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		buy_btn.addActionListener(new BtnAction());
		panel1.add(buy_btn);
		sale_btn.setBackground(new Color(204, 204, 204));
		sale_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		sale_btn.addActionListener(new BtnAction());
		panel1.add(sale_btn);
		mypage_btn.setBackground(new Color(204, 204, 204));
		mypage_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		mypage_btn.addActionListener(new BtnAction());
		panel1.add(mypage_btn);
		logout_btn.setPreferredSize(new Dimension(130, 50));
		logout_btn.setForeground(new Color(255, 255, 255));
		logout_btn.setBackground(new Color(255, 0, 0));
		logout_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		logout_btn.addActionListener(new BtnAction());
		panel1.add(logout_btn);
		
		
		
		
		home_panel.add(Box.createVerticalStrut(80));
		home_panel.add(panel0);
		home_panel.add(Box.createVerticalStrut(70));
		home_panel.add(panel1);
		home_panel.add(Box.createVerticalStrut(30));
		add(home_panel);
	}
	class BtnAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("구매")) {
				MainFrame.turnPanel("구매");
			}else if(e.getActionCommand().equals("판매등록")) {
				MainFrame.turnPanel("판매등록");
			}else if(e.getActionCommand().equals("마이페이지")) {
				MainFrame.turnPanel("마이페이지");
			}else if(e.getActionCommand().equals("로그아웃")) {
				FrameManager.turnFrame("logout");
			}
		}
		
	}

}
