package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase abstracta que representa una apuesta. Implementa la interfaz
 * Serializable para permitir la serialización.
 */
public abstract class Apuesta implements Serializable {

	/** Número de versión para la serialización. */
	private static final long serialVersionUID = 1L;

	/** Nombre de la sede donde se realiza la apuesta. */
	protected String nombreSede;

	/** Número de cédula del apostador que realiza la apuesta. */
	protected long numCedula;

	/** Día en el que se realiza la apuesta. */
	protected String diaApuesta;

	/** Valor de la apuesta. */
	protected double valorApuesta;

	/**
	 * Constructor de la clase Apuesta.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param numCedula    Número de cédula del apostador que realiza la apuesta.
	 * @param diaApuesta   Día en el que se realiza la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */
	public Apuesta(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
		super();
		this.nombreSede = nombreSede;
		this.numCedula = numCedula;
		this.diaApuesta = diaApuesta;
		this.valorApuesta = valorApuesta;
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

	// Puedes agregar métodos abstractos y concretos relacionados con las apuestas
	// en esta clase abstracta.

}
