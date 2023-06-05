package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.GuiaTuristico;
import logica.Restaurante;
import logica.Spa;

public class InterfazCambiarServicios extends JFrame implements ActionListener{
	private JComboBox<String> opciones;
	private JPanel panel;
	private JButton boton_busqueda;
	private ArrayList<String> infoServicio;
	private JComboBox numeros;
	private int eleccion;
	private JButton boton_eleccion;
	private String servicio_elegido;
	private JTextField texto_precio;
	private int precio;
	private JButton home;
	private JButton huespedesBoton;
	private JPanel panelAbajo;
	
	private static final String REALIZAR_CONSULTA="REALIZAR_CONSULTA";
	private static final String ELECCION_SERVICIO="ELECCION_SERVICIO";
	private static final String HOME = "HOME";
	private static final String ADMINISTRADOR = "ADMINISTRADOR";
	
	public InterfazCambiarServicios(){
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		
		setTitle("Sistema de cambio de precio(SERVICIOS)");
		setSize(770, 770);
		setVisible(true);
		
		panel=new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(new Color(134, 197, 210));
		panel.setPreferredSize(new Dimension(525,525));
		setVisible(true);
		
		String[] opcionesServicios = {"Restaurante Habitacion", "Restaurante", "Spa", "Guia Turistico"};
		opciones = new JComboBox<String>(opcionesServicios); 
		panel.add(opciones);
		setVisible(true);
		
		boton_busqueda=new JButton("Consulta");
		boton_busqueda.setForeground(new Color(88,135,179));
		boton_busqueda.addActionListener(this);
		boton_busqueda.setActionCommand(REALIZAR_CONSULTA);
		boton_busqueda.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_busqueda.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.add(boton_busqueda);
		
		texto_precio=new JTextField();
		texto_precio.setPreferredSize(new Dimension (120,30));
		texto_precio.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_precio.setAlignmentY(Component.CENTER_ALIGNMENT);
		panel.add(texto_precio);
		setVisible(true);
		
		panelAbajo=new JPanel();
		add(panelAbajo, BorderLayout.SOUTH);
		panelAbajo.setBackground(new Color(97,110,160));
		panelAbajo.setPreferredSize(new Dimension(200,200));
		setVisible(true);
		
		
		home = new JButton("Volver al Inicio");
		home.addActionListener(this);
		home.setActionCommand(HOME);
		home.setPreferredSize(new Dimension(200,20));
		panelAbajo.add(home);
			
		//Menuhuesped

		huespedesBoton = new JButton("Volver al Menu de Administrador");
		huespedesBoton.addActionListener(this);
		huespedesBoton.setActionCommand(ADMINISTRADOR);
		huespedesBoton.setPreferredSize(new Dimension(200,20));
		panelAbajo.add(huespedesBoton);
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if (comando.equals(REALIZAR_CONSULTA))
			getOpciones();
		if(comando.equals(ELECCION_SERVICIO))
			getServicioNombre();
		if (comando.equals(HOME)) {
			new InterfazGeneral();
			setVisible(false);
		}
		
		if (comando.equals(ADMINISTRADOR)) {
			new InterfazAdministrador();
			setVisible(false);
		}
		
	}






	






	public ArrayList<String> getOpciones() {
		infoServicio = new ArrayList<String>();
		
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
			panel.add(texto_servicios);
			panel.add(numeros);
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
			panel.add(texto_servicios);
			panel.add(numeros);
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
			panel.add(texto_servicios);
			panel.add(numeros);
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
			panel.add(texto_servicios);
			panel.add(numeros);
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
		panel.add(boton_eleccion);
		setVisible(true);
		
		return infoServicio;
	}
		
	public String getServicioNombre() {
		String servicio_solicitado=opciones.getSelectedItem().toString();
		String numero_solicitado=numeros.getSelectedItem().toString();
		int numero = Integer.parseInt(numero_solicitado);
		
		
		
		
		precio=Integer.parseInt(texto_precio.getText());
		
		if (servicio_solicitado=="Restaurante")
		{
			
			servicio_elegido=Restaurante.asociarNumeroRM(numero);
			Restaurante.cambioAdministrador_restauranteR(servicio_elegido, precio);
			System.out.println("Se cambio restaurante");
			
		}
		else if (servicio_solicitado=="Restaurante Habitacion")
		{
			servicio_elegido=Restaurante.asociarNumeroRH(numero);
			Restaurante.cambioAdministrador_restauranteH(servicio_elegido, precio);
				
		}
		else if (servicio_solicitado=="Spa")
		{
			
			servicio_elegido=Spa.asociarNumeroS(numero);
			Spa.cambioAdministrador_spa(servicio_elegido, precio);
			
		}
		else if (servicio_solicitado=="Guia Turistico")
		{
			
			servicio_elegido=GuiaTuristico.asociarNumeroGT(numero);
			GuiaTuristico.cambioAdministrador_guiaturistico(servicio_elegido, precio);
			
		}
		
	 return servicio_elegido;
		
	}	
		
	
}
