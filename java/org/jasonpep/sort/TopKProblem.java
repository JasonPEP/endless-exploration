package org.jasonpep.sort;

/**
 * description: TopKProblem
 * date: 2020/2/29 00:48
 * author: JASONPEP
 * version: 1.0
 */
public class TopKProblem {

    public static void main(String[] args) {
        int[] array = new int[Integer.MAX_VALUE / 2];
        for (int i = 0; i < Integer.MAX_VALUE / 2; i++) {
            array[i] = i;
        }

        bobbleSolve(array, 5);

    }

    /**
     * Using Bobble sort to solve
     * the time complexity is O(k*n)
     *
     * @param array 待排序数组
     * @param k     top值
     */
    public static void bobbleSolve(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[i]) {
                    swap(array, j, i);
                }
            }
        }
    }


    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
