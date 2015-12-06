package com.forksystem.ui;

import javax.swing.JInternalFrame;

import com.forksystem.controller.MesaPedidoController;
import com.forksystem.controller.PagamentoController;
import com.forksystem.controller.ReservaController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class ViewMesaMenu extends JInternalFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewMesaMenu(final String mesa) {
		getContentPane().setBackground(new Color(51, 102, 153));
		setIconifiable(true);
		setClosable(true);
		setTitle(mesa+"/Menu");
		setBounds(100, 100, 562, 361);
		getContentPane().setLayout(null);

		JButton btnVerConta = new JButton("CONTA");
		btnVerConta.setForeground(new Color(255, 255, 255));
		btnVerConta.setBackground(new Color(255, 255, 255));
		btnVerConta.setEnabled(false);
		btnVerConta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnVerConta.setBounds(53, 42, 203, 97);
		getContentPane().add(btnVerConta);

		JButton btnPagamento = new JButton("PAGAMENTO");
		btnPagamento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PagamentoController pagamento=new PagamentoController(mesa);
				pagamento.gui.setVisible(true);
				
			}
		});
		btnPagamento.setForeground(new Color(255, 255, 255));
		btnPagamento.setBackground(new Color(255, 255, 255));
		btnPagamento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnPagamento.setBounds(300, 42, 203, 97);
		getContentPane().add(btnPagamento);

		JButton btnFazerReserva = new JButton("RESERVA");
		btnFazerReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReservaController reserva=new ReservaController(mesa);
				reserva.gui.setVisible(true);
				ViewPrincipal.getPainelDesktop().add(reserva.gui);
				try {
					reserva.gui.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFazerReserva.setForeground(new Color(255, 255, 255));
		btnFazerReserva.setBackground(new Color(255, 255, 255));
		btnFazerReserva.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnFazerReserva.setBounds(53, 154, 203, 97);
		getContentPane().add(btnFazerReserva);

		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.setForeground(new Color(255, 255, 255));
		btnAdicionarProduto.setBackground(new Color(255, 255, 255));
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MesaPedidoController pedido = new MesaPedidoController(mesa);
				pedido.gui.getLblMesa().setText(mesa);
				pedido.gui.setVisible(true);
				ViewPrincipal.getPainelDesktop().add(pedido.gui);
				try {
					pedido.gui.setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAdicionarProduto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnAdicionarProduto.setBounds(300, 154, 203, 97);
		getContentPane().add(btnAdicionarProduto);

	}

}
