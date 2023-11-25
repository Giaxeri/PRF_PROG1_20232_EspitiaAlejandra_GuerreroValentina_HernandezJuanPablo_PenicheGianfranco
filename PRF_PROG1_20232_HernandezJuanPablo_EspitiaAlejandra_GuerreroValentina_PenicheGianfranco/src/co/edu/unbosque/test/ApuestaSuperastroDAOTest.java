package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaSuperastroDAO;

/**
 * Clase de prueba JUnit para la clase ApuestaSuperastroDAO.
 */
public class ApuestaSuperastroDAOTest {

    // La instancia de la clase ApuestaSuperastroDAO que se va a probar
    static ApuestaSuperastroDAO apuestaSuperastroDAO;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ApuestaSuperastroDAO.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ApuestaSuperastroDAO");
        apuestaSuperastroDAO = new ApuestaSuperastroDAO();
    }

    /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje que indica el inicio de la prueba.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
    }

    /**
     * Caso de prueba para crear una nueva apuesta de Superastro.
     */
    @Test
    public void testCrearApuestaSuperastro() {
        System.out.println("Empezando la prueba crearApuestaSuperastro");
        apuestaSuperastroDAO.crearApuestaSuperastro("Sede1", 123456789, "2023-01-01", 50.0, "Leo", 7);
        assertNotNull(apuestaSuperastroDAO.getApuestasSuperastro());
        assertFalse(apuestaSuperastroDAO.getApuestasSuperastro().isEmpty());
    }


    /**
     * Caso de prueba para leer apuestas de Superastro.
     */
    @Test
    public void testLeerApuestasSuperastro() {
        System.out.println("Empezando la prueba leerApuestasSuperastro");
        String result = apuestaSuperastroDAO.leerApuestas();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Caso de prueba para modificar una apuesta de Superastro existente.
     */
    @Test
    public void testModificarApuestaSuperastro() {
        System.out.println("Empezando la prueba modificarApuestaSuperastro");
        apuestaSuperastroDAO.modificarApuestaSuperastro("Sede2", 123456789, "2023-01-01", 7, 75.0, "Virgo", 14);
        // Agrega aserciones si es necesario
    }

    /**
     * Caso de prueba para eliminar una apuesta de Superastro.
     */
    @Test
    public void testEliminarApuestaSuperastro() {
        System.out.println("Empezando la prueba eliminarApuestaSuperastro");
        apuestaSuperastroDAO.eliminarApuestaSuperastro(123456789, 14);
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
        System.out.println("Finalizando pruebas para ApuestaSuperastroDAO");
    }
}
