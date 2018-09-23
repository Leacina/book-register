package br.com.bookregister.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import br.com.bookregister.view.LoginWindow;

public class Window extends JFrame {
	private static final long serialVersionUID = 3283754083146407662L;

	private JMenu menuAlunos;
	private JMenu menuLivros;
	private JMenu menuUsuarios;
	private JMenu menuOpcao;

	private CadastrarUsuarioWindow frameCadastrarUsuario;
	private CadastrarAlunosWindow frameCadastrarAlunos;

	private JDesktopPane desktop;

	public Window() {
		super();

		desktop = new JDesktopPane();
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		desktop.setVisible(true);
		setContentPane(desktop);

		inicializar();

		// Full screen
		setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	private String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	private void inicializar() {
		String dataLogin = getDateTime();
		this.setTitle("Controle de livros v0.0.0-1      " + " - Ultimo Login: " + dataLogin);
		this.setJMenuBar(getWindowMenuBar());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(new Rectangle(0, 0, 796, 713));
		this.setFocusableWindowState(true);
	}

	/*
	 * MENU DE NAVEGA��O
	 */
	private JMenuBar getWindowMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(getMenuAlunos());
		menuBar.add(getMenuLivros());
		menuBar.add(getMenuUsuarios());
		menuBar.add(getMenuOpcao());
		return menuBar;
	}

	// Menu Alunos
	private JMenu getMenuAlunos() {
		menuAlunos = new JMenu();
		menuAlunos.setText("Alunos");
		menuAlunos.setFont(getDefaultFont());

		menuAlunos.add(getMenuItemCadastrarAluno());
		menuAlunos.add(getMenuItemListarAlunos());

		return menuAlunos;
	}

	private JMenuItem getMenuItemCadastrarAluno() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Cadastrar");
		menuItem.setFont(getDefaultFont());

		protegerMenuItemBaseadoPerfilUsuario(menuItem);

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCadastrarAlunos = new CadastrarAlunosWindow();
				abrirFrame(frameCadastrarAlunos);
			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemListarAlunos() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Listar");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		return menuItem;
	}

	// Menu Cidades
	private JMenu getMenuLivros() {
		menuLivros = new JMenu();
		menuLivros.setText("Livros");
		menuLivros.setFont(getDefaultFont());

		menuLivros.add(getMenuItemCadastrarLivros());
		menuLivros.add(getMenuItemListarLivros());

		return menuLivros;
	}

	private JMenuItem getMenuItemCadastrarLivros() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Cadastrar");
		menuItem.setFont(getDefaultFont());

		protegerMenuItemBaseadoPerfilUsuario(menuItem);

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemListarLivros() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Listar");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		return menuItem;
	}

	// Menu Usu�rios
	private JMenu getMenuUsuarios() {
		menuUsuarios = new JMenu();
		menuUsuarios.setText("Usu�rios");
		menuUsuarios.setFont(getDefaultFont());

		menuUsuarios.add(getMenuItemCadastrarUsuario());
		menuUsuarios.add(getMenuItemListarUsuarios());
		menuUsuarios.add(getMenuItemAlterarSenhaUsuario());

		return menuUsuarios;
	}

	private JMenuItem getMenuItemCadastrarUsuario() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Cadastrar");
		menuItem.setFont(getDefaultFont());

		protegerMenuItemBaseadoPerfilUsuario(menuItem);

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCadastrarUsuario = new CadastrarUsuarioWindow();
				abrirFrame(frameCadastrarUsuario);
			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemAlterarSenhaUsuario() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Alterar senha");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemListarUsuarios() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Listar");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		return menuItem;
	}

	// Menu op��es

	private JMenu getMenuOpcao() {
		menuOpcao = new JMenu();
		menuOpcao.setText("Op��es");
		menuOpcao.setFont(getDefaultFont());

		menuOpcao.add(getMenuItemSobre());
		menuOpcao.add(getMenuItemSair());

		return menuOpcao;
	}

	private JMenuItem getMenuItemSobre() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Sobre");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema desenvolvido por:\n\nGiovane Santiago Leacina");
			}
		});

		return menuItem;
	}

	private JMenuItem getMenuItemSair() {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText("Sair");
		menuItem.setFont(getDefaultFont());

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginWindow().setVisible(true);
				setVisible(false);
			}
		});

		return menuItem;
	}

	/*
	 * HELPERS
	 */
	private void protegerMenuItemBaseadoPerfilUsuario(JMenuItem menuItem) {
		// Se usu�rio for diferente de administrador, desabilita menu item

	}

	private Font getDefaultFont() {
		return new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12);
	}

	private void abrirFrame(AbstractWindowFrame frame) {
		boolean frameJaExiste = false;

		// Percorre todos os frames adicionados
		for (JInternalFrame addedFrame : desktop.getAllFrames()) {
			// Se o frame a ser adicionado j� estiver
			if (addedFrame.getTitle().equals(frame.getTitle())) {
				// Se for uma tela com grid, remove a existente para for�ar a atualiza��o da
				// lista
				if (addedFrame instanceof AbstractGridWindow) {
					desktop.remove(addedFrame);

					// Do contr�rio, apenas atribui o frame ao j� existente
				} else {
					frame = (AbstractWindowFrame) addedFrame;
					frameJaExiste = true;
				}

				break;
			}
		}

		try {
			if (!frameJaExiste) {
				desktop.add(frame);
			}

			frame.setSelected(true);
			frame.setMaximum(true);
			frame.setVisible(true);
		} catch (PropertyVetoException e) {
			JOptionPane.showMessageDialog(rootPane, "Houve um erro ao abrir a janela", "", JOptionPane.ERROR_MESSAGE,
					null);
		}
	}

}