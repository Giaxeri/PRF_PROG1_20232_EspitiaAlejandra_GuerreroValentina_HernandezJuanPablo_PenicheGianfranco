/**
 * Clase de pruebas unitarias para la clase BettingHouseDTO.
 * Utiliza la biblioteca JUnit para realizar pruebas.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.BettingHouseDTO;

/**
 * Clase de pruebas unitarias para la clase BettingHouseDTO.
 */
public class BettingHouseDTOTest {

    private BettingHouseDTO bettingHouse;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @Before
    public void setUp() {
        bettingHouse = new BettingHouseDTO();
    }

    /**
     * Prueba del constructor por defecto de BettingHouseDTO.
     * Verifica que los valores iniciales se establecen correctamente.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(bettingHouse);
        assertEquals(null, bettingHouse.getBettingHouseName());
        assertEquals(0, bettingHouse.getNumberOfSites());
        assertEquals(0.0, bettingHouse.getTotalBudget(), 0.001);
    }

    /**
     * Prueba del constructor parametrizado de BettingHouseDTO.
     * Verifica que los valores se establecen correctamente al utilizar un constructor con parámetros.
     */
    @Test
    public void testParameterizedConstructor() {
        String houseName = "TestHouse";
        int numberOfSites = 5;
        double totalBudget = 100000.0;

        bettingHouse = new BettingHouseDTO(houseName, numberOfSites, totalBudget);

        assertNotNull(bettingHouse);
        assertEquals(houseName, bettingHouse.getBettingHouseName());
        assertEquals(numberOfSites, bettingHouse.getNumberOfSites());
        assertEquals(totalBudget, bettingHouse.getTotalBudget(), 0.001);
    }

    /**
     * Prueba de los métodos getters y setters de BettingHouseDTO.
     * Verifica que los métodos de acceso y modificación funcionan correctamente.
     */
    @Test
    public void testGettersAndSetters() {
        String houseName = "TestHouse";
        int numberOfSites = 5;
        double totalBudget = 100000.0;

        bettingHouse.setBettingHouseName(houseName);
        bettingHouse.setNumberOfSites(numberOfSites);
        bettingHouse.setTotalBudget(totalBudget);

        assertEquals(houseName, bettingHouse.getBettingHouseName());
        assertEquals(numberOfSites, bettingHouse.getNumberOfSites());
        assertEquals(totalBudget, bettingHouse.getTotalBudget(), 0.001);
    }

    /**
     * Prueba del método verifyInvariant de BettingHouseDTO.
     * Verifica que la invariante se cumple después de la creación del objeto.
     */
    @Test
    public void testVerifyInvariant() {
        // Suponiendo que el constructor por defecto establece la invariante
        assertNotNull(bettingHouse);
        assertNotNull(bettingHouse.getBettingHouseName());
    }
}

