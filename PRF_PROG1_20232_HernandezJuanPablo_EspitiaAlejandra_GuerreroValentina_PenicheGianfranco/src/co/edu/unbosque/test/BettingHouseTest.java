package co.edu.unbosque.test;



import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.BettingHouse;
import co.edu.unbosque.model.persistence.BettingHouseDAO;

/**
 * Clase de prueba para la clase BettingHouse.
 */
public class BettingHouseTest {

    private BettingHouse bettingHouse;
    private BettingHouseDAO mockBettingHouseDAO;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {

        bettingHouse = new BettingHouse();
        bettingHouse.setHouse(mockBettingHouseDAO);
    }

    /**
     * Prueba para asegurarse de que el método fillBettingHouseData interactúa correctamente con BettingHouseDAO.
     */
    @Test
    public void testFillBettingHouseData() {
        bettingHouse.fillBettingHouseData("House1", "Sites1", "1000");
        
    }

    /**
     * Prueba para asegurarse de que el método initializeBettingHouseData interactúa correctamente con BettingHouseDAO.
     */
    @Test
    public void testInitializeBettingHouseData() {
        bettingHouse.initializeBettingHouseData();
    
    }

    /**
     * Prueba para asegurarse de que el método modifyBettingHouseData interactúa correctamente con BettingHouseDAO.
     */
    @Test
    public void testModifyBettingHouseData() {
        bettingHouse.modifyBettingHouseData("House1", "Sites1", "2000");
       
    }

    /**
     * Prueba para asegurarse de que el método getHouse devuelve la instancia correcta de BettingHouseDAO.
     */
    @Test
    public void testGetHouse() {
        assertEquals(mockBettingHouseDAO, bettingHouse.getHouse());
    }

 
}

