import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class TestClass {
    private Object obj = new Object();
    
    @Test
    public void testCase() {
        try {
            // assert 1
            obj.do(1);
            fail();
        } catch (ExpectedException e) {
            assertEquals("Expected message", e.getMessage());
        }

        try {
            // assert 2
            obj.do(2);
            fail();
        } catch (ExpectedException e) {
            assertEquals("Expected message", e.getMessage());
        }
    }
} 