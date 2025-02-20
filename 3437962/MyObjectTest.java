import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Map;

public class MyObjectTest {
    private MyObject myObj;
    
    @Before
    public void setUp() {
        myObj = new MyObject(...);
    }

    @Test
    public void probablyFunctionalTestForMethodX() {
        Map<Object, Object> inputOutputMap = Map.of(
            someInput, expectedOutput,
            someOtherInput, expectedOtherOutput
        );
        final int maxIterations = 100;
        
        for (int i = 0; i < maxIterations; i++) {
            for (Map.Entry<Object, Object> test : inputOutputMap.entrySet()) {
                assertEquals(test.getValue(), myObj.myFunction(test.getKey()));
            }
        }
    }
} 