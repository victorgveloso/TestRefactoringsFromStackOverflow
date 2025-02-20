import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestAssertEquals {
    @Test
    public void testStringAssignment1() {
        String a = "Hi";
        assertEquals(a, "Hi");
    }
    
    @Test
    public void testStringAssignment2() {
        String a = "Hi";
        assertEquals("Hi", a);
    }
} 