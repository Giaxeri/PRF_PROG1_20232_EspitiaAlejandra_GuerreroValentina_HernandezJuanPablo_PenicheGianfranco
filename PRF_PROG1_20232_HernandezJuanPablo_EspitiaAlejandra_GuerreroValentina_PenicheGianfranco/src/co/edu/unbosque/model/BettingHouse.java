package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.BettingHouseDAO;

/**
 * La clase BettingHouse representa una casa de apuestas.
 */
public class BettingHouse {
	private BettingHouseDAO house;

	/**
	 * Constructor que inicializa la instancia de BettingHouse con una nueva
	 * instancia de BettingHouseDAO.
	 */
	public BettingHouse() {
		house = new BettingHouseDAO();
	}

	/**
	 * Llena la información de la casa de apuestas y la almacena en la base de
	 * datos.
	 *
	 * @param name   Nombre de la casa de apuestas.
	 * @param sites  Sitios asociados a la casa de apuestas.
	 * @param budget Presupuesto de la casa de apuestas.
	 */
	public void fillBettingHouseData(String name, String sites, String budget) {
		house.createBettingHouse(name, sites, budget);
	}

	/**
	 * Inicializa los datos de la casa de apuestas.
	 */
	public void initializeBettingHouseData() {
		house.initializeBettingHouse();
	}

	/**
	 * Modifica la información de la casa de apuestas y actualiza la base de datos.
	 *
	 * @param name   Nuevo nombre de la casa de apuestas.
	 * @param sites  Nuevos sitios asociados a la casa de apuestas.
	 * @param budget Nuevo presupuesto de la casa de apuestas.
	 */
	public void modifyBettingHouseData(String name, String sites, String budget) {
		house.modifyBettingHouse(name, sites, budget);
	}

	/**
	 * Obtiene la instancia de BettingHouseDAO asociada a esta instancia de
	 * BettingHouse.
	 *
	 * @return La instancia de BettingHouseDAO.
	 */
	public BettingHouseDAO getHouse() {
		return house;
	}

	/**
	 * Establece la instancia de BettingHouseDAO asociada a esta instancia de
	 * BettingHouse.
	 *
	 * @param house La nueva instancia de BettingHouseDAO.
	 */
	public void setHouse(BettingHouseDAO house) {
		this.house = house;
	}
	
	
}
