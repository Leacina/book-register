package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.bookregister.model.bean.User;
import br.com.bookregister.model.dao.UserDao;



public class CadastrarUsuarioWindow extends AbstractWindowFrame{
	private static final long serialVersionUID = 1L;

	KeyAdapter acao = new KeyAdapter() {
		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				cadastraUsuario();
			}
		}
	};

	private JPasswordField txfSenha;
	private JTextField txfLogin;
	private JButton btnCadastra;
	private JButton btnLimpar;
	private JLabel saida;
	private JButton iconLogin;
	private JButton iconSenha;

	public CadastrarUsuarioWindow() {
		super("Cadastrar Usuário");
		criarComponentes();
		
		JLabel icon;
		
		Icon icone = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/CadastroUsuario.png"));
		icon = new JLabel(icone);
		icon.setBounds(620, 100, 50, 50);
		icon.setBackground(new Color(235, 223, 253));
		icon.setBackground(getBackground());
		icon.setIcon(icone);
		getContentPane().add(icon);
	}

	private void criarComponentes() {
		
		saida = new JLabel("Usuario: ");
		saida.setBounds(550, 175, 200, 25);
		getContentPane().add(saida);

		txfLogin = new JTextField();
		txfLogin.setBounds(550, 200, 200, 30);
		txfLogin.setToolTipText("Digite o usuario");
		getContentPane().add(txfLogin);
		txfLogin.addKeyListener(acao);

		saida = new JLabel("Senha:");
		saida.setBounds(550, 235, 200, 25);
		getContentPane().add(saida);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(550, 260, 200, 30);
		txfSenha.setToolTipText("Digite uma senha");
		getContentPane().add(txfSenha);
		txfSenha.addKeyListener(acao);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(550, 310, 95, 25);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);

		btnCadastra = new JButton(new AbstractAction("Salvar") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cadastraUsuario();
			}
		});

		btnCadastra.addKeyListener(acao);
		btnCadastra.setBounds(655, 310, 95, 25);
		getContentPane().add(btnCadastra);
		
		iconLogin = new JButton();
		iconLogin.setBounds(510, 201, 28, 28);
		iconLogin.setBackground(new Color(235, 223, 253));
		iconLogin.setBorderPainted(false);
		Icon iconeLogin = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/iconLogin.png"));
		iconLogin.setBackground(getBackground());
		iconLogin.setIcon(iconeLogin);
		iconLogin.setToolTipText("Atualizar Campos");
		getContentPane().add(iconLogin);
		
		iconSenha = new JButton();
		iconSenha.setBounds(510, 261, 28, 28);
		iconSenha.setBackground(new Color(235, 223, 253));
		iconSenha.setBorderPainted(false);
		Icon iconeSenha = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/iconSenha.png"));
		iconSenha.setBackground(getBackground());
		iconSenha.setIcon(iconeSenha);
		iconSenha.setToolTipText("Atualizar Campos");
		getContentPane().add(iconSenha);
		
	}

	public boolean validarCamposObrigatorios() {
		if (txfLogin.getText().isEmpty() || (new String(txfSenha.getPassword())).isEmpty()) {
			return true;
		}

		return false;
	}

	public void cadastraUsuario() {

		if (validarCamposObrigatorios()) {
			JOptionPane.showMessageDialog(rootPane, "Campos obrigatórios (*) não preenchidos!", "",
					JOptionPane.ERROR_MESSAGE, null);
			return;
		}else {
			String login = txfLogin.getText();
			String senha = new String(txfSenha.getPassword());
			
			User user = new User();
			
			user.setLogin(login);
			user.setSenha(senha);
			
			UserDao uD = new UserDao();
			uD.registerUser(user);
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
			limparFormulario();
		}
	}

	public void limparFormulario() {
		txfLogin.setText("");
		txfSenha.setText("");
	}
}