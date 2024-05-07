package cr.ac.ucr.paraiso.ie.algoritmos.semana8;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.semana8.BubbleSort;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testBubbleSortWithIntegers() {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        Integer[] sortedArray = (Integer[]) bubbleSort.bubbleSort(intArray);

        assertArrayEquals(expected, sortedArray);
    }

    @Test
    public void testBubbleSortWithStrings() {
        BubbleSort bubbleSort = new BubbleSort();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};
        String[] unexpected = {"banana", "apple", "orange", "grape", "kiwi"};

        String[] sortedArray = (String[]) bubbleSort.bubbleSort(stringArray);

        assertArrayEquals(expected, sortedArray);
        assertArrayEquals(unexpected, sortedArray);
    }
}