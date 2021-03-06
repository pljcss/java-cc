package com.demo.structuralpattern.staticproxy;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:22 下午
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        teacherDaoProxy.teach();


    }
}
