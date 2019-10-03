package Client.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Font;

public class BuyPanel extends JPanel {
	private final Object colNames[] = {"번호", "제목", "등록날짜"};
	private final String category[] = {"전체", "교재", "식권", "필기도구", "전자기기", "기타"};
	
	JPanel buy_panel = new JPanel();
	
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel2_1 = new JPanel();
	JPanel panel3 = new JPanel();
	
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scroll;
	
	JButton home_btn;
	JLabel buy_title;
	JTextField search_txt;
	JButton search_btn;
	private JComboBox comboBox;
	
	
	public BuyPanel() {
		buy_panel.setLayout(new BoxLayout(buy_panel, BoxLayout.Y_AXIS));
		
		setTable();
		table = new JTable(dtm);
		scroll = new JScrollPane(table);
		
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCell(table));;
		table.getColumnModel().getColumn(1).setCellEditor(new TableCell(table));;
		
		table.setRowHeight(30);
		
		table.getColumnModel().getColumn(0).setMaxWidth(40); 
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setWidth(40);

        table.getColumnModel().getColumn(1).setMaxWidth(500); 
        table.getColumnModel().getColumn(1).setMinWidth(500);
        table.getColumnModel().getColumn(1).setWidth(500);
		//////////////////////////////////////////////////////////
		home_btn = new JButton("HOME");
        buy_title = new JLabel("판매 중인 상품");
        buy_title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		search_txt = new JTextField(10);
        search_btn = new JButton("검색");
        comboBox = new JComboBox(category);
        
        
        // panel 0 
        panel0.setLayout(new BorderLayout(0, 0));
        home_btn.addActionListener(new BuyAcyion());
        panel0.add(home_btn, BorderLayout.WEST);
		
        // panel 1
        panel1.add(buy_title);
        
        
        // panel 2
        panel2.setLayout(new BorderLayout());
        panel2_1.add(search_txt);
        search_btn.addActionListener(new BuyAcyion());
        panel2_1.add(search_btn);
        comboBox.addActionListener(new ComboAction());
        panel2_1.add(comboBox);
		panel2.add(panel2_1, BorderLayout.EAST);
		
		scroll.setPreferredSize(new Dimension(700,450));
		panel3.setPreferredSize(new Dimension(700,500));
		panel3.add(scroll);
		
		
		
		buy_panel.add(panel0);
		buy_panel.add(panel1);
		buy_panel.add(Box.createVerticalStrut(50));
		buy_panel.add(panel2);
		
		buy_panel.add(panel3);
		
		buy_panel.setPreferredSize(new Dimension(700,700));;
		add(buy_panel);
	}
	private void setTable() {
		int b = 1;
		ArrayList<Object> r = new ArrayList<>();
		ArrayList<ArrayList<Object>> q = new ArrayList<>();
        ArrayList<Object> t;    
        int n = 100;
        
        for(int i = 0; i < n; i++) {
        	t = new ArrayList<Object>();
        	t.add(b++);
        	t.add("데이터");
        	t.add(new Date());
        	q.add(t);
        }
        Object x[][] = new Object[n][3];
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < 3; j++) {
        		x[i][j] = q.get(i).get(j);
        	}
        }
        
		dtm = new DefaultTableModel(x, colNames);
	}
	
	class BuyAcyion implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("HOME")) {
				MainFrame.turnPanel("홈");
				setVisible(false);
			}else if(e.getActionCommand().equals("검색")) {
				System.out.println("ㅇㅇ");
				String str = search_txt.getText();
				// str로 리스트 제목 비교해서 출력하기
				panel3.updateUI();
			}
		}
	}
	
	class ComboAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox jcb = (JComboBox)e.getSource();
			int index = jcb.getSelectedIndex();
			
			if(index == 0) {				// 전체
				System.out.println("전체");
			}else if(index == 1) {			// 교재
				System.out.println("교재");
			}else if(index == 2) {			// 식권
				System.out.println("식권");
			}else if(index == 3) {			// 필기도구
				System.out.println("필기도구");
			}else if(index == 4) {			// 전자기기
				System.out.println("전자기기");
			}else if(index == 5) {			// 기타
				System.out.println("기타");
			}
		}
		
	}
	
	
}

