import java.io.*;
import java.util.*;
import java.util.regex.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private Set<Pokemon> userCollection;

    public PokemonManager(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.userCollection = new HashSet<>(); 
    }

    public void addPokemonToCollection(String name) {
        name = name.trim().toLowerCase(); 
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado en los datos.");
            return;
        }
        Pokemon p = pokemonMap.get(name);
        if (userCollection.contains(p)) {
            System.out.println("El Pokémon ya está en la colección.");
        } else {
            userCollection.add(p);
            System.out.println("Pokémon agregado a la colección.");
        }
    }

    public void showPokemon(String name) {
        name = name.trim().toLowerCase();
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("Pokémon no encontrado.");
        }
    }

    public void showUserCollectionSortedByType() {
        if (userCollection.isEmpty()) {
            System.out.println("La colección del usuario está vacía. Agrega Pokémon usando la opción 1.");
        } else {
            userCollection.stream()
                .sorted(Comparator.comparing(p -> p.type1))
                .forEach(p -> System.out.println("Nombre: " + p.name + ", Tipo1: " + p.type1));
        }
    }

    public void showAllPokemonsSortedByType() {
        pokemonMap.values().stream()
            .sorted(Comparator.comparing(p -> p.type1))
            .forEach(p -> System.out.println("Nombre: " + p.name + ", Tipo1: " + p.type1));
    }

    public void showPokemonByAbility(String ability) {
        List<Pokemon> pokemonWithAbility = pokemonMap.values().stream()
            .filter(p -> p.abilities.toLowerCase().contains(ability.toLowerCase()))
            .toList();

        if (pokemonWithAbility.isEmpty()) {
            System.out.println("No se encontraron Pokémon con la habilidad: " + ability);
        } else {
            pokemonWithAbility.forEach(p -> System.out.println("Nombre: " + p.name));
        }
    }

    public void loadPokemonData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); 

            while ((line = br.readLine()) != null) {
                List<String> values = new ArrayList<>();
                Matcher matcher = Pattern.compile("\"([^\"]*)\"|([^,]+)").matcher(line);
                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        values.add(matcher.group(1).trim()); 
                    } else {
                        values.add(matcher.group(2).trim()); 
                    }
                }

                if (values.size() < 10) continue;

                try {
                    String name = values.get(0).trim().toLowerCase(); 
                    int pokedexNumber = Integer.parseInt(values.get(1));
                    String type1 = values.get(2);
                    String type2 = values.get(3).isEmpty() ? "N/A" : values.get(3);
                    String classification = values.get(4);
                    double height = Double.parseDouble(values.get(5));
                    double weight = Double.parseDouble(values.get(6));
                    String abilities = values.get(7);
                    int generation = Integer.parseInt(values.get(8));
                    String legendaryStatus = values.get(9);

                    pokemonMap.put(name, new Pokemon(name, pokedexNumber, type1, type2, classification,
                                                     height, weight, abilities, generation, legendaryStatus));
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir datos en la línea: " + line);
                }
            }
            System.out.println("Archivo cargado exitosamente. " + pokemonMap.size() + " Pokémon registrados.");

            
            System.out.println("Pokémon cargados:");
            pokemonMap.keySet().forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}