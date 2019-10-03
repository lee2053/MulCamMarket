package Client.Frame;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MypagePanel extends JPanel {
	JPanel mypage_panel = new JPanel();
	
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton home_btn;
	JLabel title_label;
	JButton admin_btn;
	JButton infor_btn;
	JButton wish_btn;
	
	public MypagePanel() {
		home_btn = new JButton("HOME");
		title_label = new JLabel("마이 페이지");
		admin_btn = new JButton("판매관리");
		infor_btn = new JButton("정보수정");
		wish_btn = new JButton("관심상품");
		
		mypage_panel.setLayout(new BoxLayout(mypage_panel, BoxLayout.Y_AXIS));
		
		// panel 0
		panel0.setLayout(new BorderLayout());
		home_btn.addActionListener(new MypageAction());
		panel0.add(home_btn, BorderLayout.WEST);
		
		// panel 1
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(Box.createHorizontalStrut(100));
		title_label.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		panel1.add(title_label);
		panel1.add(Box.createHorizontalStrut(100));
		
		// panel 2
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		admin_btn.setAlignmentX(CENTER_ALIGNMENT);
		infor_btn.setAlignmentX(CENTER_ALIGNMENT);
		wish_btn.setAlignmentX(CENTER_ALIGNMENT);
		admin_btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		infor_btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		wish_btn.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		admin_btn.addActionListener(new MypageAction());
		infor_btn.addActionListener(new MypageAction());
		wish_btn.addActionListener(new MypageAction());
		panel2.add(admin_btn);
		panel2.add(Box.createVerticalStrut(25));
		panel2.add(infor_btn);
		panel2.add(Box.createVerticalStrut(25));
		panel2.add(wish_btn);
		
		mypage_panel.add(panel0);
		mypage_panel.add(Box.createVerticalStrut(40));
		mypage_panel.add(panel1);
		mypage_panel.add(Box.createVerticalStrut(70));
		mypage_panel.add(panel2);
		add(mypage_panel);
	}
	class MypageAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("HOME")) {
				setVisible(false);
				MainFrame.turnPanel("홈");
			}else if(e.getActionCommand().equals("판매관리")) {
				setVisible(false);
				MainFrame.turnPanel("판매관리");
			}else if(e.getActionCommand().equals("정보수정")) {
				setVisible(false);
				MainFrame.turnPanel("정보수정");
			}else if(e.getActionCommand().equals("관심상품")) {
				setVisible(false);
				MainFrame.turnPanel("관심상품");
			}
		}
	}
}
