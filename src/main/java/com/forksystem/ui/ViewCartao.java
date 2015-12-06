package com.forksystem.ui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class ViewCartao extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textNome;
	private JTextField textTaxa;
	private BaseToolBar baseToolBar;
	private JPanel panel;
	private JTextField textId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCartao frame = new ViewCartao();
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
	public ViewCartao() {
		setBackground(new Color(102, 153, 153));
		setIconifiable(true);
		setClosable(true);
		setTitle("Cadastros/Cartões");
		setBounds(100, 100, 652, 485);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(102, 153, 153));
		panel.setBackground(new Color(102, 153, 153));
		panel.setBounds(0, 0, 642, 381);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 642, 194);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Nome do Cartão");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(89, 259, 133, 16);
		panel.add(lblNewLabel);
		
		textId=new JTextField();
		textNome = new JTextField();
		textNome.setBounds(222, 258, 198, 20);
		panel.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblTaxa = new JLabel("Taxa Cartão");
		lblTaxa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTaxa.setForeground(new Color(255, 255, 255));
		lblTaxa.setBounds(108, 298, 96, 16);
		panel.add(lblTaxa);
		
		textTaxa = new JTextField();
		textTaxa.setColumns(10);
		textTaxa.setBounds(222, 297, 88, 20);
		panel.add(textTaxa);
		
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 386, 642, 67);
		getContentPane().add(baseToolBar);

	}
	
	public void addAction(ActionListener list) {
		
		for (String key : getBaseToolBar().getButtons().keySet()) {
			
			getBaseToolBar().getButtons().get(key).addActionListener(list);
		}
	}
	public JTable getTable() {
		return table;
	}
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}
	public JTextField getTextTaxa() {
		return textTaxa;
	}
	public JTextField getTextNome() {
		return textNome;
	}
	public JPanel getPanel() {
		return panel;
	}
	public JTextField getTextId() {
		return textId;
	}

}
