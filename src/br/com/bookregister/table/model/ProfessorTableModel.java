package br.com.bookregister.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.bookregister.model.bean.Professor;

public class ProfessorTableModel extends AbstractTableModel{
	private static final long serialVersionUID = -3586211638575736174L;

	private List<Professor> professores;
	private String[] colunas = new String[] { "ID", "Nome", "Descri��o"};

	public ProfessorTableModel(List<Professor> professores) {
		this.professores = professores;
	}

	public ProfessorTableModel() {
		this.professores = new ArrayList<Professor>();
	}

	public int getRowCount() {
		return professores.size();
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

	public void setValueAt(Professor aValue, int rowIndex) {
		Professor professor = professores.get(rowIndex);

		professor.setId(aValue.getId());
		professor.setNome(aValue.getNome());
		professor.setDescricao(aValue.getDescricao());

		fireTableCellUpdated(rowIndex, 0);
		fireTableCellUpdated(rowIndex, 1);
		fireTableCellUpdated(rowIndex, 2);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Professor professor = professores.get(rowIndex);

		switch (columnIndex) {
		case 0:
			professor.setId(Integer.parseInt(aValue.toString()));
		case 1:
			professor.setNome(aValue.toString());
		case 2:
			professor.setDescricao(aValue.toString());
		default:
			System.err.println("�ndice da coluna inv�lido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Professor professorSelecionado = professores.get(rowIndex);
		String valueObject = null;
		switch (columnIndex) {
		case 0:
			valueObject = Integer.toString(professorSelecionado.getId());
			break;
		case 1:
			valueObject = professorSelecionado.getNome();
			break;
		case 2:
			valueObject = professorSelecionado.getDescricao();
			break;
		default:
			System.err.println("�ndice inv�lido para propriedade do bean Professor.class");
		}

		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Professor getProfessor(int indiceLinha) {
		return professores.get(indiceLinha);
	}

	public void addProfessor(Professor u) {
		professores.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeProfessor(int indiceLinha) {
		professores.remove(indiceLinha);

		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	public void addListaDeProfessores(List<Professor> novosProfessores) {

		int tamanhoAntigo = getRowCount();
		professores.addAll(novosProfessores);
		fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
	}

	public void limpar() {
		professores.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return professores.isEmpty();
	}
}
