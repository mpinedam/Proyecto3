package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import consola.Aplicacion;
import logica.CreadorFactura;
import logica.GuiaTuristico;
import logica.Restaurante;
import logica.Spa;


public class InterfazServicios extends JFrame implements ActionListener{
	
	private JPanel panelWest;
	private JPanel panelEast;
	private JTextField texto_nombre;
	private JTextField texto_huesped;
	private JTextField texto_empleado;
	private JComboBox<String> opciones;
	private JButton boton_servicio;
	private JButton boton_eleccion;
	private JComboBox numeros;
	private int eleccion;
	private String huesped;
	private String empleado;
	private ArrayList<String> infoServicio;
	private String servicio_elegido;
	private JComboBox<String> opcionesFactura;
	private JButton home;
	private JButton huespedesBoton;
	private JButton boton_factura;
	
	public String lista;
	
	
	
	private static final String  texto= "Texto_Nombre";
	private static final String  texto_empleado1= "Texto_Empleado";
	private static final String texto_huesped1="Texto_Huesped";
	private static final String opciones1= "op";
	private static final String REALIZAR_CONSULTA="REALIZAR_CONSULTA";
	private static final String OPCIONES_SERVICIOS="OPCIONES_SERVICIOS";
	private static final String ELECCION_SERVICIO="ELECCION_SERVICIO";
	private static final String opcionesfactura="opcionesfactura";
	private static final String HOME="HOME";
	private static final String HUESPEDES="HUESPEDES";
	public InterfazServicios()
	{
		
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		
		setTitle("Sistema de Servicios");
		setSize(770, 770);
		setVisible(true);
		
		
		JPanel panelNorth=new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBackground(new Color(217,217,217));
		panelNorth.setPreferredSize(new Dimension(200,25));
		setVisible(true);
		
		JPanel panelSouth=new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(217,217,217));
		panelSouth.setPreferredSize(new Dimension(200,50));
		setVisible(true);
		
		home = new JButton("Volver al Inicio");
		home.addActionListener(this);
		home.setActionCommand(HOME);
		home.setPreferredSize(new Dimension(200,20));
		panelSouth.add(home);
			
		//Menuhuesped
		
		huespedesBoton = new JButton("Volver al Menu de huespedes");
		huespedesBoton.addActionListener(this);
		huespedesBoton.setActionCommand(HUESPEDES);
		huespedesBoton.setPreferredSize(new Dimension(200,20));
		panelSouth.add(huespedesBoton);
		
	
		
		panelWest=new JPanel();
		panelWest.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(new Color(96,137,175));
		panelWest.setPreferredSize(new Dimension(320,340));
		panelWest.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panelEast=new JPanel();
		panelEast.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(new Color(134, 197, 210));
		panelEast.setPreferredSize(new Dimension(350,340));
		panelEast.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		//PanelEast
		JPanel bloque=new JPanel();
		
		//panelEast.add(Box.createRigidArea(new Dimension(0,30)));
		
		JLabel factura=new JLabel("Consultar una factura");
		factura.setForeground(new Color(255,255,255));
		factura.setBackground(new Color(96,137,175));
		factura.setOpaque(true);
		panelEast.add(Box.createRigidArea(new Dimension(15,0)));
		factura.setAlignmentX(Component.CENTER_ALIGNMENT);
		factura.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(factura);
		
		bloque.setPreferredSize(new Dimension(20,0));
		panelEast.add(bloque);
		
		panelEast.add(new JLabel(""));
		JLabel a=new JLabel("Nombre asociado a reserva: ");
		a.setAlignmentX(Component.CENTER_ALIGNMENT);
		a.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(a, BorderLayout.AFTER_LINE_ENDS);
		setVisible(true);
	 
		texto_nombre=new JTextField();
		texto_nombre.setPreferredSize(new Dimension (120,30));
		texto_nombre.addActionListener(this);
		texto_nombre.setActionCommand(texto);
		texto_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_nombre.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(texto_nombre);
		setVisible(true);
		
		
		opcionesFactura=new JComboBox<String>();
		opcionesFactura.addItem("Acceder Factura");
		opcionesFactura.addItem("Finalizar Factura");
		panelEast.add(opcionesFactura);
		setVisible(true);
		
		
		
