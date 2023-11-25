package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaLoteriaDAO;

/**
 * Clase de prueba JUnit para la clase ApuestaLoteriaDAO.
 */
public class ApuestaLoteriaDAOTest {

    // La instancia de la clase ApuestaLoteriaDAO que se va a probar
    static ApuestaLoteriaDAO apuestaLoteriaDAO;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ApuestaLoteriaDAO.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ApuestaLoteriaDAO");
        apuestaLoteriaDAO = new ApuestaLoteriaDAO();
    }

    /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje que indica el inicio de la prueba.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
    }

    /**
     * Caso de prueba para crear una nueva apuesta de lotería.
     */
    @Test
    public void testCrearApuestaLoteria() {
        System.out.println("Empezando la prueba crearApuestaLoteria");
        apuestaLoteriaDAO.crearApuestaLoteria("Sede1", 123456789, "2023-01-01", 50.0, "Loteria1", 7, 123);
        assertNotNull(apuestaLoteriaDAO.getApuestasLoteria());
        assertFalse(apuestaLoteriaDAO.getApuestasLoteria().isEmpty());
    }

    /**
     * Caso de prueba para leer apuestas de lotería.
     */
    @Test
    public void testLeerApuestas() {
        System.out.println("Empezando la prueba leerApuestas");
        String result = apuestaLoteriaDAO.leerApuestas();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Caso de prueba para modificar una apuesta de lotería existente.
     */
    @Test
    public void testModificarApuestaLoteria() {
        System.out.println("Empezando la prueba modificarApuestaLoteria");
        apuestaLoteriaDAO.modificarApuestaLoteria("Sede2", 123456789, "2023-01-01", 7, 75.0, "Loteria2", 14, 456);
        // Agrega aserciones si es necesario
    }

    /**
     * Caso de prueba para eliminar una apuesta de lotería.
     */
    @Test
    public void testEliminarApuestaLoteria() {
        System.out.println("Empezando la prueba eliminarApuestaLoteria");
        apuestaLoteriaDAO.eliminarApuestaLoteria(123456789, 14);
        // Agrega aserciones si es necesario
    }

    /**
     * Método que se ejecuta después de cada prueba. Imprime un mensaje que indica el final de la prueba e incrementa el número de prueba.
     */
    @After
    public void afterEachTest() {
        System.out.println("Finalizando la prueba " + testNumber);
        testNumber++;
        System.out.println();
    }

    /**
     * Método que se ejecuta una vez después de todas las pruebas. Imprime un mensaje que indica el final de todas las pruebas.
     */
    @AfterClass
    public static void afterAll() {
        System.out.println("Finalizando pruebas para ApuestaLoteriaDAO");
    }
}
