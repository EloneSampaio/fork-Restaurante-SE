package com.forksystem.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.forksystem.controller.ContaController;
import com.forksystem.controller.DepartamentoController;
import com.forksystem.controller.EstoqueController;
import com.forksystem.controller.FornecedorController;
import com.forksystem.controller.FuncionarioController;
import com.forksystem.controller.MarcaController;
import com.forksystem.controller.MenuBaixoController;
import com.forksystem.controller.MesaController;
import com.forksystem.controller.OrcamentoController;
import com.forksystem.controller.PlanoDeContaController;
import com.forksystem.controller.ProdutoController;
import com.forksystem.controller.TipoPagamentoController;
import com.forksystem.controller.UnidadeController;
import com.forksystem.controller.VendaController;
import com.forksystem.controller.CartaoController;
import com.forksystem.controller.CategoriaController;
import com.forksystem.controller.ClienteController;
import com.forksystem.controller.ContaAPagarController;

public final class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JDesktopPane painelDesktop = null;
	private ClienteController cli = null;
	private FuncionarioController funcionario = null;
	private CategoriaController categoria = null;
	private ContaController conta = null;
	private CartaoController cartao = null;
	private TipoPagamentoController tipoPGT = null;
	private MarcaController marca = null;
	private UnidadeController unidade = null;
	private ProdutoController produto = null;
	private FornecedorController fornecdor = null;
	private DepartamentoController departamento = null;
	private PlanoDeContaController plano = null;
	private VendaController venda = null;
	private OrcamentoController orcamento = null;
	private EstoqueController estoque = null;
	private MesaController mesa = null;
	private ViewMenuBaixo menuBaixo=null;
    private ContaAPagarController contaPaga=null;
	/**
	 * Launch the application. //
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	//// for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	//// if ("Nimbus".equals(info.getName())) {
	//// UIManager.setLookAndFeel(info.getClassName());
	//// break;
	//// }
	//// }
	// UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
	//
	//
	// UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
	//
	// ViewPrincipal frame = new ViewPrincipal();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {

		// difinindo tamanho da tela
		int inset = 25;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 1, screenSize.height - inset * 3);
		/////////////////////////////////////////////////////////////////////////

		setPainelDesktop(new JDesktopPane());
		// painelDesktop.setDesktopManager(new
		// de.javasoft.plaf.synthetica.SyntheticaDesktopManager());

		setContentPane(getPainelDesktop());
		ViewMenuBaixo menuBaixo = new ViewMenuBaixo();
		menuBaixo.setVisible(true);

		// remover drag and drop dos jInternalFrame
		BasicInternalFrameUI ui = (BasicInternalFrameUI) menuBaixo.getUI();
		Component noth = ui.getNorthPane();
		MouseMotionListener[] actions = (MouseMotionListener[]) noth.getListeners(MouseMotionListener.class);
		for (int i = 0; i < actions.length; i++) {
			noth.removeMouseMotionListener(actions[i]);

		}
		setLocationRelativeTo(null);
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
		menu.itemCartoes.setActionCommand("cartao");
		menu.itemCartoes.addActionListener(new TratarEventos());
		menu.itemFuncionarios.setActionCommand("funcionario");
		menu.itemFuncionarios.addActionListener(new TratarEventos());
		menu.itemTipoPagamento.setActionCommand("tipoPGT");
		menu.itemTipoPagamento.addActionListener(new TratarEventos());
		menu.itemMarca.setActionCommand("marca");
		menu.itemMarca.addActionListener(new TratarEventos());
		menu.itemUnidades.setActionCommand("unidade");
		menu.itemUnidades.addActionListener(new TratarEventos());
		menu.itemCategorias.setActionCommand("categoria");
		menu.itemCategorias.addActionListener(new TratarEventos());
		menu.itemProdutos.setActionCommand("produto");
		menu.itemProdutos.addActionListener(new TratarEventos());
		menu.itemDepartamentos.setActionCommand("departamento");
		menu.itemDepartamentos.addActionListener(new TratarEventos());
		menu.itemPlanoDeConta.setActionCommand("plano");
		menu.itemPlanoDeConta.addActionListener(new TratarEventos());
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

		// setando metodo e difinindo a ação de sair do sistema
		menu.itemSair.setActionCommand("Sair");
		menu.itemSair.addActionListener(new TratarEventos());

		// definindo os estilos das janelas do jfram e outras configurações
		JFrame.setDefaultLookAndFeelDecorated(true);
		setLocationRelativeTo(null);
		setResizable(false); // não pode ser mudado o tamanho da jfram
		setBackground(UIManager.getColor("Button.focus")); // definindo o fundo
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

			if (e.getActionCommand().equals("cartao")) {
				if (cartao == null) {
					cartao = new CartaoController();
					cartao.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(cartao.gui);
					try {
						cartao.gui.setSelected(true);
						if (cartao.gui.isClosable()) {
							cartao = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					System.out.println("sam");
					cartao.gui.setVisible(true);
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
			if (e.getActionCommand().equals("tipoPGT")) {
				if (tipoPGT == null) {
					tipoPGT = new TipoPagamentoController();
					tipoPGT.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(tipoPGT.gui);
					try {
						tipoPGT.gui.setSelected(true);
						if (tipoPGT.gui.isClosable()) {
							tipoPGT = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// prod.setPosicao();
				} else {
					tipoPGT.gui.setVisible(true);
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

			if (e.getActionCommand().equals("fornecdor")) {
				if (fornecdor == null) {
					fornecdor = new FornecedorController();
					fornecdor.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(fornecdor.gui);
					try {
						fornecdor.gui.setSelected(true);
						if (fornecdor.gui.isClosable()) {
							fornecdor = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					fornecdor.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("departamento")) {
				if (departamento == null) {
					departamento = new DepartamentoController();
					departamento.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(departamento.gui);
					try {
						departamento.gui.setSelected(true);
						if (departamento.gui.isClosable()) {
							departamento = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					departamento.gui.setVisible(true);
				}
			}

			if (e.getActionCommand().equals("plano")) {
				if (plano == null) {
					plano = new PlanoDeContaController();
					plano.gui.setVisible(true);
					ViewPrincipal.getPainelDesktop().add(plano.gui);

					try {
						plano.gui.setSelected(true);
						if (plano.gui.isClosable()) {
							plano = null;
						}
					} catch (PropertyVetoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					plano.gui.setVisible(true);
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
			

		}

	}

}
