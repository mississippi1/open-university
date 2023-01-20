

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class princeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class princeTest
{
    /**
     * Default constructor for test class princeTest
     */
    public princeTest()
    {
        
        boolean foundSomething = false;
        
        int[][] clone = {{5, 0, 4, 2, 0},
                        {-1, 3, 2, 1, 5}};
        
        int result = Ex13.prince(clone, 1, 0);
        assertTrue(result == 1);
                
        
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
    public void testPrince()
    {
    }
}

