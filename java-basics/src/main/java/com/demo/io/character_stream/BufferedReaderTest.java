package com.demo.io.character_stream;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 12:30 下午
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        // 创建缓冲流
        FileReader fileReader = new FileReader("tmp/file_write.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // 第一种读取方式
//        char[] buf = new char[1024];
//        int count = 0;
//        while ((count = bufferedReader.read(buf)) != -1) {
//            System.out.println(new String(buf, 0, count));
//        }

        // 按行读取
        String line;
        while ((line=bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();

    }
}
