package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que representa un DAO para las apuestas Betplay.
 */
public class ApuestaBetplayDAO {

	/** Lista de apuestas Betplay. */
	private ArrayList<ApuestaBetplayDTO> apuestaBetplay;

	/** Objeto ArchivoBetplay utilizado para la escritura y lectura de archivos. */
	private ArchivoBetplay archivoBetplay;

	/**
	 * Constructor de la clase ApuestaBetplayDAO.
	 */
	public ApuestaBetplayDAO() {
		apuestaBetplay = new ArrayList<ApuestaBetplayDTO>();
		archivoBetplay = new ArchivoBetplay();
	}

	/**
	 * Crea una nueva apuesta Betplay.
	 *
	 * @param nombreSede   Nombre de la sede donde se realiza la apuesta.
	 * @param cedula       Número de cédula del apostador que realiza la apuesta.
	 * @param diaApuesta   Día en el que se realiza la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 * @param partido1     Resultado del partido 1.
	 * @param partido2     Resultado del partido 2.
	 * @param partido3     Resultado del partido 3.
	 * @param partido4     Resultado del partido 4.
	 * @param partido5     Resultado del partido 5.
	 * @param partido6     Resultado del partido 6.
	 * @param partido7     Resultado del partido 7.
	 * @param partido8     Resultado del partido 8.
	 * @param partido9     Resultado del partido 9.
	 * @param partido10    Resultado del partido 10.
	 * @param partido11    Resultado del partido 11.
	 * @param partido12    Resultado del partido 12.
	 * @param partido13    Resultado del partido 13.
	 * @param partido14    Resultado del partido 14.
	 * @return Mensaje indicando si la apuesta fue realizada correctamente o si hay
	 *         algún error.
	 */
	public String crearApuestaBetplay(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
			String partido1, String partido2, String partido3, String partido4, String partido5, String partido6,
			String partido7, String partido8, String partido9, String partido10, String partido11, String partido12,
			String partido13, String partido14) {
		String salida = null;
		if (!partido1.equalsIgnoreCase(null) && !partido2.equalsIgnoreCase(null) && !partido3.equalsIgnoreCase(null)
				&& !partido4.equalsIgnoreCase(null) && !partido5.equalsIgnoreCase(null)
				&& !partido6.equalsIgnoreCase(null) && !partido7.equalsIgnoreCase(null)
				&& !partido8.equalsIgnoreCase(null) && !partido9.equalsIgnoreCase(null)
				&& !partido10.equalsIgnoreCase(null) && !partido11.equalsIgnoreCase(null)
				&& !partido12.equalsIgnoreCase(null) && !partido13.equalsIgnoreCase(null)
				&& !partido14.equalsIgnoreCase(null)) {

			archivoBetplay.crearArchivo();
			apuestaBetplay.add(new ApuestaBetplayDTO(nombreSede, cedula, diaApuesta, valorApuesta, partido1, partido2,
					partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10, partido11,
					partido12, partido13, partido14));
			archivoBetplay.escribirArchivo(apuestaBetplay);
			salida = "Apuesta realizada correctamente";
		} else {
			salida = "Debe llenar los resultados de todos los partidos";
		}
		return salida;
	}

