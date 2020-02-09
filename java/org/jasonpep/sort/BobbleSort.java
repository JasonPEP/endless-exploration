package org.jasonpep.sort;

/**
 * Bobble Sort Understanding
 * description: BobbleSort
 * date: 2020/2/9 13:51
 * author: JASONPEP
 * version: 1.0
 */
public class BobbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{9, 2, 1, 3, 4, 8, 7, 6};
        BobbleSort bobbleSort = new BobbleSort();
        printArray(bobbleSort.sort1(array.clone()));
        printArray(bobbleSort.sort2(array.clone()));
        printArray(bobbleSort.sort3(array.clone()));
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    /**
     * Swap value
     *
     * @param array  array
     * @param indexX first index
     * @param indexY second index
     */
    public void swap(int[] array, int indexX, int indexY) {
        int tempX = array[indexX];
        array[indexX] = array[indexY];
        array[indexY] = tempX;
    }

    /**
     * easy to sort a array by compare and wap
     *
     * @param array origin array
     * @return sorted array
     */
    public int[] sort1(int[] array) {
        int loopCounts = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++, loopCounts++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
//        System.out.printf("sort1 loop counts: %d \n", loopCounts);
        return array;
    }

    /**
     * optimize sort1 to bobble sort
     *
     * @param array origin array
     * @return sorted array
     */
    public int[] sort2(int[] array) {
        int loopCounts = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 2; j > i; j--, loopCounts++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
//        System.out.printf("sort2 loop counts: %d \n", loopCounts);
        return array;
    }

    /**
     * optimize sort2 clean useless loop
     *
     * @param array origin array
     * @return sorted array
     */
    public int[] sort3(int[] array) {
        int loopCounts = 0;
        boolean flag = true;
        for (int i = 0; i < array.length && flag; i++) {
            flag = false;
            for (int j = array.length - 2; j > i; j--, loopCounts++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
        }
//        System.out.printf("sort3 loop counts: %d \n", loopCounts);
        return array;
    }
}
