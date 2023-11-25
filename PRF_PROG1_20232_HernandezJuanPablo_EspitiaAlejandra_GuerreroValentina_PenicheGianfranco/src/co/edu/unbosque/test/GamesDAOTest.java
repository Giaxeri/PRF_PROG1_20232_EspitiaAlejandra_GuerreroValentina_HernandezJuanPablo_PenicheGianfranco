package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.GamesDAO;
import co.edu.unbosque.model.persistence.GamesDTO;

/**
 * Clase de prueba para GamesDAO, que gestiona la persistencia de información sobre juegos.
 */
public class GamesDAOTest {

    private GamesDAO gamesDAO;

    /**
     * Configura el entorno de prueba.
     */
    @Before
    public void setUp() {
        gamesDAO = new GamesDAO();
    }

    /**
     * Prueba la creación de juegos y su almacenamiento en la lista de juegos.
     */
    @Test
    public void testCreateGames() {
        // Valores de entrada
        String name = "TestGame";
        String gameType = "TestType";
        String gameBudget = "500.0";

        // Llama al método a probar
        gamesDAO.createGames(name, gameType, gameBudget);

        // Obtiene la lista de juegos
        ArrayList<GamesDTO> games = gamesDAO.getGames();

        // Verifica que se haya creado un juego correctamente
        assertEquals(1, games.size());
        assertEquals(name, games.get(0).getName());
        assertEquals(gameType, games.get(0).getGameType());
        assertEquals(Double.parseDouble(gameBudget), games.get(0).getGameBudget(), 0.001);
    }

    /**
     * Prueba la modificación de un juego existente en la lista de juegos.
     */
    @Test
    public void testModifyGames() {
        // Suponiendo que createGames funciona correctamente antes de probar modifyGames
        testCreateGames();

        // Nuevos valores de entrada para la modificación
        String newName = "ModifiedGame";
        String newGameType = "ModifiedType";
        String newBudget = "750.0";
        int pos = 0;

        // Llama al método a probar
        gamesDAO.modifyGames(newName, newGameType, newBudget, pos);

        // Obtiene la lista de juegos modificada
        ArrayList<GamesDTO> games = gamesDAO.getGames();

        // Verifica que el juego se haya modificado correctamente
        assertEquals(1, games.size());
        assertEquals(newName, games.get(0).getName());
        assertEquals(newGameType, games.get(0).getGameType());
        assertEquals(Double.parseDouble(newBudget), games.get(0).getGameBudget(), 0.001);
    }

    /**
     * Prueba la inicialización de la lista de juegos desde un archivo.
     */
    @Test
    public void testInitializeGames() {
        // Suponiendo que createGames funciona correctamente antes de probar initializeGames
        testCreateGames();

        // Llama al método a probar
        gamesDAO.initializeGames();

        // Obtiene la lista de juegos después de la inicialización
        ArrayList<GamesDTO> games = gamesDAO.getGames();

        // Verifica que la inicialización se haya realizado correctamente
        assertEquals(1, games.size());
        // Agrega más aserciones basadas en el estado inicial esperado
    }

    /**
     * Desmonta el entorno de prueba y limpia los archivos creados.
     */
    @After
    public void tearDown() {
        // Limpia el archivo de juegos creado
        File file = new File("data/juegos.dat");
        if (file.exists()) {
            file.delete();
        }
    }
}

