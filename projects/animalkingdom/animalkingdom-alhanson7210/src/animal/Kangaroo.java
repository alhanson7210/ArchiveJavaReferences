package animal;

/**
 * Kangaroo is a mammal that can hop around
 */
public class Kangaroo extends Mammal {
    /**
     * constructor creating a kangaroo that has a name and adds its inheritance
     * @param name name of the animal
     */
    public Kangaroo(String name) {
        super(name);
        animalInheritance.add("Kangaroo");
    }

    /**
     * prints out a statement of the animal hopping
     */
    public void hop() {
        System.out.println(String.format("%s can hop around.", getName()));
    }
}
