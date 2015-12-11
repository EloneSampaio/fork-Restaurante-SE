package com.forksystem.ui;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.forksystem.controller.ClienteController;
import com.forksystem.controller.FornecedorController;
import com.forksystem.controller.MesaController;
import com.forksystem.controller.ProdutoController;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JLabel;

public class ViewMenuBaixo extends JInternalFrame {
	private ToolBarOpcao toolBarOpcao;

	private static final long serialVersionUID = 1L;
	protected static JDesktopPane painelDesktop;
	private ClienteController cli;
	private ProdutoController prod;
	private FornecedorController fornecedor;
	private MesaController mesa=null;
	
	
	
	/**
	 * Create the frame.
	 */
	public ViewMenuBaixo() {
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(0, 128, 128));
		setResizable(true);
		setToolTipText("Menu de Acesso");
		setBorder(new MatteBorder(12, 10, 10, 12, (Color) new Color(255, 255, 255)));
			setTitle("Menu de Acesso Rapido");
		setBackground(Color.WHITE);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 928, 220);
				getContentPane().setLayout(null);
		
				toolBarOpcao = new ToolBarOpcao();
				toolBarOpcao.setBounds(0, 0, 916, 176);
				toolBarOpcao.setFont(new Font("Dialog", Font.BOLD, 14));
				toolBarOpcao.setToolTipText("Menu de Acesso");
				toolBarOpcao.setBackground(new Color(0, 128, 128));
				toolBarOpcao.setFloatable(true);
				getContentPane().add(toolBarOpcao);
		
		addAction(new TratarEventos());

	}

	public void addAction(ActionListener list) {

		for (String key : getToolBarOpcao().getButtons().keySet()) {

			getToolBarOpcao().getButtons().get(key).addActionListener(list);
		}
	}

	public ToolBarOpcao getToolBarOpcao() {
		return toolBarOpcao;
	}

	public void sair() {
		System.exit(0);
	}
	
	public class TratarEventos implements ActionListener {

		public void actionPerformed(ActionEvent e) {
//			if (e.getActionCommand().equals("produto")) {
//				if (prod == null) {
//					prod = new ProdutoController();
//					prod.gui.setVisible(true);
//					ViewPrincipal.getPainelDesktop().add(prod.gui);
//					} else {
//					prod.gui.setVisible(true);
//				}
//			}
//
//			if (e.getActionCommand().equals("mesa")) {
//				if (mesa == null) {
//					mesa = new MesaController();
//					mesa.gui.setVisible(true);
//					ViewPrincipal.getPainelDesktop().add(mesa.gui);
//				} else {
//					mesa.gui.setVisible(true);
//				}
//			}
//			
//			if (e.getActionCommand().equals("fornecedor")) {
//				if (fornecedor == null) {
//					fornecedor = new FornecedorController();
//					fornecedor.gui.setVisible(true);
//					ViewPrincipal.getPainelDesktop().add(fornecedor.gui);
//					} else {
//					fornecedor.gui.setVisible(true);
//				}
//			}
			
			
			
		

		}

	}
}
