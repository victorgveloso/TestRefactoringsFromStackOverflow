import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassToTestTest {

    @Mock
    private AnotherClass anotherClass;
    
    @InjectMocks
    private ClassToTest classToTest;

    @Test
    public void ensure_that_value___Z___is_passed_to___AnotherClass() {
        classToTest.methodToTest(1, 2);
        verify(anotherClass).receiveSomething(eq(3));
    }
} 