package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaChance extends JFrame {

	/**
	 * La clase VentanaChance representa la interfaz gráfica para el juego de
	 * Chance.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private TextField pDiaApuesta, pValorApuesta, pNumeroApostado, pNombreLoteria;
	private JLabel diaApuestaTxt, valorApuestaTxt, numeroApostadoTxt, nombreLoteriaTxt;
	private JButton botonApostar, botonModificar, botonEliminar, flecha;

	/**
	 * Constructor de la clase VentanaChance. Inicializa y configura la interfaz
	 * gráfica.
	 */

	public VentanaChance() {

		setBounds(0, 0, 1080, 700);
		setTitle("Baloto");
		setResizable(false);
		setLayout(null);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVR.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		pDiaApuesta = new TextField();
		diaApuestaTxt = new JLabel();
		diaApuestaTxt.setBounds(40, 110, 400, 25);
		diaApuestaTxt.setText("Ingrese el dia de la apuesta:");
		pDiaApuesta.setBounds(40, 130, 350, 30);

		pValorApuesta = new TextField();
		valorApuestaTxt = new JLabel();
		valorApuestaTxt.setBounds(40, 290, 400, 25);
		valorApuestaTxt.setText("Ingrese el valor de la apuesta (No use comas ni puntos):");
		pValorApuesta.setBounds(40, 310, 350, 30);

		pNumeroApostado = new TextField();
		numeroApostadoTxt = new JLabel();
		numeroApostadoTxt.setBounds(40, 470, 550, 25);
		numeroApostadoTxt.setText("Inserte el número al cual quiere apostar (Ingrese 4 numeros):");
		pNumeroApostado.setBounds(40, 490, 350, 30);

		pNombreLoteria = new TextField();
		nombreLoteriaTxt = new JLabel();
		nombreLoteriaTxt.setBounds(530, 110, 400, 25);
		nombreLoteriaTxt.setText("Inserte el nombre de la Loteria:");
		pNombreLoteria.setBounds(530, 130, 350, 30);

		botonApostar = new JButton(new ImageIcon("src/images/RealizarApuestaBTN.png"));
		botonApostar.setBounds(555, 425, 280, 180);
		botonApostar.setOpaque(false);
		botonApostar.setContentAreaFilled(false);
		botonApostar.setBorderPainted(false);
		botonApostar.setVisible(false);

		botonModificar = new JButton(new ImageIcon("src/images/ModificarApuestaBTN.png"));
		botonModificar.setBounds(555, 425, 280, 180);
		botonModificar.setOpaque(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);
		botonModificar.setVisible(false);

		botonEliminar = new JButton(new ImageIcon("src/images/EliminarApuestaBTN.png"));
		botonEliminar.setBounds(555, 425, 280, 180);
		botonEliminar.setOpaque(false);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.setBorderPainted(false);
		botonEliminar.setVisible(false);

		flecha = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha.setBounds(5, 5, 75, 75);
		flecha.setOpaque(false);
		flecha.setContentAreaFilled(false);
		flecha.setBorderPainted(false);

		add(flecha);
		add(botonApostar);
		add(botonEliminar);
		add(botonModificar);
		add(pNombreLoteria);
		add(nombreLoteriaTxt);
		add(pDiaApuesta);
		add(diaApuestaTxt);
		add(pValorApuesta);
		add(valorApuestaTxt);
		add(pNumeroApostado);
		add(numeroApostadoTxt);
		add(fondo);

	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public TextField getpDiaApuesta() {
		return pDiaApuesta;
	}

	public void setpDiaApuesta(TextField pDiaApuesta) {
		this.pDiaApuesta = pDiaApuesta;
	}

	public TextField getpValorApuesta() {
		return pValorApuesta;
	}

	public void setpValorApuesta(TextField pValorApuesta) {
		this.pValorApuesta = pValorApuesta;
	}

	public TextField getpNumeroApostado() {
		return pNumeroApostado;
	}

	public void setpNumeroApostado(TextField pNumeroApostado) {
		this.pNumeroApostado = pNumeroApostado;
	}

	public TextField getpNombreLoteria() {
		return pNombreLoteria;
	}

	public void setpNombreLoteria(TextField pNombreLoteria) {
		this.pNombreLoteria = pNombreLoteria;
	}

	public JLabel getDiaApuestaTxt() {
		return diaApuestaTxt;
	}

	public void setDiaApuestaTxt(JLabel diaApuestaTxt) {
		this.diaApuestaTxt = diaApuestaTxt;
	}

	public JLabel getValorApuestaTxt() {
		return valorApuestaTxt;
	}

	public void setValorApuestaTxt(JLabel valorApuestaTxt) {
		this.valorApuestaTxt = valorApuestaTxt;
	}

	public JLabel getNumeroApostadoTxt() {
		return numeroApostadoTxt;
	}

	public void setNumeroApostadoTxt(JLabel numeroApostadoTxt) {
		this.numeroApostadoTxt = numeroApostadoTxt;
	}

	public JLabel getNombreLoteriaTxt() {
		return nombreLoteriaTxt;
	}

	public void setNombreLoteriaTxt(JLabel nombreLoteriaTxt) {
		this.nombreLoteriaTxt = nombreLoteriaTxt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getBotonApostar() {
		return botonApostar;
	}

	public void setBotonApostar(JButton botonApostar) {
		this.botonApostar = botonApostar;
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
