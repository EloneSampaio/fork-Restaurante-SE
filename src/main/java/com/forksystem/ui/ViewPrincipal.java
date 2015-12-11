package com.forksystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.forksystem.controller.CategoriaController;
import com.forksystem.controller.ClienteController;
import com.forksystem.controller.ContaAPagarController;
import com.forksystem.controller.ContaAReceberController;
import com.forksystem.controller.ContaController;
import com.forksystem.controller.EstoqueController;
import com.forksystem.controller.FornecedorController;
import com.forksystem.controller.FuncionarioController;
import com.forksystem.controller.MarcaController;
import com.forksystem.controller.MesaController;
import com.forksystem.controller.OrcamentoController;
import com.forksystem.controller.ProdutoController;
import com.forksystem.controller.UnidadeController;
import com.forksystem.controller.VendaController;
import com.forksystem.utils.Config;
import com.forksystem.utils.ConverterDataHora;

public final class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JDesktopPane painelDesktop = null;
	private ClienteController cli = null;
	private FuncionarioController funcionario = null;
	private CategoriaController categoria = null;
	private ContaController conta = null;
	private MarcaController marca = null;
	private UnidadeController unidade = null;
	private ProdutoController produto = null;
	private FornecedorController fornecedor = null;
	private VendaController venda = null;
	private OrcamentoController orcamento = null;
	private EstoqueController estoque = null;
	private MesaController mesa = null;
	private ViewMenuBaixo menuBaixo = null;
	private ContaAPagarController contaPaga = null;
	private ContaAReceberController contaReceber = null;
	private ViewImportProduto produtoImport = null;
	private static Image img;
	private ConverterDataHora da;
	private JLabel lblData;
	private JLabel lblHora;
	private JLabel lblSejaBemVindo;
	private ViewAlteraFundo fundo = null;;
	private ViewAjuda ajuda = null;
	private ViewAlteraTema tema = null;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		Properties prop = Config.getPropriedade();
		setTitle(prop.getProperty("prop.btn.Titulo"));
		setLayout(new BorderLayout());
		da = new ConverterDataHora();
		setBounds(100, 100, 755, 169);

		javax.swing.Timer time = new javax.swing.Timer(1000, new verRelogio());
		time.setRepeats(true);
		time.setInitialDelay(0);
		time.start();

		lblData = new JLabel();
		lblData.setFont(new Font("Dialog", Font.BOLD, 20));
		lblData.setForeground(Color.BLACK);
		lblData.setBounds(1200, 92, 2000, 1200);

		lblHora = new JLabel();
		lblHora.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHora.setForeground(Color.BLACK);
		lblHora.setBounds(1200, 120, 2000, 1250);

		lblSejaBemVindo = new JLabel("Seja Bem Vindo");
		lblSejaBemVindo.setForeground(new Color(255, 255, 255));
		lblSejaBemVindo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSejaBemVindo.setBounds(250, 12, 210, 28);

		// difinindo tamanho da tela
		int inset = 25;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 1, screenSize.height - inset * 3);
		/////////////////////////////////////////////////////////////////////////

		setPainelDesktop(new DecorateJdesktopPanel(prop.getProperty("prop.btn.Fundo")));
		getPainelDesktop().add(lblData, BorderLayout.EAST);
		getPainelDesktop().add(lblHora, BorderLayout.EAST);
		painelDesktop.setDesktopManager(new de.javasoft.plaf.synthetica.SyntheticaDesktopManager());
		setContentPane(getPainelDesktop());
		ViewMenuBaixo menuBaixo = new ViewMenuBaixo();
		menuBaixo.setLocation(new Point(300, 100));
		menuBaixo.setVisible(true);

		// // remover drag and drop dos jInternalFrame
		// BasicInternalFrameUI ui = (BasicInternalFrameUI) menuBaixo.getUI();
		// Component noth = ui.getNorthPane();
		// MouseMotionListener[] actions = (MouseMotionListener[])
		// noth.getListeners(MouseMotionListener.class);
		// for (int i = 0; i < actions.length; i++) {
		// noth.removeMouseMotionListener(actions[i]);
		//
		// }
		// setLocationRelativeTo(null);
		getPainelDesktop().add(menuBaixo);

		///////////////////////////////////////////////////////////////////////
		// criando menu e difinindo as ações dos intens de menu
		ViewMenu menu = new ViewMenu();
		setJMenuBar(menu.getMenuBar());

		menu.itemClientes.setActionCommand("cliente");
		menu.itemClientes.addActionListener(new TratarEventos());
		menu.itemFornecedor.setActionCommand("fornecedor");
		menu.itemFornecedor.addActionListener(new TratarEventos());
		menu.itemContaBancaria.setActionCommand("conta");
		menu.itemContaBancaria.addActionListener(new TratarEventos());
		menu.itemFuncionarios.setActionCommand("funcionario");
		menu.itemFuncionarios.addActionListener(new TratarEventos());
		menu.itemMarca.setActionCommand("marca");
		menu.itemMarca.addActionListener(new TratarEventos());
		menu.itemUnidades.setActionCommand("unidade");
		menu.itemUnidades.addActionListener(new TratarEventos());
		menu.itemCategorias.setActionCommand("categoria");
		menu.itemCategorias.addActionListener(new TratarEventos());
		menu.itemProdutoCadastro.setActionCommand("produto");
		menu.itemProdutoCadastro.addActionListener(new TratarEventos());
		menu.itemProdutoImport.setActionCommand("produtoImport");
		menu.itemProdutoImport.addActionListener(new TratarEventos());
		menu.itemVendas.setActionCommand("venda");
		menu.itemVendas.addActionListener(new TratarEventos());
		menu.itemOrcamento.setActionCommand("orcamento");
		menu.itemOrcamento.addActionListener(new TratarEventos());
		menu.itemControleEstoque.setActionCommand("estoque");
		menu.itemControleEstoque.addActionListener(new TratarEventos());
		menu.itemMesa.setActionCommand("mesa");
		menu.itemMesa.addActionListener(new TratarEventos());
		menu.itemMenuRapido.setActionCommand("menu");
		menu.itemMenuRapido.addActionListener(new TratarEventos());
		menu.itemContaApagar.setActionCommand("ContaAPagar");
		menu.itemContaApagar.addActionListener(new TratarEventos());
		menu.itemContaReceber.setActionCommand("ContaAReceber");
		menu.itemContaReceber.addActionListener(new TratarEventos());
		menu.itemAlterarFundo.setActionCommand("fundo");
		menu.itemAlterarFundo.addActionListener(new TratarEventos());
		menu.itemCalculadora.setActionCommand("calc");
		menu.itemCalculadora.addActionListener(new TratarEventos());
		menu.itemAjuda.setActionCommand("ajuda");
		menu.itemAjuda.addActionListener(new TratarEventos());
		menu.itemAlterarTema.setActionCommand("tema");
		menu.itemAlterarTema.addActionListener(new TratarEventos());

		// setando metodo e difinindo a ação de sair do sistema
		menu.itemSair.setActionCommand("Sair");
		menu.itemSair.addActionListener(new TratarEventos());

		// definindo os estilos das janelas do jfram e outras configurações
		JFrame.setDefaultLookAndFeelDecorated(true);
		setResizable(false); // não pode ser mudado o tamanho da jfram
		// setBackground(Color.getHSBColor(6, 20, 10)); // definindo o fundo
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // definindo a
																// ação de
																// fechar
																// programa ao
																// clicar em X

		/*
		 * metodo executado quando clicamos em fechar a aplicação
		 */
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String ObjButtons[] = { "Sim", "Não" };
				int opcao = JOptionPane.showOptionDialog(null, "Deseja fechar?", "Sair", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

	/*
	 * Metodo responsavel por centralizar as internalFrame na tela do jfram
	 */
	public static void centerInternal(JDesktopPane desktop, JInternalFrame internal) {
		int x = (desktop.getWidth() - internal.getWidth()) / 2;
		int y = (desktop.getHeight() - internal.getHeight()) / 2;

		internal.setLocation(x, y);
	}

	/*
	 * Metodo que responsavel por fechar a aplicação
	 */
	private void sair() {

		System.exit(0);
	}

	public static JDesktopPane getPainelDesktop() {
		return painelDesktop;
	}

	public static void setPainelDesktop(JDesktopPane painelDesktop) {
		ViewPrincipal.painelDesktop = painelDesktop;
	}

	public void mostrarHora() {

		if (null != da.dataActual()) {
			lblData.setText(" Data " + da.dataActual());
			lblHora.setText("Hora " + da.horaActual());
		} else {
			lblData.setText("Data 10:10:2010");
			lblHora.setText("Hora 00:00:00");

		}

	}

	public class verRelogio implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				mostrarHora();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}

		}

	}

	/**
	 * Classe Interna para tratar eventos do menu
	 * 
	 * @author sam
	 *
	 */

	public class TratarEventos implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Sair")) {
				sair();
			}

			if (e.getActionCommand().equals("cliente")) {
				if (cli == null) {
					cli = new ClienteController();
					cli.gui.setVisible(true);
					getPainelDesktop().add(cli.gui);
					try {
						cli.gui.setSelected(true);
						if (cli.gui.isClosable()) {
							cli = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					cli.gui.setVisible(true);

				}
			}

			if (e.getActionCommand().equals("categoria")) {
				if (categoria == null) {
					categoria = new CategoriaController();
					categoria.gui.setVisible(true);
					getPainelDesktop().add(categoria.gui);
					try {
						categoria.gui.setSelected(true);
						if (categoria.gui.isClosable()) {
							categoria = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					categoria.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("conta")) {
				if (conta == null) {
					conta = new ContaController();
					conta.gui.setVisible(true);
					getPainelDesktop().add(conta.gui);
					try {
						conta.gui.setSelected(true);
						if (conta.gui.isClosable()) {
							conta = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					conta.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("funcionario")) {
				if (funcionario == null) {
					funcionario = new FuncionarioController();
					funcionario.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(funcionario.gui);
					try {
						funcionario.gui.setSelected(true);
						if (funcionario.gui.isClosable()) {
							funcionario = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					funcionario.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("marca")) {
				if (marca == null) {
					marca = new MarcaController();
					marca.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(marca.gui);
					try {
						marca.gui.setSelected(true);
						if (marca.gui.isClosable()) {
							marca = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					marca.gui.setVisible(true);
				}
			}
			if (e.getActionCommand().equals("unidade")) {
				if (unidade == null) {
					unidade = new UnidadeController();
					unidade.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(unidade.gui);
					try {
						unidade.gui.setSelected(true);
						if (unidade.gui.isClosable()) {
							unidade = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					unidade.gui.setVisible(true);
				}
			}
			if (e.getActionCommand().equals("produto")) {
				if (produto == null) {
					produto = new ProdutoController();
					produto.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(produto.gui);
					try {
						produto.gui.setSelected(true);
						if (produto.gui.isClosable()) {
							produto = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					produto.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("produtoImport")) {
				if (produtoImport == null) {
					produtoImport = new ViewImportProduto();
					produtoImport.setVisible(true);
					getPainelDesktop().add(produtoImport);
					try {
						produtoImport.setSelected(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (produtoImport.isClosable()) {
						produtoImport = null;
					}
				} else {
					produtoImport.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("fornecedor")) {
				if (fornecedor == null) {
					fornecedor = new FornecedorController();
					fornecedor.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(fornecedor.gui);
					try {
						fornecedor.gui.setSelected(true);
						if (fornecedor.gui.isClosable()) {
							fornecedor = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					fornecedor.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("venda")) {
				if (venda == null) {
					venda = new VendaController();
					venda.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(venda.gui);
					try {
						venda.gui.setSelected(true);
						if (venda.gui.isClosable()) {
							venda = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					venda.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("orcamento")) {
				if (orcamento == null) {
					orcamento = new OrcamentoController();
					orcamento.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(orcamento.gui);
					try {
						orcamento.gui.setSelected(true);
						if (orcamento.gui.isClosable()) {
							orcamento = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					orcamento.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("estoque")) {
				if (estoque == null) {
					estoque = new EstoqueController();
					estoque.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(estoque.gui);
					try {
						estoque.gui.setSelected(true);
						if (estoque.gui.isClosable()) {
							estoque = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					estoque.gui.setVisible(true);
				}
			}
			if (e.getActionCommand().equals("mesa")) {
				if (mesa == null) {
					mesa = new MesaController();
					mesa.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(mesa.gui);
					try {
						mesa.gui.setSelected(true);
						if (mesa.gui.isClosable()) {
							mesa = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					mesa.gui.setVisible(true);

				}
			}

			if (e.getActionCommand().equals("ContaAPagar")) {
				if (contaPaga == null) {
					contaPaga = new ContaAPagarController();
					contaPaga.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(contaPaga.gui);
					try {
						contaPaga.gui.setSelected(true);
						if (contaPaga.gui.isClosable()) {
							contaPaga = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					contaPaga.gui.setVisible(true);

				}
			}

			if (e.getActionCommand().equals("ContaAReceber")) {
				if (contaReceber == null) {
					contaReceber = new ContaAReceberController();
					contaReceber.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(contaReceber.gui);
					try {
						contaReceber.gui.setSelected(true);
						if (contaReceber.gui.isClosable()) {
							contaReceber = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					contaReceber.gui.setVisible(true);

				}
			}

			if (e.getActionCommand().equals("menu")) {
				if (menuBaixo == null) {
					menuBaixo = new ViewMenuBaixo();
					menuBaixo.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(menuBaixo);
					try {
						menuBaixo.setSelected(true);
						if (menuBaixo.isClosable()) {
							menuBaixo = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					menuBaixo.setVisible(true);

				}
			}

			if (e.getActionCommand().equals("calc")) {
				String comando = "bash";
				try {

					Process processo = Runtime.getRuntime().exec(comando);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (e.getActionCommand().equals("fundo")) {
				if (fundo == null) {
					fundo = new ViewAlteraFundo();
					fundo.setVisible(true);
					fundo.getBtnconfirmar().addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							Config.setPropriedade("prop.btn.Fundo", fundo.getArquivo());
							JOptionPane.showMessageDialog(ViewPrincipal.this,
									"Fundo alterado. Reinicia para ver as modificações");

						}
					});

				}
			}

			if (e.getActionCommand().equals("ajuda")) {
				if (ajuda == null) {
					ajuda = new ViewAjuda();
					ajuda.setVisible(true);
					getPainelDesktop().add(ajuda);

					try {
						ajuda.setSelected(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (ajuda.isClosable()) {
						ajuda = null;
					}

				}
			}

			if (e.getActionCommand().equals("tema")) {
				if (tema == null) {
					tema = new ViewAlteraTema();
					tema.setVisible(true);
					getPainelDesktop().add(tema);
					try {
						tema.setSelected(true);
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (tema.isClosable()) {
						tema = null;
					}

				}
			}

		}

	}

}
