package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class CombSort<E> extends AbstractSort<E> {
    
    public CombSort() {
        super(null);
    }
    
    public CombSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeCombSort(array);
    }
    
    private void executeCombSort(E[] array) throws ClassCastException, NullPointerException {
        int gap = array.length;
        boolean swapped;
        do {
            gap = gap == 1 ? 1 : gap * 10 / 13;
            swapped = false;
            for (int i = 0; i + gap < array.length; i++) {
                if (compare(array[i], array[i + gap]) > 0) {
                    E tmp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = tmp;
                    swapped = true;
                }
            }
        } while (swapped || 1 < gap);
    }
    
}
