/**
 * La clase AplMain es la clase principal que contiene el método main para iniciar la aplicación.
 */
package co.edu.unbosque.controller;

/**
 * La clase AplMain es la clase principal que contiene el método main para
 * iniciar la aplicación.
 */
public class AplMain {

	/**
	 * El método main es el punto de entrada principal para la aplicación.
	 *
	 * @param args Los argumentos de la línea de comandos (no se utilizan en este
	 *             caso).
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Se crea una instancia de la clase Controller.
		Controller c = new Controller();

		// Se ejecuta el método ejecutar() de la instancia de Controller.
		c.ejecutar();
	}
}
