package com.forksystem.utils;

import java.awt.Component;
import java.awt.Container;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.alee.log.Log;

public class Utilitario {

	Boolean control;
	Container cont;
	
	
	public Utilitario() {
	       
		}
		
	public Utilitario(Container container) {
       cont=container;
	}
	
	public void limparTodos() {
		Component components[] = cont.getComponents();

		try {
			for (Component component : components) {
				if (component instanceof JTextField) {
					((JTextField) component).setText(null);
				}
			}

		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	
		
	}
	
	public int verificaIdade(Date date){
		Calendar dob = Calendar.getInstance();
		dob.setTime(date);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
		age--;
		return age;
	}
	
	public Boolean verificarCampos() {
		
		Component components[] = cont.getComponents();

		try {
			for (Component component : components) {
				if (component instanceof JTextField) {
					String value=((JTextField) component).getText();
					System.out.println(value);
					if (value.isEmpty()) {
						control=true;
					}
					else {
						control=false;
					}
					
				}
			}
		
		} catch (Exception e) {
		
		Log.error(e.getMessage());
		}
		
		
		return control;
	}
	
	
	public  BigDecimal parseBigdecimal(String str) {
		String normalized = str.replaceAll("\\s", "").replace(',', '.');
		return new BigDecimal(normalized);
	}
	public Calendar converterData(String valor) {
	
		DateFormat formatar;
		Date data;
		Calendar calendar = null;
		try {
			formatar=new SimpleDateFormat("dd/MM/yyyy");
			data=(Date)formatar.parse(valor);
			 calendar=Calendar.getInstance();
			calendar.setTime(data);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		return calendar;
	}
	
	public Calendar converterDataNacho(String valor) {
		 DateFormat dformat = DateFormat.getDateInstance(DateFormat.MEDIUM);  
		
		DateFormat formatar;
		Date data,dataNova;
		String fim;
		Calendar calendar = null;
		try {
			formatar=new SimpleDateFormat("dd/MM/yyyy");
			data=(Date)dformat.parse(valor);
			fim=formatar.format(data);
			dataNova=formatar.parse(fim);
			
			calendar=Calendar.getInstance();
			calendar.setTime(dataNova);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		return calendar;
	}
	
	
	public String formatarData(Date data,Boolean b) {
		if(!b){
		SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
		String d=formatado.format(data);
		return d;
	} else{
		SimpleDateFormat formatado = new SimpleDateFormat("dd MMM yyyy");
		String d=formatado.format(data);
		return d;
	}
		
	}
}
