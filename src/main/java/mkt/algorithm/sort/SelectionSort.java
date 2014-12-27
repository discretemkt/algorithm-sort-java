package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class SelectionSort<E> extends AbstractSort<E> {
    
    public SelectionSort() {
        super(null);
    }
    
    public SelectionSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeSelectionSort(array);
    }
    
    private void executeSelectionSort(E[] array) throws ClassCastException, NullPointerException {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (compare(array[min], array[j]) > 0)
                    min = j;
            if (min > i) {
                E tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }
    
}
