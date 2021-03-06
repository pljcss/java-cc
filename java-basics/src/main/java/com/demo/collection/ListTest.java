package com.demo.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 9:29 下午
 */
public class ListTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");

//        Iterator<String> iterator = list.iterator();

//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(s);
//        }

        // 从前往后遍历
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            System.out.println(next);
        }

        // 从后往前遍历
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.println(previous);
        }
    }
}
