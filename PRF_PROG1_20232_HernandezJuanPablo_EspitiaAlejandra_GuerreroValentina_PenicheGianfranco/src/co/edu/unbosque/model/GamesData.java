package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.GamesDAO;

/**
 * La clase GamesData proporciona funcionalidades para gestionar datos de
 * juegos.
 */
public class GamesData {
	private GamesDAO game;

	/**
	 * Constructor que inicializa la instancia de GamesData con una nueva instancia
	 * de GamesDAO.
	 */
	public GamesData() {
		game = new GamesDAO();
	}

	/**
	 * Crea un nuevo juego y lo almacena en la base de datos.
	 *
	 * @param name       Nombre del juego.
	 * @param typeGame   Tipo de juego.
	 * @param gameBudget Presupuesto del juego.
	 */
	public void createGames(String name, String typeGame, String gameBudget) {
		if (!name.isEmpty() || !typeGame.isBlank() || !gameBudget.isBlank()) {
			game.createGames(name, typeGame, gameBudget);
		}
	}

	/**
	 * Modifica la información de un juego existente en la base de datos.
	 *
	 * @param name          Nombre original del juego.
	 * @param newName       Nuevo nombre del juego.
	 * @param newGameBudget Nuevo presupuesto del juego.
	 * @param pos           Posición del juego a modificar.
	 */
	public void modifyGames(String name, String newName, String newGameBudget, int pos) {
		game.modifyGames(name, newName, newGameBudget, pos);
	}

	/**
	 * Inicializa los datos de los juegos.
	 */
	public void initializeGames() {
		game.initializeGames();
	}

	/**
	 * Obtiene la instancia de GamesDAO asociada a esta instancia de GamesData.
	 *
	 * @return La instancia de GamesDAO.
	 */
	public GamesDAO getGame() {
		return game;
	}

	/**
	 * Establece la instancia de GamesDAO asociada a esta instancia de GamesData.
	 *
	 * @param game La nueva instancia de GamesDAO.
	 */
	public void setGame(GamesDAO game) {
		this.game = game;
	}
	
	
}
