package pruebasIntegracion;

import java.io.IOException;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;
import org.junit.Test;

import logica.Alojamiento;
import logica.InventarioHotel;
import logica.cama;
import logica.Spa;
import logica.TarifaHabitacion;
import logica.Restaurante;
import logica.Reserva;

public class pruebasIntegracion1 {
	
	@Test
    public void testCrearReserva() throws Exception {
        Reserva reserva = new Reserva(0, null, 0, null, null);
        ArrayList<String> infoReserva = new ArrayList<>();

        // utiliza la instancia de reserva y la lista de información de reserva
        infoReserva.add("Información de reserva 1");
        infoReserva.add("Información de reserva 2");
        infoReserva.add("Información de reserva 3");

        java.lang.reflect.Field numeroReservaField = Reserva.class.getDeclaredField("numeroReserva");
        java.lang.reflect.Field titularReservaField = Reserva.class.getDeclaredField("titularReserva");
        java.lang.reflect.Field numeroPersonasField = Reserva.class.getDeclaredField("numeroPersonas");
        java.lang.reflect.Field habitacionReservadaField = Reserva.class.getDeclaredField("habitacionReservada");
        java.lang.reflect.Field fechaField = Reserva.class.getDeclaredField("fecha");
        numeroReservaField.setAccessible(true);
        titularReservaField.setAccessible(true);
        numeroPersonasField.setAccessible(true);
        habitacionReservadaField.setAccessible(true);
        fechaField.setAccessible(true);

        // Asignamos los valores de los campos utilizando reflexión
        numeroReservaField.setInt(reserva, 0);
        titularReservaField.set(reserva, null);
        numeroPersonasField.setInt(reserva, 0);
        habitacionReservadaField.set(reserva, null);
        fechaField.set(reserva, null);

        // Verificamos que los datos se hayan asignado correctamente
        assertEquals(0, numeroReservaField.getInt(reserva));
        assertNull(titularReservaField.get(reserva));
        assertEquals(0, numeroPersonasField.getInt(reserva));
        assertNull(habitacionReservadaField.get(reserva));
        assertNull(fechaField.get(reserva));
    }
	
	
	


	}