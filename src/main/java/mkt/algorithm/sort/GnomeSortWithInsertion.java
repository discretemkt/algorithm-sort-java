package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class GnomeSortWithInsertion<E> extends AbstractSort<E> {
    
    public GnomeSortWithInsertion() {
        super(null);
    }
    
    public GnomeSortWithInsertion(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeGnomeSortWithInsertion(array);
    }
    
    private void executeGnomeSortWithInsertion(E[] array) throws ClassCastException, NullPointerException {
        int pos = 0;
        int next = 1;
        while (pos < array.length - 1) {
            E tmp = array[next];
            while (pos >= 0 && compare(array[pos], tmp) > 0)
                --pos;
            pos++;
            System.arraycopy(array, pos, array, pos + 1, next - pos);
            array[pos] = tmp;
            pos = next;
            next++;
        }
    }
    
}
