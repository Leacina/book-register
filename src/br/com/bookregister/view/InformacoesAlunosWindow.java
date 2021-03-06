package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.bookregister.model.bean.Aluno;
import br.com.bookregister.model.bean.Professor;
import br.com.bookregister.model.dao.AlunoDao;
import br.com.bookregister.model.dao.ProfessorDao;

public class InformacoesAlunosWindow extends AbstractWindowFrame{	
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txfNome, txfCod, txfEmail, txfObs, txfEnder, txfComplemen, txfBairro;
	private JComboBox<String> cbxGenero, cbxCidade,cbxProfessor;
	private JButton btnSalvar, btnLimpar;
	private JLabel labes;
	private JFormattedTextField txfData, txfFone, txfCel, txfNum;
	private AlunoDao aD = new AlunoDao();
	private ProfessorDao pD = new ProfessorDao();
	private List<Professor> listaProfessor = null;
	private Aluno alunoSelecionado;
	
	public InformacoesAlunosWindow(Aluno alunoSelecionado) {
		super("Informa��es do Aluno");
		this.alunoSelecionado = alunoSelecionado;
		criarComponentes();	
	
	}

	public void criarComponentes() {

		// Coluna da esquerda, campos e escritas
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("C�digo do Aluno:");
		labes.setBounds(456, 10, 250, 25);
		getContentPane().add(labes);

		txfCod = new JTextField(Integer.toString(alunoSelecionado.getId()));
		txfCod.setBounds(450, 30, 135, 28);
		txfCod.setEditable(false);
		getContentPane().add(txfCod);
		
		//Cadastro do professor de um determinado aluno
	    labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(610, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Professor do Aluno:");
		labes.setBounds(616, 10, 250, 25);
		getContentPane().add(labes);

		cbxProfessor = new JComboBox<String>();
		cbxProfessor.addItem(alunoSelecionado.getProfessor());
		cbxProfessor.setBounds(610, 30, 220, 28);
		cbxProfessor.setEditable(false);
		getContentPane().add(cbxProfessor);	
					
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 60, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(456, 60, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField(alunoSelecionado.getNome());
		txfNome.setBounds(450, 80, 380, 28);
		txfNome.setEditable(false);
		getContentPane().add(txfNome);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(640, 110, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Sexo:");
		labes.setBounds(646, 110, 250, 25);
		getContentPane().add(labes);

		cbxGenero = new JComboBox<String>();
		cbxGenero.addItem(alunoSelecionado.getSexo());
		cbxGenero.setEditable(false);
		cbxGenero.setBounds(640, 130, 190, 28);
		getContentPane().add(cbxGenero);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 110, 230, 25);
		getContentPane().add(labes);
		labes = new JLabel("Data de Nascimento:");
		labes.setBounds(456, 110, 230, 25);
		getContentPane().add(labes);

			
			txfData = new JFormattedTextField(alunoSelecionado.getDataNascimento());
			txfData.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfData.setBounds(450, 130, 155, 28);
			txfData.setEditable(false);
			getContentPane().add(txfData);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(450, 160, 125, 25);
			getContentPane().add(labes);
			labes = new JLabel("Telefone:");//
			labes.setBounds(456, 160, 125, 25);
			getContentPane().add(labes);

			txfFone = new JFormattedTextField(alunoSelecionado.getTelefone());
			txfFone.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfFone.setBounds(450, 180, 155, 28);
			txfFone.setToolTipText("Digite o telefone");
			txfFone.setEditable(false);
			getContentPane().add(txfFone);

			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(640, 160, 190, 25);
			getContentPane().add(labes);
			labes = new JLabel("Celular:");
			labes.setBounds(646, 160, 190, 25);
			getContentPane().add(labes);

			txfCel = new JFormattedTextField(alunoSelecionado.getCelular());
			txfCel.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfCel.setBounds(640, 180, 190, 28);
			txfCel.setEditable(false);
			getContentPane().add(txfCel);
					
			// Cidade
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(450, 260, 100, 25);
			getContentPane().add(labes);
			labes = new JLabel("Cidade:");
			labes.setBounds(456, 260, 100, 25);
			getContentPane().add(labes);

			cbxCidade = new JComboBox<String>();
			cbxCidade.addItem(alunoSelecionado.getCidade());
			cbxCidade.setEnabled(false);
			cbxCidade.setBounds(450, 280, 170, 28);
			cbxCidade.setEditable(false);
			getContentPane().add(cbxCidade);
			
			labes = new JLabel("N�mero:");
			labes.setBounds(755, 310, 50, 25);
			getContentPane().add(labes);

			txfNum = new JFormattedTextField(alunoSelecionado.getNumero());
			txfNum.setBounds(755, 330, 75, 28);
			txfNum.setEditable(false);
			getContentPane().add(txfNum);


		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 210, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Email:");
		labes.setBounds(456, 210, 350, 25);
		getContentPane().add(labes);

		txfEmail = new JTextField(alunoSelecionado.getEmail());
		txfEmail.setBounds(450, 230, 380, 28);
		txfEmail.setEditable(false);
		getContentPane().add(txfEmail);
		
		// coluna da direita, cmpos e escrita

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 310, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Endere�o:");
		labes.setBounds(456, 310, 250, 25);
		getContentPane().add(labes);

		txfEnder = new JTextField(alunoSelecionado.getEndereco());
		txfEnder.setBounds(450, 330, 280, 28);
		txfEnder.setEditable(false);
		getContentPane().add(txfEnder);

		labes = new JLabel("Complemento:");
		labes.setBounds(450, 360, 250, 25);
		getContentPane().add(labes);

		txfComplemen = new JTextField(alunoSelecionado.getComplemento());
		txfComplemen.setBounds(450, 380, 380, 28);
		txfComplemen.setEditable(false);
		getContentPane().add(txfComplemen);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(650, 260, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Bairro:");
		labes.setBounds(656, 260, 250, 25);
		getContentPane().add(labes);

		txfBairro = new JTextField(alunoSelecionado.getBairro());
		txfBairro.setBounds(650, 280, 180, 28);
		txfBairro.setEditable(false);
		getContentPane().add(txfBairro);
		
		labes = new JLabel("Observa��o:");
		labes.setBounds(450, 410, 350, 25);
		getContentPane().add(labes);

		txfObs = new JTextField(alunoSelecionado.getObservacao());
		txfObs.setBounds(450, 430, 380, 28);
		txfObs.setEditable(false);
		getContentPane().add(txfObs);
	}
}
