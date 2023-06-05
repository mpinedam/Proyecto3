package vista;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import logica.Reserva;

@SuppressWarnings("serial")
public class InterfazReserva extends JFrame implements ActionListener{
	
	
	private JTextField nombreh;
	private JTextField documentoh;
	private JTextField correoh;
	private JTextField celularh;
	private JComboBox<String> nHuespedes;
	private JComboBox<String> tHabitacion;
	private JComboBox<String> nHabitaciones;
	private JDateChooser fechaini;
	private JDateChooser fechafin;
	private JTextField reserva;
	private JButton home;
	private JButton huespedesBoton;
	public static String preciografica;
	
	
	
	
	private static final String NOMBRE = "NOMBRE";
	private static final String DOCUMENTO = "DOCUMENTO";
	private static final String CORREO = "CORREO";
	private static final String CELULAR = "CELULAR";

	private static final String CONSULTARRRESERVA = "CONSULTARRRESERVA";

	private static final String REALIZAR_RESERVA = "REALIZAR_RESERVA";
	private static final String HOME = "HOME";
	private static final String HUESPEDES = "HUESPEDES";

	public InterfazReserva() {
	
		setTitle("Reserva");
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JPanel nuevaReserva = new JPanel();
		nuevaReserva.setBackground(new Color (113, 169, 196));
		nuevaReserva.setOpaque(true);
		
		add(nuevaReserva);
		
		nuevaReserva.setLayout(new BoxLayout(nuevaReserva, BoxLayout.Y_AXIS));
		
		JLabel imagen = new JLabel(new ImageIcon("./imagenes/reserva1.jpeg"), JLabel.LEFT);
		nuevaReserva.add(imagen);
		
		//Nombre de la reserva
		JLabel nombre = new JLabel("Nombre: ");
		nuevaReserva.add(nombre);
		
		nombreh = new JTextField();
		nombreh.setPreferredSize(new Dimension (150,30));
		nombreh.addActionListener(this);
		nombreh.setActionCommand(NOMBRE);
		nuevaReserva.add(nombreh);
		
		//Documento
		JLabel documento = new JLabel("Documento: ");
		nuevaReserva.add(documento);
		
		documentoh = new JTextField();
		documentoh.setPreferredSize(new Dimension (200,30));
		documentoh.addActionListener(this);
		documentoh.setActionCommand(DOCUMENTO);
		nuevaReserva.add(documentoh);
		
		//Correo
		JLabel correo = new JLabel("Correo Electronico: ");
		nuevaReserva.add(correo);
		
		correoh = new JTextField();
		correoh.setPreferredSize(new Dimension (200,30));
		correoh.addActionListener(this);
		correoh.setActionCommand(CORREO);
		nuevaReserva.add(correoh);
		
		//Celular
		JLabel celular = new JLabel("Celular: ");
		nuevaReserva.add(celular);
		
		celularh = new JTextField();
		celularh.setPreferredSize(new Dimension (200,30));
		celularh.addActionListener(this);
		celularh.setActionCommand(CELULAR);
		nuevaReserva.add(celularh);
		
		//Huespedes
		JLabel huespedes = new JLabel("Numero de Huespedes: ");
		nuevaReserva.add(huespedes);
		
		String[] opcionesHuesp = {"1", "2", "3", "4", "5", "6", "7"};
		nHuespedes = new JComboBox<String>(opcionesHuesp);
		nuevaReserva.add(nHuespedes);
		
		//Habitacion 
		JLabel habitacion = new JLabel("Tipo de Habitación: ");
		nuevaReserva.add(habitacion);
		
		String[] opcionesHabitacion = {"estandar", "suite", "suite doble"};
		tHabitacion = new JComboBox<String>(opcionesHabitacion);
		nuevaReserva.add(tHabitacion);
		
		//Numero Habitaciones
		JLabel numHabitaciones = new JLabel("Numero de Habitaciones: ");
		nuevaReserva.add(numHabitaciones);
		
		String[] opcionesnumeroHabitacion = {"1", "2", "3", "4", "5", "6", "7"};
		nHabitaciones = new JComboBox<String>(opcionesnumeroHabitacion);
		nuevaReserva.add(nHabitaciones);
		
		//Fecha Inicial
		JLabel fechaInicial = new JLabel("Fecha Inicial ");
		nuevaReserva.add(fechaInicial);
		
		fechaini = new JDateChooser();
		fechaini.setBounds(320, 90, 200, 30);
		fechaini.setDateFormatString("yyyy-MM-dd");
		nuevaReserva.add(fechaini);
		
		//Fecha Final
		JLabel fechaFinal = new JLabel("Fecha Final ");
		nuevaReserva.add(fechaFinal);
		
		fechafin = new JDateChooser();
		fechafin.setBounds(320, 90, 200, 30);
		fechafin.setDateFormatString("yyyy-MM-dd");
		nuevaReserva.add(fechafin);
		
		//Boton Final
		JButton realizarReserva = new JButton("Realizar Reserva");
		realizarReserva.setForeground(new Color(88,135,179));
		realizarReserva.addActionListener(this);
		realizarReserva.setActionCommand(REALIZAR_RESERVA);
		nuevaReserva.add(realizarReserva);
		
		//PANEL 2
		
		JPanel consultarReserva = new JPanel();
		consultarReserva.setBackground(new Color (134, 197, 210));
		consultarReserva.setOpaque(true);
		add(consultarReserva);
		
		consultarReserva.setLayout(new BoxLayout(consultarReserva, BoxLayout.Y_AXIS));
		
		//Numero Reserva
		JLabel numeroReserva = new JLabel("Numero de Reserva: ");
		consultarReserva.add(numeroReserva);
		
		reserva = new JTextField();
		reserva.setSize(new Dimension (200,30));
		reserva.addActionListener(this);
		reserva.setActionCommand(CELULAR);
		consultarReserva.add(reserva);
		
		
		//Boton Final
		JButton consultarlaReserva = new JButton("Consultar Reserva");
		consultarlaReserva.setForeground(new Color(88,135,179));
		consultarlaReserva.addActionListener(this);
		consultarlaReserva.setActionCommand(CONSULTARRRESERVA);
		consultarReserva.add(consultarlaReserva);
		
		JLabel imagen2 = new JLabel(new ImageIcon("./imagenes/reserva2.png"), JLabel.CENTER);
		consultarReserva.add(imagen2);
			
		//Home

		home = new JButton("Volver al Inicio");
		home.addActionListener(this);
		home.setActionCommand(HOME);
		home.setPreferredSize(new Dimension(30,30));
		consultarReserva.add(home);
			
		//Menuhuesped

		huespedesBoton = new JButton("Volver al Menu de huespedes");
		huespedesBoton.addActionListener(this);
		huespedesBoton.setActionCommand(HUESPEDES);
		huespedesBoton.setPreferredSize(new Dimension(30,30));
		consultarReserva.add(huespedesBoton);
	
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		if (comando.equals(REALIZAR_RESERVA)) {
			try {
				HashMap<String, String> reserva = Reserva.realizarReserva(getInfo());
				
				
				String codigoReserva = reserva.get("Numero Reserva");

				String nombre = reserva.get("Nombre: ");
				
				String documento = reserva.get("Documento: ");
				
				String correo = reserva.get("Correo Electronico: ");
				
				String numeroCelular = reserva.get("Numero Celular: ");
				
				String huespedesTotales = reserva.get("Huespedes Totales: ");
				
				String habitacion1 = reserva.get("Habitacion1: ");

				
				String habitacion2 = reserva.get("Habitacion2: ");
				
				String habitacion3 = reserva.get("Habitacion3: ");
				
				String habitacion4 = reserva.get("Habitacion4: ");

				String precio = reserva.get("Precio: ");
				preciografica=precio;
				
				
				String imprimirReservafinal = "Numero Reserva: "+ codigoReserva +"\nNombre: " + nombre+"\nDocumento: " + documento + "\nCorreo Electronico: " + correo + "\nNumero Celular: " + numeroCelular + "\nHuespedes Totales: " + huespedesTotales + "\nHabitacion 1: " + habitacion1 + "\nHabitacion 2: " + habitacion2 + "\nHabitacion 3: " + habitacion3 + "\nHabitacion 4: " + habitacion4 + "\nPrecio: "+ precio;
				
				JOptionPane.showMessageDialog(this, imprimirReservafinal, "RESERVA", 1);
				
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (comando.equals(CONSULTARRRESERVA)) {
			System.out.println(getReserva());
			HashMap<String, String> reserva = Reserva.consultarReserva(getReserva());
			

			
			String codigoReserva = reserva.get("Numero Reserva");

			String nombre = reserva.get("Nombre: ");
			
			String documento = reserva.get("Documento: ");
			
			String correo = reserva.get("Correo Electronico: ");
			
			String numeroCelular = reserva.get("Numero Celular: ");
			
			String huespedesTotales = reserva.get("Huespedes Totales: ");
			
			String habitacion1 = reserva.get("Habitacion1: ");

			
			String habitacion2 = reserva.get("Habitacion2: ");
			
			String habitacion3 = reserva.get("Habitacion3: ");
			
			String habitacion4 = reserva.get("Habitacion4: ");

			String precio = reserva.get("Precio: ");
			
			
			
			String imprimirReservafinal = "La reserva ha sido encontrada" +"\nNumero Reserva: "+ codigoReserva +"\nNombre: " + nombre+"\nDocumento: " + documento + "\nCorreo Electronico: " + correo + "\nNumero Celular: " + numeroCelular + "\nHuespedes Totales: " + huespedesTotales + "\nHabitacion 1: " + habitacion1 + "\nHabitacion 2: " + habitacion2 + "\nHabitacion 3: " + habitacion3 + "\nHabitacion 4: " + habitacion4 + "\nPrecio: "+ precio;
			
			JOptionPane.showMessageDialog(this, imprimirReservafinal, "RESERVA BUSCADA", 1);
	}
		if (comando.equals(HOME)) {
			new InterfazGeneral();
			setVisible(false);
		}
		
		if (comando.equals(HUESPEDES)) {
			new InterfazHuesped();
			setVisible(false);
		}
	
	}
	
	private ArrayList<String> getInfo() {
		ArrayList<String> infoHuesped = new ArrayList<String>();
		String nombrehuesped = nombreh.getText();
		infoHuesped.add(nombrehuesped);
		nombreh.setText("");
		
		String dochuesped = documentoh.getText();
		infoHuesped.add(dochuesped);
		documentoh.setText("");
		
		String correohuesped = correoh.getText();
		infoHuesped.add(correohuesped);
		correoh.setText("");
		
		String celularhuesped = celularh.getText();
		infoHuesped.add(celularhuesped);
		celularh.setText("");
		
		Object numHuespedes = nHuespedes.getSelectedItem();
		String numeroHuesdepes = numHuespedes.toString();
		infoHuesped.add(numeroHuesdepes);
		
		Object typeHabit = tHabitacion.getSelectedItem();
		String tipoHabitacion = typeHabit.toString();
		infoHuesped.add(tipoHabitacion);
		
		Object nHabit = nHabitaciones.getSelectedItem();
		String numHabitaciones = nHabit.toString();
		infoHuesped.add(numHabitaciones);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		Date date = fechaini.getDate();
		String fechaInicial = dateFormat.format(date);
		infoHuesped.add(fechaInicial);
		
		
		Date dateend = fechafin.getDate();
		String fechaFinal = dateFormat.format(dateend);
		infoHuesped.add(fechaFinal);
		
		
		return infoHuesped;
		
	}
	
	public String getReserva() {
		String reservaBuscar = reserva.getText();
		return reservaBuscar;
		
	}
	
	
	
	
	

}