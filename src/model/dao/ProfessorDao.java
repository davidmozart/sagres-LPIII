package model.dao;

import java.util.List;

import model.Professor;

public interface ProfessorDao {
	void insert(Professor obj);
	void update(Professor obj);
	void deletebyCpf(String cpf);
	Professor findByCpf(String cpf);
	List<Professor> findAll();
}
