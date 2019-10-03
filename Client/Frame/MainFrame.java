package Client.Frame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import protocol.ArraySList;

import javax.swing.BoxLayout;

public class MainFrame extends JFrame {
	private static JPanel home_panel = new HomePanel();
	private static JPanel buy_panel = new BuyPanel();
	private static JPanel salereg_panel = new SaleRegisterPanel();
	private static JPanel mypage_panel = new MypagePanel();
	private static JPanel admin_panel = new AdminPanel();
	private static JPanel infor_panel = new InfoRevisePanel();
	private static JPanel infor_input_panel = new ReviseInfoInputPanel();
	private static JPanel wish_panel = new WishPanel();
	
	static int sizecheck = 0;
	
	JPanel mainpanel = new JPanel();
	
	public static void turnPanel(String s) {
		if(s.equals("홈")) {
			home_panel.setVisible(true);
			sizecheck = 0;
		}else if(s.equals("구매")) {
			ArraySList a = new ArraySList();
			a.setProtocol("H01");
			FrameManager.sender.Sender(a);
			home_panel.setVisible(false);
			buy_panel.setVisible(true);
			sizecheck = 1;
		}else if(s.equals("판매등록")) {
			home_panel.setVisible(false);
			salereg_panel.setVisible(true);
			sizecheck = 2;
		}else if(s.equals("마이페이지")) {
			home_panel.setVisible(false);
			mypage_panel.setVisible(true);
			sizecheck = 0;
		}else if(s.equals("판매관리")) {
			admin_panel.setVisible(true);
			sizecheck = 1;
		}else if(s.equals("정보수정")) {
			infor_panel.setVisible(true);
			sizecheck = 0;
		}else if(s.equals("정보수정입력")) {
			infor_input_panel.setVisible(true);
			sizecheck = 0;
		}else if(s.equals("관심상품")) {
			wish_panel.setVisible(true);
			sizecheck = 3;
		}
	}
	
	public MainFrame() {
		wish_panel.setVisible(false);
		infor_input_panel.setVisible(false);
		infor_panel.setVisible(false);
		admin_panel.setVisible(false);
		mypage_panel.setVisible(false);
		salereg_panel.setVisible(false);
		buy_panel.setVisible(false);
		home_panel.setVisible(true);
		
		mainpanel.add(wish_panel);
		mainpanel.add(infor_input_panel);
		mainpanel.add(infor_panel);
		mainpanel.add(admin_panel);
		mainpanel.add(mypage_panel);
		mainpanel.add(salereg_panel);
		mainpanel.add(buy_panel);
		mainpanel.add(home_panel);
		
		add(mainpanel);
		
		new Thread(new Resize()).start();
		setSize(500, 500);
		Dimension monitorsize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((monitorsize.width - this.getSize().width)/2 ,
				(monitorsize.height - this.getSize().height)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("평화로운 멀켐마켓");
		setVisible(true);
		setAlwaysOnTop(true);
		setResizable(false);
	}
	class Resize implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				if(sizecheck == 0) {
					setSize(500,500);
				}else if(sizecheck == 1){
					setSize(900,700);
				}else if(sizecheck == 2) {
					setSize(500,500);
				}else if(sizecheck == 3) {
					setSize(900, 500);
				}
			}
		}
	}
	
}
