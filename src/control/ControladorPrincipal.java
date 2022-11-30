package control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import model.Professor;
import model.dao.DaoFactory;
import model.dao.ProfessorDao;
import view.FramePrincipal;
import view.JpDashboard;
import view.JpProfessor;
import view.JtpGuias;

public class ControladorPrincipal extends FramePrincipal implements ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;

	private static ControladorPrincipal instancia;
	
	private JpDashboard dashboard;
	private  static JpProfessor professor;
	private JtpGuias guiaPaineis;
	private JTabbedPane guiaPainel;
	
	public static synchronized ControladorPrincipal getInstance() {
		if (instancia == null) {
			instancia = new ControladorPrincipal();
			instancia.addWindowListener(instancia);
			instancia.setVisible(true);
			//instancia.setLayout(null);
		} 
		return instancia;
	}
	
	private ControladorPrincipal() {
		// TODO Auto-generated constructor stub
		addEventos();
	}
	
	public void addEventos() {
		//this.getContentPane().add(BorderLayout.CENTER, getGuiaPaineis());
		//JOptionPane.showMessageDialog(null, "Entrou addEventos");
		//getDashboard();
		getGuiaPainel();
		addTabelaProfessor();
	}
	
	
	


	private JtpGuias getGuiaPaineis() {
			guiaPaineis =  new JtpGuias();
			instancia.add(BorderLayout.CENTER, guiaPaineis);
			//JOptionPane.showMessageDialog(guiaPaineis, dashboard);
			//guiaPaineis.addTab("Bem Vindo", dashboard);
			//guiaPaineis.addTab("Professor", null, getProfessor(), null);
			
		return guiaPaineis;
	}
	
	private JTabbedPane getGuiaPainel() {
		guiaPainel = new JTabbedPane(JTabbedPane.LEFT);
		guiaPainel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		guiaPainel.setAlignmentX(Component.LEFT_ALIGNMENT);
		guiaPainel.setBorder(null);
		guiaPainel.setBackground(new Color(228, 228, 228));
		this.getContentPane().add(BorderLayout.CENTER, guiaPainel);
		guiaPainel.add("Bem Vindo", getDashboard());
		guiaPainel.setForegroundAt(0, new Color(0, 0, 0));
		guiaPainel.add("Professor", getProfessor());
		return guiaPainel;
	}
	


	public JpDashboard getDashboard() {
		if(dashboard == null) {
			dashboard = new JpDashboard();
		}	
		return dashboard;
	}


	public JpProfessor getProfessor() {
		if (professor == null) {
			professor = new JpProfessor();
			professor.getTabela_professor().setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "CPF", "RG", "Nome", "Data de Nascimento", "Nome da mãe", "Nome do pai", "Data de admissão"
					}){
						
						private static final long serialVersionUID = 1L;
						Class[] columnTypes = new Class[] {
							Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
			
			professor.getBtnAdicionarProfessor().addActionListener(this);
			professor.getBtnEditarProf().addActionListener(this);
			professor.getBtnExcluirProf().addActionListener(this);
		}
		
		return professor;
	}
	public void addTabelaProfessor() {
		// TODO Auto-generated method stub
		
		DefaultTableModel modelo = (DefaultTableModel) professor.getTabela_professor()
				.getModel();
		modelo.setRowCount(0);
		ProfessorDao professorDao = DaoFactory.createProfessorDao();
		List<Professor> prof = professorDao.findAll();
			for (Professor pf : prof) {
				modelo.addRow(new Object[] {
						pf.getId(),
						pf.getCpf(),
						pf.getRg(),
						pf.getNome(),
						pf.getData_nasc(),
						pf.getNome_mae(),
						pf.getNome_pai(),
						pf.getData_adm()
				});
			}
			
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
		if(e.getSource() == professor.getBtnAdicionarProfessor()) {
			ControladorCadastroProfessor.getInstance();
		} else if(e.getSource() == professor.getBtnEditarProf()) {
			ControleAtualizaProfessor.getInstance();
		} else if (e.getSource() == professor.getBtnExcluirProf()) {
			ControleExcluirProfessor.getInstance();
		}
	}

}
