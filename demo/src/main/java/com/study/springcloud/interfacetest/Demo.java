package com.study.springcloud.interfacetest;

public class Demo {

    public static void main(String[] args) {
        InterfaceDemo demo = new InterfaceDemo() {
            @Override
            public Integer doRe(Integer a, Integer b) {
                return a + b;
            }
        };

        System.out.println(demo.doRe(1 , 2));

        System.out.println(InterfaceDemo.doAdd(1,2));

        AbstractClassDemo demo1 = new AbstractClassDemo() {
            @Override
            public Integer doRe(Integer a, Integer b) {
                return doAdd(a,b);
            }
        };

        System.out.println(demo1.doRe(1,2));
        System.out.println(demo1.doAdd(1,2));
    }
}
