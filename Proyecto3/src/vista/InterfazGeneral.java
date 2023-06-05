package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import consola.Aplicacion;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
@SuppressWarnings("serial")
public class InterfazGeneral extends JFrame implements ActionListener{
    
    private static final String USUARIO = "USUARIO";
    
    private JComboBox<String> usuario;
    private JTextField login;
    private JPasswordField password;
    public HashMap<String,char[]> usuarios_registrados=new HashMap<String, char[]>();
    private JComboBox elegir;
    private String opcion_elegida;
    private String nombreUsuario;
    private char[] contrasena;
    private JButton continuar;

    public InterfazGeneral() {
        getContentPane().setBackground(new Color(134, 197, 210));
        setLayout(new BorderLayout());
        
        setTitle("Hotel Casanova 🏨");
        setSize(900, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel saludo = new JLabel("<html>Bienvenido al Property Managament System del Hotel CasaNova 🏨<br>Por favor ingrese la siguiente información para poder continuar: </html>");
        saludo.setVerticalAlignment(JLabel.CENTER);
        saludo.setHorizontalAlignment(JLabel.CENTER);
        saludo.setPreferredSize(new Dimension(getWidth(), 100));
        add(saludo, BorderLayout.CENTER);
        
        saludo.setFont(new Font("Arial", Font.BOLD, 20));
        saludo.setForeground(Color.WHITE);
        saludo.setHorizontalAlignment(SwingConstants.CENTER);
        add(saludo, BorderLayout.PAGE_START);

        JPanel panelIngreso = new JPanel(new GridLayout(3, 1));
        JPanel panelCargo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel etiquetaCargo = new JLabel("Seleccione su cargo/rol dentro del hotel:");
        panelCargo.add(etiquetaCargo);
        panelIngreso.add(panelCargo);

        JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] opcionesUsuario = {"Administrador", "Empleado", "Huesped"};
        usuario = new JComboBox<String>(opcionesUsuario); 
        usuario.addActionListener(this);
        usuario.setActionCommand(USUARIO);
        panelUsuario.add(usuario);
        panelIngreso.add(panelUsuario);
        
        elegir=new JComboBox<String>();
        elegir.addItem("Sign In");
        elegir.addItem("Log In");
        panelUsuario.add(elegir);
        setVisible(true);
        
       
        JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel etiquetaLogin = new JLabel("Login:");
        login = new JTextField();
        login.setColumns(20);
        panelLogin.add(etiquetaLogin);
        panelLogin.add(login);
        panelIngreso.add(panelLogin);

        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel etiquetaPassword = new JLabel("Password:");
        password = new JPasswordField();
        password.setColumns(20);
        panelPassword.add(etiquetaPassword);
        panelPassword.add(password);
        panelIngreso.add(panelPassword);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setPreferredSize(new Dimension(500, 200));
        panelCentro.setBackground(new Color(134, 197, 210));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panelCentro.add(panelIngreso, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        
        continuar = new JButton("Continuar");
        continuar.addActionListener(this);
        continuar.setActionCommand("CONTINUAR");

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setPreferredSize(new Dimension(getWidth(), 50));
        panelBoton.setBackground(new Color(134, 197, 210));
        panelBoton.add(continuar);
        add(panelBoton, BorderLayout.PAGE_END);
    }
	

	
public static void main(String[] args) throws IOException
	{
		new InterfazGeneral();
		Aplicacion.ejecutarCarga();
		Aplicacion.cargarArchivos();
	}


@Override
public void actionPerformed(ActionEvent e) {
	String comando = e.getActionCommand();
	
	if (comando.equals("CONTINUAR")) {
		nombreUsuario = login.getText();
		contrasena = password.getPassword();
		System.out.println(nombreUsuario);
		System.out.println(contrasena);
		String contrasena_string=contrasena.toString();
		opcion_elegida = elegir.getSelectedItem().toString();
		if(opcion_elegida=="Sign In") {
			usuarios_registrados.put(nombreUsuario, contrasena);
		}
		if(opcion_elegida=="Log In")
		{
			
			boolean condicion = usuarios_registrados.containsKey(nombreUsuario);
			if (condicion==false)
			{
				JOptionPane.showMessageDialog(this, "El usuario no esta registrado, desea registrarse?", "Nuevo Registro", 1);
				setVisible(false);
				
			}
					
			
			
		}
		
		if (nombreUsuario.isEmpty() || contrasena.length == 0) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de usuario y una contraseña válidos.");
		} else {
			String seleccionado = usuario.getSelectedItem().toString();
			switch (seleccionado) {
				case "Huesped":
					new InterfazHuesped();
					setVisible(false);
					break;
				case "Administrador":
					new InterfazAdministrador();
					setVisible(false);
					break;
				case "Empleado":
					new InterfazEmpleado();
					setVisible(false);
					break;
			}
		}
	}
}




	

}