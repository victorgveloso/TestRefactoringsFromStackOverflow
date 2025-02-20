import org.junit.Test;
import org.junit.Before;

public abstract class BaseTests {
    @Test
    protected void somethingHelper() {
        // Shared test logic
    }
}

public class TestClass1 extends BaseTests {
    @Before
    public void setup() {
        // TestClass1 specific configuration
    }
}

public class TestClass2 extends BaseTests {
    @Before
    public void setup() {
        // TestClass2 specific configuration
    }
    
    @Test
    public void testSomethingAndSomethingElse() {
        somethingHelper();
        // Additional test logic
    }
} 
} 