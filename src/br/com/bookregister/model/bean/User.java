package br.com.bookregister.model.bean;

public class User {

	private String senha;
	private String login;

	public User() {
	}

	public User(String login, String senha) {
		this.senha = senha;
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
