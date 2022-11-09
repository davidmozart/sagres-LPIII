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
	//private JTable tabela_professor;

	/**
	 * Create the panel.
	 */
	public JpProfessor() {
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		// TODO Auto-generated constructor stub
		this.setName("");
		setLayout(null);
		add(getBtnAdicionarProfessor());
		add(getScrollPane());
		add(getPainel_principal_professor());
	}
	private JButton getBtnAdicionarProfessor() {
		if (btnAdicionarProfessor == null) {
			btnAdicionarProfessor = new JButton("Adicionar Professor");
			btnAdicionarProfessor.setBounds(143, 288, 173, 23);
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
			scrollPane.setBounds(57, 73, 346, 165);
			//scrollPane.setViewportView(getTabela_professor());
		}
		return scrollPane;
	}
	/*
	public JTable getTabela_professor() {
		if (tabela_professor == null) {
			tabela_professor = new JTable();
			tabela_professor.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Descri\u00E7\u00E3o", "Data", "Valor"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		}
		return tabela_professor;
		}
		*/
	private JPanel getPainel_principal_professor() {
		if (painel_principal_professor == null) {
			painel_principal_professor = new JPanel();
			painel_principal_professor.setBounds(0, 0, 601, 62);
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
}
