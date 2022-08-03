package animal;

/**
 * A mammal is an abstract animal that has a spinal chord
 */
public abstract class Mammal extends Chordata {
    /**
     * Name of the mammal
     * @param name name of the mammal
     */
    Mammal(String name) {
        super(name);
        animalInheritance.add("Mammal");
    }

    /**
     * a mammal can drink milk so a print statement mentions the animal can drink milk
     */
    public void drinkMilk() {
        System.out.println(String.format("%s is a mammal that drinks milk.", getName()));
    }
}
