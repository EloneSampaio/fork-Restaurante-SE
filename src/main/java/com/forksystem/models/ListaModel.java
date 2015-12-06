package com.forksystem.models;

import java.util.List;

import javax.swing.AbstractListModel;

public class ListaModel extends AbstractListModel<Object>{


	private List<Object> item;
	private static final long serialVersionUID = 1L;
	
	

	public ListaModel(List<Object> item) {
		super();
		this.item = item;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return item.size();
	}

	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return item.get(index);
	}

}
