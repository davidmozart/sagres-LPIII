package view;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FramePrincipal extends JFrame {



	public FramePrincipal() {
		setResizable(false);
		//setLayout(null);
		setSize(new Dimension(900, 700));
		setLocationRelativeTo(null);
		setTitle("Sagres");
		repaint();
		validate();
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
