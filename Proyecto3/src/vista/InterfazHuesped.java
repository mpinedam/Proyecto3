package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class InterfazHuesped extends JFrame implements ActionListener{
	
	
	private static final String FUNCIONALIDAD = "FUNCIONALIDAD";
	private JComboBox<String> funcionalidad;

	public InterfazHuesped()
	{
		
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		setTitle("Huesped");
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel selusu = new JLabel("Seleccione que desea hacer: ");
		add(selusu, BorderLayout.CENTER);
		
		String[] opcionesFuncionalidad = {"Realizar Reserva", "Solicitar Servicio", "Visualizar Características del Hotel", "Visualizar Características de las Habitaciones"};
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
		if (seleccionado == "Realizar Reserva") {
			new InterfazReserva();
			setVisible(false);
		}
		else if (seleccionado == "Solicitar Servicio") {
			new InterfazServicios();
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
