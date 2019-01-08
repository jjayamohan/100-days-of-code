package com.jay.math;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("99")));
    }

    private static BigInteger factorial (BigInteger n) {

        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}
