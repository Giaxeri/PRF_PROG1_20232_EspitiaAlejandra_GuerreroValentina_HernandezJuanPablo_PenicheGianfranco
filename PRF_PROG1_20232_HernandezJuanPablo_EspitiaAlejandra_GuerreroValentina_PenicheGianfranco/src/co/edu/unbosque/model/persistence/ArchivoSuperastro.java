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
 * Clase que maneja la persistencia de las apuestas de Superastro en un archivo.
 */
public class ArchivoSuperastro {
	/**
	 * Archivo que almacena la información de las apuestas de Superastro.
	 */
	private File fileApuesta;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de apuestas de
	 * Superastro.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoSuperastro.
	 */
	public ArchivoSuperastro() {
		fileApuesta = new File("data/apuestas-superastro.dat");
	}

	/**
	 * Crea el archivo de apuestas de Superastro si no existe.
	 */
	public void crearArchivo() {
		if (!fileApuesta.exists()) {
			try {
				fileApuesta.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe la lista de apuestas de Superastro en el archivo.
	 *
	 * @param sup Lista de apuestas de Superastro a escribir en el archivo.
	 */
	public void escribirArchivo(ArrayList<ApuestaSuperastroDTO> sup) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileApuesta));
			oos.writeObject(sup);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 *
	 * @return Lista de apuestas de Superastro leída desde el archivo.
	 */
	public ArrayList<ApuestaSuperastroDTO> inicializarArchivo() {
		ArrayList<ApuestaSuperastroDTO> apuesta = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileApuesta))) {
			Object obj = ois.readObject();
			apuesta = (ArrayList<ApuestaSuperastroDTO>) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return apuesta;
	}

	public File getFileApuesta() {
		return fileApuesta;
	}

	public void setFileApuesta(File fileApuesta) {
		this.fileApuesta = fileApuesta;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
}
