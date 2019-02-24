package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.Book;
import br.com.bookregister.model.dao.AlunoDao;
import br.com.bookregister.model.dao.BookDao;

public class DevolucaoLivroWindow extends AbstractWindowFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3925675055651349195L;
	private JComboBox<String> cbxLivroEmprestado;
	private JTextField txfAlunoDevolucao;
	private JLabel label;
	private JButton btnSalvar, btnLimpar;
	private List<Book> listaLivrosDevolucao = null;
	private List<Aluno> listaAlunos = null;

	AlunoDao aD = new AlunoDao();
	BookDao bD = new BookDao();

	public DevolucaoLivroWindow() {
		super("Devolução de livros");
		listaLivrosDevolucao = bD.getLivrosDevolucao();
		listaAlunos = aD.getAlunos();
		criarComponentes();
		
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
		label = new JLabel("*");
		label.setForeground(Color.red);
		label.setBounds(450, 260, 350, 25);
		getContentPane().add(label);
		label = new JLabel("Devolução de:");
		label.setBounds(456, 260, 350, 25);
		getContentPane().add(label);

		txfAlunoDevolucao = new JTextField();
		txfAlunoDevolucao.setBounds(450, 280, 380, 28);
		txfAlunoDevolucao.setToolTipText("Insira o nome completo");
		getContentPane().add(txfAlunoDevolucao);
		txfAlunoDevolucao.setEnabled(false);

		label = new JLabel("*");
		label.setForeground(Color.red);
		label.setBounds(450, 200, 350, 25);
		getContentPane().add(label);
		label = new JLabel("Livro:");
		label.setBounds(456, 200, 350, 25);
		getContentPane().add(label);

		cbxLivroEmprestado = new JComboBox<String>();
		cbxLivroEmprestado.setBounds(450, 220, 380, 28);
		cbxLivroEmprestado.addItem("-Selecione-");
		listaLivrosDevolucao.forEach(l -> cbxLivroEmprestado.addItem(l.getNome()));
		cbxLivroEmprestado.setToolTipText("Insira o nome completo");
		getContentPane().add(cbxLivroEmprestado);

		// Listeners troca comboboxes
		cbxLivroEmprestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idAluno = buscarIdAluno();
				
				Aluno aluno = new Aluno();
				aluno = aD.buscarAlunoPorId(idAluno);
				txfAlunoDevolucao.setText(aluno.getNome());
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(450, 330, 95, 28);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(555, 330, 95, 28);
		getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devolverLivro();
			}
		});
	}

	public void devolverLivro() {
		
		BookDao bookDao = new BookDao();
		
		bookDao.devolverLivro(cbxLivroEmprestado.getSelectedItem().toString());
	    limparCampos();
	}
	
	public int buscarIdAluno() {
		
		for(int i = 0;i<listaLivrosDevolucao.size();i++) {
			if(listaLivrosDevolucao.get(i).getNome().equals(cbxLivroEmprestado.getSelectedItem().toString())) {
				return listaLivrosDevolucao.get(i).getEmprestimo();
			}
		}
		
		return -1;
	}
	
	public void limparCampos() {
		cbxLivroEmprestado.setSelectedIndex(0);
		txfAlunoDevolucao.setText("");
	}
}
