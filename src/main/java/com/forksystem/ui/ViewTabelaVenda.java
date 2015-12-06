package com.forksystem.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ViewTabelaVenda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtPesquisar;
	private JButton btnVerDetalhes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewTabelaVenda dialog = new ViewTabelaVenda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewTabelaVenda() {
		setTitle("Lista de Produtos");
		setBounds(100, 100, 739, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 58, 727, 232);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JLabel lblBuscar = new JLabel("Buscar");
			lblBuscar.setBounds(224, 12, 70, 15);
			contentPanel.add(lblBuscar);
		}
		{
			txtPesquisar = new JTextField();
			txtPesquisar.setBounds(288, 10, 184, 19);
			contentPanel.add(txtPesquisar);
			txtPesquisar.setColumns(10);
		}
		
		btnVerDetalhes = new JButton("Ver detalhes");
		btnVerDetalhes.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVerDetalhes.setBounds(516, 319, 139, 40);
		contentPanel.add(btnVerDetalhes);
	}
	

	public JTable getTable() {
		return table;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
	public JButton getBtnVerDetalhes() {
		return btnVerDetalhes;
	}
}
