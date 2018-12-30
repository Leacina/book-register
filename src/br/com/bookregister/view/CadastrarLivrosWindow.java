package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.Book;
import br.com.bookregister.model.dao.AlunoDao;
import br.com.bookregister.model.dao.BookDao;

public class CadastrarLivrosWindow extends AbstractWindowFrame{
	private static final long serialVersionUID = -4479891238469664919L;

	KeyAdapter acao = new KeyAdapter() {
		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				cadastraAluno();
			}
		}
	};
		
	private JTextField txfNome, txfCod, txfProprietario,txfAutor,txfAno;
	private JButton btnSalvar, btnLimpar;
	private JLabel labes;
	
	public CadastrarLivrosWindow() {
		super("Cadastrar Livro");
		criarComponentes();
		
		//TODO: Adicionar imagem abaixo com opacidade menor.
		
		/*JLabel iconSystem;
		
		Icon iconeSystem = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/pecas_fundo1.png"));
		iconSystem = new JLabel(iconeSystem);
		iconSystem.setBounds(450, 120, 432, 402);
		iconSystem.setBackground(new Color(235, 223, 253));
		iconSystem.setBackground(getBackground());
		iconSystem.setIcon(iconeSystem);
		iconSystem.setToolTipText("Atualizar Campos");
		getContentPane().add(iconSystem);*/
	}

	public void criarComponentes() {

		// Coluna da esquerda, campos e escritas
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 200, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Codigo do Livro:");
		labes.setBounds(456, 200, 250, 25);
		getContentPane().add(labes);

		txfCod = new JTextField();
		txfCod.setBounds(450, 220, 135, 28);
		txfCod.setToolTipText("Digite o código do livro");
		getContentPane().add(txfCod);
		txfCod.addKeyListener((KeyListener) acao);
		
		//Cadastro do professor de um determinado aluno
	    labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(610, 200, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Proprietario do livro:");
		labes.setBounds(616, 200, 250, 25);
		getContentPane().add(labes);

		txfProprietario = new JTextField();
		txfProprietario.setBounds(610, 220, 220, 28);
		txfProprietario.setToolTipText("Informe o proprietario do livro");
		getContentPane().add(txfProprietario);
		txfProprietario.addKeyListener((KeyListener) acao);
					
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 250, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(456, 250, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField();
		txfNome.setBounds(450, 270, 380, 28);
		txfNome.setToolTipText("Digite o nome completo");
		getContentPane().add(txfNome);
		txfNome.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 300, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Autor:");
		labes.setBounds(456, 300, 350, 25);
		getContentPane().add(labes);

		txfAutor = new JTextField();
		txfAutor.setBounds(450, 320, 280, 28);
		txfAutor.setToolTipText("Digite o nome completo");
		getContentPane().add(txfAutor);
		txfAutor.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(750, 300, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Ano:");
		labes.setBounds(756, 300, 350, 25);
		getContentPane().add(labes);

		txfAno = new JTextField();
		txfAno.setBounds(750, 320, 80, 28);
		txfAno.setToolTipText("Digite o ano de lançamento");
		getContentPane().add(txfAno);
		txfAno.addKeyListener((KeyListener) acao);
		
		
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(450, 360, 95, 28);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(555, 360, 95, 28);
		getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraAluno();
			}
		});
		
		btnSalvar.addKeyListener((KeyListener) acao);
	}
	
	public void cadastraAluno() {
		if(validarCamposObrigatorios()) {
			JOptionPane.showMessageDialog(rootPane, "Campos obrigatórios (*) não preenchidos!", "", JOptionPane.ERROR_MESSAGE, null);
			return;
		}else {
			Book b = new Book();
			BookDao bD = new BookDao();
			
			b.setCodigo(txfCod.getText());
			b.setProprietario(txfProprietario.getText());
			b.setNome(txfNome.getText());
			b.setAutor(txfAutor.getText());
			b.setAno("2018");
			b.setStatus("Disponivel");
			
			bD.registerBook(b);
		}
	}
	

	public boolean validarCamposObrigatorios() {
		if(txfNome.getText().isEmpty() ||
			txfCod.getText().isEmpty() ||
			txfProprietario.getText().isEmpty() 		
			) {
			return true;
		}
	
		return false;
	}
	
	
	public void limparFormulario() {

		txfNome.setText("");
		txfCod.setText("");
		txfProprietario.setText("");
	
	}
}