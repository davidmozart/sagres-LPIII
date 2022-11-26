package model.dao;

import db.DB;
import model.dao.imp.ProfessorDaoJDBC;

public class DaoFactory {
	public static ProfessorDao createProfessorDao() {
		return new ProfessorDaoJDBC(DB.getConnection());
	}
}
