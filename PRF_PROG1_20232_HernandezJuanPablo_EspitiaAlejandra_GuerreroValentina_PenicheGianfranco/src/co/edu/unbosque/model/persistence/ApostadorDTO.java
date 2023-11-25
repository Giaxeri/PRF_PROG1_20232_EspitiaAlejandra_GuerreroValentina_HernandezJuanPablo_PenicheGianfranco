package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para un apostador.
 * Implementa la interfaz Serializable para permitir la serialización.
 */
public class ApostadorDTO implements Serializable {

    /** Número de versión para la serialización. */
    private static final long serialVersionUID = 1L;

    /** Nombre del apostador. */
    private String nombre;

    /** Número de cédula del apostador. */
    private long cedula;

    /** Sede a la que pertenece el apostador. */
    private String sede;

    /** Dirección del apostador. */
    private String direccion;

    /** Número de celular del apostador. */
    private long numCelular;

    /** Constructor predeterminado de la clase. */
    public ApostadorDTO() {
    }

    /**
     * Constructor de la clase con parámetros para inicializar todas las propiedades del apostador.
     *
     * @param nombre     Nombre del apostador.
     * @param cedula     Número de cédula del apostador.
     * @param sede       Sede a la que pertenece el apostador.
     * @param direccion  Dirección del apostador.
     * @param numCelular Número de celular del apostador.
     */
    public ApostadorDTO(String nombre, long cedula, String sede, String direccion, long numCelular) {
        super();
        this.nombre = nombre;
        this.cedula = cedula;
        this.sede = sede;
        this.direccion = direccion;
        this.numCelular = numCelular;
    }

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(long numCelular) {
		this.numCelular = numCelular;
	}
	/**
     * Devuelve una representación en cadena del objeto ApostadorDTO.
     *
     * @return Cadena que representa al objeto ApostadorDTO.
     */
	@Override
	public String toString() {
		return "<html>Nombre=" + nombre + "   Cedula=" + cedula + " Sede=" + sede + ", direccion=" + direccion
				+ ", numCelular=" + numCelular + "<br><html>";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
