package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApuestaLoteriaDAO;

/**
 * La clase ApuestaLoteria representa una apuesta en el juego de Lotería.
 */
public class ApuestaLoteria {
	private ApuestaLoteriaDAO apuestaLoteria;

	/**
	 * Constructor que inicializa la instancia de ApuestaLoteria con una nueva
	 * instancia de ApuestaLoteriaDAO.
	 */
	public ApuestaLoteria() {
		apuestaLoteria = new ApuestaLoteriaDAO();
	}

	/**
	 * Crea una nueva apuesta de Lotería y la almacena en la base de datos.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param cedula         Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor apostado en la apuesta.
	 * @param nombreLoteria  Nombre de la lotería en la que se realiza la apuesta.
	 * @param numeroApostado Número seleccionado en la apuesta.
	 * @param numeroSerie    Número de serie de la lotería.
	 */
	public void crearApuestaLoteria(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String nombreLoteria, int numeroApostado, int numeroSerie) {
		apuestaLoteria.crearApuestaLoteria(nombreSede, cedula, diaApuesta, valorApuesta, nombreLoteria, numeroApostado,
				numeroSerie);
	}

	/**
	 * Modifica una apuesta de Lotería existente en la base de datos.
	 *
	 * @param nombreSede             Nombre de la sede donde se realizó la apuesta.
	 * @param cedula                 Número de cédula del apostador.
	 * @param diaApuesta             Día en que se realizó la apuesta.
	 * @param anteriorNumeroApostado Número seleccionado en la apuesta original.
	 * @param nuevoValorApuesta      Nuevo valor apostado en la apuesta modificada.
	 * @param nuevoNombreLoteria     Nuevo nombre de la lotería en la apuesta
	 *                               modificada.
	 * @param nuevoNumeroApostado    Nuevo número seleccionado en la apuesta
	 *                               modificada.
	 * @param nuevoNumeroSerie       Nuevo número de serie de la lotería en la
	 *                               apuesta modificada.
	 */
	public void modificarApuestaLoteria(String nombreSede, long cedula, String diaApuesta, int anteriorNumeroApostado,
			double nuevoValorApuesta, String nuevoNombreLoteria, int nuevoNumeroApostado, int nuevoNumeroSerie) {
		apuestaLoteria.modificarApuestaLoteria(nombreSede, cedula, diaApuesta, anteriorNumeroApostado,
				nuevoValorApuesta, nuevoNombreLoteria, nuevoNumeroApostado, nuevoNumeroSerie);
	}

	/**
	 * Lee todas las apuestas de Lotería almacenadas en la base de datos.
	 *
	 * @return Una cadena que representa la información de todas las apuestas.
	 */
	public String leerApuestaLoteria() {
		return apuestaLoteria.leerApuestas();
	}

	/**
	 * Elimina una apuesta de Lotería de la base de datos.
	 *
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Número seleccionado en la apuesta a eliminar.
	 */
	public void eliminarApuestaLoteria(long cedula, int numeroApostado) {
		apuestaLoteria.eliminarApuestaLoteria(cedula, numeroApostado);
	}

	/**
	 * Inicializa las apuestas de Lotería.
	 */
	public void inicializarApuestasLoteria() {
		apuestaLoteria.inicializarApuestasLoteria();
	}

	/**
	 * Obtiene la instancia de ApuestaLoteriaDAO asociada a esta instancia de
	 * ApuestaLoteria.
	 *
	 * @return La instancia de ApuestaLoteriaDAO.
	 */
	public ApuestaLoteriaDAO getApuestaLoteria() {
		return apuestaLoteria;
	}

	/**
	 * Establece la instancia de ApuestaLoteriaDAO asociada a esta instancia de
	 * ApuestaLoteria.
	 *
	 * @param apuestaLoteria La nueva instancia de ApuestaLoteriaDAO.
	 */
	public void setApuestaLoteria(ApuestaLoteriaDAO apuestaLoteria) {
		this.apuestaLoteria = apuestaLoteria;
	}
	
	
}
