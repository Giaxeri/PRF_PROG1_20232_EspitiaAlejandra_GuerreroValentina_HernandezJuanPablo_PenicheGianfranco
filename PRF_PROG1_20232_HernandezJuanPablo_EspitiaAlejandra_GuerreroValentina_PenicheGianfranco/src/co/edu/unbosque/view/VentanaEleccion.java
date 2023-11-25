package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEleccion extends JFrame {

	/**
	 * La clase VentanaEleccion representa la interfaz gráfica para el menú
	 * principal.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JButton flecha, flecha2, flecha3, botonModificar, botonReportes, botonApostadores, botonCasaApuestas,
			botonApostador, botonModificarApostador, botonLeerApostador, botonEliminarApostador, botonApuesta,
			botonCrearApuesta, botonModificarApuesta, botonLeerApuestas, botonEliminarApuestas, botonLoteria,
			botonBaloto, botonSuperastro, botonBetplay, botonChance;

	/**
	 * Constructor de la clase VentanaEleccion. Inicializa y configura la interfaz
	 * gráfica.
	 */

	public VentanaEleccion() {

		setBounds(0, 0, 1080, 700);
		setTitle("Menú Principal");
		setResizable(false);
		setLayout(null);

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
		flecha2 = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha2.setBounds(5, 5, 75, 75);
		flecha2.setOpaque(false);
		flecha2.setContentAreaFilled(false);
		flecha2.setBorderPainted(false);
		flecha2.setVisible(false);
		flecha3 = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha3.setBounds(5, 5, 75, 75);
		flecha3.setOpaque(false);
		flecha3.setContentAreaFilled(false);
		flecha3.setBorderPainted(false);
		flecha3.setVisible(false);
		botonModificar = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificar.setBounds(215, 225, 290, 180);
		botonModificar.setOpaque(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);

		botonApostadores = new JButton(new ImageIcon("src/images/CrearApostadorBtn.png"));
		botonApostadores.setBounds(605, 225, 290, 180);
		botonApostadores.setOpaque(false);
		botonApostadores.setContentAreaFilled(false);
		botonApostadores.setBorderPainted(false);

		botonCasaApuestas = new JButton(new ImageIcon("src/images/CasaApuestasBTN.png"));
		botonCasaApuestas.setBounds(215, 225, 290, 180);
		botonCasaApuestas.setOpaque(false);
		botonCasaApuestas.setContentAreaFilled(false);
		botonCasaApuestas.setBorderPainted(false);
		botonCasaApuestas.setVisible(false);

		botonApostador = new JButton(new ImageIcon("src/images/SoyApostadorBTN.png"));
		botonApostador.setBounds(605, 225, 290, 180);
		botonApostador.setOpaque(false);
		botonApostador.setContentAreaFilled(false);
		botonApostador.setBorderPainted(false);
		botonApostador.setVisible(false);

		botonReportes = new JButton(new ImageIcon("src/images/GenerarRepBTN.png"));
		botonReportes.setBounds(605, 225, 290, 180);
		botonReportes.setOpaque(false);
		botonReportes.setContentAreaFilled(false);
		botonReportes.setBorderPainted(false);
		botonReportes.setVisible(false);

		botonModificarApostador = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificarApostador.setBounds(100, 400, 290, 180);
		botonModificarApostador.setOpaque(false);
		botonModificarApostador.setContentAreaFilled(false);
		botonModificarApostador.setBorderPainted(false);
		botonModificarApostador.setVisible(false);

		botonLeerApostador = new JButton(new ImageIcon("src/images/LeerApostadorBTN.png"));
		botonLeerApostador.setBounds(605, 180, 290, 180);
		botonLeerApostador.setOpaque(false);
		botonLeerApostador.setContentAreaFilled(false);
		botonLeerApostador.setBorderPainted(false);
		botonLeerApostador.setVisible(false);

		botonEliminarApostador = new JButton(new ImageIcon("src/images/EliminarBTN.png"));
		botonEliminarApostador.setBounds(380, 400, 290, 180);
		botonEliminarApostador.setOpaque(false);
		botonEliminarApostador.setContentAreaFilled(false);
		botonEliminarApostador.setBorderPainted(false);
		botonEliminarApostador.setVisible(false);

		botonApuesta = new JButton(new ImageIcon("src/images/ApuestasBTN.png"));
		botonApuesta.setBounds(660, 400, 290, 180);
		botonApuesta.setOpaque(false);
		botonApuesta.setContentAreaFilled(false);
		botonApuesta.setBorderPainted(false);
		botonApuesta.setVisible(false);

		botonApostadores = new JButton(new ImageIcon("src/images/CrearApostadorBtn.png"));
		botonApostadores.setBounds(605, 225, 290, 180);
		botonApostadores.setOpaque(false);
		botonApostadores.setContentAreaFilled(false);
		botonApostadores.setBorderPainted(false);

		botonCasaApuestas = new JButton(new ImageIcon("src/images/CasaApuestasBTN.png"));
		botonCasaApuestas.setBounds(215, 225, 290, 180);
		botonCasaApuestas.setOpaque(false);
		botonCasaApuestas.setContentAreaFilled(false);
		botonCasaApuestas.setBorderPainted(false);
		botonCasaApuestas.setVisible(false);

		botonCrearApuesta = new JButton(new ImageIcon("src/images/RealizarApuestaBTN.png"));
		botonCrearApuesta.setBounds(200, 180, 290, 180);
		botonCrearApuesta.setOpaque(false);
		botonCrearApuesta.setContentAreaFilled(false);
		botonCrearApuesta.setBorderPainted(false);
		botonCrearApuesta.setVisible(false);

		botonLeerApuestas = new JButton(new ImageIcon("src/images/LeerApuestaBTN.png"));
		botonLeerApuestas.setBounds(605, 180, 290, 180);
		botonLeerApuestas.setOpaque(false);
		botonLeerApuestas.setContentAreaFilled(false);
		botonLeerApuestas.setBorderPainted(false);
		botonLeerApuestas.setVisible(false);

		botonModificarApuesta = new JButton(new ImageIcon("src/images/ModificarApuestaBTN.png"));
		botonModificarApuesta.setBounds(200, 400, 290, 180);
		botonModificarApuesta.setOpaque(false);
		botonModificarApuesta.setContentAreaFilled(false);
		botonModificarApuesta.setBorderPainted(false);
		botonModificarApuesta.setVisible(false);

		botonEliminarApuestas = new JButton(new ImageIcon("src/images/EliminarApuestaBTN.png"));
		botonEliminarApuestas.setBounds(605, 400, 290, 180);
		botonEliminarApuestas.setOpaque(false);
		botonEliminarApuestas.setContentAreaFilled(false);
		botonEliminarApuestas.setBorderPainted(false);
		botonEliminarApuestas.setVisible(false);

		botonApostadores = new JButton(new ImageIcon("src/images/CrearApostadorBtn.png"));
		botonApostadores.setBounds(200, 180, 290, 180);
		botonApostadores.setOpaque(false);
		botonApostadores.setContentAreaFilled(false);
		botonApostadores.setBorderPainted(false);

		botonLoteria = new JButton(new ImageIcon("src/images/LoteriaBTN.png"));
		botonLoteria.setBounds(100, 180, 290, 180);
		botonLoteria.setOpaque(false);
		botonLoteria.setContentAreaFilled(false);
		botonLoteria.setBorderPainted(false);
		botonLoteria.setVisible(false);

		botonBaloto = new JButton(new ImageIcon("src/images/BalotoBTN.png"));
		botonBaloto.setBounds(605, 180, 290, 180);
		botonBaloto.setOpaque(false);
		botonBaloto.setContentAreaFilled(false);
		botonBaloto.setBorderPainted(false);
		botonBaloto.setVisible(false);

		botonSuperastro = new JButton(new ImageIcon("src/images/SuperastroBTN.png"));
		botonSuperastro.setBounds(100, 400, 290, 180);
		botonSuperastro.setOpaque(false);
		botonSuperastro.setContentAreaFilled(false);
		botonSuperastro.setBorderPainted(false);
		botonSuperastro.setVisible(false);

		botonBetplay = new JButton(new ImageIcon("src/images/BetplayBTN.png"));
		botonBetplay.setBounds(380, 400, 290, 180);
		botonBetplay.setOpaque(false);
		botonBetplay.setContentAreaFilled(false);
		botonBetplay.setBorderPainted(false);
		botonBetplay.setVisible(false);

		botonChance = new JButton(new ImageIcon("src/images/ChanceBTN.png"));
		botonChance.setBounds(660, 400, 290, 180);
		botonChance.setOpaque(false);
		botonChance.setContentAreaFilled(false);
		botonChance.setBorderPainted(false);
		botonChance.setVisible(false);

		add(flecha);
		add(flecha2);
		add(flecha3);
		add(botonApostadores);
		add(botonModificar);
		add(botonCasaApuestas);
		add(botonApostador);
		add(botonReportes);
		add(botonModificarApostador);
		add(botonLeerApostador);
		add(botonEliminarApostador);
		add(botonApuesta);
		add(botonCrearApuesta);
		add(botonLeerApuestas);
		add(botonModificarApuesta);
		add(botonEliminarApuestas);
		add(botonLoteria);
		add(botonBaloto);
		add(botonSuperastro);
		add(botonBetplay);
		add(botonChance);

		add(fondo);

	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public JButton getBotonApostadores() {
		return botonApostadores;
	}

	public void setBotonApostadores(JButton botonApostadores) {
		this.botonApostadores = botonApostadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getFlecha() {
		return flecha;
	}

	public void setFlecha(JButton flecha) {
		this.flecha = flecha;
	}

	public JButton getBotonReportes() {
		return botonReportes;
	}

	public void setBotonReportes(JButton botonReportes) {
		this.botonReportes = botonReportes;
	}

	public JButton getBotonCasaApuestas() {
		return botonCasaApuestas;
	}

	public void setBotonCasaApuestas(JButton botonCasaApuestas) {
		this.botonCasaApuestas = botonCasaApuestas;
	}

	public JButton getBotonApostador() {
		return botonApostador;
	}

	public void setBotonApostador(JButton botonApostador) {
		this.botonApostador = botonApostador;
	}

	public JButton getBotonModificarApostador() {
		return botonModificarApostador;
	}

	public void setBotonModificarApostador(JButton botonModificarApostador) {
		this.botonModificarApostador = botonModificarApostador;
	}

	public JButton getBotonLeerApostador() {
		return botonLeerApostador;
	}

	public void setBotonLeerApostador(JButton botonLeerApostador) {
		this.botonLeerApostador = botonLeerApostador;
	}

	public JButton getBotonEliminarApostador() {
		return botonEliminarApostador;
	}

	public void setBotonEliminarApostador(JButton botonEliminarApostador) {
		this.botonEliminarApostador = botonEliminarApostador;
	}

	public JButton getBotonApuesta() {
		return botonApuesta;
	}

	public void setBotonApuesta(JButton botonApuesta) {
		this.botonApuesta = botonApuesta;
	}

	public JButton getFlecha2() {
		return flecha2;
	}

	public void setFlecha2(JButton flecha2) {
		this.flecha2 = flecha2;
	}

	public JButton getFlecha3() {
		return flecha3;
	}

	public void setFlecha3(JButton flecha3) {
		this.flecha3 = flecha3;
	}

	public JButton getBotonCrearApuesta() {
		return botonCrearApuesta;
	}

	public void setBotonCrearApuesta(JButton botonCrearApuesta) {
		this.botonCrearApuesta = botonCrearApuesta;
	}

	public JButton getBotonModificarApuesta() {
		return botonModificarApuesta;
	}

	public void setBotonModificarApuesta(JButton botonModificarApuesta) {
		this.botonModificarApuesta = botonModificarApuesta;
	}

	public JButton getBotonLeerApuestas() {
		return botonLeerApuestas;
	}

	public void setBotonLeerApuestas(JButton botonLeerApuestas) {
		this.botonLeerApuestas = botonLeerApuestas;
	}

	public JButton getBotonEliminarApuestas() {
		return botonEliminarApuestas;
	}

	public void setBotonEliminarApuestas(JButton botonEliminarApuestas) {
		this.botonEliminarApuestas = botonEliminarApuestas;
	}

	public JButton getBotonLoteria() {
		return botonLoteria;
	}

	public void setBotonLoteria(JButton botonLoteria) {
		this.botonLoteria = botonLoteria;
	}

	public JButton getBotonBaloto() {
		return botonBaloto;
	}

	public void setBotonBaloto(JButton botonBaloto) {
		this.botonBaloto = botonBaloto;
	}

	public JButton getBotonSuperastro() {
		return botonSuperastro;
	}

	public void setBotonSuperastro(JButton botonSuperastro) {
		this.botonSuperastro = botonSuperastro;
	}

	public JButton getBotonBetplay() {
		return botonBetplay;
	}

	public void setBotonBetplay(JButton botonBetplay) {
		this.botonBetplay = botonBetplay;
	}

	public JButton getBotonChance() {
		return botonChance;
	}

	public void setBotonChance(JButton botonChance) {
		this.botonChance = botonChance;
	}

}
