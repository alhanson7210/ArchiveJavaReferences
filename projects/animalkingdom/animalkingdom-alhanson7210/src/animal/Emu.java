package animal;

/**
 * Bird extended to Emu as a fellow bird
 */
public class Emu extends Bird {
    /**
     * Constructs a bird with a name and a feather color
     * @param name name of the bird
     * @param featherColor color of the birds feathers
     */
    public Emu(String name, String featherColor) {
        super(name, featherColor);
        animalInheritance.add("Emu");
    }
    /**
     * prints a statement about a bird(Emu) that can run
     */
    public void run() {
        System.out.println(String.format("%s is running.",getName()));
    }
}
