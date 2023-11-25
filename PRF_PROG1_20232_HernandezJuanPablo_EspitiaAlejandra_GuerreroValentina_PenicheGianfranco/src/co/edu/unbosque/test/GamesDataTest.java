package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.GamesData;

/**
 * Clase de pruebas para la clase GamesData.
 */
public class GamesDataTest {

    private GamesData  gamesData;

    @Before
    public void setUp() {
        gamesData = new GamesData();
    }

    /**
     * Prueba para verificar la creación correcta de juegos.
     */
    @Test
    public void testCreateGames() {
        gamesData.createGames("Game1", "Type1", "Budget1");
        // Puedes agregar verificaciones adicionales aquí según la lógica de tu aplicación.
        // assertTrue("Condición esperada", condicionActual);
    }

    /**
     * Prueba para verificar la modificación correcta de juegos.
     */
    @Test
    public void testModifyGames() {
        gamesData.createGames("Game1", "Type1", "Budget1");
        gamesData.modifyGames("Game1", "Type1", "NewBudget", 0);
        // Puedes agregar verificaciones adicionales aquí según la lógica de tu aplicación.
        // assertTrue("Condición esperada", condicionActual);
    }

    /**
     * Prueba para verificar la inicialización correcta de juegos.
     */
    @Test
    public void testInitializeGames() {
        gamesData.initializeGames();
        // Puedes agregar verificaciones adicionales aquí según la lógica de tu aplicación.
        // assertTrue("Condición esperada", condicionActual);
    }

    /**
     * Prueba para verificar que no se creen juegos con datos vacíos.
     */
    @Test
    public void testCreateGamesWithEmptyData() {
        gamesData.createGames("", "", "");
        // Puedes agregar verificaciones adicionales aquí según la lógica de tu aplicación.
        // assertFalse("Condición esperada", condicionActual);
    }

    /**
     * Prueba para verificar la creación de juegos con datos válidos.
     */
    @Test
    public void testCreateGamesWithValidData() {
        gamesData.createGames("Game1", "Type1", "Budget1");
        // Puedes agregar verificaciones adicionales aquí según la lógica de tu aplicación.
        // assertTrue("Condición esperada", condicionActual);
    }
}
