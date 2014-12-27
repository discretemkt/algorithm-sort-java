package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class InsertionSort<E> extends AbstractSort<E> {
    
    public InsertionSort() {
        super(null);
    }
    
    public InsertionSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeSelectionSort(array);
    }
    
    private void executeSelectionSort(E[] array) throws ClassCastException, NullPointerException {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(array[j], array[i]) > 0) {
                    E tmp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = tmp;
                    break;
                }
            }
        }
    }
    
}
