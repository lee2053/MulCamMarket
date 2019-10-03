package Client.Frame.PopUp;
//관심상품 추가시
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Post_fail extends JFrame {
	private final Action action = new SwingAction();

	public Post_fail() {                                                          
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(111, 140, 104, 31);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("이미 등록된 항목입니다.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(80, 66, 242, 44);
		getContentPane().add(lblNewLabel);

		setVisible(true);
		setSize(350, 250);
		setTitle("");
		setAlwaysOnTop(true);
		
		Dimension monitorsize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((monitorsize.width - this.getSize().width) / 2,
				(monitorsize.height - this.getSize().height) / 2);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
	}
}
