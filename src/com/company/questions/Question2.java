package com.company.questions;

import java.util.*;
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

    /*
    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    public void noRemainder() {
        long startTime = System.currentTimeMillis();
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> resultList = new ArrayList<>();
        int i = 1;
        while ((System.currentTimeMillis() - startTime) < 3000000) {
            int finalI = i;
            if (numList.stream().allMatch(num -> finalI % num == 0)) {
                resultList.add(i);
                break;
            }
            i++;
        }

        System.out.println(resultList.get(0));
    }
}
