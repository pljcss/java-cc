package com.demo.structuralpattern.staticproxy;

/**
 * @author cs
 * @version 1.0
 * @date 2020/10/12 11:15 下午
 *
 * 代理对象 静态代理
 */
public class TeacherDaoProxy implements ITeacherDao {
    /**
     * 目标对象，通过接口来聚合
     */
    private ITeacherDao target;


    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理。。。");
        target.teach();
        System.out.println("提交。。。");
    }
}
