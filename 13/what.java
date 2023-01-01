import java.util.*;
/**
 * Write a description of class what here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class what
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class what
     */
    public what()
    {
        // initialise instance variables
        x = 0;
    }
    private static int f(int[] a, int low, int high){
        int res = 0;
        for (int i=low; i <=high; i++)
            res += a[i];
        return res;
    }
    /**
     * The methods looks for the longest series of numbers in an array 
     * which their sum returns zero for mod 2
     * Time complexity - Going over a in the first loop (O(n)), 
     *  then going over partial a in secnd loop (O(n)),
     *  then going over partial of the partial a in third loop (O(n))
     *  So - O(n**3)
     * Memory complexity - Array a is already in memory, so only for c and temp vars
     *  So - O(1)
     * @param a array of natural numbers
     * @return longest streak of numbers whose sum divides by 2
     */
    public static int what(int a[])
    {
        int temp =0;
        for (int i=0; i<a.length; i++){
            for (int j=i; j<a.length; j++){
                int c = f(a, i, j);
                if (c%2 ==0){
                    if (j-i+1 > temp)
                        temp = j - i + 1;
                }
            }
        }
        return temp;
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
        System.out.println(what(s5));
        
    }
}
