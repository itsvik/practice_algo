package leetcode;

import java.util.*;

public class LRUCache {

    Deque<CacheObject> cache = new LinkedList<>();
    Map<Integer, CacheObject> links = new HashMap<>();
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        if(links.containsKey(key)){
            CacheObject cacheObject = links.get(key);
            cache.remove(cacheObject);
            cache.addFirst(cacheObject);
            return cacheObject.value;
        } else {
          return -1;
        }
    }

    public void put(int key, int value) {
        CacheObject c = new CacheObject(key, value);
        if(links.containsKey(key)){
            CacheObject cacheObject = links.get(key);
            cacheObject.value = value;
            cache.remove(cacheObject);
            cache.addFirst(cacheObject);
        } else if(cache.size() < capacity){
            cache.addFirst(c);
            links.put(key, c);
        } else {
            links.remove(c.key);
            cache.removeLast();
            cache.addFirst(c);
            links.put(key, c);
        }
    }

    public static class CacheObject{
        int key, value;

        public CacheObject(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
