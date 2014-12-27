package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
abstract class AbstractSort<E> implements Sort<E> {
    
    private final Comparator<? super E> comparator;
    
    protected AbstractSort(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }
    
    @SuppressWarnings("unchecked")
    protected int compare(E e0, E e1) throws ClassCastException, NullPointerException {
        if (comparator != null)
            return comparator.compare(e0, e1);
        return ((Comparable<? super E>) e0).compareTo(e1);
    }
    
}
