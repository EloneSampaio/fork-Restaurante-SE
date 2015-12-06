package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alee.log.Log;
import com.forksystem.dao.ICategoria;
import com.forksystem.dao.IMarca;
import com.forksystem.dao.IOperacao;
import com.forksystem.dao.IPessoa;
import com.forksystem.dao.IProduto;
import com.forksystem.dao.IUnidade;
import com.forksystem.entities.Categoria;
import com.forksystem.entities.Operacao;
import com.forksystem.entities.Produto;
import com.forksystem.entities.Unidade;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.ComboBoxModelPersonalizado;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewProduto;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class ProdutoController {

	public ViewProduto gui = null;
	private IPessoa pessoa = null;
	private IProduto produt = null;
	private ICategoria categori = null;
	private IMarca marc = null;
	private IUnidade unidad = null;
	private IOperacao operac = null;

	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public ProdutoController() {

		gui = new ViewProduto();
		gui.addAction(new OuvirCliente());
		pessoa = Context.getInstace().getContexto().getBean(IPessoa.class);
		produt = Context.getInstace().getContexto().getBean(IProduto.class);
		categori = Context.getInstace().getContexto().getBean(ICategoria.class);
		marc = Context.getInstace().getContexto().getBean(IMarca.class);
		unidad = Context.getInstace().getContexto().getBean(IUnidade.class);
		operac = Context.getInstace().getContexto().getBean(IOperacao.class);
		initializeTable();
		gui.getTable().addMouseListener((new OuvirCliente()));
		personalizarTabela();
		disableAllBtn(false);

		preencherCombobox(gui.getCmbUnidade());
		preencherCombobox(gui.getCmbCategoria());
	}

	public void preencherCombobox(JComboBox<Categoria> cb) {
		// ArrayList<Unidade> unidade = new
		// ArrayList<Unidade>(unidad.findAll());
		// ComboBoxModelPersonalizado modelUnidade = new
		// ComboBoxModelPersonalizado(unidade);
		// gui.getCmbUnidade().setModel(modelUnidade);

		ArrayList<Categoria> categoria = new ArrayList<Categoria>(categori.findAll());
		ComboBoxModelPersonalizado modelCategoria = new ComboBoxModelPersonalizado(categoria);
		gui.getCmbCategoria().setModel(modelCategoria);

	}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Produto dados : produt.findAll()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getMinimoInventario(),
					dados.getPrecoCompra(), dados.getPrecoVenda() };
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

		final Produto produto = new Produto();
		Operacao estoque = new Operacao();

		try {

			if (!(gui.getTxtFornecedor().getText().isEmpty())) {
				produto.setFornecedor(pessoa.findByFornecedor(Long.parseLong(gui.getTxtFornecedor().getText())));

			}

			if (!(null == gui.getCmbUnidade().getSelectedItem())) {
				produto.setUnidade(unidad.findByNome(gui.getCmbUnidade().getSelectedItem().toString()));
			}
			if (!(null == gui.getCmbCategoria().getSelectedItem())) {
				produto.setCategoria(categori.findByNome(gui.getCmbCategoria().getSelectedItem().toString()));
			}

			if (!(gui.getTxtMarca().getText().isEmpty())) {
				produto.setMarca(marc.findOne(Long.parseLong(gui.getTxtMarca().getText())));

			}

			produto.setNome(gui.getTxtNome().getText());
			produto.setDescricao(gui.getTxtDescricao().getText());
			produto.setImg(gui.getImagem().getText());
			produto.setMinimoInventario(Integer.parseInt(gui.getTxtstoqueMinimo().getText()));
			produto.setPrecoCOmpra(new BigDecimal(gui.getTxtPrecoCompra().getText()));
			produto.setPrecoVenda(new BigDecimal(gui.getTxtVenda().getText()));
			estoque.setQtd(new BigDecimal(gui.getTextEstoque().getText()));
			estoque.setData(Calendar.getInstance());
			estoque.setTipo(1);

			if (!gui.getTextId().getText().isEmpty()) {
				produto.setId(Long.parseLong(gui.getTextId().getText()));
			}

			produt.saveAndFlush(produto);
			estoque.setProduto(produto);
			operac.saveAndFlush(estoque);
			alerta("Operaão realizada");
			gui.getTextId().setText(null);
			initializeTable();

		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");
			System.out.println(e.getMessage() + e.getLocalizedMessage() + e.getClass() + e.getCause());

		}

	}

	public void remover() {

		int[] linhas = gui.getTable().getSelectedRows();
		for (int i = 0; i < linhas.length; i++) {
			Long produto = (Long) gui.getTable().getValueAt(linhas[i], 0);
			try {
				produt.delete(produto);

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
		gui.getLblImagem().setIcon(null);

	}

	public void preencherCampos(Produto produto) {
		gui.getTextId().setText(Long.toString(produto.getId()));
		gui.getTxtDescricao().setText(produto.getDescricao());
		gui.getTxtNome().setText(produto.getNome());
		gui.getImagem().setText(produto.getImg());
		gui.getTxtstoqueMinimo().setText(produto.getMinimoInventario().toString());
		gui.getCmbUnidade().getModel().setSelectedItem(produto.getUnidade());
		gui.getCmbCategoria().getModel().setSelectedItem(produto.getCategoria());
		gui.getTxtPrecoCompra().setText(produto.getPrecoCompra().toString());
		gui.getTxtVenda().setText(produto.getPrecoVenda().toString());
		ImageIcon icon = new ImageIcon(produto.getImg());
		gui.getLblImagem().setIcon(null);
		gui.getLblImagem().setIcon(icon);
		gui.getImagem().setVisible(false);
		gui.getTextEstoque().setVisible(false);
		gui.getLblQtdestoque().setVisible(false);

		if (!(null==produto.getFornecedor())) {
			gui.getTxtFornecedor().setText(produto.getFornecedor().getId() + "");

		}

		if (!(null==produto.getMarca())) {
			gui.getTxtMarca().setText(produto.getMarca().getId() + "");

		}
		if((null==produto.getCategoria())){
	          gui.getCmbCategoria().setSelectedItem(produto.getCategoria().toString());		
		}
		if(!(null==produto.getUnidade())){
	          gui.getCmbUnidade().setSelectedItem(produto.getUnidade().toString());		
		}
		

	}

	public class OuvirCliente implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "novo") {
				gui.getTable().clearSelection();
				gui.getTextEstoque().setVisible(true);
				gui.getLblQtdestoque().setVisible(true);
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

				}

			} else if (e.getActionCommand() == "apagar") {
				if (confirmar())
					remover();
				dados.add("editar");
				dados.add("apagar");
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			} else if (e.getActionCommand() == "editar") {
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

			Long produto = (Long) gui.getTable().getValueAt(gui.getTable().getSelectedRow(), 0);

			preencherCampos(produt.findOne(produto));
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
