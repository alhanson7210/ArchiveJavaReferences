/**
 *The Arithmetic class contains print statements that perform addition, division, and a combination of the two.
 */
public class Arithmetic {
  //main method
  public static void main(String[] args) {
    //variable declaration
    int a = 1425;
    int b = -749;
    float x = 1.43f;
    float y = 2.53f;

    //variable use in print statement
    System.out.println("numbers");
    System.out.println(a);
    System.out.println(b);
    System.out.println(x);
    System.out.println(y);

    System.out.println("addition");
    System.out.println(a + a);
    System.out.println(a + b);
    System.out.println(a + x);
    System.out.println(a + y);
    System.out.println(x + y);

    System.out.println("division");
    System.out.println(b / a);
    System.out.println(b / b);
    System.out.println(b / x);
    System.out.println(b / y);
    System.out.println(x / y);
    System.out.println(y / x);

    System.out.println("addition and division");
    System.out.println(a * (x + y));
    System.out.println(b * (y + a) / x);
    System.out.println(x + a / (b + y));
    System.out.println(y * (b - a) * x);

    System.out.println("Finished Program ^w^");
  }

}
