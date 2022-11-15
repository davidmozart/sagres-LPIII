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
		add(getPainel_principal_professor());
	}
	private JButton getBtnAdicionarProfessor() {
		if (btnAdicionarProfessor == null) {
			btnAdicionarProfessor = new JButton("Adicionar Professor");
			btnAdicionarProfessor.setBounds(354, 280, 173, 23);
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
			scrollPane.setBounds(10, 74, 726, 152);
			scrollPane.setViewportView(getTabela_professor());
			//scrollPane.setViewportView(getTabela_professor());
		}
		return scrollPane;
	}

	private JPanel getPainel_principal_professor() {
		if (painel_principal_professor == null) {
			painel_principal_professor = new JPanel();
			painel_principal_professor.setBounds(0, 0, 752, 62);
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
			lblDashboard.setFont(new Font("Arial", Font.PLAIN, 22));
			lblDashboard.setBackground((Color) null);
			lblDashboard.setBounds(31, 20, 149, 31);
		}
		return lblDashboard;
	}
	private JTable getTabela_professor() {
		if (tabela_professor == null) {
			tabela_professor = new JTable();
			tabela_professor.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "CPF", "RG", "Nome", "Data de Nascimento", "Nome da m\u00E3e", "Nome do pai", "Data de admiss\u00E3o"
				}
			));
		}
		return tabela_professor;
	}
}
