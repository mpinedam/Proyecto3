package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


import procesamiento.LoaderServicio;
import procesamiento.LoaderTarifa;


public class Reserva {
	
	
	
	private int numeroReserva;
	private String titularReserva;
	private int numeroPersonas;
	private String habitacionReservada;
	private String fecha;
	
	
	public Reserva (int numeroReserva, String titularReserva, int numeroPersonas, String habitacionReservada, String fecha) {
		this.numeroReserva = numeroReserva;
		this.titularReserva = titularReserva;
		this.numeroPersonas = numeroPersonas;
		this.habitacionReservada = habitacionReservada;
		this.fecha = fecha; 
	}
	
	
	
	
	public static HashMap<Integer, HashMap<String, String>> listaReservas = new HashMap<Integer, HashMap<String, String>>();

	public static HashMap<String, String> realizarReserva(ArrayList<String> infoReserva) throws FileNotFoundException, IOException{
		
		
		HashMap<String, String> reserva = new HashMap<String, String>();
		
		
		
		

		
		Integer random = (int) (Math.random()*(5555-999))+5555;
		reserva.put("Numero Reserva", String.valueOf(random));
		reserva.put("Nombre: ", infoReserva.get(0));
		reserva.put("Documento: ", infoReserva.get(1));
		reserva.put("Correo Electronico: ", infoReserva.get(2));
		reserva.put("Numero Celular: ", infoReserva.get(3));
		reserva.put("Huespedes Totales: ", String.valueOf(infoReserva.get(4)));
		
		
		HashMap<String, ArrayList<String>> habitacionesGeneral = LoaderServicio.cargarHabitaciones();
		
		int precioTotalHabitacion = 0;
		
		for (int i = 0; i <= Integer.valueOf(infoReserva.get(6))-1;i++) {
			String habiAsignada = Habitacion.asignarHabitacion(infoReserva.get(5));
			reserva.put("Habitacion"+ (i+1) + ": ", habiAsignada);
			int precio = Habitacion.calcularPrecioHabitación(infoReserva.get(5), infoReserva.get(7), infoReserva.get(8));
			reserva.put("PrecioHabitacion"+ (i+1) +": ", Integer.toString(precio));
			precioTotalHabitacion += precio;
			
		}
		
		
		
		ArrayList<String> listaInfo = habitacionesGeneral.get(infoReserva.get(5));
		
		
		reserva.put("Precio: ", String.valueOf(precioTotalHabitacion));
		System.out.println("La reserva ha sido registrada");
		
		listaReservas.put(random, reserva);
		
		
		return reserva;
	}
	
	
	public static HashMap<String, String> consultarReserva(String reserva){
		HashMap<String, String> reservaBuscada = listaReservas.get(Integer.parseInt(reserva));
		return reservaBuscada;
	}
	
	
	public static void cancelarReserva(int numeroReserva) {
		listaReservas.remove(numeroReserva);
		
		
		
	}
	
	
	
	
	private ArrayList<HashMap<String, String>>infoHuespedes(String nombreHuesped, String edadHuesped, int huespedesTotales){
		ArrayList<HashMap<String, String>> listaHuespedes = new ArrayList<HashMap<String, String>>();
		
		for (int i=0; i<=huespedesTotales; i++) {
			HashMap<String, String> huesped = new HashMap<String, String>();
			huesped.put("Nombre;", nombreHuesped);
			huesped.put("Edad;", edadHuesped);
			listaHuespedes.add(huesped);
					
		}
		
		
		return listaHuespedes;
		
	}
	
	
	
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;	

}


	public static HashMap<String, String> realizarReserva(String nombre, String documento, String correoElectronico,
			String numeroCelular, int huespedesTotal, String tipoHabi, String fechaInicial, String fechaFinal) {
		// TODO Auto-generated method stub
		return null;
	}


	public static HashMap<String, String> consultarReserva1(int code) {
		// TODO Auto-generated method stub
		return null;
	}
}




