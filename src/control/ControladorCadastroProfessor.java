package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.Professor;
import view.CadastroProfessor;
import view.JpCadastroProfessor;

@SuppressWarnings("serial")
public class ControladorCadastroProfessor extends CadastroProfessor implements ActionListener, WindowListener{
	private static ControladorCadastroProfessor instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();
	private static JpCadastroProfessor painelCadastroProfessor;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Professor professor;
	

	public ControladorCadastroProfessor() {
		// TODO Auto-generated constructor stub
		addEventos();
	}

	private void addEventos() {
		// TODO Auto-generated method stub
		getContentPane().add(painelCadastroProfessor);
	}
	public static synchronized ControladorCadastroProfessor getInstance() {
		instancia = new ControladorCadastroProfessor();
		instancia.addWindowListener(instancia);
		return instancia;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		contPrin.setEnabled(false);		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		contPrin.setEnabled(true);
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
		contPrin.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == painelCadastroProfessor.getBtnAdicionar()) {
			
			String dataNascimento= sdf.format(painelCadastroProfessor.getDCNascimento().getDate());
			String dataAdmissao = sdf.format(painelCadastroProfessor.getDCAdmissao().getDate());
			try {
				professor = new Professor();
				professor.setCpf(painelCadastroProfessor.getTfCpf().getText());
				professor.setRg(painelCadastroProfessor.getTfIdentidade().getText());
				professor.setNome(painelCadastroProfessor.getTfNomeProfessor().getText());
				professor.setData_nasc(dataNascimento);
				professor.setNome_mae(painelCadastroProfessor.getTfNomeMae().getText());
				professor.setNome_pai(painelCadastroProfessor.getTfNomePai().getText());
				professor.setData_adm(dataAdmissao);
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Erro: " + e1.getMessage());
			}
		} else if (e.getSource() == painelCadastroProfessor.getBtnCancelar()) {
			this.dispose();
			contPrin.setEnabled(true);
		}
	}

}
