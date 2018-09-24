package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import br.com.bookregister.model.bean.User;
import br.com.bookregister.model.dao.UserDao;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField txfNome;
	private JPasswordField txfSenha;
	private JButton btnAcessar;
	private JLabel Descricao;
	private String login, senha;
	private JLabel iconLogin;
	private JLabel iconSenha;
	
	LoginWindow() {
		setSize(300, 200);
		setTitle("Controle de livros");
		setLayout(null);
		setResizable(false);
		criarComponentes();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(new Color(230,230,250));
	}

	public void criarComponentes() {
		Descricao = new JLabel("Login: ");
		Descricao.setBounds(45, 05, 200, 25);
		getContentPane().add(Descricao);

		txfNome = new JTextField();
		txfNome.setBounds(45, 30, 200, 30);
		txfNome.setToolTipText("Informe seu login");
		getContentPane().add(txfNome);

		Descricao = new JLabel("Senha: ");
		Descricao.setBounds(45, 60, 200, 25);
		getContentPane().add(Descricao);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(45, 85, 200, 30);
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

		btnAcessar.setBounds(45, 125, 100, 25);
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
		
		
		Icon iconeLogin = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/login.png"));
		iconLogin = new JLabel(iconeLogin);
		iconLogin.setBounds(2, 30, 30, 30);
		iconLogin.setBackground(new Color(235, 223, 253));
		iconLogin.setBackground(getBackground());
		iconLogin.setIcon(iconeLogin);
		iconLogin.setToolTipText("Atualizar Campos");
		getContentPane().add(iconLogin);
		
		Icon iconeSenha = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/senha.png"));
		iconSenha = new JLabel(iconeSenha);
		iconSenha.setBounds(2, 85, 30, 30);
		iconSenha.setBackground(new Color(235, 223, 253));
		iconSenha.setBackground(getBackground());
		iconSenha.setIcon(iconeSenha);
		iconSenha.setToolTipText("Atualizar Campos");
		getContentPane().add(iconSenha);

	}

	public void autenticaUsuario(String login, String senha) {
		try {
			User u = new User();
			
			u.setLogin(login);
			u.setSenha(senha);
			
			UserDao uD = new UserDao(this);
			uD.checkLogin(u);
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
