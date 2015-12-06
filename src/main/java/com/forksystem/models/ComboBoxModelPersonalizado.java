package com.forksystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

import com.forksystem.entities.Cidades;
import com.forksystem.entities.Venda;

public class ComboBoxModelPersonalizado extends AbstractListModel implements javax.swing.ComboBoxModel {

	private static final long serialVersionUID = 1L;

	private Object selectedItem;

	private ArrayList anArrayList;

	public ComboBoxModelPersonalizado(ArrayList dados) {
		this.anArrayList = dados;
	}

	public Object getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Object newValue) {
		selectedItem = newValue;
	}

	public int getSize() {
		return anArrayList.size();
	}

	public Object getElementAt(int i) {
		return anArrayList.get(i);
	}

	public ArrayList getAnArrayList() {
		return anArrayList;
	}

	public void setAnArrayList(ArrayList anArrayList) {
		this.anArrayList = anArrayList;
	}

}
