package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase que representa el acceso a datos para las apuestas de lotería.
 */
public class ApuestaLoteriaDAO {
    private ArrayList<ApuestaLoteriaDTO> apuestasLoteria;
    private ArchivoLoteria archivoLoteria;

    /**
     * Constructor de la clase.
     */
    public ApuestaLoteriaDAO() {
        apuestasLoteria = new ArrayList<ApuestaLoteriaDTO>();
        archivoLoteria = new ArchivoLoteria();
    }

    /**
     * Crea una nueva apuesta de lotería y la guarda en el archivo.
     *
     * @param nombreSede       Nombre de la sede donde se realiza la apuesta.
     * @param cedula           Número de cédula del apostador.
     * @param diaApuesta       Día en que se realiza la apuesta.
     * @param valorApuesta     Valor de la apuesta.
     * @param nombreLoteria    Nombre de la lotería en la que se realiza la apuesta.
     * @param numeroApostado   Número apostado en la lotería.
     * @param numeroSerie      Número de serie de la lotería.
     */
    public void crearApuestaLoteria(String nombreSede, long cedula, String diaApuesta, double valorApuesta,
            String nombreLoteria, int numeroApostado, int numeroSerie) {

        apuestasLoteria.add(new ApuestaLoteriaDTO(nombreSede, cedula, diaApuesta, valorApuesta, nombreLoteria,
                numeroApostado, numeroSerie));
        archivoLoteria.crearArchivo();
        archivoLoteria.escribirArchivo(apuestasLoteria);
    }

    /**
     * Obtiene una representación en cadena de todas las apuestas de lotería.
     *
     * @return Cadena con la información de las apuestas de lotería.
     */
    public String leerApuestas() {
        inicializarApuestasLoteria();
        String printable = "";
        for (ApuestaLoteriaDTO apuestaLoteria : apuestasLoteria) {
            printable += apuestaLoteria.toString();
        }
        return printable;
    }

    /**
     * Modifica una apuesta de lotería y actualiza la información en el archivo.
     *
     * @param nombreSede            Nuevo nombre de la sede donde se realiza la apuesta.
     * @param cedula                Nueva número de cédula del apostador.
     * @param diaApuesta            Nuevo día en que se realiza la apuesta.
     * @param anteriorNumeroApostado Antiguo número apostado en la lotería.
     * @param nuevoValorApuesta     Nuevo valor de la apuesta.
     * @param nuevoNombreLoteria    Nuevo nombre de la lotería en la que se realiza la apuesta.
     * @param nuevoNumeroApostado   Nuevo número apostado en la lotería.
     * @param nuevoNumeroSerie      Nuevo número de serie de la lotería.
     */
    public void modificarApuestaLoteria(String nombreSede, long cedula, String diaApuesta, int anteriorNumeroApostado,
            double nuevoValorApuesta, String nuevoNombreLoteria, int nuevoNumeroApostado, int nuevoNumeroSerie) {

        for (int i = 0; i < apuestasLoteria.size(); i++) {
            if (cedula == apuestasLoteria.get(i).getNumCedula()
                    && anteriorNumeroApostado == apuestasLoteria.get(i).getNumeroApostado()) {
                apuestasLoteria.set(i, new ApuestaLoteriaDTO(nombreSede, cedula, diaApuesta, nuevoValorApuesta,
                        nuevoNombreLoteria, nuevoNumeroApostado, nuevoNumeroSerie));
            }
            File tmp = new File("data/apuestas-loteria.dat");
            tmp.delete();
            archivoLoteria.crearArchivo();
            archivoLoteria.escribirArchivo(apuestasLoteria);
        }
    }

    /**
     * Elimina una apuesta de lotería y actualiza la información en el archivo.
     *
     * @param cedula          Número de cédula del apostador.
     * @param numeroApostado  Número apostado en la lotería.
     */
    public void eliminarApuestaLoteria(long cedula, int numeroApostado) {
        for (int i = 0; i < apuestasLoteria.size(); i++) {
            if (cedula == apuestasLoteria.get(i).getNumCedula()
                    && numeroApostado == apuestasLoteria.get(i).getNumeroApostado()) {
                apuestasLoteria.remove(i);
            }
        }
        File tmp = new File("data/apuestas-loteria.dat");
        tmp.delete();
        archivoLoteria.crearArchivo();
        archivoLoteria.escribirArchivo(apuestasLoteria);
    }

    /**
     * Inicializa la lista de apuestas de lotería desde el archivo.
     */
    public void inicializarApuestasLoteria() {
        apuestasLoteria = archivoLoteria.inicializarArchivo();
    }

    /**
     * Obtiene la lista de apuestas de lotería.
     *
     * @return Lista de apuestas de lotería.
     */
    public ArrayList<ApuestaLoteriaDTO> getApuestasLoteria() {
        return apuestasLoteria;
    }

    /**
     * Establece la lista de apuestas de lotería.
     *
     * @param apuestasLoteria Nueva lista de apuestas de lotería.
     */
    public void setApuestasLoteria(ArrayList<ApuestaLoteriaDTO> apuestasLoteria) {
        this.apuestasLoteria = apuestasLoteria;
    }

    /**
     * Obtiene el archivo de lotería.
     *
     * @return Archivo de lotería.
     */

	public ArchivoLoteria getArchivoLoteria() {
		return archivoLoteria;
	}
	/**
     * Establece el archivo de lotería.
     *
     * @param archivoLoteria Nuevo archivo de lotería.
     */
    public void setArchivoLoteria(ArchivoLoteria archivoLoteria) {
        this.archivoLoteria = archivoLoteria;
    }

}
	
