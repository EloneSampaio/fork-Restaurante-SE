package com.forksystem.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.forksystem.controller.TabelaFornecedorController;
import com.forksystem.controller.TabelaMarcaController;
import com.forksystem.entities.Cartao;
import com.forksystem.entities.Categoria;
import com.forksystem.entities.TipoPagamento;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ViewProduto extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtPrecoCompra;
	private JTextField txtVenda;
	private JTextField txtstoqueMinimo;
	private JTextField imagem;
	private BaseToolBar baseToolBar;
	private JTextField txtFornecedor;
	private JComboBox cmbCategoria;
	private JComboBox cmbUnidade;
	private JTextField txtMarca;
	private JButton arquivo_1;
	private JPanel panelCadastro;
	private JTextField txtPesquisar;
	private JScrollPane scrollPane;
	private JTextField txtDescricao;
	private JTable table;
	private JLabel lblBuscar;
	private JLabel label_2;
	private JTextField textId;
	private JLabel lblImagem;
	private JTextField textEstoque;
	private JLabel lblQtdestoque;

	

	/**
	 * Create the frame.
	 */
	public ViewProduto() {
		setTitle("Cadastro de produtos");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1022, 672);
		textId=new JTextField();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1013, 0};
		gridBagLayout.rowHeights = new int[]{247, 311, 79, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(0, 128, 128));
		
		txtNome = new JTextField();
		txtNome.setBounds(94, 41, 179, 19);
		txtNome.setColumns(10);
		cmbUnidade = new JComboBox();
		cmbUnidade.setBounds(375, 187, 87, 24);
		
		JLabel lblGerarEstoque = new JLabel("Gerar estoque");
		lblGerarEstoque.setBounds(94, 33136, 103, 15);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(229, 33136, 58, 15);
		
		JLabel label = new JLabel("Estoque");
		label.setBounds(529, 33138, 58, 15);
		
		JLabel lblEstoqueInicial = new JLabel("Critico");
		lblEstoqueInicial.setForeground(new Color(255, 255, 255));
		lblEstoqueInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEstoqueInicial.setBounds(94, 85, 126, 15);
		
		txtPrecoCompra = new JTextField();
		txtPrecoCompra.setBounds(94, 244, 87, 24);
		txtPrecoCompra.setText("0,00");
		txtPrecoCompra.setColumns(10);
		
		JLabel lblPreoDeCompra = new JLabel("Preço/Compra");
		lblPreoDeCompra.setForeground(new Color(255, 255, 255));
		lblPreoDeCompra.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreoDeCompra.setBounds(94, 223, 126, 15);
		
		JLabel lblPreoDeVenda = new JLabel("Preço /Venda");
		lblPreoDeVenda.setForeground(new Color(255, 255, 255));
		lblPreoDeVenda.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreoDeVenda.setBounds(247, 223, 126, 15);
		
		txtVenda = new JTextField();
		txtVenda.setBounds(247, 244, 87, 24);
		txtVenda.setText("0,00");
		txtVenda.setColumns(10);
		
		JLabel lblMarca = new JLabel("Cod Marca");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMarca.setBounds(247, 159, 106, 15);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setEditable(false);
		txtMarca.setBounds(247, 186, 61, 24);
		
		JLabel lblFornecedor = new JLabel("Cod Fornecedor");
		lblFornecedor.setForeground(new Color(255, 255, 255));
		lblFornecedor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFornecedor.setBounds(94, 164, 129, 15);
		lblFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setEnabled(false);
		txtFornecedor.setEditable(false);
		txtFornecedor.setBounds(94, 187, 70, 24);
		
		JLabel lblGrupo = new JLabel("Categoria");
		lblGrupo.setForeground(new Color(255, 255, 255));
		lblGrupo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGrupo.setBounds(375, 85, 87, 15);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setBounds(375, 108, 139, 23);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(94, 20, 70, 15);
		
		txtstoqueMinimo = new JTextField();
		txtstoqueMinimo.setBounds(94, 112, 103, 19);
		txtstoqueMinimo.setColumns(10);
		
	
		
		arquivo_1 = new JButton("Escolha");
		arquivo_1.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/zoom in.png")));
		arquivo_1.setBounds(706, 208, 137, 45);
		arquivo_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JFileChooser  fc=new JFileChooser();
				int res=fc.showOpenDialog(null);
				if (res==JFileChooser.APPROVE_OPTION) {
					String arquivo=fc.getSelectedFile().getAbsolutePath();
					ImageIcon icon = new ImageIcon(arquivo);  
					lblImagem.setIcon(icon);
						imagem.setText(arquivo);
				}

			}
		});
		
		imagem = new JTextField();
		imagem.setVisible(false);
		imagem.setEditable(false);
		imagem.setBounds(898, 207, 39, 19);
		imagem.setColumns(10);
		
		JLabel unidade = new JLabel("Unidade");
		unidade.setForeground(new Color(255, 255, 255));
		unidade.setFont(new Font("Dialog", Font.BOLD, 14));
		unidade.setBounds(375, 160, 87, 15);
		panelCadastro.setLayout(null);
		panelCadastro.add(lblEstoqueInicial);
		panelCadastro.add(txtstoqueMinimo);
		panelCadastro.add(arquivo_1);
		panelCadastro.add(imagem);
		panelCadastro.add(lblGerarEstoque);
		panelCadastro.add(lblEstoque);
		panelCadastro.add(label);
		panelCadastro.add(txtFornecedor);
		panelCadastro.add(lblFornecedor);
		panelCadastro.add(lblGrupo);
		panelCadastro.add(cmbCategoria);
		panelCadastro.add(txtMarca);
		panelCadastro.add(cmbUnidade);
		panelCadastro.add(lblMarca);
		panelCadastro.add(unidade);
		panelCadastro.add(txtNome);
		panelCadastro.add(lblNome);
		panelCadastro.add(lblPreoDeCompra);
		panelCadastro.add(txtPrecoCompra);
		panelCadastro.add(txtVenda);
		panelCadastro.add(lblPreoDeVenda);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setForeground(new Color(255, 255, 255));
		lblDescrio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDescrio.setBounds(303, 20, 103, 15);
		panelCadastro.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(302, 41, 266, 19);
		panelCadastro.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		lblBuscar = new JLabel("");
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabelaFornecedorController tb=new TabelaFornecedorController(ViewProduto.this);
				tb.gui.setModal(true);
				tb.gui.setVisible(true);
				
				
			}
		});
		lblBuscar.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/search.png")));
		lblBuscar.setBounds(171, 186, 39, 25);
		panelCadastro.add(lblBuscar);
		
		label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabelaMarcaController tb=new TabelaMarcaController(ViewProduto.this);
				tb.gui.setModal(true);
				tb.gui.setVisible(true);
				
			}
		});
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBackground(new Color(0, 128, 128));
		
		scrollPane = new JScrollPane(table);
		JLabel label_1 = new JLabel("Pesquisar");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/search.png")));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		GroupLayout gl_panelTabela = new GroupLayout(panelTabela);
		gl_panelTabela.setHorizontalGroup(
			gl_panelTabela.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTabela.createSequentialGroup()
					.addGroup(gl_panelTabela.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE))
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addGap(664)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelTabela.setVerticalGroup(
			gl_panelTabela.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabela.createSequentialGroup()
					.addGroup(gl_panelTabela.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addContainerGap(18, Short.MAX_VALUE)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addGap(14)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panelTabela.setLayout(gl_panelTabela);
		GridBagConstraints gbc_panelTabela = new GridBagConstraints();
		gbc_panelTabela.fill = GridBagConstraints.VERTICAL;
		gbc_panelTabela.insets = new Insets(0, 0, 5, 0);
		gbc_panelTabela.gridx = 0;
		gbc_panelTabela.gridy = 0;
		getContentPane().add(panelTabela, gbc_panelTabela);
		label_2.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/search.png")));
		label_2.setBounds(317, 186, 32, 25);
		panelCadastro.add(label_2);
		
		lblImagem = new JLabel("");
		lblImagem.setToolTipText("Imagem");
		lblImagem.setBounds(646, 20, 257, 170);
		panelCadastro.add(lblImagem);
		
		lblQtdestoque = new JLabel("Qtd/Estoque");
		lblQtdestoque.setForeground(new Color(255, 255, 255));
		lblQtdestoque.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQtdestoque.setBounds(247, 85, 126, 15);
		panelCadastro.add(lblQtdestoque);
		
		textEstoque = new JTextField();
		textEstoque.setColumns(10);
		textEstoque.setBounds(247, 112, 103, 19);
		panelCadastro.add(textEstoque);
		GridBagConstraints gbc_panelCadastro = new GridBagConstraints();
		gbc_panelCadastro.fill = GridBagConstraints.BOTH;
		gbc_panelCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_panelCadastro.gridx = 0;
		gbc_panelCadastro.gridy = 1;
		getContentPane().add(panelCadastro, gbc_panelCadastro);
		
		baseToolBar = new BaseToolBar();
		GridBagConstraints gbc_baseToolBar = new GridBagConstraints();
		gbc_baseToolBar.fill = GridBagConstraints.BOTH;
		gbc_baseToolBar.gridx = 0;
		gbc_baseToolBar.gridy = 2;
		getContentPane().add(baseToolBar, gbc_baseToolBar);

	}
	
	

	public void addAction(ActionListener list) {
		
		for (String key : getBaseToolBar().getButtons().keySet()) {
			
			getBaseToolBar().getButtons().get(key).addActionListener(list);
		}
	}
	
	public JTextField getImagem() {
		return imagem;
	}
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}
	
	
	
	public JComboBox getCmbCategoria() {
		return cmbCategoria;
	}
	public JTextField getTxtstoqueMinimo() {
		return txtstoqueMinimo;
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}
	
	public JTextField getTxtVenda() {
		return txtVenda;
	}
	public JTextField getTxtPrecoCompra() {
		return txtPrecoCompra;
	}
	public JComboBox getCmbUnidade() {
		return cmbUnidade;
	}
	
	public JButton getArquivo() {
		return arquivo_1;
	}
	public JPanel getPanelCadastro() {
		return panelCadastro;
	}
	public JTable getTable() {
		return table;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public void setarFornecedor(String valor){
		txtFornecedor.setText(valor);
	}
	
	public void setarMarca(String valor){
		txtMarca.setText(valor);
	}
	
	public JTextField getTxtFornecedor() {
		return txtFornecedor;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}


	public JTextField getTextId() {
		return textId;
	}


	public void setTextId(JTextField textId) {
		this.textId = textId;
	}
	public JTextField getTxtDescricao() {
		return txtDescricao;
	}
	public JLabel getLblImagem() {
		return lblImagem;
	}
	public JTextField getTextEstoque() {
		return textEstoque;
	}
	public JLabel getLblQtdestoque() {
		return lblQtdestoque;
	}
}
