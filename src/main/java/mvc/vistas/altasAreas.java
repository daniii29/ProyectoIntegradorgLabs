package mvc.vistas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import BBDD.AccesoBBDD;
import mvc.control.altasAreasAñadir;
import mvc.control.altasAreasConsultas;
import mvc.control.altasAreasHome;
import mvc.control.homeAñadir;
import mvc.control.homeConsultas;

/**
 * esta es la clase vista que dará de alta las areas
 * 
 * @author alexjun09
 *
 */
public class altasAreas {

	private JFrame frame;
	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton buttonadd1;
	private JButton buttonadd2;
	private JButton buttonadd3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button1_1;

	// setters y getters habituales
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getButtonadd1() {
		return buttonadd1;
	}

	public void setButtonadd1(JButton buttonadd1) {
		this.buttonadd1 = buttonadd1;
	}

	public JButton getButtonadd2() {
		return buttonadd2;
	}

	public void setButtonadd2(JButton buttonadd2) {
		this.buttonadd2 = buttonadd2;
	}

	public JButton getButtonadd3() {
		return buttonadd3;
	}

	public void setButtonadd3(JButton buttonadd3) {
		this.buttonadd3 = buttonadd3;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public void setLblNewLabel_2(JLabel lblNewLabel_2) {
		this.lblNewLabel_2 = lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public void setLblNewLabel_3(JLabel lblNewLabel_3) {
		this.lblNewLabel_3 = lblNewLabel_3;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JButton getButton1_1() {
		return button1_1;
	}

	public void setButton1_1(JButton button1_1) {
		this.button1_1 = button1_1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	/**
	 * constructor del objeto altasAreas
	 */
	public altasAreas() {

		///////////////////// MENÚ Y FONDO/////////////////////////////77
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		frame = new JFrame("Añadir áreas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1350, 820);

		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {

				// Carga y dibuja la imagen de fondo
				ImageIcon imageIcon = new ImageIcon("Imagenes/AltasAreas.png");
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

		ImageIcon imagenAnadirIcon = new ImageIcon("Imagenes/agregar.png");
		Image resizedAnadirImage = imagenAnadirIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);

		button1_1 = new JButton("");
		button1_1.setBorderPainted(false);
		button1_1.setOpaque(false);
		button1_1.setFocusPainted(false);
		button1_1.setIcon(new ImageIcon(resizedAnadirImage));
		button1_1.setContentAreaFilled(false);

		button1_1.setBounds(1236, 556, 90, 78);

		frame.setContentPane(panel);
		panel.setLayout(null);

		panel.add(button1);

		panel.add(button1_1);
		panel.add(button2);
		panel.add(button3);

		JLabel lblNewLabel = new JLabel("ID Área:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel.setBounds(59, 431, 174, 62);
		panel.add(lblNewLabel);

		JLabel lblNExpediente = new JLabel("Descripción:");
		lblNExpediente.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNExpediente.setBounds(46, 528, 229, 62);
		panel.add(lblNExpediente);

		textField = new JTextField();
		textField.setBackground(new Color(211, 233, 250));
		textField.setBounds(192, 445, 319, 39);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(211, 233, 250));
		textField_1.setBounds(270, 539, 727, 108);
		panel.add(textField_1);

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

	/**
	 * metodo que hará la vista visible
	 */
	public void hacerVisible() {
		frame.setVisible(true);
	}

	/**
	 * metodo que se deshará del la vista
	 */
	public void dispose() {
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.setVisible(false);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a altas
	 * 
	 * @param x la vista altas
	 */
	public void setControlador1(altas x) {
		altasAreasAñadir escuchador = new altasAreasAñadir();
		escuchador.setVentanaUsuario(this, x);
		button2.addActionListener(escuchador);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá a consultas
	 * 
	 * @param x la vista home
	 */
	public void setControlador2(consultas x) {
		altasAreasConsultas escuchador2 = new altasAreasConsultas();
		escuchador2.setVentanaUsuario(this, x);
		button3.addActionListener(escuchador2);
	}

	/**
	 * metodo que creará una nuevo controlador (boton) que redigirá al home
	 * 
	 * @param x la vista home
	 */
	public void setControlador3(home x) {
		altasAreasHome escuchador2 = new altasAreasHome();
		escuchador2.setVentanaUsuario(this, x);
		button1.addActionListener(escuchador2);
	}

	/**
	 * metodo que cambia la vista a altas
	 * 
	 * @param a la vista altas
	 */
	public void setAltas(altas a) {
		// Boton que va a altas
		setControlador1(a);
	}

	/**
	 * metodo que cambia la vista a consultas
	 * 
	 * @param c la vista consultas
	 */
	public void setConsultas(consultas c) {
		// Boton que va a consultas
		setControlador2(c);
	}

	/**
	 * metodo que cambia la vista al gome
	 * 
	 * @param h
	 */
	public void setHome(home h) {
		// Boton que va a consultas
		setControlador3(h);

		final AccesoBBDD accesoBBDD = new AccesoBBDD(this);
		button1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insertar los datos en la tabla AREAS
				accesoBBDD.insertarDatosAreas();
			}
		});
	}
}
