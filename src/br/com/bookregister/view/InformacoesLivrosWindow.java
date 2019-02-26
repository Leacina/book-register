package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.bookregister.model.bean.Book;

public class InformacoesLivrosWindow extends AbstractGridWindow{
		
	private JTextField txfNome, txfCod, txfProprietario,txfAutor,txfAno;
	private JButton btnSalvar, btnLimpar,btnAbrirImagem;
	private JPanel panel;
	private JLabel labes,image;
	private File imagem;
	private Book livroSelecionado;
	
	public InformacoesLivrosWindow(Book livroSelecionado) {
		super("Informações do Aluno");
		this.livroSelecionado = livroSelecionado;
		criarComponentes();	
		
		//TODO: Adicionar imagem abaixo com opacidade menor.
		
		JLabel iconSystem;
		
		Icon iconeSystem = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/cadastroLivro.png"));
		iconSystem = new JLabel(iconeSystem);
		iconSystem.setBounds(545, 60, 100, 100);
		iconSystem.setBackground(new Color(235, 223, 253));
		iconSystem.setBackground(getBackground());
		iconSystem.setIcon(iconeSystem);
		getContentPane().add(iconSystem);
		
		JLabel icon;
		
		Icon icone = new ImageIcon(getClass().getResource("/br/com/bookregister/icons/cadastro.png"));
		icon = new JLabel(icone);
		icon.setBounds(620, 60, 100, 100);
		icon.setBackground(new Color(235, 223, 253));
		icon.setBackground(getBackground());
		icon.setIcon(icone);
		getContentPane().add(icon);
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

		txfCod = new JTextField(livroSelecionado.getCodigo());
		txfCod.setBounds(450, 220, 135, 28);
		txfCod.setEditable(false);
		getContentPane().add(txfCod);
		
		//Cadastro do professor de um determinado aluno
	    labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(610, 200, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Proprietario do livro:");
		labes.setBounds(616, 200, 250, 25);
		getContentPane().add(labes);

		txfProprietario = new JTextField(livroSelecionado.getProprietario());
		txfProprietario.setBounds(610, 220, 220, 28);
		txfProprietario.setEditable(false);
		getContentPane().add(txfProprietario);
					
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 250, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(456, 250, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField(livroSelecionado.getNome());
		txfNome.setBounds(450, 270, 380, 28);
		txfNome.setEditable(false);
		getContentPane().add(txfNome);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 300, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Autor:");
		labes.setBounds(456, 300, 350, 25);
		getContentPane().add(labes);

		txfAutor = new JTextField(livroSelecionado.getAutor());
		txfAutor.setBounds(450, 320, 280, 28);
		txfAutor.setEditable(false);
		getContentPane().add(txfAutor);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(750, 300, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Ano:");
		labes.setBounds(756, 300, 350, 25);
		getContentPane().add(labes);

		txfAno = new JTextField(livroSelecionado.getAno());
		txfAno.setBounds(750, 320, 80, 28);
		txfAno.setToolTipText("Digite o ano de lançamento");
		txfAno.setEditable(false);
		getContentPane().add(txfAno);
				
		image = new JLabel("");
		panel = new JPanel();
		panel.setBounds(450,360,260,200);
		panel.setBackground(Color.white);
		panel.add(image);
		getContentPane().add(panel);
		
		System.out.println(livroSelecionado.getImagem());
		if(livroSelecionado.getImagem() != null) {
		  ImageIcon icone = new ImageIcon(livroSelecionado.getImagem());
		  icone.setImage(icone.getImage().getScaledInstance(panel.getWidth() -5, panel.getHeight() -10, 0));
		  image.setIcon(icone);		   
		}
	}

}
