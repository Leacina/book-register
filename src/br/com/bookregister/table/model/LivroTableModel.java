package br.com.bookregister.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.bookregister.model.bean.Book;

public class LivroTableModel extends AbstractTableModel{
	private static final long serialVersionUID = -3586211638575736174L;

	private List<Book> livros;
	private String[] colunas = new String[] { "Código", "Proprietario", "Nome","Autor","Ano"};

	public LivroTableModel(List<Book> book) {
		this.livros = book;
	}

	public LivroTableModel() {
		this.livros = new ArrayList<Book>();
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

	public void setValueAt(Book aValue, int rowIndex) {
		Book book = livros.get(rowIndex);

		book.setCodigo(aValue.getCodigo());
		book.setNome(aValue.getNome());
		book.setProprietario(aValue.getProprietario());
		book.setAutor(aValue.getAutor());
		book.setAno(aValue.getAno());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
		fireTableCellUpdated(rowIndex, 3);
		fireTableCellUpdated(rowIndex, 4);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Book book = livros.get(rowIndex);

		switch (columnIndex) {
		case 0:
			book.setCodigo(aValue.toString());
		case 1:
			book.setProprietario(aValue.toString());
		case 2:
			book.setNome(aValue.toString());
		case 3:
			book.setAutor(aValue.toString());
		case 4:
			book.setAno(aValue.toString());

		default:
			System.err.println("Índice da coluna inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Book livroSelecionado = livros.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = livroSelecionado.getCodigo();
			break;
		case 1:
			valueObject = livroSelecionado.getProprietario();
			break;
		case 2:
			valueObject = livroSelecionado.getNome();
			break;
		case 3:
			valueObject = livroSelecionado.getAutor();
			break;
		case 4:
			valueObject = livroSelecionado.getAno();
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

	public Book getBook(int indiceLinha) {
		return livros.get(indiceLinha);
	}

	public void addAluno(Book u) {
		livros.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeBook(int indiceLinha) {
		livros.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeLivros(List<Book> novosLivros) {

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
