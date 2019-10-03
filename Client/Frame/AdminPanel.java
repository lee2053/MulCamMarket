package Client.Frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class AdminPanel extends JPanel {
	private final Object colNames1[] = {"번호", "제목", "수정", "삭제", "완료"};
	private final Object colNames2[] = {"번호", "제목", "판매 완료 날짜"};
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private JTable table;
	private JTable table2;
	private JScrollPane scroll;
	private JScrollPane scroll2;
	
	JPanel admin_panel = new JPanel();
	
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	JButton home_btn;
	JLabel title_label;
	JLabel ongoing_label;
	JLabel complete_label;
	
	
	public AdminPanel() {
		home_btn = new JButton("HOME");
		title_label = new JLabel("판매관리");
		ongoing_label = new JLabel("      판매 진행중인 상품");
		complete_label = new JLabel("      판매 완료 내역");
		
		setTable1();
		table = new JTable(dtm);
		scroll = new JScrollPane(table);
		
		table.setRowHeight(30);
		
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCell(table));;
		table.getColumnModel().getColumn(1).setCellEditor(new TableCell(table));;
		
		table.getColumnModel().getColumn(0).setMaxWidth(40); 
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(0).setWidth(40);

        table.getColumnModel().getColumn(1).setMaxWidth(500); 
        table.getColumnModel().getColumn(1).setMinWidth(500);
        table.getColumnModel().getColumn(1).setWidth(500);
        
		//
        setTable2();
		table2 = new JTable(dtm2);
		scroll2 = new JScrollPane(table2);
		
		table2.setRowHeight(30);
		
		table2.getColumnModel().getColumn(1).setCellRenderer(new TableCell(table2));;
		table2.getColumnModel().getColumn(1).setCellEditor(new TableCell(table2));;
		
		table2.getColumnModel().getColumn(0).setMaxWidth(40); 
        table2.getColumnModel().getColumn(0).setMinWidth(40);
        table2.getColumnModel().getColumn(0).setWidth(40);

        table2.getColumnModel().getColumn(1).setMaxWidth(500); 
        table2.getColumnModel().getColumn(1).setMinWidth(500);
        table2.getColumnModel().getColumn(1).setWidth(500);
        //
        
		admin_panel.setLayout(new BoxLayout(admin_panel, BoxLayout.Y_AXIS));
		
		// panel 0
		panel0.setLayout(new BorderLayout());
		home_btn.addActionListener(new adminaction());
		panel0.add(home_btn, BorderLayout.WEST);
		
		// panel 1
		title_label.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		panel1.add(title_label);
		
		// panel 2
		panel2.setLayout(new BorderLayout());
		ongoing_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel2.add(ongoing_label, BorderLayout.WEST);
		
		// panel 3
		scroll.setPreferredSize(new Dimension(700,180));
		panel3.setPreferredSize(new Dimension(700,190));
		panel3.add(scroll);
		
		// panel 4
		panel4.setLayout(new BorderLayout());
		complete_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		panel4.add(complete_label, BorderLayout.WEST);
		
		// panel 5
		scroll2.setPreferredSize(new Dimension(700, 180));
		panel5.setPreferredSize(new Dimension(700,190));
		panel5.add(scroll2);
		
		admin_panel.add(panel0);
		admin_panel.add(panel1);
		admin_panel.add(Box.createVerticalStrut(50));
		admin_panel.add(panel2);
		admin_panel.add(panel3);
		admin_panel.add(Box.createVerticalStrut(20));
		admin_panel.add(panel4);
		admin_panel.add(panel5);
		add(admin_panel);
	}
	private void setTable1() {
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
        
		dtm = new DefaultTableModel(x, colNames1);
	}
	private void setTable2() {
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
        
		dtm2 = new DefaultTableModel(x, colNames2);
	}
	class adminaction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("HOME")) {
				setVisible(false);
				MainFrame.turnPanel("홈");
			}
		}
	}
}
