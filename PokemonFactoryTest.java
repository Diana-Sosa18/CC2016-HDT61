import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonFactoryTest {

    @Test
    public void testCreateHashMap() {
        Map<String, Pokemon> map = PokemonFactory.createMap(1);
        assertTrue(map instanceof HashMap);
    }

    @Test
    public void testCreateTreeMap() {
        Map<String, Pokemon> map = PokemonFactory.createMap(2);
        assertTrue(map instanceof TreeMap);
    }

    @Test
    public void testCreateLinkedHashMap() {
        Map<String, Pokemon> map = PokemonFactory.createMap(3);
        assertTrue(map instanceof LinkedHashMap);
    }

    @Test
    public void testInvalidOption() {
        assertThrows(IllegalArgumentException.class, () -> {
            PokemonFactory.createMap(4);
        });
    }
}
