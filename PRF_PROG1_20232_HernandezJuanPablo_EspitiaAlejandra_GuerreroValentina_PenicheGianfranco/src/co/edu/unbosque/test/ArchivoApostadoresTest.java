package co.edu.unbosque.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApostadorDTO;
import co.edu.unbosque.model.persistence.ArchivoApostadores;

import java.util.ArrayList;

/**
 * Clase de prueba JUnit para la clase ArchivoApostadores.
 */
public class ArchivoApostadoresTest {

    // La instancia de la clase ArchivoApostadores que se va a probar
    static ArchivoApostadores archivoApostadores;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de ArchivoApostadores.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para ArchivoApostadores");
        archivoApostadores = new ArchivoApostadores();
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
     * Caso de prueba para verificar la creación del archivo de apostadores.
     */
    @Test
    public void testCrearArchivo() {
        System.out.println("Empezando la prueba crearArchivo");
        archivoApostadores.crearArchivo();
        assertTrue(archivoApostadores.getFileApostadores().exists());
    }

    /**
     * Caso de prueba para verificar la escritura del archivo de apostadores.
     */
    @Test
    public void testEscribirArchivoApostador() {
        System.out.println("Empezando la prueba escribirArchivoApostador");
        ArrayList<ApostadorDTO> apostadores = new ArrayList<>();
        apostadores.add(new ApostadorDTO());
        archivoApostadores.escribirArchivoApostador(apostadores);
        // Agrega aserciones según sea necesario
    }

    /**
     * Caso de prueba para verificar la inicialización del archivo de apostadores.
     */
    @Test
    public void testInitializeFile() {
        System.out.println("Empezando la prueba initializeFile");
        ArrayList<ApostadorDTO> result = archivoApostadores.initializeFile();
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
        System.out.println("Finalizando pruebas para ArchivoApostadores");
    }
}
