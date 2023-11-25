package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase que maneja la persistencia de las sedes en un archivo.
 */
public class ArchivoSedes {
	/**
	 * Archivo que almacena la información de las sedes.
	 */
	private File archivoSedes;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de sedes.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoSedes.
	 */
	public ArchivoSedes() {
		archivoSedes = new File("data/sedes.dat");
	}

	/**
	 * Crea el archivo de sedes si no existe.
	 */
	public void crearArchivo() {
		if (!archivoSedes.exists()) {
			try {
				archivoSedes.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe la lista de sedes en el archivo.
	 *
	 * @param sedes Lista de sedes a escribir en el archivo.
	 */
	public void escribirArchivoSedes(ArrayList<SedesDTO> sedes) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivoSedes));
			oos.writeObject(sedes);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 *
	 * @return Lista de sedes leída desde el archivo.
	 */
	public ArrayList<SedesDTO> initializeFile() {
		ArrayList<SedesDTO> g = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSedes))) {
			Object obj = ois.readObject();
			g = (ArrayList<SedesDTO>) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return g;
	}

	public File getArchivoSedes() {
		return archivoSedes;
	}

	public void setArchivoSedes(File archivoSedes) {
		this.archivoSedes = archivoSedes;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
	
}
