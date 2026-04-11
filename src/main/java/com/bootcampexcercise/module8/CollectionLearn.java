package com.bootcampexcercise.module8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CollectionLearn {

    ArrayList<String> list = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    HashMap<Integer, String> map = new HashMap<>();

    // Populate each with 10 values
    public CollectionLearn() {
        String[] names = {"John", "Mike", "Shanti", "Stacie", "Wajid",
                "Disha", "Alex", "Sara", "Tom", "Rita"};
        for (int i = 0; i < names.length; i++) {
            list.add(names[i]);
            set.add(names[i]);
            map.put(i + 1, names[i]);
        }
    }

    // Print methods for all 3 collections
    void printList() {
        System.out.println("ArrayList: " + list);
    }

    void printSet() {
        System.out.println("HashSet: " + set);
    }

    void printMap() {
        System.out.println("HashMap: " + map);
    }

    void printAll() {
        printList();
        printSet();
        printMap();
    }

    // Add value to all (don't allow duplicates)
    void addValue(String value) {
        if (!list.contains(value)) {
            list.add(value);
        } else {
            System.out.println("List already contains '" + value + "'");
        }
        // HashSet handles duplicates naturally
        if (!set.add(value)) {
            System.out.println("Set already contains '" + value + "'");
        }
        if (!map.containsValue(value)) {
            map.put(map.size() + 1, value);
        } else {
            System.out.println("Map already contains '" + value + "'");
        }
    }

    // Remove value from all
    void removeValue(String value) {
        list.remove(value);
        set.remove(value);
        Integer keyToRemove = null;
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(value)) {
                keyToRemove = key;
                break;
            }
        }
        if (keyToRemove != null) {
            map.remove(keyToRemove);
        }
    }

    // Replace values (don't allow duplicates)
    void replaceValue(String oldValue, String newValue) {
        // Prevent duplicate in list
        if (list.contains(newValue)) {
            System.out.println("Cannot replace - '" + newValue + "' already in list");
            return;
        }
        if (set.contains(newValue)) {
            System.out.println("Cannot replace - '" + newValue + "' already in set");
            return;
        }
        if (map.containsValue(newValue)) {
            System.out.println("Cannot replace - '" + newValue + "' already in map");
            return;
        }

        int idx = list.indexOf(oldValue);
        if (idx >= 0) list.set(idx, newValue);

        set.remove(oldValue);
        set.add(newValue);

        for (Integer key : map.keySet()) {
            if (map.get(key).equals(oldValue)) {
                map.put(key, newValue);
                break;
            }
        }
    }

    public static void main(String[] args) {
        CollectionLearn cl = new CollectionLearn();

        System.out.println("---- Initial (10 values each) ----");
        cl.printAll();

        System.out.println("\n---- Add 'Karen' (new), then 'John' (duplicate) ----");
        cl.addValue("Karen");
        cl.addValue("John");
        cl.printAll();

        System.out.println("\n---- Remove 'Mike' and 'Sara' ----");
        cl.removeValue("Mike");
        cl.removeValue("Sara");
        cl.printAll();

        System.out.println("\n---- Replace 'Tom' with 'Bob' ----");
        cl.replaceValue("Tom", "Bob");
        cl.printAll();

        System.out.println("\n---- Try replacing 'Rita' with 'John' (duplicate) ----");
        cl.replaceValue("Rita", "John");
        cl.printAll();
    }
}
