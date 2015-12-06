package com.forksystem.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.forksystem.dao.IMesa;
import com.forksystem.dao.IPedido;
import com.forksystem.dao.IReserva;
import com.forksystem.entities.Mesa;
import com.forksystem.ui.ViewMesa;
import com.forksystem.ui.ViewMesaMenu;
import com.forksystem.ui.ViewPrincipal;
import com.forksystem.utils.Context;

public class MesaController {

	public ViewMesa gui = null;
	private IMesa mesa = null;
	private IReserva reserva = null;

	JButton btn;
	String iconPath = "/img/mesa/mesaop.png";
	String iconPath1 = "/img/mesa/mesaof.png";

	public MesaController() {
		gui = new ViewMesa();
		mesa = Context.getInstace().getContexto().getBean(IMesa.class);
		reserva = Context.getInstace().getContexto().getBean(IReserva.class);
		mostrar();
	}

	public void mostrar() {

		for (Mesa dados : mesa.findAll()) {

			btn = new JButton();
			btn.setText(dados.getNome());

			if (reserva.findByMesa(mesa.findOne(dados.getId())) != null) {

				btn.setIcon(new ImageIcon(getClass().getResource(iconPath1)));

			} else {
				btn.setIcon(new ImageIcon(getClass().getResource(iconPath)));
			}

			btn.setFocusable(true);
			btn.setFont(new Font("dialog", Font.BOLD, 14));
			btn.setForeground(Color.WHITE);
			btn.setToolTipText(dados.getNome());
			btn.setPreferredSize(new Dimension(150, 150));
			gui.panelMesas.add(btn);
			action(btn, dados.getNome());

		}

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

	public void actualizarStatus() {

		gui.updateUI();
	}
}
