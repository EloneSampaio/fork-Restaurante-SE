package com.forksystem.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ViewTipoPGT extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textDescricao;
	private JTextField textId;
	private JTable table;
	private BaseToolBar baseToolBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTipoPGT frame = new ViewTipoPGT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewTipoPGT() {
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastro/Tipos de Pagamento");
		setBounds(100, 100, 612, 384);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{600, 0};
		gridBagLayout.rowHeights = new int[]{282, 67, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(null);
		
		JLabel lblDescrioDoTipo = new JLabel("Descrição");
		lblDescrioDoTipo.setForeground(new Color(255, 255, 255));
		lblDescrioDoTipo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDescrioDoTipo.setBounds(80, 221, 99, 16);
		panel.add(lblDescrioDoTipo);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(186, 220, 177, 20);
		panel.add(textDescricao);
		textDescricao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 604, 185);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		baseToolBar = new BaseToolBar();
		GridBagConstraints gbc_baseToolBar = new GridBagConstraints();
		gbc_baseToolBar.fill = GridBagConstraints.BOTH;
		gbc_baseToolBar.gridx = 0;
		gbc_baseToolBar.gridy = 1;
		getContentPane().add(baseToolBar, gbc_baseToolBar);
		textId=new JTextField();

	}
	public void addAction(ActionListener list) {
		
		for (String key : getBaseToolBar().getButtons().keySet()) {
			
			getBaseToolBar().getButtons().get(key).addActionListener(list);
		}
	}
	public JPanel getPanel() {
		return panel;
	}
	
	public JTextField getTextDescricao() {
		return textDescricao;
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
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}
}
