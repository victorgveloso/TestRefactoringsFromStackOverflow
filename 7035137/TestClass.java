import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;
import static com.googlecode.catchexception.CatchException.verifyException;

public class TestClass {
    private Object obj = new Object();
    
    @Test
    public void testCase() {
        // assert 1
        verifyException(obj, ExpectedException.class).do(1);
        // assert 2
        verifyException(obj, ExpectedException.class).do(2);
    }
} 