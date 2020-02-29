package org.jasonpep.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * description: FullPermutation 全排序
 * date: 2020/2/21 21:20
 * author: JASONPEP
 * version: 1.0
 */
public class FullPermutation {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
    }

    /**
     * 打印全排序
     *
     * @param elements 元素集合
     */
    private static List<String> solution(int[] elements) {
        List<String> result = new LinkedList<>();

        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j < elements.length; j++) {
                swap(elements, i, j);
            }
        }

        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        System.out.println(Arrays.toString(arr));
    }
}
