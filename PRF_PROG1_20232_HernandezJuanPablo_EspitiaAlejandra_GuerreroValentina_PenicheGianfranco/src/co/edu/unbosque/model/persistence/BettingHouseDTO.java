package co.edu.unbosque.model.persistence;

import java.io.Serializable;

/**
 * Clase que representa la información asociada a una casa de apuestas.
 */
public class BettingHouseDTO implements Serializable {

	/**
	 * Identificador único para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre de la casa de apuestas.
	 */
	private String bettingHouseName;

	/**
	 * Número de sedes de la casa de apuestas.
	 */
	private int numberOfSites;

	/**
	 * Presupuesto total de la casa de apuestas.
	 */
	private double totalBudget;

	/**
	 * Constructor por defecto que verifica las invariantes.
	 */
	public BettingHouseDTO() {
		verifyInvariant();
	}

	/**
	 * Constructor que inicializa todos los campos de la casa de apuestas.
	 *
	 * @param bettingHouseName Nombre de la casa de apuestas.
	 * @param numberOfSites    Número de sedes de la casa de apuestas.
	 * @param totalBudget      Presupuesto total de la casa de apuestas.
	 */
	public BettingHouseDTO(String bettingHouseName, int numberOfSites, double totalBudget) {
		super();
		this.bettingHouseName = bettingHouseName;
		this.numberOfSites = numberOfSites;
		this.totalBudget = totalBudget;
		verifyInvariant();
	}

	/**
	 * Obtiene el nombre de la casa de apuestas.
	 *
	 * @return Nombre de la casa de apuestas.
	 */
	public String getBettingHouseName() {
		return bettingHouseName;
	}

	/**
	 * Establece el nombre de la casa de apuestas.
	 *
	 * @param bettingHouseName Nuevo nombre de la casa de apuestas.
	 */
	public void setBettingHouseName(String bettingHouseName) {
		this.bettingHouseName = bettingHouseName;
	}

	/**
	 * Obtiene el número de sedes de la casa de apuestas.
	 *
	 * @return Número de sedes de la casa de apuestas.
	 */
	public int getNumberOfSites() {
		return numberOfSites;
	}

	/**
	 * Establece el número de sedes de la casa de apuestas.
	 *
	 * @param numberOfSites Nuevo número de sedes de la casa de apuestas.
	 */
	public void setNumberOfSites(int numberOfSites) {
		this.numberOfSites = numberOfSites;
	}

	/**
	 * Obtiene el presupuesto total de la casa de apuestas.
	 *
	 * @return Presupuesto total de la casa de apuestas.
	 */
	public double getTotalBudget() {
		return totalBudget;
	}

	/**
	 * Establece el presupuesto total de la casa de apuestas.
	 *
	 * @param totalBudget Nuevo presupuesto total de la casa de apuestas.
	 */
	public void setTotalBudget(double totalBudget) {
		this.totalBudget = totalBudget;
	}

	/**
	 * Verifica las invariantes de la clase.
	 */
	private void verifyInvariant() {
		assert bettingHouseName != null : "El nombre no puede estar vacío";
		assert numberOfSites > 0 : "El número de sedes no puede ser menor o igual a 0";
		assert totalBudget > 0 : "El presupuesto total no puede ser menor o igual a 0";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
