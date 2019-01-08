package com.jay.algo.sort;

public class InsertionSort {
    public static void main(String[] args) {

        int[] a = {1,95, 9, 2, 3};
        int[] result = insertionSort(a);
        for (int each : result) {
            System.out.print(each + " ");
        }

    }

    /**
     * Consider Insertion sort as a sorting a pack of card which are upside down.
     * - First take the second card and compare with the first value
     * - If less put the card before the first card.
     * - Now take the third card compare it with the second card and if lesser compare with first card if more insert
     *   between first and second card.
     * - Continue the same with 4th card and till N
     *
     * Refer - https://www.youtube.com/watch?v=BO145HIUHRg
     *
     * @param input
     * @return
     */
    private static int[] insertionSort(int[] input) {

        String s;

        for (int i = 1; i <= input.length - 1; i++) {

            int currentValue = input[i];
            int previousIndex = i - 1;

            while (i > 0 && currentValue < input[previousIndex]) {
                input[previousIndex + 1] = input[previousIndex];
                previousIndex--;
            }

            input[previousIndex + 1] = currentValue;
        }

        return input;
    }

}
