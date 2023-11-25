package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * La clase SedesDTO representa una sede con su ubicación y número de empleados.
 */
public class SedesDTO implements Serializable {

	/** Número de versión para la serialización. */
	private static final long serialVersionUID = 1L;

	/** Ubicación o localidad de la sede. */
	private String ubicacionLocalidad;

	/** Número de empleados de la sede. */
	private int numeroDeEmpleados;

	/**
	 * Constructor vacío de la clase SedesDTO.
	 */
	public SedesDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase SedesDTO que inicializa la ubicación y el número de
	 * empleados de la sede.
	 *
	 * @param ubicacionLocalidad Ubicación o localidad de la sede.
	 * @param numeroDeEmpleados  Número de empleados de la sede.
	 */
	public SedesDTO(String ubicacionLocalidad, int numeroDeEmpleados) {
		super();
		this.ubicacionLocalidad = ubicacionLocalidad;
		this.numeroDeEmpleados = numeroDeEmpleados;

	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getUbicacionLocalidad() {
		return ubicacionLocalidad;
	}

	public void setUbicacionLocalidad(String ubicacionLocalidad) {
		this.ubicacionLocalidad = ubicacionLocalidad;
	}

	public int getNumeroDeEmpleados() {
		return numeroDeEmpleados;
	}

	public void setNumeroDeEmpleados(int numeroDeEmpleados) {
		this.numeroDeEmpleados = numeroDeEmpleados;
	}

	@Override
	public String toString() {
		return "--- \n Localidad =" + ubicacionLocalidad + ",\n # empleados =" + numeroDeEmpleados + "\n";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
