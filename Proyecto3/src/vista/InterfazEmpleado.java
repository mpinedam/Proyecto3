package vista;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;

	@SuppressWarnings("serial")
	public class InterfazEmpleado extends JFrame implements ActionListener{
		
		
		private static final String FUNCIONALIDAD = "FUNCIONALIDAD";
		private JComboBox<String> funcionalidad;

		public  InterfazEmpleado()
		{
			
			getContentPane().setBackground(new Color (134, 197, 210));
			setLayout(new BorderLayout());
			
			setTitle("Empleado");
			setSize(700, 700);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JLabel selusu = new JLabel("Seleccione que desea realizar: ");
			add(selusu, BorderLayout.PAGE_START);
			
			String[] opcionesFuncionalidad = {"Visualizar Inventario", "Visualizar Ocupadación Habitaciones", "Registrar una Reserva", "Realizar CheckOut", "Visualizar Características del Hotel", "Visualizar Características de las Habitaciones"};
			funcionalidad = new JComboBox<String>(opcionesFuncionalidad); 
			funcionalidad.addActionListener(this);
			funcionalidad.setActionCommand(FUNCIONALIDAD);
			
			add(funcionalidad, BorderLayout.CENTER);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if (comando.equals(FUNCIONALIDAD));
			Object funcionalidadele = funcionalidad.getSelectedItem();
			String seleccionado = funcionalidadele.toString();
			if (seleccionado == "Visualizar Inventario") {
				new InterfazVisualizarInventario();
				setVisible(false);
			}
			else if (seleccionado == "Visualizar Ocupadación Habitaciones") {
				new vistaInventario();
				setVisible(false);
				
			}
			else if (seleccionado == "Registrar una Reserva") {
				new InterfazReserva();
				setVisible(false);
			}
			
			else if (seleccionado == "Realizar CheckOut") {
				new InterfazCheckOut();
				setVisible(false);
			}
			
			else if (seleccionado == "Visualizar Características del Hotel") {
				new InterfazInformacionHotel();
				setVisible(false);
			
		}
			
			else if (seleccionado == "Visualizar Características de las Habitaciones") {
				new InterfazInformacionCuartos();
				setVisible(false);
			}

	}
		
	}
	

