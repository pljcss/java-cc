package com.demo.alg;

/**
 * @author cs
 * @version 1.0
 * @date 2019/11/7 2:32 下午
 *
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] array = {4, 5, 6, 3, 2, 1};
//        bubbleSort(array, array.length);

        int j = 3;
        for (; j>0; j--) {
            System.out.println(j);
        }

    }


    public static void bubbleSort(int[] array, int length) {
//        a = new int[]{4, 5, 6, 3, 2, 1};
//        n = a.length;

        if (array.length == 1) {
            System.out.println("无序排序");
        }


        for (int i = 0; i<length; i++) {
            boolean flag = false;
            for (int j = 0; j< length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }

            if (!flag) {
                System.out.println(!flag);
                break;
            }
        }

        for (int i=0; i<length; i++) {
            System.out.print(array[i]);
        }

    }
}
