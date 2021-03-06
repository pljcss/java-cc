package com.demo.io.byte_stream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/2 10:36 上午
 */
public class FileOutputStreamTest {

    @Test
    public void writeToFile() throws IOException {
        OutputStream fos = new FileOutputStream("tmp/write_log.txt");

        fos.write('h');
        // 写的是该ascii码对应的字符
        fos.write(123);
        fos.write(45);

        fos.close();
    }

    @Test
    public void writeToFile2() throws IOException {
        // 为 true 表示以追加方式写入
        OutputStream fos = new FileOutputStream("tmp/write_log2.txt", true);

        String str = "hello world";
        // 写一个字节数组
        fos.write(str.getBytes());

        fos.close();
    }
}
