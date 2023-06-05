package procesamiento;

import java.io.BufferedReader;

import java.io.File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoaderTarifa {
	private static final String FILENAME = "data/inventario_habitacionestxt.txt";

	public static void actualizarTarifas(String tipoCuarto, String fechaInicial, String fechaFinal, String nuevaTarifa, String diasSemana) throws IOException {
	    // Convertimos las fechas en objetos LocalDate
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    
	    System.out.println(fechaFinal);
	    
	    LocalDate fechaIni = LocalDate.parse(fechaInicial, formatter);
	    LocalDate fechaFin = LocalDate.parse(fechaFinal, formatter);
	    
	    System.out.println(fechaFin);

	    // Convertimos los días de la semana en una lista de objetos DayOfWeek
	    List<String> diasSemanaList = Arrays.asList(diasSemana.split(","));
	    DayOfWeek[] diasSemanaArr = new DayOfWeek[diasSemanaList.size()];
	    for (int i = 0; i < diasSemanaList.size(); i++) {
	        diasSemanaArr[i] = DayOfWeek.valueOf(diasSemanaList.get(i).toUpperCase().trim());
	    }

	    // Abrimos el archivo de inventario para leerlo
	    File archivoInventario = new File(FILENAME);
	    FileReader fr = new FileReader(archivoInventario);
	    BufferedReader br = new BufferedReader(fr);

	    // Creamos un archivo temporal para escribir los nuevos precios
	    File archivoTemporal = new File("data/inventario_habitaciones_temp.txt");
	    FileWriter fw = new FileWriter(archivoTemporal, true);

	    // Variables para llevar el control de si se encontró el rango de fechas
	    boolean rangoEncontrado = false;
	    boolean rangoAgregado = false;

	    // Recorremos cada línea del archivo de inventario
	    String lineaActual;
	    while ((lineaActual = br.readLine()) != null) {
	        // Convertimos la línea actual en un arreglo de valores
	        String[] valores = lineaActual.split(";");
	        LocalDate fechaActual = LocalDate.parse(valores[0], formatter);
	        

	        // Si la fecha actual está dentro del rango especificado y es del tipo de cuarto deseado
	        if (fechaActual.isAfter(fechaIni.minusDays(1)) && fechaActual.isBefore(fechaFin.plusDays(1)) && valores[1].equals(tipoCuarto)) {
	            // Convertimos el día de la semana actual en un objeto DayOfWeek
	        	System.out.println(fechaActual);
	        	
	        	DayOfWeek diaSemanaActual = fechaActual.getDayOfWeek();

	            // Si el día de la semana actual está dentro de los días de la semana deseados
	            if (Arrays.asList(diasSemanaArr).contains(diaSemanaActual)) {
	                // Actualizamos el precio de la habitación
	                valores[2] = nuevaTarifa;
	                rangoEncontrado = true;
	            }
	        }

	        // Escribimos la línea actual en el archivo temporal
	        fw.write(String.join(";", valores) + "\n");
	    }

	    // Cerramos los archivos
	    fr.close();
	    br.close();
	    fw.close();

	    // Eliminamos el archivo original y renombramos el archivo temporal
	    File archivoInventarioTemp = new File("data/inventario_habitaciones_temp.txt");
	    archivoInventario.delete();
	    archivoInventarioTemp.renameTo(archivoInventario);
	}

            
               
 
public static ArrayList<ArrayList<String>> cargarPreciosHabitaciones() throws IOException {

		ArrayList<ArrayList<String>> habitaciones = new ArrayList<ArrayList<String>>();
		File usar = new File("data/inventario_habitacionestxt.txt");
		String path = usar.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));
		br.readLine();
		String line = br.readLine();
		
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String fecha = partes[0];
			String precioHabitacion = partes[2];
			String tipo = partes[1];
			ArrayList<String> habitacion = new ArrayList<String>();
			
			habitacion.add(fecha);
			habitacion.add(tipo);
			habitacion.add(precioHabitacion);
			
		
			habitaciones.add(habitacion);


		}
		return habitaciones;
		
		
	
	}




public void cambiarTarifa(String fechaInicial, String fechaFinal, String habitacion, String dias, String nuevaTarifa) {
	// TODO Auto-generated method stub
	
}




public void cargarInformacionInventario(String string) {
	// TODO Auto-generated method stub
	
}




public String getTablaInventario() {
	// TODO Auto-generated method stub
	return null;
}   
    
    
	
	

}