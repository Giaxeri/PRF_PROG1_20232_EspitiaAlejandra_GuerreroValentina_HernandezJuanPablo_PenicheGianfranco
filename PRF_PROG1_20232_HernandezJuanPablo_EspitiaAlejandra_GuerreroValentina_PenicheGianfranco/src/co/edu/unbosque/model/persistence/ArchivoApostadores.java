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
 * Clase que maneja la persistencia de los datos de los apostadores en un
 * archivo.
 */
public class ArchivoApostadores {
	/**
	 * Archivo que almacena la información de los apostadores.
	 */
	private File fileApostadores;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de apostadores.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoApostadores.
	 */
	public ArchivoApostadores() {
		fileApostadores = new File("data/apostadores.dat");
	}

	/**
	 * Crea el archivo de apostadores si no existe.
	 */
	public void crearArchivo() {
		if (fileApostadores.exists()) {

		} else {
			try {
				fileApostadores.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe la lista de apostadores en el archivo.
	 * 
	 * @param apostadores Lista de apostadores a escribir en el archivo.
	 */
	public void escribirArchivoApostador(ArrayList<ApostadorDTO> apostadores) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileApostadores));
			oos.writeObject(apostadores);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 * 
	 * @return Lista de apostadores leída desde el archivo.
	 */
	public ArrayList<ApostadorDTO> initializeFile() {
		ArrayList<ApostadorDTO> apostadores = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileApostadores))) {
			Object obj = ois.readObject();
			apostadores = (ArrayList<ApostadorDTO>) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return apostadores;
	}

	public File getFileApostadores() {
		return fileApostadores;
	}

	public void setFileApostadores(File fileApostadores) {
		this.fileApostadores = fileApostadores;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}
	
	
}
