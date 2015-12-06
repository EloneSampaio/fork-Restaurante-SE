package com.forksystem.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import com.forksystem.entities.TipoPagamentos;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class ViewPagamento extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private JTextField textCliente;
	private JTextField textTotal;
	private JComboBox cmbFormaPagamento;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField textTotalPago;
	private JLabel lblValor;
	private JLabel label_1;
	private JTextField textDesconto;
	private JLabel lblTotal;
	private JLabel lblTotalgeral;

	/**
	 * Create the dialog.
	 */
	public ViewPagamento(String mesa) {
		setTitle(mesa);
		setBackground(new Color(0, 128, 128));
		setBounds(100, 100, 520, 318);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 518, 0 };
		gridBagLayout.rowHeights = new int[] { 209, 76, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		{
			{
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{70, 109, 25, 50, 16, 44, 152, 0};
				gbl_panel.rowHeights = new int[]{18, 24, 39, 18, 19, 41, 18, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel label = new JLabel("Cliente");
					label.setForeground(new Color(255, 255, 255));
					label.setFont(new Font("Dialog", Font.BOLD, 15));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.anchor = GridBagConstraints.NORTH;
					gbc_label.fill = GridBagConstraints.HORIZONTAL;
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridx = 1;
					gbc_label.gridy = 0;
					panel.add(label, gbc_label);
				}
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/PNG/search.png")));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.anchor = GridBagConstraints.SOUTHWEST;
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridheight = 2;
					gbc_label.gridx = 3;
					gbc_label.gridy = 0;
					panel.add(label, gbc_label);
				}
				{
					JLabel lblFormapagamento = new JLabel("Forma/Pagamento");
					lblFormapagamento.setForeground(new Color(255, 255, 255));
					lblFormapagamento.setFont(new Font("Dialog", Font.BOLD, 15));
					GridBagConstraints gbc_lblFormapagamento = new GridBagConstraints();
					gbc_lblFormapagamento.anchor = GridBagConstraints.NORTHWEST;
					gbc_lblFormapagamento.insets = new Insets(0, 0, 5, 0);
					gbc_lblFormapagamento.gridwidth = 3;
					gbc_lblFormapagamento.gridx = 4;
					gbc_lblFormapagamento.gridy = 0;
					panel.add(lblFormapagamento, gbc_lblFormapagamento);
				}
				{
					textCliente = new JTextField();
					textCliente.setEditable(false);
					textCliente.setColumns(10);
					GridBagConstraints gbc_textCliente = new GridBagConstraints();
					gbc_textCliente.anchor = GridBagConstraints.SOUTH;
					gbc_textCliente.fill = GridBagConstraints.HORIZONTAL;
					gbc_textCliente.insets = new Insets(0, 0, 5, 5);
					gbc_textCliente.gridwidth = 2;
					gbc_textCliente.gridx = 1;
					gbc_textCliente.gridy = 1;
					panel.add(textCliente, gbc_textCliente);
				}
				{
					cmbFormaPagamento = new JComboBox();
					cmbFormaPagamento.setModel(new DefaultComboBoxModel(TipoPagamentos.values()));
					GridBagConstraints gbc_cmbFormaPagamento = new GridBagConstraints();
					gbc_cmbFormaPagamento.anchor = GridBagConstraints.NORTHWEST;
					gbc_cmbFormaPagamento.insets = new Insets(0, 0, 5, 0);
					gbc_cmbFormaPagamento.gridwidth = 3;
					gbc_cmbFormaPagamento.gridx = 4;
					gbc_cmbFormaPagamento.gridy = 1;
					panel.add(cmbFormaPagamento, gbc_cmbFormaPagamento);
				}
				{
					JLabel label = new JLabel("Total");
					label.setForeground(new Color(255, 255, 255));
					label.setFont(new Font("Dialog", Font.BOLD, 15));
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.anchor = GridBagConstraints.NORTH;
					gbc_label.fill = GridBagConstraints.HORIZONTAL;
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridx = 1;
					gbc_label.gridy = 3;
					panel.add(label, gbc_label);
				}
				{
					label_1 = new JLabel("Desconto");
					label_1.setForeground(Color.WHITE);
					label_1.setFont(new Font("Dialog", Font.BOLD, 15));
					GridBagConstraints gbc_label_1 = new GridBagConstraints();
					gbc_label_1.anchor = GridBagConstraints.NORTH;
					gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_label_1.insets = new Insets(0, 0, 5, 5);
					gbc_label_1.gridwidth = 3;
					gbc_label_1.gridx = 2;
					gbc_label_1.gridy = 3;
					panel.add(label_1, gbc_label_1);
				}
				{
					lblValor = new JLabel("Valor a Pagar");
					lblValor.setForeground(new Color(255, 255, 255));
					lblValor.setFont(new Font("Dialog", Font.BOLD, 15));
					GridBagConstraints gbc_lblValor = new GridBagConstraints();
					gbc_lblValor.anchor = GridBagConstraints.NORTH;
					gbc_lblValor.fill = GridBagConstraints.HORIZONTAL;
					gbc_lblValor.insets = new Insets(0, 0, 5, 0);
					gbc_lblValor.gridx = 6;
					gbc_lblValor.gridy = 3;
					panel.add(lblValor, gbc_lblValor);
				}
				{
					textTotal = new JTextField();
					textTotal.setEditable(false);
					textTotal.setColumns(10);
					GridBagConstraints gbc_textTotal = new GridBagConstraints();
					gbc_textTotal.anchor = GridBagConstraints.NORTH;
					gbc_textTotal.fill = GridBagConstraints.HORIZONTAL;
					gbc_textTotal.insets = new Insets(0, 0, 5, 5);
					gbc_textTotal.gridx = 1;
					gbc_textTotal.gridy = 4;
					panel.add(textTotal, gbc_textTotal);
				}
				{
					textDesconto = new JTextField();
					textDesconto.setColumns(10);
					GridBagConstraints gbc_textDesconto = new GridBagConstraints();
					gbc_textDesconto.anchor = GridBagConstraints.NORTH;
					gbc_textDesconto.fill = GridBagConstraints.HORIZONTAL;
					gbc_textDesconto.insets = new Insets(0, 0, 5, 5);
					gbc_textDesconto.gridwidth = 2;
					gbc_textDesconto.gridx = 2;
					gbc_textDesconto.gridy = 4;
					panel.add(textDesconto, gbc_textDesconto);
				}
				{
					textTotalPago = new JTextField();
					textTotalPago.setEditable(false);
					textTotalPago.setColumns(10);
					GridBagConstraints gbc_textTotalPago = new GridBagConstraints();
					gbc_textTotalPago.anchor = GridBagConstraints.WEST;
					gbc_textTotalPago.fill=GridBagConstraints.HORIZONTAL;
					gbc_textTotalPago.insets = new Insets(0, 0, 5, 0);
					gbc_textTotalPago.gridwidth=2;
					gbc_textTotalPago.gridx = 5;
					gbc_textTotalPago.gridy = 4;
					panel.add(textTotalPago, gbc_textTotalPago);
				}
				lblTotalgeral = new JLabel("");
				lblTotalgeral.setVisible(false);
				lblTotal = new JLabel("Total=");
				lblTotal.setVisible(false);
				lblTotal.setForeground(new Color(255, 255, 255));
				lblTotal.setFont(new Font("Dialog", Font.BOLD, 15));
				GridBagConstraints gbc_lblTotal = new GridBagConstraints();
				gbc_lblTotal.anchor = GridBagConstraints.NORTH;
				gbc_lblTotal.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
				gbc_lblTotal.gridwidth = 2;
				gbc_lblTotal.gridx = 2;
				gbc_lblTotal.gridy = 6;
				panel.add(lblTotal, gbc_lblTotal);
				lblTotalgeral.setForeground(new Color(255, 255, 255));
				lblTotalgeral.setFont(new Font("Dialog", Font.BOLD, 15));
				GridBagConstraints gbc_lblTotalgeral = new GridBagConstraints();
				gbc_lblTotalgeral.fill = GridBagConstraints.BOTH;
				gbc_lblTotalgeral.gridwidth = 3;
				gbc_lblTotalgeral.gridx = 4;
				gbc_lblTotalgeral.gridy = 6;
				panel.add(lblTotalgeral, gbc_lblTotalgeral);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.fill = GridBagConstraints.BOTH;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			buttonPane.setLayout(null);
			{
				okButton = new JButton("Confirmar");
				okButton.setFont(new Font("Dialog", Font.BOLD, 15));
				okButton.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/PNG/refresh.png")));
				okButton.setBounds(108, 12, 160, 36);
				okButton.setActionCommand("confirmar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setFont(new Font("Dialog", Font.BOLD, 15));
				cancelButton.setIcon(new ImageIcon(ViewPagamento.class.getResource("/img/PNG/stop.png")));
				cancelButton.setBounds(280, 12, 149, 36);
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void ouvinte(ActionListener e, JButton b) {

		b.addActionListener(e);

	}

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getTextCliente() {
		return textCliente;
	}

	public JTextField textDesconto() {
		return textDesconto;
	}

	public JComboBox getCmbFormaPagamento() {
		return cmbFormaPagamento;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JTextField getTextTotal() {
		return textTotal;
	}

	public JTextField getTextTotalPago() {
		return textTotalPago;
	}

	public JTextField getTextDesconto() {
		return textDesconto;
	}

	public void setTextDesconto(JTextField textDesconto) {
		this.textDesconto = textDesconto;
	}

	public void setTextTotalPago(JTextField textTotalPago) {
		this.textTotalPago = textTotalPago;
	}

	public void setTextTotal(JTextField textTotal) {
		this.textTotal = textTotal;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}

	public JLabel getLblTotalgeral() {
		return lblTotalgeral;
	}
}
