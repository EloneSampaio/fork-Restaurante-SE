package com.forksystem.utils;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class GeradorDeGrafico extends JInternalFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart grafico;
	private Integer entradas;
	private Integer saidas;
	private Integer disponivel;
	

	public GeradorDeGrafico(String titulo,Integer entrada,Integer saida) {
		setEntradas(entrada);
		setSaidas(saida);
		setDisponivel(entradas-saidas);
		setIconifiable(true);
		setClosable(true);
		PieDataset dataset = createDataset();

		// com base no conjunto de dados que criamos o gráfico
		JFreeChart chart = createChart(dataset, titulo);

		// vamos colocar o gráfico em um painel
		ChartPanel chartPanel = new ChartPanel(chart);

		// default tamanho
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		// adiciona a nossa aplicação
				setContentPane(chartPanel);
				
	   }
	
	public void salva(OutputStream out) throws IOException {
	     ChartUtilities.writeChartAsPNG(out, grafico, 500, 350);
	   }
	

	
	/**
	 * Cria um conjunto de dados de amostra 
	 */

	private PieDataset createDataset() {
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Saidas", getSaidas());
		result.setValue("Entradas", getEntradas());
		result.setValue("Disponivel", getDisponivel());
		return result;

	}
	
	/**
	 * Cria um gráfico 
	 */

	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, // título / gráfico 
				dataset, // dados 
				true, // include lenda
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}

	public Integer getEntradas() {
		return entradas;
	}

	public void setEntradas(Integer entradas) {
		this.entradas = entradas;
	}

	public Integer getSaidas() {
		return saidas;
	}

	public void setSaidas(Integer saidas) {
		this.saidas = saidas;
	}

	public Integer getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Integer disponivel) {
		this.disponivel = disponivel;
	}
}

