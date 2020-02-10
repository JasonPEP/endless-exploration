package org.jasonpep.sort;

/**
 * Understanding straight insertion sort
 * description: StraightInsertionSort
 * date: 2020/2/10 15:42
 * author: JASONPEP
 * version: 1.0
 */
public class StraightInsertionSort {

    public static void main(String[] args) {
        StraightInsertionSort straightInsertionSort = new StraightInsertionSort();
        straightInsertionSort.sort(new int[]{8, 31, 4, 3, 1, 66, 3, 9, 34, 62});
    }

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int temp = array[j];
            for (; j > 0 && temp < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }
}
