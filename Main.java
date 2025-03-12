import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map: 1) HashMap 2) TreeMap 3) LinkedHashMap");
        int option = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> pokemonMap = PokemonFactory.createMap(option);
        System.out.println("Implementación de Map seleccionada: " + pokemonMap.getClass().getSimpleName());

        PokemonManager manager = new PokemonManager(pokemonMap);

        System.out.println("Cargando datos desde pokemon_data_pokeapi.csv...");
        manager.loadPokemonData("pokemon_data_pokeapi.csv");

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección del usuario ordenada por tipo");
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo");
            System.out.println("5. Buscar Pokémon por habilidad");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre del Pokémon:");
                    String name = scanner.nextLine();
                    manager.addPokemonToCollection(name);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Pokémon:");
                    name = scanner.nextLine();
                    manager.showPokemon(name);
                    break;
                case 3:
                    manager.showUserCollectionSortedByType();
                    break;
                case 4:
                    manager.showAllPokemonsSortedByType();
                    break;
                case 5:
                    System.out.println("Ingrese la habilidad:");
                    String ability = scanner.nextLine();
                    manager.showPokemonByAbility(ability);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        scanner.close();
    }
}