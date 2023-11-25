package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaLoteria extends JFrame {

	/**
	 * La clase VentanaLoteria representa la interfaz gráfica para el juego de
	 * lotería.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private TextField pDiaApuesta, pValorApuesta, pNombreLoteria, pNumeroApostado, pSerie;
	private JLabel diaApuestaTxt, valorApuestaTxt, nombreLoteriaTxt, numeroApostadoTxt, serieTxt;
	private JButton botonApostar, botonModificar, botonEliminar, flecha;

	/**
	 * Constructor de la clase VentanaLoteria. Inicializa y configura la interfaz
	 * gráfica.
	 */

	public VentanaLoteria() {

		setBounds(0, 0, 1080, 700);
		setTitle("Loteria");
		setResizable(false);
		setLayout(null);

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

		pNombreLoteria = new TextField();
		nombreLoteriaTxt = new JLabel();
		nombreLoteriaTxt.setBounds(40, 470, 400, 25);
		nombreLoteriaTxt.setText("Inserte el nombre de la loteria:");
		pNombreLoteria.setBounds(40, 490, 350, 30);

		pNumeroApostado = new TextField();
		numeroApostadoTxt = new JLabel();
		numeroApostadoTxt.setBounds(530, 110, 550, 25);
		numeroApostadoTxt.setText("Inserte el número al cual apostar (Ingrese 4 numeros):");
		pNumeroApostado.setBounds(530, 130, 350, 30);

		pSerie = new TextField();
		serieTxt = new JLabel();
		serieTxt.setBounds(530, 290, 400, 25);
		serieTxt.setText("Inserte la Serie (No use comas ni puntos):");
		pSerie.setBounds(530, 310, 350, 30);

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

		add(pDiaApuesta);
		add(diaApuestaTxt);
		add(pValorApuesta);
		add(valorApuestaTxt);
		add(pNombreLoteria);
		add(nombreLoteriaTxt);
		add(pNumeroApostado);
		add(numeroApostadoTxt);
		add(pSerie);
		add(serieTxt);
		add(botonApostar);
		add(botonEliminar);
		add(botonModificar);
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

	public TextField getpNombreLoteria() {
		return pNombreLoteria;
	}

	public void setpNombreLoteria(TextField pNombreLoteria) {
		this.pNombreLoteria = pNombreLoteria;
	}

	public TextField getpNumeroApostado() {
		return pNumeroApostado;
	}

	public void setpNumeroApostado(TextField pNumeroApostado) {
		this.pNumeroApostado = pNumeroApostado;
	}

	public TextField getpSerie() {
		return pSerie;
	}

	public void setpSerie(TextField pSerie) {
		this.pSerie = pSerie;
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

	public JLabel getNombreLoteriaTxt() {
		return nombreLoteriaTxt;
	}

	public void setNombreLoteriaTxt(JLabel nombreLoteriaTxt) {
		this.nombreLoteriaTxt = nombreLoteriaTxt;
	}

	public JLabel getNumeroApostadoTxt() {
		return numeroApostadoTxt;
	}

	public void setNumeroApostadoTxt(JLabel numeroApostadoTxt) {
		this.numeroApostadoTxt = numeroApostadoTxt;
	}

	public JLabel getSerieTxt() {
		return serieTxt;
	}

	public void setSerieTxt(JLabel serieTxt) {
		this.serieTxt = serieTxt;
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
