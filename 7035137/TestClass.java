import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestClass {
    private Object obj = new Object();
    
    interface Callback {
        void call() throws Exception;
    }

    void expectsException(Callback callback) {
        try {
            callback.call();
            fail("ExpectedException not thrown");
        } catch (Exception e) {
            if (!(e instanceof ExpectedException)) {
                fail("Expected ExpectedException, got " + e.getClass());
            }
            assertEquals("Expected message", e.getMessage());
        }
    }

    @Test
    public void testCase() {
        expectsException(new Callback() {
            public void call() throws Exception {
                // assert 1
                obj.do(1);
            }
        });

        expectsException(new Callback() {
            public void call() throws Exception {
                // assert 2
                obj.do(2);
            }
        });
    }
} 