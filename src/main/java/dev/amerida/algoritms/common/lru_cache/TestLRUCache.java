package dev.amerida.algoritms.common.lru_cache;

public class TestLRUCache {
    static void main() {
        // Create an LRU cache with a capacity of 3
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        IO.println("Initial cache: " + cache);
        // Output: {1=One, 2=Two, 3=Three}

        // Accessing element '1' makes it the most recent user
        cache.get(1);
        IO.println("Cache after accessing '1': " + cache);
        // Output: {2=Two, 3=Three, 1=One} (Notice '1' moved to the end)

        // Adding a 4th element will cause the least recent user (which is '2') to be evicted
        cache.put(4, "Four");
        IO.println("Cache after adding '4': " + cache);
        // Output: {3=Three, 1=One, 4=Four} ('2' is gone!)
    }
}
