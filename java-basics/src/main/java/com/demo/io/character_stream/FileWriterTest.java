package com.demo.io.character_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 12:16 下午
 */
public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("tmp/file_write.txt");

        for (int i = 0; i < 5; i++) {
            fileWriter.write("Java 好好好");
        }

        fileWriter.close();

    }
}
