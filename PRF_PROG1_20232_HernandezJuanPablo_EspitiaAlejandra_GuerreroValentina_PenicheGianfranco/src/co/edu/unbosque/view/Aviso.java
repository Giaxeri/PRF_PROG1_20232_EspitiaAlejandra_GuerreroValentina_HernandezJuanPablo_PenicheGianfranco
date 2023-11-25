package co.edu.unbosque.view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * La clase Aviso proporciona métodos para mostrar mensajes de información y
 * recibir datos del usuario a través de ventanas emergentes.
 */
public class Aviso {

	/**
	 * Constructor predeterminado de la clase Aviso.
	 */
	public Aviso() {

	}

	/**
	 * Muestra un mensaje de información simple en una ventana emergente.
	 *
	 * @param dato El mensaje de información a mostrar.
	 */
	public void mostrarInfo(String dato) {
		JOptionPane optionPane = new JOptionPane(dato, JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Aviso");
		dialog.setResizable(true);
		dialog.setVisible(true);
	}

	/**
	 * Muestra un mensaje de información largo en una ventana emergente con
	 * capacidad de desplazamiento.
	 *
	 * @param dato El mensaje de información largo a mostrar.
	 */
	public void mostrarInfoLarga(String dato) {
		JTextArea ta = new JTextArea(20, 30);
		ta.setText(dato);
		JOptionPane optionPane = new JOptionPane(new JScrollPane(ta), JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog("Aviso");
		dialog.setResizable(true);
		dialog.setVisible(true);
	}

	/**
	 * Muestra una ventana de entrada para que el usuario ingrese información.
	 *
	 * @param info El mensaje que indica qué tipo de información se espera.
	 * @return La información ingresada por el usuario.
	 */
	public String recibirInfo(String info) {
		return JOptionPane.showInputDialog(info);
	}

	/**
	 * Muestra una ventana con dos opciones para que el usuario elija.
	 *
	 * @param info    El mensaje que describe las opciones disponibles.
	 * @param opcion1 Texto de la primera opción.
	 * @param opcion2 Texto de la segunda opción.
	 * @return El índice de la opción seleccionada por el usuario (0 para la primera
	 *         opción, 1 para la segunda).
	 */
	public int elegirOpcionInfo(String info, String opcion1, String opcion2) {
		String[] options = { opcion1, opcion2 };
		return JOptionPane.showOptionDialog(null, info, "Click a button", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	}
	
}
