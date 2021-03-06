package br.com.bookregister.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
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
	private JButton btnSalvar, btnLimpar,btnAbrirImagem;
	private JPanel panel;
	private JLabel labes,image;
	private File imagem;
	
	public CadastrarLivrosWindow() {
		super("Cadastrar Livro");
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

		txfCod = new JTextField();
		txfCod.setBounds(450, 220, 135, 28);
		txfCod.setToolTipText("Digite o c�digo do livro");
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
		txfAno.setToolTipText("Digite o ano de lan�amento");
		getContentPane().add(txfAno);
		txfAno.addKeyListener((KeyListener) acao);
		
		image = new JLabel("");
		panel = new JPanel();
		panel.setBounds(450,360,140,120);
		panel.setBackground(Color.white);
		panel.add(image);
		getContentPane().add(panel);
		
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(450, 500, 95, 28);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(555, 500, 95, 28);
		getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraAluno();
			}
		});
		
		btnSalvar.addKeyListener((KeyListener) acao);
		
		btnAbrirImagem = new JButton("Abrir");
		btnAbrirImagem.setBounds(605, 453, 45, 28);
		getContentPane().add(btnAbrirImagem);
		btnAbrirImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagem = selecionarImagem();
				abrirImagem(imagem);
			}
		});
		
		btnAbrirImagem.addKeyListener((KeyListener) acao);
	}
	
	public void cadastraAluno() {
		if(validarCamposObrigatorios()) {
			JOptionPane.showMessageDialog(rootPane, "Campos obrigat�rios (*) n�o preenchidos!", "", JOptionPane.ERROR_MESSAGE, null);
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
			b.setImagem(getImagem());
			
			System.out.println(getImagem().toString());
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
	
	public File selecionarImagem(){
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg","png");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.setCurrentDirectory(new File("/"));
		fileChooser.showOpenDialog(this);
		
		return fileChooser.getSelectedFile();
	}
	
	private byte[] getImagem(){
		boolean isPng = false;
		
		if(imagem != null){
			isPng = imagem.getName().endsWith("png");
			
			try {
				
				BufferedImage image = ImageIO.read(imagem);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;
				
				if(isPng){
					type = BufferedImage.BITMASK;
				}
				
				BufferedImage novaImagem = new BufferedImage(panel.getWidth() - 5, panel.getHeight() - 10, type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0,0, panel.getWidth() -5, panel.getHeight() -10, null);
				
				if(isPng){
					ImageIO.write(novaImagem, "png", out);
				}else{
					ImageIO.write(novaImagem, "jpg", out);
				}
				
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();
				
				return byteArray;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private void abrirImagem(Object source){
		if(source instanceof File){
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(panel.getWidth()-5, panel.getHeight() -10, 100));
			image.setIcon(icon);
		}
	}
	
}