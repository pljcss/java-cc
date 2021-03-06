package com.demo.enum1;

/**
 * 枚举
 * 注意
 *   1）枚举中必须包含枚举常量，也可以包含属性，方法，私有构造方法
 *   2）枚举常量必须写在前面，多个常量之间使用逗号隔开，最后分号可写可不写
 *
 * @author cs
 * @version 1.0
 * @date 2020/10/13 4:53 下午
 */
public enum Gender {
    /**
     *
     */
    FEMALE, MALE;

    private String name;

    private Gender() {}

    public static void test1() {

    }
}
