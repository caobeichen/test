package com.study.springcloud.deleyqueue;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Index implements Delayed {

    private String indexOwnerName;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private long time;

    public Index(String indexOwnerName, long time, TimeUnit unit) {
        this.indexOwnerName = indexOwnerName;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);

        System.out.format("%s选房开始,开始时间为:%s\n", indexOwnerName, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Index index = (Index) o;
        long diff = this.time - index.time;
        if (diff > 0) return 1;
        else return -1;
    }

    public String getIndexOwnerName() {
        return indexOwnerName;
    }
}
