package com.demo.io.character_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 12:09 下午
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        Reader fileReader = new FileReader("tmp/hello.txt");

        // 单个字符读取
        int data;
        while ((data=fileReader.read()) != -1) {
            System.out.println((char) data);
        }

        // 读取多个
        char[] buf = new char[2];
//        char[] buf = new char[1024];
        int count = 0;
        while ((count = fileReader.read(buf)) != -1) {
            System.out.println(new String(buf, 0, count));
        }

        fileReader.close();

    }
}
