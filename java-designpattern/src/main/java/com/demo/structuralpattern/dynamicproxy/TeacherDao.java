package com.demo.structuralpattern.dynamicproxy;

/**
 * @Author: cs
 * @Date: 2021/1/28 3:23 下午
 * @Desc:
 */
public class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("授课中.....");
    }
}
