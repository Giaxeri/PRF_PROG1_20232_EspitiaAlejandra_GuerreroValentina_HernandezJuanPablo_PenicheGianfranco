/**
 * Clase de pruebas unitarias para la clase ApuestaBetplayDTO.
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

import co.edu.unbosque.model.persistence.ApuestaBetplayDTO;

/**
 * Clase de pruebas unitarias para la clase ApuestaBetplayDTO.
 */
public class ApuestaBetplayDTOTest {

    static ApuestaBetplayDTO apuestaBetplayDTO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApuestaBetplayDTO");
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una instancia de ApuestaBetplayDTO para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuestaBetplayDTO = new ApuestaBetplayDTO("Sede1", 123456789, "2023-01-01", 100.0, "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14");
    }

    /**
     * Prueba para el método toString de ApuestaBetplayDTO.
     * Verifica que se genera correctamente una representación en cadena del objeto.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando la prueba de toString");
        String expected = "Apuesta BetPlay: \nNombre sede: Sede1 Cedula: 123456789 Dia apuesta: 2023-01-01 Valor apuesta: 100.0 Partido 1: 1\n Partido 1: 1\n Partido 2: 2\n Partido 3: 3\n Partido 4: 4\n Partido 5: 5\n Partido 6: 6\n Partido 7: 7\n Partido 8: 8\n Partido 9: 9\n Partido 10: 10\n Partido 11: 11\n Partido 12: 12\n Partido 13: 13\n Partido 14: 14\n";
        assertEquals(expected, apuestaBetplayDTO.toString());
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
        System.out.println("Finalizando pruebas de ApuestaBetplayDTO");
    }
}
