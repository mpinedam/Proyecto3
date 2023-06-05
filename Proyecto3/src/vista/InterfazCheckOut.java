package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import logica.PayPal;
import logica.PayU;
import logica.Sire;
import logica.TarjetaDeCredito;

@SuppressWarnings("serial")
public class InterfazCheckOut extends JFrame implements ActionListener{
	
	private static final String PAYU = "PAYU";
	private static final String PAYPAL = "PAYPAL";
	private static final String SIRE = "SIRE";
	private static final String PAGAR = "PAGAR";
	
	
	private JTextField numeroReserva;
	private JTextField numeroTarjeta;
	private JTextField fechav;
	private JTextField csvv;
	private JTextField titularTarjeta;
	
	private JRadioButton PayPalBoton;
	private JRadioButton PayUBoton;
	private JRadioButton SireBoton;
	
	
	
	public InterfazCheckOut() {
		
		setTitle("CheckOut");
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout());
		
		JPanel CheckOut = new JPanel();
		CheckOut.setBackground(new Color (113, 169, 196));
		CheckOut.setOpaque(true);
		CheckOut.setLayout(new BoxLayout(CheckOut, BoxLayout.Y_AXIS));
		
		add(CheckOut);
		
		JLabel reserva = new JLabel("Ingrese el numero de reserva: ");
		CheckOut.add(reserva);
		numeroReserva = new JTextField();
		CheckOut.add(numeroReserva);
		
		

		JLabel pago = new JLabel("Escoger metodo de pago: ");
		CheckOut.add(pago);
		
		PayPalBoton = new JRadioButton();
		ImageIcon paypal = new ImageIcon("./imagenes/paypal.png");
		Image paypaloriginal = paypal.getImage();
		Image paypalresized = paypaloriginal.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
		ImageIcon paypalUsar = new ImageIcon(paypalresized);	
		PayPalBoton.setIcon(paypalUsar);
		PayPalBoton.addActionListener(this);
		PayPalBoton.setActionCommand(PAYPAL);
		CheckOut.add(PayPalBoton);
		
		
		PayUBoton = new JRadioButton();
		ImageIcon payu = new ImageIcon("./imagenes/PayU.png");
		Image payuoriginal = payu.getImage();
		Image payuresized = payuoriginal.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
		ImageIcon payuUsar = new ImageIcon(payuresized);	
		PayUBoton.setIcon(payuUsar);		
		PayUBoton.addActionListener(this);
		PayUBoton.setActionCommand(PAYU);
		CheckOut.add(PayUBoton);
		
		SireBoton = new JRadioButton();
		ImageIcon sire = new ImageIcon("./imagenes/sire.png");
		Image sireoriginal = sire.getImage();
		Image sireresized = sireoriginal.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
		ImageIcon sireUsar = new ImageIcon(sireresized);	
		SireBoton.setIcon(sireUsar);		
		SireBoton.addActionListener(this);
		SireBoton.setActionCommand(SIRE);
		CheckOut.add(SireBoton);
		
		 ButtonGroup grupoMediosPago = new ButtonGroup();
		 grupoMediosPago.add(PayPalBoton);
		 grupoMediosPago.add(PayUBoton);
		 grupoMediosPago.add(SireBoton);
		
		JLabel numeroTarj = new JLabel("Numero de Tarjeta: ");
		CheckOut.add(numeroTarj);
		numeroTarjeta = new JTextField();
		CheckOut.add(numeroTarjeta);
		
		JLabel titular = new JLabel("Titular Tarjeta: ");
		CheckOut.add(titular);
		titularTarjeta = new JTextField();
		CheckOut.add(titularTarjeta);
		
		JLabel vencimiento = new JLabel("Fecha de Vencimiento: ");
		CheckOut.add(vencimiento);
		fechav = new JTextField();
		CheckOut.add(fechav);
		
		JLabel csv = new JLabel("CSV: ");
		CheckOut.add(csv);
		csvv = new JTextField();
		CheckOut.add(csvv);
		
		JButton pagar = new JButton("Pagar");
		CheckOut.add(pagar);
		pagar.addActionListener(this);
		pagar.setActionCommand(PAGAR);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equals(PAGAR)) {
			ArrayList<String> pagoInformacion = getInfo();
			System.out.println(pagoInformacion);
			int cobro = TarjetaDeCredito.buscarPrecioTotal(pagoInformacion.get(0));
			
			pagoInformacion.add(String.valueOf(cobro));
			
			if (pagoInformacion.get(5).equals("PayPal")) {
				try {
					PayPal.agregarTransaccion(pagoInformacion);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			else if (pagoInformacion.get(5).equals("PayU")) {
				try {
					PayU.agregarTransaccion(pagoInformacion);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			else if (pagoInformacion.get(5).equals("Sire")) {
				try {
					Sire.agregarTransaccion(pagoInformacion);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			JOptionPane.showMessageDialog(this, "El pago se ha registrado" + "\n El valor de la transaccion es de: "  , "RESERVA", 1);
			
		}
		
		
		
	}
	
	
	private ArrayList<String> getInfo() {
		ArrayList<String> infoPago = new ArrayList<String>();
		
		String reserva = numeroReserva.getText();
		infoPago.add(reserva);
		numeroReserva.setText("");
		
		String numeTarjeta = numeroTarjeta.getText();
		infoPago.add(numeTarjeta);
		numeroReserva.setText("");
		
		String nombreTarjeta = titularTarjeta.getText();
		infoPago.add(nombreTarjeta);
		numeroReserva.setText("");
		
		String fechavenc = fechav.getText();
		infoPago.add(fechavenc);
		numeroReserva.setText("");
		
		String codigocsv = csvv.getText();
		infoPago.add(codigocsv);
		numeroReserva.setText("");
		
		
		
		if (PayPalBoton.isSelected()) {
			infoPago.add("PayPal");
		}
		
		else if (PayUBoton.isSelected()) {
			infoPago.add("PayU");
		}
		
		else if (SireBoton.isSelected()) {
			infoPago.add("Sire");
		}
		
		return infoPago;
		
	}
	

}
