package com.forksystem.ui;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBarOpcao extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, JButton> buttons;

	protected ActionListener listener;

	public ToolBarOpcao() {
		buttons = new HashMap<String, JButton>();
		defaultButons();
	}

	public Map<String, JButton> getButtons() {
		return buttons;
	}

	public ToolBarOpcao addButton(String text, String iconPath, String command) {
		JButton buton = buildButton(text, iconPath, command);
		buttons.put(text.toLowerCase(), buton);
		add(buton);
		setFloatable(true);
		return this;
	}

	private JButton buildButton(String text, String iconPath, String command) {
		JButton buton = new JButton();
		buton.setText(text);
		buton.setToolTipText(text);
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
		this.addButton("Produto", "/img/PNG/archive1.png", "produto")
				.addButton("Compras", "/img/PNG/compra.png", "compra")
				.addButton("Vendas", "/img/PNG/forward.png", "venda")
				.addButton("Caixa", "/img/PNG/cash.png", "caixa")
				.addButton("Mesa", "/img/PNG/cash.png", "mesa")
				.addButton("Clientes", "/img/PNG/folder.png", "cliente")
				.addButton("Fornecedores", "/img/PNG/fornecedor.png", "fornecedor")
				.addButton("Funcionarios", "/img/PNG/users.png", "funcionario")
				.addButton("Configurações", "/img/PNG/advanced.png", "config")
				.addButton("Backup", "/img/PNG/hd.png", "backup")
				.addButton("Importar Backup", "/img/PNG/install.png", "importar");
		
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
