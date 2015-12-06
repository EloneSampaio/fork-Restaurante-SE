package com.forksystem.ui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ViewEstoque extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel;
	private JTextField textId;
	private JLabel lblQuantidade;
	private JTextField txtQuantdade;
	private JTextField txtPesquisar;
	private JButton btnAdicionar;
	private JButton btnCancelar;

	

	/**
	 * Create the frame.
	 */
	public ViewEstoque() {
		getContentPane().setBackground(new Color(102, 153, 153));
		setTitle("Controle de Estoque");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 730, 409);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{330, 55, 334, 0};
		gridBagLayout.rowHeights = new int[]{287, 45, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(386, 0, 84, 32);
		lblBuscar.setForeground(new Color(255, 255, 255));
		lblBuscar.setIcon(new ImageIcon(ViewEstoque.class.getResource("/img/PNG/search.png")));
		panel.add(lblBuscar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(475, 6, 232, 19);
		panel.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 707, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(181, 244, 117, 17);
		lblQuantidade.setForeground(new Color(255, 255, 255));
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblQuantidade);
		
		txtQuantdade = new JTextField();
		txtQuantdade.setBounds(316, 244, 103, 19);
		txtQuantdade.setColumns(10);
		panel.add(txtQuantdade);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(ViewEstoque.class.getResource("/img/PNG/refresh.png")));
		btnAdicionar.setActionCommand("adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.EAST;
		gbc_btnAdicionar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 0;
		gbc_btnAdicionar.gridy = 1;
		getContentPane().add(btnAdicionar, gbc_btnAdicionar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(ViewEstoque.class.getResource("/img/PNG/stop.png")));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 1;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		textId=new JTextField();

	}
	
	public void ouvinte(ActionListener e, JButton b) {

		b.addActionListener(e);

	}
	
	
	public JTable getTable() {
		return table;
	}
	

	public JTextField getTextId() {
		return textId;
	}

	public void setTextId(JTextField textId) {
		this.textId = textId;
	}
	public JPanel getPanel() {
		return panel;
	}

	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	public JTextField getTxtQuantdade() {
		return txtQuantdade;
	}
	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
