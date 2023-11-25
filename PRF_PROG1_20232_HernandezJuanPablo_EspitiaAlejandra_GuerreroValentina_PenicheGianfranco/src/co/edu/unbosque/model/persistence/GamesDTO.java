package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * La clase GamesDTO representa un juego y almacena información relacionada con
 * él. Implementa la interfaz Serializable para permitir la serialización de
 * objetos.
 */
public class GamesDTO implements Serializable {

	/** Número de versión para la serialización. */
	private static final long serialVersionUID = 1L;

	/** El nombre del juego. */
	private String name;

	/** El tipo de juego. */
	private String gameType;

	/** El presupuesto asignado al juego. */
	private Double gameBudget;

	/**
	 * Constructor por defecto de la clase GamesDTO. Se utiliza para crear
	 * instancias de la clase sin proporcionar información específica.
	 */
	public GamesDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase GamesDTO que toma parámetros para inicializar sus
	 * atributos.
	 *
	 * @param name       El nombre del juego.
	 * @param gameType   El tipo de juego.
	 * @param gameBudget El presupuesto asignado al juego.
	 */
	public GamesDTO(String name, String gameType, Double gameBudget) {
		super();
		this.name = name;
		this.gameType = gameType;
		this.gameBudget = gameBudget;
	}

	// Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setGameBudget(Double gameBudget) {
		this.gameBudget = gameBudget;
	}

}
