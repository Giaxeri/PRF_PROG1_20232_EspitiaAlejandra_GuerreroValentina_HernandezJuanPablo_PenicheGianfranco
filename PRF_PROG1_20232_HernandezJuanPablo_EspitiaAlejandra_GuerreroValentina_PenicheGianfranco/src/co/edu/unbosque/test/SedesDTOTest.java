package co.edu.unbosque.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.SedesDTO;

/**
 * Clase de prueba JUnit para la clase SedesDTO.
 */
public class SedesDTOTest {

    // La instancia de la clase SedesDTO que se va a probar
    static SedesDTO sede;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de la clase SedesDTO.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para SedesDTO");
        sede = new SedesDTO("Localidad1", 10);
    }

    /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje que indica el inicio de la prueba.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
    }

    /**
     * Caso de prueba para verificar la creación de una instancia de SedesDTO.
     */
    @Test
    public void testCrearSedesDTO() {
        System.out.println("Empezando la prueba crearSedesDTO");
        assertNotNull(sede);
    }

    /**
     * Caso de prueba para verificar el método toString de SedesDTO.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando la prueba toString");
        String expectedString = "--- \n Localidad =Localidad1,\n # empleados =10\n";
        assertEquals(expectedString, sede.toString());
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
        System.out.println("Finalizando pruebas para SedesDTO");
    }
}
