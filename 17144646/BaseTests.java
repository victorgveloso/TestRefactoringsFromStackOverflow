import org.junit.Test;
import org.junit.Before;

public abstract class BaseTests {
    protected void somethingHelper() {
        // Shared test logic
    }
}

public class TestClass1 extends BaseTests {
    @Test
    public void testSomething() {
        somethingHelper();
    }
}

public class TestClass2 extends BaseTests {
    @Test
    public void testSomethingAndSomethingElse() {
        somethingHelper();
        // Additional test logic
    }
} 