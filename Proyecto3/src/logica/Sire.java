package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sire {
	
	
	public static void agregarTransaccion(ArrayList<String> infoTransaccion) throws IOException{
		
		String ruta = "pasarelatransacciones/Sire.txt";
		
		 FileWriter escribirFile = new FileWriter(ruta);

         BufferedWriter writer = new BufferedWriter(escribirFile);
         
         String cadena = infoTransaccion.get(0) + ";" + infoTransaccion.get(1) + ";" + infoTransaccion.get(2)+ ";" + infoTransaccion.get(3)+ ";" + infoTransaccion.get(4)+ ";" + infoTransaccion.get(5) + ";" + infoTransaccion.get(6)+ ";" + "Aprobada";
         writer.newLine();
         writer.write(cadena);
         
         writer.close();
         escribirFile.close();
		
	}
}
