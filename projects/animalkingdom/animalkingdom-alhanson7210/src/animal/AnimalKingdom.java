package animal;

import java.util.ArrayList;

/**
 * The animal kingdom which all class inherent from
 * @author Alex Hanson
 * @version 1.0
 */
public abstract class AnimalKingdom {
    private String name;
    ArrayList<String> animalInheritance;

    /**
     * Animal constructor that creates each following extended classes uses to create a name for each animal and save the inheritance
     * @param name name of a give animal
     */
    AnimalKingdom(String name) {
        animalInheritance = new ArrayList<>();
        animalInheritance.add("Animal Kingdom");
        this.name = name;
    }
    /**
     * Get the animals name
     * @return a string of the animals name
     */
    String getName() {
        return name;
    }

    /**
     * Formatting the name of an animal of the animal kingdom
     * @return a formatted string with the name
     */
    @Override
    public String toString() {
        String inheritance = "This animal is a " + getName() + "(";
        for (int i = 0; i < animalInheritance.size(); i++) {
            if (i != animalInheritance.size() - 1) {
                inheritance += animalInheritance.get(i) + ", ";
            }
            else {
                inheritance += animalInheritance.get(i) + ")";
            }
        }
        return inheritance;
    }
}
