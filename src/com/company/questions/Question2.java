package com.company.questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Question2 {

    /*
    A palindromic number reads the same both ways. The largest palindrome made
    from the product of two 2-digit numbers is 9009 = 91 × 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
     */
    public void palindrome() {

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < 1000000; i ++) {
            int p1 = ThreadLocalRandom.current().nextInt(100, 999);
            int p2 = ThreadLocalRandom.current().nextInt(100, 999);

            System.out.println("Factors: " + p1 + "  " + p2);

            int product = p1 * p2;

            if (isPalindrome(product)) {
                System.out.println("Found it -- > " + product);
                resultList.add(product);
            }
        }
        System.out.println(resultList.stream().max(Comparator.comparingInt(Integer::intValue)));
    }

    private boolean isPalindrome(int numberToCheck) {

        String numString = String.valueOf(numberToCheck);
        return numString.equals(new StringBuilder(numString).reverse().toString());
    }
}
