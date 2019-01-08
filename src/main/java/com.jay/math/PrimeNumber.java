package com.jay.math;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrime(13));
        System.out.println(isPrime(4));
        printAllPrime(100);
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    private static void printAllPrime (int max) {

        for (int i = 2; i <max; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }
}
