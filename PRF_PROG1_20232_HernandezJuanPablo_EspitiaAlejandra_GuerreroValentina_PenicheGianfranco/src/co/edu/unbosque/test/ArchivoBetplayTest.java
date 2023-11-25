package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaBetplayDTO;
import co.edu.unbosque.model.persistence.ArchivoBetplay;

import java.util.ArrayList;

/**
 * Clase de prueba JUnit para la clase ArchivoBetplay.
 */
public class ArchivoBetplayTest {

    // La instancia de la clase ArchivoBetplay que se va a probar
    static ArchivoBetplay archivoBetplay;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ArchivoBetplay.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ArchivoBetplay");
        archivoBetplay = new ArchivoBetplay();
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
     * Caso de prueba para verificar la creación del archivo de apuestas Betplay.
     */
    @Test
    public void testCrearArchivo() {
        System.out.println("Empezando la prueba crearArchivo");
        archivoBetplay.crearArchivo();
        assertTrue(archivoBetplay.getFileApuesta().exists());
    }

    /**
     * Caso de prueba para verificar la escritura del archivo de apuestas Betplay.
     */
    @Test
    public void testEscribirArchivo() {
        System.out.println("Empezando la prueba escribirArchivo");
        ArrayList<ApuestaBetplayDTO> apuestasBetplay = new ArrayList<>();
        archivoBetplay.escribirArchivo(apuestasBetplay);
        // Agrega aserciones según sea necesario
    }

    /**
     * Caso de prueba para verificar la inicialización del archivo de apuestas Betplay.
     */
    @Test
    public void testInicializarArchivo() {
        System.out.println("Empezando la prueba inicializarArchivo");
        ArrayList<ApuestaBetplayDTO> result = archivoBetplay.inicializarArchivo();
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
        System.out.println("Finalizando pruebas para ArchivoBetplay");
    }
}
