package co.edu.unbosque.view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	/**
	 * La clase VentanaPrincipal representa la interfaz gráfica principal de la
	 * aplicación.
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonIniciar;
	private JButton botonRegresar;
	private JLabel fondo;

	/**
	 * Constructor de la clase VentanaPrincipal. Inicializa y configura la interfaz
	 * gráfica.
	 */
	public VentanaPrincipal() {

		setBounds(0, 0, 1080, 700);
		setTitle("Croupier");
		setResizable(false);
		setLayout(null);

		botonIniciar = new JButton(new ImageIcon("src/images/IniciarBoton.png"));
		botonIniciar.setBounds(700, 100, 285, 180);
		botonIniciar.setOpaque(false);
		botonIniciar.setContentAreaFilled(false);
		botonIniciar.setBorderPainted(false);

		botonRegresar = new JButton(new ImageIcon("src/images/SalirBoton.png"));
		botonRegresar.setBounds(700, 375, 285, 180);
		botonRegresar.setOpaque(false);
		botonRegresar.setContentAreaFilled(false);
		botonRegresar.setBorderPainted(false);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVP.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		add(botonIniciar);
		add(botonRegresar);
		add(fondo);
	}

	// Métodos getter y setter
	public JButton getBotonIniciar() {
		return botonIniciar;
	}

	public void setBotonIniciar(JButton botonIniciar) {
		this.botonIniciar = botonIniciar;
	}

	public JButton getBotonRegresar() {
		return botonRegresar;
	}

	public void setBotonRegresar(JButton botonRegresar) {
		this.botonRegresar = botonRegresar;
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
