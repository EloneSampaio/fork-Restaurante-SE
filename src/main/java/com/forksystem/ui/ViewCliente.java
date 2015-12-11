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

import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

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

public class ViewCliente extends JInternalFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textEmail;
	private JFormattedTextField textTelefone;
	private JTextField textEndreco;
	private JTextField textBairro;
	private JComboBox cmbEstado;
	private JTable tabelaDeClientes;
	private JPanel panelContacto;
	private JPanel panelEndereco;
	private MaskFormatter data,codigo,telefone,celular,cpf;
	private BaseToolBar baseToolBar;

	private ButtonGroup jradioButoes;
	private JTextField txtPesquisar;
	private JPanel panelCadastro;
	private JLabel labelNome;
	private JLabel lblNascimento;
	private JLabel lblSexo;
	private DateField txtData;
	private JTextField txtNome;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JFormattedTextField txtCpf;
	private JLabel lblCidade_1;
	private JComboBox cmbCidade;
	private JRadioButton rdbtnOutro;
	private JTextField textCodigo;
	private JPanel panelEmpresas;
	private JLabel lblEmpresa;
	private JTextField txtEmpresa;
	private JLabel lblTelefoneDaEmpresa;
	private JTextField txtTelefoneempresa;
	private JLabel lblProfisso;
	private JTextField txtProfissoa;
	private JLabel lblTelefonecliente;
	private JTextField txtTelefonecliente;
	private JLabel lblRenda;
	private JTextField txtRenda;
	
	
	

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
	public ViewCliente() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setTitle("Cadastro/Clientes");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 1017, 745);
		
		JPanel panelLista = new JPanel();
		panelLista.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(null, 1, true), UIManager.getBorder("EditorPane.border")), "", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		baseToolBar = new BaseToolBar();
		
		JTabbedPane tabbedPaneCadastro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastro.setBackground(new Color(0, 128, 0));
		tabbedPaneCadastro.setFont(new Font("Dialog", Font.BOLD, 14));
		tabbedPaneCadastro.setForeground(new Color(255, 255, 255));
		
		panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(0, 128, 128));
		tabbedPaneCadastro.addTab("Dados Pessoas", null, panelCadastro, null);
		
		try {
			 data= new MaskFormatter("##/##/####");
			 cpf=new MaskFormatter("(###)###-####");
			 celular=new MaskFormatter("(###)###-####");
			 cpf=new MaskFormatter("###.####.####-##");
			 telefone=new MaskFormatter("(###)###-####");
			 
			 
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		labelNome = new JLabel("Nome");
		labelNome.setForeground(new Color(255, 255, 255));
		labelNome.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblNascimento = new JLabel("Nascimento");
		lblNascimento.setForeground(new Color(255, 255, 255));
		lblNascimento.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(255, 255, 255));
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 14));
		
		txtData = CalendarFactory.createDateField();
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		textCodigo=new JTextField();
		
		rdbtnMasculino = new JRadioButton("Homem");
		rdbtnMasculino.setForeground(new Color(255, 255, 255));
		rdbtnMasculino.setFont(new Font("Dialog", Font.BOLD, 14));
		
		rdbtnFemenino = new JRadioButton("Mulher");
		rdbtnFemenino.setForeground(new Color(255, 255, 255));
		rdbtnFemenino.setFont(new Font("Dialog", Font.BOLD, 14));
		
	
		
		txtCpf = new JFormattedTextField(cpf);
		txtCpf.setColumns(14);
		
		rdbtnOutro = new JRadioButton("Outro");
		rdbtnOutro.setForeground(new Color(255, 255, 255));
		rdbtnOutro.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblBi = new JLabel("BI");
		lblBi.setForeground(new Color(255, 255, 255));
		
		
		
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(232)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addComponent(labelNome)
						.addComponent(lblNascimento)
						.addComponent(lblSexo)
						.addComponent(lblBi, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(rdbtnMasculino)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnFemenino)
							.addGap(18)
							.addComponent(rdbtnOutro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
					.addGap(375))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNascimento)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSexo)
						.addComponent(rdbtnMasculino)
						.addComponent(rdbtnFemenino)
						.addComponent(rdbtnOutro))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBi))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(0, 128, 128));
		tabbedPaneCadastro.addTab("Contacto", null, panelContacto, "Contacto");
		
		JLabel labelEmail = new JLabel("E-Mail");
		labelEmail.setForeground(new Color(255, 255, 255));
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		
		textTelefone = new JFormattedTextField(telefone);
		textTelefone.setColumns(10);
		GroupLayout gl_panelContacto = new GroupLayout(panelContacto);
		gl_panelContacto.setHorizontalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addGap(265)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
						.addComponent(labelEmail)
						.addComponent(lblTelefone))
					.addGap(6)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addGap(472))
		);
		gl_panelContacto.setVerticalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addGap(2)
							.addComponent(labelEmail)
							.addGap(22)
							.addComponent(lblTelefone))
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(122))
		);
		panelContacto.setLayout(gl_panelContacto);
		
		panelEndereco = new JPanel();
		panelEndereco.setBackground(new Color(0, 128, 128));
		tabbedPaneCadastro.addTab("Endereço", null, panelEndereco, "Endereco");
		
		textEndreco = new JTextField();
		textEndreco.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(new Color(255, 255, 255));
		
		textBairro = new JTextField();
		textBairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setForeground(new Color(255, 255, 255));
		
		JLabel Estado = new JLabel("Provincia");
		Estado.setForeground(new Color(255, 255, 255));
		
		cmbEstado = new JComboBox();
		
		lblCidade_1 = new JLabel("Cidade");
		lblCidade_1.setForeground(new Color(255, 255, 255));
		
		cmbCidade = new JComboBox();
		GroupLayout gl_panelEndereco = new GroupLayout(panelEndereco);
		gl_panelEndereco.setHorizontalGroup(
			gl_panelEndereco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEndereco.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereo)
						.addComponent(lblBairro))
					.addGap(12)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addComponent(textEndreco, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(textBairro, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCidade_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(Estado))
					.addGap(40)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbCidade, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(210, Short.MAX_VALUE))
		);
		gl_panelEndereco.setVerticalGroup(
			gl_panelEndereco.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEndereco.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGap(2)
							.addComponent(lblEndereo)
							.addGap(22)
							.addComponent(lblBairro))
						.addGroup(gl_panelEndereco.createSequentialGroup()
							.addGroup(gl_panelEndereco.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelEndereco.createParallelGroup(Alignment.BASELINE)
									.addComponent(Estado)
									.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textEndreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelEndereco.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelEndereco.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblCidade_1)
									.addComponent(textBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		panelEndereco.setLayout(gl_panelEndereco);
		
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setForeground(new Color(255, 255, 255));
		lblPesquisar.setIcon(new ImageIcon(ViewCliente.class.getResource("/img/PNG/search.png")));
		
				
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(baseToolBar, GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPaneCadastro, GroupLayout.PREFERRED_SIZE, 983, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPesquisar)
					.addGap(32)
					.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(603, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblPesquisar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtPesquisar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(tabbedPaneCadastro, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(baseToolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		tabelaDeClientes = new JTable();
		tabelaDeClientes.setFont(new Font("Dialog", Font.PLAIN, 14));
	
		tabelaDeClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		JScrollPane scrollPane = new JScrollPane(tabelaDeClientes);
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		scrollPane.setHorizontalScrollBar(new JScrollBar(0));
		
		GroupLayout gl_panelLista = new GroupLayout(panelLista);
		gl_panelLista.setHorizontalGroup(
			gl_panelLista.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
		);
		gl_panelLista.setVerticalGroup(
			gl_panelLista.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
		);
		
		
		panelLista.setLayout(gl_panelLista);
		
		jradioButoes = new ButtonGroup();
		jradioButoes.add(rdbtnFemenino);
		jradioButoes.add(rdbtnMasculino);
        jradioButoes.add(rdbtnOutro);		
        
       
		
	
		getContentPane().setLayout(groupLayout);

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

	public DateField getTxtData() {
		return txtData;
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

	public JTable getTabelaDeClientes() {
		return tabelaDeClientes;
	}

	public void setTabelaDeClientes(JTable tabelaDeClientes) {
		this.tabelaDeClientes = tabelaDeClientes;
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
	public JRadioButton getRdbtnMasculino() {
		return rdbtnMasculino;
	}
	public JRadioButton getRdbtnFemenino() {
		return rdbtnFemenino;
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
	public JRadioButton getRdbtnOutro() {
		return rdbtnOutro;
	}



	public JTextField getTextCodigo() {
		return textCodigo;
	}

	public void setTextCodigo(JTextField textCodigo) {
		this.textCodigo = textCodigo;
	}
	public JTextField getTxtEmpresa() {
		return txtEmpresa;
	}
	public JTextField getTxtTelefoneempresa() {
		return txtTelefoneempresa;
	}
	public JTextField getTxtProfissoa() {
		return txtProfissoa;
	}
	public JTextField getTxtTelefonecliente() {
		return txtTelefonecliente;
	}
	public JTextField getTxtRenda() {
		return txtRenda;
	}
	public JPanel getPanelEmpresas() {
		return panelEmpresas;
	}
	public JComboBox getCmbCidade() {
		return cmbCidade;
	}
}
