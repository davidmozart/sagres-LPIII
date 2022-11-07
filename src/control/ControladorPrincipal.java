package control;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import view.JpDashboard;
import view.JpProfessor;
import view.JtpGuias;

@SuppressWarnings("serial")
public class ControladorPrincipal extends Frame implements ActionListener, WindowListener{

	private static ControladorPrincipal instancia;
	
	private JpDashboard dashboard;
	private static JpProfessor professor;
	private JtpGuias guiaPaineis;
	
	private ControladorPrincipal() {
		// TODO Auto-generated constructor stub
		addEventos();
	}
	
	public void addEventos() {
		getGuiaPaineis();		
		
	}
	
	
	
	public JtpGuias getGuiaPaineis() {
		guiaPaineis = new JtpGuias();
		guiaPaineis.addTab("Dashboard", null, getDashboard(), null);
		guiaPaineis.addTab("Professor", null, professor, null);
		return guiaPaineis;
	}
	


	public JpDashboard getDashboard() {
		return dashboard;
	}


	public static JpProfessor getProfessor() {
		return professor;
	}


	public static synchronized ControladorPrincipal getInstance() {
		if (instancia == null) {
			instancia = new ControladorPrincipal();
			instancia.addWindowListener(instancia);
		} 
		return instancia;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
