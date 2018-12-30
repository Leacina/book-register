package br.com.bookregister.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.User;
import br.com.bookregister.view.CadastrarPrimeiroUser;

public class AlunoDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;

	public void registerStudent(Aluno a) {
		try {
			stmt = con.prepareStatement("insert into alunos (nome,data_nascimento,sexo,telefone,celular,email,"
					+ "observacao,endereco,numero,complemento,cidade,bairro,professor_aluno)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getDataNascimento());
			stmt.setString(3, a.getSexo());
			stmt.setString(4, a.getTelefone());
			stmt.setString(5, a.getCelular());
			stmt.setString(6, a.getEmail());
			stmt.setString(7, a.getObservacao());
			stmt.setString(8, a.getEndereco());
			stmt.setString(9, a.getNumero());
			stmt.setString(10, a.getComplemento());
			stmt.setString(11, a.getCidade());
			stmt.setString(12, a.getBairro());
			stmt.setString(13, a.getProfessor());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public String getCodigoAluno() {

		String codigo = "0";
		try {
			stmt = con.prepareStatement("Select * from alunos");

			rS = stmt.executeQuery();
			if (rS.next()) {
				codigo = rS.getString("id");
			}
		} catch (SQLException e) {
			// TODO: Lançar exception correta
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		return codigo;
	}
}


