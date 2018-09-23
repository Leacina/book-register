package br.com.bookregister.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import br.com.bookregister.model.dao.UserDao;

public class LoginWindow extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField txfNome;
	private JPasswordField txfSenha;
	private JButton btnAcessar;
	private JLabel Descricao;
	private String login, senha;

	LoginWindow() {
		setSize(250, 200);
		setTitle("Controle de livros");
		setLayout(null);
		setResizable(false);
		criarComponentes();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void criarComponentes() {
		Descricao = new JLabel("Login: ");
		Descricao.setBounds(10, 10, 200, 25);
		getContentPane().add(Descricao);

		txfNome = new JTextField();
		txfNome.setBounds(10, 30, 200, 25);
		txfNome.setToolTipText("Informe seu login");
		getContentPane().add(txfNome);

		Descricao = new JLabel("Senha: ");
		Descricao.setBounds(10, 65, 200, 25);
		getContentPane().add(Descricao);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(10, 85, 200, 25);
		txfSenha.setToolTipText("Informe sua senha");
		getContentPane().add(txfSenha);

		txfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login = txfNome.getText();
					senha = new String(txfSenha.getPassword());

					autenticaUsuario(login, senha);
				}
			}
		});

		txfSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login = txfNome.getText();
					senha = new String(txfSenha.getPassword());

					autenticaUsuario(login, senha);
				}
			}
		});

		btnAcessar = new JButton(new AbstractAction("Acessar") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				login = txfNome.getText();
				senha = new String(txfSenha.getPassword());

				autenticaUsuario(login, senha);
			}
		});

		btnAcessar.setBounds(10, 115, 100, 25);
		getContentPane().add(btnAcessar);
		btnAcessar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login = txfNome.getText();
					senha = new String(txfSenha.getPassword());

					autenticaUsuario(login, senha);
				}
			}
		});

	}

	public void autenticaUsuario(String login, String senha) {
		try {
			UserDao uD = new UserDao(this);
			uD.checkLogin(login, senha);
		} catch (Exception message) {
			JOptionPane.showMessageDialog(null, "Erro: " + message);
		}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new LoginWindow().setVisible(true);
			}
		});
	}
}
