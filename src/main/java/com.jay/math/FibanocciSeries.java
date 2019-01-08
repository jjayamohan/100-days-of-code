package com.jay.math;

import java.util.HashMap;
import java.util.Map;

public class FibanocciSeries {


    public static void main(String[] args) {

        System.out.println("Fibonacci recursive");
        for (int i = 1; i < 10; i++)
            System.out.print(fibanocciRecursive(i) + " ");

        System.out.println("\nFibonacci dynamic recursive");
        for (int i = 1; i < 10; i++)
            System.out.print(fibanocciDynamicResursive(i, new HashMap<>()) + " ");
    }


    /**
     * Top down solution
     * @param n
     * @return
     */
    private static int fibanocciRecursive (int n) {
        if (n <= 1)
            return n;
        return fibanocciRecursive(n - 1) + fibanocciRecursive(n-2);
    }

    /**
     * Memoized Solution. Store the intermediate solutions
     */
    private static int fibanocciDynamicResursive (int n, Map<Integer, Integer> cache) {

        if (cache.get(n) != null)
            return cache.get(n);

        if (n <= 1)
            return n;

        int result = fibanocciDynamicResursive(n-1, cache) + fibanocciDynamicResursive(n-2, cache);
        cache.put(n, result);

        return result;
    }
}
