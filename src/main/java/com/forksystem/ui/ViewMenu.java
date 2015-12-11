package com.forksystem.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.forksystem.utils.ConstantesImagem;

public class ViewMenu {

	private JMenuBar menubar = null;

	private JMenu menuCadastros = new JMenu("Cadastros");
	private JMenu menuMovimentos = new JMenu("Movimentos");
	private JMenu menuAjuda = new JMenu("Ajuda");
	private JMenu menuRelatorios = new JMenu("Relatorios");
	private JMenu menuFerramentas = new JMenu("Utilitarios");
	private JMenu menuSair = new JMenu("Sair");

	protected JMenuItem itemClientes = new JMenuItem("Clientes");
	protected JMenuItem itemFornecedor = new JMenuItem("Fornecedores");
	protected JMenuItem itemContaBancaria = new JMenuItem("Conta Bancaria");
	protected JMenuItem itemUnidades = new JMenuItem("Unidades");
	protected JMenuItem itemMarca = new JMenuItem("Marca");
	protected JMenuItem itemCategorias = new JMenuItem("Categorias");
	protected JMenuItem itemProdutos = new JMenu("Produtos");
	protected JMenuItem itemProdutoImport = new JMenuItem("Importar Excel");
	protected JMenuItem itemProdutoCadastro = new JMenuItem("Cadastrar Produto");
	protected JMenuItem itemFuncionarios = new JMenuItem("Usuarios");
	protected JMenuItem itemMesa = new JMenuItem("Mesas");

	protected JMenuItem itemContaApagar = new JMenuItem("Contas a Pagar");
	protected JMenuItem itemContaReceber = new JMenuItem("Contas a Receber");
	protected JMenuItem itemControleEstoque = new JMenuItem("Controle de Estoque");
	protected JMenuItem itemVendas = new JMenu("Vendas");
	protected JMenuItem itemVendaNova = new JMenuItem("Nova Venda");
	protected JMenuItem itemVendasFeitas = new JMenuItem("Vendas Realizadas");

	protected JMenuItem itemOrcamento = new JMenu("Orçamentos");
	protected JMenuItem itemOrcamentoNova = new JMenuItem("Novo Orçamento");
	protected JMenuItem itemOrcamentoFeitas = new JMenuItem("Orçamentos Feitos");

	protected JMenuItem itemPedido = new JMenuItem("Pedidos");

	protected JMenuItem itemSair = new JMenuItem("Sair");
	protected JMenuItem itemAjuda = new JMenuItem("Sobre o Sistema");
	protected JMenuItem itemCalculadora = new JMenuItem("Calculadora");
	protected JMenuItem itemMenuRapido = new JMenuItem("Menu de Acesso Rapido");

	protected JMenuItem itemSeguranca = new JMenu("Sistema de Segurança");
	protected JMenuItem itemDefinirSenha = new JMenuItem("Alterar Senha");
	protected JMenuItem itemNiveldeAcesso = new JMenuItem("Definir Nivel de Acesso");
	protected JMenuItem itemAparencia = new JMenu("Aparencia");
	protected JMenuItem itemAlterarFundo = new JMenuItem("Alterar Fundo");
	protected JMenuItem itemAlterarTema = new JMenuItem("Alterar Tema");

	protected JDesktopPane painel;

