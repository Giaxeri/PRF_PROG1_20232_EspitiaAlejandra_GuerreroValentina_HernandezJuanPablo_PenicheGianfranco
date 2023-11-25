package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que maneja la persistencia de las apuestas Baloto.
 */
public class ApuestaBalotoDAO {

	/** Lista que almacena objetos de tipo ApuestaBalotoDTO. */
	private ArrayList<ApuestaBalotoDTO> apuestasBaloto;

	/**
	 * Objeto que maneja la escritura y lectura de archivos para las apuestas
	 * Baloto.
	 */
	private ArchivoBaloto archivoBaloto;

	/**
	 * Constructor de la clase ApuestaBalotoDAO. Inicializa la lista de apuestas
	 * Baloto y el objeto de archivo.
	 */
	public ApuestaBalotoDAO() {
		apuestasBaloto = new ArrayList<ApuestaBalotoDTO>();
		archivoBaloto = new ArchivoBaloto();
	}

	/**
	 * Crea una nueva apuesta Baloto y la agrega a la lista de apuestas.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param cedula       Número de cédula del apostador que realiza la apuesta.
	 * @param diaApuesta   Día en el que se realiza la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 * @param numApostado  Números apostados en la apuesta.
	 * @return Mensaje indicando el resultado de la creación de la apuesta.
	 */
	public String crearApuestaBaloto(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String numApostado) {
		String salida = null;
		boolean verificacion = false;
		String[] numerosString = numApostado.split(" ");
		int[] numeros = new int[numerosString.length];
		for (int i = 0; i < numerosString.length; i++) {
			numeros[i] = Integer.parseInt(numerosString[i]);
			if (numeros[i] > 1 && numeros[i] < 45) {
				verificacion = true;
			} else {
				verificacion = false;
			}
		}

		for (int i = 0; i < numeros.length; i++) {
			int tmp = numeros[i];
			for (int j = 1; i < numeros.length; i++) {
				if (tmp != numeros[j]) {
					verificacion = true;
				} else {
					verificacion = false;
				}
			}
		}
		if (numerosString.length != 6) {
			salida = "Deben haber 6 números.";
			verificacion = false;
		}

		if (verificacion == true) {
			archivoBaloto.crearArchivo();
			numApostado = numApostado.replaceAll("\\s+", "");
			apuestasBaloto.add(
					new ApuestaBalotoDTO(nombreSede, cedula, diaApuesta, valorApuesta, Integer.parseInt(numApostado)));
			archivoBaloto.escribirArchivo(apuestasBaloto);
			salida = "Apuesta realizada exitosamente";
		} else {
			salida = "Error, debe ingresar 6 numeros que no se repitan y que estén entre 1 y 45";
		}

		return salida;
	}

