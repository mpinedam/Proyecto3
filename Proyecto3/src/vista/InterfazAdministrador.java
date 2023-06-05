package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logica.Graficas;

@SuppressWarnings("serial")
public class InterfazAdministrador extends JFrame implements ActionListener{
	
	
	private static final String FUNCIONALIDAD = "FUNCIONALIDAD";
	private JComboBox<String> funcionalidad;
	public static Graficas graph=new Graficas();

	public  InterfazAdministrador()
	{
		
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		setTitle("Administrador");
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel selusu = new JLabel("Seleccione que desea realizar: ");
		add(selusu, BorderLayout.CENTER);
		
		String[] opcionesFuncionalidad = {"Cambiar Tarifa Habitaciones", "Cambiar Tarifa Servicios", "Visualizar Inventario","Reporte:valor factura", "Reporte:restaurante vs reservas", "Reporte: Cantidad de platos ordenados en restaurante", "Reporte: Cantidad de platos ordenados en restaurante para habitacion","Reporte: Precio de platos ordenados en restaurante", "Reporte: Precio de platos ordenados en restaurante para habitacion", "Reporte: Ingresos por ordenes en habitacion y ordenes en restaurante", "Visualizar Características del Hotel", "Visualizar Características de las Habitaciones"};
		funcionalidad = new JComboBox<String>(opcionesFuncionalidad); 
		funcionalidad.addActionListener(this);
		funcionalidad.setActionCommand(FUNCIONALIDAD);
		
		add(funcionalidad, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(FUNCIONALIDAD));
		Object funcionalidadele = funcionalidad.getSelectedItem();
		String seleccionado = funcionalidadele.toString();
		if (seleccionado == "Cambiar Tarifa Habitaciones") {
			new InterfazCambioTarifa();
			setVisible(false);
		}
		if (seleccionado == "Cambiar Tarifa Servicios") {
			new InterfazCambiarServicios();
			setVisible(false);
		}
		if (seleccionado == "Visualizar Inventario") {
			new InterfazVisualizarInventario();
			setVisible(false);
		}
		if (seleccionado=="Reporte:valor factura") {
			graph.graficas_factura();
			
		
		}
		if (seleccionado=="Reporte:restaurante vs reservas") {
			graph.graficas_precio();
			
		
		}
		if(seleccionado=="Reporte: Cantidad de platos ordenados en restaurante")
		{
			graph.graficas_restuarante();
			
		}
		if(seleccionado=="Reporte: Cantidad de platos ordenados en restaurante para habitacion")
		{
			graph.graficas_restuarante_habitacion();
			
		}
		if(seleccionado=="Reporte: Ingresos por ordenes en habitacion y ordenes en restaurante")
		{
			graph.graficas_ingresos();
		
		}
		if(seleccionado=="Reporte: Precio de platos ordenados en restaurante") {
			graph.graficas_restuarante_precio();
			
		}
		if(seleccionado=="Reporte: Precio de platos ordenados en restaurante para habitacion")
		{
			graph.graficas_restuarante_habitacion_precio();
			
		}
		
		if (seleccionado == "Visualizar Características del Hotel") {
			new InterfazInformacionHotel();
			setVisible(false);
		}
		
		else if (seleccionado == "Visualizar Características de las Habitaciones") {
			new InterfazInformacionCuartos();
			setVisible(false);
		}
		
		
			
		
	}

}