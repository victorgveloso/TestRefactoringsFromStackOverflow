import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestCaseResourceTest1.class,
    TestCaseResourceTest2.class
})
public class TestSuiteClass {
    @BeforeClass
    public static void setup() throws Exception {
        new TestCaseResourceTest1().beforeFileTest();
    }
}

public class TestCaseResourceTest1 {
    @Mock
    private TestService testService;
    @Mock
    private AreaService areaService;
    
    private TestCaseService1 testCaseService1;

    @Before
    public void before() throws Exception {
        testCaseService1 = mock(TestCaseService1.class);
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