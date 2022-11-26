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
import view.FrAtualizaProfessor;
import view.JpCadastroProfessor;

@SuppressWarnings("serial")
public class ControleAtualizaProfessor extends FrAtualizaProfessor implements ActionListener, WindowListener{

	private static ControleAtualizaProfessor instancia;
	private static ControladorPrincipal contPrin = ControladorPrincipal.getInstance();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private JpCadastroProfessor painelEditaProfessor;
	private Professor professor;
	
	public static synchronized ControleAtualizaProfessor getInstance() {
		instancia = new ControleAtualizaProfessor();
		instancia.addWindowListener(instancia);
		return instancia;
	}
	
	public ControleAtualizaProfessor() {
		addEventos();
	}

	private void addEventos() {
		this.setContentPane(painelEditaProfessor());		
	}

	private Container painelEditaProfessor() {
		if (painelEditaProfessor == null) {
			painelEditaProfessor = new JpCadastroProfessor();
		}
		painelEditaProfessor.getTfCpf();
		painelEditaProfessor.getTfIdentidade().setEditable(false);
		painelEditaProfessor.getTfNomeProfessor().setEditable(false);
		painelEditaProfessor.getDCNascimento().setEnabled(false);
		painelEditaProfessor.getTfNomeMae().setEditable(false);
		painelEditaProfessor.getTfNomePai().setEditable(false);
		painelEditaProfessor.getDCAdmissao().setEnabled(false);
		painelEditaProfessor.getBtnAdicionar().setEnabled(false);
		painelEditaProfessor.getLblCadastroProfessor().setText("Editar cadastro do professor");
		painelEditaProfessor.getBtnAdicionar().setText("Alterar");
		painelEditaProfessor.getBtnPesquisar().addActionListener(this);
		painelEditaProfessor.getBtnAdicionar().addActionListener(this);
		painelEditaProfessor.getBtnCancelar().addActionListener(this);
		return painelEditaProfessor;
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
		ProfessorDao professorDao = DaoFactory.createProfessorDao();
		if (e.getSource() == painelEditaProfessor.getBtnPesquisar()){
			try {
				if (painelEditaProfessor.getTfCpf().getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite um CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else if (ValidaCpf.isCPF(painelEditaProfessor.getTfCpf().getText())){
					//String dataNascimento= sdf.format(painelCadastroProfessor.getDCNascimento().getDate());
					//String dataAdmissao = sdf.format(painelCadastroProfessor.getDCAdmissao().getDate());
					professor = professorDao.findByCpf(painelEditaProfessor.getTfCpf().getText());
					
					Date dataNas = sdf.parse(professor.getData_nasc());
					Date dataAdm = sdf.parse(professor.getData_adm());

					painelEditaProfessor.getTfCpf().setEditable(false);
					painelEditaProfessor.getTfCpf().setText(professor.getCpf());
					painelEditaProfessor.getTfIdentidade().setText(professor.getRg());
					painelEditaProfessor.getTfNomeProfessor().setText(professor.getNome());
					painelEditaProfessor.getDCNascimento().setDate(dataNas);
					painelEditaProfessor.getTfNomeMae().setText(professor.getNome_mae());
					painelEditaProfessor.getTfNomePai().setText(professor.getNome_pai());
					painelEditaProfessor.getDCAdmissao().setDate(dataAdm);
					painelEditaProfessor.getTfIdentidade().setEditable(true);
					painelEditaProfessor.getTfNomeProfessor().setEditable(true);
					painelEditaProfessor.getDCNascimento().setEnabled(true);
					painelEditaProfessor.getTfNomeMae().setEditable(true);
					painelEditaProfessor.getTfNomePai().setEditable(true);
					painelEditaProfessor.getDCAdmissao().setEnabled(true);
					painelEditaProfessor.getBtnAdicionar().setEnabled(true);
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
			}
		} else if(e.getSource() == painelEditaProfessor.getBtnAdicionar()) {
			try {
				String dataNascimento= sdf.format(painelEditaProfessor.getDCNascimento().getDate());
				String dataAdmissao = sdf.format(painelEditaProfessor.getDCAdmissao().getDate());
				professor.setCpf(painelEditaProfessor.getTfCpf().getText());
				
				professor.setRg(painelEditaProfessor.getTfIdentidade().getText());
				JOptionPane.showMessageDialog(null, professor.getRg());
				professor.setNome(painelEditaProfessor.getTfNomeProfessor().getText());
				professor.setData_nasc(dataNascimento);
				professor.setNome_mae(painelEditaProfessor.getTfNomeMae().getText());
				professor.setNome_pai(painelEditaProfessor.getTfNomePai().getText());
				professor.setData_adm(dataAdmissao);
				
				professorDao.update(professor);
				
				JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "ALTERAR", JOptionPane.INFORMATION_MESSAGE);
				contPrin.addTabelaProfessor();
				this.dispose();
				contPrin.setEnabled(true);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Erro: " + e2.getMessage());
			}
			
		} else if(e.getSource() == painelEditaProfessor.getBtnCancelar()) {
			this.dispose();
			contPrin.setEnabled(true);
		}
	}

}
