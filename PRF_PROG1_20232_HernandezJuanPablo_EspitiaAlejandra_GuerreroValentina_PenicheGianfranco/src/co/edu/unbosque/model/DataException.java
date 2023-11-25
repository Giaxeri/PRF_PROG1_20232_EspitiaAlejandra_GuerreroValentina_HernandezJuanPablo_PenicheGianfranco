package co.edu.unbosque.model;

/**
 * La clase DataException representa una excepción personalizada para manejar
 * errores relacionados con datos.
 */
public class DataException extends Exception {

	/**
	 * Identificador único de la versión de la clase (serialVersionUID).
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que crea una instancia de DataException con un mensaje
	 * específico.
	 *
	 * @param msg Mensaje que describe la excepción.
	 */
	public DataException(String msg) {
		super(msg);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
