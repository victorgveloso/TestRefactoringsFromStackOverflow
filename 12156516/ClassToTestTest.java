import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClassToTestTest {

    @Mock
    private AnotherClass anotherClass;
    
    @InjectMocks
    private ClassToTest classToTest;
    
    @Captor
    private ArgumentCaptor<List<Integer>> listCaptor;

    @Test
    public void ensure_that_list_with_value___Z___is_passed_to___AnotherClass() {
        // Test implementation would need to match production code
        // This test currently doesn't align with the original class's behavior
        classToTest.methodToTest(1, 2);
        
        verify(anotherClass).receiveSomething(listCaptor.capture());
        assertThat(listCaptor.getValue()).contains(3);
    }
} 