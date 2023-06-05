package vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfazVisualizarInventario extends JFrame implements ActionListener {

    private DefaultTableModel model;
    private JButton home;
	private JButton huespedesBoton;
	private static final String HOME = "HOME";
	private static final String HUESPEDES = "HUESPEDES";


    public InterfazVisualizarInventario() {
    	
        super("Inventario de Habitaciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Leer el archivo y almacenar los datos en una lista o matriz
        ArrayList<String[]> habitaciones = new ArrayList<>();
        try {
            File file = new File("data/inventario_habitacionestxt.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] habitacion = scanner.nextLine().split(";");
                habitaciones.add(habitacion);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Crear un calendario utilizando la librería SWING de Java
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        JTable table = new JTable();
        String[] columns = {"Fecha", "Tipo de habitación", "Precio", "Descripción"};
        model = new DefaultTableModel(columns, 0);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Agregar componentes en el calendario para mostrar la información de las habitaciones para cada fecha disponible
        for (String[] habitacion : habitaciones) {
            String fecha = habitacion[0];
            String tipoHabitacion = habitacion[1];
            String precio = habitacion[2];
            String descripcion = habitacion[3];

            String[] row = {fecha, tipoHabitacion, precio, descripcion};
            model.addRow(row);
        }

        setVisible(true);
        
      //Home

      	home = new JButton("Volver al Inicio");
      	home.addActionListener(this);
      	home.setActionCommand(HOME);
      	home.setPreferredSize(new Dimension(30,30));
      	panel.add(home);
      			
      	//Menuhuesped

      	huespedesBoton = new JButton("Volver al Menu del Administrador");
      	huespedesBoton.addActionListener(this);
      	huespedesBoton.setActionCommand(HUESPEDES);
      	huespedesBoton.setPreferredSize(new Dimension(30,30));
      	panel.add(huespedesBoton);
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
		
		if (comando.equals(HUESPEDES)) {
			new InterfazHuesped();
			setVisible(false);
		}
		
	}
}
