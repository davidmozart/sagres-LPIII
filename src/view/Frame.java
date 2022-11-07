package view;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Frame() {
		super ("Sagres");
		setResizable(false);
		this.setSize(700, 385);
		this.setVisible(true);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		repaint();
		validate();
		setVisible(true);
	}
}
