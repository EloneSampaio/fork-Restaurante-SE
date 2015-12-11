package com.forksystem.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.forksystem.controller.TabelaDepartamentoController;
import javax.swing.JCheckBox;

public class ViewFuncionario extends JInternalFrame {
	
	
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

	private ButtonGroup jradioButoes;
	private JTextField txtPesquisar;
	private JPanel panelCadastro;
	private JLabel lblIcon;
	private JLabel labelNome;
	private JLabel lblCpf;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JLabel lblCidade_1;
	private JComboBox cmbCidade;
	private JTextField txtDepartamento;
	private JTextField textFuncao;
	private JTextField txtImagem;
	private JTextField txtcodigo;
	private JTextField textField_1;
	private JPasswordField pwdSenha;
	
	
	

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
	public ViewFuncionario() {
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setTitle("Cadastro/Funcionario");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 973, 637);
		
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
		
		jradioButoes = new ButtonGroup();
		getContentPane().setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(573, 0, 107, 32);
		lblPesquisar.setForeground(new Color(255, 255, 255));
		lblPesquisar.setIcon(new ImageIcon(ViewFuncionario.class.getResource("/img/PNG/search.png")));
		getContentPane().add(lblPesquisar);
		
		JTabbedPane tabbedPaneCadastro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastro.setBounds(0, 327, 960, 177);
		tabbedPaneCadastro.setBackground(new Color(0, 128, 128));
		tabbedPaneCadastro.setForeground(new Color(255, 255, 255));
		tabbedPaneCadastro.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(0, 128, 128));
		panelCadastro.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Dados Pessoas", null, panelCadastro, null);
		
		txtImagem = new JTextField();
		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(685, 6, 275, 19);
		txtPesquisar.setColumns(10);
		getContentPane().add(txtPesquisar);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(0, 37, 960, 285);
		panelLista.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 14));
		
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{},
				},
				new String[] {
				}
			));
			JScrollPane scrollPane = new JScrollPane(table);
			
				scrollPane.setHorizontalScrollBar(new JScrollBar(0));
				
				GroupLayout gl_panelLista = new GroupLayout(panelLista);
				gl_panelLista.setHorizontalGroup(
					gl_panelLista.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLista.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 931, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(15, Short.MAX_VALUE))
				);
				gl_panelLista.setVerticalGroup(
					gl_panelLista.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelLista.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
							.addContainerGap())
				);
				
				
				panelLista.setLayout(gl_panelLista);
				getContentPane().add(panelLista);
		panelCadastro.setLayout(null);
		
		lblIcon = new JLabel("");
		lblIcon.setBounds(12, 0, 102, 102);
		lblIcon.setIcon(new ImageIcon(ViewCliente.class.getResource("/img/funcionario.jpg")));
		panelCadastro.add(lblIcon);
		
		txtcodigo = new JTextField();
		JLabel lblTipo = new JLabel("Departamento");
		lblTipo.setBounds(490, 44, 147, 17);
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCadastro.add(lblTipo);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(609, 44, 95, 18);
		txtDepartamento.setFont(new Font("Dialog", Font.PLAIN, 11));
		panelCadastro.add(txtDepartamento);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(709, 44, 32, 32);
		lblImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TabelaDepartamentoController tb=new TabelaDepartamentoController(ViewFuncionario.this);
				tb.gui.setModal(true);
				tb.gui.setVisible(true);
			}
		});
		lblImg.setIcon(new ImageIcon(ViewFuncionario.class.getResource("/img/PNG/search.png")));
		panelCadastro.add(lblImg);
		labelNome = new JLabel("Nome");
		labelNome.setBounds(180, 44, 79, 17);
		labelNome.setForeground(new Color(255, 255, 255));
		labelNome.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCadastro.add(labelNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(277, 44, 201, 19);
		txtNome.setColumns(10);
		panelCadastro.add(txtNome);
		
		lblCpf = new JLabel("Doc/BI");
		lblCpf.setBounds(490, 91, 79, 17);
		lblCpf.setForeground(new Color(255, 255, 255));
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCadastro.add(lblCpf);
		
		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.setBounds(1, 106, 138, 30);
		btnEscolher.setFont(new Font("Dialog", Font.BOLD, 14));
		btnEscolher.setForeground(new Color(255, 255, 255));
		btnEscolher.setIcon(new ImageIcon(ViewFuncionario.class.getResource("/img/PNG/search.png")));
		btnEscolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser  fc=new JFileChooser();
				int res=fc.showOpenDialog(null);
				if (res==JFileChooser.APPROVE_OPTION) {
					String arquivo=fc.getSelectedFile().getAbsolutePath();
					ImageIcon icon = new ImageIcon(arquivo);  
					getLblIcon().setIcon(icon);
					getTxtImagem().setVisible(false);
					getTxtImagem().setText(arquivo);
				}

			}
		});
		
	
		
		txtCpf = new JFormattedTextField(cpf);
		txtCpf.setBounds(564, 90, 158, 19);
		txtCpf.setColumns(14);
		panelCadastro.add(txtCpf);
		
		JLabel lblFuno = new JLabel("Função");
		lblFuno.setBounds(180, 85, 79, 17);
		lblFuno.setForeground(new Color(255, 255, 255));
		lblFuno.setFont(new Font("Dialog", Font.BOLD, 14));
		panelCadastro.add(lblFuno);
		
		textFuncao = new JTextField();
		textFuncao.setBounds(287, 84, 191, 19);
		textFuncao.setColumns(10);
		panelCadastro.add(textFuncao);
		panelCadastro.add(btnEscolher);
		
		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(0, 128, 128));
		panelContacto.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Contacto", null, panelContacto, "Contacto");
		GridBagLayout gbl_panelContacto = new GridBagLayout();
		gbl_panelContacto.columnWidths = new int[]{170, 47, 70, 185, 0};
		gbl_panelContacto.rowHeights = new int[]{36, 30, 73, 0};
		gbl_panelContacto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelContacto.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelContacto.setLayout(gbl_panelContacto);
		
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
		gbc_lblTelefone.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTelefone.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefone.gridx = 2;
		gbc_lblTelefone.gridy = 2;
		panelContacto.add(lblTelefone, gbc_lblTelefone);
		
		textTelefone = new JFormattedTextField(telefone);
		textTelefone.setColumns(10);
		GridBagConstraints gbc_textTelefone = new GridBagConstraints();
		gbc_textTelefone.anchor = GridBagConstraints.NORTH;
		gbc_textTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefone.gridx = 3;
		gbc_textTelefone.gridy = 2;
		panelContacto.add(textTelefone, gbc_textTelefone);
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(new Color(0, 128, 128));
		panelEndereco.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		tabbedPaneCadastro.addTab("Endereço", null, panelEndereco, "Endereco");
		GridBagLayout gbl_panelEndereco = new GridBagLayout();
		gbl_panelEndereco.columnWidths = new int[]{203, 75, 185, 53, 72, 185, 0};
		gbl_panelEndereco.rowHeights = new int[]{71, 27, 46, 0};
		gbl_panelEndereco.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelEndereco.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEndereco.setLayout(gbl_panelEndereco);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEndereo.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
		gbc_lblEndereo.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndereo.gridx = 1;
		gbc_lblEndereo.gridy = 0;
		panelEndereco.add(lblEndereo, gbc_lblEndereo);
		
		textEndreco = new JTextField();
		textEndreco.setColumns(10);
		GridBagConstraints gbc_textEndreco = new GridBagConstraints();
		gbc_textEndreco.anchor = GridBagConstraints.SOUTH;
		gbc_textEndreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEndreco.insets = new Insets(0, 0, 5, 5);
		gbc_textEndreco.gridx = 2;
		gbc_textEndreco.gridy = 0;
		panelEndereco.add(textEndreco, gbc_textEndreco);
		
		JLabel Estado = new JLabel("Provincia");
		Estado.setFont(new Font("Dialog", Font.BOLD, 14));
		Estado.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_Estado = new GridBagConstraints();
		gbc_Estado.anchor = GridBagConstraints.SOUTHWEST;
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
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBairro.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblBairro = new GridBagConstraints();
		gbc_lblBairro.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblBairro.insets = new Insets(0, 0, 5, 5);
		gbc_lblBairro.gridx = 1;
		gbc_lblBairro.gridy = 1;
		panelEndereco.add(lblBairro, gbc_lblBairro);
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		GridBagConstraints gbc_textBairro = new GridBagConstraints();
		gbc_textBairro.anchor = GridBagConstraints.NORTH;
		gbc_textBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBairro.insets = new Insets(0, 0, 5, 5);
		gbc_textBairro.gridx = 2;
		gbc_textBairro.gridy = 1;
		panelEndereco.add(textBairro, gbc_textBairro);
		
		lblCidade_1 = new JLabel("Cidade");
		lblCidade_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCidade_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblCidade_1 = new GridBagConstraints();
		gbc_lblCidade_1.anchor = GridBagConstraints.NORTH;
		gbc_lblCidade_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCidade_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCidade_1.gridx = 4;
		gbc_lblCidade_1.gridy = 1;
		panelEndereco.add(lblCidade_1, gbc_lblCidade_1);
		
		cmbCidade = new JComboBox();
		cmbCidade.setModel(new DefaultComboBoxModel(new String[] {"Luanda", "São Luis", "São Paulo"}));
		GridBagConstraints gbc_cmbCidade = new GridBagConstraints();
		gbc_cmbCidade.anchor = GridBagConstraints.SOUTH;
		gbc_cmbCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCidade.insets = new Insets(0, 0, 5, 0);
		gbc_cmbCidade.gridx = 5;
		gbc_cmbCidade.gridy = 1;
		panelEndereco.add(cmbCidade, gbc_cmbCidade);
		getContentPane().add(tabbedPaneCadastro);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel.setBackground(new Color(0, 128, 128));
		tabbedPaneCadastro.addTab("Dados de Acesso", null, panel, null);
		
		JLabel label_3 = new JLabel("Nome");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(180, 44, 79, 17);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(277, 44, 201, 19);
		panel.add(textField_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBounds(180, 85, 79, 17);
		panel.add(lblSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("senha");
		pwdSenha.setBounds(277, 75, 201, 27);
		panel.add(pwdSenha);
		
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 537, 960, 67);
		getContentPane().add(baseToolBar);

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

	public void setarDepartamento(String valor){
		getTxtDepartamento().setText(valor);
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
	

	
	public JComboBox getCmbCidade() {
		return cmbCidade;
	}
	public JTextField getTextFuncao() {
		return textFuncao;
	}
	public JTextField getTxtDepartamento() {
		return txtDepartamento;
	}

	
	public JLabel getLblIcon() {
		return lblIcon;
	}
	public JTextField getTxtImagem() {
		return txtImagem;
	}
}
