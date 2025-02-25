import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyObjectTest {
    private MyObject myObj;
    
    @Before
    public void setUp() {
        myObj = new MyObject(...);
    }

    @Test
    public void testSomeInputGivesExpectedOutput() {
        assertEquals(expectedOutput, myObj.myFunction(someInput));
    }

    @Test
    public void testSomeOtherInputGivesExpectedOutput() {
        assertEquals(expectedOtherOutput, myObj.myFunction(someOtherInput));
    }

    @Test
    public void test_MyFunction_hasNoSideEffects() {
        MyObject original = myObj.clone();
        myObj.myFunction(someInput);
        assertEquals(original, myObj);
    }
} 