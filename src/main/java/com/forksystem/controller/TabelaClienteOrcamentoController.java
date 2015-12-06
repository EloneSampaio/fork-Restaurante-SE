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

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alee.log.Log;
import com.forksystem.controller.FornecedorController.OuvirObjecto;
import com.forksystem.dao.ICartao;
import com.forksystem.dao.IConta;
import com.forksystem.dao.IPessoa;
import com.forksystem.entities.Cartao;
import com.forksystem.entities.Cliente;
import com.forksystem.entities.Conta;
import com.forksystem.entities.Endereco;
import com.forksystem.entities.Fornecedor;
import com.forksystem.entities.Pessoa;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewCartao;
import com.forksystem.ui.ViewConta;
import com.forksystem.ui.ViewOrcamento;
import com.forksystem.ui.ViewProduto;
import com.forksystem.ui.ViewTabelaCliente;
import com.forksystem.ui.ViewTabelaFornecedor;
import com.forksystem.ui.ViewVenda;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class TabelaClienteOrcamentoController {

	public ViewTabelaCliente gui;
	public ViewOrcamento orcamento=null;
	
	private IPessoa dao;
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public TabelaClienteOrcamentoController(JInternalFrame frame) {
		gui = new ViewTabelaCliente();
		 orcamento=(ViewOrcamento)frame;
		dao = Context.getInstace().getContexto().getBean(IPessoa.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirObjecto()));
		personalizarTabela();
	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Cliente dados : dao.findAllClientes()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getCpf() };
			linha.add(object);

		}

		String[] colunas = new String[] { "COD", "NOME", "CPF/CPNJ" };
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

	public void preencherCampos(Cliente c) {

		orcamento.setarCliente(c.getId()+"");
		orcamento.getTextNomeCliente().setText(c.getNome());
	
		System.out.println(c.getId());
	}

	public class OuvirObjecto implements MouseListener {

		public void mouseClicked(MouseEvent e) {

			Long cl = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(dao.findByCliente(cl));

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
