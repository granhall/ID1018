import java.util.*;
import static java.lang.System.out;

class testing {
    public static void main(String[] args) {
    Scanner in = new Scanner (System.in);
    out.println("Enter a number");
    String num1 = in.next();
    out.println("The numeric value for your number is: ");
    out.println("The length of your string is " + num1.length());
    for (int i = (num1.length()-1) ; i >= 0; i--) {
        char currentvalue1 = num1.charAt(i);
        int numeric1 = Character.getNumericValue(currentvalue1);
        out.println(currentvalue1);
        }
    in.close();
    }
}