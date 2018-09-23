package br.com.bookregister.view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	private JTextField txfUsuario;
	private JButton btnCadastra;
	private JButton btnLimpar;
	private JLabel saida;

	public CadastrarUsuarioWindow() {
		super("Cadastrar Usuário");
		criarComponentes();
	}

	private void criarComponentes() {
		saida = new JLabel("Login: ");
		saida.setBounds(550, 175, 200, 25);
		getContentPane().add(saida);

		txfUsuario = new JTextField();
		txfUsuario.setBounds(550, 200, 200, 25);
		txfUsuario.setToolTipText("Digite o código");
		getContentPane().add(txfUsuario);
		txfUsuario.addKeyListener(acao);

		saida = new JLabel("Senha:");
		saida.setBounds(550, 235, 200, 25);
		getContentPane().add(saida);

		txfSenha = new JPasswordField();
		txfSenha.setBounds(550, 260, 200, 25);
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
	}

	public boolean validarCamposObrigatorios() {
		if (txfUsuario.getText().isEmpty() || (new String(txfSenha.getPassword())).isEmpty()) {
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
			String usuario = txfUsuario.getText();
			String senha = new String(txfSenha.getPassword());
			
			UserDao uD = new UserDao();
			uD.registerUser(usuario, senha);
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
			limparFormulario();
		}
	}

	public void limparFormulario() {
		txfUsuario.setText("");
		txfSenha.setText("");
	}
}