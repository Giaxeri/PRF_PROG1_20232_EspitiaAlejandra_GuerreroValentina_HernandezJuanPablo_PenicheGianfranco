package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;

/**
 * La clase ApuestaBaloto representa una apuesta en el juego de Baloto.
 */
public class ApuestaBaloto {

	private ApuestaBalotoDAO apuestaBaloto;

	/**
	 * Constructor que inicializa la instancia de ApuestaBaloto con una nueva
	 * instancia de ApuestaBalotoDAO.
	 */
	public ApuestaBaloto() {
		apuestaBaloto = new ApuestaBalotoDAO();
	}

	/**
	 * Crea una nueva apuesta de Baloto y la almacena en la base de datos.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param cedula       Número de cédula del apostador.
	 * @param diaApuesta   Día en que se realiza la apuesta.
	 * @param valorApuesta Valor apostado en la apuesta.
	 * @param numApostado  Números seleccionados en la apuesta.
	 * @return Mensaje que indica el resultado de la creación de la apuesta.
	 */
	public String crearApuestaBaloto(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String numApostado) {
		return apuestaBaloto.crearApuestaBaloto(nombreSede, cedula, diaApuesta, valorApuesta, numApostado);
	}

	/**
	 * Modifica una apuesta de Baloto existente en la base de datos.
	 *
	 * @param nombreSede       Nombre de la sede donde se realizó la apuesta.
	 * @param cedula           Número de cédula del apostador.
	 * @param diaApuesta       Día en que se realizó la apuesta.
	 * @param valorApuesta     Nuevo valor apostado en la apuesta.
	 * @param numApostado      Números seleccionados en la apuesta original.
	 * @param nuevoNumApostado Nuevos números seleccionados en la apuesta
	 *                         modificada.
	 * @return Mensaje que indica el resultado de la modificación de la apuesta.
	 */
	public String modificarApuestaBaloto(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String numApostado, String nuevoNumApostado) {
		return apuestaBaloto.modificarApuestaBaloto(nombreSede, cedula, diaApuesta, valorApuesta, numApostado,
				nuevoNumApostado);
	}

	/**
	 * Lee todas las apuestas de Baloto almacenadas en la base de datos.
	 *
	 * @return Una cadena que representa la información de todas las apuestas.
	 */
	public String leerApuestaBaloto() {
		return apuestaBaloto.leerApuestas();
	}

	/**
	 * Elimina una apuesta de Baloto de la base de datos.
	 *
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Números seleccionados en la apuesta a eliminar.
	 */
	public void eliminarApuestaBaloto(long cedula, String numeroApostado) {
		apuestaBaloto.eliminarApuestaBaloto(cedula, numeroApostado);
	}

	/**
	 * Inicializa el archivo de apuestas de Baloto.
	 */
	public void inicializarApuestasBaloto() {
		apuestaBaloto.inicializarArchivo();
	}

	/**
	 * Obtiene la instancia de ApuestaBalotoDAO asociada a esta instancia de
	 * ApuestaBaloto.
	 *
	 * @return La instancia de ApuestaBalotoDAO.
	 */
	public ApuestaBalotoDAO getApuestaBaloto() {
		return apuestaBaloto;
	}

	/**
	 * Establece la instancia de ApuestaBalotoDAO asociada a esta instancia de
	 * ApuestaBaloto.
	 *
	 * @param apuestaBaloto La nueva instancia de ApuestaBalotoDAO.
	 */
	public void setApuestaBaloto(ApuestaBalotoDAO apuestaBaloto) {
		this.apuestaBaloto = apuestaBaloto;
	}
	
	
}
