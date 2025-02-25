import org.junit.Test;
import org.junit.Before;

public class TestClass1 {
    @Test
    public void testSomething() {
        // Original test implementation
    }
}

public class TestClass2 {
    private TestClass1 testClass1 = new TestClass1();
    
    @Test
    public void testSomethingAndSomethingElse() {
        testClass1.testSomething();
        // Additional test logic
    }
} 