package com.forksystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

import com.alee.log.Log;
import com.forksystem.dao.IMesa;
import com.forksystem.dao.IReserva;
import com.forksystem.entities.Reserva;
import com.forksystem.models.TableModelPersonalizado;
import com.forksystem.ui.ViewReserva;
import com.forksystem.utils.Context;
import com.forksystem.utils.Utilitario;

public class ReservaController {

	public ViewReserva gui;
	private IMesa mesa = null;
	private IReserva reserva = null;
	public TableModelPersonalizado tabela;
	private Long idReserva = null;
	private String nomeMesa = null;

	public ReservaController(String m) {
		gui = new ViewReserva(m);
		setNomeMesa(m);
		mesa = Context.getInstace().getContexto().getBean(IMesa.class);
		reserva = Context.getInstace().getContexto().getBean(IReserva.class);
		verDados();
		gui.ouvinte(new OuvirObjecto(), gui.getBtnConfirmar());
		gui.ouvinte(new OuvirObjecto(), gui.getBtnCancelar());
	}

	public void verDados() {

		Reserva dados = reserva.findByMesa(mesa.findByNome(getNomeMesa()));
		if (null != dados) {
			gui.getTxtNom().setText(dados.getNome());
			gui.getTxtDocumento().setText(dados.getDocumento());
			gui.getTextHora().setText(Calendar.getInstance().toString());
			gui.getTxtNumeropessoa().setText(dados.getNumeroPessoas().toString());
			gui.getTxtTelefone().setText(dados.getTelefone().toString());
			gui.getTxtmesa().setText(dados.getMesa().getId().toString());
			gui.getBtnConfirmar().setText("Actualizar");
			setIdReserva(dados.getId());
		}

	}

	public void alerta(String m) {

		JOptionPane.showMessageDialog(null, m);
	}

	public Boolean verificarTodos() {
		Boolean t = false;
		if (new Utilitario(gui.getPanel()).verificarCampos()) {
			alerta("preencha os campos");
			t = true;
		}
		return t;
	}

	public void limparTodos() {
		new Utilitario(gui.getPanel()).limparTodos();

	}

	public void adicionar() {
		Reserva reserv = new Reserva();

		try {
			if (null != getIdReserva()) {
				reserv.setId(getIdReserva());
				System.out.println(getNomeMesa());
			}
			reserv.setNome(gui.getTxtNom().getText());
			reserv.setDocumento(gui.getTxtDocumento().getText());
			reserv.setHora(Calendar.getInstance());
			reserv.setNumeroPessoas(Integer.parseInt(gui.getTxtNumeropessoa().getText()));
			reserv.setTelefone(Integer.parseInt(gui.getTxtTelefone().getText()));
			reserv.setMesa(mesa.findByNome(getNomeMesa()));

			reserva.saveAndFlush(reserv);
			alerta("Operação realizada." + " O status muda logo que reabrires a janela de mesas");
			setIdReserva(reserv.getId());

		} catch (Exception e) {
			alerta("Erro ao fazer cadastro");
			Log.error("falha ao salvar" + e.getMessage());
		}

	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public String getNomeMesa() {
		return nomeMesa;
	}

	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa = nomeMesa;
	}

	public class OuvirObjecto implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "confirmar") {
				if (!verificarTodos()) {
					adicionar();
				}

			}

			if (e.getActionCommand() == "cancelar") {
				if (null == getIdReserva()) {
					alerta("Faça uma reserva");
				} else {
					reserva.delete(getIdReserva());
					alerta("Reserva Cancelada." + " O status muda logo que reabrires a janela de mesas");
					gui.dispose();

				}

			}

		}

	}

}
