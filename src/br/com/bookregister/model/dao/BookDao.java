package br.com.bookregister.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.Book;

/**
 *
 * @author Giovane Santiago Leacina
 */
public class BookDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;

	public void registerBook(Book b) {
		try {
			stmt = con.prepareStatement("insert into livro (codigo,nome,proprietario,status,autor,ano)"
					+ "values (?,?,?,?,?,?)");

			stmt.setString(1, b.getCodigo());
			stmt.setString(2, b.getNome());
			stmt.setString(3, b.getProprietario());
			stmt.setString(4, b.getStatus());
			stmt.setString(5, b.getAutor());
			stmt.setString(6, b.getAno());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	
}
