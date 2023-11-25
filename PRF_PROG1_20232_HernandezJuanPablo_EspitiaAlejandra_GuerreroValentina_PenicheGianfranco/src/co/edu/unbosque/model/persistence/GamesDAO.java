package co.edu.unbosque.model.persistence;

import java.io.File;
import java.util.ArrayList;

/**
 * La clase GamesDAO gestiona la persistencia y operaciones relacionadas con los
 * juegos.
 */
public class GamesDAO {

	private ArrayList<GamesDTO> games; // Lista para almacenar juegos
	private GamesFile gFile; // Objeto para manejar operaciones de archivos de juegos
	private BettingHouseDAO bHouse; // Objeto para acceder a la información de la casa de apuestas
	private Double budgetSum; // Variable aparentemente no utilizada

	/**
	 * Construye un objeto GamesDAO.
	 */
	public GamesDAO() {
		budgetSum = 0.0; // Inicialización de la variable de suma de presupuesto
		games = new ArrayList<GamesDTO>(); // Inicialización de la lista de juegos
		gFile = new GamesFile(); // Inicialización del objeto para manejar archivos de juegos
		bHouse = new BettingHouseDAO(); // Inicialización del objeto para acceder a la información de la casa de
										// apuestas
	}

	/**
	 * Crea un nuevo juego y lo agrega a la lista de juegos.
	 *
	 * @param name       El nombre del juego.
	 * @param gameType   El tipo de juego.
	 * @param gameBudget El presupuesto asignado para el juego.
	 */
	public void createGames(String name, String gameType, String gameBudget) {
		games.add(new GamesDTO(name, gameType, Double.parseDouble(gameBudget))); // Agrega un nuevo juego a la lista
		if (games.size() == 5) {
			gFile.createFile(); // Crea un nuevo archivo para almacenar los juegos
			File file = new File("data/juegos.dat");
			gFile.writeFile(games, file); // Escribe la lista de juegos en el archivo
		}
	}

	/**
	 * Modifica un juego existente en la lista.
	 *
	 * @param name      El nombre del juego.
	 * @param gameType  El tipo de juego.
	 * @param newBudget El nuevo presupuesto asignado para el juego.
	 * @param pos       La posición del juego que se modificará en la lista.
	 */
	public void modifyGames(String name, String gameType, String newBudget, int pos) {
		int adition = 0; // Variable que aparentemente no tiene utilidad
		games.set(pos, new GamesDTO(name, gameType, Double.parseDouble(newBudget))); // Modifica un juego en la lista
		adition = adition++; // Incrementa la variable adition (posiblemente un error, ya que siempre será 1)

		File file = new File("data/juegos.dat");
		file.delete(); // Elimina el archivo de juegos actual
		gFile.createFile(); // Crea un nuevo archivo para almacenar los juegos
		gFile.writeFile(games, file); // Escribe la lista de juegos en el nuevo archivo
	}

	/**
	 * Inicializa la lista de juegos desde un archivo.
	 */
	public void initializeGames() {
		games = gFile.initializeFile(); // Inicializa la lista de juegos desde un archivo
	}
	// Metodos que permiten acceder al valor de un atributo - getters y setters

	public ArrayList<GamesDTO> getGames() {
		return games;
	}

	public void setGames(ArrayList<GamesDTO> games) {
		this.games = games;
	}

	public GamesFile getgFile() {
		return gFile;
	}

	public void setgFile(GamesFile gFile) {
		this.gFile = gFile;
	}

	public BettingHouseDAO getbHouse() {
		return bHouse;
	}

	public void setbHouse(BettingHouseDAO bHouse) {
		this.bHouse = bHouse;
	}

	public Double getBudgetSum() {
		return budgetSum;
	}

	public void setBudgetSum(Double budgetSum) {
		this.budgetSum = budgetSum;
	}

}