		boton_factura=new JButton("Consulta");
		boton_factura.setForeground(new Color(88,135,179));
		boton_factura.addActionListener(this);
		boton_factura.setActionCommand(REALIZAR_CONSULTA);
		boton_factura.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_factura.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(boton_factura);
		setVisible(true);
		
		//PanelWest
		JLabel servicio=new JLabel("Adquirir Servicio");
		servicio.setForeground(new Color(255,255,255));
		servicio.setBackground(new Color(97,110,160));
		servicio.setOpaque(true);
		
		servicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		servicio.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(servicio);
		JPanel bloque1=new JPanel();
		bloque1.setPreferredSize(new Dimension(300,0));
		panelWest.add(bloque1);
		
		
	
		JLabel b=new JLabel("Nombre Huesped: ");
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(b, BorderLayout.AFTER_LAST_LINE);
		setVisible(true);
		
		texto_huesped=new JTextField();
		texto_huesped.setPreferredSize(new Dimension (120,30));
		texto_huesped.addActionListener(this);
		texto_huesped.setActionCommand(texto_huesped1);
		texto_huesped.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_huesped.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(texto_huesped);
		setVisible(true);
		
		JLabel c=new JLabel("Nombre Empleado: ");
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(c, BorderLayout.AFTER_LAST_LINE);
		setVisible(true);
		
		texto_empleado=new JTextField();
		texto_empleado.setPreferredSize(new Dimension (120,30));
		texto_empleado.addActionListener(this);
		texto_empleado.setActionCommand(texto_empleado1);
		texto_empleado.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_empleado.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(texto_empleado);
		setVisible(true);
		
		String[] opcionesServicios = {"Restaurante Habitacion", "Restaurante", "Spa", "Guia Turistico"};
		opciones = new JComboBox<String>(opcionesServicios); 
		opciones.addActionListener(this);
		opciones.setActionCommand(opciones1);
		panelWest.add(opciones);
		setVisible(true);
		
		boton_servicio=new JButton("Consulta");
		boton_servicio.setForeground(new Color(88,135,179));
		boton_servicio.addActionListener(this);
		boton_servicio.setActionCommand(OPCIONES_SERVICIOS);
		boton_servicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_servicio.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(boton_servicio);
		setVisible(true);
		
		
		
	

	    
	}
	
	
public ArrayList<String> Servicio() {
		infoServicio = new ArrayList<String>();
		String nombreHuesped=texto_huesped.getText();
		String nombreEmpleado=texto_empleado.getText();
		infoServicio.add(nombreHuesped);
		infoServicio.add(nombreEmpleado);
		String servicio_solicitado=opciones.getSelectedItem().toString();
		
		numeros=new JComboBox();
		
		
		String lista_restaurante="";
		if (servicio_solicitado=="Restaurante")
		{
			Object keys = Restaurante.mostrarPlato_restaurante().get(0);
			String keysString=keys.toString();
			String keysStringF = keysString.substring(1, keysString.length()-1);
		
			String[] arraykeys=keysStringF.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			
	
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 350));
			
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_servicios.setFont(fuente);
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			infoServicio.addAll(listkeys);
	
			eleccion=3;
			setVisible(true);
			
			
		}
		else if (servicio_solicitado=="Restaurante Habitacion")
		{
			Object keys = Restaurante.mostrarPlato_habitacion().get(0);
			String keysString=keys.toString();
			String keysStringF = keysString.substring(1, keysString.length()-1);
			
			String[] arraykeys=keysStringF.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
		
			
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 120));
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_servicios.setFont(fuente);
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			infoServicio.addAll(listkeys);
			eleccion=2;
			setVisible(true);
				
		}
		else if (servicio_solicitado=="Spa")
		{
			Object keys = Spa.mostrarMasaje().get(0);
			String keysString=keys.toString();
			String keysStringF = keysString.substring(1, keysString.length()-1);
			
			String[] arraykeys=keysStringF.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 200));
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_servicios.setFont(fuente);
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			infoServicio.addAll(listkeys);
			eleccion=4;
			setVisible(true);
		
			
		}
		else if (servicio_solicitado=="Guia Turistico")
		{
			Object keys = GuiaTuristico.mostrarPlan().get(0);
			String keysString=keys.toString();
			String keysStringF = keysString.substring(1, keysString.length()-1);
			
			String[] arraykeys=keysStringF.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 200));
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_servicios.setFont(fuente);
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			infoServicio.addAll(listkeys);
			eleccion=1;
			setVisible(true);
		
			
		}
		boton_eleccion=new JButton("Elegir");
		boton_eleccion.setForeground(new Color(88,135,179));
		boton_eleccion.addActionListener(this);
		boton_eleccion.setActionCommand(ELECCION_SERVICIO);
		boton_eleccion.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_eleccion.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(boton_eleccion);
		setVisible(true);
		boton_servicio.setEnabled(false);
		
		return infoServicio;
	}
	
