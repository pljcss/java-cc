package com.demo.io.conversion_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 1:46 下午
 */
public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {

        // 创建 OutputStreamWriter 对象
        FileOutputStream fos = new FileOutputStream("tmp/osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        for (int i = 0; i < 5; i++) {
            osw.write("北上广深");
        }

        // flush
        osw.flush();
        // 关闭
        osw.close();
    }
}
