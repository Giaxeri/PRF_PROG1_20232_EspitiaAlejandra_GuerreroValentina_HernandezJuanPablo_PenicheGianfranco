/**
 * Clase de pruebas unitarias para la clase ApuestaChanceDAO.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con la anotación @Before para establecer el estado inicial necesario.
 * Se proporciona un resumen de las pruebas al inicio y al final de la ejecución.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaChanceDAO;

/**
 * Clase de pruebas unitarias para la clase ApuestaChanceDAO.
 */
public class ApuestaChanceDAOTest {

    static ApuestaChanceDAO apuestaChanceDAO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApuestaChanceDAO");
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una instancia de ApuestaChanceDAO para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuestaChanceDAO = new ApuestaChanceDAO();
    }

    /**
     * Prueba para el método crearApuestaChance de ApuestaChanceDAO.
     * Verifica que se crea correctamente una apuesta Chance y se almacena en la lista de apuestas Chance.
     */
    @Test
    public void testCrearApuestaChance() {
        System.out.println("Empezando la prueba de crearApuestaChance");
        apuestaChanceDAO.crearApuestaChance("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 5);
        assertEquals("ApuestaChanceDTO[Nombre sede=Sede1, Cedula=123456789, Dia apuesta=2023-01-01, Valor apuesta=100.0, Nombre loteria=Loteria1, Numero apostado=5]",
                apuestaChanceDAO.getApuestasChance().get(0).toString());
    }

    /**
     * Prueba para el método modificarApuestaChance de ApuestaChanceDAO.
     * Verifica que se modifica correctamente una apuesta Chance existente.
     */
    @Test
    public void testModificarApuestaChance() {
        System.out.println("Empezando la prueba de modificarApuestaChance");
        // Supongamos que hay una apuesta existente
        apuestaChanceDAO.crearApuestaChance("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 5);
        apuestaChanceDAO.modificarApuestaChance("Sede1", 123456789, "2023-01-01", 5, 150.0, "Loteria2", 10);
        assertEquals("ApuestaChanceDTO[Nombre sede=Sede1, Cedula=123456789, Dia apuesta=2023-01-01, Valor apuesta=150.0, Nombre loteria=Loteria2, Numero apostado=10]",
                apuestaChanceDAO.getApuestasChance().get(0).toString());
    }

    /**
     * Método ejecutado después de cada prueba.
     * Imprime un mensaje indicando el final de la prueba actual.
     * Incrementa el número de prueba para la siguiente ejecución.
     */
    @After
    public void afterEachTest() {
        System.out.println("Finalizando la prueba " + testNumber);
        testNumber++;
        System.out.println();
    }

    /**
     * Método ejecutado después de todas las pruebas.
     * Imprime un mensaje indicando el final de todas las pruebas.
     */
    @AfterClass
    public static void afterAll() {
        System.out.println("Finalizando pruebas de ApuestaChanceDAO");
    }
}
