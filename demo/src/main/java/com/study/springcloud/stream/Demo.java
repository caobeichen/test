package com.study.springcloud.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {
        int min = 1;
        int max = 100;


        List<Integer> list = new ArrayList<>();
        List<Double> result = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        // collections
        long time = System.nanoTime();
        long etime = 0;

        for (Integer i : list) {
            if (i % 2 == 0) {
                result.add(Math.sqrt(i));
            }
        }
        etime = System.nanoTime() - time;

        System.out.println("Collection Execut Time: " + etime + " ns");


        // Stream

        Stream<Integer> stream = list.stream();

        time = System.nanoTime();

        result = stream.filter(i -> i % 2 == 0).map(i -> Math.sqrt(i)).collect(Collectors.toList());

        etime = System.nanoTime() - time;

        System.out.println("Stream Execut Time: " + etime + " ns");

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();



    }
}
