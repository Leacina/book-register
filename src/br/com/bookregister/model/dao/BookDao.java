package br.com.bookregister.model.dao;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.Book;

/**
 *
 * @author Giovane Santiago Leacina
 */
public class BookDao {

	public void create(Book b) {
		Connection con = ConnectionFactory.getConnection();
		
		try {
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	public static void main(String args[]) {
		Book b = new Book();
		b.setTitle("Giovanelo");

		BookDao lD = new BookDao();
		lD.create(b);
	}
}
