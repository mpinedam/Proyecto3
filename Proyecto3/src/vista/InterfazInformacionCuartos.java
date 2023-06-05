package vista;

	import java.awt.BorderLayout;
	import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

	@SuppressWarnings("serial")
	public class InterfazInformacionCuartos extends JFrame implements ActionListener{
		
		
		private static final String FUNCIONALIDAD = "FUNCIONALIDAD";
		private JComboBox<String> funcionalidad;
		

		public  InterfazInformacionCuartos()
		{
			
			getContentPane().setBackground(new Color (134, 197, 210));
			setLayout(new BorderLayout());
			
			setTitle("Empleado");
			setSize(700, 700);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JLabel selusu = new JLabel("Seleccione que desea realizar: ");
			add(selusu, BorderLayout.PAGE_START);
			
			String[] opcionesFuncionalidad = {"Estandar", "Suite", "Suite Doble"};
			funcionalidad = new JComboBox<String>(opcionesFuncionalidad); 
			funcionalidad.addActionListener(this);
			funcionalidad.setActionCommand(FUNCIONALIDAD);
			
			add(funcionalidad, BorderLayout.CENTER);
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String infoEstandar = "Ubicacion: Piso 1, Piso 2, Piso 3\n Capacidad: 2 personas\n Tamaño: 40 m2\n Camas: 1 cama doble\nBalcon: No\n Cocina: No\n Vista: Si\n Aire Acondicionado: Si\n TV: Si \n Cafetera: Si\n Hipoalergenicos: Si\n Plancha: No\n Secador de pelo: No\n Voltaje: 150V\nUSB-A: Si\n USB-C: Si\n Desayuno: No  ";
			String infoSuite = "Ubicacion: Piso 4, Piso 5\n Capacidad: 3 personas\n Tamaño: 50 m2\n Camas: 1 cama doble y 1 cama sencilla\nBalcon: Si\n Cocina: No\n Vista: Si\n Aire Acondicionado: Si\n TV: Si \n Cafetera: Si\n Hipoalergenicos: Si\n Plancha: Si\n Secador de pelo: Si\n Voltaje: 150V\nUSB-A: Si\n USB-C: Si\n Desayuno: No";
			String infoSuiteDoble = "Ubicacion: Piso 6\n Capacidad: 4 personas\n Tamaño: 50 m2\n Camas: 1 cama doble y 2 camas sencillas\nBalcon: Si\n Cocina: Si\n Vista: Si\n Aire Acondicionado: Si\n TV: Si \n Cafetera: Si\n Hipoalergenicos: Si\n Plancha: Si\n Secador de pelo: Si\n Voltaje: 150V\nUSB-A: Si\n USB-C: Si\n Desayuno: Si";
			
			
			
			String comando = e.getActionCommand();
			if (comando.equals(FUNCIONALIDAD));
			Object funcionalidadele = funcionalidad.getSelectedItem();
			String seleccionado = funcionalidadele.toString();
			if (seleccionado == "Estandar") {
				JOptionPane.showMessageDialog(this, infoEstandar, "RESERVA", 1);

			}
			else if (seleccionado == "Suite") {
				JOptionPane.showMessageDialog(this, infoSuite, "RESERVA", 1);
				
			}
			
			else if (seleccionado == "Suite Doble") {
				JOptionPane.showMessageDialog(this, infoSuiteDoble, "RESERVA", 1);
			}
			
			
		}

	}
		
	