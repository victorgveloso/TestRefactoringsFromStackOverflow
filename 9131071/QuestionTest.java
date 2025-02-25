import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.RuleChain;
import org.junit.rules.ExternalResource;
import static org.junit.Assert.*;

public class QuestionTest {
    private TestRule clientRule = new ExternalResource() {
        @Override
        protected void before() {
            setUpClientStub();
        }
        
        @Override
        protected void after() {
            tearDownClientStub();
        }
    };

    private TestRule objectRule = new ExternalResource() {
        @Override
        protected void before() {
            setUpObjectUnderTest();
        }
        
        @Override
        protected void after() {
            tearDownObjectUnderTest();
        }
    };

    @Rule
    public TestRule chain = RuleChain
        .outerRule(clientRule)
        .around(objectRule);

    private void setUpClientStub() {/*...*/}
    private void tearDownClientStub() {/*...*/}
    private void setUpObjectUnderTest() {/*...*/}
    private void tearDownObjectUnderTest() {/*...*/}

    @Test
    public void testSomething() {
        // Test implementation
    }
} 