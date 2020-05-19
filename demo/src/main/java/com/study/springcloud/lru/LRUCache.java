package com.study.springcloud.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private float loadFactor;

    private final int maxSize;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public LRUCache(int maxSize) {
        super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
        this.maxSize = maxSize;
    }

    public LRUCache(int initialCapacity, int maxSize) {
        super(initialCapacity, DEFAULT_LOAD_FACTOR, true);
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.maxSize = maxSize;
    }

    public LRUCache(int initialCapacity,
                    float loadFactor, int maxSize) {
        super(initialCapacity, loadFactor, true);
        this.loadFactor = loadFactor;
        this.maxSize = maxSize;
    }


    private boolean needRemove() {
        return size() >= this.maxSize;
    }

    private void removeLRU() {
        Iterator<Map.Entry<K, V>> it = this.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> key = it.next();
            this.remove(key.getKey());
            break;
        }
    }

    @Override
    public V put(K key, V value) {
        if (needRemove()) removeLRU();
        return super.put(key, value);
    }
}
