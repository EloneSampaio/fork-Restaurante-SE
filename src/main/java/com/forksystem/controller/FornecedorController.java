package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.forksystem.dao.IPessoa;
import com.forksystem.entities.Cliente;
import com.forksystem.entities.Contacto;
import com.forksystem.entities.Endereco;
import com.forksystem.entities.Fornecedor;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewCliente;
import com.forksystem.ui.ViewFornecedor;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class FornecedorController {

	public ViewFornecedor gui;
	private IPessoa dao;
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public FornecedorController() {

		gui = new ViewFornecedor();
		gui.addAction(new OuvirObjecto());
		dao = Context.getInstace().getContexto().getBean(IPessoa.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirObjecto()));
		personalizarTabela();
		disableAllBtn(false);

	}

	public void adicionar() {
		Fornecedor fornecedor = new Fornecedor();
		Endereco endereco = new Endereco();

		Contacto contactos = new Contacto();
		contactos.setEmail(gui.getTextEmail().getText());
		contactos.setTelefone(gui.getTextTelefone().getText());
		fornecedor.setContacto(contactos);
		endereco.setCidade(gui.getCmbCidade().getSelectedItem().toString());
		endereco.setBairro(gui.getTextBairro().getText());
		endereco.setEndereco(gui.getTextEndreco().getText());
		endereco.setCep(gui.getTxtCp().getText());
		fornecedor.setEndereco(endereco);
        fornecedor.setSite(gui.getTxtSite().getText());
        fornecedor.setCpf(gui.getTextCpf().getText());
        endereco.setEstado(gui.getCmbEstado().getSelectedItem().toString());

		fornecedor.setNome(gui.getTxtNome().getText());
		
		if (!gui.getTxtCodigo().getText().isEmpty()) {
			Long id = Long.parseLong(gui.getTxtCodigo().getText());
			fornecedor.setId(id);
			System.out.println(fornecedor.getId());

		}

		try {
			dao.saveAndFlush(fornecedor);
			alerta("Operaão realizada");
			initializeTable();

		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");

			e.printStackTrace();
		}
	}

	public void remover() {

		int[] linhas = gui.getTable().getSelectedRows();
		for (int i = 0; i < linhas.length; i++) {
			Long fornecedor = (Long) gui.getTable().getValueAt(linhas[i], 0);
			dao.delete(fornecedor);
		}
		alerta("Removido");
		initializeTable();
	}

	public void preencherCampos(Fornecedor fornecedor) {
		gui.getTxtCodigo().setText(Long.toString(fornecedor.getId()));
		gui.getTxtNome().setText(fornecedor.getNome());
		gui.getTextCpf().setText(fornecedor.getCpf());
		gui.getTextEmail().setText(fornecedor.getContacto().getEmail());
		gui.getTextTelefone().setText(fornecedor.getContacto().getTelefone());
		gui.getCmbEstado().setSelectedItem(fornecedor.getEndereco().getEstado());
		gui.getTextBairro().setText(fornecedor.getEndereco().getBairro());
		gui.getTextEndreco().setText(fornecedor.getEndereco().getEndereco());
		gui.getTxtSite().setText(fornecedor.getSite());
		gui.getCmbCidade().setSelectedItem(fornecedor.getEndereco().getCidade());
		gui.getTxtCp().setText(fornecedor.getEndereco().getCep());
		

	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Fornecedor dados : dao.findAllFornecedors()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getCpf(),
					dados.getContacto().getTelefone(), dados.getEndereco().getEndereco() };
			linha.add(object);

		}

		String[] colunas = new String[] { "COD", "NOME", "DOC/BI", "TELEFONE", "ENDEREÇO" };
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

		if (new Utilitario(gui.getPanelCadastro()).verificarCampos()) {
			alerta("preencha os campos");

		} else if (new Utilitario(gui.getPanelContacto()).verificarCampos()) {
			alerta("preencha os campos");
		} else if (new Utilitario(gui.getPanelEndereco()).verificarCampos()) {
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
		new Utilitario(gui.getPanelContacto()).limparTodos();
		new Utilitario(gui.getPanelEndereco()).limparTodos();

	}

	public class OuvirObjecto implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "novo") {
				gui.getTable().clearSelection();
                dados.clear();
				dados.add("guardar");
				dados.add("cancelar");
				dados.add("novo");
				limparTodos();
				disableOrenableBtnToEdit(false);

			} else if (e.getActionCommand() == "guardar") {
				if (new Utilitario(gui.getPanelCadastro()).verificarCampos()) {
					alerta("preencha os campos");
					control = true;
				} else if (new Utilitario(gui.getPanelContacto()).verificarCampos()) {
					alerta("preencha os campos");
					control = true;
				} else if (new Utilitario(gui.getPanelEndereco()).verificarCampos()) {
					alerta("preencha os campos");
					control = true;
				} else {
					control = false;
				}
				if (!control) {
					adicionar();
					dados.clear();
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
				dados.clear();
				dados.add("editar");
				dados.add("apagar");
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			} else if (e.getActionCommand() == "editar") {
				System.err.println("sam");
				adicionar();
				dados.clear();
				dados.add("editar");
				dados.add("apagar");
				dados.add("novo");
				disableOrenableBtnToEdit(false);
			} else if (e.getActionCommand() == "cancelar") {
				gui.getTable().clearSelection();
				dados.clear();
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			}

		}

		public void mouseClicked(MouseEvent e) {

			Long fornecedor = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(dao.findByFornecedor(fornecedor));
			dados.clear();
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
