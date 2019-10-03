package Client.Frame.PopUp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;

public class login_fail extends JFrame {
	private final Action action = new SwingAction();

	public login_fail() {
//		getContentPane().setForeground(new Color(0, 0, 0));
//		getContentPane().setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(111, 140, 104, 31);
		getContentPane().add(btnNewButton);

		JLabel label = new JLabel("입력한 아이디와 비밀번호가 일치하지 않습니다.");
		label.setForeground(Color.RED);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setBackground(Color.BLACK);
		label.setBounds(30, 53, 271, 31);
		getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("아이디 또는 비밀번호를 다시 한번 입력해 주세요.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 79, 271, 25);
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
