package org.jasonpep.sort;

/**
 * description: FastSort 快速排序
 * date: 2020/2/21 21:53
 * author: JASONPEP
 * version: 1.0
 */
public class FastSort {

    public static void main(String[] args) {
        int arrayLength = Integer.MAX_VALUE >> 20;
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = -i;
        }
        quickSort(array, 0, array.length - 1);
        System.out.println(1);
    }

    static void quickSort(int[] array, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        // set a base number
        int p = array[lo];
        int i = lo;
        int j = hi;
        while (i != j) {
            while (array[j] >= p && i < j) {
                j--;
            }
            while (array[i] <= p && i < j) {
                i++;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }
        array[lo] = array[i];
        array[i] = p;
        quickSort(array, lo, i - 1);
        quickSort(array, i + 1, hi);
    }

    static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
