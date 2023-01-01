

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CarTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarTest
{
    /**
     * Default constructor for test class CarTest
     */
    public CarTest()
    {
        Car c1 = new Car(1000001, 'D', "Tomer", true);
        assertTrue(c1.better(new Car(1000001, 'A', "Tomer", false)));
        assertTrue(c1.better(new Car(1000001, 'A', "Tomer", true)));
        assertTrue(c1.better(new Car(1000001, 'B', "Tomer", false)));
        assertTrue(c1.better(new Car(1000001, 'D', "Tomer", false)));
        assertFalse(c1.better(new Car(1000001, 'D', "Tomer", true)));
        Car c2 = new Car(1000001, 'A', "Tomer", false);
        assertFalse(c2.better(new Car(1000001, 'A', "Tomer", false)));
        assertFalse(c2.better(new Car(1000001, 'A', "Tomer", true)));
        assertFalse(c2.better(new Car(1000001, 'B', "Tomer", false)));
        assertFalse(c2.better(new Car(1000001, 'D', "Tomer", false)));
        assertFalse(c2.better(new Car(1000001, 'D', "Tomer", true)));
        
        assertTrue(c1.equals(new Car(1000001, 'D', "Tomer", true)));
        assertFalse(c1.equals(new Car(1000001, 'D', "Tomer", false)));
        assertFalse(c1.equals(new Car(1000001, 'B', "Tomer", false)));
        assertFalse(c1.equals(new Car(1000001, 'B', "Tomer1", false)));
        
        assertTrue(c2.equals(new Car(1000001, 'A', "Tomer", false)));
        assertFalse(c2.equals(new Car(1000001, 'A', "Tomer", true)));
        
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
    public void catTest()
    {
    }
}

