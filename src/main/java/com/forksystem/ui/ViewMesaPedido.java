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
	private JLabel totalGeral;
	private JButton btnCalcularTotal;
	private JButton btnImprimir;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblTotalGeral;
	private JTextField txtTotal;



	/**
	 * Create the frame.
	 */
	public ViewMesaPedido(String mesa) {
		setClosable(true);
		setTitle("Mesas/Pedidos");
		getContentPane().setBackground(new Color(0, 128, 128));
		setIconifiable(true);
		setBounds(200, 400, 1295, 740);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 66, 66, 66, 66, 181, 674, 0};
		gridBagLayout.rowHeights = new int[]{38, 78, 42, 76, 449, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.SOUTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 6;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{138, 208, 0};
		gbl_panel.rowHeights = new int[]{33, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblMesa = new JLabel(mesa);
		lblMesa.setForeground(Color.WHITE);
		lblMesa.setFont(new Font("Dialog", Font.BOLD, 27));
		GridBagConstraints gbc_lblMesa = new GridBagConstraints();
		gbc_lblMesa.anchor = GridBagConstraints.NORTH;
		gbc_lblMesa.insets = new Insets(0, 0, 5, 0);
		gbc_lblMesa.gridx = 1;
		gbc_lblMesa.gridy = 0;
		panel.add(lblMesa, gbc_lblMesa);
		
		JLabel lblItensDaMesa = new JLabel("Itens da Mesa");
		GridBagConstraints gbc_lblItensDaMesa = new GridBagConstraints();
		gbc_lblItensDaMesa.fill = GridBagConstraints.BOTH;
		gbc_lblItensDaMesa.gridx = 1;
		gbc_lblItensDaMesa.gridy = 1;
		panel.add(lblItensDaMesa, gbc_lblItensDaMesa);
		lblItensDaMesa.setForeground(Color.WHITE);
		lblItensDaMesa.setFont(new Font("Dialog", Font.BOLD, 24));
		lblItensDaMesa.setBackground(Color.WHITE);
		
		panelCategoria = new JPanel();
		panelCategoria.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Categorias de Produto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)), new MatteBorder(10, 12, 12, 10, (Color) new Color(122, 138, 153))));
		panelCategoria.setBackground(new Color(255, 255, 255));
		panelCategoria.setFont(new Font("Dialog", Font.BOLD, 27));
		GridBagConstraints gbc_panelCategoria = new GridBagConstraints();
		gbc_panelCategoria.fill = GridBagConstraints.BOTH;
		gbc_panelCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_panelCategoria.gridheight = 3;
		gbc_panelCategoria.gridx = 6;
		gbc_panelCategoria.gridy = 1;
		getContentPane().add(panelCategoria, gbc_panelCategoria);
		GridBagLayout gbl_panelCategoria = new GridBagLayout();
		gbl_panelCategoria.columnWidths = new int[]{0};
		gbl_panelCategoria.rowHeights = new int[]{0};
		gbl_panelCategoria.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelCategoria.rowWeights = new double[]{Double.MIN_VALUE};
		panelCategoria.setLayout(gbl_panelCategoria);
		
		btnAdicionar = new JButton("");
		btnAdicionar.setToolTipText("Adicionar quantidade");
		btnAdicionar.setActionCommand("adicionar");
		btnAdicionar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/plus.png")));
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdicionar.gridx = 0;
		gbc_btnAdicionar.gridy = 2;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);
		
		btnExluir = new JButton("");
		btnExluir.setToolTipText("Excluir Item");
		btnExluir.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/minus white.png")));
		btnExluir.setActionCommand("excluir");
		GridBagConstraints gbc_btnExluir = new GridBagConstraints();
		gbc_btnExluir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnExluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExluir.gridx = 1;
		gbc_btnExluir.gridy = 2;
		getContentPane().add(btnExluir, gbc_btnExluir);
		
		btnCalcularTotal = new JButton("");
		btnCalcularTotal.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/calculator.png")));
		btnCalcularTotal.setToolTipText("Calcular Total");
		btnCalcularTotal.setActionCommand("excluir");
		btnCalcularTotal.setActionCommand("calcular");
		GridBagConstraints gbc_btnCalcularTotal = new GridBagConstraints();
		gbc_btnCalcularTotal.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCalcularTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalcularTotal.gridx = 2;
		gbc_btnCalcularTotal.gridy = 2;
		getContentPane().add(btnCalcularTotal, gbc_btnCalcularTotal);
		
		btnConfirmar = new JButton("");
		btnConfirmar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/refresh.png")));
		btnConfirmar.setToolTipText("Processar Pedido");
		btnConfirmar.setActionCommand("confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmar.gridx = 3;
		gbc_btnConfirmar.gridy = 2;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);
		
		btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/print.png")));
		btnImprimir.setToolTipText("Imprimir");
		btnImprimir.setActionCommand("imprimir");
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimir.gridx = 4;
		gbc_btnImprimir.gridy = 2;
		getContentPane().add(btnImprimir, gbc_btnImprimir);
		
		btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(ViewMesaPedido.class.getResource("/img/PNG/stop.png")));
		btnCancelar.setToolTipText("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 5;
		gbc_btnCancelar.gridy = 2;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
		panelPedidos = new JPanel();
		panelPedidos.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panelPedidos = new GridBagConstraints();
		gbc_panelPedidos.fill = GridBagConstraints.BOTH;
		gbc_panelPedidos.insets = new Insets(0, 0, 0, 5);
		gbc_panelPedidos.gridheight = 2;
		gbc_panelPedidos.gridwidth = 6;
		gbc_panelPedidos.gridx = 0;
		gbc_panelPedidos.gridy = 3;
		getContentPane().add(panelPedidos, gbc_panelPedidos);
		panelPedidos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 12, 587, 340);
		panelPedidos.add(scrollPane);
		
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
		
		lblTotalGeral = new JLabel("Total Geral=");
		lblTotalGeral.setVisible(false);
		
		lblTotalGeral.setForeground(new Color(255, 255, 255));
		lblTotalGeral.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalGeral.setBounds(270, 364, 156, 25);
		panelPedidos.add(lblTotalGeral);
		
		 totalGeral = new JLabel("");
		 totalGeral.setForeground(new Color(255, 255, 255));
		 totalGeral.setFont(new Font("Dialog", Font.BOLD, 19));
		 totalGeral.setBounds(426, 368, 149, 21);
		 panelPedidos.add(totalGeral);
		 
		 txtTotal = new JTextField();
		 
		 JEditorPane dtrpnAvisos = new JEditorPane();
		 dtrpnAvisos.setFont(new Font("Dialog", Font.BOLD, 16));
		 dtrpnAvisos.setText("Adicionar Item(F1)  Excluir Item(F2)   Calcular Preço(F10)  \n\nFechar Mesa(F5)   Imprimir Factura(F11) Cancelar Pedido(F9)\n");
		 dtrpnAvisos.setBounds(12, 419, 557, 111);
		 panelPedidos.add(dtrpnAvisos);
		
		panelProduto = new JPanel();
		panelProduto.setBorder(new CompoundBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Produtos", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(51, 51, 51)), new MatteBorder(10, 12, 12, 10, (Color) new Color(122, 138, 153))));
		panelProduto.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelProduto = new GridBagConstraints();
		gbc_panelProduto.fill = GridBagConstraints.BOTH;
		gbc_panelProduto.gridx = 6;
		gbc_panelProduto.gridy = 4;
		getContentPane().add(panelProduto, gbc_panelProduto);

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
