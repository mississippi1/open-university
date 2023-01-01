
/**
 * This program checks if a triangle is valid, and prints his type (if valid).
 * @Tomer Peker
 * @20221021
 */
import java.util.Scanner;
import java.lang.Math;
public class Triangle2
{
     public static void main (String [] args)
     {
         Scanner scan = new Scanner (System.in);
         System.out.println ("This program checks if a triangle is valid "
         + "and prints his type. ");
         System.out.println ("Please enter the three lengths"
         + " of the triangle's sides");
         int a = scan.nextInt();
         int b = scan.nextInt();
         int c = scan.nextInt();
         System.out.print("The numbers: " + a + ", " + b + " and " + c);
         if (
             (a>0) &&
             (b>0) &&
             (c>0) &&
             (a < b + c) && 
             (b < a + c) && 
             (c < a + b))
             {
             if ((a == b) && (b == c))
                 System.out.println(" represent an equilateral triangle");
             else if ((a == b) || (b == c) || (a == c))
                 System.out.println(" represent an isosceles triangle");
             else if ((Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) == c) ||
                     (Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)) == b) ||
                     (Math.sqrt(Math.pow(c, 2) + Math.pow(b, 2)) == a))
                 System.out.println(" represent a right-angle triangle");
             else
                 System.out.println(" represent a common triangle");
             }
         else
         System.out.println(" cannot represent a triangle");
     } // end of method main
} //end of class Triangle