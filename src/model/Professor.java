package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("serial")
public class Professor implements Serializable{
	

	private String nome;
	private String data_adm;
	private String data_nasc;
	private String cpf;
	private String rg;
	private String nome_mae;
	private String nome_pai;
	private Long id;
	
	



	private static List<Professor> cadProfessor = new ArrayList<>();
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_adm() {
		return data_adm;
	}

	public void setData_adm(String data_adm) {
		this.data_adm = data_adm;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome_mae() {
		return nome_mae;
	}

	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}

	public String getNome_pai() {
		return nome_pai;
	}

	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<Professor> getCadProfessor() {
		return cadProfessor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(cpf, other.cpf);
	}	
	
}
