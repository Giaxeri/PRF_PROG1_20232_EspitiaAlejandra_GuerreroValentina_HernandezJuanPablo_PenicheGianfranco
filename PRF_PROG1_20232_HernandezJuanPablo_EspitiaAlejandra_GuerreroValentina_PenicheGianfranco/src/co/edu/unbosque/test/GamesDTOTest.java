package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import co.edu.unbosque.model.persistence.GamesDTO;

/**
 * Clase de prueba para la serialización y deserialización de objetos GamesDTO.
 */
public class GamesDTOTest {

    /**
     * Prueba la serialización y deserialización de un objeto GamesDTO.
     */
    @Test
    public void testSerialization() {
        // Crea un objeto GamesDTO original
        GamesDTO originalGame = new GamesDTO("TestGame", "TestType", 500.0);

        // Serializa el objeto
        byte[] serializedObject = serialize(originalGame);

        // Deserializa el objeto
        GamesDTO deserializedGame = deserialize(serializedObject);

        // Asegura que el objeto deserializado sea igual al original
        assertEquals(originalGame.getName(), deserializedGame.getName());
        assertEquals(originalGame.getGameType(), deserializedGame.getGameType());
        assertEquals(originalGame.getGameBudget(), deserializedGame.getGameBudget(), 0.001);
    }

    /**
     * Serializa un objeto a un array de bytes.
     *
     * @param object Objeto a serializar.
     * @return Array de bytes que representa el objeto serializado.
     */
    private byte[] serialize(Object object) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(object);
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Deserializa un array de bytes a un objeto.
     *
     * @param bytes Array de bytes que representa el objeto serializado.
     * @param <T>   Tipo del objeto a deserializar.
     * @return Objeto deserializado.
     */
    private <T> T deserialize(byte[] bytes) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
