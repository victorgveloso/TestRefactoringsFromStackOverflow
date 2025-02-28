import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestWatcher;

public class AbstractTest {
    @Rule 
    public TestWatcher resultReportingTestWatcher = new TestWatcher(this);
}

public class YourTest extends AbstractTest {
    @Test
    public void sampleTest() {
        // Test implementation
    }
} 