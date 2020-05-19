package com.study.springcloud;

import com.study.springcloud.lru.LRUCache;

import java.util.Iterator;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {


        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>(4);

        for (int i = 1; i < 20; i++) {
            System.out.println("###### 插入" + i + "########");

            lruCache.put(i + "", i);

            Iterator<Map.Entry<String, Integer>> it = lruCache.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> key = it.next();
                System.out.println(key);
            }
        }
    }
}
