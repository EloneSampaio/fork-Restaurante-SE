package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.forksystem.dao.IOperacao;
import com.forksystem.dao.IPagamento;
import com.forksystem.dao.IPedido;
import com.forksystem.dao.IPessoa;
import com.forksystem.dao.IProduto;
import com.forksystem.entities.Cliente;
import com.forksystem.entities.ItemPedido;
import com.forksystem.entities.Operacao;
import com.forksystem.entities.Pagamento;
import com.forksystem.entities.Pedido;
import com.forksystem.entities.StatusPedido;
import com.forksystem.entities.TipoPagamentos;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelOrcamento;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.models.TableModelVenda;
import com.forksystem.ui.ViewOrcamento;
import com.forksystem.ui.ViewTabelaVenda;
import com.forksystem.ui.ViewVenda;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class OrcamentoController {

	private IPedido daoPedido = null;
	private TableModelOrcamento orcamento = null;
	private IPessoa pessoa = null;
	private IProduto produto = null;
	private IPagamento DaoPagamento = null;
	public ViewOrcamento gui;
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;
	private TableModelPersonalizado tabelaOrcamento;
	ViewTabelaVenda tab = new ViewTabelaVenda();
	TableModelOrcamento model;

	public OrcamentoController() {
		gui = new ViewOrcamento();
		gui.getPanelTabela().setBackground(new Color(102, 153, 153));
		gui.getContentPane().setBackground(new Color(102, 153, 153));
		gui.getPanelDados().setBackground(new Color(102, 153, 153));
		initializeTable();
		orcamento = new TableModelOrcamento();
		personalizarTabela();
		gui.ouvinte(new OuvirObjecto(), gui.getBtnNovo());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnCancelar());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnConfirmar());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnExcluir());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnImprimir());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnInserirItem());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnCalcularTotal());
		daoPedido = Context.getInstace().getContexto().getBean(IPedido.class);
		pessoa = Context.getInstace().getContexto().getBean(IPessoa.class);
		produto = Context.getInstace().getContexto().getBean(IProduto.class);
		DaoPagamento = Context.getInstace().getContexto().getBean(IPagamento.class);
		model = (TableModelOrcamento) gui.getTable().getModel();

	}

	public void initializeTable() {
		List<ItemPedido> venda = new ArrayList<ItemPedido>();
		model = new TableModelOrcamento(venda, gui.getTable());
		gui.getTable().setModel(model);
		gui.getTable().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
	}

	/*
	 * Metodo para personalizar tabela venda
	 */
	public void ver() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList linha = new ArrayList();

		for (Pedido dados : daoPedido.findAll()) {
			Object object = new Object[] { dados.getId(), dados.getValorTotal(), dados.getValorDesconto(),
					sdf.format(dados.getDataCriacao().getTime()) };
			linha.add(object);

		}

		String[] colunas = new String[] { "COD", "Valor", "Desconto", "Data" };
		tabelaOrcamento = new TableModelPersonalizado(linha, colunas);
		tab.getTable().setModel(tabelaOrcamento);
		tab.getTable().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tab.getTable().setAutoCreateColumnsFromModel(true);
		tab.getTable().setAutoscrolls(true);
		JTableHeader headerTable = tab.getTable().getTableHeader();
		headerTable.setDefaultRenderer(new HeaderCellRenderer());
		tab.getTable().setTableHeader(headerTable);
		tab.getTable().setSelectionBackground(Color.yellow);
		tab.getTable().setSelectionForeground(new Color(0, 0, 0));
		tab.getTable().setGridColor(new Color(221, 221, 221));

		tab.getTable().setDefaultRenderer(Object.class, new CellRenderer());
		tab.setVisible(true);

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

	public void cadastrar() {
		TableModelVenda model = (TableModelVenda) gui.getTable().getModel();

		Pedido pedido = new Pedido();
		Pagamento pagamento = new Pagamento();

		Date data = (Date) gui.getData().getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			pedido.setDataCriacao(new Utilitario().converterData(sdf.format(data)));
			pedido.setValorTotal(parse(gui.getTxtTotal().getText().toString()));
			pedido.setStatus(StatusPedido.PAGO);
			pedido.setTipoPagamento((TipoPagamentos) gui.getCmbTipoPagamento().getSelectedItem());
			pedido.setValorDesconto(BigDecimal.ZERO);
			if (!gui.getTxtDesconto().getText().isEmpty()) {
				pedido.setValorDesconto(parse(gui.getTxtDesconto().getText()));
				pagamento.setVlorDoDesconto(0);

			}
			if (!gui.getTxtCliente().getText().isEmpty()) {
				pedido.setCliente((Cliente) pessoa.findOne(Long.parseLong(gui.getTxtCliente().getText())));
			}

			if (!gui.getTxtFuncionario().getText().isEmpty()) {
				pedido.setAtendente(pessoa.findByFuncionario(Long.parseLong(gui.getTxtFuncionario().getText())));
			}

			for (ItemPedido dados : model.getColunas()) {
				dados.setId(null);
				dados.setPedido(pedido);

			}
			pedido.getItens().addAll(model.getColunas());

			daoPedido.saveAndFlush(pedido);

			alerta("Orçamento gerado");

		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getClass());
			alerta("Erro ao confirmar venda");
		}

	}

	public void verificarTodos() {

		if (new Utilitario(gui.getPanelDados()).verificarCampos()) {
			alerta("preencha os campos");

		}
	}

	private static BigDecimal parse(String str) {
		String normalized = str.replaceAll("\\s", "").replace(',', '.');
		return new BigDecimal(normalized);
	}

	public void limparTodos() {
		new Utilitario(gui.getPanelDados()).limparTodos();
		gui.getLlbTotal().setText("");

		model.getColunas().clear();
		gui.getTable().repaint();
		gui.getBtnNovo().setEnabled(true);
		gui.getBtnConfirmar().setEnabled(false);
		gui.getBtnInserirItem().setEnabled(false);
		gui.getBtnExcluir().setEnabled(false);
		gui.getBtnCalcularTotal().setEnabled(false);
		gui.getBtnCancelar().setEnabled(false);
		gui.getLblTotalMensagem().setVisible(false);

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

	// public void preencherComobo() {
	// ArrayList<Cartao> cart = new ArrayList<Cartao>(cartao.findAll());
	// ComboBoxModelPersonalizado modelCartao = new
	// ComboBoxModelPersonalizado(cart);
	// modelCartao.getAnArrayList().add("");
	// gui.getCmbCartao().setModel(modelCartao);
	//
	// }

	public class OuvirObjecto implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("novo")) {
				// iniciarTransacao();
				gui.getBtnInserirItem().setEnabled(true);
				gui.getBtnNovo().setEnabled(false);
			}

			if (e.getActionCommand().equals("inserir")) {
				TabelaProdutoController tb = new TabelaProdutoController(gui);
				gui.getBtnExcluir().setEnabled(true);
				gui.getBtnCancelar().setEnabled(true);
				gui.getBtnCalcularTotal().setEnabled(true);
				tb.gui.setModal(true);
				tb.gui.setVisible(true);

			}

			if (e.getActionCommand().equals("excluir")) {
				int row = gui.getTable().getSelectedRow();
				model.removeRow(row);

			}

			if (e.getActionCommand().equals("cancelar")) {
				limparTodos();

			}
			if (e.getActionCommand().equals("confirmar")) {

				cadastrar();
				gui.getBtnImprimir().setEnabled(true);
				limparTodos();

			}

			if (e.getActionCommand().equals("verDados")) {
				ver();

			}

			if (e.getActionCommand().equals("calcular")) {
				gui.getBtnConfirmar().setEnabled(true);

				BigDecimal vlDesconto = null;
				BigDecimal percentagemGeral = null;
				BigDecimal total = model.somarTodos();
				gui.getTxtValorvenda().setText(total.toString());

				if (!gui.getTxtDesconto().getText().isEmpty()) {
					vlDesconto = new BigDecimal(gui.getTxtDesconto().getText());
					percentagemGeral = new BigDecimal("100");

				}
				if (!gui.getTxtDesconto().getText().isEmpty() && !vlDesconto.equals(0)) {
					BigDecimal desconto = new BigDecimal(
							total.multiply(vlDesconto.divide(percentagemGeral)).toString());
					BigDecimal totalGeral = total.subtract(desconto).setScale(2, BigDecimal.ROUND_HALF_EVEN);
					gui.getTxtTotal().setText(totalGeral.toString());
					String vl = NumberFormat.getCurrencyInstance().format(totalGeral);
					gui.getLlbTotal().setText(vl);

				} else {
					gui.getTxtTotal().setText(total.toString());
					String vl = NumberFormat.getCurrencyInstance().format(total);

					gui.getLblTotalMensagem().setVisible(true);
					gui.getLlbTotal().setText(vl);
				}

			}

		}

	}

}
