package com.study.springcloud;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> fi = es.submit(() -> {
            return 100;
        });

        fi.get();
     }
}
