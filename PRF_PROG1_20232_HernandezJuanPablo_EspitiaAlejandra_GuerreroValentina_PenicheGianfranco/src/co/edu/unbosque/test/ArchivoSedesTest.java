/**
 * Clase de pruebas unitarias para la clase ArchivoSedes.
 * Extiende de TestCase de JUnit.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con el método setUp y se finaliza con el método tearDown.
 */
package co.edu.unbosque.test;

import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoSedes;
import co.edu.unbosque.model.persistence.SedesDTO;

/**
 * Clase de pruebas unitarias para la clase ArchivoSedes.
 * Extiende de TestCase de JUnit.
 */
public class ArchivoSedesTest extends TestCase {

    private static final String FILE_PATH = "data/test_sedes.dat";

    /**
     * Prueba para el método crearArchivo de ArchivoSedes.
     * Verifica que el archivo se crea correctamente.
     */
    public void testCrearArchivo() {
        ArchivoSedes archivoSedes = new ArchivoSedes();  
        archivoSedes.crearArchivo();
      
        // Puedes agregar aserciones adicionales según sea necesario para verificar el resultado esperado.
    }

    /**
     * Prueba para el método escribirArchivoSedes de ArchivoSedes.
     * Verifica que se escriben correctamente las sedes en el archivo.
     */
    public void testEscribirArchivoSedes() {
        ArchivoSedes archivoSedes = new ArchivoSedes();  

        // Crear datos de prueba
        ArrayList<SedesDTO> sedes = new ArrayList<>();
        sedes.add(new SedesDTO("Sede 1", 0));
        sedes.add(new SedesDTO("Sede 2", 0));

        archivoSedes.escribirArchivoSedes(sedes);

        // Verificar que el archivo se ha creado y contiene los datos esperados
        ArrayList<SedesDTO> sedesLeidas = archivoSedes.initializeFile();

        // Agregar aserciones para comparar las sedes escritas y las sedes leídas
        assertEquals(sedes.size(), sedesLeidas.size());
        for (int i = 0; i < sedes.size(); i++) {
            assertEquals(sedes.get(i).toString(), sedesLeidas.get(i).toString());
        }
    }

    // Este método se ejecuta antes de cada prueba
    protected void setUp() {
        // Puedes realizar configuraciones adicionales si es necesario
    }

    // Este método se ejecuta después de cada prueba
    protected void tearDown() {
        // Puedes realizar limpieza adicional si es necesario
        File file = new File(FILE_PATH);
        if (file.exists()) {
            // Eliminar el archivo después de cada prueba
            file.delete();
        }
    }
}
