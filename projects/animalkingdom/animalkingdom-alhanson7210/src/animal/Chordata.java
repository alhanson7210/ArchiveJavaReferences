package animal;

/**
 * All animals that have a vertebrate extend from chordata
 */
abstract class Chordata extends AnimalKingdom {
    /**
     * passes the name to the super to create the name
     * @param name name to be passed
     */
    Chordata(String name) {
        super(name);
        animalInheritance.add("Chordata");
    }

    /**
     * prints out a statement about having a backbone
     */
    public final void backbone() {
        String VERTEBRATE = "I HAVE A BACKBONE BECAUSE I AM A VERTEBRATE";
        System.out.println(VERTEBRATE);
    }
}
