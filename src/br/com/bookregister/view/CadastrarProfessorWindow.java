package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.bookregister.model.bean.Professor;
import br.com.bookregister.model.dao.ProfessorDao;

public class CadastrarProfessorWindow extends AbstractWindowFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txfNome, txfDescricao;
	private JLabel label;
	private JButton btnSalvar,btnLimpar;
	
	public CadastrarProfessorWindow() {
		super("Cadastrar Professor");
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
		label.setBounds(450, 200, 350, 25);
		getContentPane().add(label);
		label = new JLabel("Nome:");
		label.setBounds(456, 200, 350, 25);
		getContentPane().add(label);
		
		txfNome = new JTextField();
		txfNome.setBounds(450, 220, 380, 28);
		txfNome.setToolTipText("Insira o nome completo");
		getContentPane().add(txfNome);
		
		label = new JLabel("Descrição:");
		label.setBounds(456, 260, 350, 25);
		getContentPane().add(label);
		
		txfDescricao = new JTextField();
		txfDescricao.setBounds(450, 280, 380, 60);
		txfDescricao.setToolTipText("Descrição do professor");
		getContentPane().add(txfDescricao);
		
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
				cadastrarProfessor();
			}
		});
	}
	
	public void cadastrarProfessor() {
		Professor professor = new Professor();
		ProfessorDao professorDao = new ProfessorDao();
		
		professor.setNome(txfNome.getText());
		professor.setDescricao(txfDescricao.getText());
		
		professorDao.registerProfessor(professor);
	}
}
