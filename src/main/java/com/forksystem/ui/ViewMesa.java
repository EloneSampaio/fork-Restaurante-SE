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
import javax.swing.BorderFactory;
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
		setBounds(100, 100, 1200, 800);
			panelMesas = new JPanel();
			panelMesas.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			panelMesas.setBackground(new Color(0, 128, 128));
			panelMesas.setPreferredSize(new Dimension(800,600));
			panelMesas.setLayout(new FlowLayout(1));
			 final JScrollPane scroll = new JScrollPane(panelMesas);
			 setLayout(new BorderLayout());
			 add(scroll,BorderLayout.CENTER);
			 JScrollBar vertical = scroll.getVerticalScrollBar();  
			//Para rolar tudo para baixo:  
			vertical.setValue(vertical.getMaximum());  
			
			setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			
		
			
			
	}


	
	public JPanel getPanelMesas() {
		return panelMesas;
	}
}
