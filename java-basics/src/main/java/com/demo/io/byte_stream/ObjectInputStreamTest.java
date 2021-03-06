package com.demo.io.byte_stream;

import java.io.*;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:39 上午
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("tmp/stu.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // 反序列化(读入操作)
        Student stu = (Student)ois.readObject();

        System.out.println(stu);

        ois.close();


    }
}
