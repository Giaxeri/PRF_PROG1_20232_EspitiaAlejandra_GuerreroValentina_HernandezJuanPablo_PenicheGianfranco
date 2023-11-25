package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaSedesYClientes extends JFrame {

	/**
	 * La clase VentanaSedesYClientes representa la interfaz gráfica para gestionar
	 * sedes y clientes.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JButton botonDetalles, botonClienteSedes, botonTotal, botonSedeTipo, flecha;

	/**
	 * Constructor de la clase VentanaSedesYClientes. Inicializa y configura la
	 * interfaz gráfica.
	 */

	public VentanaSedesYClientes() {

		setBounds(0, 0, 1080, 700);
		setTitle("Elecciónes");
		setResizable(false);
		setLayout(null);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVR.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		botonDetalles = new JButton(new ImageIcon("src/images/DetallesBTN.png"));
		botonDetalles.setBounds(185, 95, 290, 180);
		botonDetalles.setOpaque(false);
		botonDetalles.setContentAreaFilled(false);
		botonDetalles.setBorderPainted(false);

		botonClienteSedes = new JButton(new ImageIcon("src/images/ClienteSedes.png"));
		botonClienteSedes.setBounds(595, 95, 290, 180);
		botonClienteSedes.setOpaque(false);
		botonClienteSedes.setContentAreaFilled(false);
		botonClienteSedes.setBorderPainted(false);

		botonTotal = new JButton(new ImageIcon("src/images/TotalApuestasBTN.png"));
		botonTotal.setBounds(185, 350, 290, 180);
		botonTotal.setOpaque(false);
		botonTotal.setContentAreaFilled(false);
		botonTotal.setBorderPainted(false);

		botonSedeTipo = new JButton(new ImageIcon("src/images/SedeYTipoBTN.png"));
		botonSedeTipo.setBounds(595, 350, 290, 180);
		botonSedeTipo.setOpaque(false);
		botonSedeTipo.setContentAreaFilled(false);
		botonSedeTipo.setBorderPainted(false);

		flecha = new JButton(new ImageIcon("src/images/FlechaR.png"));
		flecha.setBounds(5, 5, 75, 75);
		flecha.setOpaque(false);
		flecha.setContentAreaFilled(false);
		flecha.setBorderPainted(false);

		add(flecha);
		add(botonTotal);
		add(botonSedeTipo);
		add(botonDetalles);
		add(botonClienteSedes);
		add(fondo);
	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBotonDetalles() {
		return botonDetalles;
	}

	public void setBotonDetalles(JButton botonDetalles) {
		this.botonDetalles = botonDetalles;
	}

	public JButton getBotonClienteSedes() {
		return botonClienteSedes;
	}

	public void setBotonClienteSedes(JButton botonClienteSedes) {
		this.botonClienteSedes = botonClienteSedes;
	}

	public JButton getBotonTotal() {
		return botonTotal;
	}

	public void setBotonTotal(JButton botonTotal) {
		this.botonTotal = botonTotal;
	}

	public JButton getBotonSedeTipo() {
		return botonSedeTipo;
	}

	public void setBotonSedeTipo(JButton botonSedeTipo) {
		this.botonSedeTipo = botonSedeTipo;
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

}