package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa una apuesta de tipo Chance.
 */
public class ApuestaChanceDTO extends Apuesta implements Serializable {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre de la lotería.
	 */
	private String nombreLoteria;

	/**
	 * Número apostado.
	 */
	private int numeroApostado;

	/**
	 * Constructor de la clase.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param numCedula      Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor de la apuesta.
	 * @param nombreLoteria  Nombre de la lotería en la que se realiza la apuesta.
	 * @param numeroApostado Número apostado en la lotería.
	 */
	public ApuestaChanceDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta,
			String nombreLoteria, int numeroApostado) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		this.nombreLoteria = nombreLoteria;
		this.numeroApostado = numeroApostado;
	}
	
	public ApuestaChanceDTO(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
		super(nombreSede, numCedula, diaApuesta, valorApuesta);
		// TODO Auto-generated constructor stub
	}
	
	

	



	/**
	 * Obtiene una representación en cadena de la apuesta Chance.
	 *
	 * @return Cadena con la información de la apuesta Chance.
	 */
	@Override
	public String toString() {
		return "Apuesta Superastro: " + "\n" + "Nombre sede: " + nombreSede + " Cedula: " + numCedula + " Dia apuesta: "
				+ diaApuesta + " Valor apuesta: " + valorApuesta + " Nombre Loteria: " + nombreLoteria
				+ " Número apostado: " + numeroApostado + "\n";

	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getNombreLoteria() {
		return nombreLoteria;
	}

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	public int getNumeroApostado() {
		return numeroApostado;
	}

	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
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
