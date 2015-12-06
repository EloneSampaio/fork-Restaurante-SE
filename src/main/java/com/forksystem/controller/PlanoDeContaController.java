package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

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
import com.forksystem.dao.IDepartamento;
import com.forksystem.dao.IMarca;
import com.forksystem.dao.IPlanoDeConta;
import com.forksystem.entities.Cartao;
import com.forksystem.entities.Conta;
import com.forksystem.entities.Departamento;
import com.forksystem.entities.Endereco;
import com.forksystem.entities.Fornecedor;
import com.forksystem.entities.Marca;
import com.forksystem.entities.PlanoConta;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewCartao;
import com.forksystem.ui.ViewConta;
import com.forksystem.ui.ViewDepartamento;
import com.forksystem.ui.ViewMarca;
import com.forksystem.ui.ViewPlanoDeConta;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class PlanoDeContaController {

	public ViewPlanoDeConta gui;
	private IPlanoDeConta dao;
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public PlanoDeContaController() {
		gui = new ViewPlanoDeConta();
		gui.addAction(new OuvirObjecto());
		dao = Context.getInstace().getContexto().getBean(IPlanoDeConta.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirObjecto()));
		personalizarTabela();
		disableAllBtn(false);
	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (PlanoConta dados : dao.findAll()) {
			Object object = new Object[] { dados.getId(),dados.getDescricao()};
			linha.add(object);

		}

		String[] colunas = new String[] {"COD", "NOME" };
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
		new Utilitario(gui.getPanel()).limparTodos();

	}

	public void adicionar() {
		PlanoConta plano = new PlanoConta();

		plano.setDescricao(gui.getTextNome().getText());
		if (!gui.getTextId().getText().isEmpty()) {
			Long id = Long.parseLong(gui.getTextId().getText());
			plano.setId(id);
		}

		try {

			dao.saveAndFlush(plano);
			alerta("Operação realizada");
			gui.getTextId().setText(null);
			initializeTable();

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
			} catch (Exception e) {
				Log.error(e.getMessage());
			}

		}
		alerta("Removido");
		initializeTable();
	}

	public void preencherCampos(PlanoConta plano) {
		gui.getTextId().setText(plano.getId() + "");
		gui.getTextNome().setText(plano.getDescricao().toString());
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
				if (new Utilitario(gui.getPanel()).verificarCampos()) {
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
