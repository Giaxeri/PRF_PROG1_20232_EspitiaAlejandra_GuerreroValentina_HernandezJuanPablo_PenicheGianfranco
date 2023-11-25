package co.edu.unbosque.model.persistence;

public interface CRUDOperation {

	/**
	 * Crea una nueva entrada utilizando los atributos proporcionados.
	 *
	 * @param attribs Atributos para crear una nueva entrada.
	 */
	void create(String... attribs);

	/**
	 * Crea una nueva entrada utilizando el objeto proporcionado.
	 *
	 * @param obj Objeto para crear una nueva entrada.
	 */
	void create(Object obj);

	/**
	 * Lee todas las entradas y las devuelve como una cadena.
	 *
	 * @return Una representación de cadena de todas las entradas.
	 */
	String readAll();

	/**
	 * Actualiza una entrada en el índice especificado con nuevos datos.
	 *
	 * @param index   Índice de la entrada que se actualizará.
	 * @param newData Nuevos datos para actualizar la entrada.
	 * @return True si la actualización es exitosa, false en caso contrario.
	 */
	boolean updateByIndex(int index, String... newData);

	/**
	 * Elimina una entrada con el número de ID especificado.
	 *
	 * @param idNumber Número de ID de la entrada que se eliminará.
	 * @return True si la eliminación es exitosa, false en caso contrario.
	 */
	boolean delete(long idNumber);

	/**
	 * Elimina el objeto proporcionado.
	 *
	 * @param obj Objeto que se eliminará.
	 * @return True si la eliminación es exitosa, false en caso contrario.
	 */
	boolean delete(Object obj);
}
