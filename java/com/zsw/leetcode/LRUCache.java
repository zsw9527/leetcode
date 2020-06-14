package com.zsw.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
