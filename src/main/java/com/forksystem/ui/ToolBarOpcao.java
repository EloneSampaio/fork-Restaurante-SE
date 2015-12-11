package com.forksystem.ui;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.forksystem.utils.Config;

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

	protected void defaultButons() {
		Properties prop = Config.getPropriedade();
		System.out.println(prop);
		this.addButton(prop.getProperty("prop.btn.Produto"), "/img/PNG/archive1.png", "produto")
				.addButton(prop.getProperty("prop.btn.Compras"), "/img/PNG/compra.png", "compra")
				.addButton(prop.getProperty("prop.btn.Vendas"), "/img/PNG/forward.png", "venda")
				.addButton(prop.getProperty("prop.btn.Mesa"), "/img/PNG/cash.png", "mesa")
				.addButton(prop.getProperty("prop.btn.Fornecedores"), "/img/PNG/fornecedor.png", "fornecedor")
				.addButton(prop.getProperty("prop.btn.Usuario"), "/img/PNG/user.png", "Usuarios")

		.addButton(prop.getProperty("prop.btn.Config"), "/img/PNG/advanced.png", "config");

	}

	// protected void defaultButons() {
	// this.addButton("Produto", "/img/PNG/archive1.png", "produto")
	// .addButton("Compras", "/img/PNG/compra.png", "compra")
	// .addButton("Vendas", "/img/PNG/forward.png", "venda").addButton("Caixa",
	// "/img/PNG/cash.png", "caixa")
	// .addButton("Mesa", "/img/PNG/cash.png", "mesa").addButton("Clientes",
	// "/img/PNG/folder.png", "cliente")
	// .addButton("Fornecedores", "/img/PNG/fornecedor.png", "fornecedor")
	// .addButton("Funcionarios", "/img/PNG/users.png", "funcionario")
	// .addButton("Configurações", "/img/PNG/advanced.png", "config");
	//
	// }

	public ActionListener getListener() {
		return listener;

	}

	public void setListener(ActionListener listener) {
		this.listener = listener;

	}

}
