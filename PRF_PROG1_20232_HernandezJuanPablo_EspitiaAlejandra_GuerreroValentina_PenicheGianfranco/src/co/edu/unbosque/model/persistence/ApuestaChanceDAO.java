package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que gestiona las apuestas de tipo Chance.
 */
public class ApuestaChanceDAO {
	/**
	 * Lista de apuestas Chance.
	 */
	private ArrayList<ApuestaChanceDTO> apuestasChance;

	/**
	 * Objeto que maneja el archivo de las apuestas Chance.
	 */
	private ArchivoChance archivoChance;

	/**
	 * Constructor de la clase.
	 */
	public ApuestaChanceDAO() {
		apuestasChance = new ArrayList<ApuestaChanceDTO>();
		archivoChance = new ArchivoChance();
	}

	/**
	 * Crea una nueva apuesta Chance y la almacena en el archivo.
	 *
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param cedula         Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor de la apuesta.
	 * @param nombreLoteria  Nombre de la lotería en la que se realiza la apuesta.
	 * @param numeroApostado Número apostado en la lotería.
	 */
	public void crearApuestaChance(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String nombreLoteria, int numeroApostado) {
		apuestasChance
				.add(new ApuestaChanceDTO(nombreSede, cedula, diaApuesta, valorApuesta, nombreLoteria, numeroApostado));
		archivoChance.crearArchivo();
		archivoChance.escribirArchivo(apuestasChance);
	}

	/**
	 * Modifica una apuesta Chance y actualiza el archivo.
	 *
	 * @param nombreSede             Nuevo nombre de la sede donde se realiza la
	 *                               apuesta.
	 * @param cedula                 Nueva número de cédula del apostador.
	 * @param diaApuesta             Nuevo día en que se realiza la apuesta.
	 * @param anteriorNumeroApostado Número apostado anterior en la lotería.
	 * @param nuevoValorApuesta      Nuevo valor de la apuesta.
	 * @param nuevoNombreLoteria     Nuevo nombre de la lotería en la que se realiza
	 *                               la apuesta.
	 * @param nuevoNumeroApostado    Nuevo número apostado en la lotería.
	 */
	public void modificarApuestaChance(String nombreSede, long cedula, String diaApuesta, int anteriorNumeroApostado,
			double nuevoValorApuesta, String nuevoNombreLoteria, int nuevoNumeroApostado) {
		for (int i = 0; i < apuestasChance.size(); i++) {
			if (cedula == apuestasChance.get(i).getNumCedula()
					&& anteriorNumeroApostado == apuestasChance.get(i).getNumeroApostado()) {
				apuestasChance.set(i, new ApuestaChanceDTO(nombreSede, cedula, diaApuesta, nuevoValorApuesta,
						nuevoNombreLoteria, nuevoNumeroApostado));
			}
			File tmp = new File("data/apuestas-chance.dat");
			tmp.delete();
			archivoChance.crearArchivo();
			archivoChance.escribirArchivo(apuestasChance);
		}
	}

	/**
	 * Obtiene una representación en cadena de todas las apuestas Chance.
	 *
	 * @return Cadena con la información de todas las apuestas Chance.
	 */
	public String leerApuestas() {
		String printable = "";
		for (ApuestaChanceDTO apuestaChanceDTO : apuestasChance) {
			printable += apuestaChanceDTO.toString();
		}
		return printable;
	}

	/**
	 * Elimina una apuesta Chance y actualiza el archivo.
	 *
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Número apostado en la lotería.
	 */
	public void eliminarApuestaChance(long cedula, int numeroApostado) {
		for (int i = 0; i < apuestasChance.size(); i++) {
			if (cedula == apuestasChance.get(i).getNumCedula()
					&& numeroApostado == apuestasChance.get(i).getNumeroApostado()) {
				apuestasChance.remove(i);
			}
		}
		File tmp = new File("data/apuestas-chance.dat");
		tmp.delete();
		archivoChance.crearArchivo();
		archivoChance.escribirArchivo(apuestasChance);
	}

	/**
	 * Inicializa la lista de apuestas Chance a partir del archivo.
	 */
	public void inicializarApuestasChance() {
		apuestasChance = archivoChance.inicializarArchivo();
	}

	/**
	 * Obtiene la lista de apuestas Chance.
	 *
	 * @return Lista de apuestas Chance.
	 */
	public ArrayList<ApuestaChanceDTO> getApuestasChance() {
		return apuestasChance;
	}

	/**
	 * Establece la lista de apuestas Chance.
	 *
	 * @param apuestasChance Lista de apuestas Chance.
	 */
	public void setApuestasChance(ArrayList<ApuestaChanceDTO> apuestasChance) {
		this.apuestasChance = apuestasChance;
	}

	/**
	 * Obtiene el objeto ArchivoChance.
	 *
	 * @return Objeto ArchivoChance.
	 */
	public ArchivoChance getArchivoChance() {
		return archivoChance;
	}

	/**
	 * Establece el objeto ArchivoChance.
	 *
	 * @param archivoChance Objeto ArchivoChance.
	 */
	public void setArchivoChance(ArchivoChance archivoChance) {
		this.archivoChance = archivoChance;
	}
	
}
