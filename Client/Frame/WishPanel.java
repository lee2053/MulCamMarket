package Client.Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WishPanel extends JPanel {
	private final Object colNames1[] = {"번호", "제목", "판매 완료 여부", "삭제"};
	JPanel wish_panel = new JPanel();
	JPanel panel0 = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scroll;
	
	JButton home_btn;
	JLabel title_label;
	
	
	
	public WishPanel() {
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
		
        home_btn = new JButton("HOME");
        title_label = new JLabel("관심상품");
        
        wish_panel.setLayout(new BoxLayout(wish_panel, BoxLayout.Y_AXIS));
        
		// panel 0
        panel0.setLayout(new BorderLayout());
        home_btn.addActionListener(new WishAction());
        panel0.add(home_btn, BorderLayout.WEST);
        
        // panel 1
        title_label.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        panel1.add(title_label);
        
        // panel 2 
        scroll.setPreferredSize(new Dimension(700,250));
		panel2.setPreferredSize(new Dimension(700,260));
        panel2.add(scroll);
		
        
        
        
        
		wish_panel.add(panel0);
		wish_panel.add(panel1);
		wish_panel.add(Box.createVerticalStrut(40));
		wish_panel.add(panel2);
		add(wish_panel);
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
	class WishAction implements ActionListener{
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
