package vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfazInformacionHotel extends JFrame implements ActionListener {

    private DefaultTableModel model;
    private JButton home;
	private JButton huespedesBoton;
	private static final String HOME = "HOME";
	private static final String HUESPEDES = "HUESPEDES";


    public InterfazInformacionHotel() {
    	
    	{
    		// Establecer título de la ventana
            setTitle("Información del Hotel");

            // Crear un panel para mostrar la información del hotel
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.anchor = GridBagConstraints.WEST;
  
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel label1 = new JLabel("El hotel cuenta con la siguiente información:");
            label1.setFont(new Font("Arial", Font.BOLD, 16));
            constraints.gridx = 0;
            constraints.gridy = 0;
            panel.add(label1, constraints);

            String[] informacion = {
                    "• Parqueadero pago en el hotel 💵",
                    "• Parqueadero gratuito en el hotel 🆓",
                    "• Piscina 💦‍️",
                    "• Zonas húmedas 🔥️",
                    "• BBQ 🍖",
                    "• Wifi gratis 🌐",
                    "• Recepción 24 horas 🛎️",
                    "• Admite mascotas 🐕"
            };

            for (int i = 0; i < informacion.length; i++) {
                JLabel label = new JLabel(informacion[i]);
                constraints.gridy = i + 1;
                panel.add(label, constraints);
            }

           
        
	      //Home
	
	      	home = new JButton("Volver al Inicio");
	      	home.addActionListener(this);
	      	home.setActionCommand(HOME);
	      	home.setPreferredSize(new Dimension(30,30));
	      	panel.add(home);
	      		
	      	
	     // Agregar el panel a la ventana
            getContentPane().add(panel);

            // Ajustar el tamaño de la ventana automáticamente según el contenido
            pack();

            // Establecer la operación predeterminada al cerrar la ventana
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Mostrar la ventana
            setVisible(true);
    	}
    }
    	
    	

    public static void main(String[] args) {
        new InterfazVisualizarInventario();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(HOME)) {
			new InterfazGeneral();
			setVisible(false);
		}
		
		
	}
}