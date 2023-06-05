package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Reserva;


public class vistaInventario extends JFrame implements ActionListener{
	
	private static final String HOME = "HOME";
	JButton home;
	
	public vistaInventario() {
	setTitle("Inventario");
	setSize(700, 300);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridLayout(4,12));
	
	

  
    for (int i = 1101; i <= 1148; i++) {
        JButton button = new JButton(String.valueOf(i));
        
        HashMap<Integer, HashMap<String, String>>totalReservas = Reserva.listaReservas;
        
        for (int m=0;m<=totalReservas.size()-1;m++) {
        	Set<Integer> numerosReservas = totalReservas.keySet();
        	add(button);
        	for (int j=0; j<=numerosReservas.size()-1;j++) {
        		Object[] arrayReservas = numerosReservas.toArray();
        		Integer reservaActual = (Integer) arrayReservas[j];
        		HashMap<String, String> infoReserva = totalReservas.get(reservaActual);
        		String habitacion1=infoReserva.get("Habitacion1: ");
        		if (Integer.toString(i).equals(habitacion1)) {
        			
        			button.setForeground(Color.RED);
        		}
        		
        		
        		
        	}
        		

        
	}

    }

    home = new JButton("Volver al Inicio");
	home.addActionListener(this);
	home.setActionCommand(HOME);
	home.setPreferredSize(new Dimension(30,10));
	add(home);
    

}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if (comando.equals(HOME)) {
			new InterfazGeneral();
			setVisible(false);
		}
	}
}