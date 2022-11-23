
/**
 * This program calculates the perimeter and area of a triangle, for his inputed sides
 * @Tomer Peker
 * @20221021
 */
import java.util.Scanner;
import java.lang.Math;
public class Triangle1
{
     public static void main (String [] args)
     {
         Scanner scan = new Scanner (System.in);
         System.out.println ("This program calculates the area "
         + "and the perimeter of a given triangle. ");
         System.out.println ("Please enter the three lengths"
         + " of the triangle's sides");
         int a = scan.nextInt();
         int b = scan.nextInt();
         int c = scan.nextInt();
         int perimeter = a + b + c;
         float halfPerimeter = perimeter / 2;
         double area =  Math.sqrt(halfPerimeter * (halfPerimeter  - a) * (halfPerimeter - b) * (halfPerimeter - c));
         System.out.println("The lengths of the triangle sides are:" + a + ", " + b + ", " + c + ".");
         System.out.println("The perimeter of the triangle is: " + perimeter);
         System.out.println("The area of the triangle is: " + area);
     } // end of method main
} //end of class Triangle