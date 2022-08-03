import animal.Kangaroo;
import animal.Human;
import animal.Emu;
import animal.Robin;

/**
 * Class with a main method that instantiates at least one Kangaroo, Robin, Emu, and Human and demonstrates your implementation of these classes
 */
public class MainKingdom {
    /**
     * No use for command line string arguments
     * @param args unused
     */
    public static void main(String[] args) {
	// write your code here
        Kangaroo kang = new Kangaroo("kangaroo jack");
        System.out.println(kang.toString());
        kang.hop();
        kang.drinkMilk();
        kang.backbone();
        System.out.println("\n");

        Human hue = new Human("Allen");
        System.out.println(hue.toString());
        hue.bendThumb();
        hue.drinkMilk();
        hue.backbone();
        System.out.println("\n");

        Emu mu = new Emu("muttal", "blue");
        System.out.println(mu.toString());
        mu.run();
        mu.showFeathers();
        mu.backbone();
        System.out.println("\n");

        Robin bin = new Robin("robby", "orange");
        System.out.println(bin.toString());
        bin.fly();
        bin.showFeathers();
        bin.backbone();
        System.out.println("\n");
    }
}
