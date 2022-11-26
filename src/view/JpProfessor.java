package view;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JpProfessor extends JPanel {
	private JButton btnAdicionarProfessor;
	private JScrollPane scrollPane;
	private JPanel painel_principal_professor;
	private JLabel lblDashboard;
	private JTable tabela_professor;
	private JButton btnEditarProf;
	private JButton btnExcluirProf;
	

	/**
	 * Create the panel.
	 */
	public JpProfessor() {
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("Cadastro do Professor");
		setLayout(null);
		add(getScrollPane());
		add(getBtnAdicionarProfessor());
		add(getBtnEditarProf());
		add(getPainel_principal_professor());
		add(getBtnExcluirProf());
	}
	public JButton getBtnAdicionarProfessor() {
		if (btnAdicionarProfessor == null) {
			btnAdicionarProfessor = new JButton("Adicionar Professor");
			btnAdicionarProfessor.setBounds(307, 280, 173, 23);
			btnAdicionarProfessor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
		}
		return btnAdicionarProfessor;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 74, 785, 152);
			scrollPane.setViewportView(getTabela_professor());
			//scrollPane.setViewportView(getTabela_professor());
		}
		return scrollPane;
	}

	private JPanel getPainel_principal_professor() {
		if (painel_principal_professor == null) {
			painel_principal_professor = new JPanel();
			painel_principal_professor.setBounds(0, 0, 795, 62);
			painel_principal_professor.setLayout(null);
			painel_principal_professor.setBackground(new Color(119, 104, 255));
			painel_principal_professor.add(getLblDashboard());
		}
		return painel_principal_professor;
	}
	private JLabel getLblDashboard() {
		if (lblDashboard == null) {
			lblDashboard = new JLabel("Professor");
			lblDashboard.setForeground(Color.WHITE);
			lblDashboard.setFont(new Font("Dialog", Font.BOLD, 38));
			lblDashboard.setBackground((Color) null);
			lblDashboard.setBounds(294, 12, 207, 31);
		}
		return lblDashboard;
	}
	public JTable getTabela_professor() {
		if (tabela_professor == null) {
			tabela_professor = new JTable();
			tabela_professor.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					
				}
			));
		}
		return tabela_professor;
	}
	public JButton getBtnEditarProf() {
		if (btnEditarProf == null) {
			btnEditarProf = new JButton("Editar Professor");
			btnEditarProf.setBounds(71, 279, 165, 25);
		}
		return btnEditarProf;
	}
	public JButton getBtnExcluirProf() {
		if (btnExcluirProf == null) {
			btnExcluirProf = new JButton("Excluir Professor");
			btnExcluirProf.setBounds(551, 279, 173, 25);
		}
		return btnExcluirProf;
	}
}
