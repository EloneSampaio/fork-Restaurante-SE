package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.alee.log.Log;
import com.forksystem.dao.IContaAPagar;
import com.forksystem.entities.ContaPagamento;
import com.forksystem.entities.Status;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewContasAPagar;
import com.forksystem.ui.ViewContasAReceber;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class ContaAReceberController {

	public ViewContasAReceber gui = null;
	private IContaAPagar dao = null;
	public TableModelPersonalizado tabela = null;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;
	private Long id = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ContaAReceberController() {
		gui = new ViewContasAReceber();
		dao = Context.getInstace().getContexto().getBean(IContaAPagar.class);
		initializeTable();
		personalizarTabela();
		preencherDados();
		disableAllBtn(false);
		gui.getTable().addMouseListener((new OuvirObjecto()));
		gui.addAction(new OuvirObjecto());

	}

	/*
	 * Metodo que preenche os dados das labels
	 */
	public void preencherDados() {
		int pago = 0;
		int aPagar = 0;
		int divida = 0;
		try {
			pago = (dao.buscarContaPagas(Status.PAGO)) == null ? 0 : dao.buscarContaPagas(Status.PAGO);
			aPagar = dao.buscarConta(Status.PROCESSANDO, Calendar.getInstance()) == null ? 0
					: dao.buscarConta(Status.PROCESSANDO, Calendar.getInstance());
			divida = dao.buscarContaVencida(Calendar.getInstance(), Status.PAGO) == null ? 0
					: dao.buscarContaVencida(Calendar.getInstance(), Status.PAGO);
			if (!(pago == 0)) {
				gui.getLblValorpago().setText(String.valueOf(pago) + " KZ");
			} else {
				gui.getLblValorpago().setText("0.0 KZ");
			}
			if (!(aPagar == 0)) {
				gui.getLblValorApagar().setText(String.valueOf(aPagar) + " KZ");
			} else {
				gui.getLblValorApagar().setText("0.0 KZ");
			}
			if (!(divida == 0)) {
				gui.getLblVencidas().setText(String.valueOf(divida) + " KZ");
			} else {
				gui.getLblVencidas().setText("0.0 KZ");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (ContaPagamento dados : dao.findByTipo(1)) {

			Object object = new Object[] { dados.getId(), dados.getDescricao(),
					sdf.format(dados.getDataVencimento().getTime()),
					dados.getDataVencimento().before(Calendar.getInstance()) && dados.getStatus() != Status.PAGO
							? Status.VENCIDO : dados.getStatus() };
			linha.add(object);
		}

		String[] colunas = new String[] { "COD", "Descrição", "Data de Vencimento", "Situação" };
		tabela = new TableModelPersonalizado(linha, colunas);
		gui.getTable().setModel(tabela);
		gui.getTable().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
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

	public void disableOrenableBtnToEdit(Boolean valor) {

		for (String key : gui.getBaseToolBar().getButtons().keySet()) {
			if (dados.contains(gui.getBaseToolBar().getButtons().get(key).getActionCommand())) {
				gui.getBaseToolBar().getButtons().get(key).setEnabled(!valor);
			} else {

				gui.getBaseToolBar().getButtons().get(key).setEnabled(valor);
			}

		}
	}

	public void disableAllBtn(Boolean valor) {
		for (String key : gui.getBaseToolBar().getButtons().keySet()) {
			if (gui.getBaseToolBar().getButtons().get(key).getActionCommand() == "novo") {
				gui.getBaseToolBar().getButtons().get(key).setEnabled(!valor);
			} else {

				gui.getBaseToolBar().getButtons().get(key).setEnabled(valor);
			}

		}
	}

	public void verificarTodos() {

		if (new Utilitario(gui.getPanelCadastro()).verificarCampos()) {
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
		new Utilitario(gui.getPanelCadastro()).limparTodos();

	}

	public void adicionar() {
		ContaPagamento conta = new ContaPagamento();
		try {

			Date data = (Date) gui.getTxtVencimento().getValue();

			conta.setDescricao(gui.getTxtDescricao().getText());
			conta.setValor(new BigDecimal(gui.getTxtValor().getText()));
			conta.setDataEntrada(Calendar.getInstance());
			conta.setDataVencimento(new Utilitario().converterData(sdf.format(data)));
			conta.setStatus((Status) gui.getCmbStatus().getSelectedItem());
			conta.setTipo(1);

			if (null != getId()) {
				conta.setId(getId());
			}

			dao.saveAndFlush(conta);
			setId(null);
			alerta("Operação realizada");
			initializeTable();
			preencherDados();
		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");
			Log.error("falha ao salvar" + e.getMessage());
		}

	}

	public void remover() {
		int[] linhas = gui.getTable().getSelectedRows();
		for (int i = 0; i < linhas.length; i++) {
			Long banco = (Long) gui.getTable().getValueAt(linhas[i], 0);
			try {
				dao.delete(banco);
				preencherDados();
			} catch (Exception e) {
				Log.error(e.getMessage());
			}

		}
		alerta("Removido");
		initializeTable();
		
	}

	public void preencherCampos(ContaPagamento conta) {
		gui.getTxtDescricao().setText(conta.getDescricao().toString());
		gui.getTxtValor().setText(conta.getValor().toString());
		gui.getTxtVencimento().setValue(conta.getDataVencimento().getTime());
		gui.getCmbStatus().setSelectedItem(conta.getStatus());
		setId(conta.getId());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public class OuvirObjecto implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "novo") {
				gui.getTable().clearSelection();

				dados.add("guardar");
				dados.add("cancelar");
				dados.add("novo");
				limparTodos();
				disableOrenableBtnToEdit(false);

			} else if (e.getActionCommand() == "guardar") {
				if (new Utilitario(gui.getPanelCadastro()).verificarCampos()) {
					alerta("preencha os campos");
					control = true;
				} else {
					control = false;
				}
				if (!control) {
					adicionar();
					dados.add("editar");
					dados.add("apagar");
					dados.add("novo");
					disableOrenableBtnToEdit(false);
					tabela.fireTableDataChanged();
					limparTodos();

				}

			} else if (e.getActionCommand() == "apagar") {
				System.err.println("sam");
				if (confirmar())
					remover();
				dados.add("editar");
				dados.add("apagar");
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			} else if (e.getActionCommand() == "editar") {
				System.err.println("sam");
				adicionar();
				dados.add("editar");
				dados.add("apagar");
				dados.add("novo");
				disableOrenableBtnToEdit(false);
			} else if (e.getActionCommand() == "cancelar") {
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			}

		}

		public void mouseClicked(MouseEvent e) {

			Long cartao = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(dao.findOne(cartao));
			dados.add("editar");
			dados.add("apagar");
			dados.add("novo");
			disableOrenableBtnToEdit(false);

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
