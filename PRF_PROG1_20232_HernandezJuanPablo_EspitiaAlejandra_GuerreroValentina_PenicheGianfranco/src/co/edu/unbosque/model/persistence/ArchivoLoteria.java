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
 * Clase que maneja la persistencia de las apuestas de Lotería en un archivo.
 */
public class ArchivoLoteria {
	/**
	 * Archivo que almacena la información de las apuestas de Lotería.
	 */
	private File fileApuesta;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de apuestas de
	 * Lotería.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoLoteria.
	 */
	public ArchivoLoteria() {
		fileApuesta = new File("data/apuestas-loteria.dat");
	}

	/**
	 * Crea el archivo de apuestas de Lotería si no existe.
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
	 * Escribe la lista de apuestas de Lotería en el archivo.
	 *
	 * @param lot Lista de apuestas de Lotería a escribir en el archivo.
	 */
	public void escribirArchivo(ArrayList<ApuestaLoteriaDTO> lot) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileApuesta));
			oos.writeObject(lot);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 *
	 * @return Lista de apuestas de Lotería leída desde el archivo.
	 */
	public ArrayList<ApuestaLoteriaDTO> inicializarArchivo() {
		ArrayList<ApuestaLoteriaDTO> apuesta = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileApuesta))) {
			Object obj = ois.readObject();
			apuesta = (ArrayList<ApuestaLoteriaDTO>) obj;

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
