package com.forksystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.alee.log.Log;
import com.forksystem.dao.IMesa;
import com.forksystem.dao.IPagamento;
import com.forksystem.dao.IPedido;
import com.forksystem.dao.IReserva;
import com.forksystem.entities.Mesa;
import com.forksystem.entities.Pagamento;
import com.forksystem.entities.TipoPagamento;
import com.forksystem.entities.TipoPagamentos;
import com.forksystem.ui.ViewPagamento;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class PagamentoController {

	public ViewPagamento gui = null;
	private IPagamento pagamentoDao = null;
	private IPedido pedido = null;
	private IReserva reserva = null;
	private IMesa mesaDao = null;
	private String mesa = null;
	private Mesa mesaId=null;

	public PagamentoController(String mesa) {
		gui = new ViewPagamento(mesa);
		setMesa(mesa);
		pagamentoDao = Context.getInstace().getContexto().getBean(IPagamento.class);
		pedido = Context.getInstace().getContexto().getBean(IPedido.class);
		mesaDao = Context.getInstace().getContexto().getBean(IMesa.class);
		reserva = Context.getInstace().getContexto().getBean(IReserva.class);
		gui.ouvinte(new OuvirObjecto(), gui.getOkButton());
		gui.ouvinte(new OuvirObjecto(), gui.getCancelButton());
		preencherTotal();
		calcularDesconto();

	}

	/*
	 * metodo responsavel por setar o valor total do pedido
	 */
	public void preencherTotal() {

		setMesaId(mesaDao.findByNome(getMesa())) ;
		if(null!=reserva.findByMesa(getMesaId())){
		gui.getTextTotal().setText(pedido.findByMesa(getMesaId()).getValorTotal().toString());
		}else{
			alerta("Nenhuma conta a ser paga no momento");
			return ;
		}

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
	}

	public void verificarTodos() {

		if (new Utilitario(gui.getPanel()).verificarCampos()) {
			alerta("preencha os campos");

		}
	}

	public void limparTodos() {
		new Utilitario(gui.getPanel()).limparTodos();

	}

	private static BigDecimal parse(String str) {
		String normalized = str.replaceAll("\\s", "").replace(',', '.');
		return new BigDecimal(normalized);
	}

	public void adicionar() {
   
		try {
			Pagamento pagamento = new Pagamento();
			pagamento.setDataPagamento(Calendar.getInstance());
			pagamento.setEmissao(Calendar.getInstance());
			pagamento.setNumeroPagamento("000001");
			pagamento.setTipoPagamento((TipoPagamentos) gui.getCmbFormaPagamento().getSelectedItem());
			pagamento.setVlorPago(parse(gui.getTextTotalPago().getText()));
			if (gui.getTextDesconto().getText().isEmpty() || gui.getTextDesconto().getText().equals("0")) {
				pagamento.setVlorDoDesconto(0);
			} else {
				pagamento.setVlorDoDesconto(Integer.parseInt(gui.getTextDesconto().getText()));
			}
			
			if(pagamentoDao.save(pagamento) != null){
				reserva = Context.getInstace().getContexto().getBean(IReserva.class);
				reserva.delete(reserva.findByMesa(getMesaId()));
				
			}
			
			alerta("operação finalizada");
			

		} catch (Exception e) {
			alerta("Erro ao fazer operação");
			Log.error("falha ao salvar " + e.getMessage());
		}

	}

	public void calcularDesconto() {
		gui.getTextDesconto().addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				BigDecimal vlDesconto = null;
				BigDecimal percentagemGeral = null;
				BigDecimal total;
				total = new BigDecimal(gui.getTextTotal().getText());
				if (!gui.getTextDesconto().getText().isEmpty()) {
					vlDesconto = new BigDecimal(gui.getTextDesconto().getText());
					percentagemGeral = new BigDecimal("100");

				}
				if (!gui.getTextDesconto().getText().isEmpty() && !vlDesconto.equals(0)) {
					BigDecimal desconto = new BigDecimal(
							total.multiply(vlDesconto.divide(percentagemGeral)).toString());
					BigDecimal totalGeral = total.subtract(desconto).setScale(2, BigDecimal.ROUND_HALF_EVEN);
					gui.getTextTotalPago().setText(totalGeral.toString());
					String vl = NumberFormat.getCurrencyInstance().format(totalGeral);
					gui.getLblTotalgeral().setVisible(true);
					gui.getLblTotal().setVisible(true);
					gui.getLblTotalgeral().setText(vl);

				} else {
					gui.getTextTotalPago().setText(total.toString());
					String vl = NumberFormat.getCurrencyInstance().format(total);

					gui.getLblTotalgeral().setVisible(true);
					gui.getLblTotal().setVisible(true);
					gui.getLblTotalgeral().setText(vl);
				}

			}

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public Mesa getMesaId() {
		return mesaId;
	}

	public void setMesaId(Mesa mesaId) {
		this.mesaId = mesaId;
	}

	public class OuvirObjecto implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "confirmar") {
				verificarTodos();
				adicionar();
				limparTodos();
			}
			if (e.getActionCommand() == "Cancelar") {
				gui.dispose();
			}

		}
	}

}
