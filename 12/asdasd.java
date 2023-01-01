

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class testRent.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class asdasd
{
  
    
    public static void main( String[] args)
    {
        Rent r1=new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));  
        Rent before =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(30,1,2020), new Date(31,1,2020));  
        Rent sameStart = new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(7,2,2020));  
        Rent sameEnd =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(3,2,2020), new Date(5,2,2020));  
        Rent endIsAfter =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(3,2,2020), new Date(7,2,2020));  
        Rent contains =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(30,1,2020), new Date(7,2,2020));  
        Rent after =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(6,2,2020), new Date(20,2,2020));  
        System.out.println("asdasd");
        System.out.println(r1.overlap(sameStart));
        
    }
}

