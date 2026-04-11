package com.bootcampexcercise.module8;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetActivityWajid {

    public static void main(String[] args) {
        // Create a HashSet of names - 10
        HashSet<String> names = new HashSet<>();
        names.add("John");
        names.add("Mike");
        names.add("Shanti");
        names.add("Stacie");
        names.add("Wajid");
        names.add("Disha");
        names.add("Alex");
        names.add("Sara");
        names.add("Tom");
        names.add("Rita");

        System.out.println("---- Initial HashSet (10 names) ----");
        printSet(names);

        // Add duplicate values - 2 (HashSet will not actually store duplicates)
        System.out.println("\n---- Trying to add 2 duplicates (John, Mike) ----");
        boolean added1 = names.add("John");
        boolean added2 = names.add("Mike");
        System.out.println("Added 'John' again? " + added1);
        System.out.println("Added 'Mike' again? " + added2);
        printSet(names);

        // Remove 2 values
        System.out.println("\n---- After removing 2 values (Alex, Rita) ----");
        names.remove("Alex");
        names.remove("Rita");
        printSet(names);

        // Find the "index" of Wajid in the HashSet
        // NOTE: HashSet is unordered so it has no real index.
        // We iterate and report the position in iteration order.
        System.out.println("\n---- Searching for 'Wajid' ----");
        String target = "Wajid";
        int index = -1;
        int i = 0;
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (it.next().equals(target)) {
                index = i;
                break;
            }
            i++;
        }
        if (index >= 0) {
            System.out.println("'" + target + "' found at iteration position: " + index);
        } else {
            System.out.println("'" + target + "' not found in HashSet");
        }
    }

    static void printSet(HashSet<String> set) {
        System.out.println("Size: " + set.size());
        for (String name : set) {
            System.out.println(" - " + name);
        }
    }
}
