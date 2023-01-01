

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
public class testRent
{
    /**
     * Default constructor for test class testRent
     */
    public testRent()
    {
        Rent r1=new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));  
        System.out.println(r1.getPrice());
        System.out.println(r1.upgrade(new Car (1234567, 'B', "Opel", false)));
        }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testRent()
    {
        Rent r1=new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));  
        Rent before =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(29,1,2020), new Date(30,1,2020));  
        Rent sameStart = new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(7,2,2020));  
        Rent sameEnd =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(3,2,2020), new Date(5,2,2020));  
        Rent endIsAfter =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(3,2,2020), new Date(7,2,2020));  
        Rent contains =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(30,1,2020), new Date(7,2,2020));  
        Rent after =new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(6,2,2020), new Date(20,2,2020));  
        assertTrue(r1.equals(r1));
        assertTrue(r1.howManyDays() == 4);
        assertTrue(r1.getPrice() == 400);
        assertTrue(new Rent(r1).upgrade(new Car (1234567, 'B', "Opel", false)) == 200);
        assertEquals(r1.overlap(before), null);
        System.out.println(r1.overlap(sameStart));
        Rent c = r1.overlap(sameStart);
        assertTrue(new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(7,2,2020)).equals(r1.overlap(sameStart)), "Smae");
        assertTrue(r1.overlap(sameEnd).equals(new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020))));
        assertTrue(r1.overlap(endIsAfter).equals(new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(7,2,2020))));
        assertTrue(r1.overlap(contains).equals(new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(30,1,2020), new Date(7,2,2020))));
        assertTrue(r1.overlap(after) == null);
        
    }
}

