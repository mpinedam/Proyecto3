package logica;

import java.util.HashMap;

public class TarjetaDeCredito {
	
	public static int buscarPrecioTotal(String idReserva) {
		
		Integer reservaUsar = Integer.valueOf(idReserva);
				
		HashMap<Integer, HashMap<String, String>> listaHabitaciones = Reserva.listaReservas;
		HashMap<String, String> infoHabitacion = listaHabitaciones.get(reservaUsar);
		String precio = infoHabitacion.get("Precio: ");
		
		Integer cobro = Integer.valueOf(precio);

		return cobro;
	}
	
	
	
	

}
