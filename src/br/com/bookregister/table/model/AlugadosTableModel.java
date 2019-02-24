package br.com.bookregister.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.bookregister.model.bean.LivrosAlugado;

public class AlugadosTableModel extends AbstractTableModel{
	private static final long serialVersionUID = -3586211638575736174L;

	private List<LivrosAlugado> livros;
	private String[] colunas = new String[] { "Livro", "Empréstimo"};

	public AlugadosTableModel(List<LivrosAlugado> book) {
		this.livros = book;
	}

	public AlugadosTableModel() {
		this.livros = new ArrayList<LivrosAlugado>();
	}

	public int getRowCount() {
		return livros.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public void setValueAt(LivrosAlugado aValue, int rowIndex) {
		LivrosAlugado book = livros.get(rowIndex);

		book.setEmprestimo(aValue.getEmprestimo());
		book.setNome(aValue.getNome());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		LivrosAlugado book = livros.get(rowIndex);

		switch (columnIndex) {
		case 0:
			book.setNome(aValue.toString());
		case 1:
			book.setEmprestimo(aValue.toString());
	
		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		LivrosAlugado livroSelecionado = livros.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = livroSelecionado.getNome();
			break;
		case 1:
			valueObject = livroSelecionado.getEmprestimo();
			break;
		
		default:
			System.err.println("Índice inválido para propriedade do bean Aluno.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public LivrosAlugado getBook(int indiceLinha) {
		return livros.get(indiceLinha);
	}

	public void addAluno(LivrosAlugado u) {
		livros.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeBook(int indiceLinha) {
		livros.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeAlunos(List<LivrosAlugado> novosLivros) {

		int tamanhoAntigo = getRowCount();
		livros.addAll(novosLivros);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		livros.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return livros.isEmpty();
	}
}
