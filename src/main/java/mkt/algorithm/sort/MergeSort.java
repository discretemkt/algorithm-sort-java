package mkt.algorithm.sort;

import java.util.Comparator;

/**
 * @param <E>
 * @since 0.0.1
 * @author mkt
 */
public class MergeSort<E> extends AbstractSort<E> {
    
    public MergeSort() {
        super(null);
    }
    
    public MergeSort(Comparator<? super E> comparator) {
        super(comparator);
    }
    
    @Override
    public void sort(E[] array) throws ClassCastException, NullPointerException {
        if (array.length < 2)
            return;
        executeMergeSort(array, 0, array.length);
    }
    
    private void executeMergeSort(E[] array, int begin, int end) throws ClassCastException, NullPointerException {
        int len = end - begin;
        if (len < 2)
            return;
        int mid = begin + len / 2;
        executeMergeSort(array, begin, mid);
        executeMergeSort(array, mid, end);
        @SuppressWarnings("unchecked")
        E[] merge = (E[]) new Object[len];
        int i = begin;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (compare(array[i], array[j]) <= 0) {
                merge[k] = array[i];
                i++;
            } else {
                merge[k] = array[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            merge[k] = array[i];
            i++;
            k++;
        }
        while (j < end) {
            merge[k] = array[j];
            j++;
            k++;
        }
        System.arraycopy(merge, 0, array, begin, len);
    }
    
}
