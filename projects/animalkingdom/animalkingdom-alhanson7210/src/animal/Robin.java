package animal;

/**
 * A robin is a bird with a name, feather color, and can fly
 */
public class Robin extends Bird {
    /**
     * Constructs a robin with a name, feather color, and adds its respective inheritance
     * @param name name of the robin
     * @param featherColor color of the robin's feather color
     */
    public Robin(String name, String featherColor) {
        super(name, featherColor);
        animalInheritance.add("Robin");
    }
    /**
     * prints out a statement staying the robin can fly
     */
    public void fly() {
        System.out.println(String.format("%s is flying around in the air",getName()));
    }
}
