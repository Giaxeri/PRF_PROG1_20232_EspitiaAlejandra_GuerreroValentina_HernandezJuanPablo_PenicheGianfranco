package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.persistence.BHProperties;

/**
 * Clase de prueba para BHProperties, que gestiona las propiedades de una casa de apuestas.
 */
public class BHPropertiesTest {

    private BHProperties bhProperties;

    /**
     * Configura el entorno de prueba.
     */
    @Before
    public void setUp() {
        bhProperties = new BHProperties();
    }

    /**
     * Prueba la escritura de propiedades en un archivo.
     */
    @Test
    public void testWriteProperties() {
        // Valores de entrada
        String houseName = "TestHouse";
        String numberOfSites = "5";
        String totalBudget = "100000.0";

        // Llama al método a probar
        int result = bhProperties.writeProperties(houseName, numberOfSites, totalBudget);

        // Verifica que las propiedades se escriban correctamente
        assertEquals(0, result);

        // Carga las propiedades desde el archivo
        Properties properties = loadProperties(bhProperties.getRoute());

        // Verifica que las propiedades cargadas coincidan con los valores de entrada
        assertEquals(houseName, properties.getProperty("bettingHouseName"));
        assertEquals(numberOfSites, properties.getProperty("numberOfSites"));
        assertEquals(totalBudget, properties.getProperty("totalBudget"));
    }

    /**
     * Prueba la modificación de propiedades existentes en un archivo.
     */
    @Test
    public void testModifyProperties() {
        // Suponiendo que writeProperties funciona correctamente antes de probar modifyProperties
        testWriteProperties();

        // Nuevos valores de entrada para la modificación
        String newHouseName = "ModifiedHouse";
        String newNumberOfSites = "7";
        String newTotalBudget = "75000.0";

        // Llama al método a probar
        int result = bhProperties.modifyProperties(newHouseName, newNumberOfSites, newTotalBudget);

        // Verifica que las propiedades se modifiquen correctamente
        assertEquals(0, result);

        // Carga las propiedades modificadas desde el archivo
        Properties properties = loadProperties(bhProperties.getRoute());

        // Verifica que las propiedades cargadas coincidan con los nuevos valores de entrada
        assertEquals(newHouseName, properties.getProperty("bettingHouseName"));
        assertEquals(newNumberOfSites, properties.getProperty("numberOfSites"));
        assertEquals(newTotalBudget, properties.getProperty("totalBudget"));
    }

    /**
     * Prueba la inicialización de propiedades desde un archivo.
     */
    @Test
    public void testInitializeProperties() {
        // Suponiendo que writeProperties funciona correctamente antes de probar initializeProperties
        testWriteProperties();

        // Llama al método a probar
        int result = bhProperties.initializeProperties();

        // Verifica que las propiedades se inicialicen correctamente
        assertEquals(0, result);

        // Verifica que las propiedades inicializadas coincidan con los valores de entrada
        assertEquals("TestHouse", bhProperties.getBettingHouseName());
        assertEquals("5", bhProperties.getNumberOfSites());
        assertEquals("100000.0", bhProperties.getTotalBudget());
    }

    /**
     * Desmonta el entorno de prueba y limpia los archivos creados.
     */
    @After
    public void tearDown() {
        // Limpia el archivo de propiedades creado
        File file = new File(bhProperties.getRoute());
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Carga las propiedades desde un archivo.
     *
     * @param route La ruta del archivo.
     * @return Las propiedades cargadas.
     */
    private Properties loadProperties(String route) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(route)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
