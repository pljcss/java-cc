package com.demo.structuralpattern.staticproxy;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:14 下午
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("授课中。。。。");
    }
}
