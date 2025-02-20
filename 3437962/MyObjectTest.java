import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MyObjectTest {
    private MyObject myObj;
    
    @Before
    public void setUp() {
        myObj = new MyObject(...);
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
            {someInput, expectedOutput},
            {someOtherInput, expectedOtherOutput}
        };
    }
    
    private final Object input;
    private final Object expected;
    
    public MyObjectTest(Object input, Object expected) {
        this.input = input;
        this.expected = expected;
    }
    
    @Test
    public void testFunctionality() {
        assertEquals(expected, myObj.myFunction(input));
    }
} 