package com.forksystem.ui;

import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ViewMenu {

	//	private JMenuBar menubar = null;
	//
	//	private JMenu menuArquivo = new JMenu("Arquivo");
	//
	//	private JMenuItem menuNovoArquivo = new JMenuItem("Novo Arquivo");
	//
	//	private JMenuItem menuAbrirArquivo = new JMenuItem("Abrir Arquivo");
	//
	//	private JMenuItem menuSair = new JMenuItem("Sair");
	//
	//	private JMenu menuGravar = new JMenu("Gravar");
	//
	//	private JMenuItem menuGravarFrases = new JMenuItem("Frases");
	//
	//	private JMenu menuTreinamento = new JMenu("Treinamento");
	//
	//	private JMenuItem menuTreinar = new JMenuItem("Treinar");
	//
	//	private JMenuItem menuOpcoes = new JMenuItem("Opções");
	//
	//	private JMenu menuGerarArquivos = new JMenu("Gerar Arquivos Treinamento");
	//
	//	private JMenuItem menuGerarFonemas = new JMenuItem("Fonemas");
	//
	//	private JMenuItem menuGerarFrases = new JMenuItem("Frases");
	//
	//	private JMenu menuAjuda = new JMenu("Ajuda");
	//
	//	private JMenuItem menuSobre = new JMenuItem("Sobre");

	private JMenuBar menubar = null;

	private JMenu menuCadastros=new JMenu("Cadastros");
	private JMenu menuMovimentos=new JMenu("Movimentos");
	private JMenu menuAjuda=new JMenu("Ajuda");
	private JMenu menuRelatorios=new JMenu("Relatorios");
	private JMenu menuFerramentas=new JMenu("Utilitarios");
	private JMenu menuSair=new JMenu("Sair");

	protected JMenuItem itemClientes=new JMenuItem("Clientes");
	protected JMenuItem itemFornecedor=new JMenuItem("Fornecedores");
	protected JMenuItem itemContaBancaria=new JMenuItem("Conta Bancaria");
	protected JMenuItem itemUnidades=new JMenuItem("Unidades");
	protected JMenuItem itemMarca=new JMenuItem("Marca");
	protected JMenuItem itemCategorias=new JMenuItem("Categorias");
	protected JMenuItem itemProdutos=new JMenuItem("Produtos");
	protected JMenuItem itemDepartamentos=new JMenuItem("Departamentos");
	protected JMenuItem itemFuncionarios=new JMenuItem("Funcionarios");
	protected JMenuItem itemCartoes=new JMenuItem("Cartões");
	protected JMenuItem itemPlanoDeConta=new JMenuItem("Plano de Conta");
	protected JMenuItem itemTipoPagamento=new JMenuItem("Tipos de Pagamento");
	protected JMenuItem itemMesa=new JMenuItem("Mesas");

	protected JMenuItem itemContaApagar=new JMenuItem("Contas a Pagar");
	protected JMenuItem itemContaReceber=new JMenuItem("Contas a Receber");
	protected JMenuItem itemControleEstoque=new JMenuItem("Controle de Estoque");
	protected JMenuItem itemCompras=new JMenuItem("Compras");
	protected JMenuItem itemVendas=new JMenuItem("Vendas");
	protected JMenuItem itemOrcamento=new JMenuItem("Orçamentos");
	protected JMenuItem itemTesouraria=new JMenu("Tesouraria e Banco");
	
	protected JMenuItem itemRequisicao=new JMenuItem("Requisição");
	protected JMenuItem itemCotacao=new JMenuItem("Cotação");
	protected JMenuItem itemConfirmarCotacao=new JMenuItem("Confirmar Cotação");
	protected JMenuItem itemPedido=new JMenuItem("Pedidos");
	protected JMenuItem itemEmissaoDeCheuqes=new JMenuItem("Emissão de Cheques");
	protected JMenuItem itemConciliaoDeCheques=new JMenuItem("Conciliação de Cheques");
	protected JMenuItem itemMovimentoDeBanco=new JMenuItem("Movimento de Banco");
	
	
	
	protected JMenuItem itemSair=new JMenuItem("Sair");
	protected JMenuItem itemAjuda=new JMenuItem("Sobre o Sistema");
	protected JMenuItem itemCalculadora=new JMenuItem("Calculadora");
	protected JMenuItem itemCalendario=new JMenuItem("Calendario");
	protected JMenuItem itemMenuRapido=new JMenuItem("Menu de Acesso Rapido");
	
	protected JMenuItem itemSeguranca=new JMenu("Sistema de Segurança");
	protected JMenuItem itemDefinirSenha=new JMenuItem("Alterar Senha");
	protected JMenuItem itemNiveldeAcesso=new JMenuItem("Definir Nivel de Acesso");
	
	
	protected JDesktopPane painel;


	public ViewMenu() {

		menubar = new JMenuBar();

		// Começa menu Arquivo

		//		ImageIcon iconArquivo = new ImageIcon(ConstantesImages.ARQUIVO);
		//
		//		menuArquivo.setIcon(iconArquivo);
		//
		//		menuArquivo.setMnemonic(KeyEvent.VK_A);

		menuCadastros.setFont(new Font("Arial Narrow", Font.BOLD, 16));

		menubar.add(menuCadastros);
		//
		//		// Sub-Menu NovoArquivo
		//
		//		ImageIcon iconNovoArquivo = new ImageIcon(ConstantesImages.NOVO);
		//
		//		menuNovoArquivo.setIcon(iconNovoArquivo);
		//
		itemClientes.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		menuCadastros.add(itemClientes);

		itemFornecedor.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		menuCadastros.add(itemFornecedor);
		
		itemContaBancaria.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemContaBancaria);
		menuCadastros.addSeparator();
		
		itemUnidades.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemUnidades);
		itemMesa.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemMesa);
		itemMarca.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemMarca);
		
		itemCategorias.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemCategorias);
		itemProdutos.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemProdutos);
		menuCadastros.addSeparator();
		
		itemDepartamentos.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemDepartamentos);
		
		itemFuncionarios.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemFuncionarios);
		menuCadastros.addSeparator();
		
		itemCartoes.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemCartoes);
		
		itemPlanoDeConta.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemPlanoDeConta);
		
		itemTipoPagamento.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuCadastros.add(itemTipoPagamento);
		menuCadastros.addSeparator();
		
		///////////////
		menubar.add(menuMovimentos);
		itemContaApagar.setFont(new Font("Arial Now ",Font.PLAIN,14));
        menuMovimentos.add(itemContaApagar);
		itemContaReceber.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuMovimentos.add(itemContaReceber);
		menuMovimentos.addSeparator();
		itemVendas.setFont(new Font("Arial Now ",Font.PLAIN,14));
