package com.demo.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器
 * @author cs
 * @version 1.0
 * @date 2020/10/13 2:55 下午
 */
public class ClassLoaderTest {

    /**
     * 不同类型的类加载器
     */
    @Test
    public void classLoader() {
        // 对于自定义类，使用的是系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // AppClassLoader 即系统类加载器
        System.out.println(classLoader);

        // 调用系统类加载器的 getParent()，获取拓展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        // 调用拓展类加载器的 getParent()，无法获取引导类加载器
        // 引导类加载器主要负责加载java的核心类库，无法加载自定义的类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        // String类就是引导类加载器加载的，无法获取到 null
        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /**
     * 使用 ClassLoader 读取配置文件
     * @throws IOException
     */
    @Test
    public void loadConfig() throws IOException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 方式1 使用类加载器加载配置文件
        // 配置文件默认识别当前module下src
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");

        // 方式2 使用 FileInputStream读取

        Properties properties = new Properties();
        properties.load(resourceAsStream);

        System.out.println(properties);
    }
}
