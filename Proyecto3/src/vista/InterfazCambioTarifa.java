package vista;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Image;

import procesamiento.LoaderInfo;
import procesamiento.LoaderTarifa;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class InterfazCambioTarifa extends JFrame implements ActionListener{
	

	public static JTextField nuevatarifa;
	public static JTextField ndias;
	public static JComboBox<String> tHabitacion;
	public static JDateChooser fechaini;
	public static JDateChooser fechafin;

	public static String fechaInicial;
	public static String fechaFinal;
	public static String tipoHabitacion;
	public static String dias_sem;
	public static String tarifa_nueva;
	
	private JButton home;
	private JButton huespedesBoton;
	

	private static final String REALIZAR_RESERVA = "REALIZAR_RESERVA";
	private static final String CELULAR = null;
	private static final String HOME = "HOME";
	private static final String ADMINISTRADOR = "ADMINISTRADOR";

	public InterfazCambioTarifa() {
	
		setTitle("Cambio de Tarifa");
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JPanel nuevaReserva = new JPanel();
		nuevaReserva.setBackground(new Color (134, 197, 210));
		nuevaReserva.setOpaque(true);
		
		add(nuevaReserva);
		
		nuevaReserva.setLayout(new BoxLayout(nuevaReserva, BoxLayout.Y_AXIS));

		
		// crea la etiqueta JLabel con la imagen
		ImageIcon icono = new ImageIcon("./imagenes/habitaciones_inv.jpeg");
		Image imagenOriginal = icono.getImage();
		Image imagenRedimensionada = imagenOriginal.getScaledInstance(500, -1, Image.SCALE_DEFAULT); 
		JLabel imagen = new JLabel(new ImageIcon(imagenRedimensionada), JLabel.LEFT);

		// agrega la etiqueta al panel
		nuevaReserva.add(imagen);
		
		
		//Tipo de cuarto
		JLabel cuartoss = new JLabel("Seleccione el tipo de cuarto: ");
		
		nuevaReserva.add(cuartoss,BorderLayout.NORTH);
		
		String[] opcionesHuesp = {"estandar", "suite", "suite doble"};
		
		tHabitacion = new JComboBox<String>(opcionesHuesp);
		nuevaReserva.add(tHabitacion,BorderLayout.CENTER);
		
		// Seleccionar dias

		JLabel dias = new JLabel("Escriba los días a modificar en formato MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY: ");
		nuevaReserva.add(dias);
				
		ndias = new JTextField();
		ndias.setPreferredSize(new Dimension (200,30));
		ndias.addActionListener(this);
		ndias.setActionCommand(CELULAR);
		nuevaReserva.add(ndias);


		
		//Fecha Inicial
		JLabel fechaInicial = new JLabel("Fecha Inicial ");
		nuevaReserva.add(fechaInicial);
		
		fechaini = new JDateChooser();
		fechaini.setBounds(320, 90, 200, 30);
		fechaini.setDateFormatString("yyyy-MM-dd");
		nuevaReserva.add(fechaini);
		
		//Fecha Final
		JLabel fechaFinal = new JLabel("Fecha Final ");
		nuevaReserva.add(fechaFinal);
		
		fechafin = new JDateChooser();
		fechafin.setBounds(320, 90, 200, 30);
		fechafin.setDateFormatString("yyyy-MM-dd");
		nuevaReserva.add(fechafin);
		
		// Escribir nueva Tarifa

		JLabel precio = new JLabel("Escriba la nueva tarifa a aplicar: ");
		nuevaReserva.add(precio);
						
		nuevatarifa = new JTextField();
		nuevatarifa.setPreferredSize(new Dimension (200,30));
		nuevatarifa.addActionListener(this);
		nuevatarifa.setActionCommand(CELULAR);
		nuevaReserva.add(nuevatarifa);
		
		//Boton Final
		JButton realizarReserva = new JButton("Realizar Cambio de Tarifa");
		realizarReserva.setForeground(new Color(88,135,179));
		realizarReserva.addActionListener(this);
		realizarReserva.setActionCommand(REALIZAR_RESERVA);
		nuevaReserva.add(realizarReserva);
		
		home = new JButton("Volver al Inicio");
		home.addActionListener(this);
		home.setActionCommand(HOME);
		home.setPreferredSize(new Dimension(30,30));
		nuevaReserva.add(home);
			
		//Menuhuesped

		huespedesBoton = new JButton("Volver al Menu de Administrador");
		huespedesBoton.addActionListener(this);
		huespedesBoton.setActionCommand(ADMINISTRADOR);
		huespedesBoton.setPreferredSize(new Dimension(30,30));
		nuevaReserva.add(huespedesBoton);
	
		
		

	
	}
	
	private static LoaderTarifa habitaciones = new LoaderTarifa();
	

	public static String getInfo() throws IOException {
		ArrayList<String> infoHuesped = new ArrayList<String>();
	
		tarifa_nueva = nuevatarifa.getText();
		infoHuesped.add(tarifa_nueva);
		
		dias_sem = ndias.getText();
		infoHuesped.add(dias_sem);
		
		Object typeHabit = tHabitacion.getSelectedItem();
		tipoHabitacion = typeHabit.toString();
		infoHuesped.add(tipoHabitacion);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		Date date = fechaini.getDate();
		fechaInicial = dateFormat.format(date);
		infoHuesped.add(fechaInicial);
		
		Date dateend = fechafin.getDate();
		fechaFinal = dateFormat.format(dateend);
		infoHuesped.add(fechaFinal);
		
		String infoHuespedd = "HOLA";
		
		System.out.println(infoHuespedd);
		System.out.println(fechaFinal);
		
		habitaciones.actualizarTarifas
		(tipoHabitacion,fechaInicial,fechaFinal,tarifa_nueva,dias_sem);
		
		
		
		System.out.println(infoHuesped);
		
		return infoHuespedd;
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		if (comando.equals(REALIZAR_RESERVA));

		LoaderTarifa cambiarTarifa = new LoaderTarifa();

		
		try {
			InterfazCambioTarifa.getInfo();
			Object[] opciones = {"Visualizar inventario", "Volver al menú principal"};
		    int seleccion = JOptionPane.showOptionDialog(null, "El cambio de tarifa fue exitoso", "Cambio de tarifa", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

		    if (seleccion == 0) {
		    	new InterfazVisualizarInventario();
		    } else {
		    	new InterfazAdministrador(); 
		    	setVisible(false);
		    }
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (comando.equals(HOME)) {
			new InterfazGeneral();
			setVisible(false);
		}
		
		if (comando.equals(ADMINISTRADOR)) {
			new InterfazAdministrador();
			setVisible(false);
		}

		
	}
	
	
	}