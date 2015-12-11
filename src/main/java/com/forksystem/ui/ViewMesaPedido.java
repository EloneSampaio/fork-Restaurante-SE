package com.forksystem.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class ViewMesaPedido extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPedidos;
	private JPanel panelCategoria;
	private JPanel panelProduto;
	private JLabel lblMesa;
	private JTable table;
	private JButton btnAdicionar;
	private JButton btnExluir;
	private JButton btnCalcularTotal;
	private JButton btnImprimir;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblTotalGeral;
	private JTextField txtTotal;
	private JPanel panelPreco;
	private JLabel totalGeral;



	/**
	 * Create the frame.
	 */
	public ViewMesaPedido(String mesa) {
		setMaximizable(true);
		setClosable(true);
		setTitle("Mesas/Pedidos");
		getContentPane().setBackground(new Color(0, 128, 128));
		setIconifiable(true);
		setBounds(200, 400, 1388, 828);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, 372, 67);
		panel.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{186, 173, 0};
		gbl_panel.rowHeights = new int[]{33, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblMesa = new JLabel(mesa);
		lblMesa.setForeground(Color.WHITE);
		lblMesa.setFont(new Font("Dialog", Font.BOLD, 27));
		GridBagConstraints gbc_lblMesa = new GridBagConstraints();
		gbc_lblMesa.insets = new Insets(0, 0, 5, 0);
		gbc_lblMesa.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMesa.gridx = 1;
		gbc_lblMesa.gridy = 0;
		panel.add(lblMesa, gbc_lblMesa);
		
		JLabel lblItensDaMesa = new JLabel("Itens da Mesa");
		GridBagConstraints gbc_lblItensDaMesa = new GridBagConstraints();
		gbc_lblItensDaMesa.anchor = GridBagConstraints.WEST;
		gbc_lblItensDaMesa.gridx = 1;
		gbc_lblItensDaMesa.gridy = 1;
		panel.add(lblItensDaMesa, gbc_lblItensDaMesa);
		lblItensDaMesa.setForeground(Color.WHITE);
		lblItensDaMesa.setFont(new Font("Dialog", Font.BOLD, 24));
		lblItensDaMesa.setBackground(Color.WHITE);
		
		panelCategoria = new JPanel();
		panelCategoria.setBounds(592, 0, 776, 289);
		panelCategoria.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Categorias de Produto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)), new MatteBorder(10, 12, 12, 10, (Color) new Color(122, 138, 153))));
		panelCategoria.setBackground(new Color(255, 255, 255));
		panelCategoria.setFont(new Font("Dialog", Font.BOLD, 27));
		getContentPane().add(panelCategoria);
		panelCategoria.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(83, 103, 421, 42);
		getContentPane().add(panelBtn);
		GridBagLayout gbl_panelBtn = new GridBagLayout();
		gbl_panelBtn.columnWidths = new int[]{66, 66, 66, 66, 66, 66, 0};
		gbl_panelBtn.rowHeights = new int[]{42, 0};
		gbl_panelBtn.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBtn.setLayout(gbl_panelBtn);
		
		btnCancelar = new JButton("");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 0;
		panelBtn.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/stop.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		
		btnImprimir = new JButton("");
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimir.gridx = 1;
		gbc_btnImprimir.gridy = 0;
		panelBtn.add(btnImprimir, gbc_btnImprimir);
		btnImprimir.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/print.png")));
		btnImprimir.setToolTipText("Imprimir");
		btnImprimir.setActionCommand("imprimir");
		
		btnConfirmar = new JButton("");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 2;
		gbc_btnConfirmar.gridy = 0;
		panelBtn.add(btnConfirmar, gbc_btnConfirmar);
		btnConfirmar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/refresh.png")));
		btnConfirmar.setToolTipText("Processar Pedido");
		btnConfirmar.setActionCommand("confirmar");
		
		btnCalcularTotal = new JButton("");
		GridBagConstraints gbc_btnCalcularTotal = new GridBagConstraints();
		gbc_btnCalcularTotal.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalcularTotal.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcularTotal.gridx = 3;
		gbc_btnCalcularTotal.gridy = 0;
		panelBtn.add(btnCalcularTotal, gbc_btnCalcularTotal);
		btnCalcularTotal.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/calculator.png")));
		btnCalcularTotal.setToolTipText("Calcular Total");
		btnCalcularTotal.setActionCommand("excluir");
		btnCalcularTotal.setActionCommand("calcular");
		
		btnExluir = new JButton("");
		GridBagConstraints gbc_btnExluir = new GridBagConstraints();
		gbc_btnExluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExluir.gridx = 4;
		gbc_btnExluir.gridy = 0;
		panelBtn.add(btnExluir, gbc_btnExluir);
		btnExluir.setToolTipText("Excluir Item");
		btnExluir.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/minus white.png")));
		btnExluir.setActionCommand("excluir");
		
		btnAdicionar = new JButton("");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionar.gridx = 5;
		gbc_btnAdicionar.gridy = 0;
		panelBtn.add(btnAdicionar, gbc_btnAdicionar);
		btnAdicionar.setToolTipText("Adicionar quantidade");
		btnAdicionar.setActionCommand("adicionar");
		btnAdicionar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/plus.png")));
		
		panelPedidos = new JPanel();
		panelPedidos.setBounds(0, 150, 587, 606);
		panelPedidos.setBackground(new Color(0, 128, 128));
		getContentPane().add(panelPedidos);
		GridBagLayout gbl_panelPedidos = new GridBagLayout();
		gbl_panelPedidos.columnWidths = new int[]{587, 0};
		gbl_panelPedidos.rowHeights = new int[]{335, 67, 162, 0};
		gbl_panelPedidos.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelPedidos.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPedidos.setLayout(gbl_panelPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelPedidos.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Arroz", "10", "20", "10"},
			},
			new String[] {
				"Produto", "Qtd", "Pre\u00E7o", "Total"
			}
		));
		scrollPane.setViewportView(table);
		
		panelPreco = new JPanel();
		panelPreco.setForeground(new Color(0, 128, 128));
		panelPreco.setBorder(new CompoundBorder(new MatteBorder(10, 15, 19, 12, (Color) new Color(0, 128, 128)), new CompoundBorder(new MatteBorder(12, 14, 12, 10, (Color) new Color(0, 128, 128)), new MatteBorder(11, 15, 10, 16, (Color) new Color(0, 128, 128)))));
		GridBagLayout gbl_panelPreco = new GridBagLayout();
		gbl_panelPreco.columnWidths = new int[]{67, 165, 172, 0};
		gbl_panelPreco.rowHeights = new int[]{38, 36, 0};
		gbl_panelPreco.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPreco.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelPreco.setLayout(gbl_panelPreco);
		
		lblTotalGeral = new JLabel("Total Geral =");
		lblTotalGeral.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalGeral.setVisible(false);
		
		lblTotalGeral.setForeground(new Color(0, 0, 0));
		lblTotalGeral.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblTotalGeral_11 = new GridBagConstraints();
		gbc_lblTotalGeral_11.anchor = GridBagConstraints.NORTH;
		gbc_lblTotalGeral_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTotalGeral_11.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalGeral_11.gridx = 1;
		gbc_lblTotalGeral_11.gridy = 1;
		panelPreco.add(lblTotalGeral, gbc_lblTotalGeral_11);
		
		totalGeral = new JLabel("");
		totalGeral.setForeground(new Color(0, 0, 0));
		totalGeral.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_totalGeral_1 = new GridBagConstraints();
		gbc_totalGeral_1.fill = GridBagConstraints.BOTH;
		gbc_totalGeral_1.gridx = 2;
		gbc_totalGeral_1.gridy = 1;
		panelPreco.add(totalGeral, gbc_totalGeral_1);
		//panelPedidos.add(totalGeral, gbc_totalGeral);
		
		GridBagConstraints gbc_panelPreco = new GridBagConstraints();
		gbc_panelPreco.fill = GridBagConstraints.VERTICAL;
		gbc_panelPreco.gridx = 0;
		gbc_panelPreco.gridy = 2;
		panelPedidos.add(panelPreco, gbc_panelPreco);
		
		panelProduto = new JPanel();
		panelProduto.setBounds(592, 294, 776, 462);
		panelProduto.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Produtos", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)), new MatteBorder(10, 12, 12, 10, (Color) new Color(122, 138, 153))));
		panelProduto.setBackground(Color.WHITE);
		getContentPane().add(panelProduto);
		panelProduto.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GridBagConstraints gbc_lblTotalGeral_1 = new GridBagConstraints();
		gbc_lblTotalGeral_1.anchor = GridBagConstraints.EAST;
		gbc_lblTotalGeral_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblTotalGeral_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalGeral_1.gridx = 0;
		gbc_lblTotalGeral_1.gridy = 3;
		 GridBagConstraints gbc_totalGeral_11 = new GridBagConstraints();
		 gbc_totalGeral_11.insets = new Insets(6, 0, 5, 5);
		 gbc_totalGeral_11.fill = GridBagConstraints.BOTH;
		 gbc_totalGeral_11.gridx = 2;
		 gbc_totalGeral_11.gridy = 3;
		 
		 txtTotal = new JTextField();

	}


	public void ouvinte(ActionListener e, JButton b) {

		b.addActionListener(e);

	}

	
	public JPanel getPanelPedidos() {
		return panelPedidos;
	}
	public JPanel getPanelCategoria() {
		return panelCategoria;
	}
	
	public JPanel getPanelProduto() {
		return panelProduto;
	}
	public JLabel getLblMesa() {
		return lblMesa;
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	public JButton getBtnExluir() {
		return btnExluir;
	}

	public JButton getBtnImprimir() {
		return btnImprimir;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JLabel getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(JLabel totalGeral) {
		this.totalGeral = totalGeral;
	}
	public JButton getBtnCalcularTotal() {
		return btnCalcularTotal;
	}

	public JLabel getLblTotalGeral() {
		return lblTotalGeral;
	}

	public void setLblTotalGeral(JLabel lblTotalGeral) {
		this.lblTotalGeral = lblTotalGeral;
	}
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public void setTxtTotal(JTextField txtTotal) {
		this.txtTotal = txtTotal;
	}
}
