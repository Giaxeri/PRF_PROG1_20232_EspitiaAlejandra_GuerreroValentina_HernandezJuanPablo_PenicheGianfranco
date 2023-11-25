/**
 * Clase de pruebas unitarias para la clase BettingHouseDAO.
 * Utiliza la biblioteca JUnit para realizar pruebas.
 */
package co.edu.unbosque.test;

import co.edu.unbosque.model.persistence.BettingHouseDAO;
import co.edu.unbosque.model.persistence.BettingHouseDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase de pruebas unitarias para la clase BettingHouseDAO.
 */
public class BettingHouseDAOTest {

    private BettingHouseDAO bettingHouseDAO;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @Before
    public void setUp() {
        bettingHouseDAO = new BettingHouseDAO();
    }

    /**
     * Prueba para el método initializeBettingHouse de BettingHouseDAO.
     * Verifica que el objeto BettingHouseDTO se inicializa correctamente.
     */
    @Test
    public void testInitializeBettingHouse() {
        // Configuración de valores predefinidos para las propiedades
        String houseName = "TestHouse";
        String numberOfSites = "5";
        String totalBudget = "100000.0";

        // Llamar al método a probar
        bettingHouseDAO.createBettingHouse(houseName, numberOfSites, totalBudget);

        // Llamar al método a probar
        bettingHouseDAO.initializeBettingHouse();

        // Verificar que el estado interno se establece correctamente
        BettingHouseDTO bettingHouse = bettingHouseDAO.getBettingHouse();
        assertEquals(houseName, bettingHouse.getBettingHouseName());
        assertEquals(Integer.parseInt(numberOfSites), bettingHouse.getNumberOfSites());
        assertEquals(Double.parseDouble(totalBudget), bettingHouse.getTotalBudget(), 0.001);
    }
}
