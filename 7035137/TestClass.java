import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

public class TestClass {
    private Object obj = new Object();
    
    @Test(expectedExceptions = ExpectedException.class)
    public void testCase1() {
        // assert 1
        obj.do(1);
    }

    @Test(expectedExceptions = ExpectedException.class)
    public void testCase2() {
        // assert 2
        obj.do(2);
    }
} 