package cr.ac.ucr.paraiso.ie.algoritmos.semana8;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.tema5.LinearSelectionWithSwappingSort;

import static org.junit.Assert.assertArrayEquals;

public class LinearSelectionWithSwappingSortTest {

    @Test
    public void testLinearSelectionWithSwappingSortWithIntegers() {
        LinearSelectionWithSwappingSort<Integer> selectionSort = new LinearSelectionWithSwappingSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};

        selectionSort.linearSelectionWithSwappingSort(intArray);

        assertArrayEquals(expected, intArray);
    }

    @Test
    public void testLinearSelectionWithSwappingSortWithStrings() {
        LinearSelectionWithSwappingSort<String> selectionSort = new LinearSelectionWithSwappingSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};

        selectionSort.linearSelectionWithSwappingSort(stringArray);

        assertArrayEquals(expected, stringArray);
    }
}