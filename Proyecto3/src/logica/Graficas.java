package logica;

import java.util.*;

import javax.swing.JFrame;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import vista.InterfazReserva;

public class Graficas {
	public ArrayList<Integer> lista;
	public static XYChart chart;
	public String valor_precioreserva;
	public Integer valor_preciorestaurante;
	public HashMap<String, Integer> mapa=new HashMap<>();
	

	public void graficas_factura() {
		
        // Create the chart
        lista = CreadorFactura.valorfacturas;
        chart = new XYChartBuilder().width(800).height(700).title("Valor facturas").xAxisTitle("Factura").yAxisTitle("Valor").build();
        ArrayList<Integer> valores = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            valores.add(i + 1);
        }
        chart.addSeries("Valores", valores, lista);
        
        // Display the chart
        
        
        System.out.print(lista);
        new Thread(() -> {
            JFrame frame = new SwingWrapper(chart).displayChart();
            javax.swing.SwingUtilities.invokeLater(
                () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
            );
        }).start();


}
public void graficas_precio() {
		
        // Create the chart
		valor_precioreserva=InterfazReserva.preciografica;
		int valor_precioreserva_num=Integer.parseInt(valor_precioreserva);
		valor_preciorestaurante=CreadorFactura.valor_Restaurante;
		Map<String, Integer> datos=new LinkedHashMap<>();
		datos.put("Reserva", valor_precioreserva_num);
		datos.put("Restaurante", valor_preciorestaurante);
		PieChart chart=new PieChartBuilder().width(800).height(600).title("Relacion de valor de restaurante y reserva").build();
		datos.forEach((categoria, valor)->chart.addSeries(categoria, valor));
		
        new Thread(() -> {
            JFrame frame = new SwingWrapper(chart).displayChart();
            javax.swing.SwingUtilities.invokeLater(
                () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
            );
        }).start();


}
public void graficas_restuarante()
{
	
	mapa=CreadorFactura.servicios_restaurante;
	Set<String> key = mapa.keySet();
	Collection<Integer> values = mapa.values();
	List<Integer>values1=new ArrayList(values);
	List<String>keys1=new ArrayList(key);
	CategoryChart chart=new CategoryChartBuilder().width(800).height(700).title("Cantidad de pedidos por plato en restaurante").xAxisTitle("Plato").yAxisTitle("Cantidades").build();
	chart.addSeries("Valores", keys1, values1);
	chart.getStyler().setAxisTitleFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
	chart.getStyler().setAxisTickLabelsFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 6));
	new Thread(() -> {
        JFrame frame = new SwingWrapper(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
            () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );
    }).start();
	
}

public void graficas_restuarante_habitacion()
{
	
	mapa=CreadorFactura.servicios_restaurante_habitacion;
	Set<String> key = mapa.keySet();
	Collection<Integer> values = mapa.values();
	List<Integer>values1=new ArrayList(values);
	List<String>keys1=new ArrayList(key);
	CategoryChart chart=new CategoryChartBuilder().width(800).height(700).title("Cantidad de pedidos por plato en restaurante(habitacion)").xAxisTitle("Plato").yAxisTitle("Cantidades").build();
	chart.addSeries("Valores", keys1, values1);
	chart.getStyler().setAxisTitleFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
	chart.getStyler().setAxisTickLabelsFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
	new Thread(() -> {
        JFrame frame = new SwingWrapper(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
            () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );
    }).start();
	
}

public void graficas_restuarante_precio()
{
	
	mapa=CreadorFactura.servicios_restaurante_precio;
	Set<String> key = mapa.keySet();
	Collection<Integer> values = mapa.values();
	List<Integer>values1=new ArrayList(values);
	List<String>keys1=new ArrayList(key);
	CategoryChart chart=new CategoryChartBuilder().width(800).height(700).title("Precio de pedidos por plato en restaurante").xAxisTitle("Plato").yAxisTitle("Cantidades").build();
	chart.addSeries("Valores", keys1, values1);
	chart.getStyler().setAxisTitleFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
	chart.getStyler().setAxisTickLabelsFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 6));
	new Thread(() -> {
        JFrame frame = new SwingWrapper(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
            () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );
    }).start();
	
}

public void graficas_restuarante_habitacion_precio()
{
	
	mapa=CreadorFactura.servicios_restaurante_habitacion_precio;
	Set<String> key = mapa.keySet();
	Collection<Integer> values = mapa.values();
	List<Integer>values1=new ArrayList(values);
	List<String>keys1=new ArrayList(key);
	CategoryChart chart=new CategoryChartBuilder().width(800).height(700).title("Precio de pedidos por plato en restaurante(habitacion)").xAxisTitle("Plato").yAxisTitle("Cantidades").build();
	chart.addSeries("Valores", keys1, values1);
	chart.getStyler().setAxisTitleFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
	chart.getStyler().setAxisTickLabelsFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
	new Thread(() -> {
        JFrame frame = new SwingWrapper(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
            () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );
    }).start();
	
}
	
public void graficas_ingresos() {
	
    // Create the chart
	Integer ingresoshab = CreadorFactura.ingresos_restaurante_hab;
	Integer ingresosrest = CreadorFactura.ingresos_restaurante;
	
	
	Map<String, Integer> datos=new LinkedHashMap<>();
	datos.put("Ingresos por restaurante en habitacion", ingresoshab);
	datos.put("Ingresos por restaurante", ingresosrest);
	PieChart chart=new PieChartBuilder().width(800).height(600).title("Relacion entre ingresos por ordenes en habitacion y ordenes en restaurante").build();
	datos.forEach((categoria, valor)->chart.addSeries(categoria, valor));
	
    new Thread(() -> {
        JFrame frame = new SwingWrapper(chart).displayChart();
        javax.swing.SwingUtilities.invokeLater(
            () -> frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        );
    }).start();


}	
	
}