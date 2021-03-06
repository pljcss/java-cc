package com.demo.io.character_stream;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 12:43 下午
 */
public class PrintWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("tmp/pw.txt");

        printWriter.println(98);
        printWriter.println(true);
        printWriter.println("hello world");
        printWriter.println("张飞");

        printWriter.flush();
        printWriter.close();
    }
}
