package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.List;

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
import br.com.bookregister.model.bean.Professor;
import br.com.bookregister.model.dao.AlunoDao;
import br.com.bookregister.model.dao.ProfessorDao;

public class CadastrarAlunosWindow extends AbstractWindowFrame{
	private static final long serialVersionUID = -4479891238469664919L;

	KeyAdapter acao = new KeyAdapter() {
		@Override
		public void keyPressed(java.awt.event.KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				cadastraAluno();
			}
		}
	};
		
	private JTextField txfNome, txfCod, txfEmail, txfObs, txfEnder, txfComplemen, txfBairro;
	private JComboBox<String> cbxGenero, cbxCidade,cbxProfessor;
	private JButton btnSalvar, btnLimpar;
	private JLabel labes;
	private JFormattedTextField txfData, txfFone, txfCel, txfNum;
	private AlunoDao aD = new AlunoDao();
	private ProfessorDao pD = new ProfessorDao();
	private List<Professor> listaProfessor = null;
	
	public CadastrarAlunosWindow() {
		super("Cadastrar Aluno");
		listaProfessor = pD.getProfessores(); 
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
		labes.setBounds(450, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Código do Aluno:");
		labes.setBounds(456, 10, 250, 25);
		getContentPane().add(labes);

		txfCod = new JTextField();
		txfCod.setBounds(450, 30, 135, 28);
		txfCod.setToolTipText("Digite o código do aluno");
		getContentPane().add(txfCod);
		txfCod.addKeyListener((KeyListener) acao);
		txfCod.setText(aD.getCodigoProximoAluno());
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
		cbxProfessor.addItem("-Selecione-");
		cbxProfessor.setBounds(610, 30, 220, 28);
		listaProfessor.forEach(p -> cbxProfessor.addItem(p.getNome()));
		cbxProfessor.setToolTipText("Informe o professor do aluno");
		getContentPane().add(cbxProfessor);
		cbxProfessor.addKeyListener((KeyListener) acao);	
					
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 60, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(456, 60, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField();
		txfNome.setBounds(450, 80, 380, 28);
		txfNome.setToolTipText("Digite o nome completo");
		getContentPane().add(txfNome);
		txfNome.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(640, 110, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Sexo:");
		labes.setBounds(646, 110, 250, 25);
		getContentPane().add(labes);

		cbxGenero = new JComboBox<String>();
		cbxGenero.addItem("-Selecione-");
		cbxGenero.addItem("Masculino");
		cbxGenero.addItem("Feminino");
		cbxGenero.setBounds(640, 130, 190, 28);
		cbxGenero.setToolTipText("Informe o sexo");
		getContentPane().add(cbxGenero);
		cbxGenero.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 110, 230, 25);
		getContentPane().add(labes);
		labes = new JLabel("Data de Nascimento:");
		labes.setBounds(456, 110, 230, 25);
		getContentPane().add(labes);
		
		try {
			
			txfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txfData.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfData.setBounds(450, 130, 155, 28);
			txfData.setToolTipText("Digite a data de nascimento");
			getContentPane().add(txfData);
			txfData.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(450, 160, 125, 25);
			getContentPane().add(labes);
			labes = new JLabel("Telefone:");//
			labes.setBounds(456, 160, 125, 25);
			getContentPane().add(labes);

			txfFone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			txfFone.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfFone.setBounds(450, 180, 155, 28);
			txfFone.setToolTipText("Digite o telefone");
			getContentPane().add(txfFone);
			txfFone.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(640, 160, 190, 25);
			getContentPane().add(labes);
			labes = new JLabel("Celular:");
			labes.setBounds(646, 160, 190, 25);
			getContentPane().add(labes);

			txfCel = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
			txfCel.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfCel.setBounds(640, 180, 190, 28);
			txfCel.setToolTipText("Digite o celular");
			getContentPane().add(txfCel);
			txfCel.addKeyListener((KeyListener) acao);
					
			// Cidade
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(450, 260, 100, 25);
			getContentPane().add(labes);
			labes = new JLabel("Cidade:");
			labes.setBounds(456, 260, 100, 25);
			getContentPane().add(labes);

			cbxCidade = new JComboBox<String>();
			cbxCidade.addItem("-Selecione-");
			cbxCidade.setBounds(450, 280, 170, 28);
			cbxCidade.setToolTipText("Informe a cidade");
			getContentPane().add(cbxCidade);
			cbxCidade.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("Número:");
			labes.setBounds(755, 310, 50, 25);
			getContentPane().add(labes);

			txfNum = new JFormattedTextField(new MaskFormatter("##########"));
			txfNum.setBounds(755, 330, 75, 28);
			txfNum.setToolTipText("Digite o número");
			getContentPane().add(txfNum);
			txfNum.addKeyListener((KeyListener) acao);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 210, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Email:");
		labes.setBounds(456, 210, 350, 25);
		getContentPane().add(labes);

		txfEmail = new JTextField();
		txfEmail.setBounds(450, 230, 380, 28);
		txfEmail.setToolTipText("Digite o email");
		getContentPane().add(txfEmail);
		txfEmail.addKeyListener((KeyListener) acao);
		
		// coluna da direita, cmpos e escrita

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 310, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Endereço:");
		labes.setBounds(456, 310, 250, 25);
		getContentPane().add(labes);

		txfEnder = new JTextField();
		txfEnder.setBounds(450, 330, 280, 28);
		txfEnder.setToolTipText("Digite o endereço");
		getContentPane().add(txfEnder);
		txfEnder.addKeyListener((KeyListener) acao);

		labes = new JLabel("Complemento:");
		labes.setBounds(450, 360, 250, 25);
		getContentPane().add(labes);

		txfComplemen = new JTextField();
		txfComplemen.setBounds(450, 380, 380, 28);
		txfComplemen.setToolTipText("Digite o complemento");
		getContentPane().add(txfComplemen);
		txfComplemen.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(650, 260, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Bairro:");
		labes.setBounds(656, 260, 250, 25);
		getContentPane().add(labes);

		txfBairro = new JTextField();
		txfBairro.setBounds(650, 280, 180, 28);
		txfBairro.setToolTipText("Digite o bairro");
		getContentPane().add(txfBairro);
		txfBairro.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("Observação:");
		labes.setBounds(450, 410, 350, 25);
		getContentPane().add(labes);

		txfObs = new JTextField();
		txfObs.setBounds(450, 430, 380, 28);
		txfObs.setToolTipText("Digite uma observação");
		getContentPane().add(txfObs);
		txfObs.addKeyListener((KeyListener) acao);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(450, 480, 95, 28);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(555, 480, 95, 28);
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
			Aluno aluno = new Aluno();
			AlunoDao aD = new AlunoDao();
			
			aluno.setNome(txfNome.getText());
			String auxSexo = cbxGenero.getSelectedItem().toString();
			aluno.setSexo(auxSexo);
			aluno.setDataNascimento(txfData.getText());
			aluno.setTelefone(txfFone.getText());
			aluno.setCelular(txfCel.getText());
			aluno.setEmail(txfEmail.getText());
			aluno.setObservacao(txfObs.getText());
			aluno.setEndereco(txfEnder.getText());
			aluno.setComplemento(txfComplemen.getText());
			aluno.setBairro(txfBairro.getText());
			aluno.setNumero("128");
			aluno.setCidade("Içara");
			aluno.setProfessor("Claudionor");
			
			aD.registerStudent(aluno);
		}
	}
	

	public boolean validarCamposObrigatorios() {
		if(txfNome.getText().isEmpty() ||
			txfCod.getText().isEmpty() ||
			txfEmail.getText().isEmpty() ||
			txfEnder.getText().isEmpty() ||
			txfBairro.getText().isEmpty() ||
			"-Selecione-".equals(cbxGenero.getSelectedItem()) ||
		//	"-Selecione-".equals(cbxUf.getSelectedItem()) ||
		//	"-Selecione-".equals(cbxPais.getSelectedItem()) ||
			//"-Selecione-".equals(cbxCidade.getSelectedItem()) ||
			txfData.getText().isEmpty() ||
			txfFone.getText().isEmpty() ||
			txfCel.getText().isEmpty() 
		
			) {
			return true;
		}
	
		return false;
	}
	
	
	public void limparFormulario() {

		txfNome.setText("");
		txfCod.setText("");
		txfEmail.setText("");
		txfObs.setText("");
		txfEnder.setText("");
		txfNum.setText("");
		txfComplemen.setText("");
		txfBairro.setText("");
		cbxGenero.setSelectedIndex(0);
		cbxCidade.setSelectedIndex(0);
		txfData.setText("");
		txfFone.setText("");
		txfCel.setText("");
	
	}
}