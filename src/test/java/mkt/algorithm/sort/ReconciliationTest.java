package mkt.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @since 0.0.1
 * @author mkt
 */
public class ReconciliationTest {
    
    private static class Element {
        int key;
        int value;
        Element(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final
            Comparator<Element> comparator = new Comparator<Element>() {
        @Override
        public int compare(Element e0, Element e1) {
            return e0.key < e1.key ? -1 : e0.key > e1.key ? 1 : 0;
        }
    };
    
    @Test
    public void testBubbleSort() {
        reconcile(new BubbleSort<Integer>());
        reconcileStability(new BubbleSort<>(comparator));
    }
    
    @Test
    public void testCombSort() {
        reconcile(new CombSort<Integer>());
        
        /* Comb Sort is not a stable sorting algorithm.
        reconcileStability(new CombSort<>(comparator));
        */
    }
    
    @Test
    public void testGnomeSort() {
        reconcile(new GnomeSort<Integer>());
        reconcileStability(new GnomeSort<>(comparator));
    }
    
    @Test
    public void testGnomeSortOptimized() {
        reconcile(new GnomeSortOptimized<Integer>());
        reconcileStability(new GnomeSortOptimized<>(comparator));
    }
    
    @Test
    public void testGnomeSortWithInsertion() {
        reconcile(new GnomeSortWithInsertion<Integer>());
        reconcileStability(new GnomeSortWithInsertion<>(comparator));
    }
    
    @Test
    public void testInsertionSort() {
        reconcile(new InsertionSort<Integer>());
        reconcileStability(new InsertionSort<>(comparator));
    }
    
    @Test
    public void testSelectionSort() {
        reconcile(new SelectionSort<Integer>());
        
        /* Selection Sort is not a stable sorting algorithm.
        reconcileStability(new SelectionSort<>(comparator));
        */
    }
    
    @Test
    public void testMergeSort() {
        reconcile(new MergeSort<Integer>());
        reconcileStability(new MergeSort<>(comparator));
    }
    
    private void reconcile(Sort<Integer> sort) {
        int size = 64 * 64 - 1;
        List<Integer> randomNumbers = generateRandomNumbers(size);
        Integer[] array0 = randomNumbers.toArray(new Integer[size]);
        Integer[] array1 = randomNumbers.toArray(new Integer[size]);
        Arrays.sort(array0);
        sort.sort(array1);
        assertThat(array1, is(array0));
    }
    
    private void reconcileStability(Sort<Element> sort) {
        int size = 64 * 64 - 1;
        List<Element> randomElements = generateRandomElements(size);
        Element[] array0 = randomElements.toArray(new Element[size]);
        Element[] array1 = randomElements.toArray(new Element[size]);
        Arrays.sort(array0, comparator);
        sort.sort(array1);
        assertThat(array1, is(array0));
    }
    
    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++)
            randomNumbers.add(random.nextInt(size));
        return randomNumbers;
    }
    
    private List<Element> generateRandomElements(int size) {
        List<Element> randomElements = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++)
            randomElements.add(new Element(random.nextInt(size), i));
        return randomElements;
    }
    
}
