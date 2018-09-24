package br.com.bookregister.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.Aluno;

public class AlunoDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;

	public void registerStudent(Aluno a) {
		try {
			stmt = con.prepareStatement(
					"insert into alunos (codAluno,nome,data_nascimento,sexo,celular,telefone,email,"
					+ "observacao,endereco,numero,complemento,cep,bairro,pais,uf,cidade)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, a.getCodAluno());
			stmt.setString(2, a.getNomeAluno());
			stmt.setString(3, a.getDataNascimento());
			stmt.setString(4, a.getSexo());
			stmt.setString(5, a.getCelular());
			stmt.setString(6, a.getTelefone());
			stmt.setString(7, a.getEmail());
			stmt.setString(8, a.getObservacao());
			stmt.setString(9, a.getEndereco());
			stmt.setString(10, a.getNumero());
			stmt.setString(11, a.getComplemento());
			stmt.setString(12, a.getCep());
			stmt.setString(13, a.getBairro());
			stmt.setString(14, a.getPais());
			stmt.setString(15, a.getUf());
			stmt.setString(16, a.getCidade());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
