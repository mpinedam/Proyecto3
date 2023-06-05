package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Spa {

	private String masaje;
	private int precio;
	private static Map<String, Integer> spa;
	public static Set<String> keys;
	public static Collection<Integer> values;
	public static List<String> keysfinal;
	public static int valor;
	public static String servicio;
	
	public Spa(String mas, int precio1)
	{
		masaje=mas;
		precio=precio1;
	}
	
	public String getMasaje()
	{
		return masaje;
	}
	public int getPrecio()
	{
		return precio;
	}
	
	public Spa(Map<String, Integer> plan1)
	{
		spa=plan1;
	}
	
	public static List<Object> mostrarMasaje()
	{
		keys=spa.keySet();
		values=spa.values();
		List<Integer>values1=new ArrayList(values);
		List<String>keys1=new ArrayList(keys);	
		List<Object> resultado=new ArrayList<>();
		resultado.add(keys1);
		resultado.add(values1);
		keysfinal=keys1;
		values=values1;
		
		return resultado;
	
	}
	
	public static String asociarNumeroS(int numero)
	{
		for (int i=0; i<spa.size(); i++)
		{
			keys=spa.keySet();
			values=spa.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
		    keysfinal = keys1;
		    if (numero==i+1)
			{
				servicio=keys1.get(i);
			}
		}
				
		return servicio;	
	
	}
	
	public static List<String> keys()
	{
		
		mostrarMasaje();
		return keysfinal;
	}
	public static Collection<Integer> values()
	{
		
		mostrarMasaje();
		return values;
	}
	
	public static int valor(String eleccion)
	{
		
		valor=spa.get(eleccion);
		return valor;
	}
	
	public static void cambioAdministrador_spa(String servicio, int precio) {
		
		for (int i=0; i<spa.size(); i++)
		{
			spa.replace(servicio, precio);
				
		}
		
	}
	
}
	