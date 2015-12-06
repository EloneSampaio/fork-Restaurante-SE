package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import com.forksystem.dao.IConta;
import com.forksystem.entities.Conta;
import com.forksystem.entities.Endereco;
import com.forksystem.entities.Fornecedor;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewConta;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class ContaController {

	public ViewConta gui;
	private IConta dao;
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public ContaController() {
		gui = new ViewConta();
		gui.addAction(new OuvirObjecto());
		dao = Context.getInstace().getContexto().getBean(IConta.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirObjecto()));
		personalizarTabela();
		disableAllBtn(false);
	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Conta dados : dao.findAll()) {
			Object object = new Object[] { dados.getId(), dados.getBanco(), dados.getAgencia(), dados.getNumeroConta(),
					dados.getGerente(), dados.getContacto() };
			linha.add(object);

		}

		String[] colunas = new String[] { "CODIGO", "NOME", "AGENCIA", "CONTA", "GERENTE", "CONTACTO" };
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
		Conta banco = new Conta();
		banco.setBanco(gui.getTxtNome().getText());
		banco.setAgencia(gui.getTextAgencia().getText());
		banco.setGerente(gui.getTextGerente().getText());
		banco.setNumeroConta(Integer.parseInt(gui.getTextConta().getText()));
		banco.setContacto(gui.getTextTelefone().getText());
		banco.setEndereco(gui.getTextEndereco().getText());
		if (!gui.getTextId().getText().isEmpty()) {
			Long id = Long.parseLong(gui.getTextId().getText());
			banco.setId(id);

		}

		try {

			dao.saveAndFlush(banco);
			alerta("Operação realizada");
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

	public void preencherCampos(Conta banco) {
		gui.getTextId().setText(banco.getId() + "");
		gui.getTxtNome().setText(banco.getBanco().toString());
		gui.getTextAgencia().setText(banco.getAgencia().toString());
		gui.getTextConta().setText(banco.getNumeroConta() + "");
		gui.getTextGerente().setText(banco.getGerente().toString());
		gui.getTextTelefone().setText(banco.getContacto().toString());
		gui.getTextEndereco().setText(banco.getEndereco().toString());
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

			Long fornecedor = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(dao.findOne(fornecedor));
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
