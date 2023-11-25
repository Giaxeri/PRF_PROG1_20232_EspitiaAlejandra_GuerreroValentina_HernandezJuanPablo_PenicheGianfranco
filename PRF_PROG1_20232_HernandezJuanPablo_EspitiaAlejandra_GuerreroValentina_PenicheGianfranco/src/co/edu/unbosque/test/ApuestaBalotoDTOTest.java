/**
 * Clase de pruebas unitarias para la clase ApuestaBalotoDTO.
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

import co.edu.unbosque.model.persistence.ApuestaBalotoDTO;

/**
 * Clase de pruebas unitarias para la clase ApuestaBalotoDTO.
 */
public class ApuestaBalotoDTOTest {

    static ApuestaBalotoDTO apuestaBalotoDTO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApuestaBalotoDTO");
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una instancia de ApuestaBalotoDTO para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuestaBalotoDTO = new ApuestaBalotoDTO("Sede1", 123456789, "2023-01-01", 100.0, 7);
    }

    /**
     * Prueba para el método toString de ApuestaBalotoDTO.
     * Verifica que se genera correctamente una representación en cadena del objeto.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando la prueba de toString");
        String expectedString = "Apuesta Baloto: " + "\n" + "Nombre sede: Sede1 Cedula: 123456789 Dia apuesta: 2023-01-01 Valor apuesta: 100.0 Numero apostado: 7\n";
        assertEquals(expectedString, apuestaBalotoDTO.toString());
    }

    /**
     * Prueba para el método getNumeroApostado de ApuestaBalotoDTO.
     * Verifica que se devuelve correctamente el número apostado en la apuesta.
     */
    @Test
    public void testGetNumeroApostado() {
        System.out.println("Empezando la prueba de getNumeroApostado");
        assertEquals(7, apuestaBalotoDTO.getNumeroApostado());
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
        System.out.println("Finalizando pruebas de ApuestaBalotoDTO");
    }
}
