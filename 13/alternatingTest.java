

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class alternatingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class alternatingTest
{
    /**
     * Default constructor for test class alternatingTest
     **/
    public alternatingTest()
    {
        Ex13 alt = new Ex13();
        String emptyString="";
        String twoCharString="10";        
        String sampleString="00011011";
        String halfAndHalf="1001001101";
        assertTrue(alt.alternating(emptyString) == 0);
        assertTrue(alt.alternating(twoCharString) == 0);
        // assertTrue(alt.alternating(sampleString) == 2);
        int s = alt.alternating(halfAndHalf);
        assertTrue(alt.alternating(halfAndHalf) == 2);
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
    public void alternatingtest()
    {
    }
}

