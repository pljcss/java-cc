package com.demo.io.byte_stream;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:35 上午
 */
public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {

        OutputStream fos = new FileOutputStream("tmp/stu.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 反序列化（写出操作）
        oos.writeObject(new Student("张三", 22));

        oos.close();

    }
}
