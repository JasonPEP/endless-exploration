package org.jasonpep.algorithm;

/**
 * description: MiddleNumberProblem
 * date: 2020/2/29 14:56
 * author: JASONPEP
 * version: 1.0
 */
public class MiddleNumberProblem {

    public static void main(String[] args) {
        int[] array = new int[/*Integer.MAX_VALUE / 2*/10000];
        for (int i = 0; i < 10000; i++) {
            array[i] = i;
        }

        int middleNumber = findMiddleNumber(array);
        System.out.println(middleNumber);
    }

    static int findMiddleNumber(int[] array) {

        int middleIndex = array.length / 2;

        for (int i = 0; i < middleIndex; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }

        return array[middleIndex];
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
