import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractSortingTest {
    private ISortingAlgorithm algorithm;
    
    @BeforeEach
    void setUp() {
        this.algorithm = createAlgorithm();
    }
    
    protected abstract ISortingAlgorithm createAlgorithm();
    
    @ParameterizedTest
    @EnumSource(ArrayCase.class)
    void testSorting(ArrayCase arrayCase) {
        assertArrayEquals(
            arrayCase.expectedArray(),
            algorithm.sort(arrayCase.testArray())
        );
    }
    
    enum ArrayCase {
        // ... existing enum cases from question ...
    }
} 