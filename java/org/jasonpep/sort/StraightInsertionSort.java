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
        straightInsertionSort.sort1(new int[]{8, 31, 4, 3, 1, 66, 3, 9, 34, 62});
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

    public int[] sort1(int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }
        int temp = array[minIndex];
        array[minIndex] = array[0];
        array[0] = temp;
        // ----------把最小值移到无序表的最左边作为哨兵--------------------


        for (int i = 2; i < array.length; i++) {
            int j = i;
            int temp2 = array[j];
            for (; temp2 < array[j - 1]; j--) {// 这里因为哨兵的作用 少了一个 数组的边界判断
                array[j] = array[j - 1];
            }
            array[j] = temp2;
        }
        return array;
    }
}
