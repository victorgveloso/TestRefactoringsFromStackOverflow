import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

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
    
    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World" })
    void verifyFileExists(String argument) throws Exception {
        assertNotNull(argument);
        verifyOtherArea(testCaseService1);
        doReturn(false).when(areaService).checkExists(any(String.class), eq(false));
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWithSimpleMethodSource(String argument) {
        assertNotNull(argument);
    }

    static Stream<String> stringProvider() {
        return Stream.of("foo", "bar");
    }
} 