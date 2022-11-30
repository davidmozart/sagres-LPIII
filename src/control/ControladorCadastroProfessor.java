package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import model.Professor;
import model.dao.DaoFactory;
import model.dao.ProfessorDao;
import view.CadastroProfessor;
import view.JpCadastroProfessor;

@SuppressWarnings("serial")
public class ControladorCadastroProfessor extends CadastroProfessor implements ActionListener, WindowListener{
	private static ControladorCadastroProfessor instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();
	
	private JpCadastroProfessor painelCadastroProfessor;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Professor professor;
	
	public static synchronized ControladorCadastroProfessor getInstance() {
		instancia = new ControladorCadastroProfessor();
		instancia.addWindowListener(instancia);
		return instancia;
	}

	public ControladorCadastroProfessor() {
		// TODO Auto-generated constructor stub
		addEventos();
	}

	private void addEventos() {
		// TODO Auto-generated method stub
		setContentPane(painelCadastroProfessor());
		//getContentPane().add();
	}

	private JpCadastroProfessor painelCadastroProfessor() {
		if (painelCadastroProfessor == null) {
			painelCadastroProfessor = new JpCadastroProfessor();
			painelCadastroProfessor.remove(painelCadastroProfessor.getBtnPesquisar());
		}
		painelCadastroProfessor.getBtnAdicionar().addActionListener(this);
		painelCadastroProfessor.getBtnCancelar().addActionListener(this);
		return painelCadastroProfessor;
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
			
			try {				
				//
				if (painelCadastroProfessor.getTfCpf().getText().isEmpty() && 
						painelCadastroProfessor.getTfIdentidade().getText().isEmpty() &&
						painelCadastroProfessor.getTfNomeProfessor().getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Campos Obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				else if(ValidaCpf.isCPF(painelCadastroProfessor.getTfCpf().getText())) {
					String dataNascimento= sdf.format(painelCadastroProfessor.getDCNascimento().getDate());
					String dataAdmissao = sdf.format(painelCadastroProfessor.getDCAdmissao().getDate());
					Calendar dataNasc = Calendar.getInstance();
					dataNasc.setTime(painelCadastroProfessor.getDCNascimento().getDate()); 
					Calendar dataAdm = Calendar.getInstance();
					dataAdm.setTime(painelCadastroProfessor.getDCAdmissao().getDate());
					professor = new Professor(); 
					int idade = dataAdm.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
					if (idade > 17) {
						ProfessorDao professorDao = DaoFactory.createProfessorDao();
						painelCadastroProfessor.getTfCpf().setText(painelCadastroProfessor.getTfCpf().getText());
						professor.setCpf(painelCadastroProfessor.getTfCpf().getText());
						professor.setRg(painelCadastroProfessor.getTfIdentidade().getText());
						professor.setNome(painelCadastroProfessor.getTfNomeProfessor().getText());
						professor.setData_nasc(dataNascimento);
						professor.setNome_mae(painelCadastroProfessor.getTfNomeMae().getText());
						professor.setNome_pai(painelCadastroProfessor.getTfNomePai().getText());
						professor.setData_adm(dataAdmissao);
						professorDao.insert(professor);
						JOptionPane.showMessageDialog(null, "Adicionado!", "AVISO", JOptionPane.YES_OPTION);
						contPrin.addTabelaProfessor();
						this.dispose();
						contPrin.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Data de Admissão tem que ser superior à 18 anos da data de Nascimento!", "DATA", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "CPF Inválido!", "Erro de CPF", JOptionPane.ERROR_MESSAGE);
				}
				
				//professorDao.insert(professor);
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
