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

/**
 *
 * @author Giovane Santiago Leacina
 */
public class BookDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;
	List<Book> listaLivros = new ArrayList<>();

	public void registerBook(Book b) {
		try {
			stmt = con.prepareStatement("insert into livro (codigo,nome,proprietario,status,autor,ano,imagem)"
					+ "values (?,?,?,?,?,?,?)");

			stmt.setString(1, b.getCodigo());
			stmt.setString(2, b.getNome());
			stmt.setString(3, b.getProprietario());
			stmt.setString(4, b.getStatus());
			stmt.setString(5, b.getAutor());
			stmt.setString(6, b.getAno());
			stmt.setBytes(7, b.getImagem());
			
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Book> getLivrosDisponiveis() {
		try {
			stmt = con.prepareStatement("select * from livro where status = ?");

			stmt.setString(1, "Disponivel");
			rS = stmt.executeQuery();

			while(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				
				listaLivros.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listaLivros;
	}
	
	public List<Book> getLivrosAlugado() {
		try {
			listaLivros.clear();
			stmt = con.prepareStatement("select * from livro where status <> ?");

			stmt.setString(1, "Disponivel");
			rS = stmt.executeQuery();

			while(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				book.setEmprestimo(rS.getInt("emprestimo_aluno"));
				
				listaLivros.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listaLivros;
	}
	
	public List<Book> getLivrosDevolucao() {
		try {
			stmt = con.prepareStatement("select * from livro where status <> ?");

			stmt.setString(1, "Disponivel");
			rS = stmt.executeQuery();

			while(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				book.setEmprestimo(rS.getInt("emprestimo_aluno"));
				
				listaLivros.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return listaLivros;
	}
	
	public List<Book> getLivros(){
		try {
			listaLivros.clear(); 
			stmt = con.prepareStatement("select * from livro");
			
			rS = stmt.executeQuery();
			 
			while(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				book.setEmprestimo(rS.getInt("emprestimo_aluno"));
				book.setImagem(rS.getBytes("imagem"));
				
				listaLivros.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
	public List<Book> getLivrosPorNome(String nome){
		try {
			listaLivros.clear(); 
			stmt = con.prepareStatement("select * from livro where nome like ?");
			
			stmt.setString(1, "%" + nome + "%");
			rS = stmt.executeQuery();
			 
			while(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				book.setEmprestimo(rS.getInt("emprestimo_aluno"));
				
				listaLivros.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
	public String getCodigoBook(String nome) {
		String codigo = "0";
		
		try {
			stmt = con.prepareStatement("Select * from livro where nome = ?");
			
			stmt.setString(1, nome);
			
			rS = stmt.executeQuery();
			
			if (rS.next()) {
				codigo = rS.getString("id");
			}
		} catch (SQLException e) {
			// TODO: Lan�ar exception correta
		} 
		return codigo;
	}
	
	public void alugarLivro(int idLivro,int idAluno) {
		try {
			stmt = con.prepareStatement("update livro set emprestimo_aluno = ?,status = ? where id = ?");

			stmt.setInt(1, idAluno);
			stmt.setString(2, "Emprestado");
			stmt.setInt(3, idLivro);
			
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Empr�stimo de livro realizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void devolverLivro(String nomeLivro) {
		try {
			stmt = con.prepareStatement("update livro set emprestimo_aluno = ?,status = ? where nome = ?");
			
			stmt.setString(1, null);
			stmt.setString(2, "Disponivel");
			stmt.setString(3, nomeLivro);
					
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Devolu��o de livro realizada com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book getLivroPorCodigo(String codigo) {
		try {
			stmt = con.prepareStatement("select * from livro where codigo = ?");
			
			stmt.setString(1, codigo);
			rS = stmt.executeQuery();
			
			if(rS.next()) {
				Book book = new Book();
				book.setId(Integer.parseInt(rS.getString("id")));
				book.setCodigo(rS.getString("codigo"));
				book.setNome(rS.getString("nome"));
				book.setProprietario(rS.getString("proprietario"));
				book.setStatus(rS.getString("status"));
				book.setAutor(rS.getString("autor"));
				book.setAno(rS.getString("ano"));
				book.setEmprestimo(rS.getInt("emprestimo_aluno"));
				book.setImagem(rS.getBytes("imagem"));
				
				return book;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
