package com.forksystem.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.forksystem.dao.IOperacao;
import com.forksystem.dao.IProduto;
import com.forksystem.entities.ItemPedido;
import com.forksystem.entities.Venda;
import com.forksystem.utils.Context;

public class TableModelPedido extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Lista que vai conter todos os dados do JTable
	private List<ItemPedido> colunas;
	JTable tabela = null;
	// Constante que defini o nome das colunas
	private static final String[] col = new String[] {"Nome", "Quantidade", "Valor Unit","Valor Total"};

	// Construtor da classe recebe os dados a ser populado
	public TableModelPedido(List<ItemPedido> bean, JTable table) {

		colunas = new ArrayList<ItemPedido>(bean);

		tabela = table;
		fireTableStructureChanged();
	//	mudar();
	}

	public TableModelPedido() {
	}

	// Método sobrescrito que retorna o número de linhas do JTable, após
	// populado

	public int getRowCount() {
		return colunas.size();
	}

	// Método sobrescrito que retorna o número de colunas do JTable após
	// populado
	public int getColumnCount() {
		return col.length;
	}

	// Método sobrescrito que vai popular e retornar cada célula do JTable

	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemPedido cbean = colunas.get(rowIndex);
		Object row = null;
		switch (columnIndex) {
		case 0:
			row = cbean.getProduto().getNome();
			break;

		case 1:
			row = cbean.getQuantidade();
			break;
		case 2:
			row = cbean.getValorUnitario();
			break;
		case 3:
			row = cbean.getValorTotal();
			break;	
		}
		return row;
	}

	/*
	 * Este método sobrescrito, defini se o JTable será editável ou não. Voce
	 * pode definir qual coluna de qual linha será editável. Caso voce defina
	 * que o seu JTable seja editável, então é necessário definir também o
	 * método "setValueAt" que vem logo a seguir, caso contrário, é só retornar
	 * false para todas as linhas e colunas, como definido abaixo.
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/*
	 * Este método sobrescrito, permite voce editar o JTable, caso o método
	 * anterior tenha algumas colunas de algumas ou todas linhas editáveis
	 * setadas para true, ou que tenha como retorno o valor true para todas as
	 * linhas e colunas.
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		ItemPedido dado = colunas.get(row);
		switch (col) {
		case 0:
			dado.getProduto().setNome((String) value);
			break;

		case 1:
			dado.setQuantidade((BigDecimal) value);
			break;
		case 2:
			dado.setValorUnitario(new BigDecimal((String) value));
			break;
		case 3:
			dado.setValorTotal(new BigDecimal((String) value));
			break;
		
		}
		
		fireTableCellUpdated(row, col);
	}

	// Este método sobrescrito defini que tipo de dado será retornado para cada
	// coluna
	@Override
	public Class getColumnClass(int column) {
		if (column == 0 || column == 3) {
			return BigDecimal.class;
		} else {
			return String.class;
		}
	}

	/*
	 * Este método criado por nós, vai retornar o conjunto de dados inteiro do
	 * JTable, através de um List contendo Objetos itempedidos populados.
	 */
	public List<ItemPedido> getDataSet() {
		return colunas;
	}

	/*
	 * Este método sobrescrito vai definir o nome das colunas que foi atribuído
	 * na constante "col" logo no início da classe
	 */
	@Override
	public String getColumnName(int column) {
		return col[column];
	}

	/*
	 * Este método foi criado por nós para retornar um objeto ClienteBean
	 * populado, de acordo com o número de linha do JTable fornecido pelo
	 * parâmetro "int row"
	 */
	public ItemPedido getRow(int row) {
		return colunas.get(row);
	}

	/*
	 * Este método criado por nós, serve para voce criar um ClienteBean e
	 * populá-lo fora do JTable e passar para este método que vai acrescentar os
	 * dados na última linha do JTable sem que haja a necessidade de se usar o
	 * método "setValueAt(...)"
	 */
	public void addRow(ItemPedido bean) {
		colunas.add(bean);
		fireTableDataChanged();
	}

	/*
	 * Este método foi criado por nós para remover uma linha específica do
	 * JTable, de acordo com linha fornecida pelo parâmetro "int row"
	 */
	public void removeRow(int row) {
		colunas.remove(row);
		fireTableDataChanged();
	}

	/*
	 * Este método criado por nós, acrescenta uma linha em branco no JTable,
	 * caso voce queira inserir dados diretamente no JTable tem que chamar este
	 * método antes.
	 */
	public void addEmptyRow() {
		colunas.add(new ItemPedido());
		fireTableDataChanged();
	}


	public BigDecimal somarTodos() {
		BigDecimal soma = null;
		try {
			soma = new BigDecimal("0.0");
			for (int i = 0; i <= tabela.getColumnCount(); i++) {
				BigDecimal valor = (BigDecimal) tabela.getValueAt(i, 3);
				soma = soma.add(valor);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		return soma;

	}

	public List<ItemPedido> getColunas() {
		return colunas;
	}

	public void setColunas(List<ItemPedido> colunas) {
		this.colunas = colunas;
	}



}
