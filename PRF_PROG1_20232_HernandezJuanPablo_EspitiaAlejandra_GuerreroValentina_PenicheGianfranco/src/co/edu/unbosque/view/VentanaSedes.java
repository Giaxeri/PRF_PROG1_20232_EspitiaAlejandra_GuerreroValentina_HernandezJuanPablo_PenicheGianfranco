package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VentanaSedes extends JFrame {

	/**
	 * La clase VentanaSedes representa la interfaz gráfica para gestionar sedes de
	 * la casa de apuestas.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JButton botonSedes, botonModificarSedes, botonFinalizar, botonEliminarSede, botonLlenarSedes;
	private TextField localidadAModificarField, localidadField, empleadosField;
	private JLabel localidadTxt, empleadosTxt, localidadAModificarTxt;
	private JTextArea sedesActuales;

	public VentanaSedes() {
		/**
		 * Constructor de la clase VentanaSedes. Inicializa y configura la interfaz
		 * gráfica.
		 */

		setBounds(0, 0, 1080, 700);
		setTitle("Sedes");
		setResizable(false);
		setLayout(null);

		sedesActuales = new JTextArea(20, 30);
		sedesActuales.setBounds(600, 130, 300, 300);
		sedesActuales.setEditable(false);
		sedesActuales.setOpaque(false);

		localidadField = new TextField();
		localidadField.setBounds(40, 130, 350, 30);
		localidadTxt = new JLabel();
		localidadTxt.setText("Introduzca la localidad de la sede:");
		localidadTxt.setBounds(40, 110, 400, 25);

		localidadAModificarField = new TextField();
		localidadAModificarField.setBounds(40, 130, 350, 30);
		localidadAModificarTxt = new JLabel();
		localidadAModificarTxt.setText("Introduzca la localidad de la sede:");
		localidadAModificarTxt.setBounds(40, 110, 400, 25);
		localidadAModificarField.setVisible(false);
		localidadAModificarTxt.setVisible(false);

		empleadosField = new TextField();
		empleadosField.setBounds(40, 310, 350, 30);
		empleadosTxt = new JLabel();
		empleadosTxt.setText("Introduzca la cantidad de empleados de la sede (No use comas ni puntos): ");
		empleadosTxt.setBounds(40, 290, 450, 25);

		botonSedes = new JButton(new ImageIcon("src/images/RegistrarEmp.png"));
		botonSedes.setBounds(65, 425, 280, 180);
		botonSedes.setOpaque(false);
		botonSedes.setContentAreaFilled(false);
		botonSedes.setBorderPainted(false);

		botonLlenarSedes = new JButton(new ImageIcon("src/images/RegistrarEmp.png"));
		botonLlenarSedes.setBounds(65, 425, 280, 180);
		botonLlenarSedes.setOpaque(false);
		botonLlenarSedes.setContentAreaFilled(false);
		botonLlenarSedes.setBorderPainted(false);
		botonLlenarSedes.setVisible(false);

		botonModificarSedes = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificarSedes.setBounds(65, 425, 280, 180);
		botonModificarSedes.setOpaque(false);
		botonModificarSedes.setContentAreaFilled(false);
		botonModificarSedes.setBorderPainted(false);
		botonModificarSedes.setVisible(false);

		botonEliminarSede = new JButton(new ImageIcon("src/images/EliminarBTN.png"));
		botonEliminarSede.setBounds(65, 425, 280, 180);
		botonEliminarSede.setOpaque(false);
		botonEliminarSede.setContentAreaFilled(false);
		botonEliminarSede.setBorderPainted(false);
		botonEliminarSede.setVisible(false);

		botonFinalizar = new JButton(new ImageIcon("src/images/FinalizarBTN.png"));
		botonFinalizar.setBounds(600, 425, 280, 180);
		botonFinalizar.setOpaque(false);
		botonFinalizar.setContentAreaFilled(false);
		botonFinalizar.setBorderPainted(false);
		botonFinalizar.setVisible(false);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVR.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		add(sedesActuales);
		add(botonSedes);
		add(botonLlenarSedes);
		add(botonModificarSedes);
		add(botonEliminarSede);
		add(botonFinalizar);
		add(localidadField);
		add(localidadTxt);
		add(localidadAModificarField);
		add(localidadAModificarTxt);
		add(empleadosField);
		add(empleadosTxt);

		add(fondo);

	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBotonSedes() {
		return botonSedes;
	}

	public void setBotonSedes(JButton botonSedes) {
		this.botonSedes = botonSedes;
	}

	public TextField getLocalidadField() {
		return localidadField;
	}

	public void setLocalidadField(TextField localidadField) {
		this.localidadField = localidadField;
	}

	public TextField getEmpleadosField() {
		return empleadosField;
	}

	public void setEmpleadosField(TextField empleadosField) {
		this.empleadosField = empleadosField;
	}

	public JLabel getLocalidadTxt() {
		return localidadTxt;
	}

	public void setLocalidadTxt(JLabel localidadTxt) {
		this.localidadTxt = localidadTxt;
	}

	public JLabel getEmpleadosTxt() {
		return empleadosTxt;
	}

	public void setEmpleadosTxt(JLabel empleadosTxt) {
		this.empleadosTxt = empleadosTxt;
	}

	public TextField getLocalidadAModificarField() {
		return localidadAModificarField;
	}

	public void setLocalidadAModificarField(TextField localidadAModificarField) {
		this.localidadAModificarField = localidadAModificarField;
	}

	public JLabel getLocalidadAModificarTxt() {
		return localidadAModificarTxt;
	}

	public void setLocalidadAModificarTxt(JLabel localidadAModificarTxt) {
		this.localidadAModificarTxt = localidadAModificarTxt;
	}

	public JButton getBotonModificarSedes() {
		return botonModificarSedes;
	}

	public void setBotonModificarSedes(JButton botonModificarSedes) {
		this.botonModificarSedes = botonModificarSedes;
	}

	public JButton getBotonFinalizar() {
		return botonFinalizar;
	}

	public void setBotonFinalizar(JButton botonFinalizar) {
		this.botonFinalizar = botonFinalizar;
	}

	public JButton getBotonEliminarSede() {
		return botonEliminarSede;
	}

	public void setBotonEliminarSede(JButton botonEliminarSede) {
		this.botonEliminarSede = botonEliminarSede;
	}

	public JButton getBotonLlenarSedes() {
		return botonLlenarSedes;
	}

	public void setBotonLlenarSedes(JButton botonLlenarSedes) {
		this.botonLlenarSedes = botonLlenarSedes;
	}

	public JTextArea getSedesActuales() {
		return sedesActuales;
	}

	public void setSedesActuales(JTextArea sedesActuales) {
		this.sedesActuales = sedesActuales;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
