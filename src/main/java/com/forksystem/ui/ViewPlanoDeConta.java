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
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class ViewPlanoDeConta extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaseToolBar baseToolBar;
	private JTable table;
	private JPanel panel;
	private JTextField textId;
	private JLabel label;
	private JTextField textNome;

	

	/**
	 * Create the frame.
	 */
	public ViewPlanoDeConta() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Cadastro/Plano de conta a pagar");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 580, 373);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{568, 0};
		gridBagLayout.rowHeights = new int[]{266, 73, 0};
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 560, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("Nome");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(97, 227, 70, 15);
		panel.add(label);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(174, 225, 236, 19);
		panel.add(textNome);
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
	
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
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
	public JTextField getTextNome() {
		return textNome;
	}
}
