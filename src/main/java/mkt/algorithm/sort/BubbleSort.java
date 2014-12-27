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
        int last = array.length - 1;
        while (0 < last) {
            for (int i = 0; i < last; i++) {
                if (compare(array[i], array[i + 1]) > 0) {
                    E tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            --last;
        }
    }
    
}
