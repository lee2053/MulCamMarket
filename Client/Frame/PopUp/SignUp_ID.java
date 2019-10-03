package Client.Frame.PopUp;

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

public class SignUp_ID extends JFrame {
	private final Action action = new SwingAction();

	public SignUp_ID() {
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

		JLabel lblNewLabel = new JLabel("ID는 대문자/소문자/숫자만");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(67, 51, 215, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblD = new JLabel("입력 가능합니다.");
		lblD.setForeground(Color.RED);
		lblD.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblD.setBounds(67, 79, 138, 31);
		getContentPane().add(lblD);

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
