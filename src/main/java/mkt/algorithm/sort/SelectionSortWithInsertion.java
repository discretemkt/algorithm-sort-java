package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class SelectionSortWithInsertion<E> extends AbstractSort<E> {
    
    public SelectionSortWithInsertion() {
        super(null);
    }
    
    public SelectionSortWithInsertion(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeSelectionSortWithInsertion(array);
    }
    
    private void executeSelectionSortWithInsertion(E[] array) throws ClassCastException, NullPointerException {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++)
                if (compare(array[min], array[j]) > 0)
                    min = j;
            if (min > i) {
                E tmp = array[min];
                System.arraycopy(array, i, array, i + 1, min - i);
                array[i] = tmp;
            }
        }
    }
    
}
