package model.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.DB;
import db.DbException;
import model.Professor;
import model.dao.ProfessorDao;

public class ProfessorDaoJDBC implements ProfessorDao{
	
	private Connection conn;

	public ProfessorDaoJDBC(Connection conn) {
		this.conn = conn;	
	}

	@Override
	public void insert(Professor obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO professor "
					+ "(cpf, rg, nome, data_nasc, nome_mae, nome_pai, data_adm) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getRg());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getData_nasc());
			st.setString(5, obj.getNome_mae());
			st.setString(6, obj.getNome_pai());
			st.setString(7, obj.getData_adm());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					Long id = rs.getLong(1);
					obj.setId(id);
				}
				DB.closeResulSet(rs);
			} 
			else  {
				throw new DbException("Erro inesperado! Nenhuma linha foi afetada");
			}
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Professor obj) {
		PreparedStatement st = null;
		JOptionPane.showMessageDialog(null, obj.getNome());
		try {
			st = conn.prepareStatement(
					"UPDATE professor "
					+ "SET rg=?, nome=?, data_nasc=?, nome_mae=?, nome_pai=?, data_adm=? "
					+ "WHERE cpf=?");
			st.setString(1, obj.getRg());
			st.setString(2, obj.getNome());
			st.setString(3, obj.getData_nasc());
			st.setString(4, obj.getNome_mae());
			st.setString(5, obj.getNome_pai());
			st.setString(6, obj.getData_adm());
			st.setString(7, obj.getCpf());
			st.executeUpdate();
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
		// TODO Auto-generated method stub
		
	}



	@Override
	public Professor findByCpf(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM professor "
					+ "WHERE professor.cpf = ?");
			st.setString(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				Professor prof = instantiateProf(rs);
				return prof;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
			// TODO: handle exception
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResulSet(rs);
		}
	}

	private Professor instantiateProf(ResultSet rs) throws SQLException {
		Professor prof = new Professor();	
		prof.setId(rs.getLong("id"));
		prof.setCpf(rs.getString("cpf"));
		prof.setRg(rs.getString("rg"));
		prof.setNome(rs.getString("nome"));
		prof.setData_nasc(rs.getString("data_nasc"));
		prof.setNome_mae(rs.getString("nome_mae"));
		prof.setNome_pai(rs.getString("nome_pai"));
		prof.setData_adm(rs.getString("data_adm"));
		return prof;
	}

	@Override
	public List<Professor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT * "
					+ "FROM professor "
					+ "ORDER BY nome");
			rs = st.executeQuery();
			List<Professor> list = new ArrayList<>();
			while (rs.next()) {
				Professor prof = instantiateProf(rs);
				list.add(prof);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResulSet(rs);
		}
			
	}

	@Override
	public void deletebyCpf(String cpf) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE * FROM professor WHERE cpf = ?");
			st.setString(1, cpf);
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

}
