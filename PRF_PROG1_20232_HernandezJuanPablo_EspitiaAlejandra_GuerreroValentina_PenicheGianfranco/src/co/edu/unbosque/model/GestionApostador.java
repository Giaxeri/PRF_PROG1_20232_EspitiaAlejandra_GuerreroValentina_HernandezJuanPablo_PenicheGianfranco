package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApostadorDTO;

/**
 * La clase GestionApostador proporciona funcionalidades para gestionar
 * apostadores.
 */
public class GestionApostador {
	private ApostadorDAO apostador;

	/**
	 * Constructor que inicializa la instancia de GestionApostador con una nueva
	 * instancia de ApostadorDAO.
	 */
	public GestionApostador() {
		apostador = new ApostadorDAO();
	}

	/**
	 * Crea un nuevo apostador y lo almacena en la base de datos.
	 *
	 * @param nombre     Nombre del apostador.
	 * @param cedula     Número de cédula del apostador.
	 * @param sede       Sede asociada al apostador.
	 * @param direccion  Dirección del apostador.
	 * @param numCelular Número de celular del apostador.
	 */
	public void crearApostador(String nombre, long cedula, String sede, String direccion, long numCelular) {
		apostador.create(new ApostadorDTO(nombre, cedula, sede, direccion, numCelular));
	}

	/**
	 * Modifica la información de un apostador existente en la base de datos.
	 *
	 * @param nombreAModificar Nombre del apostador a modificar.
	 * @param nuevoNombre      Nuevo nombre del apostador.
	 * @param nuevaCedula      Nueva cédula del apostador.
	 * @param nuevaSede        Nueva sede asociada al apostador.
	 * @param nuevaDireccion   Nueva dirección del apostador.
	 * @param nuevoNumCelular  Nuevo número de celular del apostador.
	 */
	public void modificarApostador(String nombreAModificar, String nuevoNombre, long nuevaCedula, String nuevaSede,
			String nuevaDireccion, long nuevoNumCelular) {
		apostador.modify(nombreAModificar, nuevoNombre, nuevaCedula, nuevaSede, nuevaDireccion, nuevoNumCelular);
	}

	/**
	 * Lee todos los apostadores almacenados en la base de datos.
	 *
	 * @return Una cadena que representa la información de todos los apostadores.
	 */
	public String leerApostadores() {
		return apostador.readAll();
	}

	/**
	 * Elimina un apostador de la base de datos.
	 *
	 * @param numCedula Número de cédula del apostador a eliminar.
	 */
	public void eliminarApostador(long numCedula) {
		apostador.delete(numCedula);
	}

	/**
	 * Inicializa la información de los apostadores.
	 */
	public void inicializarApostadores() {
		apostador.initializeFile();
	}

	/**
	 * Obtiene la instancia de ApostadorDAO asociada a esta instancia de
	 * GestionApostador.
	 *
	 * @return La instancia de ApostadorDAO.
	 */
	public ApostadorDAO getApostador() {
		return apostador;
	}

	/**
	 * Establece la instancia de ApostadorDAO asociada a esta instancia de
	 * GestionApostador.
	 *
	 * @param apostador La nueva instancia de ApostadorDAO.
	 */
	public void setApostador(ApostadorDAO apostador) {
		this.apostador = apostador;
	}
	
	
}
