package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * La clase VentanaApostador representa la interfaz gráfica para el registro de
 * apostadores.
 */

public class VentanaApostador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JLabel nombreTxt, nombreAModificarTxt, cedulaTxt, sedeTxt, direccionTxt, celularTxt;
	private TextField nombreField, nombreAModificarField, cedulaField, sedeField, direccionField, celularField;
	private JButton botonCrear, botonModificar, botonEliminar, flecha;

	public JButton getBotonCrear() {
		return botonCrear;
	}

	public void setBotonCrear(JButton botonCrear) {
		this.botonCrear = botonCrear;
	}

	public VentanaApostador() {

		/**
		 * Constructor de la clase VentanaApostador. Inicializa y configura la interfaz
		 * gráfica.
		 */

		setBounds(0, 0, 1080, 700);
		setTitle("Registro Apostador");
		setResizable(false);
		setLayout(null);

		nombreAModificarField = new TextField();
		nombreAModificarTxt = new JLabel();
		nombreAModificarTxt.setBounds(40, 150, 400, 25);
		nombreAModificarTxt.setText("Nombre del apostador a modificar:");
		nombreAModificarField.setBounds(40, 170, 350, 30);
		nombreAModificarField.setVisible(false);
		nombreAModificarTxt.setVisible(false);

		nombreField = new TextField();
		nombreTxt = new JLabel();
		nombreTxt.setBounds(40, 110, 400, 25);
		nombreTxt.setText("Nombre del apostador:");
		nombreField.setBounds(40, 130, 350, 30);

		cedulaField = new TextField();
		cedulaTxt = new JLabel();
		cedulaTxt.setBounds(40, 290, 400, 25);
		cedulaTxt.setText("Número de Cédula(No use comas ni puntos): ");
		cedulaField.setBounds(40, 310, 350, 30);

		sedeField = new TextField();
		sedeTxt = new JLabel();
		sedeTxt.setBounds(40, 470, 400, 25);
		sedeTxt.setText("Sede del Apostador:");
		sedeField.setBounds(40, 490, 350, 30);

		direccionField = new TextField();
		direccionTxt = new JLabel();
		direccionTxt.setBounds(530, 110, 400, 25);
		direccionTxt.setText("Dirección del apostador:");
		direccionField.setBounds(530, 130, 350, 30);

		celularField = new TextField();
		celularTxt = new JLabel();
		celularTxt.setBounds(530, 290, 400, 25);
		celularTxt.setText("Número de Teléfono (No use comas ni puntos):");
		celularField.setBounds(530, 310, 350, 30);

		botonCrear = new JButton(new ImageIcon("src/images/CrearAptBtn.png"));
		botonCrear.setBounds(555, 425, 280, 180);
		botonCrear.setOpaque(false);
		botonCrear.setContentAreaFilled(false);
		botonCrear.setBorderPainted(false);

		botonModificar = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificar.setBounds(555, 425, 280, 180);
		botonModificar.setOpaque(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);
		botonModificar.setVisible(false);

		botonEliminar = new JButton(new ImageIcon("src/images/EliminarBTN.png"));
		botonEliminar.setBounds(555, 425, 280, 180);
		botonEliminar.setOpaque(false);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.setBorderPainted(false);
		botonEliminar.setVisible(false);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVR.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		flecha = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha.setBounds(5, 5, 75, 75);
		flecha.setOpaque(false);
		flecha.setContentAreaFilled(false);
		flecha.setBorderPainted(false);
		add(flecha);
		add(botonCrear);
		add(botonEliminar);
		add(botonModificar);
		add(nombreField);
		add(nombreTxt);
		add(nombreAModificarField);
		add(nombreAModificarTxt);
		add(nombreTxt);
		add(cedulaField);
		add(cedulaTxt);
		add(sedeField);
		add(sedeTxt);
		add(direccionField);
		add(direccionTxt);
		add(celularField);
		add(celularTxt);

		add(fondo);

	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JLabel getNombreTxt() {
		return nombreTxt;
	}

	public void setNombreTxt(JLabel nombreTxt) {
		this.nombreTxt = nombreTxt;
	}

	public JLabel getCedulaTxt() {
		return cedulaTxt;
	}

	public void setCedulaTxt(JLabel cedulaTxt) {
		this.cedulaTxt = cedulaTxt;
	}

	public JLabel getSedeTxt() {
		return sedeTxt;
	}

	public void setSedeTxt(JLabel sedeTxt) {
		this.sedeTxt = sedeTxt;
	}

	public JLabel getDireccionTxt() {
		return direccionTxt;
	}

	public void setDireccionTxt(JLabel direccionTxt) {
		this.direccionTxt = direccionTxt;
	}

	public JLabel getCelularTxt() {
		return celularTxt;
	}

	public void setCelularTxt(JLabel celularTxt) {
		this.celularTxt = celularTxt;
	}

	public TextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(TextField nombreField) {
		this.nombreField = nombreField;
	}

	public TextField getCedulaField() {
		return cedulaField;
	}

	public void setCedulaField(TextField cedulaField) {
		this.cedulaField = cedulaField;
	}

	public TextField getSedeField() {
		return sedeField;
	}

	public void setSedeField(TextField sedeField) {
		this.sedeField = sedeField;
	}

	public TextField getDireccionField() {
		return direccionField;
	}

	public void setDireccionField(TextField direccionField) {
		this.direccionField = direccionField;
	}

	public TextField getCelularField() {
		return celularField;
	}

	public void setCelularField(TextField celularField) {
		this.celularField = celularField;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getNombreAModificarTxt() {
		return nombreAModificarTxt;
	}

	public void setNombreAModificarTxt(JLabel nombreAModificarTxt) {
		this.nombreAModificarTxt = nombreAModificarTxt;
	}

	public TextField getNombreAModificarField() {
		return nombreAModificarField;
	}

	public void setNombreAModificarField(TextField nombreAModificarField) {
		this.nombreAModificarField = nombreAModificarField;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}

	public void setBotonEliminar(JButton botonEliminar) {
		this.botonEliminar = botonEliminar;
	}

	public JButton getFlecha() {
		return flecha;
	}

	public void setFlecha(JButton flecha) {
		this.flecha = flecha;
	}

}
