public class Pokemon {
    String name;
    int pokedexNumber;
    String type1;
    String type2;
    String classification;
    double height;
    double weight;
    String abilities;
    int generation;
    String legendaryStatus;

    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification,
                   double height, double weight, String abilities, int generation, String legendaryStatus) {
        this.name = name.trim().toLowerCase(); 
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1.trim();
        this.type2 = type2.trim();
        this.classification = classification.trim();
        this.height = height;
        this.weight = weight;
        this.abilities = abilities.trim();
        this.generation = generation;
        this.legendaryStatus = legendaryStatus.trim();
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Pokedex #: " + pokedexNumber + ", Tipo1: " + type1 + ", Tipo2: " + type2 +
               ", Clasificación: " + classification + ", Altura: " + height + "m, Peso: " + weight + "kg, " +
               "Habilidades: " + abilities + ", Generación: " + generation + ", Legendario: " + legendaryStatus;
    }
}