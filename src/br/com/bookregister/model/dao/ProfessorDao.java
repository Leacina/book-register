package br.com.bookregister.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.Professor;
import br.com.bookregister.view.LoginWindow;

public class ProfessorDao {
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;
	LoginWindow lW = null;
	List<Professor> listaProfessor = new ArrayList<>();
	
	public void registerProfessor(Professor p) {
		try {
			stmt = con.prepareStatement("insert into professor (nome,descricao)"
					+ "values (?,?)");

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getDescricao());
			
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Professor> getProfessores(){
		
		try {
			stmt = con.prepareStatement("select * from professor");
			
			rS = stmt.executeQuery();
			
			while(rS.next()) {
				Professor professor = new Professor();
				
				professor.setId(rS.getInt("id"));
			    professor.setNome(rS.getString("nome"));
			    professor.setDescricao(rS.getString("descricao"));
			    
			    listaProfessor.add(professor);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaProfessor;
	}
}