//		itemRequisicao.setFont(new Font("Arial Now ",Font.PLAIN,14));
//		itemVendas.add(itemRequisicao);
//		itemCotacao.setFont(new Font("Arial Now ",Font.PLAIN,14));
//		itemVendas.add(itemCotacao);
//		itemConfirmarCotacao.setFont(new Font("Arial Now ",Font.PLAIN,14));
//		itemVendas.add(itemConfirmarCotacao);
//		itemPedido.setFont(new Font("Arial Now ",Font.PLAIN,14));
//		itemVendas.add(itemPedido);
		menuMovimentos.add(itemVendas);
		itemOrcamento.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuMovimentos.add(itemOrcamento);
		
		itemControleEstoque.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuMovimentos.add(itemControleEstoque);
		itemCompras.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuMovimentos.add(itemCompras);
		menuMovimentos.addSeparator();
		itemTesouraria.setFont(new Font("Arial Now ",Font.PLAIN,14));
		
		itemEmissaoDeCheuqes.setFont(new Font("Arial Now ",Font.PLAIN,14));
		itemTesouraria.add(itemEmissaoDeCheuqes);
		itemConciliaoDeCheques.setFont(new Font("Arial Now ",Font.PLAIN,14));
		itemTesouraria.add(itemConciliaoDeCheques);
		itemMovimentoDeBanco.setFont(new Font("Arial Now ",Font.PLAIN,14));
		itemTesouraria.add(itemMovimentoDeBanco);
		menuMovimentos.add(itemTesouraria);
		menuMovimentos.addSeparator();
		
		itemCalculadora.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuFerramentas.add(itemCalculadora);
		itemCalendario.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuFerramentas.add(itemCalendario);
		menuFerramentas.addSeparator();
		itemMenuRapido.setFont(new Font("Arial Now ",Font.PLAIN,14));
		menuFerramentas.add(itemMenuRapido);
		itemDefinirSenha.setFont(new Font("Arial Now ",Font.PLAIN,14));
		itemSeguranca.add(itemDefinirSenha);
		itemNiveldeAcesso.setFont(new Font("Arial Now ",Font.PLAIN,14));
		itemSeguranca.add(itemNiveldeAcesso);
		menuFerramentas.add(itemSeguranca);
		
		menubar.add(menuFerramentas);
		
		
		
		
		//
		//		// Sub-Menu AbrirArquivo
		//
		//		ImageIcon iconAbrirArquivo = new ImageIcon(ConstantesImages.ABRIR);
		//
		//		menuAbrirArquivo.setIcon(iconAbrirArquivo);
		//
		//		menuAbrirArquivo.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuArquivo.add(menuAbrirArquivo);
		//
		//		menuArquivo.addSeparator();
		//
		//		// Sub-Menu Sair
		//
		//		ImageIcon iconSair = new ImageIcon(ConstantesImages.FECHAR);
		//
		//		menuSair.setIcon(iconSair);
		//
		//		menuSair.setMnemonic(KeyEvent.VK_S);
		//
		//		menuSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
		//				ActionEvent.ALT_MASK));
		//
		//		menuSair.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuArquivo.add(menuSair);
		//
		//		// Termina menu Arquivo
		//
		//		// Começa menu GerarArquivos
		//
		//		ImageIcon iconGerarArquivos = new ImageIcon(
		//				ConstantesImages.ARQUIVO_FRASES);
		//
		//		menuGerarArquivos.setIcon(iconGerarArquivos);
		//
		//		menuGerarArquivos.setMnemonic(KeyEvent.VK_G);
		//
		//		menuGerarArquivos.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		//
		//		menubar.add(menuGerarArquivos);
		//
		//		// Sub-Menu GerarArquivoFonemas
		//
		//		ImageIcon iconGerarFonemas = new ImageIcon(
		//				ConstantesImages.GERAR_FONEMAS);
		//
		//		menuGerarFonemas.setIcon(iconGerarFonemas);
		//
		//		menuGerarFonemas.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuGerarArquivos.add(menuGerarFonemas);
		//
		//		menuGerarArquivos.addSeparator();
		//
		//		// Sub-Menu GerarArquivoFrases
		//
		//		ImageIcon iconGerarFrases = new ImageIcon(ConstantesImages.GERAR_FRASES);
		//
		//		menuGerarFrases.setIcon(iconGerarFrases);
		//
		//		menuGerarFrases.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuGerarArquivos.add(menuGerarFrases);
		//
		//		// Termina menu GerarArquivosTreinamento
		//
		//		// Começa menu Gravação
		//
		//		ImageIcon iconGravar = new ImageIcon(ConstantesImages.TELAINICIAL);
		//
		//		menuGravar.setIcon(iconGravar);
		//
		//		menuGravar.setMnemonic(KeyEvent.VK_R);
		//
		//		menuGravar.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		//
		//		menubar.add(menuGravar);
		//
		//		// Sub-Menu GravarFrases
		//
		//		ImageIcon iconGravarFrases = new ImageIcon(ConstantesImages.GRAVAR);
		//
		//		menuGravarFrases.setIcon(iconGravarFrases);
		//
		//		menuGravarFrases.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuGravar.add(menuGravarFrases);
		//
		//		// Termina menu Gravação
		//
		//		// Começa menu Treinamento
		//
		//		ImageIcon iconTreinamento = new ImageIcon(ConstantesImages.TREINAMENTO);
		//
		//		menuTreinamento.setIcon(iconTreinamento);
		//
		//		menuTreinamento.setMnemonic(KeyEvent.VK_T);
		//
		//		menuTreinamento.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		//
		//		menubar.add(menuTreinamento);
		//
		//		// Sub-Menu Treinar
		//
		//		ImageIcon iconTreinar = new ImageIcon(ConstantesImages.TREINAR);
		//
		//		menuTreinar.setIcon(iconTreinar);
		//
		//		menuTreinar.setMnemonic(KeyEvent.VK_N);
		//
		//		menuTreinar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
		//				ActionEvent.ALT_MASK));
		//
		//		menuTreinar.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuTreinamento.add(menuTreinar);
		//
		//		menuTreinamento.addSeparator();
		//
		//		// Sub-Menu Opções
		//
		//		ImageIcon iconOpcoes = new ImageIcon(ConstantesImages.OPCOES);
		//
		//		menuOpcoes.setIcon(iconOpcoes);
		//
		//		menuOpcoes.setMnemonic(KeyEvent.VK_O);
		//
		//		menuOpcoes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
		//				ActionEvent.ALT_MASK));
		//
		//		menuOpcoes.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuTreinamento.add(menuOpcoes);
		//
		//		// Termina menu Treinamento
		//
		//		// Começa menu Ajuda
		//
		//		ImageIcon iconAjuda = new ImageIcon(ConstantesImages.AJUDA);
		//
		//		menuAjuda.setIcon(iconAjuda);
		menuAjuda.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		//
		menuAjuda.add(itemAjuda);
		menuAjuda.addSeparator();
		menubar.add(menuAjuda);
		
		itemSair.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		menuSair.add(itemSair);
		menubar.add(menuSair);

		//
		//		// Sub-Menu Sobre
		//
		//		ImageIcon iconSobre = new ImageIcon(ConstantesImages.SOBRE);
		//
		//		menuSobre.setIcon(iconSobre);
		//
		//		menuSobre.setMnemonic(KeyEvent.VK_B);
		//
		//		menuSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
		//				ActionEvent.ALT_MASK));
		//
		//		menuSobre.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		//
		//		menuAjuda.add(menuSobre);
		//
		//		// Termina menu Ajuda

	}

	public JMenuBar getMenuBar() {
		return menubar;
	}
}