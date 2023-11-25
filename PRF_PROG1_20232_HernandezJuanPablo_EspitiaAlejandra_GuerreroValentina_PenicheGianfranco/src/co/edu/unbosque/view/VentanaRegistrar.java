package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaRegistrar extends JFrame {

	/**
	 * La clase VentanaRegistrar representa la interfaz gráfica para el registro de
	 * la casa de apuestas.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JButton flecha, botonCrear, botonModificar, flecha2;
	private TextField nombreCasaField;
	private TextField cantidadSedesField;
	private TextField presupuestoTotalField;
	private JLabel nombreCasaTxt;
	private JLabel cantidadSedesTxt;
	private JLabel presupuestoTotalTxt;
	private JLabel txt1, txt2, txt3, txt4, txt5, txt6;

	/**
	 * Constructor de la clase VentanaRegistrar. Inicializa y configura la interfaz
	 * gráfica.
	 */
	public VentanaRegistrar() {

		setBounds(0, 0, 1080, 700);
		setTitle("Registro");
		setResizable(false);
		setLayout(null);

		nombreCasaField = new TextField();
		nombreCasaTxt = new JLabel();
		nombreCasaTxt.setBounds(40, 110, 300, 25);
		nombreCasaTxt.setText("Inserte el nombre de la casa de apuestas: ");
		nombreCasaField.setBounds(40, 130, 350, 30);

		cantidadSedesField = new TextField();
		cantidadSedesTxt = new JLabel();
		cantidadSedesTxt.setBounds(40, 290, 450, 25);
		cantidadSedesTxt.setText("Inserte la cantidad de sedes de la casa de apuestas (No use comas ni puntos): ");
		cantidadSedesField.setBounds(40, 310, 350, 30);

		presupuestoTotalField = new TextField();
		presupuestoTotalTxt = new JLabel();
		presupuestoTotalTxt.setBounds(40, 470, 445, 25);
		presupuestoTotalTxt.setText("Inserte el presupuesto total de la casa de apuestas (No use comas ni puntos): ");
		presupuestoTotalField.setBounds(40, 490, 350, 25);

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

		txt1 = new JLabel();
		txt1.setBounds(450, 120, 600, 25);
		txt1.setText("A continuación, ingresará la información de los juegos de su casa de apuestas;");
		txt1.setFont(new Font("", Font.PLAIN, 17));

		txt2 = new JLabel();
		txt2.setBounds(450, 140, 600, 25);
		txt2.setText("Es necesario recordar que debe tener en total 5 juegos, ");
		txt2.setFont(new Font("", Font.PLAIN, 17));

		txt5 = new JLabel();
		txt5.setBounds(450, 160, 600, 25);
		txt5.setText("usted definirá el presupuesto asignado a su juego.");
		txt5.setFont(new Font("", Font.PLAIN, 17));

		txt3 = new JLabel();
		txt3.setBounds(450, 180, 600, 25);
		txt3.setText("Los juegos son: Loteria, Baloto, Superastro, Betplay, Chance");
		txt3.setFont(new Font("", Font.PLAIN, 17));

		txt4 = new JLabel();
		txt4.setBounds(450, 200, 600, 25);
		txt4.setText("Recordar que la suma de los presupuestos por juego no debe exceder");
		txt4.setFont(new Font("", Font.PLAIN, 17));

		txt6 = new JLabel();
		txt6.setBounds(450, 220, 600, 25);
		txt6.setText("al presupuesto total.");
		txt6.setFont(new Font("", Font.PLAIN, 17));

		botonCrear = new JButton(new ImageIcon("src/images/CrearBoton.png"));
		botonCrear.setBounds(555, 375, 280, 180);
		botonCrear.setOpaque(false);
		botonCrear.setContentAreaFilled(false);
		botonCrear.setBorderPainted(false);

		botonModificar = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificar.setBounds(555, 375, 280, 180);
		botonModificar.setOpaque(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);
		botonModificar.setVisible(false);

		flecha2 = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha2.setBounds(5, 5, 75, 75);
		flecha2.setOpaque(false);
		flecha2.setContentAreaFilled(false);
		flecha2.setBorderPainted(false);

		add(flecha2);
		add(botonCrear);
		add(botonModificar);
		add(txt6);
		add(txt5);
		add(txt4);
		add(txt3);
		add(txt2);
		add(txt1);
		add(presupuestoTotalField);
		add(presupuestoTotalTxt);
		add(cantidadSedesField);
		add(cantidadSedesTxt);
		add(nombreCasaField);
		add(nombreCasaTxt);
		add(flecha);

		add(fondo);

	}

	// Métodos getter y setter
	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getFlecha() {
		return flecha;
	}

	public void setFlecha(JButton flecha) {
		this.flecha = flecha;
	}

	public JButton getBotonCrear() {
		return botonCrear;
	}

	public void setBotonCrear(JButton botonCrear) {
		this.botonCrear = botonCrear;
	}

	public TextField getNombreCasaField() {
		return nombreCasaField;
	}

	public void setNombreCasaField(TextField nombreCasaField) {
		this.nombreCasaField = nombreCasaField;
	}

	public TextField getCantidadSedesField() {
		return cantidadSedesField;
	}

	public void setCantidadSedesField(TextField cantidadSedesField) {
		this.cantidadSedesField = cantidadSedesField;
	}

	public TextField getPresupuestoTotalField() {
		return presupuestoTotalField;
	}

	public void setPresupuestoTotalField(TextField presupuestoTotalField) {
		this.presupuestoTotalField = presupuestoTotalField;
	}

	public JLabel getNombreCasaTxt() {
		return nombreCasaTxt;
	}

	public void setNombreCasaTxt(JLabel nombreCasaTxt) {
		this.nombreCasaTxt = nombreCasaTxt;
	}

	public JLabel getCantidadSedesTxt() {
		return cantidadSedesTxt;
	}

	public void setCantidadSedesTxt(JLabel cantidadSedesTxt) {
		this.cantidadSedesTxt = cantidadSedesTxt;
	}

	public JLabel getPresupuestoTotalTxt() {
		return presupuestoTotalTxt;
	}

	public void setPresupuestoTotalTxt(JLabel presupuestoTotalTxt) {
		this.presupuestoTotalTxt = presupuestoTotalTxt;
	}

	public JLabel getTxt1() {
		return txt1;
	}

	public void setTxt1(JLabel txt1) {
		this.txt1 = txt1;
	}

	public JLabel getTxt2() {
		return txt2;
	}

	public void setTxt2(JLabel txt2) {
		this.txt2 = txt2;
	}

	public JLabel getTxt3() {
		return txt3;
	}

	public void setTxt3(JLabel txt3) {
		this.txt3 = txt3;
	}

	public JLabel getTxt4() {
		return txt4;
	}

	public void setTxt4(JLabel txt4) {
		this.txt4 = txt4;
	}

	public JLabel getTxt5() {
		return txt5;
	}

	public void setTxt5(JLabel txt5) {
		this.txt5 = txt5;
	}

	public JLabel getTxt6() {
		return txt6;
	}

	public void setTxt6(JLabel txt6) {
		this.txt6 = txt6;
	}

	public JButton getFlecha2() {
		return flecha2;
	}

	public void setFlecha2(JButton flecha2) {
		this.flecha2 = flecha2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
