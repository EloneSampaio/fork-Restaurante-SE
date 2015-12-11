package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alee.log.Log;
import com.forksystem.dao.IOperacao;
import com.forksystem.dao.IProduto;
import com.forksystem.entities.Operacao;
import com.forksystem.entities.Produto;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewEstoque;
import com.forksystem.ui.ViewPrincipal;
import com.forksystem.utils.Context;
import com.forksystem.utils.GeradorDeGrafico;
import com.forksystem.utils.Utilitario;

public class EstoqueController {

	public ViewEstoque gui = null;
	private IProduto dao1 = null;
	private IOperacao dao5 = null;

	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;
	private Long idProduto = null;

	public EstoqueController() {

		gui = new ViewEstoque();
		dao1 = Context.getInstace().getContexto().getBean(IProduto.class);
		dao5 = Context.getInstace().getContexto().getBean(IOperacao.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirCliente()));
		personalizarTabela();
		gui.ouvinte(new OuvirCliente(), gui.getBtnAdicionar());
		gui.ouvinte(new OuvirCliente(), gui.getBtnCancelar());

	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Produto dados : dao1.findAll()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getestoqueCritico(),
					dados.getPrecoCompra(), dados.getPrecoVenda(), };
			linha.add(object);

		}

		String[] colunas = new String[] { "ID", "NOME", "Minimo", "Compra", "Venda" };
		tabela = new TableModelPersonalizado(linha, colunas);
		gui.getTable().setModel(tabela);
		gui.getTable().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		sorter = new TableRowSorter<TableModel>(tabela);
		gui.getTable().setRowSorter(sorter);
		gui.getTxtPesquisar().addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				String valor = gui.getTxtPesquisar().getText().trim();
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + valor, 1));

			}
		});

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
	}

	public void adicionar() {

		int row = gui.getTable().getSelectedRow();
		Operacao estoque = new Operacao();

		if (!(row == -1)) {

			estoque.setQtd(new BigDecimal(gui.getTxtQuantdade().getText()));
			estoque.setData(Calendar.getInstance());
			estoque.setTipo(1);
			estoque.setProduto(dao1.findOne(getIdProduto()));
		} else {
			alerta("Seleciona um produto");
			return;
		}
		try {
			dao5.saveAndFlush(estoque);
			alerta("Operação realizada");
			setIdProduto(null);
			initializeTable();

		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");

		}

	}

	public void remover() {

		int[] linhas = gui.getTable().getSelectedRows();
		for (int i = 0; i < linhas.length; i++) {
			Long produto = (Long) gui.getTable().getValueAt(linhas[i], 0);
			try {
				dao1.delete(produto);

			} catch (Exception e) {
				Log.error(e.getMessage());
			}
		}
		alerta("Removido");
		initializeTable();
	}

	public Boolean confirmar() {
		String ObjButtons[] = { "Sim", "Não" };
		int opcao = JOptionPane.showOptionDialog(gui, "Deseja remover?", "Cancelar", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
		if (opcao == JOptionPane.YES_OPTION) {
			control = true;
		} else {
			control = false;
		}
		return control;
	}

	/*
	 * Metodo que habilita os campos par edição
	 */

	public void verificarTodos() {

		if (new Utilitario(gui.getPanel()).verificarCampos()) {
			alerta("preencha os campos");

		}

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

	public void limparTodos() {

	}

	public void preencherCampos(Produto produto) {

	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public class OuvirCliente implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "adicionar") {

				adicionar();

			}
			if (e.getActionCommand() == "cancelar") {
				limparTodos();
			}

		}

		public void mouseClicked(MouseEvent e) {
			GeradorDeGrafico graf;
			int entrada = 0;
			int saida;
			try {

				Long produto = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);
				setIdProduto(produto);
				entrada = dao5.buscaByTipo(dao1.findOne(produto), 1) == null ? 0
						: dao5.buscaByTipo(dao1.findOne(produto), 1);
				saida = dao5.buscaByTipo(dao1.findOne(produto), 2) == null ? 0
						: dao5.buscaByTipo(dao1.findOne(produto), 2);
				
				if (!(saida == 0)) {
					graf = new GeradorDeGrafico("Dados de Estoque do Produto", entrada, saida);
					System.out.println(saida);

					graf.pack();
					graf.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(graf);
					graf.setSelected(true);
				}

			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

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