	public ViewMenu() {

		menubar = new JMenuBar();
		menuCadastros.setFont(new Font("Arial Narrow", Font.BOLD, 16));

		menubar.add(menuCadastros);

		itemClientes.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		itemClientes.setMnemonic(KeyEvent.VK_F11);
		itemClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, ActionEvent.ALT_MASK));

		//
		menuCadastros.add(itemClientes);

		itemFornecedor.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		itemFornecedor.setMnemonic(KeyEvent.VK_R);
		itemFornecedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));

		itemFuncionarios.setMnemonic(KeyEvent.VK_F10);
		itemFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, ActionEvent.ALT_MASK));
		//
		menuCadastros.add(itemFornecedor);

		itemUnidades.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemUnidades.setMnemonic(KeyEvent.VK_F9);
		itemUnidades.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, ActionEvent.ALT_MASK));

		menuCadastros.add(itemUnidades);
		itemMesa.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemMesa.setMnemonic(KeyEvent.VK_M);
		itemMesa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));

		menuCadastros.add(itemMesa);
		itemMarca.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemMarca.setMnemonic(KeyEvent.VK_S);
		itemMarca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));

		menuCadastros.add(itemMarca);

		itemCategorias.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemCategorias.setMnemonic(KeyEvent.VK_C);
		itemCategorias.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));

		menuCadastros.add(itemCategorias);
		itemProdutoImport.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemProdutoImport.setMnemonic(KeyEvent.VK_9);
		itemProdutoImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));

		itemProdutoCadastro.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemProdutoCadastro.setMnemonic(KeyEvent.VK_P);
		itemProdutoCadastro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));

		itemProdutos.add(itemProdutoCadastro);
		itemProdutos.add(itemProdutoImport);
		itemProdutos.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		menuCadastros.add(itemProdutos);
		menuCadastros.addSeparator();

		itemFuncionarios.setMnemonic(KeyEvent.VK_F12);
		itemFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, ActionEvent.ALT_MASK));
		itemFuncionarios.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		menuCadastros.add(itemFuncionarios);
		menuCadastros.addSeparator();

		///////////////
		menubar.add(menuMovimentos);
		itemContaApagar.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemContaApagar.setMnemonic(KeyEvent.VK_W);
		itemContaApagar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));

		menuMovimentos.add(itemContaApagar);
		itemContaReceber.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemContaReceber.setMnemonic(KeyEvent.VK_N);
		itemContaReceber.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));

		menuMovimentos.add(itemContaReceber);

		menuMovimentos.addSeparator();
		itemVendas.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemVendaNova.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemVendaNova.setMnemonic(KeyEvent.VK_E);
		itemVendaNova.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

		itemVendasFeitas.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemVendasFeitas.setMnemonic(KeyEvent.VK_2);
		itemVendasFeitas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		itemVendas.add(itemVendaNova);
		itemVendas.add(itemVendasFeitas);
		menuMovimentos.add(itemVendas);

		itemOrcamento.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemOrcamentoNova.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemOrcamentoNova.setMnemonic(KeyEvent.VK_O);
		itemOrcamentoNova.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		itemOrcamentoFeitas.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemOrcamentoFeitas.setMnemonic(KeyEvent.VK_3);
		itemOrcamentoFeitas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		itemOrcamento.add(itemOrcamentoNova);
		itemOrcamento.add(itemOrcamentoFeitas);

		menuMovimentos.add(itemOrcamento);
		menuMovimentos.addSeparator();
		itemControleEstoque.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemControleEstoque.setMnemonic(KeyEvent.VK_G);
		itemControleEstoque.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.ALT_MASK));

		menuMovimentos.add(itemControleEstoque);

		menuRelatorios.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		menubar.add(menuRelatorios);

		itemCalculadora.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemCalculadora.setMnemonic(KeyEvent.VK_I);
		itemCalculadora.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));

		menuFerramentas.add(itemCalculadora);
		menuFerramentas.addSeparator();
		itemMenuRapido.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemMenuRapido.setMnemonic(KeyEvent.VK_Z);
		itemMenuRapido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));

		menuFerramentas.add(itemMenuRapido);
		itemDefinirSenha.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemDefinirSenha.setMnemonic(KeyEvent.VK_Q);
		itemDefinirSenha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));

		itemSeguranca.add(itemDefinirSenha);
		
		itemAparencia.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemAlterarFundo.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemAlterarFundo.setMnemonic(KeyEvent.VK_Y);
		itemAlterarFundo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.ALT_MASK));
        itemAparencia.add(itemAlterarFundo);
        itemAlterarTema.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemAparencia.add(itemAlterarTema);
		
		
		menuFerramentas.add(itemAparencia);
		
		
		itemNiveldeAcesso.setFont(new Font("Arial Now ", Font.PLAIN, 14));
		itemNiveldeAcesso.setMnemonic(KeyEvent.VK_U);
		itemNiveldeAcesso.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.ALT_MASK));
		itemSeguranca.add(itemNiveldeAcesso);
		menuFerramentas.add(itemSeguranca);

		menubar.add(menuFerramentas);

		menuAjuda.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		menuAjuda.add(itemAjuda);
		menubar.add(menuAjuda);
		itemSair.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		itemSair.setMnemonic(KeyEvent.VK_X);
		itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));

		menuSair.add(itemSair);
		menubar.add(menuSair);

		//
		// ImageIcon iconOpcoes = new ImageIcon(ConstantesImages.OPCOES);
		//
		// menuOpcoes.setIcon(iconOpcoes);
		//
		// menuOpcoes.setMnemonic(KeyEvent.VK_O);
		//
		// menuOpcoes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
		// ActionEvent.ALT_MASK));
		//
		// menuOpcoes.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		// menuTreinamento.add(menuOpcoes);
		//

	}

	public JMenuBar getMenuBar() {
		return menubar;
	}
}