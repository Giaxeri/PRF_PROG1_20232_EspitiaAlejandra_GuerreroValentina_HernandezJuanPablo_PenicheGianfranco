package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaLoteriaDTO;

/**
 * Clase de prueba JUnit para la clase ApuestaLoteriaDTO.
 */
public class ApuestaLoteriaDTOTest {

    // La instancia de la clase ApuestaLoteriaDTO que se va a probar
    static ApuestaLoteriaDTO apuestaLoteriaDTO;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ApuestaLoteriaDTO.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ApuestaLoteriaDTO");
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
     * Caso de prueba para verificar el método toString de ApuestaLoteriaDTO.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando la prueba toString");
        apuestaLoteriaDTO = new ApuestaLoteriaDTO("Sede1", 123456789, "2023-01-01", 50.0, "Loteria1", 7, 123);
        String result = apuestaLoteriaDTO.toString();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    // Puedes agregar más casos de prueba según sea necesario

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
        System.out.println("Finalizando pruebas para ApuestaLoteriaDTO");
    }
}
