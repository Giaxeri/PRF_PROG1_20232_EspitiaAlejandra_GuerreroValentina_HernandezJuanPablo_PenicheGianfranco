package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que gestiona las apuestas de Superastro.
 */
public class ApuestaSuperastroDAO {
	private ArrayList<ApuestaSuperastroDTO> apuestasSuperastro;
	private ArchivoSuperastro archivoSuperastro;

	/**
	 * Constructor de la clase ApuestaSuperastroDAO. Inicializa la lista de apuestas
	 * de Superastro y el archivo correspondiente.
	 */
	public ApuestaSuperastroDAO() {
		apuestasSuperastro = new ArrayList<ApuestaSuperastroDTO>();
		archivoSuperastro = new ArchivoSuperastro();
	}

	/**
	 * Crea una nueva apuesta de Superastro y la agrega a la lista.
	 * 
	 * @param nombreSede     Nombre de la sede donde se realiza la apuesta.
	 * @param cedula         Número de cédula del apostador.
	 * @param diaApuesta     Día en que se realiza la apuesta.
	 * @param valorApuesta   Valor apostado.
	 * @param signoZodiaco   Signo zodiacal seleccionado.
	 * @param numeroApostado Número apostado en Superastro.
	 */
	public void crearApuestaSuperastro(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String signoZodiaco, int numeroApostado) {
		apuestasSuperastro.add(
				new ApuestaSuperastroDTO(nombreSede, cedula, diaApuesta, valorApuesta, numeroApostado, signoZodiaco));
		archivoSuperastro.crearArchivo();
		archivoSuperastro.escribirArchivo(apuestasSuperastro);
	}

	/**
	 * Modifica una apuesta de Superastro existente.
	 * 
	 * @param nombreSede             Nombre de la sede donde se realiza la apuesta.
	 * @param cedula                 Número de cédula del apostador.
	 * @param diaApuesta             Día en que se realiza la apuesta.
	 * @param anteriorNumeroApostado Número apostado anteriormente.
	 * @param nuevoValorApuesta      Nuevo valor apostado.
	 * @param nuevoSignoZodiaco      Nuevo signo zodiacal seleccionado.
	 * @param nuevoNumeroApostado    Nuevo número apostado en Superastro.
	 */
	public void modificarApuestaSuperastro(String nombreSede, long cedula, String diaApuesta,
			int anteriorNumeroApostado, double nuevoValorApuesta, String nuevoSignoZodiaco, int nuevoNumeroApostado) {
		for (int i = 0; i < apuestasSuperastro.size(); i++) {
			if (cedula == apuestasSuperastro.get(i).getNumCedula()
					&& anteriorNumeroApostado == apuestasSuperastro.get(i).getNumeroApostado()) {
				apuestasSuperastro.set(i, new ApuestaSuperastroDTO(nombreSede, cedula, diaApuesta, nuevoValorApuesta,
						nuevoNumeroApostado, nuevoSignoZodiaco));
			}
			File tmp = new File("data/apuestas-superastro.dat");
			tmp.delete();
			archivoSuperastro.crearArchivo();
			archivoSuperastro.escribirArchivo(apuestasSuperastro);
		}
	}

	/**
	 * Obtiene una representación en cadena de todas las apuestas de Superastro.
	 * 
	 * @return Cadena con información de todas las apuestas de Superastro.
	 */
	public String leerApuestas() {
		String printable = "";
		for (ApuestaSuperastroDTO apuestaSuperastroDTO : apuestasSuperastro) {
			printable += apuestaSuperastroDTO.toString();
		}
		return printable;
	}

	/**
	 * Elimina una apuesta de Superastro existente.
	 * 
	 * @param cedula         Número de cédula del apostador.
	 * @param numeroApostado Número apostado en Superastro.
	 */
	public void eliminarApuestaSuperastro(long cedula, int numeroApostado) {
		for (int i = 0; i < apuestasSuperastro.size(); i++) {
			if (cedula == apuestasSuperastro.get(i).getNumCedula()
					&& numeroApostado == apuestasSuperastro.get(i).getNumeroApostado()) {
				apuestasSuperastro.remove(i);
			}
		}
		File tmp = new File("data/apuestas-superastro.dat");
		tmp.delete();
		archivoSuperastro.crearArchivo();
		archivoSuperastro.escribirArchivo(apuestasSuperastro);
	}

	/**
	 * Inicializa las apuestas de Superastro desde el archivo de datos.
	 */
	public void inicializarApuestasSuperastro() {
		apuestasSuperastro = archivoSuperastro.inicializarArchivo();
	}

	/**
	 * Obtiene la lista de apuestas de Superastro.
	 * 
	 * @return Lista de apuestas de Superastro.
	 */
	public ArrayList<ApuestaSuperastroDTO> getApuestasSuperastro() {
		return apuestasSuperastro;
	}

	/**
	 * Establece la lista de apuestas de Superastro.
	 * 
	 * @param apuestasSuperastro Nueva lista de apuestas de Superastro.
	 */
	public void setApuestasSuperastro(ArrayList<ApuestaSuperastroDTO> apuestasSuperastro) {
		this.apuestasSuperastro = apuestasSuperastro;
	}

	/**
	 * Obtiene el archivo de Superastro utilizado para almacenar las apuestas.
	 * 
	 * @return Archivo de Superastro.
	 */

	public ArchivoSuperastro getArchivoSuperastro() {
		return archivoSuperastro;
	}

	/**
	 * Establece el archivo de Superastro utilizado para almacenar las apuestas.
	 * 
	 * @param archivoSuperastro Nuevo archivo de Superastro.
	 */
	public void setArchivoSuperastro(ArchivoSuperastro archivoSuperastro) {
		this.archivoSuperastro = archivoSuperastro;
	}

}
