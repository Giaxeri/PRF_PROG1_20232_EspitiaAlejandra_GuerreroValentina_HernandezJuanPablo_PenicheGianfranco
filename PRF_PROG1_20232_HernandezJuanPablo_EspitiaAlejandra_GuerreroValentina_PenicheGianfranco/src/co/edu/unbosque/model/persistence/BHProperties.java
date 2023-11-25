package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase para manejar las propiedades de la casa de apuestas.
 */
public class BHProperties {

    private Properties prop;
    private String route;
    private String bettingHouseName;
    private String numberOfSites;
    private String totalBudget;

    /**
     * Constructor que inicializa las propiedades y la ruta del archivo.
     */
    public BHProperties() {
        prop = new Properties();
        route = "data/config.properties";
    }

    /**
     * Escribe las propiedades en el archivo de configuración.
     *
     * @param houseName     Nombre de la casa de apuestas.
     * @param numberOfSites Número de sedes de la casa de apuestas.
     * @param totalBudget   Presupuesto total de la casa de apuestas.
     * @return 0 si se escriben correctamente, -1 si hay algún error.
     */
    public int writeProperties(String houseName, String numberOfSites, String totalBudget) {
        try {
            prop.setProperty("bettingHouseName", houseName);
            prop.setProperty("numberOfSites", numberOfSites);
            prop.setProperty("totalBudget", totalBudget);
            prop.store(new FileOutputStream(route), null);
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }

    /**
     * Modifica las propiedades en el archivo de configuración.
     *
     * @param houseName     Nuevo nombre de la casa de apuestas.
     * @param numberOfSites Nuevo número de sedes de la casa de apuestas.
     * @param totalBudget   Nuevo presupuesto total de la casa de apuestas.
     * @return 0 si se modifican correctamente, -1 si hay algún error.
     */
    public int modifyProperties(String houseName, String numberOfSites, String totalBudget) {
        try {
            prop.load(new FileInputStream(route));
            prop.setProperty("bettingHouseName", houseName);
            prop.setProperty("numberOfSites", numberOfSites);
            prop.setProperty("totalBudget", totalBudget);
            prop.store(new FileOutputStream(route), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    /**
     * Inicializa las propiedades desde el archivo de configuración.
     *
     * @return 0 si se inicializan correctamente, -1 si hay algún error.
     */
    public int initializeProperties() {
        try {
            prop.load(new FileInputStream(route));
            bettingHouseName = prop.getProperty("bettingHouseName");
            numberOfSites = prop.getProperty("numberOfSites");
            totalBudget = prop.getProperty("totalBudget");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
	//Metodos que permiten acceder al valor de un atributo - getters y setters
	public String getBettingHouseName() {
		return bettingHouseName;
	}

	public void setBettingHouseName(String bettingHouseName) {
		this.bettingHouseName = bettingHouseName;
	}

	public String getNumberOfSites() {
		return numberOfSites;
	}

	public void setNumberOfSites(String numberOfSites) {
		this.numberOfSites = numberOfSites;
	}

	public String getTotalBudget() {
		return totalBudget;
	}

	public void setTotalBudget(String totalBudget) {
		this.totalBudget = totalBudget;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

}
