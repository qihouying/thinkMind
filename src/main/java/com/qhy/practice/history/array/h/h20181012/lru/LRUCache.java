package com.qhy.practice.history.array.h.h20181012.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Desc:
 * author: qihouying@meituan.com
 * Date:   10 12, 2018 11:15
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
   private final int MAX_CACH_SIZE;

    public LRUCache(int capacity) {
        super((int) Math.ceil(capacity/0.75)+1, 0.75f, true);
        MAX_CACH_SIZE = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACH_SIZE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(", ");
        }
        return super.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.toString());
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }
}
