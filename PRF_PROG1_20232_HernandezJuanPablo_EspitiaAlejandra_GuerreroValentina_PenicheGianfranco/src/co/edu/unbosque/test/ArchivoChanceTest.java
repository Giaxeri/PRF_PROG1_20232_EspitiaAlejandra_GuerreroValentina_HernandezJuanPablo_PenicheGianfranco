package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaChanceDTO;
import co.edu.unbosque.model.persistence.ArchivoChance;

import java.util.ArrayList;

/**
 * Clase de prueba JUnit para la clase ArchivoChance.
 */
public class ArchivoChanceTest {

    // La instancia de la clase ArchivoChance que se va a probar
    static ArchivoChance archivoChance;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ArchivoChance.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ArchivoChance");
        archivoChance = new ArchivoChance();
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
     * Caso de prueba para verificar la creación del archivo de apuestas Chance.
     */
    @Test
    public void testCrearArchivo() {
        System.out.println("Empezando la prueba crearArchivo");
        archivoChance.crearArchivo();
        assertTrue(archivoChance.getFileApuesta().exists());
    }

    /**
     * Caso de prueba para verificar la escritura del archivo de apuestas Chance.
     */
    @Test
    public void testEscribirArchivo() {
        System.out.println("Empezando la prueba escribirArchivo");
        ArrayList<ApuestaChanceDTO> apuestasChance = new ArrayList<>();
        apuestasChance.add(new ApuestaChanceDTO("Sede1", 123456789, "2023-01-01", 50.0, "Número de la suerte", 7));
        archivoChance.escribirArchivo(apuestasChance);
        // Agrega aserciones según sea necesario
    }

    /**
     * Caso de prueba para verificar la inicialización del archivo de apuestas Chance.
     */
    @Test
    public void testInicializarArchivo() {
        System.out.println("Empezando la prueba inicializarArchivo");
        ArrayList<ApuestaChanceDTO> result = archivoChance.inicializarArchivo();
        assertNotNull(result);
        // Agrega aserciones según sea necesario
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
        System.out.println("Finalizando pruebas para ArchivoChance");
    }
}
