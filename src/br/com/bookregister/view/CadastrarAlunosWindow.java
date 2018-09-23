package br.com.bookregister.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
	private JComboBox<String> cbxGenero, cbxCidade, cbxUf, cbxPais;
	private JButton btnSalvar, btnLimpar;
	private JLabel labes;
	private JFormattedTextField txfData, txfFone, txfCel, txfCep, txfNum;

	public CadastrarAlunosWindow() {
		super("Cadastrar Aluno");
		criarComponentes();
	}

	public void criarComponentes() {

		// Coluna da esquerda, campos e escritas
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(15, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("C�digo do Aluno:");
		labes.setBounds(21, 10, 250, 25);
		getContentPane().add(labes);

		txfCod = new JTextField();
		txfCod.setBounds(15, 30, 125, 25);
		txfCod.setToolTipText("Digite o c�digo do aluno");
		getContentPane().add(txfCod);
		txfCod.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(15, 60, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Nome:");
		labes.setBounds(21, 60, 350, 25);
		getContentPane().add(labes);

		txfNome = new JTextField();
		txfNome.setBounds(15, 80, 350, 25);
		txfNome.setToolTipText("Digite o nome completo");
		getContentPane().add(txfNome);
		txfNome.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(175, 110, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Sexo:");
		labes.setBounds(181, 110, 250, 25);
		getContentPane().add(labes);

		cbxGenero = new JComboBox<String>();
		cbxGenero.addItem("-Selecione-");
		cbxGenero.addItem("Masculino");
		cbxGenero.addItem("Feminino");
		cbxGenero.setBounds(175, 130, 190, 25);
		cbxGenero.setToolTipText("Informe o sexo");
		getContentPane().add(cbxGenero);
		cbxGenero.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(15, 110, 230, 25);
		getContentPane().add(labes);
		labes = new JLabel("Data de Nascimento:");
		labes.setBounds(21, 110, 230, 25);
		getContentPane().add(labes);
		
		try {
			
			txfData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txfData.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfData.setBounds(15, 130, 125, 25);
			txfData.setToolTipText("Digite a data de nascimento");
			getContentPane().add(txfData);
			txfData.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(15, 160, 125, 25);
			getContentPane().add(labes);
			labes = new JLabel("Telefone:");//
			labes.setBounds(21, 160, 125, 25);
			getContentPane().add(labes);

			txfFone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
			txfFone.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfFone.setBounds(15, 180, 125, 25);
			txfFone.setToolTipText("Digite o telefone");
			getContentPane().add(txfFone);
			txfFone.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(175, 160, 190, 25);
			getContentPane().add(labes);
			labes = new JLabel("Celular:");
			labes.setBounds(181, 160, 190, 25);
			getContentPane().add(labes);

			txfCel = new JFormattedTextField(new MaskFormatter("(##) # ####-####"));
			txfCel.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfCel.setBounds(175, 180, 190, 25);
			txfCel.setToolTipText("Digite o celular");
			getContentPane().add(txfCel);
			txfCel.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("*");
			labes.setForeground(Color.red);
			labes.setBounds(450, 110, 100, 25);
			getContentPane().add(labes);
			labes = new JLabel("CEP:");
			labes.setBounds(456, 110, 100, 25);
			getContentPane().add(labes);

			txfCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			txfCep.setFocusLostBehavior(JFormattedTextField.COMMIT);
			txfCep.setBounds(450, 130, 100, 25);
			txfCep.setToolTipText("Digite o CEP");
			getContentPane().add(txfCep);
			txfCep.addKeyListener((KeyListener) acao);
			
			labes = new JLabel("N�mero:");
			labes.setBounds(675, 10, 50, 25);
			getContentPane().add(labes);

			txfNum = new JFormattedTextField(new MaskFormatter("##########"));
			txfNum.setBounds(675, 30, 75, 25);
			txfNum.setToolTipText("Digite o n�mero");
			getContentPane().add(txfNum);
			txfNum.addKeyListener((KeyListener) acao);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(15, 210, 350, 25);
		getContentPane().add(labes);
		labes = new JLabel("Email:");
		labes.setBounds(21, 210, 350, 25);
		getContentPane().add(labes);

		txfEmail = new JTextField();
		txfEmail.setBounds(15, 230, 350, 25);
		txfEmail.setToolTipText("Digite o email");
		getContentPane().add(txfEmail);
		txfEmail.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("Observa��o:");
		labes.setBounds(15, 260, 350, 25);
		getContentPane().add(labes);

		txfObs = new JTextField();
		txfObs.setBounds(15, 280, 350, 25);
		txfObs.setToolTipText("Digite uma observa��o");
		getContentPane().add(txfObs);
		txfObs.addKeyListener((KeyListener) acao);

		// coluna da direita, cmpos e escrita

		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 10, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Endere�o:");
		labes.setBounds(456, 10, 250, 25);
		getContentPane().add(labes);

		txfEnder = new JTextField();
		txfEnder.setBounds(450, 30, 200, 25);
		txfEnder.setToolTipText("Digite o endere�o");
		getContentPane().add(txfEnder);
		txfEnder.addKeyListener((KeyListener) acao);

		labes = new JLabel("Complemento:");
		labes.setBounds(450, 60, 250, 25);
		getContentPane().add(labes);

		txfComplemen = new JTextField();
		txfComplemen.setBounds(450, 80, 300, 25);
		txfComplemen.setToolTipText("Digite o complemento");
		getContentPane().add(txfComplemen);
		txfComplemen.addKeyListener((KeyListener) acao);
		
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(570, 110, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Bairro:");
		labes.setBounds(576, 110, 250, 25);
		getContentPane().add(labes);

		txfBairro = new JTextField();
		txfBairro.setBounds(570, 130, 180, 25);
		txfBairro.setToolTipText("Digite o bairro");
		getContentPane().add(txfBairro);
		txfBairro.addKeyListener((KeyListener) acao);
		
		// Pa�s
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 160, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Pa�s:");
		labes.setBounds(456, 160, 250, 25);
		getContentPane().add(labes);

		cbxPais = new JComboBox<String>();
		cbxPais.addItem("-Selecione-");
		
		cbxPais.setBounds(450, 180, 200, 25);
		cbxPais.setToolTipText("Informe o pa�s");
		getContentPane().add(cbxPais);
		cbxPais.addKeyListener((KeyListener) acao);
		
		// Estado
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 210, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("UF:");
		labes.setBounds(456, 210, 250, 25);
		getContentPane().add(labes);

		cbxUf = new JComboBox<String>();
		cbxUf.addItem("-Selecione-");
		cbxUf.setBounds(450, 230, 200, 25);
		cbxUf.setToolTipText("Informe o UF");
		getContentPane().add(cbxUf);
		cbxUf.addKeyListener((KeyListener) acao);
		
		// Cidade
		labes = new JLabel("*");
		labes.setForeground(Color.red);
		labes.setBounds(450, 260, 250, 25);
		getContentPane().add(labes);
		labes = new JLabel("Cidade:");
		labes.setBounds(456, 260, 250, 25);
		getContentPane().add(labes);

		cbxCidade = new JComboBox<String>();
		cbxCidade.addItem("-Selecione-");
		cbxCidade.setBounds(450, 280, 200, 25);
		cbxCidade.setToolTipText("Informe a cidade");
		getContentPane().add(cbxCidade);
		cbxCidade.addKeyListener((KeyListener) acao);
		
		// Listeners troca comboboxes
		cbxPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paisSelecionado = (String) cbxPais.getSelectedItem();

				// Reseta estados e cidades
				cbxUf.removeAllItems();
				cbxUf.addItem("-Selecione-");
				cbxCidade.removeAllItems();
				cbxCidade.addItem("-Selecione-");

				if (paisSelecionado == null) {
					return;
				}
			}
		});

		cbxUf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String paisSelecionado = (String) cbxPais.getSelectedItem();
				String estadoSelecionado = (String) cbxUf.getSelectedItem();

				// Reseta estados e cidades
				cbxCidade.removeAllItems();
				cbxCidade.addItem("-Selecione-");

				if (paisSelecionado == null || estadoSelecionado == null) {
					return;
				}

				// Adiciona op��es estados
			}
		});

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(15, 320, 95, 25);
		btnLimpar.setToolTipText("Clique aqui para limpar os campos");
		getContentPane().add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(120, 320, 95, 25);
		getContentPane().add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraAluno();
			}
		});
		
		btnSalvar.addKeyListener((KeyListener) acao);
		
		btnAtualizar = new JButton (new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				cbxUf.setSelectedIndex(0);
				cbxPais.setSelectedIndex(0);
			}
		});
	}
	
	public void cadastraAluno() {
		if(validarCamposObrigatorios()) {
			JOptionPane.showMessageDialog(rootPane, "Campos obrigat�rios (*) n�o preenchidos!", "", JOptionPane.ERROR_MESSAGE, null);
			return;
		}
	}
	

	public boolean validarCamposObrigatorios() {
		if(txfNome.getText().isEmpty() ||
			txfCod.getText().isEmpty() ||
			txfEmail.getText().isEmpty() ||
			txfEnder.getText().isEmpty() ||
			txfBairro.getText().isEmpty() ||
			"-Selecione-".equals(cbxGenero.getSelectedItem()) ||
			"-Selecione-".equals(cbxUf.getSelectedItem()) ||
			"-Selecione-".equals(cbxPais.getSelectedItem()) ||
			"-Selecione-".equals(cbxCidade.getSelectedItem()) ||
			txfData.getText().isEmpty() ||
			txfFone.getText().isEmpty() ||
			txfCel.getText().isEmpty() ||
			txfCep.getText().isEmpty()
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
		cbxUf.setSelectedIndex(0);
		cbxPais.setSelectedIndex(0);
		txfData.setText("");
		txfFone.setText("");
		txfCel.setText("");
		txfCep.setText("");

	}
}