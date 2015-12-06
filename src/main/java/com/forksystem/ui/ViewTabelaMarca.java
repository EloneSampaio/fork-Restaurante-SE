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

public class ViewTabelaMarca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewTabelaMarca dialog = new ViewTabelaMarca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewTabelaMarca() {
		setTitle("Lista de Marcas");
		setBounds(100, 100, 505, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 41, 495, 227);
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
	}
	

	public JTable getTable() {
		return table;
	}
	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}
