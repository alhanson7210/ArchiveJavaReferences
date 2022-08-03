package animal;

/**
 * Creates a mammal called a human that can bend its thumb
 */
public class Human extends Mammal {
    /**
     * create a human with a name and adds its inheritance
     * @param name name of the human
     */
    public Human(String name) {
        super(name);
        animalInheritance.add("Human");
    }
    /**
     * prints a statement saying the human can bend its thumb
     */
    public void bendThumb() {
        System.out.println(String.format("%s is bending their thumb.", getName()));
    }
}
