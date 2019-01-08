package com.jay.algo.sort;

public class QuickSort {

    public static void main(String[] args) {

        int[] a = {1, 95, 9, 2, 3, 5};

        quickSort(a, 0, a.length);

        for (int each : a) {
            System.out.print(each + " ");
        }
    }

    /**
     * Works on Partition algorithm
     *
     * Partition algorithm
     *  - take any number in the array. Say we take the last element. lets call it as S
     *  - Loop the array and compare it with the value we took, i.e S
     *  - If the element in the loop is less than the S. Swap it before the pivot
     *  - At the end of the partition the element we took that is S will be in a place where
     *    all the elements less than S will be in the left side of S. And all the element greater
     *    than S will be in right side of the array
     *
     * Reference - https://www.youtube.com/watch?v=3DV8GO9g7B4
     *
     * @param
     * @param
     */

    private static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int q = partition(a, l, r);
            quickSort(a, l, q - 1);
            quickSort(a, q + 1, r);
        }

    }

    private static int partition(int[] input, int l, int r) {

        int lastElement = input[r];
        int i = l - 1;

        for (int j = l; j < r - 1; j ++) {
            if(lastElement <= input[l]) {
                input[i++] = input[j];
            }
        }

        input[i+1] = lastElement;

        return i + 1;
    }
}
