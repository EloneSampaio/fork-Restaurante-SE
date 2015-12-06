package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.forksystem.entities.ItemPedido;
import com.forksystem.entities.Pedido;
import com.forksystem.entities.StatusPedido;
import com.forksystem.entities.TipoPagamentos;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.models.TableModelVenda;
import com.forksystem.ui.ViewTabelaVenda;
import com.forksystem.ui.ViewVenda;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class VendaController {

	private IPedido daoPedido = null;
	private TableModelVenda venda = null;
	private IPessoa pessoa = null;
	private IProduto produto = null;
	private IOperacao Daooperacao = null;
	private IPagamento DaoPagamento = null;
	public ViewVenda gui;
	public TableModelVenda tabela;
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;
	private TableModelPersonalizado tabelaVenda;
	ViewTabelaVenda tab = new ViewTabelaVenda();

	public VendaController() {
		gui = new ViewVenda();
		gui.getPanelTabela().setBackground(new Color(102, 153, 153));
		gui.getContentPane().setBackground(new Color(102, 153, 153));
		gui.getPanelDados().setBackground(new Color(102, 153, 153));
		initializeTable();
		venda = new TableModelVenda();
		personalizarTabela();
		gui.ouvinte(new OuvirObjecto(), gui.getBtnNovo());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnCancelar());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnConfirmar());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnExcluir());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnImprimir());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnInserirItem());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnVer());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnCalcularTotal());
		daoPedido = Context.getInstace().getContexto().getBean(IPedido.class);
		pessoa = Context.getInstace().getContexto().getBean(IPessoa.class);
		produto = Context.getInstace().getContexto().getBean(IProduto.class);
		Daooperacao = Context.getInstace().getContexto().getBean(IOperacao.class);
		DaoPagamento = Context.getInstace().getContexto().getBean(IPagamento.class);

	}

	public void initializeTable() {
		List<ItemPedido> venda = new ArrayList<ItemPedido>();
		tabela = new TableModelVenda(venda, gui.getTable());
		gui.getTable().setModel(tabela);
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
		tabelaVenda = new TableModelPersonalizado(linha, colunas);
		tab.getTable().setModel(tabelaVenda);
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
//		Pagamento pagamento = new Pagamento();
//		Operacao operacao;

		Date data = (Date) gui.getData().getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//
		// try {
		pedido.setDataCriacao(new Utilitario().converterData(sdf.format(data)));
		pedido.setValorTotal(parse(gui.getTxtTotal().getText().toString()));
		pedido.setStatus(StatusPedido.PAGO);
		pedido.setTipoPagamento((TipoPagamentos) gui.getCmbTipoPagamento().getSelectedItem());
		pedido.setValorDesconto(BigDecimal.ZERO);
//		if (!gui.getTxtDesconto().getText().isEmpty()) {
//			pedido.setValorDesconto(parse(gui.getTxtDesconto().getText()));
//			pagamento.setVlorDoDesconto(0);
//
//		}
//		if (!gui.getTxtCliente().getText().isEmpty()) {
//			pedido.setCliente((Cliente) pessoa.findOne(Long.parseLong(gui.getTxtCliente().getText())));
//		}
//
//		if (!gui.getTxtFuncionario().getText().isEmpty()) {
//			pedido.setAtendente(pessoa.findByFuncionario(Long.parseLong(gui.getTxtFuncionario().getText())));
//		}

		for (ItemPedido dados : model.getColunas()) {
			dados.setPedido(pedido);
			
		}
		pedido.getItens().addAll(model.getColunas());
		
		daoPedido.saveAndFlush(pedido);
		


//		pagamento.setDataPagamento(new Utilitario().converterData(sdf.format(data)));
//		pagamento.setLancamento(Calendar.getInstance());
//		pagamento.setTipoPagamento((TipoPagamentos) gui.getCmbTipoPagamento().getSelectedItem());
//		pagamento.setVlorDoDesconto(0);

		// if (!(null == gui.getCmbCartao().getSelectedItem())) {
		// pedido.setCartao(cartao.findByNome(gui.getCmbCartao().getSelectedItem().toString()));
		// }

//		for (ItemPedido valor : model.getColunas()) {
//			operacao = new Operacao();
//			operacao.setData(new Utilitario().converterData(sdf.format(data)));
//			operacao.setProduto(produto.getOne(valor.getId()));
//			operacao.setQtd(valor.getQuantidade());
//			operacao.setTipo(2);
//			Daooperacao.save(operacao);
//		}

		// DaoPagamento.saveAndFlush(pagamento);
		
		alerta("Venda concluida");

		// } catch (Exception e) {
		// System.out.println(e.getMessage() + e.getClass());
		// alerta("Erro ao confirmar venda");
		// }

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

		TableModelVenda tb = (TableModelVenda) gui.getTable().getModel();
		tb.getColunas().clear();
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
				TableModelVenda model = (TableModelVenda) gui.getTable().getModel();
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
				TableModelVenda model = (TableModelVenda) gui.getTable().getModel();
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
