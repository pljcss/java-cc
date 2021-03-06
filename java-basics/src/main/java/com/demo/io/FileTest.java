package com.demo.io;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Properties;

/**
 * 1）文件分隔符
 * 2）文件操作
 * 3）文件夹操作
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/2 4:04 下午
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("tmp/test.txt");
        file.createNewFile();
        System.out.println(file.exists());
    }

    /**
     * 1）分隔符
     */
    @Test
    public void separate() {
        System.out.println("路径分隔符   " + File.pathSeparator);
        System.out.println("名称分隔符   " + File.separator);
    }

    /**
     * 2）文件操作
     */
    @Test
    public void fileOp() throws IOException {
        // 1）创建文件
        File file = new File("tmp/testfile.txt");
        System.out.println(file.toString());
        // 判断文件是否存在
        System.out.println(file.exists());
        boolean create = file.createNewFile();
        System.out.println("创建结果：" + create);


        // 2）删除文件
        // 2.1 直接删除
        boolean delete = file.delete();
        System.out.println("删除结果：" + delete);

        // 2.2 使用JVM删除（当JVM退出时自动删除）
        file.deleteOnExit();

        // 3）获取文件信息
        System.out.println("获取文件绝对路径：" + file.getAbsolutePath());
        System.out.println("获取路径：" + file.getPath());
        System.out.println("获取文件名称：" + file.getName());

        // 4）判断
        System.out.println("文件是否可写：" + file.canRead());
        System.out.println("是否是文件：" + file.isFile());

    }

    /**
     * 文件夹操作
     */
    @Test
    public void directoryOp() {
        // 1、创建文件夹
        File dir = new File("tmp/test");
        if (!dir.exists()) {
//            dir.mkdir(); // 只能创建单级目录
            dir.mkdirs(); // 创建多级目录
        }

        // 2、删除文件夹
        // 2.1 直接删除（注意：只能删除空目录，如果非空需要递归删除）
        System.out.println("删除结果：" + dir.delete());

        // 2.2 JVM删除
        dir.deleteOnExit();

        // 获取文件夹信息
        System.out.println("获取文件夹绝对路径：" + dir.getAbsolutePath());
        System.out.println("获取文件夹路径：" + dir.getPath());
        System.out.println("获取文件夹名称：" + dir.getName());

        // 判断
        System.out.println("判断是否是文件夹：" + dir.isDirectory());
        System.out.println("判断是否是隐藏文件夹：" + dir.isHidden());

        // 遍历文件夹
        dir.list(); // TODO

    }

    /**
     * FileFilter 过滤文件
     */
    @Test
    public void fileFilterOp() {
        // 1、创建文件夹
        File dir = new File("tmp");

        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getName().endsWith("jpg")) {
                    return true;
                }
                return false;
            }
        });

        for (File file : files) {
            System.out.println(file);
        }

    }


}