	/**
	 * Modifica una apuesta Betplay existente.
	 *
	 * @param nombreSede         Nombre de la sede donde se realiza la apuesta.
	 * @param cedula             Número de cédula del apostador que realiza la
	 *                           apuesta.
	 * @param diaApuestaAnterior Día en el que se realizó la apuesta anteriormente.
	 * @param diaApuesta         Nuevo día en el que se realiza la apuesta.
	 * @param valorApuesta       Nuevo valor de la apuesta.
	 * @param partido1           Nuevo resultado del partido 1.
	 * @param partido2           Nuevo resultado del partido 2.
	 * @param partido3           Nuevo resultado del partido 3.
	 * @param partido4           Nuevo resultado del partido 4.
	 * @param partido5           Nuevo resultado del partido 5.
	 * @param partido6           Nuevo resultado del partido 6.
	 * @param partido7           Nuevo resultado del partido 7.
	 * @param partido8           Nuevo resultado del partido 8.
	 * @param partido9           Nuevo resultado del partido 9.
	 * @param partido10          Nuevo resultado del partido 10.
	 * @param partido11          Nuevo resultado del partido 11.
	 * @param partido12          Nuevo resultado del partido 12.
	 * @param partido13          Nuevo resultado del partido 13.
	 * @param partido14          Nuevo resultado del partido 14.
	 * @return Mensaje indicando si la apuesta fue modificada correctamente o si hay
	 *         algún error.
	 */
	public String modificarApuestaBetplay(String nombreSede, long cedula, String diaApuestaAnterior, String diaApuesta,
			double valorApuesta, String partido1, String partido2, String partido3, String partido4, String partido5,
			String partido6, String partido7, String partido8, String partido9, String partido10, String partido11,
			String partido12, String partido13, String partido14) {
		if (!partido1.equalsIgnoreCase(null) && !partido2.equalsIgnoreCase(null) && !partido3.equalsIgnoreCase(null)
				&& !partido4.equalsIgnoreCase(null) && !partido5.equalsIgnoreCase(null)
				&& !partido6.equalsIgnoreCase(null) && !partido7.equalsIgnoreCase(null)
				&& !partido8.equalsIgnoreCase(null) && !partido9.equalsIgnoreCase(null)
				&& !partido10.equalsIgnoreCase(null) && !partido11.equalsIgnoreCase(null)
				&& !partido12.equalsIgnoreCase(null) && !partido13.equalsIgnoreCase(null)
				&& !partido14.equalsIgnoreCase(null)) {
			for (int i = 0; i < apuestaBetplay.size(); i++) {
				if (cedula == apuestaBetplay.get(i).getNumCedula()
						&& diaApuesta.equalsIgnoreCase(apuestaBetplay.get(i).getDiaApuesta())) {

					apuestaBetplay.set(i,
							new ApuestaBetplayDTO(nombreSede, cedula, diaApuesta, valorApuesta, partido1, partido2,
									partido3, partido4, partido5, partido6, partido7, partido8, partido9, partido10,
									partido11, partido12, partido13, partido14));
				}
			}
			File f = new File("data/apuestas-betplay.dat");
			f.delete();
			archivoBetplay.crearArchivo();
			archivoBetplay.escribirArchivo(apuestaBetplay);
			return "Apuesta modificada correctamente";
		} else {
			return "Debe llenar todos los partidos";
		}
	}

	/**
	 * Obtiene una cadena con la información de todas las apuestas Betplay.
	 *
	 * @return Cadena con la información de todas las apuestas Betplay.
	 */
	public String leerApuestas() {
		String printable = "";
		for (ApuestaBetplayDTO apuestaBetplayDTO : apuestaBetplay) {
			printable += apuestaBetplayDTO.toString();
		}
		return printable;
	}

	/**
	 * Elimina una apuesta Betplay.
	 *
	 * @param cedula     Número de cédula del apostador que realizó la apuesta.
	 * @param diaApuesta Día en el que se realizó la apuesta.
	 * @return Mensaje indicando si la apuesta fue eliminada correctamente o si hay
	 *         algún error.
	 */
	public String eliminarApuestaBetplay(long cedula, String diaApuesta) {
		boolean temp = true;
		String salida = null;
		for (int i = 0; i < apuestaBetplay.size(); i++) {
			if (cedula == apuestaBetplay.get(i).getNumCedula()
					&& diaApuesta.equalsIgnoreCase(apuestaBetplay.get(i).getDiaApuesta())) {

				apuestaBetplay.remove(i);
				File f = new File("data/apuestas-betplay.dat");
				f.delete();
				archivoBetplay.crearArchivo();
				archivoBetplay.escribirArchivo(apuestaBetplay);
				temp = true;

			} else {
				temp = false;
			}

			if (temp == true) {
				salida = "Apuesta eliminada exitosamente";
			}
		}
		return salida;
	}

	/**
	 * Inicializa la lista de apuestas Betplay desde el archivo de datos.
	 */
	public void inicializarApuestasBetplay() {
		apuestaBetplay = archivoBetplay.inicializarArchivo();
	}

	/**
	 * Obtiene la lista de apuestas Betplay.
	 *
	 * @return Lista de apuestas Betplay.
	 */
	public ArrayList<ApuestaBetplayDTO> getApuestaBetplay() {
		return apuestaBetplay;
	}

	/**
	 * Establece la lista de apuestas Betplay.
	 *
	 * @param apuestaBetplay Lista de apuestas Betplay a establecer.
	 */
	public void setApuestaBetplay(ArrayList<ApuestaBetplayDTO> apuestaBetplay) {
		this.apuestaBetplay = apuestaBetplay;
	}

	/**
	 * Obtiene el objeto ArchivoBetplay utilizado para la escritura y lectura de
	 * archivos.
	 *
	 * @return Objeto ArchivoBetplay.
	 */
	public ArchivoBetplay getArchivoBetplay() {
		return archivoBetplay;
	}

	/**
	 * Establece el objeto ArchivoBetplay utilizado para la escritura y lectura de
	 * archivos.
	 *
	 * @param archivoBetplay Objeto ArchivoBetplay a establecer.
	 */
	public void setArchivoBetplay(ArchivoBetplay archivoBetplay) {
		this.archivoBetplay = archivoBetplay;
	}
	
	
}
