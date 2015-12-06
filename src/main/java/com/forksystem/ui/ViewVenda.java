package com.forksystem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.forksystem.controller.TabelaClienteController;
import com.forksystem.dao.ICartao;
import com.forksystem.dao.ITipoPagamento;
import com.forksystem.entities.Cartao;
import com.forksystem.entities.TipoPagamento;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.utils.Context;
import com.forksystem.utils.OnlyNumber;

import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;
import com.forksystem.entities.TipoPagamentos;

public class ViewVenda extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigovenda;
	private JTextField txtValorvenda;
	private JTextField txtDesconto;
	private JTextField txtTotal;
	private JTable table;
	private ITipoPagamento tipo = null;
	private ICartao cartao = null;
	public TableModelPersonalizado tabela;
	private JComboBox cmbTipoPagamento;
	private JComboBox cmbCartao;
	private JButton btnNovo;
	private JButton btnVer;
	private JButton btnInserirItem;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JButton btnImprimir;
	private JPanel panelDados;
	private JPanel panelTabela;
	private JLabel llbTotal;
	private JTextField textNomeCliente;
	private DateField data;
	private JButton btnCalcularTotal;
	private JLabel lblTotalMensagem;
	private JTextField txtCliente;
	private JTextField txtFuncionario;

	public ViewVenda() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setClosable(true);
		setIconifiable(true);
		setTitle("Movimentos/Venda");
		setBounds(100, 100, 855, 724);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 238, 746, 0 };
		gridBagLayout.rowHeights = new int[] { 362, 338, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panelMenu = new GridBagConstraints();
		gbc_panelMenu.fill = GridBagConstraints.BOTH;
		gbc_panelMenu.insets = new Insets(0, 0, 0, 5);
		gbc_panelMenu.gridheight = 2;
		gbc_panelMenu.gridx = 0;
		gbc_panelMenu.gridy = 0;
		getContentPane().add(panelMenu, gbc_panelMenu);
		GridBagLayout gbl_panelMenu = new GridBagLayout();
		gbl_panelMenu.columnWidths = new int[]{163, 0};
		gbl_panelMenu.rowHeights = new int[]{54, 49, 49, 49, 49, 49, 49, 48, 49, 0};
		gbl_panelMenu.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMenu.setLayout(gbl_panelMenu);
				
						btnNovo = new JButton("Nova Venda");
						btnNovo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						btnNovo.setForeground(new Color(255, 255, 255));
						
								btnNovo.setHorizontalAlignment(SwingConstants.LEFT);
								btnNovo.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/archive1.png")));
								btnNovo.setActionCommand("novo");
								GridBagConstraints gbc_btnNovo = new GridBagConstraints();
								gbc_btnNovo.fill = GridBagConstraints.BOTH;
								gbc_btnNovo.insets = new Insets(0, 0, 5, 0);
								gbc_btnNovo.gridx = 0;
								gbc_btnNovo.gridy = 1;
								panelMenu.add(btnNovo, gbc_btnNovo);
		
				btnVer = new JButton("Ver Venda");
				btnVer.setActionCommand("verDados");
				btnVer.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				btnVer.setForeground(new Color(255, 255, 255));
				btnVer.setHorizontalAlignment(SwingConstants.LEFT);
				btnVer.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/archive.png")));
				GridBagConstraints gbc_btnVer = new GridBagConstraints();
				gbc_btnVer.fill = GridBagConstraints.BOTH;
				gbc_btnVer.insets = new Insets(0, 0, 5, 0);
				gbc_btnVer.gridx = 0;
				gbc_btnVer.gridy = 2;
				panelMenu.add(btnVer, gbc_btnVer);
								
										btnInserirItem = new JButton("Inserir Item");
										btnInserirItem.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
										btnInserirItem.setForeground(new Color(255, 255, 255));
										btnInserirItem.setEnabled(false);
										btnInserirItem.setHorizontalAlignment(SwingConstants.LEFT);
										btnInserirItem.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/forward_alt.png")));
										btnInserirItem.setActionCommand("inserir");
										GridBagConstraints gbc_btnInserirItem = new GridBagConstraints();
										gbc_btnInserirItem.fill = GridBagConstraints.BOTH;
										gbc_btnInserirItem.insets = new Insets(0, 0, 5, 0);
										gbc_btnInserirItem.gridx = 0;
										gbc_btnInserirItem.gridy = 3;
										panelMenu.add(btnInserirItem, gbc_btnInserirItem);
						
								btnExcluir = new JButton("Excluir");
								btnExcluir.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
								btnExcluir.setForeground(new Color(255, 255, 255));
								btnExcluir.setEnabled(false);
								btnExcluir.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/minus white.png")));
								btnExcluir.setActionCommand("excluir");
								GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
								gbc_btnExcluir.fill = GridBagConstraints.BOTH;
								gbc_btnExcluir.insets = new Insets(0, 0, 5, 0);
								gbc_btnExcluir.gridx = 0;
								gbc_btnExcluir.gridy = 4;
								panelMenu.add(btnExcluir, gbc_btnExcluir);
						
								btnCancelar = new JButton("Cancelar");
								btnCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
								btnCancelar.setForeground(new Color(255, 255, 255));
								btnCancelar.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/stop 2.png")));
								btnCancelar.setActionCommand("cancelar");
								GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
								gbc_btnCancelar.fill = GridBagConstraints.BOTH;
								gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
								gbc_btnCancelar.gridx = 0;
								gbc_btnCancelar.gridy = 5;
								panelMenu.add(btnCancelar, gbc_btnCancelar);
				
						btnConfirmar = new JButton("Confirmar");
						btnConfirmar.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						btnConfirmar.setForeground(new Color(255, 255, 255));
						btnConfirmar.setEnabled(false);
						btnConfirmar.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/refresh.png")));
						btnConfirmar.setActionCommand("confirmar");
						GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
						gbc_btnConfirmar.fill = GridBagConstraints.BOTH;
						gbc_btnConfirmar.insets = new Insets(0, 0, 5, 0);
						gbc_btnConfirmar.gridx = 0;
						gbc_btnConfirmar.gridy = 6;
						panelMenu.add(btnConfirmar, gbc_btnConfirmar);
		
				btnImprimir = new JButton("Imprimir");
				btnImprimir.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				btnImprimir.setForeground(new Color(255, 255, 255));
				btnImprimir.setEnabled(false);
				btnImprimir.setHorizontalAlignment(SwingConstants.LEFT);
				btnImprimir.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/print.png")));
				btnImprimir.setActionCommand("imprimir");
				GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
				gbc_btnImprimir.fill = GridBagConstraints.BOTH;
				gbc_btnImprimir.insets = new Insets(0, 0, 5, 0);
				gbc_btnImprimir.gridx = 0;
				gbc_btnImprimir.gridy = 7;
				panelMenu.add(btnImprimir, gbc_btnImprimir);
		
				btnCalcularTotal = new JButton("Calcular Total");
				btnCalcularTotal.setForeground(new Color(255, 255, 255));
				btnCalcularTotal.setEnabled(false);
				btnCalcularTotal.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/calculator_add_12952 (1).png")));
				btnCalcularTotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
				btnCalcularTotal.setActionCommand("calcular");
				GridBagConstraints gbc_btnCalcularTotal = new GridBagConstraints();
				gbc_btnCalcularTotal.fill = GridBagConstraints.BOTH;
				gbc_btnCalcularTotal.gridx = 0;
				gbc_btnCalcularTotal.gridy = 8;
				panelMenu.add(btnCalcularTotal, gbc_btnCalcularTotal);

		panelDados = new JPanel();
		panelDados.setForeground(new Color(0, 0, 0));
		panelDados.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panelDados = new GridBagConstraints();
		gbc_panelDados.fill = GridBagConstraints.BOTH;
		gbc_panelDados.insets = new Insets(0, 0, 5, 0);
		gbc_panelDados.gridx = 1;
		gbc_panelDados.gridy = 0;
		getContentPane().add(panelDados, gbc_panelDados);
		panelDados.setLayout(null);

		JLabel lblCodigodavenda = new JLabel("Codigo");
		lblCodigodavenda.setForeground(new Color(255, 255, 255));
		lblCodigodavenda.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCodigodavenda.setBounds(70, 44, 109, 16);
		panelDados.add(lblCodigodavenda);

		txtCodigovenda = new JTextField();
		txtCodigovenda.setEditable(false);
		txtCodigovenda.setBounds(70, 72, 109, 20);
		panelDados.add(txtCodigovenda);
		txtCodigovenda.setColumns(10);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(new Color(255, 255, 255));
		lblCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCliente.setBounds(197, 44, 72, 16);
		panelDados.add(lblCliente);

		txtCliente = new JTextField();
		JLabel lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabelaClienteController tb = new TabelaClienteController(ViewVenda.this);
				tb.gui.setModal(true);
				tb.gui.setVisible(true);

			}
		});
		lblBuscar.setIcon(new ImageIcon(ViewVenda.class.getResource("/img/PNG/search.png")));
		lblBuscar.setBounds(396, 60, 32, 32);
		panelDados.add(lblBuscar);

		txtFuncionario = new JTextField();
		JLabel lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Dialog", Font.BOLD, 14));
		lblData.setBounds(70, 121, 57, 16);
		panelDados.add(lblData);

		data = CalendarFactory.createDateField();
		data.setBounds(70, 146, 116, 20);
		panelDados.add(data);
		JLabel lblTipoDePagamento = new JLabel("Pagamento");
		lblTipoDePagamento.setForeground(new Color(255, 255, 255));
		lblTipoDePagamento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipoDePagamento.setBounds(213, 121, 116, 16);
		panelDados.add(lblTipoDePagamento);

		cmbTipoPagamento = new JComboBox();
		cmbTipoPagamento.setModel(new DefaultComboBoxModel(TipoPagamentos.values()));
		cmbTipoPagamento.setBounds(214, 146, 116, 20);
		panelDados.add(cmbTipoPagamento);

		JLabel lblCarto = new JLabel("Cartão");
		lblCarto.setForeground(new Color(255, 255, 255));
		lblCarto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCarto.setBounds(349, 121, 72, 16);
		panelDados.add(lblCarto);

		cmbCartao = new JComboBox();
		cmbCartao.setBounds(349, 146, 161, 20);
		panelDados.add(cmbCartao);

		JLabel lblV = new JLabel("Valor da Venda");
		lblV.setForeground(new Color(255, 255, 255));
		lblV.setFont(new Font("Dialog", Font.BOLD, 14));
		lblV.setBounds(70, 199, 136, 16);
		panelDados.add(lblV);

		txtValorvenda = new JTextField();
		txtValorvenda.setEditable(false);
		txtValorvenda.setBounds(70, 226, 152, 20);
		panelDados.add(txtValorvenda);
		txtValorvenda.setColumns(10);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setForeground(new Color(255, 255, 255));
		lblDesconto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDesconto.setBounds(234, 199, 96, 16);
		panelDados.add(lblDesconto);

		txtDesconto = new JTextField();
		txtDesconto.setBounds(234, 226, 85, 20);
		panelDados.add(txtDesconto);
		txtDesconto.setColumns(10);
		txtDesconto.setDocument(new OnlyNumber());

		JLabel lblTotalGeral = new JLabel("Total Geral");
		lblTotalGeral.setForeground(new Color(255, 255, 255));
		lblTotalGeral.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTotalGeral.setBounds(348, 199, 116, 16);
		panelDados.add(lblTotalGeral);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(349, 226, 160, 20);
		panelDados.add(txtTotal);
		txtTotal.setColumns(10);

		textNomeCliente = new JTextField();
		textNomeCliente.setEditable(false);
		textNomeCliente.setBounds(197, 72, 192, 20);
		panelDados.add(textNomeCliente);
		textNomeCliente.setColumns(10);
		panelTabela = new JPanel();
		panelTabela.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panelTabela = new GridBagConstraints();
		gbc_panelTabela.fill = GridBagConstraints.BOTH;
		gbc_panelTabela.gridx = 1;
		gbc_panelTabela.gridy = 1;
		getContentPane().add(panelTabela, gbc_panelTabela);
		panelTabela.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 25, 641, 259);
		panelTabela.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Cod Produto", "Quantidade", "Valor Unitario", "Valor Total" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(126);
		table.getColumnModel().getColumn(1).setPreferredWidth(121);
		table.getColumnModel().getColumn(2).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(table);

		lblTotalMensagem = new JLabel("Total a Pagar:");
		lblTotalMensagem.setForeground(Color.WHITE);
		lblTotalMensagem.setVisible(false);
		lblTotalMensagem.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblTotalMensagem.setBounds(280, 296, 180, 30);
		panelTabela.add(lblTotalMensagem);

		llbTotal = new JLabel("");
		llbTotal.setForeground(Color.WHITE);
		llbTotal.setFont(new Font("Dialog", Font.PLAIN, 26));
		llbTotal.setBounds(445, 296, 200, 30);
		panelTabela.add(llbTotal);

	}

	public void iniciarTransacao() {
		tipo = Context.getInstace().getContexto().getBean(ITipoPagamento.class);
		cartao = Context.getInstace().getContexto().getBean(ICartao.class);
		preencherComobo();
	}

	public void preencherComobo() {
		cmbCartao.removeAllItems();
		cmbCartao.addItem("escolha");
		DefaultComboBoxModel comboModel1 = (DefaultComboBoxModel) cmbCartao.getModel();
		for (Cartao object : cartao.findAll()) {
			cmbCartao.addItem(object);
		}
	}

	public void ouvinte(ActionListener e, JButton b) {

		b.addActionListener(e);

	}

	public JTextField getTxtCodigovenda() {
		return txtCodigovenda;
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public JComboBox getCmbTipoPagamento() {
		return cmbTipoPagamento;
	}

	public JComboBox getCmbCartao() {
		return cmbCartao;
	}

	public JTextField getTxtValorvenda() {
		return txtValorvenda;
	}

	public JTextField getTxtDesconto() {
		return txtDesconto;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnNovo() {
		return btnNovo;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	public JButton getBtnInserirItem() {
		return btnInserirItem;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public void setarCliente(String valor) {
		txtCliente.setText(valor);
	}

	public JPanel getPanelDados() {
		return panelDados;
	}

	public JPanel getPanelTabela() {
		return panelTabela;
	}

	public JLabel getLlbTotal() {
		return llbTotal;
	}

	public JTextField getTextNomeCliente() {
		return textNomeCliente;
	}

	public DateField getData() {
		return data;
	}

	

	public JButton getBtnCalcularTotal() {
		return btnCalcularTotal;
	}

	public JLabel getLblTotalMensagem() {
		return lblTotalMensagem;
	}

	public JTextField getTxtFuncionario() {
		return txtFuncionario;
	}
}
