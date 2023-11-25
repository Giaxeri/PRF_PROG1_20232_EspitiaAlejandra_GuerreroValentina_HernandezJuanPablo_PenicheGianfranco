package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApuestaChanceDAO;

/**
 * La clase ApuestaChance representa una apuesta en el juego de Chance.
 */
public class ApuestaChance {
	private ApuestaChanceDAO apuestaChance;

	/**
	 * Constructor que inicializa la instancia de ApuestaChance con una nueva
	 * instancia de ApuestaChanceDAO.
	 */
	public ApuestaChance() {
		apuestaChance = new ApuestaChanceDAO();
	}

	/**
	 * Crea una nueva apuesta de Chance y la almacena en la base de datos.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param cedula         Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor apostado en la apuesta.
	 * @param nombreLoteria  Nombre de la lotería en la que se realiza la apuesta.
	 * @param numeroApostado Número seleccionado en la apuesta.
	 */
	public void crearApuestaChance(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String nombreLoteria, int numeroApostado) {
		apuestaChance.crearApuestaChance(nombreSede, cedula, diaApuesta, valorApuesta, nombreLoteria, numeroApostado);
	}

	/**
	 * Modifica una apuesta de Chance existente en la base de datos.
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
	 */
	public void modificarApuestaChance(String nombreSede, long cedula, String diaApuesta, int anteriorNumeroApostado,
			double nuevoValorApuesta, String nuevoNombreLoteria, int nuevoNumeroApostado) {
		apuestaChance.modificarApuestaChance(nombreSede, cedula, diaApuesta, anteriorNumeroApostado, nuevoValorApuesta,
				nuevoNombreLoteria, nuevoNumeroApostado);
	}

	/**
	 * Lee todas las apuestas de Chance almacenadas en la base de datos.
	 *
	 * @return Una cadena que representa la información de todas las apuestas.
	 */
	public String leerApuestaChance() {
		return apuestaChance.leerApuestas();
	}

	/**
	 * Elimina una apuesta de Chance de la base de datos.
	 *
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Número seleccionado en la apuesta a eliminar.
	 */
	public void eliminarApuestaChance(long cedula, int numeroApostado) {
		apuestaChance.eliminarApuestaChance(cedula, numeroApostado);
	}

	/**
	 * Inicializa las apuestas de Chance.
	 */
	public void inicializarApuestasChance() {
		apuestaChance.inicializarApuestasChance();
	}

	/**
	 * Obtiene la instancia de ApuestaChanceDAO asociada a esta instancia de
	 * ApuestaChance.
	 *
	 * @return La instancia de ApuestaChanceDAO.
	 */
	public ApuestaChanceDAO getApuestaChance() {
		return apuestaChance;
	}

	/**
	 * Establece la instancia de ApuestaChanceDAO asociada a esta instancia de
	 * ApuestaChance.
	 *
	 * @param apuestaChance La nueva instancia de ApuestaChanceDAO.
	 */
	public void setApuestaChance(ApuestaChanceDAO apuestaChance) {
		this.apuestaChance = apuestaChance;
	}
	
	
}
