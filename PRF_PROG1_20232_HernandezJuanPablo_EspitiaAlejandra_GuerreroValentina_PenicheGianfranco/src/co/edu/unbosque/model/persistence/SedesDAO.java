package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * La clase SedesDAO proporciona métodos para gestionar sedes y almacenar información relacionada en archivos.
 */
public class SedesDAO {

    /** Lista de sedes. */
    private ArrayList<SedesDTO> sedes;

    /** Instancia de ArchivoSedes para trabajar con archivos de sedes. */
    private ArchivoSedes archivoSedes;

    /**
     * Constructor de la clase SedesDAO.
     * Inicializa la instancia de ArchivoSedes y la lista de sedes.
     */
    public SedesDAO() {
        archivoSedes = new ArchivoSedes();
        sedes = new ArrayList<SedesDTO>();
    }

    /**
     * Crea una sede y gestiona su información.
     *
     * @param cantidadSedes       Cantidad total de sedes que se espera gestionar.
     * @param localidad           Localidad de la sede.
     * @param cantidadEmpleados   Cantidad de empleados de la sede.
     * @return Confirmación de la creación del archivo de sedes o el estado actual de la gestión.
     */
    public String crearSede(int cantidadSedes, String localidad, int cantidadEmpleados) {
        sedes.add(new SedesDTO(localidad, cantidadEmpleados));
        String confirmacion = "";
        if (sedes.size() == cantidadSedes) {
            archivoSedes.crearArchivo();
            archivoSedes.escribirArchivoSedes(sedes);
            confirmacion = "Archivo de sedes creado exitosamente";
        } else {
            confirmacion = "Aun no has gestionado todas las sedes.";
        }

        return confirmacion;
    }

    /**
     * Modifica la información de una sede existente.
     *
     * @param localidadAnt        Localidad actual de la sede a modificar.
     * @param localidadNueva      Nueva localidad de la sede.
     * @param numEmpleadosNuevo   Nueva cantidad de empleados de la sede.
     */
    public void modificarSede(String localidadAnt, String localidadNueva, int numEmpleadosNuevo) {
        for (int i = 0; i < sedes.size(); i++) {
            if (sedes.get(i).getUbicacionLocalidad().equalsIgnoreCase(localidadAnt)) {
                sedes.set(i, new SedesDTO(localidadNueva, numEmpleadosNuevo));
                File tmp = new File("data/sedes.dat");
                tmp.delete();
                archivoSedes.crearArchivo();
                archivoSedes.escribirArchivoSedes(sedes);
            } else {
                System.out.println("Sede no encontrada.");
            }
        }
    }

    /**
     * Lee la información de todas las sedes disponibles.
     *
     * @return Cadena con la información de las sedes.
     */
    public String leerSedes() {
        String sedesDisponibles = "";
        for (int i = 0; i < sedes.size(); i++) {
            sedesDisponibles = sedesDisponibles.concat("\n" + sedes.get(i).getUbicacionLocalidad());
        }
        return sedesDisponibles;
    }

    /**
     * Elimina una sede y actualiza el archivo de sedes.
     *
     * @param localidad       Localidad de la sede a eliminar.
     * @param cantidadSedes   Cantidad total de sedes que se espera gestionar.
     * @return Confirmación del estado de la gestión de sedes.
     */
    public String eliminarSedes(String localidad, int cantidadSedes) {
        String confirmacion = null;
        SedesDTO encontrado = null;
        for (int i = 0; i < sedes.size(); i++) {
            if (localidad.equalsIgnoreCase(sedes.get(i).getUbicacionLocalidad())) {
                encontrado = sedes.get(i);
            }
        }
        sedes.remove(encontrado);
        if (sedes.size() == cantidadSedes) {
            confirmacion = "Sedes gestionadas correctamente";
            File archivo = new File("data/sedes.dat");
            archivo.delete();
            archivoSedes.crearArchivo();
            archivoSedes.escribirArchivoSedes(sedes);
        } else {
            confirmacion = "Aun no ha gestionado todas las sedes, debe seguir eliminando sedes hasta igualar el número de sedes ingresado anteriormente.";
        }
        return confirmacion;
    }

    /**
     * Inicializa la lista de sedes desde el archivo existente.
     */
    public void inicializarSedes() {
        sedes = archivoSedes.initializeFile();
    }

    /**
     * Obtiene la lista de sedes.
     *
     * @return Lista de sedes.
     */
    public ArrayList<SedesDTO> getSedes() {
        return sedes;
    }

    /**
     * Establece la lista de sedes.
     *
     * @param sedes Nueva lista de sedes.
     */
    public void setSedes(ArrayList<SedesDTO> sedes) {
        this.sedes = sedes;
    }

    /**
     * Obtiene la instancia de ArchivoSedes.
     *
     * @return Instancia de ArchivoSedes.
     */
    public ArchivoSedes getArchivoSedes() {
        return archivoSedes;
    }

    /**
     * Establece la instancia de ArchivoSedes.
     *
     * @param archivoSedes Nueva instancia de ArchivoSedes.
     */
    public void setArchivoSedes(ArchivoSedes archivoSedes) {
        this.archivoSedes = archivoSedes;
	}
	
	
}
