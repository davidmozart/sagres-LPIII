package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import view.util.LimitaCaracteres;

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
	private JPanel pnlTitulo;
	private JLabel lblCadastroProfessor;
	private JDateChooser dCNascimento;
	private JDateChooser dCAdmissao;
	private JButton btnPesquisar;
	

	/**
	 * Create the panel.
	 */
	public JpCadastroProfessor() {
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		this.setName("");
		this.setBackground(UIManager.getColor("ArrowButton.background"));
		//getTfCpf().setDocument(new LimitaCaracteres(14, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
		add(getLblCpf());
		add(getTfCpf());
		add(getLblIdentidade());
		add(getTfIdentidade());
		add(getLblNomeDoProfessor());
		add(getTfNomeProfessor());
		add(getLblDataDeNascimento());
		add(getDCNascimento());
		add(getLblDataDeAdmisso());
		add(getDCAdmissao());
		add(getLblNomeDaMae());
		add(getTfNomeMae());
		add(getLblNomeDoPai());
		add(getTfNomePai());
		add(getBtnAdicionar());
		add(getBtnCancelar());
		add(getPnlTitulo());
		add(getBtnPesquisar());
	}


	public JLabel getLblNomeDoProfessor() {
		if (lblNomeDoProfessor == null) {
			lblNomeDoProfessor = new JLabel("Nome do Professor:");
			lblNomeDoProfessor.setBounds(69, 131, 140, 15);
		}
		return lblNomeDoProfessor;
	}
	public JTextField getTfNomeProfessor() {
		if (tfNomeProfessor == null) {
			tfNomeProfessor = new JTextField();
			tfNomeProfessor.setDocument(new LimitaCaracteres(60, LimitaCaracteres.TipoEntrada.NOME));
			tfNomeProfessor.setBounds(221, 129, 261, 19);
			tfNomeProfessor.setColumns(10);
		}
		return tfNomeProfessor;
	}
	public JLabel getLblDataDeAdmisso() {
		if (lblDataDeAdmisso == null) {
			lblDataDeAdmisso = new JLabel("Data de admissão:");
			lblDataDeAdmisso.setBounds(69, 263, 140, 15);
		}
		return lblDataDeAdmisso;
	}
	public JLabel getLblDataDeNascimento() {
		if (lblDataDeNascimento == null) {
			lblDataDeNascimento = new JLabel("Data de nascimento:");
			lblDataDeNascimento.setBounds(69, 166, 157, 15);
		}
		return lblDataDeNascimento;
	}
	public JLabel getLblCpf() {
		if (lblCpf == null) {
			lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(69, 102, 46, 15);
		}
		return lblCpf;
	}
	public JLabel getLblIdentidade() {
		if (lblIdentidade == null) {
			lblIdentidade = new JLabel("Identidade:");
			lblIdentidade.setBounds(244, 100, 90, 15);
		}
		return lblIdentidade;
	}
	public JTextField getTfCpf() {
		if (tfCpf == null) {
			tfCpf = new JTextField();
			tfCpf.setDocument(new LimitaCaracteres(11, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));
			tfCpf.setBounds(109, 100, 124, 19);
			tfCpf.setColumns(10);
			
		}
		return tfCpf;
	}
	public JTextField getTfIdentidade() {
		if (tfIdentidade == null) {
			tfIdentidade = new JTextField();
			tfIdentidade.setBounds(333, 98, 126, 19);
			tfIdentidade.setColumns(10);
		}
		return tfIdentidade;
	}
	public JLabel getLblNomeDaMae() {
		if (lblNomeDaMae == null) {
			lblNomeDaMae = new JLabel("Nome da mãe:");
			lblNomeDaMae.setBounds(69, 200, 104, 15);
		}
		return lblNomeDaMae;
	}
	public JTextField getTfNomeMae() {
		if (tfNomeMae == null) {
			tfNomeMae = new JTextField();
			tfNomeMae.setDocument(new LimitaCaracteres(60, LimitaCaracteres.TipoEntrada.NOME));
			tfNomeMae.setBounds(173, 198, 286, 19);
			tfNomeMae.setColumns(10);
		}
		return tfNomeMae;
	}
	public JLabel getLblNomeDoPai() {
		if (lblNomeDoPai == null) {
			lblNomeDoPai = new JLabel("Nome do pai:");
			lblNomeDoPai.setBounds(69, 236, 104, 15);
		}
		return lblNomeDoPai;
	}
	public JTextField getTfNomePai() {
		if (tfNomePai == null) {
			tfNomePai = new JTextField();
			tfNomePai.setDocument(new LimitaCaracteres(60, LimitaCaracteres.TipoEntrada.NOME));
			tfNomePai.setBounds(173, 234, 286, 19);
			tfNomePai.setColumns(10);
		}
		return tfNomePai;
	}
	public JButton getBtnAdicionar() {
		if (btnAdicionar == null) {
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setBounds(231, 301, 117, 25);
		}
		return btnAdicionar;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(405, 301, 117, 25);
		}
		return btnCancelar;
	}
	public JPanel getPnlTitulo() {
		if (pnlTitulo == null) {
			pnlTitulo = new JPanel();
			pnlTitulo.setBackground(new Color(119, 104, 255));
			pnlTitulo.setBounds(0, 0, 631, 62);
			pnlTitulo.setLayout(null);
			pnlTitulo.add(getLblCadastroProfessor());
		}
		return pnlTitulo;
	}
	public JLabel getLblCadastroProfessor() {
		if (lblCadastroProfessor == null) {
			lblCadastroProfessor = new JLabel("Cadastro do Professor");
			lblCadastroProfessor.setForeground(Color.WHITE);
			lblCadastroProfessor.setFont(new Font("URW Bookman L", Font.BOLD, 27));
			lblCadastroProfessor.setBackground((Color) null);
			lblCadastroProfessor.setBounds(99, 19, 433, 31);
		}
		return lblCadastroProfessor;
	}
	public JDateChooser getDCNascimento() {
		if (dCNascimento == null) {
			dCNascimento = new JDateChooser();
			dCNascimento.setDateFormatString("dd '/' MM '/' yyyy");
			dCNascimento.setBounds(221, 162, 131, 19);
		}
		return dCNascimento;
	}
	public JDateChooser getDCAdmissao() {
		if (dCAdmissao == null) {
			dCAdmissao = new JDateChooser();
			dCAdmissao.setDateFormatString("dd '/' MM '/' yyyy");
			dCAdmissao.setBounds(203, 259, 131, 19);
		}
		return dCAdmissao;
	}
	public JButton getBtnPesquisar() {
		if (btnPesquisar == null) {
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBounds(57, 301, 117, 25);
		}
		return btnPesquisar;
	}
}
