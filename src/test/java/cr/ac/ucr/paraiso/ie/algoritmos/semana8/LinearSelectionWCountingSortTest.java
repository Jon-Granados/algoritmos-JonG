package cr.ac.ucr.paraiso.ie.algoritmos.semana8;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.tema5.LinearSelectionWCountingSort;

public class LinearSelectionWCountingSortTest {

	@Test
    public void testLinearSelectionSortWithCountingWithIntegers() {
		LinearSelectionWCountingSort<Integer> selectionSort = new LinearSelectionWCountingSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        selectionSort.linearSelectionSortWithCounting(intArray);

        assertArrayEquals(expected, intArray);
    }

    @Test
    public void testLinearSelectionSortWithCountingWithStrings() {
    	LinearSelectionWCountingSort<String> selectionSort = new LinearSelectionWCountingSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};

        selectionSort.linearSelectionSortWithCounting(stringArray);

        assertArrayEquals(expected, stringArray);
    }
}
