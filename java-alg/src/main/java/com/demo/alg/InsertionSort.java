package com.demo.alg;

/**
 * @author cs
 * @version 1.0
 * @date 2019/11/7 10:31 下午
 *
 * 插入排序
 */
public class InsertionSort {

    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {return;}

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;

            // 查找插入的位置
            for (; j >= 0; --j) {
                System.out.println(j);
                if (a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
                System.out.println("&&&&  " + a[j]);
            }

            System.out.println("--------   " + j);
            a[j+1] = value;
        }

        for (int i=0; i<n; i++) {
            System.out.print(a[i]);
        }
    }

    // 5, 4
    public static void main(String[] args) {
        insertionSort(new int[]{4, 5, 6, 1, 3, 2}, 6);
    }
}
