package co.edu.unbosque.model.persistence;

/**
 * Clase que gestiona la interacción entre la aplicación y la información de la
 * casa de apuestas.
 */
public class BettingHouseDAO {

	/**
	 * Representa la casa de apuestas con la información asociada.
	 */
	private BettingHouseDTO bettingHouse;

	/**
	 * Instancia de BHProperties para gestionar la persistencia de propiedades.
	 */
	private BHProperties data;

	/**
	 * Constructor de la clase BettingHouseDAO.
	 */
	public BettingHouseDAO() {
		bettingHouse = new BettingHouseDTO();
		data = new BHProperties();
	}

	/**
	 * Crea una nueva casa de apuestas y persiste la información.
	 *
	 * @param houseName     Nombre de la casa de apuestas.
	 * @param numberOfSites Número de sitios de apuestas.
	 * @param totalBudget   Presupuesto total de la casa de apuestas.
	 */
	public void createBettingHouse(String houseName, String numberOfSites, String totalBudget) {
		data.writeProperties(houseName, numberOfSites, totalBudget);
		bettingHouse = new BettingHouseDTO(houseName, Integer.parseInt(numberOfSites), Double.parseDouble(totalBudget));
	}

	/**
	 * Modifica la información de la casa de apuestas y actualiza la persistencia.
	 *
	 * @param newHouseName     Nuevo nombre de la casa de apuestas.
	 * @param newNumberOfSites Nuevo número de sitios de apuestas.
	 * @param newTotalBudget   Nuevo presupuesto total de la casa de apuestas.
	 */
	public void modifyBettingHouse(String newHouseName, String newNumberOfSites, String newTotalBudget) {
		bettingHouse.setBettingHouseName(newHouseName);
		bettingHouse.setNumberOfSites(Integer.parseInt(newNumberOfSites));
		bettingHouse.setTotalBudget(Double.parseDouble(newTotalBudget));
		data.modifyProperties(newHouseName, newNumberOfSites, newTotalBudget);
	}

	/**
	 * Inicializa la información de la casa de apuestas desde la persistencia.
	 */
	public void initializeBettingHouse() {
		data.initializeProperties();
		bettingHouse.setBettingHouseName(data.getBettingHouseName());
		bettingHouse.setNumberOfSites(Integer.parseInt(data.getNumberOfSites()));
		bettingHouse.setTotalBudget(Double.parseDouble(data.getTotalBudget()));
	}

	/**
	 * Obtiene la casa de apuestas.
	 *
	 * @return Instancia de BettingHouseDTO que representa la casa de apuestas.
	 */
	public BettingHouseDTO getBettingHouse() {
		return bettingHouse;
	}

	/**
	 * Establece la casa de apuestas.
	 *
	 * @param bettingHouse Instancia de BettingHouseDTO que representa la casa de
	 *                     apuestas.
	 */
	public void setBettingHouse(BettingHouseDTO bettingHouse) {
		this.bettingHouse = bettingHouse;
	}

	/**
	 * Obtiene la instancia de BHProperties utilizada para gestionar la
	 * persistencia.
	 *
	 * @return Instancia de BHProperties.
	 */
	public BHProperties getData() {
		return data;
	}

	/**
	 * Establece la instancia de BHProperties.
	 *
	 * @param data Instancia de BHProperties.
	 */
	public void setData(BHProperties data) {
		this.data = data;
	}
	
	
}
