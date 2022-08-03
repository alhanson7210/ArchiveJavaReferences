package animal;

/**
 * abstract class to create a bird with a name and string color
 */
public abstract class Bird extends Chordata {
    private String featherColor;
    /**
     * Creating a bird
     * @param name the bird's name
     * @param featherColor the feather color
     */
    Bird(String name, String featherColor) {
        super(name);
        this.featherColor = featherColor;
        animalInheritance.add("Bird");
    }

    /**
     * current feathercolor
     * @return a birds feather color
     */
    private String getFeatherColor() {
        return featherColor;
    }

    /**
     * prints out the name and the feather color of the animal
     */
    public void showFeathers() {
        System.out.println(String.format("%s has a %s feather color.", getName(), getFeatherColor()));
    }
}
