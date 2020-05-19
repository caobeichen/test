package com.study.springcloud.list;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        integers = new ListOperator<Integer>().filter(integers, (integer) -> {
//            if (integer % 2 != 0) {
//                return false;
//            }
//            return true;
//        });
//
//        integers = new ListOperator<Integer>().operator(integers,(integer) -> {
//            return integer * 2;
//        });

        integers = new ListOperator<Integer>().operatorFilter(integers, (integer) -> {
            return integer * 2;
        }, (integer) -> {
            if ((integer / 2) % 2 == 0) {
                return true;
            }
            return false;
        });

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
