package com.demo.io.byte_stream;

import org.junit.Test;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/2 10:58 上午
 */
public class BufferedInputStreamTest {

    public static void main(String[] args) {

    }

    @Test
    public void buffRead() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("tmp/hello.txt"));

//        int data = 0;
//        while ((data = bis.read()) != -1) {
//            System.out.println((char)data);
//        }


        byte[] buf = new byte[1024];
        int count = 0;
        while ((count=bis.read(buf)) != -1) {
            System.out.println(new String(buf, 0, count));
        }


        bis.close();

    }
}
