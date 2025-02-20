import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    private enum ArrayCase {
        SINGLETON(new int[]{2}, new int[]{2}),
        REVERSE_SORTED(new int[]{-1,3,6,7,9}, new int[]{9,7,6,3,-1}),
        MOSTLY_DUPLICATES(new int[]{-1,-1,0,0,0,2,2,2,3,4,4,4,7,7,7,9,9},
                         new int[]{4,9,4,-1,9,0,2,2,2,7,-1,0,3,4,7,0,7});

        private final int[] sortedArray;
        private final int[] testArray;

        ArrayCase(int[] sortedArray, int[] testArray) {
            this.sortedArray = sortedArray;
            this.testArray = testArray;
        }
        
        public int[] expectedArray() { return sortedArray; }
        public int[] testArray() { return testArray; }
    }

    @ParameterizedTest
    @EnumSource(ArrayCase.class)
    void insertionSort(ArrayCase arrayCase) {
        assertArrayEquals(
            arrayCase.expectedArray(),
            Sort.insertionSort(arrayCase.testArray())
        );
    }

    @ParameterizedTest
    @EnumSource(ArrayCase.class)
    void selectionSort(ArrayCase arrayCase) {
        assertArrayEquals(
            arrayCase.expectedArray(),
            Sort.selectionSort(arrayCase.testArray())
        );
    }
} 