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
 * Clase que maneja la persistencia de las apuestas de Baloto en un archivo.
 */
public class ArchivoBaloto {
	/**
	 * Archivo que almacena la información de las apuestas de Baloto.
	 */
	private File fileApuesta;

	/**
	 * Flujo de salida de objetos para escribir en el archivo de apuestas de Baloto.
	 */
	private ObjectOutputStream oos;

	/**
	 * Constructor de la clase ArchivoBaloto.
	 */
	public ArchivoBaloto() {
		fileApuesta = new File("data/apuestas-baloto.dat");
	}

	/**
	 * Crea el archivo de apuestas de Baloto si no existe.
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
	 * Escribe la lista de apuestas de Baloto en el archivo.
	 * 
	 * @param bal Lista de apuestas de Baloto a escribir en el archivo.
	 */
	public void escribirArchivo(ArrayList<ApuestaBalotoDTO> bal) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileApuesta));
			oos.writeObject(bal);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa el archivo leyendo la información almacenada.
	 * 
	 * @return Lista de apuestas de Baloto leída desde el archivo.
	 */
	public ArrayList<ApuestaBalotoDTO> inicializarArchivo() {
		ArrayList<ApuestaBalotoDTO> apuesta = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileApuesta))) {
			Object obj = ois.readObject();
			apuesta = (ArrayList<ApuestaBalotoDTO>) obj;

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
