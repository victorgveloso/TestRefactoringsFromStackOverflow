import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public abstract class TestCaseResourceTest {
    @Mock
    private TestService testService;
    @Mock
    private AreaService areaService;
    
    protected TestCaseService1 testCaseService1;

    protected abstract TestCaseService1 getServiceToTest();

    @Before
    public void before() throws Exception {
        testCaseService1 = getServiceToTest();
        MockitoAnnotations.initMocks(this);
        beforeFileTest();
    }

    private void beforeFileTest() throws Exception {
        doReturn(true).when(areaService).checkExists(any(String.class), eq(false));
    }

    @Test
    public void verifyFileExists() throws Exception {
        verifyOtherArea(testCaseService1);
        doReturn(false).when(areaService).checkExists(any(String.class), eq(false));
    }
}

// Concrete implementation
public class TestCaseResourceTest1 extends TestCaseResourceTest {
    @Override
    protected TestCaseService1 getServiceToTest() {
        return mock(TestCaseService1.class);
    }
} 