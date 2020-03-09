package org.jasonpep.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * description: FizzBuzz
 * date: 2020/3/9 14:59
 * author: JASONPEP
 * version: 1.0
 */
public class FizzBuzz {


    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        for (int i = 1; i <= n; i++) {
            if (i % 5 != 0) {
                if (i % 3 != 0) {
                    System.out.println(i);
                } else {
                    System.out.println("Fizz");
                }
            } else {
                if (i % 3 != 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println("FizzBuzz");
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        FizzBuzz.fizzBuzz(n);

        bufferedReader.close();
    }
}