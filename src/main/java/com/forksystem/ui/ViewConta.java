package com.forksystem.ui;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ViewConta extends JInternalFrame {
	private JTextField txtNome;
	private JTable table;
	private JPanel panel;
	private BaseToolBar baseToolBar;
	private JTextField textAgencia;
	private JLabel lblAgenciaDoBanco;
	private JLabel lblConta;
	private JTextField textConta;
	private JLabel lblGerente;
	private JTextField textGerente;
	private JLabel lblTelefone;
	private JTextField textTelefone;
	private JTextField txtPesquisar;
	private JLabel lblPesquisar;
	private JLabel label;
	private JTextField textEndereco;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewConta frame = new ViewConta();
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
	public ViewConta() {
		setIconifiable(true);
		setTitle("Cadastros/Contas Bancarias");
		setClosable(true);
		setBounds(100, 100, 874, 583);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 12, 862, 451);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 61, 862, 222);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome do Banco");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(68, 295, 133, 16);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(68, 325, 155, 20);
		panel.add(txtNome);
		txtNome.setColumns(14);
		
		textAgencia = new JTextField();
		textAgencia.setColumns(14);
		textAgencia.setBounds(256, 324, 197, 20);
		panel.add(textAgencia);
		
		lblAgenciaDoBanco = new JLabel("Agencia");
		lblAgenciaDoBanco.setForeground(new Color(255, 255, 255));
		lblAgenciaDoBanco.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAgenciaDoBanco.setBounds(256, 296, 100, 16);
		panel.add(lblAgenciaDoBanco);
		
		lblConta = new JLabel("Conta");
		lblConta.setForeground(new Color(255, 255, 255));
		lblConta.setFont(new Font("Dialog", Font.BOLD, 14));
		lblConta.setBounds(68, 357, 57, 16);
		panel.add(lblConta);
		
		textConta = new JTextField();
		textConta.setColumns(14);
		textConta.setBounds(68, 387, 155, 20);
		panel.add(textConta);
		
		lblGerente = new JLabel("Gerente");
		lblGerente.setForeground(new Color(255, 255, 255));
		lblGerente.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGerente.setBounds(465, 295, 110, 16);
		panel.add(lblGerente);
		
		textGerente = new JTextField();
		textGerente.setColumns(14);
		textGerente.setBounds(465, 325, 203, 20);
		panel.add(textGerente);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setBounds(256, 358, 100, 16);
		panel.add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(14);
		textTelefone.setBounds(256, 387, 155, 20);
		panel.add(textTelefone);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(599, 8, 257, 20);
		panel.add(txtPesquisar);
		
		lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setForeground(new Color(255, 255, 255));
		lblPesquisar.setIcon(new ImageIcon(ViewConta.class.getResource("/img/PNG/search.png")));
		lblPesquisar.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblPesquisar.setBounds(465, 3, 110, 29);
		panel.add(lblPesquisar);
		
		label = new JLabel("Endereço");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(423, 359, 86, 16);
		panel.add(label);
		
		textId = new JTextField();
		textEndereco = new JTextField();
		textEndereco.setColumns(14);
		textEndereco.setBounds(423, 387, 155, 20);
		panel.add(textEndereco);
		
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 483, 862, 68);
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
	public JPanel getPanel() {
		return panel;
	}
	public JTextField getTxtNome() {
		return txtNome;
	}
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	public JTextField getTextAgencia() {
		return textAgencia;
	}
	public JTextField getTextConta() {
		return textConta;
	}
	public JTextField getTextGerente() {
		return textGerente;
	}
	public JTextField getTextTelefone() {
		return textTelefone;
	}
	public JTextField getTextPesquisar() {
		return txtPesquisar;
	}
	
	public JTextField getTextEndereco() {
		return textEndereco;
	}
	public JTextField getTextId() {
		return textId;
	}
	
}
