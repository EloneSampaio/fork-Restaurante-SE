package com.forksystem.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.alee.log.Log;
import com.forksystem.dao.IPessoa;
import com.forksystem.entities.Cliente;
import com.forksystem.entities.Contacto;
import com.forksystem.entities.Endereco;
import com.forksystem.models.CellRenderer;
import com.forksystem.models.HeaderCellRenderer;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewCliente;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class ClienteController {

	public ViewCliente gui;
	private IPessoa dao;
	public TableModelPersonalizado tabela;
	public java.util.Vector<String> dados = new java.util.Vector<String>();
	Boolean control = false;
	TableRowSorter<TableModel> sorter = null;

	public ClienteController() {

		gui = new ViewCliente();
		gui.addAction(new OuvirCliente());
		dao = Context.getInstace().getContexto().getBean(IPessoa.class);
		initializeTable();
		gui.getTabelaDeClientes().addMouseListener((new OuvirCliente()));
		personalizarTabela();
		disableAllBtn(false);

	}

	public void adicionar() {
		String genero = null;
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date data=(Date) gui.getTxtData().getValue();
		Contacto contacto = new Contacto();
		contacto.setEmail(gui.getTextEmail().getText());
		contacto.setTelefone(gui.getTextTelefone().getText());
		cliente.setContacto(contacto);

		endereco.setCidade(gui.getCmbEstado().getSelectedItem().toString());
		endereco.setBairro(gui.getTextBairro().getText());
		endereco.setEndereco(gui.getTextEndreco().getText());
		cliente.setEndereco(endereco);

		cliente.setNome(gui.getTxtNome().getText());
		cliente.setCpf(gui.getTextCpf().getText());
		cliente.setData((new Utilitario().converterData(sdf.format(data))));
		cliente.setDesde(Calendar.getInstance());
		cliente.setEmpresa(gui.getTxtEmpresa().getText());
		cliente.setFoneEmpresa(gui.getTxtTelefoneempresa().getText());
		cliente.setFone_referencia_cliente(gui.getTxtTelefonecliente().getText());
		cliente.setProfissao(gui.getTxtProfissoa().getText());
		cliente.setRendaCLiente(gui.getTxtRenda().getText());
		

		if (!gui.getTextCodigo().getText().isEmpty()) {
			Long id = Long.parseLong(gui.getTextCodigo().getText());
			cliente.setId(id);
			

		}
		if (gui.getRdbtnFemenino().isSelected()) {
			genero = "Femenino";
		} else if (gui.getRdbtnMasculino().isSelected()) {
			genero = "Masculino";
		}

		cliente.setSexo(genero);

		try {
			 dao.saveAndFlush(cliente);
			gui.getTextCodigo().setText(null);	
			cliente.setId(null);
			 alerta("Operaão realizada");
				initializeTable();
				

		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");
			
			Log.error(e.getMessage());
			}

	}

	public void remover() {

		int[] linhas = gui.getTabelaDeClientes().getSelectedRows();
		for (int i = 0; i < linhas.length; i++) {
			Long cliente = (Long) gui.getTabelaDeClientes().getValueAt(linhas[i], 0);
			dao.delete(cliente);
		}
		alerta("Removido");
		initializeTable();
	}

	public void preencherCampos(Cliente cliente) {
		gui.getTextCodigo().setText(Long.toString(cliente.getId()));
		gui.getTxtNome().setText(cliente.getNome());
		gui.getTextCpf().setText(cliente.getCpf());
		
		if (cliente.getSexo().equals("Masculino")) {
			gui.getRdbtnMasculino().setText(cliente.getSexo());
			gui.getRdbtnMasculino().setSelected(true);
		} else if (cliente.getSexo().equals("Femenino")) {
			gui.getRdbtnFemenino().setText(cliente.getSexo());
			gui.getRdbtnFemenino().setSelected(true);
		}
		
		else if (cliente.getSexo().equals("Outro")) {
			gui.getRdbtnOutro().setText(cliente.getSexo());
			gui.getRdbtnOutro().setSelected(true);
		}

		gui.getTxtData().setValue(new Utilitario().formatarData(cliente.getData().getTime(), false));
		gui.getCmbEstado().setSelectedItem(cliente.getEndereco().getCidade());
        gui.getTxtEmpresa().setText(cliente.getEmpresa().toString());
        gui.getTxtProfissoa().setText(cliente.getProfissao().toString());
        gui.getTxtRenda().setText(cliente.getRendaCLiente().toString());
        gui.getTxtTelefonecliente().setText(cliente.getFone_referencia_cliente().toString());
        gui.getTxtTelefoneempresa().setText(cliente.getFoneEmpresa().toString());
        

        gui.getTextBairro().setText(cliente.getEndereco().getBairro());
		gui.getTextEndreco().setText(cliente.getEndereco().getEndereco());
		
		if(!cliente.getContacto().getEmail().isEmpty()){
			
        gui.getTextEmail().setText(cliente.getContacto().getEmail());
		}
		if(!cliente.getContacto().getTelefone().isEmpty()){
		gui.getTextTelefone().setText(cliente.getContacto().getTelefone());
		}
		
		}

	public void initializeTable() {
		ArrayList linha = new ArrayList();

		for (Cliente dados : dao.findAllClientes()) {
			Object object = new Object[] { dados.getId(), dados.getNome(), dados.getSexo(),
					new Utilitario().verificaIdade(dados.getData().getTime()), dados.getCpf(),dados.getContacto().getTelefone() };
			linha.add(object);
			  
				
		}

		String[] colunas = new String[] { "COD", "NOME", "GENERO", "IDADE", "CPF","TELEFONE" };
		tabela = new TableModelPersonalizado(linha, colunas);
		gui.getTabelaDeClientes().setModel(tabela);
		gui.getTabelaDeClientes().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
         sorter = new TableRowSorter<TableModel>(tabela);
		gui.getTabelaDeClientes().setRowSorter(sorter);
		gui.getTxtPesquisar().addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				String valor = gui.getTxtPesquisar().getText().trim();
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + valor, 4));
				

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
		gui.getTabelaDeClientes().setAutoCreateColumnsFromModel(true);
		gui.getTabelaDeClientes().setAutoscrolls(true);
		JTableHeader headerTable = gui.getTabelaDeClientes().getTableHeader();
		headerTable.setDefaultRenderer(new HeaderCellRenderer());
		gui.getTabelaDeClientes().setTableHeader(headerTable);
		gui.getTabelaDeClientes().setSelectionBackground(Color.yellow);
		gui.getTabelaDeClientes().setSelectionForeground(new Color(0, 0, 0));
		gui.getTabelaDeClientes().setGridColor(new Color(221, 221, 221));

		gui.getTabelaDeClientes().setDefaultRenderer(Object.class, new CellRenderer());
		
		
	}

	public void limparTodos(){
		new Utilitario(gui.getPanelCadastro()).limparTodos();
		new Utilitario(gui.getPanelContacto()).limparTodos();
		new Utilitario(gui.getPanelEndereco()).limparTodos();
		new Utilitario(gui.getPanelEmpresas()).limparTodos();

	}
	
	public class OuvirCliente implements ActionListener, MouseListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "novo") {
				gui.getTabelaDeClientes().clearSelection();

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
			}
			else if (e.getActionCommand() == "cancelar") {
				dados.add("novo");
				disableOrenableBtnToEdit(false);
				limparTodos();
			}

		}

		public void mouseClicked(MouseEvent e) {

			Long cliente = (Long) gui.getTabelaDeClientes()
					.getValueAt(gui.getTabelaDeClientes().getSelectedRow(), 0);

			preencherCampos(dao.findByCliente(cliente));
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
