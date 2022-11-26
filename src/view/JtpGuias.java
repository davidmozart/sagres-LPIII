package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class JtpGuias extends JTabbedPane{
	
	public JtpGuias() {
		setTabPlacement(JTabbedPane.LEFT);
		this.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setBorder(null);
		this.setBackground(new Color(228, 228, 228));
		this.setForegroundAt(0, new Color(0, 0, 0));
	}
	
}
