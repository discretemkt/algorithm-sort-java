package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class GnomeSort<E> extends AbstractSort<E> {
    
    public GnomeSort() {
        super(null);
    }
    
    public GnomeSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeGnomeSort(array);
    }
    
    private void executeGnomeSort(E[] array) throws ClassCastException, NullPointerException {
        int pos = 0;
        while (pos < array.length - 1) {
            if (compare(array[pos], array[pos + 1]) > 0) {
                E tmp = array[pos];
                array[pos] = array[pos + 1];
                array[pos + 1] = tmp;
                if (pos == 0)
                    pos++;
                else
                    --pos;
            } else {
                pos++;
            }
        }
    }
    
}
