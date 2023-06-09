package mvc.vistas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import mvc.control.buscarAlumnoEditarAlumno;
import mvc.control.buscarPIAñadir;
import mvc.control.buscarPIConsultas;
import mvc.control.buscarPIEditarPI;
import mvc.control.buscarPIHome;
import mvc.control.consultasAltas;
import mvc.control.consultasHome;
import mvc.modelo.datosAlumno;
import mvc.modelo.datosAreas;
import mvc.modelo.datosPI;

/**
 * clase que contiene las vistas de buscarPI
 * 
 * @author alexjun09
 *
 */
public class buscarPI {
	private JFrame frame;
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel lblNewLabel_1;
	private JTextField txtHola;

	private JScrollPane scrollPane;
	public JList<datosPI> datosPI;

	private home h;
	private altas a;
	private consultas c;

	/**
	 * constructor del objeto buscarPI
	 */
	public buscarPI() {

		///////////////////// MENÚ Y FONDO/////////////////////////////77
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		frame = new JFrame("Consultar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 820);

		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {

				// Carga y dibuja la imagen de fondo
				ImageIcon imageIcon = new ImageIcon("Imagenes/FondoConsultaProyectos.png");
				Image image = imageIcon.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				setVisible(true);
				super.paintComponent(g);
			}
		};

		// Cambia el icono de la ventana de Java
		ImageIcon icon = new ImageIcon("Imagenes/7.png");
		frame.setIconImage(icon.getImage());

		ImageIcon imagenHome = new ImageIcon("Imagenes/home.png");
		Image resizedImage = imagenHome.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon imagenAdd = new ImageIcon("Imagenes/mas.png");
		Image resizedAdd = imagenAdd.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon imagenConsultar = new ImageIcon("Imagenes/buscar.png");
		Image resizedConsultar = imagenConsultar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

		button1 = new JButton("");
		button1.setBorderPainted(false);
		button1.setBounds(115, 677, 90, 78);
		button1.setIcon(new ImageIcon(resizedImage));
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setOpaque(false);

		button2 = new JButton("");
		button2.setBorderPainted(false);
		button2.setBounds(600, 677, 90, 78);
		button2.setIcon(new ImageIcon(resizedAdd));
		button2.setContentAreaFilled(false);
		button2.setFocusPainted(false);
		button2.setOpaque(false);

		button3 = new JButton("");
		button3.setBorderPainted(false);
		button3.setBounds(1085, 677, 90, 78);
		button3.setIcon(new ImageIcon(resizedConsultar));
		button3.setContentAreaFilled(false);
		button3.setFocusPainted(false);
		button3.setOpaque(false);

		frame.setContentPane(panel);
		panel.setLayout(null);

		// BOTONES DE BUSCAR
		ImageIcon imagenAnadir = new ImageIcon("Imagenes/lupa.png");
		Image resizedAnadir = imagenAnadir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		JScrollPane panelScroll2 = new JScrollPane();
		panelScroll2.setBounds(46,200,1054,437);
		frame.getContentPane().add(panelScroll2);
    
  
	
		
		datosPI = new JList<datosPI>();
		panelScroll2.setViewportView(datosPI);
		panelScroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		datosPI.setFont(new Font("Verdana", Font.PLAIN, 18));
    
	

	}

	private DefaultListModel<datosPI> modeloPI; // Agrega esta variable de instancia

	/**
	 * 
	 * @param listaPI
	 */
	public void setListaPI(ArrayList<datosPI> listaPI) {
		if (modeloPI == null) {
			modeloPI = new DefaultListModel<datosPI>();
			datosPI.setModel(modeloPI);
		}

		modeloPI.clear();
		modeloPI.addAll(listaPI);
	}

	/**
	 * metodo que hará la vista visible
	 */
	public void hacerVisible() {
		frame.setVisible(true);
	}

	/**
	 * metodo que se deshará de la vista
	 */
	public void dispose() {
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.setVisible(false);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a home
	 * 
	 * @param x la vista home
	 */
	public void setControlador(home x) {
		buscarPIHome escuchador = new buscarPIHome();
		escuchador.setVentanaUsuario(this, x);
		button1.addActionListener(escuchador);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a altas
	 * 
	 * @param x la vista alta
	 */
	public void setControlador2(altas x) {
		buscarPIAñadir escuchador = new buscarPIAñadir();
		escuchador.setVentanaUsuario(this, x);
		button2.addActionListener(escuchador);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a consultas
	 * 
	 * @param x la vista consultas
	 */
	public void setControlador3(consultas x) {
		buscarPIConsultas escuchador = new buscarPIConsultas();
		escuchador.setVentanaUsuario(this, x);
		button3.addActionListener(escuchador);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a editarPI
	 * 
	 * @param x la vista editarPI
	 */
	public void setControlador4(editarPI x) {
		buscarPIEditarPI escuchador = new buscarPIEditarPI();
		escuchador.setVentana(this, x);
		datosPI.addListSelectionListener(escuchador);
	}

	/**
	 * metodo que cambia de vista a editar pi
	 * 
	 * @param editarPI la vista editarPI
	 */
	public void setEditarPI(editarPI editarPI) {
		setControlador4(editarPI);
	}

	/**
	 * metodo que cambia de vista a altas
	 * 
	 * @param altas la vista altas
	 */
	public void setAltas(altas altas) {
		a = altas;
		// boton que va a altas
		setControlador2(a);
	}

	/**
	 * metodo que cambia la vista al home
	 * 
	 * @param home la vista home
	 */
	public void setHome(home home) {
		h = home;
		// boton que vuelve a home
		setControlador(h);
	}

	/**
	 * metodo que cambia la vista a consultas
	 * 
	 * @param consultas la vista consultas
	 */
	public void setConsultas(consultas consultas) {
		c = consultas;
		setControlador3(c);
	}

	/**
	 * getter del boton 1
	 * 
	 * @return button1 el boton 1
	 */
	public JButton getButton1() {
		return button1;
	}

	/**
	 * getter del boton 2
	 * 
	 * @return button2 el boton 2
	 */
	public JButton getButton2() {
		return button2;
	}

	/**
	 * getter del boton 3
	 * 
	 * @return button3 el boton 3
	 */
	public JButton getButton3() {
		return button3;
	}
}
