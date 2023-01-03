

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class IsWayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IsWayTest
{
    /**
     * Default constructor for test class IsWayTest
     */
    public IsWayTest()
    {
        int [] a= {2,4,1,6,4,2,4,3,5};
        int [] a1= {4, 5, 1, 4, 4, 0, 0, 1, 5, 5, 1, 4, 3, 2, 3, 5, 4, 2};
        int [] a2= {5, 2, 3, 5, 4, 4, 2, 3, 5};
        int [] a3= {5, 4, 3, 4, 2, 2};
        int [] a4= {1,8,1};
        int [] a5= {1,1,9};
        // assertTrue(IsWay.isWay(a));
        Ex13 IsWay = new Ex13();
        // assertTrue(IsWay.isWay(a1));
        assertTrue(IsWay.isWay(a2));
        assertTrue(IsWay.isWay(a3));
        assertFalse(IsWay.isWay(a4));
        assertTrue(IsWay.isWay(a5));
    }
    @Test
    public static void isWayTest(){
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
    public void isWaytest()
    {
    }
}

