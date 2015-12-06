package com.forksystem.ui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;

import com.toedter.components.JSpinField;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ViewFornecedor extends JInternalFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JFormattedTextField textTelefone;
	private JTextField textEndreco;
	private JTextField textBairro;
	private JComboBox cmbEstado;
	private JTable table;
	private JPanel panelContacto;
	private JPanel panelEndereco;
	private MaskFormatter data,codigo,telefone,celular,cpf;
	private BaseToolBar baseToolBar;
	private JTextField txtcodigo;
	private ButtonGroup jradioButoes;
	private JTextField txtPesquisar;
	private JPanel panelCadastro;
	private JLabel labelNome;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JLabel lblCidade_1;
	private JComboBox cmbCidade;
	private JTextField txtSite;
	private JLabel lblCep;
	private JTextField txtCp;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCliente frame = new ViewCliente();
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
	public ViewFornecedor() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Cadastro/Fornecedores");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 973, 714);
		
		try {
			 data= new MaskFormatter("##/##/####");
			 cpf=new MaskFormatter("(###)###-####");
			 celular=new MaskFormatter("(###)###-####");
			 cpf=new MaskFormatter("###.####.####-##");
			 codigo=new MaskFormatter("###############");
			 telefone=new MaskFormatter("(###)###-####");
			 
			 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  txtcodigo=new JTextField();
		
		jradioButoes = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{660, 44, 272, 0};
		gridBagLayout.rowHeights = new int[]{32, 293, 257, 88, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setForeground(new Color(255, 255, 255));
		lblPesquisar.setIcon(new ImageIcon(ViewFornecedor.class.getResource("/img/PNG/search.png")));
		lblPesquisar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblPesquisar = new GridBagConstraints();
		gbc_lblPesquisar.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesquisar.gridx = 0;
		gbc_lblPesquisar.gridy = 0;
		getContentPane().add(lblPesquisar, gbc_lblPesquisar);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		GridBagConstraints gbc_txtPesquisar = new GridBagConstraints();
		gbc_txtPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_txtPesquisar.gridx = 2;
		gbc_txtPesquisar.gridy = 0;
		getContentPane().add(txtPesquisar, gbc_txtPesquisar);
		
		JPanel panelLista = new JPanel();
		panelLista.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GridBagConstraints gbc_panelLista = new GridBagConstraints();
		gbc_panelLista.fill = GridBagConstraints.BOTH;
		gbc_panelLista.insets = new Insets(0, 0, 5, 0);
		gbc_panelLista.gridwidth = 3;
		gbc_panelLista.gridx = 0;
		gbc_panelLista.gridy = 1;
		getContentPane().add(panelLista, gbc_panelLista);
		GridBagLayout gbl_panelLista = new GridBagLayout();
		gbl_panelLista.columnWidths = new int[]{941, 0};
		gbl_panelLista.rowHeights = new int[]{259, 0};
		gbl_panelLista.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLista.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelLista.setLayout(gbl_panelLista);
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
		
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{},
				},
				new String[] {
				}
			));
			JScrollPane scrollPane = new JScrollPane(table);
			
				scrollPane.setHorizontalScrollBar(new JScrollBar(0));
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panelLista.add(scrollPane, gbc_scrollPane);
		
		JTabbedPane tabbedPaneCadastro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastro.setForeground(new Color(255, 255, 255));
		tabbedPaneCadastro.setFont(new Font("Dialog", Font.BOLD, 15));
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(0, 128, 128));
		panelCadastro.setForeground(new Color(255, 255, 255));
		panelCadastro.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Dados Pessoas", null, panelCadastro, null);
		GridBagLayout gbl_panelCadastro = new GridBagLayout();
		gbl_panelCadastro.columnWidths = new int[]{102, 145, 61, 34, 216, 0};
		gbl_panelCadastro.rowHeights = new int[]{49, 40, 57, 0};
		gbl_panelCadastro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCadastro.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCadastro.setLayout(gbl_panelCadastro);
		labelNome = new JLabel("Nome");
		labelNome.setForeground(new Color(255, 255, 255));
		labelNome.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_labelNome = new GridBagConstraints();
		gbc_labelNome.anchor = GridBagConstraints.SOUTH;
		gbc_labelNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelNome.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome.gridx = 2;
		gbc_labelNome.gridy = 1;
		panelCadastro.add(labelNome, gbc_labelNome);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.anchor = GridBagConstraints.SOUTH;
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.gridx = 4;
		gbc_txtNome.gridy = 1;
		panelCadastro.add(txtNome, gbc_txtNome);
		
		JLabel lblBi = new JLabel("Doc/BI");
		lblBi.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBi.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBi = new GridBagConstraints();
		gbc_lblBi.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBi.insets = new Insets(0, 0, 0, 5);
		gbc_lblBi.gridx = 2;
		gbc_lblBi.gridy = 2;
		panelCadastro.add(lblBi, gbc_lblBi);
		
		txtCpf = new JFormattedTextField(cpf);
		txtCpf.setColumns(14);
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.anchor = GridBagConstraints.NORTH;
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.gridx = 4;
		gbc_txtCpf.gridy = 2;
		panelCadastro.add(txtCpf, gbc_txtCpf);
		
		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(0, 128, 128));
		panelContacto.setForeground(new Color(255, 255, 255));
		panelContacto.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Contacto", null, panelContacto, "Contacto");
		GridBagLayout gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[]{170, 53, 70, 185, 0};
		gbl_panelContacto.rowHeights = new int[]{36, 30, 21, 34, 0};
		gbl_panelContacto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelContacto.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelContacto.setLayout(gbl_panelContacto);
		
		JLabel labelContacto = new JLabel("");
		labelContacto.setIcon(new ImageIcon(ViewCliente.class.getResource("/img/images (1).jpg")));
		GridBagConstraints gbc_labelContacto = new GridBagConstraints();
		gbc_labelContacto.fill = GridBagConstraints.BOTH;
		gbc_labelContacto.insets = new Insets(0, 0, 0, 5);
		gbc_labelContacto.gridheight = 3;
		gbc_labelContacto.gridx = 0;
		gbc_labelContacto.gridy = 1;
		panelContacto.add(labelContacto, gbc_labelContacto);
		
		JLabel labelEmail = new JLabel("E-Mail");
		labelEmail.setForeground(new Color(255, 255, 255));
		labelEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.anchor = GridBagConstraints.SOUTHWEST;
		gbc_labelEmail.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmail.gridx = 2;
		gbc_labelEmail.gridy = 1;
		panelContacto.add(labelEmail, gbc_labelEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.anchor = GridBagConstraints.SOUTH;
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.gridx = 3;
		gbc_textEmail.gridy = 1;
		panelContacto.add(textEmail, gbc_textEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 2;
		gbc_lblTelefone.gridy = 2;
		panelContacto.add(lblTelefone, gbc_lblTelefone);
		
		textTelefone = new JFormattedTextField(telefone);
		textTelefone.setColumns(10);
		GridBagConstraints gbc_textTelefone = new GridBagConstraints();
		gbc_textTelefone.anchor = GridBagConstraints.NORTH;
		gbc_textTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_textTelefone.gridx = 3;
		gbc_textTelefone.gridy = 2;
		panelContacto.add(textTelefone, gbc_textTelefone);
		
		JLabel lblSite = new JLabel("Site");
		lblSite.setForeground(new Color(255, 255, 255));
		lblSite.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblSite = new GridBagConstraints();
		gbc_lblSite.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblSite.insets = new Insets(0, 0, 0, 5);
		gbc_lblSite.gridx = 2;
		gbc_lblSite.gridy = 3;
		panelContacto.add(lblSite, gbc_lblSite);
		
		txtSite = new JTextField();
		txtSite.setText("site");
		txtSite.setColumns(10);
		GridBagConstraints gbc_txtSite = new GridBagConstraints();
		gbc_txtSite.anchor = GridBagConstraints.NORTH;
		gbc_txtSite.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSite.gridx = 3;
		gbc_txtSite.gridy = 3;
		panelContacto.add(txtSite, gbc_txtSite);
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(new Color(0, 128, 128));
		panelEndereco.setForeground(new Color(255, 255, 255));
		panelEndereco.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Endereço", null, panelEndereco, "Endereco");
		GridBagLayout gbl_panelEndereco = new GridBagLayout();
		gbl_panelEndereco.columnWidths = new int[]{225, 51, 75, 180, 94, 185, 0};
		gbl_panelEndereco.rowHeights = new int[]{82, 26, 107, 0};
		gbl_panelEndereco.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEndereco.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEndereco.setLayout(gbl_panelEndereco);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ViewCliente.class.getResource("/img/images.png")));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridheight = 3;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panelEndereco.add(label_1, gbc_label_1);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(new Color(255, 255, 255));
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 2;
		gbc_lblEndereo.gridy = 0;
		panelEndereco.add(lblEndereo, gbc_lblEndereo);
		
		textEndreco = new JTextField();
		textEndreco.setColumns(10);
		GridBagConstraints gbc_textEndreco = new GridBagConstraints();
		gbc_textEndreco.anchor = GridBagConstraints.SOUTH;
		gbc_textEndreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEndreco.insets = new Insets(0, 0, 5, 5);
		gbc_textEndreco.gridx = 3;
		gbc_textEndreco.gridy = 0;
		panelEndereco.add(textEndreco, gbc_textEndreco);
		
		JLabel Estado = new JLabel("Provincia");
		Estado.setForeground(new Color(255, 255, 255));
		Estado.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_Estado = new GridBagConstraints();
		gbc_Estado.anchor = GridBagConstraints.SOUTH;
		gbc_Estado.fill = GridBagConstraints.HORIZONTAL;
		gbc_Estado.insets = new Insets(0, 0, 5, 5);
		gbc_Estado.gridx = 4;
		gbc_Estado.gridy = 0;
		panelEndereco.add(Estado, gbc_Estado);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Luanda", "Cabinda"}));
		GridBagConstraints gbc_cmbEstado = new GridBagConstraints();
		gbc_cmbEstado.anchor = GridBagConstraints.SOUTH;
		gbc_cmbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbEstado.insets = new Insets(0, 0, 5, 0);
		gbc_cmbEstado.gridx = 5;
		gbc_cmbEstado.gridy = 0;
		panelEndereco.add(cmbEstado, gbc_cmbEstado);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(255, 255, 255));
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 2;
		gbc_lblBairro.gridy = 1;
		panelEndereco.add(lblBairro, gbc_lblBairro);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		GridBagConstraints gbc_textBairro = new GridBagConstraints();
		gbc_textBairro.anchor = GridBagConstraints.SOUTH;
		gbc_textBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBairro.insets = new Insets(0, 0, 5, 5);
		gbc_textBairro.gridx = 3;
		gbc_textBairro.gridy = 1;
		panelEndereco.add(textBairro, gbc_textBairro);
		
		lblCidade_1 = new JLabel("Cidade");
		lblCidade_1.setForeground(new Color(255, 255, 255));
		lblCidade_1.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblCidade_1 = new GridBagConstraints();
		gbc_lblCidade_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCidade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade_1.gridx = 4;
		gbc_lblCidade_1.gridy = 1;
		panelEndereco.add(lblCidade_1, gbc_lblCidade_1);
		
		cmbCidade = new JComboBox();
		cmbCidade.setModel(new DefaultComboBoxModel(new String[] {"Luanda", "São Luis", "São Paulo"}));
		GridBagConstraints gbc_cmbCidade = new GridBagConstraints();
		gbc_cmbCidade.anchor = GridBagConstraints.NORTH;
		gbc_cmbCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCidade.insets = new Insets(0, 0, 5, 0);
		gbc_cmbCidade.gridx = 5;
		gbc_cmbCidade.gridy = 1;
		panelEndereco.add(cmbCidade, gbc_cmbCidade);
		
		lblCep = new JLabel("CEP");
		lblCep.setForeground(new Color(255, 255, 255));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblCep = new GridBagConstraints();
		gbc_lblCep.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCep.insets = new Insets(0, 0, 0, 5);
		gbc_lblCep.gridx = 2;
		gbc_lblCep.gridy = 2;
		panelEndereco.add(lblCep, gbc_lblCep);
		
		txtCp = new JTextField();
		txtCp.setColumns(10);
		GridBagConstraints gbc_txtCp = new GridBagConstraints();
		gbc_txtCp.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtCp.insets = new Insets(0, 0, 0, 5);
		gbc_txtCp.gridx = 3;
		gbc_txtCp.gridy = 2;
		panelEndereco.add(txtCp, gbc_txtCp);
		GridBagConstraints gbc_tabbedPaneCadastro = new GridBagConstraints();
		gbc_tabbedPaneCadastro.anchor = GridBagConstraints.NORTH;
		gbc_tabbedPaneCadastro.fill = GridBagConstraints.HORIZONTAL;
		gbc_tabbedPaneCadastro.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPaneCadastro.gridwidth = 3;
		gbc_tabbedPaneCadastro.gridx = 0;
		gbc_tabbedPaneCadastro.gridy = 2;
		getContentPane().add(tabbedPaneCadastro, gbc_tabbedPaneCadastro);
		
		baseToolBar = new BaseToolBar();
		GridBagConstraints gbc_baseToolBar = new GridBagConstraints();
		gbc_baseToolBar.fill = GridBagConstraints.BOTH;
		gbc_baseToolBar.gridwidth = 3;
		gbc_baseToolBar.gridx = 0;
		gbc_baseToolBar.gridy = 3;
		getContentPane().add(baseToolBar, gbc_baseToolBar);

	}
	

	public void addAction(ActionListener list) {
		
		for (String key : getBaseToolBar().getButtons().keySet()) {
			
			getBaseToolBar().getButtons().get(key).addActionListener(list);
		}
	}
	


	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	


	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	public JTextField getTextTelefone() {
		return textTelefone;
	}


	public void setTextEndreco(JTextField textEndreco) {
		this.textEndreco = textEndreco;
	}

	public JTextField getTextBairro() {
		return textBairro;
	}

	public void setTextBairro(JTextField textBairro) {
		this.textBairro = textBairro;
	}

		public JComboBox getCmbEstado() {
		return cmbEstado;
	}

	public void setCmbEstado(JComboBox cmbEstado) {
		this.cmbEstado = cmbEstado;
	}

	
	
	
	

	public JPanel getPanelCadastro() {
		return panelCadastro;
	}

	public void setPanelCadastro(JPanel panelCadastro) {
		this.panelCadastro = panelCadastro;
	}
	public JPanel getPanelContacto() {
		return panelContacto;
	}
	public JPanel getPanelEndereco() {
		return panelEndereco;
	}
	public JFormattedTextField getTextCpf() {
		return txtCpf;
	}
	public JTextField getTxtCodigo() {
		return txtcodigo;
	}

	public JTextField getTextEndreco() {
		return textEndreco;
	}
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}

	public ButtonGroup getJradioButoes() {
		return jradioButoes;
	}

	public void setJradioButoes(ButtonGroup jradioButoes) {
		this.jradioButoes = jradioButoes;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	
	public JTable getTable() {
		return table;
	}
	public JTextField getTxtSite() {
		return txtSite;
	}
	public JTextField getTxtCp() {
		return txtCp;
	}

	public JComboBox getCmbCidade() {
		return cmbCidade;
	}
}
