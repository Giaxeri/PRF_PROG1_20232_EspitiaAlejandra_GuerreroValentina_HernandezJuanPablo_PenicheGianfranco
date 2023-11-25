package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa una apuesta Baloto y extiende la clase abstracta
 * Apuesta.
 */
public class ApuestaBalotoDTO extends Apuesta implements Serializable {

	/** Número de versión para la serialización. */
	private static final long serialVersionUID = 1L;

	/** Número apostado en la apuesta Baloto. */
	private int numeroApostado;

	/**
	 * Constructor para una apuesta Baloto sin número apostado.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param numCedula    Número de cédula del apostador que realiza la apuesta.
	 * @param diaApuesta   Día en el que se realiza la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */
	public ApuestaBalotoDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
	}

	/**
	 * Constructor para una apuesta Baloto con número apostado.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param numCedula      Número de cédula del apostador que realiza la apuesta.
	 * @param diaApuesta     Día en el que se realiza la apuesta.
	 * @param valorApuesta   Valor de la apuesta.
	 * @param numeroApostado Número apostado en la apuesta Baloto.
	 */
	public ApuestaBalotoDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta,
			int numeroApostado) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		this.numeroApostado = numeroApostado;
	}

	/**
	 * Obtiene una representación en cadena de la apuesta Baloto.
	 *
	 * @return Cadena que representa la apuesta Baloto.
	 */
	public String toString() {
		return "Apuesta Baloto:" + "\n" + "Nombre sede: " + nombreSede + " Cedula: " + numCedula + " Dia apuesta: "
				+ diaApuesta + " Valor apuesta: " + valorApuesta + " Numero apostado: " + numeroApostado + "\n";
	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
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

	public int getNumeroApostado() {
		return numeroApostado;
	}

	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
