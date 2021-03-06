package com.demo.alg;

/**
 * @author cs
 * @version 1.0
 * @date 2019/11/9 9:38 上午
 *
 * 合并两个有序数组
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] array1 = {5, 11, 22};
        int[] array2 = {3, 8, 12};
        sortTwoArray(array1, array2);
    }


    public static void sortTwoArray(int[] array1, int[] array2) {
        int left1 = 0;
        int left2 = 0;

        int[] tmpArrays = new int[array1.length + array2.length];

        int leftTmp = 0;

        while (left1 < array1.length && left2 < array2.length) {
            if (array1[left1] < array2[left2]) {
                tmpArrays[leftTmp] = array1[left1];
                ++left1;
                ++leftTmp;
            } else if (array1[left1] > array2[left2]) {
                tmpArrays[leftTmp] = array2[left1];
                ++left2;
                ++leftTmp;

                if (left2 == array2.length) {
                    tmpArrays[leftTmp] = array1[left1];
                    ++left1;
                    ++leftTmp;
                }
            }
        }

        print(tmpArrays);
    }

    public static void print(int[] data) {
        for (int i=0; i<data.length; ++i) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}
