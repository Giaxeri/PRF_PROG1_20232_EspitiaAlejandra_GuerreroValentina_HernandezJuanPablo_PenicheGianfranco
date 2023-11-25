package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa una apuesta de Superastro.
 */
public class ApuestaSuperastroDTO extends Apuesta implements Serializable {

	/**
	 * SerialVersionUID para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Número apostado en la apuesta de Superastro.
	 */
	private int numeroApostado;

	/**
	 * Signo del zodiaco asociado a la apuesta de Superastro.
	 */
	private String signoZodiaco;

	/**
	 * Constructor de la clase ApuestaSuperastroDTO.
	 * 
	 * @param nombreSede   Nombre de la sede.
	 * @param numCedula    Número de cédula.
	 * @param diaApuesta   Día de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */
	public ApuestaSuperastroDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase ApuestaSuperastroDTO.
	 * 
	 * @param nombreSede     Nombre de la sede.
	 * @param numCedula      Número de cédula.
	 * @param diaApuesta     Día de la apuesta.
	 * @param valorApuesta   Valor de la apuesta.
	 * @param numeroApostado Número apostado.
	 * @param signoZodiaco   Signo del zodiaco.
	 */
	public ApuestaSuperastroDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta,
			int numeroApostado, String signoZodiaco) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		this.numeroApostado = numeroApostado;
		this.signoZodiaco = signoZodiaco;
	}

	/**
	 * Genera una representación en formato de cadena de la apuesta Superastro.
	 * 
	 * @return Cadena que representa la apuesta Superastro.
	 */
	public String toString() {
		return "Apuesta Superastro: " + "\n" + "Nombre sede: " + nombreSede + " Cedula: " + numCedula + " Dia apuesta: "
				+ diaApuesta + " Valor apuesta: " + valorApuesta + " Signo del zodiaco: " + signoZodiaco
				+ " Número apostado: " + numeroApostado + "\n";

	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public int getNumeroApostado() {
		return numeroApostado;
	}

	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
	}

	public String getSignoZodiaco() {
		return signoZodiaco;
	}

	public void setSignoZodiaco(String signoZodiaco) {
		this.signoZodiaco = signoZodiaco;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public long getNumCedula() {
		return numCedula;
	}

	public void setNumCedula(long numCedula) {
		this.numCedula = numCedula;
	}

	public String getDiaApuesta() {
		return diaApuesta;
	}

	public void setDiaApuesta(String diaApuesta) {
		this.diaApuesta = diaApuesta;
	}

	public double getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
