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
		super("Informações do Aluno");
		this.alunoSelecionado = alunoSelecionado;
		criarComponentes();	
	
	}

	public void criarComponentes() {

		// Coluna da esquerda, campos e escritas
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Código do Aluno:");
		labes.setBounds(456, 10, 250, 25);
		getContentPane().add(labes);

		txfCod = new JTextField(Integer.toString(alunoSelecionado.getId()));
		txfCod.setBounds(450, 30, 135, 28);
		txfCod.setEnabled(false);
		getContentPane().add(txfCod);
		txfCod.setEnabled(false);
		
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
		cbxProfessor.setEnabled(false);
		getContentPane().add(cbxProfessor);	
		cbxProfessor.setEnabled(false);
					
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 60, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(456, 60, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField(alunoSelecionado.getNome());
		txfNome.setBounds(450, 80, 380, 28);
		txfNome.setEnabled(false);
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
		cbxGenero.setEnabled(false);
		cbxGenero.setBounds(640, 130, 190, 28);
		cbxGenero.setToolTipText("Informe o sexo");
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
			txfData.setToolTipText("Digite a data de nascimento");
			txfData.setEnabled(false);
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
			txfFone.setEnabled(false);
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
			txfCel.setEnabled(false);
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
			cbxCidade.setEnabled(false);
			getContentPane().add(cbxCidade);
			
			labes = new JLabel("Número:");
			labes.setBounds(755, 310, 50, 25);
			getContentPane().add(labes);

			txfNum = new JFormattedTextField(alunoSelecionado.getNumero());
			txfNum.setBounds(755, 330, 75, 28);
			txfNum.setEnabled(false);
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
		txfEmail.setEnabled(false);
		getContentPane().add(txfEmail);
		
		// coluna da direita, cmpos e escrita

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 310, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Endereço:");
		labes.setBounds(456, 310, 250, 25);
		getContentPane().add(labes);

		txfEnder = new JTextField(alunoSelecionado.getEndereco());
		txfEnder.setBounds(450, 330, 280, 28);
		txfEnder.setEnabled(false);
		getContentPane().add(txfEnder);

		labes = new JLabel("Complemento:");
		labes.setBounds(450, 360, 250, 25);
		getContentPane().add(labes);

		txfComplemen = new JTextField(alunoSelecionado.getComplemento());
		txfComplemen.setBounds(450, 380, 380, 28);
		txfComplemen.setEnabled(false);
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
		txfBairro.setEnabled(false);
		getContentPane().add(txfBairro);
		
		labes = new JLabel("Observação:");
		labes.setBounds(450, 410, 350, 25);
		getContentPane().add(labes);

		txfObs = new JTextField(alunoSelecionado.getObservacao());
		txfObs.setBounds(450, 430, 380, 28);
		txfObs.setEnabled(false);
		getContentPane().add(txfObs);
	}
}
