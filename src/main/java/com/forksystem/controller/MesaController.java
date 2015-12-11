package com.forksystem.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.forksystem.dao.IMesa;
import com.forksystem.dao.IPedido;
import com.forksystem.dao.IReserva;
import com.forksystem.entities.Mesa;
import com.forksystem.ui.ToolBarOpcao;
import com.forksystem.ui.ViewMesa;
import com.forksystem.ui.ViewMesaMenu;
import com.forksystem.ui.ViewPrincipal;
import com.forksystem.utils.Context;

public class MesaController {

	public ViewMesa gui = null;
	private IMesa mesa = null;
	private IReserva reserva = null;
	Map<String, JButton> buttons;

	JButton btn;
	String iconPath = "/img/mesa/mesaop.png";
	String iconPath1 = "/img/mesa/mesaof.png";

	public MesaController() {
		gui = new ViewMesa();
		mesa = Context.getInstace().getContexto().getBean(IMesa.class);
		reserva = Context.getInstace().getContexto().getBean(IReserva.class);
		buttons = new HashMap<String, JButton>();
		mostrar();
	}

	public void mostrar() {

		for (Mesa dados : mesa.findAll()) {
			
			 addButton(dados.getNome(), reserva.findByMesa(mesa.findOne(dados.getId())) != null? iconPath1: iconPath);
			
		}
		addAction(new OuvirBotoes());
		 

	}

	public void action(JButton bt, final String m) {

		bt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, m);

				ViewMesaMenu menu = new ViewMesaMenu(m);
				menu.setVisible(true);
				ViewPrincipal.getPainelDesktop().add(menu);
				try {
					menu.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
	
	public void addAction(ActionListener list) {
		
		for (String key : getButtons().keySet()) {
			
			getButtons().get(key).addActionListener(list);
		}
	}
	
	
	
	public void addButton(String text, String iconPath) {
		JButton buton = buildButton(text, iconPath);
		buttons.put(text.toLowerCase(), buton);
		gui.getPanelMesas().add(buton);
		gui.getPanelMesas().validate();
		
		
	}

	private JButton buildButton(String text, String iconPath) {
		JButton buton = new JButton();
		buton.setText(text);
		buton.setToolTipText(text);
		buton.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		buton.setHorizontalTextPosition(SwingConstants.CENTER);
		buton.setVerticalTextPosition(SwingConstants.BOTTOM);
		buton.setActionCommand(text);
		buton.setPreferredSize(new Dimension(150, 150));
		buton.setFont(new Font("arial", Font.PLAIN, 14));
		buton.setForeground(Color.white);
		return buton;

	}


	public void actualizarStatus() {

		gui.updateUI();
	}
	
	public Map<String, JButton> getButtons() {
		return buttons;
	}
	
	
	public class OuvirBotoes implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			ViewMesaMenu menu = new ViewMesaMenu(e.getActionCommand());
			menu.setVisible(true);
			ViewPrincipal.getPainelDesktop().add(menu);
			try {
				menu.setSelected(true);
			} catch (PropertyVetoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		
		
	}
}
