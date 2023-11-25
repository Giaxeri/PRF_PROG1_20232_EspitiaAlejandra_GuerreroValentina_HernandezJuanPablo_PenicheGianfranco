package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.SedesDAO;

/**
 * Clase de prueba JUnit para la clase SedesDAO.
 */
public class SedesDAOTest {

    // La instancia de la clase SedesDAO que se va a probar
    static SedesDAO sedesDAO;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de la clase SedesDAO.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para SedesDAO");
        sedesDAO = new SedesDAO();
    }

    /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje que indica el inicio de la prueba.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        // Puedes inicializar la instancia aquí si es necesario
    }

    /**
     * Caso de prueba para verificar la creación de una sede a través de la clase SedesDAO.
     */
    @Test
    public void testCrearSede() {
        System.out.println("Empezando la prueba crearSede");
        String confirmacion = sedesDAO.crearSede(1, "Localidad1", 10);
        assertEquals("Archivo de sedes creado exitosamente", confirmacion);
    }

    /**
     * Caso de prueba para verificar la modificación de una sede a través de la clase SedesDAO.
     */
    @Test
    public void testModificarSede() {
        System.out.println("Empezando la prueba modificarSede");
        sedesDAO.crearSede(1, "Localidad1", 10);
        sedesDAO.modificarSede("Localidad1", "NuevaLocalidad", 20);
        // Agrega aserciones según sea necesario
    }

    /**
     * Caso de prueba para verificar la lectura de sedes a través de la clase SedesDAO.
     */
    @Test
    public void testLeerSedes() {
        System.out.println("Empezando la prueba leerSedes");
        String sedesDisponibles = sedesDAO.leerSedes();
        assertNotNull(sedesDisponibles);
        // Agrega aserciones según sea necesario
    }

    /**
     * Caso de prueba para verificar la eliminación de sedes a través de la clase SedesDAO.
     */
    @Test
    public void testEliminarSedes() {
        System.out.println("Empezando la prueba eliminarSedes");
        sedesDAO.crearSede(1, "Localidad1", 10);
        String confirmacion = sedesDAO.eliminarSedes("Localidad1", 1);
        assertEquals("Sedes gestionadas correctamente", confirmacion);
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
        System.out.println("Finalizando pruebas para SedesDAO");
    }
}
