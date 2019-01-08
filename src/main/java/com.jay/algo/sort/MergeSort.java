package com.jay.algo.sort;

public class MergeSort {


    public static void main(String[] args) {

        //int[] a = {1,95, 9, 2, 3, 5};
        int[] a = { 8, 5, 9, 1, 6, 3, 4 };

        mergeSort(a);
        for (int each : a) {
            System.out.print(each + " ");
        }
    }

    /**
     *
     * Main is merging two list by comparing.
     *
     * Divide the given list to two different list using recursive till the
     * list size is 1.
     *
     * Then do merging one after one
     *
     * Reference - https://www.baeldung.com/java-merge-sort
     *
     * Time complexity o(n LOG n)
     * Space complexit O(n)
     *
     * @param input
     */
    private static void mergeSort(int[] input) {

        if (input.length < 2)
            return;

        int mid = (input.length + 1)/ 2;

        int[] leftarr = new int[mid];
        int[] rightarr = new int[input.length - mid];

        for (int i = 0; i < mid; i++) {
            leftarr[i] = input[i];
        }

        for (int i = mid; i < input.length; i++) {
            rightarr[i - mid] = input[i];
        }

        mergeSort(leftarr);
        mergeSort(rightarr);
        merge(input, leftarr, rightarr);

    }

    private static void merge(int[] input, int[] leftarr, int[] rightarr) {

        int i = 0; int j = 0; int k =0;
        int larraySize = leftarr.length;
        int rarraySize = rightarr.length;

        while (i < larraySize && j < rarraySize) {
            if (leftarr[i] <= rightarr[j]) {
                input[k++] = leftarr[i++];
            } else {
                input[k++] = rightarr[j++];
            }
        }

        while (i < larraySize)
            input[k++] = leftarr[i++];

        while (j < rarraySize)
            input[k++] = rightarr[j++];
    }
}
