package com.forksystem.controller;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alee.log.Log;
import com.forksystem.controller.FornecedorController.OuvirObjecto;
import com.forksystem.dao.ICartao;
import com.forksystem.dao.IConta;
import com.forksystem.dao.IPessoa;
import com.forksystem.dao.IProduto;
import com.forksystem.entities.Cartao;
import com.forksystem.entities.Conta;
import com.forksystem.entities.Endereco;
import com.forksystem.entities.Fornecedor;
import com.forksystem.entities.Pessoa;
import com.forksystem.entities.Produto;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewCartao;
import com.forksystem.ui.ViewConta;
import com.forksystem.ui.ViewProduto;
import com.forksystem.ui.ViewTabelaFornecedor;
import com.forksystem.ui.ViewTabelaProduto;
import com.forksystem.ui.ViewVenda;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

import antlr.collections.impl.Vector;

public class TabelaVendaController {

	public ViewVenda gui;

	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	private TableRowSorter<TableModel> sorter = null;
	private List<String> produtos;

	public TabelaVendaController() {
		produtos = new ArrayList<String>();
		initializeTable();
		gui.getTable().getModel().addTableModelListener((new OuvirObjecto()));
		personalizarTabela();
	}

	public void initializeTable() {
		String[] colunas = new String[] { "Cod Produto", "Quantidade", "Valor Unitario", "Valor Total" };
		tabela = new TableModelPersonalizado((ArrayList) produtos, colunas);
		gui.getTable().setModel(tabela);
		gui.getTable().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
	}

	public void personalizarTabela() {
		gui.getTable().setAutoCreateColumnsFromModel(true);
		gui.getTable().setAutoscrolls(true);
		JTableHeader headerTable = gui.getTable().getTableHeader();
		headerTable.setDefaultRenderer(new HeaderCellRenderer());
		gui.getTable().setTableHeader(headerTable);
		gui.getTable().setSelectionBackground(Color.yellow);
		gui.getTable().setSelectionForeground(new Color(0, 0, 0));
		gui.getTable().setGridColor(new Color(221, 221, 221));

		gui.getTable().setDefaultRenderer(Object.class, new CellRenderer());
	}

	public void preencherCampos(Produto p) {
		int pos = 0;
		boolean achou = false;

		DefaultTableModel model = (DefaultTableModel) gui.getTable().getModel();

		for (int j = 0; j < model.getRowCount() && achou == false; j++) {
			Object objecto = model.getValueAt(j, 0);
			if (objecto.equals(p.getId())) {
				pos = j;
				achou = true;
			}
		}
		if (achou) {
			alerta("Produto já adicionado");
			return;
		}

		produtos.add(p.getId().toString());
		produtos.add("1");
		produtos.add(p.getPrecoVenda().toString());
		produtos.add("");
		model.addRow((java.util.Vector) produtos);
		gui.getTable().repaint();

	}

	public class OuvirObjecto implements TableModelListener {

		public void tableChanged(TableModelEvent e) {
			int qtd;
			int total;
			int prec;
			double preco = 0;
			int firstRow = e.getFirstRow();
			int lastRow = e.getLastRow();
			int coluna = e.getColumn();
			
			

			DefaultTableModel model = (DefaultTableModel) gui.getTable().getModel();
			switch (e.getType()) {
			case TableModelEvent.UPDATE:
				for (int r = firstRow; r <= lastRow; r++) {
					BigDecimal b =new BigDecimal((model.getValueAt(firstRow, coluna).toString())); 
					BigDecimal p = new BigDecimal(model.getValueAt(firstRow, 2).toString());

					if (!b.equals("")) {
						BigDecimal w = new BigDecimal(b.multiply(p).toString());
						 model.setValueAt(w.toString(), firstRow,3);
						 System.out.println(w);


					} else {
						System.out.println("vazio");
					}
					
					
				}

				break;
			}
			
		
		}

		}

	}

