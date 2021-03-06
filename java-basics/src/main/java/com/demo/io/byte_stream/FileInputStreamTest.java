package com.demo.io.byte_stream;


import org.junit.Test;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/1 9:26 上午
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        // 实现图片拷贝
        FileInputStream fis = new FileInputStream("tmp/world_map.jpg");
        FileOutputStream fos = new FileOutputStream("tmp/copy_world_map.jpg");

        byte[] buff = new byte[1024];
        // 读取缓存的个数
        int count = 0;
        while ((count = fis.read(buff)) != -1) {
            // 到最后可能读取的不是1024个字节，因此需要指定每次写的数据的偏移量和数据长度
            fos.write(buff, 0 ,count);
        }

        // 关系
        fis.close();
        fos.close();

    }

    @Test
    public void readFromFile1() throws IOException {
        FileInputStream fis = new FileInputStream("tmp/hello.txt");

        // 读取一个字节
        int data = 0;
        while ((data = fis.read()) != -1) {
            System.out.println((char)data);
        }

        fis.close();
    }

    @Test
    public void readFromFile2() throws IOException {
        FileInputStream fis = new FileInputStream("tmp/hello.txt");

        // 读取多个字节
        byte[] buff = new byte[1024];
        int count = 0;
        while ((count=fis.read(buff)) != -1) {
            System.out.println(new String(buff));
        }

        // 关闭
        fis.close();
    }

}
