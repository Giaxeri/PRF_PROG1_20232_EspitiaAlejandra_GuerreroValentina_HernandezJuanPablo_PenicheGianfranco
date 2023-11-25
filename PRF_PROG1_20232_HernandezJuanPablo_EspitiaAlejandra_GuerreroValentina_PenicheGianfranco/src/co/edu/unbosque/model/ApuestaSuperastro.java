package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApuestaSuperastroDAO;

/**
 * La clase ApuestaSuperastro representa una apuesta en el juego de Superastro.
 */
public class ApuestaSuperastro {
	private ApuestaSuperastroDAO apuestaSuperastro;

	/**
	 * Constructor que inicializa la instancia de ApuestaSuperastro con una nueva
	 * instancia de ApuestaSuperastroDAO.
	 */
	public ApuestaSuperastro() {
		apuestaSuperastro = new ApuestaSuperastroDAO();
	}

	/**
	 * Crea una nueva apuesta de Superastro y la almacena en la base de datos.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param cedula         Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor apostado en la apuesta.
	 * @param signoZodiaco   Signo zodiacal seleccionado en la apuesta.
	 * @param numeroApostado Número seleccionado en la apuesta.
	 */
	public void crearApuestaSuperastro(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String signoZodiaco, int numeroApostado) {
		apuestaSuperastro.crearApuestaSuperastro(nombreSede, cedula, diaApuesta, valorApuesta, signoZodiaco,
				numeroApostado);
	}

	/**
	 * Modifica una apuesta de Superastro existente en la base de datos.
	 *
	 * @param nombreSede             Nombre de la sede donde se realizó la apuesta.
	 * @param cedula                 Número de cédula del apostador.
	 * @param diaApuesta             Día en que se realizó la apuesta.
	 * @param anteriorNumeroApostado Número seleccionado en la apuesta original.
	 * @param nuevoValorApuesta      Nuevo valor apostado en la apuesta modificada.
	 * @param nuevoSignoZodiaco      Nuevo signo zodiacal seleccionado en la apuesta
	 *                               modificada.
	 * @param nuevoNumeroApostado    Nuevo número seleccionado en la apuesta
	 *                               modificada.
	 */
	public void modificarApuestaSuperastro(String nombreSede, long cedula, String diaApuesta,
			int anteriorNumeroApostado, double nuevoValorApuesta, String nuevoSignoZodiaco, int nuevoNumeroApostado) {
		apuestaSuperastro.modificarApuestaSuperastro(nombreSede, cedula, diaApuesta, anteriorNumeroApostado,
				nuevoValorApuesta, nuevoSignoZodiaco, nuevoNumeroApostado);
	}

	/**
	 * Lee todas las apuestas de Superastro almacenadas en la base de datos.
	 *
	 * @return Una cadena que representa la información de todas las apuestas.
	 */
	public String leerApuestaSuperastro() {
		return apuestaSuperastro.leerApuestas();
	}

	/**
	 * Elimina una apuesta de Superastro de la base de datos.
	 *
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Número seleccionado en la apuesta a eliminar.
	 */
	public void eliminarApuestaSuperastro(long cedula, int numeroApostado) {
		apuestaSuperastro.eliminarApuestaSuperastro(cedula, numeroApostado);
	}

	/**
	 * Inicializa las apuestas de Superastro.
	 */
	public void inicializarApuestasSuperastro() {
		apuestaSuperastro.inicializarApuestasSuperastro();
	}

	/**
	 * Obtiene la instancia de ApuestaSuperastroDAO asociada a esta instancia de
	 * ApuestaSuperastro.
	 *
	 * @return La instancia de ApuestaSuperastroDAO.
	 */
	public ApuestaSuperastroDAO getApuestaSuperastro() {
		return apuestaSuperastro;
	}

	/**
	 * Establece la instancia de ApuestaSuperastroDAO asociada a esta instancia de
	 * ApuestaSuperastro.
	 *
	 * @param apuestaSuperastro La nueva instancia de ApuestaSuperastroDAO.
	 */
	public void setApuestaSuperastro(ApuestaSuperastroDAO apuestaSuperastro) {
		this.apuestaSuperastro = apuestaSuperastro;
	}
	
	
}
