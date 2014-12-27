package mkt.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @since 0.0.1
 * @author mkt
 */
public class BenchmarkTest {
    
    public static void main(String... args) {
        testFasterAlgorithms();
        testSlowerAlgorithms();
    }
    
    private static void testFasterAlgorithms() { // O(n log n)
        int size = 1024 * 1024 - 1;
        List<Integer> randomNumbers = generateRandomNumbers(size);
        System.out.printf("Benchmark of faster algorithms with %,d samples\n", size);
        execute(randomNumbers.toArray(new Integer[size]));
        execute(new CombSort<Integer>(), randomNumbers.toArray(new Integer[size]));
        execute(new MergeSort<Integer>(), randomNumbers.toArray(new Integer[size]));
    }
    
    private static void testSlowerAlgorithms() { // O(n pow 2)
        int size = 128 * 128 - 1;
        List<Integer> randomNumbers = generateRandomNumbers(size);
        System.out.printf("Benchmark of slower algorithms with %,d samples\n", size);
        execute(new BubbleSort<Integer>(), randomNumbers.toArray(new Integer[size]));
        execute(new InsertionSort<Integer>(), randomNumbers.toArray(new Integer[size]));
        execute(new SelectionSort<Integer>(), randomNumbers.toArray(new Integer[size]));
    }
    
    private static List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++)
            randomNumbers.add(random.nextInt(size));
        return randomNumbers;
    }
    
    private static void execute(Integer[] randomNumbers) {
        System.out.printf("  %s ... ", Arrays.class.getName());
        long t0 = System.currentTimeMillis();
        Arrays.sort(randomNumbers);
        long t1 = System.currentTimeMillis();
        System.out.printf("%,d msec\n", t1 - t0);
    }
    
    private static void execute(Sort<Integer> sort, Integer[] randomNumbers) {
        System.out.printf("  %s ... ", sort.getClass().getName());
        long t0 = System.currentTimeMillis();
        sort.sort(randomNumbers);
        long t1 = System.currentTimeMillis();
        System.out.printf("%,d msec\n", t1 - t0);
    }
    
}
