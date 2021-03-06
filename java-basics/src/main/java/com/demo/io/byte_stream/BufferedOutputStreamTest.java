package com.demo.io.byte_stream;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 10:48 上午
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        // 创建字节输出缓冲流
        OutputStream fos = new FileOutputStream("tmp/hello2.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 写入文件
        for (int i = 0; i < 10; i++) {
            bos.write("hello world".getBytes());
        }

        // 刷新
        bos.flush();

        // 关闭
        bos.close();

    }
}
