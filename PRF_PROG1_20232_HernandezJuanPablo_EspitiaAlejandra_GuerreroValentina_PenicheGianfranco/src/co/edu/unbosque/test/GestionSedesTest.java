package co.edu.unbosque.test;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.GestionSedes;

/**
 * Clase de prueba JUnit para la clase GestionSedes.
 */
public class GestionSedesTest {

    // La instancia de la clase GestionSedes que se va a probar
    static GestionSedes gestionSedes;

    // Contador para el número de prueba
    static int testNumber = 1;

    /**
     * Método que se ejecuta una vez antes de todas las pruebas. Inicializa la instancia de GestionSedes.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias para GestionSedes");
        gestionSedes = new GestionSedes();
    }

    /**
     * Método que se ejecuta antes de cada prueba. Imprime un mensaje que indica el inicio de la prueba.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
    }

    /**
     * Caso de prueba para crear una nueva sede.
     */
    @Test
    public void testCrearNuevaSede() {
        System.out.println("Empezando la prueba crearNuevaSede");
        String result = gestionSedes.crearNuevaSede(5, "Bogotá", 100);
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Caso de prueba para modificar una sede existente.
     */
    @Test
    public void testModificarSede() {
        System.out.println("Empezando la prueba modificarSede");
        gestionSedes.modificarSede("Bogotá", "Medellín", 150);
        // Puedes agregar afirmaciones si es necesario
    }

    /**
     * Caso de prueba para eliminar sede(s).
     */
    @Test
    public void testEliminarSede() {
        System.out.println("Empezando la prueba eliminarSede");
        String result = gestionSedes.eliminarSede(2, "Medellín");
        assertTrue(result != null && !result.isEmpty());
    }

    /**
     * Caso de prueba para inicializar sedes.
     */
    @Test
    public void testInicializarSedes() {
        System.out.println("Empezando la prueba inicializarSedes");
        gestionSedes.inicializarSedes();
        // Puedes agregar afirmaciones si es necesario
    }

    /**
     * Caso de prueba para mostrar sedes.
     */
    @Test
    public void testMostrarSedes() {
        System.out.println("Empezando la prueba mostrarSedes");
        String result = gestionSedes.mostrarSedes();
        assertTrue(result != null && !result.isEmpty());
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
        System.out.println("Finalizando pruebas para GestionSedes");
    }
}
