package com.forksystem.models;

import java.util.ArrayList;


import javax.swing.table.AbstractTableModel;

public class TableModelPersonalizado extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList linhas = null;
	private String[] colunas = null;

	public TableModelPersonalizado(ArrayList lin, String[] col) {
		setLinhas(lin);
		setColunas(col);
	
	}

	public void add(ArrayList cl) {
		this.linhas.add(cl);
		fireTableDataChanged();
	}

	public void remove(int index) {
		linhas.remove(index);
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int column) {

		return colunas[column];
	}

	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object[] objecto = (Object[]) getLinhas().get(rowIndex);
		return objecto[columnIndex];
	}



	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}

}
