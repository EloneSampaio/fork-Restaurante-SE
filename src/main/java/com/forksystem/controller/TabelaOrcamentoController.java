package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.forksystem.dao.IProduto;
import com.forksystem.entities.ItemPedido;
import com.forksystem.entities.Produto;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.models.TableModelVenda;
import com.forksystem.ui.ViewTabelaProduto;
import com.forksystem.ui.ViewVenda;
import com.forksystem.utils.Context;

public class TabelaOrcamentoController {

	public ViewTabelaProduto gui;
	private ViewVenda venda = null;
	private IProduto dao;
	
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public TabelaOrcamentoController(JInternalFrame frame) {
		gui = new ViewTabelaProduto();
		venda = (ViewVenda) frame;
		dao = Context.getInstace().getContexto().getBean(IProduto.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirObjecto()));
		personalizarTabela();
	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Produto dados : dao.findAll()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getDescricao(),
					dados.getPrecoVenda() };
			linha.add(object);

		}

		String[] colunas = new String[] { "COD", "NOME", "DESCRIÇÃO", "PREÇO UNIT" };
		tabela = new TableModelPersonalizado(linha, colunas);
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

		TableModelVenda model = (TableModelVenda) venda.getTable().getModel();

		for (int j = 0; j < model.getRowCount() && achou == false; j++) {
			Object objecto = model.getValueAt(j, 0);
			if (!"".equals(objecto)) {

				if (p.getId().equals(objecto)) {
					pos = j;
					achou = true;
				}
			}
		}

		if (achou) {
			alerta("Produto já adicionado");
			return;
		}

		ItemPedido v = new ItemPedido();
		v.setId(p.getId());
		v.setProduto(p);
		v.getProduto().setNome(p.getNome());
		v.setValorUnitario(p.getPrecoVenda());
		v.setQuantidade(BigDecimal.ONE);
		v.setValorTotal(v.getQuantidade().multiply(v.getValorUnitario()));
		model.addRow(v);
		//venda.getTable().repaint();

	}

	public class OuvirObjecto implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			Long prod = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(dao.findOne(prod));

		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
