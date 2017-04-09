package com.huangjifeng.java;

/**
 * 饿汉式
 */

public class Student {
    private static final Student student = new Student();

    private Student() {
    }

    public static Student getInstance() {
        return student;
    }
}
