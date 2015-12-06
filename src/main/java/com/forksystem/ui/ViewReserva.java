package com.forksystem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class ViewReserva extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField txtNom;
	private JTextField txtDocumento;
	private JTextField txtTelefone;
	private JFormattedTextField textHora;
	private JTextField txtNumeropessoa;
	private JTextField txtmesa;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private MaskFormatter hora;

	public ViewReserva(String m) {
		setTitle("Reservando " + m);
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 626, 394);

		try {
			hora = new MaskFormatter("##:##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 259, 37, 350, 0 };
		gridBagLayout.rowHeights = new int[] { 266, 42, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 3;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(151, 65, 70, 15);
		panel.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setForeground(new Color(255, 255, 255));
		lblTelefone.setBounds(151, 124, 70, 15);
		panel.add(lblTelefone);
		JLabel lblNewLabel = new JLabel("Hora");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(151, 151, 70, 15);
		panel.add(lblNewLabel);

		JLabel lblNdoc = new JLabel("Nª/Doc");
		lblNdoc.setForeground(new Color(255, 255, 255));
		lblNdoc.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNdoc.setBounds(151, 97, 70, 15);
		panel.add(lblNdoc);

		JLabel lblMesa = new JLabel("Mesa");

		lblMesa.setFont(new Font("Dialog", Font.BOLD, 14));
		lblMesa.setForeground(new Color(255, 255, 255));
		lblMesa.setBounds(151, 207, 70, 15);
		panel.add(lblMesa);

		JLabel lblNpessoas = new JLabel("Nª/Pessoas");
		lblNpessoas.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNpessoas.setForeground(new Color(255, 255, 255));
		lblNpessoas.setBounds(139, 178, 92, 15);
		panel.add(lblNpessoas);

		txtNom = new JTextField();
		txtNom.setBounds(239, 63, 203, 19);
		panel.add(txtNom);
		txtNom.setColumns(10);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(239, 95, 203, 19);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(239, 122, 203, 19);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);

		textHora = new JFormattedTextField(hora);
		textHora.setBounds(239, 149, 58, 19);
		panel.add(textHora);
		textHora.setColumns(10);

		txtNumeropessoa = new JTextField();
		txtNumeropessoa.setBounds(239, 176, 114, 19);
		panel.add(txtNumeropessoa);
		txtNumeropessoa.setColumns(10);

		txtmesa = new JTextField();
		txtmesa.setText(m);
		txtmesa.setEnabled(false);
		txtmesa.setEditable(false);
		txtmesa.setBounds(239, 202, 81, 24);
		panel.add(txtmesa);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(0, 0, 0));
		btnConfirmar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnConfirmar.setIcon(new ImageIcon(ViewReserva.class.getResource("/img/PNG/refresh.png")));
		btnConfirmar.setActionCommand("confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 0;
		gbc_btnConfirmar.gridy = 1;
		getContentPane().add(btnConfirmar, gbc_btnConfirmar);

		btnCancelar = new JButton("Cancelar Reserva");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setIcon(new ImageIcon(ViewReserva.class.getResource("/img/PNG/stop.png")));
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnCancelar.setActionCommand("cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 1;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
	}

	public void ouvinte(ActionListener e, JButton b) {

		b.addActionListener(e);

	}

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JTextField getTextHora() {
		return textHora;
	}

	public JTextField getTxtNumeropessoa() {
		return txtNumeropessoa;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTxtmesa() {
		return txtmesa;
	}
}
