package com.demo.io.conversion_stream;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 1:41 下午
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {

        // 创建 InputStreamReader 对象
        InputStream fis = new FileInputStream("tmp/bw.txt");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");

        // 读取文件
        int data = 0;
        while ((data=isr.read()) != -1) {
            System.out.println((char) data);
        }

        // 关闭
        isr.close();

    }
}
