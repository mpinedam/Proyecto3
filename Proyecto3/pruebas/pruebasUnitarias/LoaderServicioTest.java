package pruebasUnitarias;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

import procesamiento.LoaderServicio;

import java.util.ArrayList;
import java.util.HashMap;


public class LoaderServicioTest {

	@Test
    public void testCargarHabitaciones() {
        try {
            HashMap<String, ArrayList<String>> habitaciones = LoaderServicio.cargarHabitaciones();

            assertNotNull(habitaciones);
            assertEquals(3, habitaciones.size());

            ArrayList<String> estandarInfo = habitaciones.get("estandar");
            assertNotNull(estandarInfo);
            assertEquals(8, estandarInfo.size());
            assertEquals("500000", estandarInfo.get(0));
            assertEquals("400000", estandarInfo.get(1));
            assertEquals("1", estandarInfo.get(2));
            assertEquals("0", estandarInfo.get(3));
            assertEquals("2", estandarInfo.get(4));
            assertEquals("false", estandarInfo.get(5));
            assertEquals("false", estandarInfo.get(6));
            assertEquals("interior", estandarInfo.get(7));

            ArrayList<String> suiteInfo = habitaciones.get("suite");
            assertNotNull(suiteInfo);
            assertEquals(8, suiteInfo.size());
            assertEquals("600000", suiteInfo.get(0));
            assertEquals("600000", suiteInfo.get(1));
            assertEquals("1", suiteInfo.get(2));
            assertEquals("1", suiteInfo.get(3));
            assertEquals("3", suiteInfo.get(4));
            assertEquals("false", suiteInfo.get(5));
            assertEquals("true", suiteInfo.get(6));
            assertEquals("exterior", suiteInfo.get(7));

            ArrayList<String> suiteDobleInfo = habitaciones.get("suitedoble");
            assertNotNull(suiteDobleInfo);
            assertEquals(8, suiteDobleInfo.size());
            assertEquals("900000", suiteDobleInfo.get(0));
            assertEquals("750000", suiteDobleInfo.get(1));
            assertEquals("2", suiteDobleInfo.get(2));
            assertEquals("1", suiteDobleInfo.get(3));
            assertEquals("5", suiteDobleInfo.get(4));
            assertEquals("true", suiteDobleInfo.get(5));
            assertEquals("true", suiteDobleInfo.get(6));
            assertEquals("exterior", suiteDobleInfo.get(7));

        } catch (IOException e) {
            fail("Se produjo una excepción inesperada: " + e.getMessage());
        }
    }


    @Test
    public void testCargarHabitacionesCodigo() {
        try {
            // Llamar al método cargarHabitacionesCodigo y verificar que se carguen correctamente los datos
            HashMap<String, String> habitaciones = LoaderServicio.cargarHabitacionesCodigo();

            // Verificar que se hayan cargado algunas habitaciones
            assertFalse(habitaciones.isEmpty());

            // Verificar que los datos de las habitaciones sean correctos
            String tipo = habitaciones.get("1101");
            assertNotNull(tipo);
            assertEquals("estandar", tipo);
            
            
            HashMap<String, String> habitacionesCodigo = LoaderServicio.cargarHabitacionesCodigo();

            assertEquals(48, habitacionesCodigo.size());
            assertEquals("estandar", habitacionesCodigo.get("1101"));
            assertEquals("estandar", habitacionesCodigo.get("1110"));
            assertEquals("suite", habitacionesCodigo.get("1122"));
            assertEquals("suite doble", habitacionesCodigo.get("1140"));
            

        } catch (Exception e) {
            fail("Error al cargar los códigos de las habitaciones: " + e.getMessage());
        }
    }
}