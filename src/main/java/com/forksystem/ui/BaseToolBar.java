package com.forksystem.ui;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class BaseToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, JButton> buttons;

	protected ActionListener listener;

	public BaseToolBar() {
		buttons = new HashMap<String, JButton>();
		defaultButons();
	}

	public Map<String, JButton> getButtons() {
		return buttons;
	}

	public BaseToolBar addButton(String text, String iconPath, String command) {
		JButton buton = buildButton(text, iconPath, command);
		buttons.put(text.toLowerCase(), buton);
		add(buton);
		setFloatable(false);
		return this;
	}

	private JButton buildButton(String text, String iconPath, String command) {
		JButton buton = new JButton();
		buton.setText(text);
		buton.setIcon(new ImageIcon(getClass().getResource(iconPath)));
		buton.setHorizontalTextPosition(SwingConstants.CENTER);
		buton.setVerticalTextPosition(SwingConstants.BOTTOM);
		buton.setActionCommand(command);
		return buton;

	}

	// protected void defaultButons() {
	// Properties prop = getPropriedade();
	// this.addButton(prop.getProperty("prop.btn.novo"), "/img/novo.png",
	// "novo")
	// .addButton(prop.getProperty("prop.btn.guardar"), "/img/1230_1847_48.png",
	// "guardar")
	// .addButton(prop.getProperty("prop.btn.editar"), "/img/edit-icon.png",
	// "editar")
	// .addButton(prop.getProperty("prop.btn.apagar"), "/img/icon_excluir.jpg",
	// "apagar")
	// .addButton(prop.getProperty("prop.btn.cancelar"), "/img/cancel.jpg",
	// "cancelar");
	// }

	protected void defaultButons() {
		this.addButton("Novo", "/img/PNG/new doc.png", "novo").addButton("Guardar", "/img/PNG/plus.png", "guardar")
				.addButton("Editar", "/img/PNG/edit.png", "editar").addButton("Excluir", "/img/PNG/trash.png", "apagar")
				.addButton("Cancelar", "/img/PNG/stop 2.png", "cancelar");
	}

	public ActionListener getListener() {
		return listener;

	}

	public void setListener(ActionListener listener) {
		this.listener = listener;

	}

	// public Properties getPropriedade() {
	// try {
	//
	// Properties propriedades = new Properties();
	// FileInputStream file = new
	// FileInputStream("./src/main/java/dados.properties");
	// propriedades.load(file);
	// return propriedades;
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// return null;
	// }
	//
	// }

}
