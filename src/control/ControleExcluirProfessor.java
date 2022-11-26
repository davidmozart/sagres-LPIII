package control;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Professor;
import model.dao.DaoFactory;
import model.dao.ProfessorDao;
import view.FrExcluirProfessor;
import view.JpCadastroProfessor;

@SuppressWarnings("serial")
public class ControleExcluirProfessor extends FrExcluirProfessor implements ActionListener, WindowListener{
	
	private static ControleExcluirProfessor instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private JpCadastroProfessor painelExcluirProfessor;
	private Professor professor;
	
	public static synchronized ControleExcluirProfessor getInstance() {
		instancia = new ControleExcluirProfessor();
		instancia.addWindowListener(instancia);
		return instancia;
	}

	public ControleExcluirProfessor() {
		// TODO Auto-generated constructor stub
		addEventos();
	}

	private void addEventos() {
		// TODO Auto-generated method stub
		this.setContentPane(painelExcluirProfessor());
	}

	private Container painelExcluirProfessor() {
		if(painelExcluirProfessor == null) {
			painelExcluirProfessor = new JpCadastroProfessor();
		}
		painelExcluirProfessor.getTfCpf();
		painelExcluirProfessor.getTfIdentidade().setEditable(false);
		painelExcluirProfessor.getTfNomeProfessor().setEditable(false);
		painelExcluirProfessor.getDCNascimento().setEnabled(false);
		painelExcluirProfessor.getTfNomeMae().setEditable(false);
		painelExcluirProfessor.getTfNomePai().setEditable(false);
		painelExcluirProfessor.getDCAdmissao().setEnabled(false);
		painelExcluirProfessor.getBtnAdicionar().setEnabled(false);
		painelExcluirProfessor.getLblCadastroProfessor().setText("Excluir cadastro do professor");
		painelExcluirProfessor.getBtnAdicionar().setText("Excluir");
		painelExcluirProfessor.getBtnPesquisar().addActionListener(this);
		painelExcluirProfessor.getBtnAdicionar().addActionListener(this);
		painelExcluirProfessor.getBtnCancelar().addActionListener(this);
		return painelExcluirProfessor;
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ProfessorDao professorDao = DaoFactory.createProfessorDao();
		if (e.getSource() == painelExcluirProfessor.getBtnPesquisar()){
			try {
				if (painelExcluirProfessor.getTfCpf().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite um CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if (ValidaCpf.isCPF(painelExcluirProfessor.getTfCpf().getText())){
					
					professor = professorDao.findByCpf(painelExcluirProfessor.getTfCpf().getText());
					
					Date dataNas = sdf.parse(professor.getData_nasc());
					Date dataAdm = sdf.parse(professor.getData_adm());

					
					painelExcluirProfessor.getTfIdentidade().setText(professor.getRg());
					painelExcluirProfessor.getTfNomeProfessor().setText(professor.getNome());
					painelExcluirProfessor.getDCNascimento().setDate(dataNas);
					painelExcluirProfessor.getTfNomeMae().setText(professor.getNome_mae());
					painelExcluirProfessor.getTfNomePai().setText(professor.getNome_pai());
					painelExcluirProfessor.getDCAdmissao().setDate(dataAdm);
					painelExcluirProfessor.getBtnAdicionar().setEnabled(true);
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
			}
		} else if(e.getSource() == painelExcluirProfessor.getBtnAdicionar()) {
			try {
				
				
				professorDao.deletebyCpf(painelExcluirProfessor.getTfCpf().getText());
				
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!", "EXCLUIR", JOptionPane.INFORMATION_MESSAGE);
				contPrin.addTabelaProfessor();
				this.dispose();
				contPrin.setEnabled(true);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
			}
			
		} else if(e.getSource() == painelExcluirProfessor.getBtnCancelar()) {
			this.dispose();
			contPrin.setEnabled(true);
		}
	}

}