	/**
	 * Modifica una apuesta Baloto existente en la lista.
	 *
	 * @param nombreSede       Nombre de la sede donde se realiza la apuesta.
	 * @param cedula           Número de cédula del apostador que realiza la
	 *                         apuesta.
	 * @param diaApuesta       Día en el que se realiza la apuesta.
	 * @param valorApuesta     Valor de la apuesta.
	 * @param numApostado      Números apostados en la apuesta a modificar.
	 * @param nuevoNumApostado Nuevos números apostados.
	 * @return Mensaje indicando el resultado de la modificación de la apuesta.
	 */
	public String modificarApuestaBaloto(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String numApostado, String nuevoNumApostado) {

		String salida = null;

		for (int i = 0; i < apuestasBaloto.size(); i++) {

			if (nombreSede.equalsIgnoreCase(apuestasBaloto.get(i).getNombreSede())
					&& cedula == apuestasBaloto.get(i).getNumCedula()
					&& Integer.parseInt(numApostado) == apuestasBaloto.get(i).getNumeroApostado()) {

				numApostado = numApostado.replaceAll("\\s+", "");
				boolean verificacion = false;
				String[] numerosString = nuevoNumApostado.split(" ");
				int[] numeros = new int[numerosString.length];

				for (int j = 0; j < numerosString.length; j++) {
					numeros[j] = Integer.parseInt(numerosString[j]);
					if (numeros[j] >= 1 && numeros[j] <= 45) {
						verificacion = true;
					} else {
						verificacion = false;
						salida = "los numeros no estan entre 1 y 45";
					}
				}

				for (int j = 0; j < numeros.length; j++) {
					int tmp = numeros[j];
					for (int k = j++; k < numeros.length; k++) {
						if (tmp != numeros[k]) {
							verificacion = true;
						} else {
							verificacion = false;
							salida = "Los números " + numeros[j] + " y " + numeros[k] + " se repiten";
						}
					}
				}
				if (numerosString.length != 6) {
					salida = "Deben haber 6 números.";
					verificacion = false;
				}

				if (verificacion == true) {
					File f = new File("data/apuestas-baloto.dat");
					f.delete();
					archivoBaloto.crearArchivo();
					nuevoNumApostado = nuevoNumApostado.replaceAll("\\s+", "");
					apuestasBaloto.set(i, new ApuestaBalotoDTO(nombreSede, cedula, diaApuesta, valorApuesta,
							Integer.parseInt(nuevoNumApostado)));
					archivoBaloto.escribirArchivo(apuestasBaloto);
					salida = "Apuesta realizada exitosamente";
				}
			}
		}
		return salida;
	}

	/**
	 * Obtiene una representación en cadena de todas las apuestas Baloto.
	 *
	 * @return Cadena que representa a todas las apuestas Baloto.
	 */
	public String leerApuestas() {
		String printable = "";
		for (ApuestaBalotoDTO apuestaBalotoDTO : apuestasBaloto) {
			printable += apuestaBalotoDTO.toString();
		}
		return printable;
	}

	/**
	 * Elimina una apuesta Baloto de la lista.
	 *
	 * @param cedula         Número de cédula del apostador que realizó la apuesta.
	 * @param numeroApostado Números apostados en la apuesta a eliminar.
	 */

	public void eliminarApuestaBaloto(long cedula, String numeroApostado) {
		numeroApostado = numeroApostado.replaceAll("\\s+", "");
		for (int i = 0; i < apuestasBaloto.size(); i++) {
			if (cedula == apuestasBaloto.get(i).getNumCedula()
					&& Integer.parseInt(numeroApostado) == apuestasBaloto.get(i).getNumeroApostado()) {
				apuestasBaloto.remove(i);
			}
		}
		File tmp = new File("data/apuestas-baloto.dat");
		tmp.delete();
		archivoBaloto.crearArchivo();
		archivoBaloto.escribirArchivo(apuestasBaloto);
	}

	/**
	 * Inicializa la lista de apuestas Baloto a partir de un archivo.
	 */
	public void inicializarArchivo() {
		apuestasBaloto = archivoBaloto.inicializarArchivo();
	}

	/**
	 * Obtiene la lista de apuestas Baloto.
	 *
	 * @return Lista de apuestas Baloto.
	 */
	public ArrayList<ApuestaBalotoDTO> getApuestasBaloto() {
		return apuestasBaloto;
	}

	/**
	 * Establece la lista de apuestas Baloto.
	 *
	 * @param apuestasBaloto Nueva lista de apuestas Baloto.
	 */
	public void setApuestasBaloto(ArrayList<ApuestaBalotoDTO> apuestasBaloto) {
		this.apuestasBaloto = apuestasBaloto;
	}

	/**
	 * Obtiene el objeto ArchivoBaloto utilizado para la escritura y lectura de
	 * archivos.
	 *
	 * @return Objeto ArchivoBaloto.
	 */
	public ArchivoBaloto getArchivoBaloto() {
		return archivoBaloto;
	}

	/**
	 * Establece el objeto ArchivoBaloto utilizado para la escritura y lectura de
	 * archivos.
	 *
	 * @param archivoBaloto Nuevo objeto ArchivoBaloto.
	 */
	public void setArchivoBaloto(ArchivoBaloto archivoBaloto) {
		this.archivoBaloto = archivoBaloto;
	}
	
}