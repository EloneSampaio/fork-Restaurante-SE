package com.forksystem.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ViewEmpresa extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtBairoo;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmpresa frame = new ViewEmpresa();
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
	public ViewEmpresa() {
		setBounds(100, 100, 894, 392);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{318, 312, 254, 0};
		gridBagLayout.rowHeights = new int[]{67, 275, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		BaseToolBar baseToolBar = new BaseToolBar();
		GridBagConstraints gbc_baseToolBar = new GridBagConstraints();
		gbc_baseToolBar.anchor = GridBagConstraints.NORTHEAST;
		gbc_baseToolBar.insets = new Insets(0, 0, 5, 5);
		gbc_baseToolBar.gridx = 0;
		gbc_baseToolBar.gridy = 0;
		getContentPane().add(baseToolBar, gbc_baseToolBar);
		
		JLabel lblCadastroDeEmpresa = new JLabel("Cadastro de Empresa");
		lblCadastroDeEmpresa.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lblCadastroDeEmpresa = new GridBagConstraints();
		gbc_lblCadastroDeEmpresa.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCadastroDeEmpresa.insets = new Insets(0, 0, 5, 0);
		gbc_lblCadastroDeEmpresa.gridx = 2;
		gbc_lblCadastroDeEmpresa.gridy = 0;
		getContentPane().add(lblCadastroDeEmpresa, gbc_lblCadastroDeEmpresa);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(102, 153, 153));
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setForeground(new Color(255, 255, 255));
		lblEmpresa.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setForeground(new Color(255, 255, 255));
		lblEndereo.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblBairoo = new JLabel("Bairro");
		lblBairoo.setForeground(new Color(255, 255, 255));
		lblBairoo.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(new Color(255, 255, 255));
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblEndereo_1 = new JLabel("Email");
		lblEndereo_1.setForeground(new Color(255, 255, 255));
		lblEndereo_1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		txtBairoo = new JTextField();
		txtBairoo.setText("bairoo");
		txtBairoo.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(114)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblEndereo_1)
									.addGap(47))
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblEndereo)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_3)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblBairoo)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtBairoo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblTelefone)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(35)
							.addComponent(lblCidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblEmpresa)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, 457, 457, 457)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmpresa)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairoo)
						.addComponent(lblCidade)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairoo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndereo))
					.addGap(31)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		GridBagConstraints gbc_panelCadastro = new GridBagConstraints();
		gbc_panelCadastro.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelCadastro.gridwidth = 3;
		gbc_panelCadastro.gridx = 0;
		gbc_panelCadastro.gridy = 1;
		getContentPane().add(panelCadastro, gbc_panelCadastro);

	}
}
