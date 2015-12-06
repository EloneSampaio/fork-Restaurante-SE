package com.forksystem.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import net.sf.nachocalendar.CalendarFactory;
import net.sf.nachocalendar.components.DateField;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.forksystem.entities.Status;
import com.forksystem.entities.StatusConta;

public class ViewContasAReceber extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTable table;
	private JTextField textPesquisar;
	private DateField txtVencimento;
	private JComboBox cmbStatus;
	private BaseToolBar baseToolBar;
	private JPanel panelCadastro;
	private JLabel lblValorpago;
	private JLabel lblValorApagar;
	private JLabel lblVencidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContasAReceber frame = new ViewContasAReceber();
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
	public ViewContasAReceber() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setBounds(100, 100, 758, 665);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(357, 0, 32, 32);
		label.setIcon(new ImageIcon(ViewContasAReceber.class.getResource("/img/PNG/search.png")));
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().add(label);
		
		textPesquisar = new JTextField();
		textPesquisar.setBounds(394, 0, 356, 19);
		textPesquisar.setColumns(10);
		getContentPane().add(textPesquisar);
		
		JLabel lblTotalDeContas = new JLabel("Contas/Recebidas:");
		lblTotalDeContas.setBounds(12, 112, 157, 18);
		lblTotalDeContas.setForeground(Color.WHITE);
		lblTotalDeContas.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(lblTotalDeContas);
		
		JLabel lblTotalDeContas_1 = new JLabel("Contas/Pagar :");
		lblTotalDeContas_1.setBounds(276, 112, 135, 18);
		lblTotalDeContas_1.setForeground(Color.WHITE);
		lblTotalDeContas_1.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(lblTotalDeContas_1);
		
		JLabel lblTotalDeContas_2 = new JLabel("Contas/Vencidas");
		lblTotalDeContas_2.setBounds(508, 112, 146, 18);
		lblTotalDeContas_2.setForeground(new Color(255, 255, 255));
		lblTotalDeContas_2.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(lblTotalDeContas_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 168, 750, 189);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{751, 0};
		gbl_panel.rowHeights = new int[]{189, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		panelCadastro = new JPanel();
		panelCadastro.setBounds(0, 362, 750, 192);
		panelCadastro.setBackground(new Color(0, 128, 128));
		panelCadastro.setForeground(new Color(0, 0, 0));
		GridBagLayout gbl_panelCadastro = new GridBagLayout();
		gbl_panelCadastro.columnWidths = new int[]{185, 78, 25, 132, 114, 0};
		gbl_panelCadastro.rowHeights = new int[]{62, 19, 33, 17, 24, 0};
		gbl_panelCadastro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCadastro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCadastro.setLayout(gbl_panelCadastro);
		
		JLabel lblDescrioDaConta = new JLabel("Descrição");
		lblDescrioDaConta.setForeground(new Color(255, 255, 255));
		lblDescrioDaConta.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblDescrioDaConta = new GridBagConstraints();
		gbc_lblDescrioDaConta.anchor = GridBagConstraints.WEST;
		gbc_lblDescrioDaConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrioDaConta.gridx = 1;
		gbc_lblDescrioDaConta.gridy = 1;
		panelCadastro.add(lblDescrioDaConta, gbc_lblDescrioDaConta);
		
		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescricao.setColumns(10);
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridwidth = 3;
		gbc_txtDescricao.gridx = 2;
		gbc_txtDescricao.gridy = 1;
		panelCadastro.add(txtDescricao, gbc_txtDescricao);
		
		JLabel lblVencimento = new JLabel("Vencimento");
		lblVencimento.setForeground(new Color(255, 255, 255));
		lblVencimento.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblVencimento = new GridBagConstraints();
		gbc_lblVencimento.anchor = GridBagConstraints.NORTH;
		gbc_lblVencimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVencimento.insets = new Insets(0, 0, 5, 5);
		gbc_lblVencimento.gridwidth = 2;
		gbc_lblVencimento.gridx = 1;
		gbc_lblVencimento.gridy = 3;
		panelCadastro.add(lblVencimento, gbc_lblVencimento);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 3;
		gbc_lblStatus.gridy = 3;
		panelCadastro.add(lblStatus, gbc_lblStatus);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor.gridx = 4;
		gbc_lblValor.gridy = 3;
		panelCadastro.add(lblValor, gbc_lblValor);
		
		txtVencimento = CalendarFactory.createDateField();
		GridBagConstraints gbc_txtVencimento = new GridBagConstraints();
		gbc_txtVencimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVencimento.insets = new Insets(0, 0, 0, 5);
		gbc_txtVencimento.gridwidth = 2;
		gbc_txtVencimento.gridx = 1;
		gbc_txtVencimento.gridy = 4;
		panelCadastro.add(txtVencimento, gbc_txtVencimento);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(StatusConta.values()));
		GridBagConstraints gbc_cmbStatus = new GridBagConstraints();
		gbc_cmbStatus.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbStatus.insets = new Insets(0, 0, 0, 5);
		gbc_cmbStatus.gridx = 3;
		gbc_cmbStatus.gridy = 4;
		panelCadastro.add(cmbStatus, gbc_cmbStatus);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.anchor = GridBagConstraints.WEST;
		gbc_txtValor.gridx = 4;
		gbc_txtValor.gridy = 4;
		panelCadastro.add(txtValor, gbc_txtValor);
		getContentPane().add(panelCadastro);
		
		baseToolBar = new BaseToolBar();
		baseToolBar.setBounds(0, 559, 750, 67);
		getContentPane().add(baseToolBar);
		
		lblValorpago = new JLabel("");
		lblValorpago.setForeground(Color.WHITE);
		lblValorpago.setFont(new Font("Dialog", Font.BOLD, 15));
		lblValorpago.setBounds(181, 115, 83, 15);
		getContentPane().add(lblValorpago);
		
		lblValorApagar = new JLabel("");
		lblValorApagar.setFont(new Font("Dialog", Font.BOLD, 15));
		lblValorApagar.setForeground(Color.WHITE);
		lblValorApagar.setBounds(409, 114, 70, 15);
		getContentPane().add(lblValorApagar);
		
		lblVencidas = new JLabel("");
		lblVencidas.setForeground(Color.WHITE);
		lblVencidas.setFont(new Font("Dialog", Font.BOLD, 15));
		lblVencidas.setBounds(666, 112, 70, 15);
		getContentPane().add(lblVencidas);

	}
	
	public void addAction(ActionListener list) {
		
		for (String key : getBaseToolBar().getButtons().keySet()) {
			
			getBaseToolBar().getButtons().get(key).addActionListener(list);
		}
	}
	public JComboBox getCmbStatus() {
		return cmbStatus;
	}
	public JTextField getTxtValor() {
		return txtValor;
	}
	public DateField getTxtVencimento() {
		return txtVencimento;
	}
	public JTextField getTxtDescricao() {
		return txtDescricao;
	}
	public JTextField getTextPesquisar() {
		return textPesquisar;
	}
	public BaseToolBar getBaseToolBar() {
		return baseToolBar;
	}
	public JTable getTable() {
		return table;
	}
	public JPanel getPanelCadastro() {
		return panelCadastro;
	}
	

	public JLabel getLblValorpago() {
		return lblValorpago;
	}
	public JLabel getLblValorApagar() {
		return lblValorApagar;
	}
	public JLabel getLblVencidas() {
		return lblVencidas;
	}
}
