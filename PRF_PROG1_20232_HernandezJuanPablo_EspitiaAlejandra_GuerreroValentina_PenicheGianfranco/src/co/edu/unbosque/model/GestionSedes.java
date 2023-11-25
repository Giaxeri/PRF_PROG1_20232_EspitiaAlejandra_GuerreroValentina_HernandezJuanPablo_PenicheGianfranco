package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.SedesDAO;

/**
 * La clase GestionSedes proporciona funcionalidades para gestionar sedes.
 */
public class GestionSedes {
	private SedesDAO sedes;

	/**
	 * Constructor que inicializa la instancia de GestionSedes con una nueva
	 * instancia de SedesDAO.
	 */
	public GestionSedes() {
		sedes = new SedesDAO();
	}

	/**
	 * Crea una nueva sede con la cantidad, localidad y número de empleados
	 * especificados.
	 *
	 * @param cantidadSedes Cantidad de sedes a crear.
	 * @param localidad     Localidad de la sede.
	 * @param numEmpleados  Número de empleados de la sede.
	 * @return Un mensaje indicando el resultado de la creación de la sede.
	 */
	public String crearNuevaSede(int cantidadSedes, String localidad, int numEmpleados) {
		return sedes.crearSede(cantidadSedes, localidad, numEmpleados);
	}

	/**
	 * Modifica la información de una sede existente en la base de datos.
	 *
	 * @param localidadAnt      Localidad de la sede a modificar.
	 * @param localidadNueva    Nueva localidad de la sede.
	 * @param numEmpleadosNuevo Nuevo número de empleados de la sede.
	 */
	public void modificarSede(String localidadAnt, String localidadNueva, int numEmpleadosNuevo) {
		sedes.modificarSede(localidadAnt, localidadNueva, numEmpleadosNuevo);
	}

	/**
	 * Elimina una sede de la base de datos.
	 *
	 * @param cantidadSedes      Cantidad de sedes a considerar en la eliminación.
	 * @param localidadAEliminar Localidad de la sede a eliminar.
	 * @return Un mensaje indicando el resultado de la eliminación de la sede.
	 */
	public String eliminarSede(int cantidadSedes, String localidadAEliminar) {
		return sedes.eliminarSedes(localidadAEliminar, cantidadSedes);
	}

	/**
	 * Inicializa la información de las sedes.
	 */
	public void inicializarSedes() {
		sedes.inicializarSedes();
	}

	/**
	 * Lee y devuelve la información de todas las sedes almacenadas en la base de
	 * datos.
	 *
	 * @return Una cadena que representa la información de todas las sedes.
	 */
	public String mostrarSedes() {
		return sedes.leerSedes();
	}

	/**
	 * Obtiene la instancia de SedesDAO asociada a esta instancia de GestionSedes.
	 *
	 * @return La instancia de SedesDAO.
	 */
	public SedesDAO getSedes() {
		return sedes;
	}

	/**
	 * Establece la instancia de SedesDAO asociada a esta instancia de GestionSedes.
	 *
	 * @param sedes La nueva instancia de SedesDAO.
	 */
	public void setSedes(SedesDAO sedes) {
		this.sedes = sedes;
	}
	
	
}
