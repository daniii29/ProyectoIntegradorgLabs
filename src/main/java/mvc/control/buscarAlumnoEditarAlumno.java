package mvc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import mvc.modelo.datosAlumno;
import mvc.vistas.VistaPrincipal;
import mvc.vistas.VistaSignUp;
import mvc.vistas.buscarAlumnos;
import mvc.vistas.editarAlumnos;

public class buscarAlumnoEditarAlumno implements ActionListener, ListSelectionListener {

	// declaramos la vista principal
	buscarAlumnos ba;
	editarAlumnos ea;
	private boolean bandera;

	public void setVentana(buscarAlumnos buscarAlumnos, editarAlumnos editarAlumnos) {
		ba = buscarAlumnos;
		ea = editarAlumnos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(bandera==true) {
			 ba.dispose();
			 ea.hacerVisible();
		 }
    }

	@Override
	public void valueChanged(ListSelectionEvent e) {
        if (e != null && !e.getValueIsAdjusting()) {
            bandera = true;
        }
    }

}
