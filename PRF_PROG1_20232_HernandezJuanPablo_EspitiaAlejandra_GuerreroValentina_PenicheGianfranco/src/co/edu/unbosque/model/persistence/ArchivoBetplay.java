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
 * Clase que maneja la persistencia de las apuestas de Betplay en un archivo.
 */
public class ArchivoBetplay {
	/**
	 * Archivo que almacena la información de las apuestas de Betplay.
	 */
	private File fileApuesta;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de apuestas de
	 * Betplay.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoBetplay.
	 */
	public ArchivoBetplay() {
		fileApuesta = new File("data/apuestas-betplay.dat");
	}

	/**
	 * Crea el archivo de apuestas de Betplay si no existe.
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
	 * Escribe la lista de apuestas de Betplay en el archivo.
	 *
	 * @param bet Lista de apuestas de Betplay a escribir en el archivo.
	 */
	public void escribirArchivo(ArrayList<ApuestaBetplayDTO> bet) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileApuesta));
			oos.writeObject(bet);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 *
	 * @return Lista de apuestas de Betplay leída desde el archivo.
	 */
	public ArrayList<ApuestaBetplayDTO> inicializarArchivo() {
		ArrayList<ApuestaBetplayDTO> apuesta = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileApuesta))) {
			Object obj = ois.readObject();
			apuesta = (ArrayList<ApuestaBetplayDTO>) obj;

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
