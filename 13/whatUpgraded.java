import java.util.*;
/**
 * Write a description of class what here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class whatUpgraded
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class what
     */
    public whatUpgraded()
    {
        // initialise instance variables
        x = 0;
    }
    private static int f(int[] a, int low, int high){
        int res = 0;
        for (int i=low; i <high; i++)
            res += a[i];
        return res;
    }
    /**
     * The methods looks for the longest series of numbers in an array 
     * which their sum returns zero for mod 2
     * Time complexity - Going over a in the first loop (O(n)) to calculate the sum o(n), 
     *  if even than finished.
     *  If not, find the first odd number (because odd minus odd is even), 
     *      which requires going over the array again (O(n)).
     *  So, at worst case O(2*n) = O(n).
     * Memory complexity - Array a is already in memory, so O(1).
     * @param a array of natural numbers
     * @return longest streak of numbers whose sum divides by 2
     */
    public static int what(int[] a)
    {
        int currentInt;
        int currentIntFromEnd;
        int totalSum = f(a, 0, a.length);
        if (totalSum % 2 == 0){
            return a.length;
        }
        return idxOfFirstOddNumber(a);
    }
    private static int idxOfFirstOddNumber(int[] a){
        for (int i = 0 ; i < a.length; i++){
            if ((a[i] % 2 != 0) || (a[a.length-i -1] % 2 != 0)){
                return a.length - i - 1;
            }
        }
        return a.length;
    }
    public static void main(String [] args){
        int [] s =  {1,2,3,4};
        int [] s1 =  {4,4,4,4};
        int [] s2 =  {4,4,1, 6,10, 8 };
        int [] s3=  {4,4,6,10, 18, 24, 26, 28};
        int [] s4=  {4,4,6,10, 18, 25, 24, 26, 28};
        int [] s5=  {4,4,6,1, 1, 1, -8, 26, 28};
        System.out.println(what(s));
        System.out.println(what(s1));
        System.out.println(what(s2));
        System.out.println(what(s3));
        System.out.println(what(s4));
        System.out.println(what(s5));
        
    }
}
