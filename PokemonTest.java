import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    public void testConstructorAndGetters() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, "No");
        
        assertEquals("pikachu", pokemon.name); 
        assertEquals(25, pokemon.pokedexNumber);
        assertEquals("Electric", pokemon.type1);
        assertEquals("", pokemon.type2); 
        assertEquals("Mouse Pokémon", pokemon.classification);
        assertEquals(0.4, pokemon.height);
        assertEquals(6.0, pokemon.weight);
        assertEquals("Static", pokemon.abilities);
        assertEquals(1, pokemon.generation);
        assertEquals("No", pokemon.legendaryStatus);
    }

    @Test
    public void testToString() {
        Pokemon pokemon = new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, "Static", 1, "No");
    
        String expected = "Nombre: pikachu, Pokedex #: 25, Tipo1: Electric, Tipo2: , Clasificación: Mouse Pokémon, " +
                         "Altura: 0.4m, Peso: 6.0kg, Habilidades: Static, Generación: 1, Legendario: No";
        assertEquals(expected, pokemon.toString());
    }
}