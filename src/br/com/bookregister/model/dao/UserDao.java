package br.com.bookregister.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bookregister.connection.ConnectionFactory;
import br.com.bookregister.model.bean.User;
import br.com.bookregister.view.CadastrarPrimeiroUser;
import br.com.bookregister.view.LoginWindow;
import br.com.bookregister.view.Window;

public class UserDao {

	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	ResultSet rS = null;
	LoginWindow lW = null;
	
	public UserDao() {
		
	}
	
	public UserDao(LoginWindow lW) {
		this.lW = lW;
	}
	
	public void checkLogin(User user) {

		try {
			if (user.getLogin().equals("admin") && user.getSenha().equals("admin")) {
				stmt = con.prepareStatement("Select * from usuario where usuario = ? and senha = ? and id = 1");
				stmt.setString(1, user.getLogin());
				stmt.setString(2, user.getSenha());

				rS = stmt.executeQuery();
				if (rS.next()) {
					new CadastrarPrimeiroUser().setVisible(true);
					
				}
			} else {
				stmt = con.prepareStatement("Select * from usuario where usuario = ? and senha = ?");
				stmt.setString(1, user.getLogin());
				stmt.setString(2, user.getSenha());

				rS = stmt.executeQuery();

				if (rS.next()) {
					login();
				}
			}
		} catch (SQLException e) {
			// TODO: Lançar exception correta
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public void registerFirstLogin(User user) {
		try {
			stmt = con.prepareStatement("update usuario set usuario = ?,senha = ? where id = 1");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getSenha());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void login() {
		new Window().setVisible(true);
		lW.setVisible(false);
	}
	
	public void registerUser(User user) {
		try {
			stmt = con.prepareStatement("insert into usuario (usuario,senha) values(?,?)");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getSenha());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

}
