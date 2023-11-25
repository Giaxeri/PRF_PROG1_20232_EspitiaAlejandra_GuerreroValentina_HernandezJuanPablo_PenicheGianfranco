package co.edu.unbosque.test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import co.edu.unbosque.model.DataException;

/**
 * Clase de pruebas para la clase DataException.
 */
public class DataExceptionTest {

    /**
     * Prueba para verificar que el mensaje de la excepción sea el esperado.
     */
    @Test
    public void testConstructor() {
        String mensajeEsperado = "Este es un mensaje de prueba.";
        DataException dataException = new DataException(mensajeEsperado);
        assertEquals("El mensaje de la excepción no es el esperado.", mensajeEsperado, dataException.getMessage());
    }
}
