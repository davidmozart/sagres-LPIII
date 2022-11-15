package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class JpCadastroProfessor extends JPanel {
	private JLabel lblNomeDoProfessor;
	private JTextField tfNomeProfessor;
	private JLabel lblDataDeAdmisso;
	private JLabel lblDataDeNascimento;
	private JLabel lblCpf;
	private JLabel lblIdentidade;
	private JTextField tfCpf;
	private JTextField tfIdentidade;
	private JLabel lblNomeDaMae;
	private JTextField tfNomeMae;
	private JLabel lblNomeDoPai;
	private JTextField tfNomePai;
	private JButton btnAdicionar;
	private JButton btnCancelar;
	private JPanel panel;
	private JLabel lblCadastroProfessor;
	private JDateChooser dCNascimento;
	private JDateChooser dCAdmissao;
	

	/**
	 * Create the panel.
	 */
	public JpCadastroProfessor() {
		setLayout(null);
		add(getLblCpf());
		add(getTfCpf());
		add(getLblIdentidade());
		add(getTfIdentidade());
		add(getLblNomeDoProfessor());
		add(getTfNomeProfessor());
		add(getLblDataDeNascimento());
		add(getDCNascimento());
		add(getLblNomeDaMae());
		add(getTfNomeMae());
		add(getLblNomeDoPai());
		add(getTfNomePai());
		add(getLblDataDeAdmisso());
		add(getDCAdmissao());
		add(getBtnAdicionar());
		add(getBtnCancelar());
		add(getPanel());
		
	}
	
	
	public JpCadastroProfessor(JLabel lblNomeDoProfessor, JTextField tfNomeProfessor, JLabel lblDataDeAdmisso,
			JLabel lblDataDeNascimento, JLabel lblCpf, JLabel lblIdentidade, JTextField tfCpf, JTextField tfIdentidade,
			JLabel lblNomeDaMae, JTextField tfNomeMae, JLabel lblNomeDoPai, JTextField tfNomePai, JButton btnAdicionar,
			JButton btnCancelar, JPanel panel, JLabel lblCadastroProfessor, JDateChooser dCNascimento,
			JDateChooser dCAdmissao) {
		super();
		this.lblNomeDoProfessor = lblNomeDoProfessor;
		this.tfNomeProfessor = tfNomeProfessor;
		this.lblDataDeAdmisso = lblDataDeAdmisso;
		this.lblDataDeNascimento = lblDataDeNascimento;
		this.lblCpf = lblCpf;
		this.lblIdentidade = lblIdentidade;
		this.tfCpf = tfCpf;
		this.tfIdentidade = tfIdentidade;
		this.lblNomeDaMae = lblNomeDaMae;
		this.tfNomeMae = tfNomeMae;
		this.lblNomeDoPai = lblNomeDoPai;
		this.tfNomePai = tfNomePai;
		this.btnAdicionar = btnAdicionar;
		this.btnCancelar = btnCancelar;
		this.panel = panel;
		this.lblCadastroProfessor = lblCadastroProfessor;
		this.dCNascimento = dCNascimento;
		this.dCAdmissao = dCAdmissao;
	}



	private JLabel getLblNomeDoProfessor() {
		if (lblNomeDoProfessor == null) {
			lblNomeDoProfessor = new JLabel("Nome do Professor:");
			lblNomeDoProfessor.setBounds(39, 119, 140, 15);
		}
		return lblNomeDoProfessor;
	}
	private JTextField getTfNomeProfessor() {
		if (tfNomeProfessor == null) {
			tfNomeProfessor = new JTextField();
			tfNomeProfessor.setBounds(191, 117, 261, 19);
			tfNomeProfessor.setColumns(10);
		}
		return tfNomeProfessor;
	}
	private JLabel getLblDataDeAdmisso() {
		if (lblDataDeAdmisso == null) {
			lblDataDeAdmisso = new JLabel("Data de admissão:");
			lblDataDeAdmisso.setBounds(39, 251, 140, 15);
		}
		return lblDataDeAdmisso;
	}
	private JLabel getLblDataDeNascimento() {
		if (lblDataDeNascimento == null) {
			lblDataDeNascimento = new JLabel("Data de nascimento:");
			lblDataDeNascimento.setBounds(39, 154, 157, 15);
		}
		return lblDataDeNascimento;
	}
	private JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(39, 90, 46, 15);
		}
		return lblCpf;
	}
	private JLabel getLblIdentidade() {
		if (lblIdentidade == null) {
			lblIdentidade = new JLabel("Identidade:");
			lblIdentidade.setBounds(214, 88, 90, 15);
		}
		return lblIdentidade;
	}
	private JTextField getTfCpf() {
		if (tfCpf == null) {
			tfCpf = new JTextField();
			tfCpf.setBounds(79, 88, 114, 19);
			tfCpf.setColumns(10);
		}
		return tfCpf;
	}
	private JTextField getTfIdentidade() {
		if (tfIdentidade == null) {
			tfIdentidade = new JTextField();
			tfIdentidade.setBounds(303, 86, 114, 19);
			tfIdentidade.setColumns(10);
		}
		return tfIdentidade;
	}
	private JLabel getLblNomeDaMae() {
		if (lblNomeDaMae == null) {
			lblNomeDaMae = new JLabel("Nome da mãe:");
			lblNomeDaMae.setBounds(39, 188, 104, 15);
		}
		return lblNomeDaMae;
	}
	private JTextField getTfNomeMae() {
		if (tfNomeMae == null) {
			tfNomeMae = new JTextField();
			tfNomeMae.setBounds(143, 186, 286, 19);
			tfNomeMae.setColumns(10);
		}
		return tfNomeMae;
	}
	private JLabel getLblNomeDoPai() {
		if (lblNomeDoPai == null) {
			lblNomeDoPai = new JLabel("Nome do pai:");
			lblNomeDoPai.setBounds(39, 224, 104, 15);
		}
		return lblNomeDoPai;
	}
	private JTextField getTfNomePai() {
		if (tfNomePai == null) {
			tfNomePai = new JTextField();
			tfNomePai.setDropMode(DropMode.ON);
			tfNomePai.setBounds(143, 222, 286, 19);
			tfNomePai.setColumns(10);
		}
		return tfNomePai;
	}
	private JButton getBtnAdicionar() {
		if (btnAdicionar == null) {
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(119, 289, 117, 25);
		}
		return btnAdicionar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(267, 289, 117, 25);
		}
		return btnCancelar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(119, 104, 255));
			panel.setBounds(0, 0, 557, 62);
			panel.setLayout(null);
			panel.add(getLblCadastroProfessor());
		}
		return panel;
	}
	private JLabel getLblCadastroProfessor() {
		if (lblCadastroProfessor == null) {
			lblCadastroProfessor = new JLabel("Cadastro do Professor");
			lblCadastroProfessor.setForeground(Color.WHITE);
			lblCadastroProfessor.setFont(new Font("URW Bookman L", Font.BOLD, 27));
			lblCadastroProfessor.setBackground((Color) null);
			lblCadastroProfessor.setBounds(125, 19, 329, 31);
		}
		return lblCadastroProfessor;
	}
	private JDateChooser getDCNascimento() {
		if (dCNascimento == null) {
			dCNascimento = new JDateChooser();
			dCNascimento.setBounds(191, 150, 131, 19);
		}
		return dCNascimento;
	}
	private JDateChooser getDCAdmissao() {
		if (dCAdmissao == null) {
			dCAdmissao = new JDateChooser();
			dCAdmissao.setBounds(173, 247, 131, 19);
		}
		return dCAdmissao;
	}
}
