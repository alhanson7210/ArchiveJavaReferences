/**
 *The StringFun class takes in three string arguments from the command line and performs seven string methods.
 *The additiional string methods are toUpperCase and endsWith.
 *the string method toUpperCase was used to capitalize an entire String.
 *the string method endsWith tested whether the string ends with a particular subString.
 */
public class StringFun {
  //string method
  public static void main(String[] args) {
    //variable declaration
    String s = null;
    String otherString = null;
    String subString = null;

    //error handling
    try {
      //argument assignment
      s = args[0];
      otherString = args[1];
      subString = args[2];

    } catch (ArrayIndexOutOfBoundsException e) {
      //error handling with no arguments
      System.out.println("Three string arguments weren't used. ");
      System.exit(1);

    }
    //string method: s.length()
    System.out.println("The string length is: " + s.length());

    //string method: s.equals(otherString)
    System.out.println("The first string being equal to the other string is: " + s.equals(otherString));

    //string method: s.substring(startIndex, endIndex)
    System.out.println("The first to indexs of the first string from the beginning is: " + s.substring(0,2));

    //string method: s.trim()
    System.out.println("The first string with whitespace removed is: " + s.trim());

    //string method: s.indexOf(subString)
    System.out.println("The index of the subString is: " + s.indexOf(subString));

    //string method: s.lastIndexOf(subString)
    System.out.println("The last index for the given subString is: " + s.lastIndexOf(subString));

    //string method: s.charAt(index)
    System.out.println("The character at index 1 is: " + s.charAt(1));

    //string method: s.toUpperCase()
    System.out.println("The entire string capitalized is: " + s.toUpperCase());

    //string method: s.endsWith(String suffix)
    System.out.println("Does the string end with the subString?: " + s.endsWith(subString));


  }

}
