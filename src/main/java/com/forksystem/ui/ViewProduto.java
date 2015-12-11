package com.forksystem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.forksystem.controller.TabelaFornecedorController;
import com.forksystem.controller.TabelaMarcaController;
import com.forksystem.utils.LerDocumento;

public class ViewProduto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtPrecoCompra;
	private JTextField txtVenda;
	private JTextField txtstoqueMinimo;
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
	private JTextField imagem;
	private JComboBox cmbCatgoria;

	

	/**
	 * Create the frame.
	 */
	public ViewProduto() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Cadastro de produtos");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1231, 721);
		textId=new JTextField();
		imagem = new JTextField();
		getContentPane().setLayout(null);
		
		JPanel panelTabela = new JPanel();
		panelTabela.setBounds(0, 0, 1218, 356);
		panelTabela.setBackground(new Color(0, 128, 128));
		
		scrollPane = new JScrollPane(table);
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar Por Nome");
		lblPesquisarPorNome.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPesquisarPorNome.setForeground(new Color(255, 255, 255));
		lblPesquisarPorNome.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/search.png")));
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		
		cmbCatgoria = new JComboBox();
		
		JLabel lblPesquisarPor = new JLabel("Filtrar Categoria");
		lblPesquisarPor.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPesquisarPor.setForeground(Color.WHITE);
		GroupLayout gl_panelTabela = new GroupLayout(panelTabela);
		gl_panelTabela.setHorizontalGroup(
			gl_panelTabela.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTabela.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTabela.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1194, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panelTabela.createSequentialGroup()
							.addComponent(lblPesquisarPorNome, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addGap(81))
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addComponent(lblPesquisarPor, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbCatgoria, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 628, Short.MAX_VALUE)
							.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(71))))
		);
		gl_panelTabela.setVerticalGroup(
			gl_panelTabela.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabela.createSequentialGroup()
					.addGap(5)
					.addComponent(lblPesquisarPorNome)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelTabela.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addGroup(gl_panelTabela.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPesquisarPor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(11))
						.addGroup(gl_panelTabela.createSequentialGroup()
							.addComponent(cmbCatgoria)
							.addGap(18)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		panelTabela.setLayout(gl_panelTabela);
		getContentPane().add(panelTabela);
		
		panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 361, 1218, 259);
		panelCadastro.setBackground(new Color(0, 128, 128));
		
		txtNome = new JTextField();
		txtNome.setBounds(118, 54, 179, 19);
		txtNome.setColumns(10);
		cmbUnidade = new JComboBox();
		cmbUnidade.setBounds(399, 196, 87, 24);
		
		JLabel lblGerarEstoque = new JLabel("Gerar estoque");
		lblGerarEstoque.setBounds(94, 33136, 103, 15);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(229, 33136, 58, 15);
		
		JLabel label = new JLabel("Estoque");
		label.setBounds(529, 33138, 58, 15);
		
		JLabel lblEstoqueInicial = new JLabel("Critico");
		lblEstoqueInicial.setForeground(new Color(255, 255, 255));
		lblEstoqueInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEstoqueInicial.setBounds(118, 98, 126, 15);
		
		txtPrecoCompra = new JTextField();
		txtPrecoCompra.setBounds(112, 304, 87, 24);
		txtPrecoCompra.setText("0,00");
		txtPrecoCompra.setColumns(10);
		
		JLabel lblPreoDeCompra = new JLabel("Preço/Compra");
		lblPreoDeCompra.setForeground(new Color(255, 255, 255));
		lblPreoDeCompra.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreoDeCompra.setBounds(112, 283, 126, 15);
		
		JLabel lblPreoDeVenda = new JLabel("Preço /Venda");
		lblPreoDeVenda.setForeground(new Color(255, 255, 255));
		lblPreoDeVenda.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPreoDeVenda.setBounds(265, 283, 126, 15);
		
		txtVenda = new JTextField();
		txtVenda.setBounds(265, 304, 87, 24);
		txtVenda.setText("0,00");
		txtVenda.setColumns(10);
		
		JLabel lblMarca = new JLabel("Cod Marca");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMarca.setBounds(271, 172, 106, 15);
		
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setEditable(false);
		txtMarca.setBounds(271, 199, 61, 24);
		
		JLabel lblFornecedor = new JLabel("Cod Fornecedor");
		lblFornecedor.setForeground(new Color(255, 255, 255));
		lblFornecedor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFornecedor.setBounds(118, 177, 129, 15);
		lblFornecedor.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setEnabled(false);
		txtFornecedor.setEditable(false);
		txtFornecedor.setBounds(118, 200, 70, 24);
		
		JLabel lblGrupo = new JLabel("Categoria");
		lblGrupo.setForeground(new Color(255, 255, 255));
		lblGrupo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGrupo.setBounds(422, 94, 87, 15);
		
		cmbCategoria = new JComboBox();
		cmbCategoria.setBounds(399, 121, 139, 23);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(118, 33, 70, 15);
		
		txtstoqueMinimo = new JTextField();
		txtstoqueMinimo.setBounds(118, 125, 103, 19);
		txtstoqueMinimo.setColumns(10);
		
	
		
		arquivo_1 = new JButton("Escolha");
		arquivo_1.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/zoom in.png")));
		arquivo_1.setBounds(675, 196, 126, 45);
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
		
		JLabel unidade = new JLabel("Unidade");
		unidade.setForeground(new Color(255, 255, 255));
		unidade.setFont(new Font("Dialog", Font.BOLD, 14));
		unidade.setBounds(399, 173, 87, 15);
		panelCadastro.setLayout(null);
		panelCadastro.add(lblEstoqueInicial);
		panelCadastro.add(txtstoqueMinimo);
		panelCadastro.add(arquivo_1);
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
		lblDescrio.setBounds(327, 33, 103, 15);
		panelCadastro.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(309, 54, 266, 19);
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
		lblBuscar.setBounds(195, 199, 39, 25);
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
		label_2.setIcon(new ImageIcon(ViewProduto.class.getResource("/img/PNG/search.png")));
		label_2.setBounds(341, 199, 32, 25);
		panelCadastro.add(label_2);
		
		lblImagem = new JLabel("");
		lblImagem.setToolTipText("Imagem");
		lblImagem.setBounds(615, 18, 257, 170);
		panelCadastro.add(lblImagem);
		
		lblQtdestoque = new JLabel("Qtd/Estoque");
		lblQtdestoque.setForeground(new Color(255, 255, 255));
		lblQtdestoque.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQtdestoque.setBounds(271, 98, 126, 15);
		panelCadastro.add(lblQtdestoque);
		
		textEstoque = new JTextField();
		textEstoque.setColumns(10);
		textEstoque.setBounds(271, 125, 103, 19);
		panelCadastro.add(textEstoque);
		getContentPane().add(panelCadastro);
		
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 625, 1218, 67);
		getContentPane().add(baseToolBar);

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
	public JComboBox getCmbCatgoria() {
		return cmbCatgoria;
	}
}
