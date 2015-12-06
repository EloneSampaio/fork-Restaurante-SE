package com.forksystem.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.Scrollbar;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class ViewMesa extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panelMesas;


	public ViewMesa() {
		setTitle("Mesas");
		getContentPane().setForeground(new Color(255, 255, 255));
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 1327, 780);
			getContentPane().setLayout(new BorderLayout(0, 0));
			panelMesas = new JPanel();
			panelMesas.setBackground(new Color(0, 128, 128));
			panelMesas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(panelMesas);
			
			
			setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			
		
			
			
	}


	
	public JPanel getPanelMesas() {
		return panelMesas;
	}
}
