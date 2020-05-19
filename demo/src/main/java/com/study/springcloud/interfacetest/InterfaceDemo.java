package com.study.springcloud.interfacetest;

@FunctionalInterface
public interface InterfaceDemo {

    public Integer doRe(Integer a,Integer b);

    public static Integer doAdd(Integer a,Integer b) {
        return a +b;
    }
}
