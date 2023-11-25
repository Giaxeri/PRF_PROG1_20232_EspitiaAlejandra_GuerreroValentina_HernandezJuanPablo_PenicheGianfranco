package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPresupuestos extends JFrame {

	/**
	 * La clase VentanaPresupuestos representa la interfaz gráfica para gestionar
	 * presupuestos.
	 */
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	private JButton botonPresupuestos, botonModificar;
	private TextField pLoteria, pBaloto, pSuperastro, pBetplay, pChance;
	private JLabel loteriaTxt, balotoTxt, superastroTxt, betplayTxt, chanceTxt;

	/**
	 * Constructor de la clase VentanaPresupuestos. Inicializa y configura la
	 * interfaz gráfica.
	 */
	public VentanaPresupuestos() {

		setBounds(0, 0, 1080, 700);
		setTitle("Presupuestos");
		setResizable(false);
		setLayout(null);

		pLoteria = new TextField();
		loteriaTxt = new JLabel();
		loteriaTxt.setBounds(40, 110, 400, 25);
		loteriaTxt.setText("Presupuesto destinado para la Loteria (No use comas ni puntos):");
		pLoteria.setBounds(40, 130, 350, 30);

		pBaloto = new TextField();
		balotoTxt = new JLabel();
		balotoTxt.setBounds(40, 290, 400, 25);
		balotoTxt.setText("Presupuesto destinado para el Baloto (No use comas ni puntos):");
		pBaloto.setBounds(40, 310, 350, 30);

		pSuperastro = new TextField();
		superastroTxt = new JLabel();
		superastroTxt.setBounds(40, 470, 400, 25);
		superastroTxt.setText("Inserte el presupuesto para Superastro (No use comas ni puntos):");
		pSuperastro.setBounds(40, 490, 350, 30);

		pBetplay = new TextField();
		betplayTxt = new JLabel();
		betplayTxt.setBounds(530, 110, 400, 25);
		betplayTxt.setText("Inserte el presupuesto para el Betplay (No use comas ni puntos):");
		pBetplay.setBounds(530, 130, 350, 30);

		pChance = new TextField();
		chanceTxt = new JLabel();
		chanceTxt.setBounds(530, 290, 400, 25);
		chanceTxt.setText("Inserte el presupuesto para Chance (No use comas ni puntos):");
		pChance.setBounds(530, 310, 350, 30);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1080, 700);
		Image temporal = new ImageIcon("src/images/FondoVR.png").getImage();
		ImageIcon imgResimension = new ImageIcon(
				temporal.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imgResimension);

		botonPresupuestos = new JButton(new ImageIcon("src/images/RegistrarBoton.png"));
		botonPresupuestos.setBounds(555, 425, 280, 180);
		botonPresupuestos.setOpaque(false);
		botonPresupuestos.setContentAreaFilled(false);
		botonPresupuestos.setBorderPainted(false);

		botonModificar = new JButton(new ImageIcon("src/images/ModificarBtn.png"));
		botonModificar.setBounds(555, 425, 280, 180);
		botonModificar.setOpaque(false);
		botonModificar.setContentAreaFilled(false);
		botonModificar.setBorderPainted(false);
		botonModificar.setVisible(false);

		add(botonPresupuestos);
		add(botonModificar);
		add(pLoteria);
		add(loteriaTxt);
		add(pBaloto);
		add(balotoTxt);
		add(pSuperastro);
		add(superastroTxt);
		add(pBetplay);
		add(betplayTxt);
		add(pChance);
		add(chanceTxt);

		add(fondo);

	}

	// Métodos getter y setter
	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBotonPresupuestos() {
		return botonPresupuestos;
	}

	public void setBotonPresupuestos(JButton botonPresupuestos) {
		this.botonPresupuestos = botonPresupuestos;
	}

	public TextField getpLoteria() {
		return pLoteria;
	}

	public void setpLoteria(TextField pLoteria) {
		this.pLoteria = pLoteria;
	}

	public TextField getpBaloto() {
		return pBaloto;
	}

	public void setpBaloto(TextField pBaloto) {
		this.pBaloto = pBaloto;
	}

	public TextField getpSuperastro() {
		return pSuperastro;
	}

	public void setpSuperastro(TextField pSuperastro) {
		this.pSuperastro = pSuperastro;
	}

	public TextField getpBetplay() {
		return pBetplay;
	}

	public void setpBetplay(TextField pBetplay) {
		this.pBetplay = pBetplay;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public void setBotonModificar(JButton botonModificar) {
		this.botonModificar = botonModificar;
	}

	public TextField getpChance() {
		return pChance;
	}

	public void setpChance(TextField pChance) {
		this.pChance = pChance;
	}

	public JLabel getLoteriaTxt() {
		return loteriaTxt;
	}

	public void setLoteriaTxt(JLabel loteriaTxt) {
		this.loteriaTxt = loteriaTxt;
	}

	public JLabel getBalotoTxt() {
		return balotoTxt;
	}

	public void setBalotoTxt(JLabel balotoTxt) {
		this.balotoTxt = balotoTxt;
	}

	public JLabel getSuperastroTxt() {
		return superastroTxt;
	}

	public void setSuperastroTxt(JLabel superastroTxt) {
		this.superastroTxt = superastroTxt;
	}

	public JLabel getBetplayTxt() {
		return betplayTxt;
	}

	public void setBetplayTxt(JLabel betplayTxt) {
		this.betplayTxt = betplayTxt;
	}

	public JLabel getChanceTxt() {
		return chanceTxt;
	}

	public void setChanceTxt(JLabel chanceTxt) {
		this.chanceTxt = chanceTxt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
