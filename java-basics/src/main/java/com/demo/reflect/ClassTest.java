package com.demo.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/13 9:49 上午
 */
public class ClassTest {
    public static void main(String[] args) {

    }

    /**
     * 获取类对象的四种方式
     * @throws ClassNotFoundException
     */
    @Test
    public void getClassObj() throws ClassNotFoundException {
        // 1、通过对象获取
        ClassTest classTest = new ClassTest();
        Class<? extends ClassTest> class1 = classTest.getClass();
        System.out.println(class1);
        System.out.println(class1.hashCode());

        // 2、通过类获取
        Class<ClassTest> class2 = ClassTest.class;
        System.out.println(class2);
        System.out.println(class2.hashCode());

        // 3、通过Class.forName获取（推荐使用，依赖性小）
        Class<?> class3 = Class.forName("com.demo.reflect.ClassTest");
        System.out.println(class3);
        System.out.println(class3.hashCode());

        // 4、通过ClassLoader（了解）
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class<?> class4 = classLoader.loadClass("com.demo.reflect.ClassTest");
        System.out.println(class4);
        System.out.println(class4.hashCode());
    }

    /**
     * 通过反射获取类名、包名、父类、接口
     * @throws ClassNotFoundException
     */
    @Test
    public void reflectOp() throws ClassNotFoundException {
        Class<?> person = Class.forName("com.demo.reflect.Person");
        // 获取类名
        System.out.println(person.getName());
        // 获取包名
        System.out.println(person.getPackage());
        // 获取父类
        System.out.println(person.getSuperclass().getName());
        Class<?>[] interfaces = person.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
    }

    /**
     * 使用反射获取类的构造方法，并创建对象
     * @throws ClassNotFoundException
     */
    @Test
    public void reflectOp2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> person = Class.forName("com.demo.reflect.Person");

        // 获取所有构造方法
        Constructor<?>[] constructors = person.getConstructors();
        System.out.println(Arrays.toString(constructors));

        // 获取单个无参构造方法，并创建对象（获取无参数构造方法）
        Constructor<?> constructor = person.getConstructor();
        Person o = (Person) constructor.newInstance();
        System.out.println(o);

        // 简便方法（不需要通过构造方法创建对象）
        Person o1 = (Person) person.newInstance();
        System.out.println(o1);

        // 获取类中的带参构造方法
        Constructor<?> constructor1 = person.getConstructor(String.class, int.class);
        Person o2 = (Person) constructor1.newInstance("张三", 22);
        System.out.println(o2);


    }

    /**
     * 使用反射获取类中的方法，并调用方法
     * @throws ClassNotFoundException
     */
    @Test
    public void reflectOp3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> person = Class.forName("com.demo.reflect.Person");

        // getMethods() 获取公开的方法，包括从父类继承的方法（不能获取私有的方法）
        Method[] methods = person.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        // getDeclaredMethods() 获取类中的所有方法，包括私有、默认、保护，但不包含继承方法
        Method[] declaredMethods = person.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        // 获取单个方法
        // 填写方法名
        Method sayHelloMethod = person.getMethod("sayHello");
        // 创建对象
        Person trump = (Person) person.newInstance();
        // 调用方法，并填入对象
        sayHelloMethod.invoke(trump);

        // 获取带参数方法
        Method eatFoodMethod = person.getMethod("eatFood", String.class);
        eatFoodMethod.invoke(trump, "鸡腿");

        // 获取私有方法
        Method privateMethod = person.getDeclaredMethod("privateMethod");
        // 设置访问权限无效
        privateMethod.setAccessible(true);
        privateMethod.invoke(trump);

        // 获取静态方法
        Method staticMethod = person.getMethod("staticMethod");
        // 静态方法不需要传入对象（类名.的方式调用）
        staticMethod.invoke(null);
    }

    /**
     * 使用反射获取类中的属性
     * @throws ClassNotFoundException
     */
    @Test
    public void reflectOp4() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        // 获取类对象
        Class<?> person = Class.forName("com.demo.reflect.Person");

        // 获取多个属性（只能拿到公开的和父类继承的属性）
        Field[] fields = person.getFields();
        System.out.println(Arrays.toString(fields));

        // 获取多个属性（私有属性）
        Field[] declaredFields = person.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // 获取单个属性
        Field name = person.getDeclaredField("name");
        // 访问私有属性，应设置访问权限
        name.setAccessible(true);
        Person trump = (Person) person.newInstance();
        name.set(trump, "zhangsan");

        System.out.println(name.get(trump));
    }
}
