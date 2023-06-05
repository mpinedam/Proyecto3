package pruebasUnitarias;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import procesamiento.LoaderTarifa;

import java.util.ArrayList;
import java.util.HashMap;

public class LoaderTarifaTest {
	
	@Test
    public void testCargarPreciosHabitaciones() {
        try {
            ArrayList<ArrayList<String>> habitaciones = LoaderTarifa.cargarPreciosHabitaciones();
            
            // Verificar que se haya cargado la cantidad correcta de habitaciones
            assertEquals(1093, habitaciones.size());

            // Verificar los valores de las habitaciones cargadas
            ArrayList<String> habitacion1 = habitaciones.get(0);
            assertEquals("2023-04-02", habitacion1.get(0));
            assertEquals("estandar", habitacion1.get(1));
            assertEquals("450000", habitacion1.get(2));

            ArrayList<String> habitacion2 = habitaciones.get(1);
            assertEquals("2023-04-03", habitacion2.get(0));
            assertEquals("estandar", habitacion2.get(1));
            assertEquals("450000", habitacion2.get(2));


        } catch (IOException e) {
            fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
        
        
    }
	
}
