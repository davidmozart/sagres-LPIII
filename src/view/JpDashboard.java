package view;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class JpDashboard extends JPanel {
	private JPanel panel;
	private JLabel lblBemVindo;

	/**
	 * Create the panel.
	 */
	public JpDashboard() {
		this.setName("");
		this.setLayout(null);
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(119, 104, 255));
			panel.setBounds(0, 0, 893, 62);
			panel.add(getLblBemVindo());
		}
		return panel;
	}
	private JLabel getLblBemVindo() {
		if (lblBemVindo == null) {
			lblBemVindo = new JLabel("SAGRES");
			lblBemVindo.setForeground(Color.WHITE);
			lblBemVindo.setFont(new Font("URW Bookman L", Font.BOLD, 38));
			lblBemVindo.setBackground((Color) null);
			lblBemVindo.setBounds(370, 12, 174, 31);
		}
		return lblBemVindo;
	}
}
