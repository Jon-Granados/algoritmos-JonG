package cr.ac.ucr.paraiso.ie.algoritmos.semana8;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucr.paraiso.ie.algoritmos.tema5.SinkingSort;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class SinkingSortTest {

    @Test
    public void testSinkingSortWithStrings() {
        SinkingSort<String> stringSort = new SinkingSort<>();
        String[] stringArray = {"banana", "apple", "orange", "grape", "kiwi"};
        String[] expected = {"apple", "banana", "grape", "kiwi", "orange"};
        
        stringSort.sinkingSort(stringArray);
        
        assertArrayEquals(expected, stringArray);
    }
    
    @Test
    public void testSinkingSortWithIntegers() {
        SinkingSort<Integer> intSort = new SinkingSort<>();
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        Integer[] expected = {11, 12, 22, 25, 34, 64, 90};
        
        intSort.sinkingSort(intArray);
        
        assertArrayEquals(expected, intArray);
    }
}