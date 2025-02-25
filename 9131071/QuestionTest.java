import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTest {
    @Before  // Will execute second (reverse lex order)
    public void z_setUpObjectUnderTest() {
        // Object under test setup
    }

    @Before  // Will execute first (reverse lex order)
    public void a_setUpClientStub() {
        // Client stub setup
    }

    @Test
    public void testSomething() {
        // Test implementation
    }
} 