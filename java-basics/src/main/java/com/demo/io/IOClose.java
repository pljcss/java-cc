package com.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 3:15 下午
 */
public class IOClose {
    public static void main(String[] args) {

    }


    /**
     * 1.7 之前关闭流方法
     */
    public void closeIO() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("tmp/test.txt");
            int read = fis.read();
            System.out.println((char) read);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
