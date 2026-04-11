package com.bootcampexcercise.module8;

import java.util.HashMap;
import java.util.Map;

public class MapActivity {

    public static void main(String[] args) {
        // Create a HashMap of key-value pair
        // key = id (String), value = name (String)
        HashMap<String, String> map = new HashMap<>();
        map.put("S001", "John");
        map.put("S002", "Mike");
        map.put("S003", "Shanti");
        map.put("S004", "Wajid");
        map.put("S005", "Disha");

        // Call print method
        MapActivity obj = new MapActivity();
        obj.print(map);
    }

    void print(Map map) {
        System.out.println("---- Map Contents ----");
        System.out.println("Size: " + map.size());
        for (Object key : map.keySet()) {
            System.out.println("Key: " + key + " | Value: " + map.get(key));
        }
    }
}
