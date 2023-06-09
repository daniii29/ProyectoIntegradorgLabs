package mvc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mvc.modelo.datosAlumno;
import mvc.modelo.datosAreas;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaSignUp;
import mvc.vistas.buscarAlumnos;
import mvc.vistas.buscarArea;
import mvc.vistas.editarAlumnos;
import mvc.vistas.editarAreas;

/**
 * Clase que implementa actionListener y cambia de vistas de buscarArea a
 * editarArea
 * 
 * @author alexjun09
 *
 */
public class buscarAreaEditarArea implements ActionListener, ListSelectionListener {

	// declaramos la vista principal
	buscarArea ba;
	editarAreas ea;
	private boolean bandera;

	/**
	 * metodo que actualiza las vistas
	 * 
	 * @param buscarArea  vista buscarArea
	 * @param editarAreas vista editarArea
	 */
	public void setVentana(buscarArea buscarArea, editarAreas editarAreas) {
		ba = buscarArea;
		ea = editarAreas;
	}

	/**
	 * metodo que cambia de vistas dependiendo del valor de bandera
	 */
	public void actionPerformed(ActionEvent e) {
		if (bandera == true) {
			ba.dispose();
			ea.hacerVisible();
		}
	}

	/**
	 * metodo que cambia de vista y pone los datos del area en la nueva vista
	 */
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			// Obtener el índice de la fila seleccionada
			int selectedIndex = ba.datosAreas.getSelectedIndex();

			if (selectedIndex != -1) { // Se ha seleccionado una fila
				// Obtener los datos del alumno seleccionado
				datosAreas area = ba.datosAreas.getModel().getElementAt(selectedIndex);

				// Establecer los datos del alumno en los JTextFields de la ventana editarAreas
				ea.getTextField().setText(String.valueOf(area.getID_Area()));
				ea.getTextField_1().setText(String.valueOf(area.getDESCRIPCION()));

				// Ocultar la ventana buscarAlumnos
				ba.dispose();

				// Mostrar la ventana editarAreas
				ea.hacerVisible();
			}
		}
	}

}
