package com.study.springcloud.deleyqueue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Index> queue = new DelayQueue<>();

        Index zs = new Index("张三",1, TimeUnit.MINUTES);
        queue.put(zs);

        Thread.sleep(2000);
        Index ls = new Index("李四",1, TimeUnit.MINUTES);
        queue.put(ls);

        Thread.sleep(5000);
        Index ww = new Index("王五",1, TimeUnit.MINUTES);
        queue.put(ww);

        while(queue.size() > 0) {
            Index index = queue.poll();

            if (index != null) {
                System.out.format("%s选房结束,选房时间为:%s\n",index.getIndexOwnerName(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }
        }

    }
}