public String nuevoPedido() {
	String opcion_servicio_solicitado=numeros.getSelectedItem().toString();
	int opcion_servicio_solicitado_num = Integer.parseInt(opcion_servicio_solicitado);
	System.out.println(opcion_servicio_solicitado);
	huesped=infoServicio.get(0);
	empleado=infoServicio.get(1);
	servicio_elegido = infoServicio.get(1+opcion_servicio_solicitado_num);
	servicio_elegido=servicio_elegido.trim();
	CreadorFactura.asociarloUsuario(huesped, empleado, eleccion, servicio_elegido);
	System.out.println(CreadorFactura.accederListaFacturas(huesped));
	
	return opcion_servicio_solicitado;
}
	
	public String getConsultaFactura() {
		
		String nombreReserva=texto_nombre.getText();
		String facturaeleccion = opcionesFactura.getSelectedItem().toString();
		if(facturaeleccion=="Acceder Factura")
		{
			String resultado = CreadorFactura.accederListaFacturas(nombreReserva).toString();
			resultado=resultado.replace("[", "");
			resultado=resultado.replace("]", "");
			resultado=resultado.replace(",", "");
			resultado=resultado.replace("{", "\n");
			resultado=resultado.replace("}", "\n");
			JTextArea texto_factura=new JTextArea();
			texto_factura.setText(resultado);
			

			texto_factura.setPreferredSize(new Dimension(200, 200));
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_factura.setFont(fuente);
			panelEast.add(texto_factura);
			setVisible(true);
		}
		else if(facturaeleccion=="Finalizar Factura")
		{
			String resultado=CreadorFactura.finalizarFactura(nombreReserva).toString();
			JTextArea texto_factura=new JTextArea();
			
			resultado=resultado.replace("[", "");
			resultado=resultado.replace("]", "");
			resultado=resultado.replace(",", "");
			resultado=resultado.replace("{", "\n");
			resultado=resultado.replace("}", "\n");
			texto_factura.setText(resultado);
			
			texto_factura.setPreferredSize(new Dimension(200, 200));
			Font fuente=new Font("Arial", Font.HANGING_BASELINE, 12);
			texto_factura.setFont(fuente);
			panelEast.add(texto_factura);
			setVisible(true);
		}
			
		boton_factura.setEnabled(false);
		return nombreReserva;
	}
	
	public ArrayList<String> getServicios() {
		ArrayList<String> infoServicio = new ArrayList<String>();
		String nombreHuesped=texto_huesped.getText();
		String nombreEmpleado=texto_empleado.getText();
		infoServicio.add(nombreHuesped);
		infoServicio.add(nombreEmpleado);
		return infoServicio;
	}
	
	
	
public ArrayList<String> getListaServicios(ArrayList<String> lista_opciones)
{
	return lista_opciones;
}
	

	
public static void main(String[] args) throws IOException
	{
		Aplicacion.ejecutarCarga();
		Aplicacion.cargarArchivos();
		new InterfazServicios();
		
	}


@Override
public void actionPerformed(ActionEvent e) {
	
	String comando = e.getActionCommand();
	if (comando.equals(REALIZAR_CONSULTA))
		getConsultaFactura();
	if(comando.equals(OPCIONES_SERVICIOS))
		Servicio();
	if(comando.equals(ELECCION_SERVICIO))
		nuevoPedido();
	if (comando.equals(HOME)) {
		new InterfazGeneral();
		setVisible(false);
	}
	if (comando.equals(HUESPEDES)) {
		new InterfazHuesped();
		setVisible(false);
	}
		

	
		
		 
		

	
}





}