package edu.sjsu.cmpe.cache.client;


import java.util.*;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");
        CacheServiceInterface cache0 = new DistributedCacheService(
                "http://localhost:3000");
        CacheServiceInterface cache1 = new DistributedCacheService(
                "http://localhost:3001");
        CacheServiceInterface cache2 = new DistributedCacheService(
                "http://localhost:3002");

        List<CacheServiceInterface> caches = new ArrayList<CacheServiceInterface>();
        caches.add(cache0);
        caches.add(cache1);
        caches.add(cache2);

        CustomHashFunction chf = new CustomHashFunctionImpl();
        ConsistentHash<CacheServiceInterface> hash = new ConsistentHash<CacheServiceInterface>(chf, 1, caches);

        Map<String, String> kvMap = new TreeMap<String, String>();
        kvMap.put("1", "a");
        kvMap.put("2", "b");
        kvMap.put("3", "c");
        kvMap.put("4", "d");
        kvMap.put("5", "e");
        kvMap.put("6", "f");
        kvMap.put("7", "g");
        kvMap.put("8", "h");
        kvMap.put("9", "i");
        kvMap.put("10", "j");

        for(String key : kvMap.keySet()) {
            CacheServiceInterface cache = hash.get(key);
            cache.put(Long.parseLong(key), kvMap.get(key));
        }

        for (String key : kvMap.keySet()) {
            CacheServiceInterface cache = hash.get(key);
            cache.get(Long.parseLong(key));
            System.out.println(key);

        }

        System.out.println("Ending Cache Client...");


    }



}
