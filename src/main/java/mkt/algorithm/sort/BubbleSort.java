package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class BubbleSort<E> extends AbstractSort<E> {
    
    public BubbleSort() {
        super(null);
    }
    
    public BubbleSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeBubbleSort(array);
    }
    
    private void executeBubbleSort(E[] array) throws ClassCastException, NullPointerException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; --j) {
                if (compare(array[j - 1], array[j]) > 0) {
                    E tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }
    
}
