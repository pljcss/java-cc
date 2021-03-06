package com.demo.io.character_stream;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 12:30 下午
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("tmp/bw.txt");
        BufferedWriter bw = new BufferedWriter(writer);

        for (int i = 0; i < 5; i++) {
            bw.write("hello 你好可大可久水淀粉");
            bw.newLine();
        }

        bw.flush();

        bw.close();
    }
}
