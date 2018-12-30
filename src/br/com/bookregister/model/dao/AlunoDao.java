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
import br.com.bookregister.model.bean.Book;
import br.com.bookregister.model.bean.User;
import br.com.bookregister.view.CadastrarPrimeiroUser;

public class AlunoDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;
	List<Aluno> listaAlunos = new ArrayList<>();

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
	
	public String getCodigoAluno(String nome) {
		String codigo = "0";
		
		try {
			stmt = con.prepareStatement("Select * from alunos where nome = ?");
			
			stmt.setString(1, nome);
			
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

	public String getCodigoProximoAluno() {

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
	
	public List<Aluno> getAlunos() {
		try {
			stmt = con.prepareStatement("select * from alunos");

			rS = stmt.executeQuery();

			while(rS.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(Integer.parseInt(rS.getString("id")));
				aluno.setNome(rS.getString("nome"));
				aluno.setDataNascimento(rS.getString("data_nascimento"));
				aluno.setSexo(rS.getString("sexo"));
				aluno.setTelefone(rS.getString("telefone"));
				aluno.setCelular(rS.getString("celular"));
				aluno.setEmail(rS.getString("email"));
				aluno.setObservacao(rS.getString("observacao"));
				aluno.setEndereco(rS.getString("endereco"));
				aluno.setComplemento(rS.getString("complemento"));
				aluno.setCidade(rS.getString("cidade"));
				aluno.setBairro(rS.getString("bairro"));
				aluno.setProfessor(rS.getString("professor_aluno"));
				
				
				listaAlunos.add(aluno);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listaAlunos;
	}
	
	public Aluno buscarAlunoPorId(int id) {
		
		try {
			stmt = con.prepareStatement("select * from alunos");

			rS = stmt.executeQuery();

			while(rS.next()) {
				Aluno aluno = new Aluno();
				if(rS.getInt("id") == id) {
					aluno.setNome(rS.getString("nome"));
					return aluno;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
}


