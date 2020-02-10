package org.jasonpep.sort;

/**
 * Simple selection sort understanding
 * description: SimpleSelectionSort
 * date: 2020/2/10 15:20
 * author: JASONPEP
 * version: 1.0
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        SimpleSelectionSort selectionSort = new SimpleSelectionSort();
        selectionSort.sort(new int[]{8, 31, 4, 3, 1, 66, 3, 9, 34, 62});
        // console prints below
        // loop count: 45
        // swap count: 7


        // The advantage of simple selection sort is fewer swaps
    }

    public int[] sort(int[] array) {
        // minimum value index
        int minIndex = 0;
        int swapCount = 0;
        int loopCount = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++, loopCount++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // swap
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                swapCount++;
            }
        }
        System.out.printf("loop count: %s \n swap count: %d \n", loopCount, swapCount);
        return array;
    }

}
