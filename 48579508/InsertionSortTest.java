public class InsertionSortTest extends AbstractSortingTest {
    @Override
    protected ISortingAlgorithm createAlgorithm() {
        return new ISortingAlgorithm() {
            public int[] sort(int[] input) {
                return Sort.insertionSort(input);
            }
        };
    }
} 