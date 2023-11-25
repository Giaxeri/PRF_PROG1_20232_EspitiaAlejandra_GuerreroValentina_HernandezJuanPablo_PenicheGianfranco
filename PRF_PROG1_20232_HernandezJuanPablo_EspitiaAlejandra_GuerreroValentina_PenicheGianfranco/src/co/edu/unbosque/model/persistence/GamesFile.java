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
 * La clase GamesFile proporciona métodos para trabajar con archivos que
 * almacenan información de juegos.
 */
public class GamesFile {

	/** Archivo que almacena información sobre los juegos. */
	private File gamesFile;

	/** Objeto para escribir objetos en el archivo de juegos. */
	private ObjectOutputStream oos;

	/** Nombre del juego. */
	private String gameName;

	/** Tipo de juego. */
	private String gameType;

	/** Presupuesto del juego. */
	private double gameBudget;

	/**
	 * Constructor de la clase GamesFile. Inicializa el archivo de juegos con la
	 * ruta "data/juegos.dat".
	 */
	public GamesFile() {
		gamesFile = new File("data/juegos.dat");
	}

	/**
	 * Crea el archivo de juegos si no existe.
	 */
	public void createFile() {
		if (gamesFile.exists()) {

		} else {
			try {
				gamesFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Escribe la lista de juegos en el archivo especificado.
	 *
	 * @param games Lista de juegos a escribir en el archivo.
	 * @param f1    Archivo en el que se escribirán los juegos.
	 */
	public void writeFile(ArrayList<GamesDTO> games, File f1) {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f1));
			oos.writeObject(games);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa la lista de juegos a partir del archivo existente.
	 *
	 * @return Lista de juegos inicializada desde el archivo.
	 */
	public ArrayList<GamesDTO> initializeFile() {
		ArrayList<GamesDTO> g = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(gamesFile))) {
			Object obj = ois.readObject();
			g = (ArrayList<GamesDTO>) obj;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return g;
	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters

	public File getGamesFile() {
		return gamesFile;
	}

	public void setGamesFile(File gamesFile) {
		this.gamesFile = gamesFile;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public double getGameBudget() {
		return gameBudget;
	}

	public void setGameBudget(double gameBudget) {
		this.gameBudget = gameBudget;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

}
