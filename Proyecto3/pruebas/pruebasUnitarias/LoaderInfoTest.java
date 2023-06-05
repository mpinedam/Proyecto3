package pruebasUnitarias;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import procesamiento.LoaderInfo;


public class LoaderInfoTest {

    @Test
    public void testCargarArchivo() {
        try {
            // Llamar al método cargarArchivo
            LoaderInfo.cargarArchivo();

            // Si no se lanzan excepciones, asumimos que la carga del archivo fue exitosa
            assertTrue(true);
        } catch (Exception e) {
            // Si se lanza una excepción, la carga del archivo falló
            fail("Error al cargar el archivo: " + e.getMessage());
        }
    }

    
}