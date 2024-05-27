package cr.ac.ucr.paraiso.ie.algoritmos.semana8;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.tema5.OptimizedBubbleSort;

import static org.junit.Assert.assertArrayEquals;

public class OptimizedBubbleSortTest {

    @Test
    public void testOptimizedBubbleSortWithIntegers() {
        OptimizedBubbleSort<Integer> bubbleSort = new OptimizedBubbleSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        bubbleSort.optimizedBubbleSort(intArray);

        assertArrayEquals(expected, intArray);
    }

    @Test
    public void testOptimizedBubbleSortWithStrings() {
        OptimizedBubbleSort<String> bubbleSort = new OptimizedBubbleSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};

        bubbleSort.optimizedBubbleSort(stringArray);

        assertArrayEquals(expected, stringArray);
    }
}