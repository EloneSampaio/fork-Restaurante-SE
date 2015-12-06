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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ViewCategoria extends JInternalFrame {
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
	private JTextField textDescricao;
	private JLabel lblDescrio;
	private JLabel lblImagem;
	private JTextField txtImagem;
	


	/**
	 * Create the frame.
	 */
	public ViewCategoria() {
		setTitle("Cadastro/Categoria");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 779, 409);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 153, 153));
		panel.setBounds(0, 0, 769, 296);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 485, 205);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(93, 235, 156, 19);
		panel.add(textNome);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(355, 235, 170, 19);
		panel.add(textDescricao);
		
		lblDescrio = new JLabel("Descrição");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDescrio.setBounds(267, 235, 87, 15);
		panel.add(lblDescrio);
		
		JButton btnEscolhaAImagem = new JButton("Escolha a Imagem");
		btnEscolhaAImagem.setForeground(new Color(255, 255, 255));
		btnEscolhaAImagem.setIcon(new ImageIcon(ViewCategoria.class.getResource("/img/PNG/zoom in.png")));
		btnEscolhaAImagem.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEscolhaAImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser  fc=new JFileChooser();
				int res=fc.showOpenDialog(null);
				if (res==JFileChooser.APPROVE_OPTION) {
					String arquivo=fc.getSelectedFile().getAbsolutePath();
					ImageIcon icon = new ImageIcon(arquivo);  
					lblImagem.setIcon(icon);
					getTxtImagem().setText(arquivo);
				}

			}
		});
		btnEscolhaAImagem.setBounds(571, 223, 145, 35);
		panel.add(btnEscolhaAImagem);
		
		lblImagem = new JLabel("");
		lblImagem.setBounds(500, 12, 257, 170);
		panel.add(lblImagem);
		
		txtImagem = new JTextField();
		txtImagem.setEnabled(false);
		txtImagem.setEditable(false);
		txtImagem.setVisible(false);
		txtImagem.setBounds(584, 192, 78, 19);
		panel.add(txtImagem);
		txtImagem.setColumns(10);
		
		label = new JLabel("Nome");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(12, 237, 70, 15);
		panel.add(label);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		textId=new JTextField();
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 310, 769, 67);
		getContentPane().add(baseToolBar);

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
	public JTextField getTextDescricao() {
		return textDescricao;
	}
	public JLabel getLblImagem() {
		return lblImagem;
	}


	public JTextField getTxtImagem() {
		return txtImagem;
	}
}
