package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApuestaBetplayDAO;

/**
 * La clase ApuestaBetplay representa una apuesta en el juego de Betplay.
 */
public class ApuestaBetplay {

	private ApuestaBetplayDAO apuestaBetplay;

	/**
	 * Constructor que inicializa la instancia de ApuestaBetplay con una nueva
	 * instancia de ApuestaBetplayDAO.
	 */
	public ApuestaBetplay() {
		apuestaBetplay = new ApuestaBetplayDAO();
	}

	/**
	 * Crea una nueva apuesta de Betplay y la almacena en la base de datos.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param cedula       Número de cédula del apostador.
	 * @param diaApuesta   Día en que se realiza la apuesta.
	 * @param valorApuesta Valor apostado en la apuesta.
	 * @param partido1-14  Resultados de los partidos seleccionados en la apuesta.
	 * @return Mensaje que indica el resultado de la creación de la apuesta.
	 */
	public String crearApuestaBetplay(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String partido1, String partido2, String partido3, String partido4, String partido5, String partido6,
			String partido7, String partido8, String partido9, String partido10, String partido11, String partido12,
			String partido13, String partido14) {
		return apuestaBetplay.crearApuestaBetplay(nombreSede, cedula, diaApuesta, valorApuesta, partido1, partido2,
				partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10, partido11, partido12,
				partido13, partido14);
	}

	/**
	 * Modifica una apuesta de Betplay existente en la base de datos.
	 *
	 * @param nombreSede         Nombre de la sede donde se realizó la apuesta.
	 * @param cedula             Número de cédula del apostador.
	 * @param diaApuestaAnterior Día en que se realizó la apuesta original.
	 * @param diaApuesta         Nuevo día en que se realiza la apuesta modificada.
	 * @param valorApuesta       Nuevo valor apostado en la apuesta.
	 * @param partido1-14        Nuevos resultados de los partidos seleccionados en
	 *                           la apuesta modificada.
	 * @return Mensaje que indica el resultado de la modificación de la apuesta.
	 */
	public String modificarApuestaBetplay(String nombreSede, long cedula, String diaApuestaAnterior, String diaApuesta,
			double valorApuesta, String partido1, String partido2, String partido3, String partido4, String partido5,
			String partido6, String partido7, String partido8, String partido9, String partido10, String partido11,
			String partido12, String partido13, String partido14) {
		return apuestaBetplay.modificarApuestaBetplay(nombreSede, cedula, diaApuestaAnterior, diaApuesta, valorApuesta,
				partido1, partido2, partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10,
				partido11, partido12, partido13, partido14);
	}

	/**
	 * Lee todas las apuestas de Betplay almacenadas en la base de datos.
	 *
	 * @return Una cadena que representa la información de todas las apuestas.
	 */
	public String leerApuestaBetplay() {
		return apuestaBetplay.leerApuestas();
	}

	/**
	 * Elimina una apuesta de Betplay de la base de datos.
	 *
	 * @param cedula     Número de cédula del apostador.
	 * @param diaApuesta Día en que se realizó la apuesta a eliminar.
	 * @return Mensaje que indica el resultado de la eliminación de la apuesta.
	 */
	public String eliminarApuestaBetplay(long cedula, String diaApuesta) {
		return apuestaBetplay.eliminarApuestaBetplay(cedula, diaApuesta);
	}

	/**
	 * Inicializa las apuestas de Betplay.
	 */
	public void inicializarApuestasBetplay() {
		apuestaBetplay.inicializarApuestasBetplay();
	}

	/**
	 * Obtiene la instancia de ApuestaBetplayDAO asociada a esta instancia de
	 * ApuestaBetplay.
	 *
	 * @return La instancia de ApuestaBetplayDAO.
	 */
	public ApuestaBetplayDAO getApuestaBetplay() {
		return apuestaBetplay;
	}

	/**
	 * Establece la instancia de ApuestaBetplayDAO asociada a esta instancia de
	 * ApuestaBetplay.
	 *
	 * @param apuestaBetplay La nueva instancia de ApuestaBetplayDAO.
	 */
	public void setApuestaBetplay(ApuestaBetplayDAO apuestaBetplay) {
		this.apuestaBetplay = apuestaBetplay;
	}
	
	
}
