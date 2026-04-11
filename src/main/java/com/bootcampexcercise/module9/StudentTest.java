package com.bootcampexcercise.module9;

import java.util.ArrayList;

public class StudentTest {

    static int passed = 0;
    static int failed = 0;

    // Local copy of add/remove/find logic for testing
    static ArrayList<Student> students;

    public static void main(String[] args) {
        System.out.println("==== Running StudentTest (for StudentArrayList) ====\n");

        testAddStudent();
        testPreventDuplicateId();
        testRemoveById();
        testRemoveNonExistentId();
        testFindHighestGrade();
        testEmptyListHighestGrade();

        System.out.println("\n==== Results ====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }

    static void reset() {
        students = new ArrayList<>();
    }

    static boolean addStudent(Student s) {
        for (Student existing : students) {
            if (existing.getId() == s.getId()) return false;
        }
        students.add(s);
        return true;
    }

    static boolean removeById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    static Student findHighestGrade() {
        if (students.isEmpty()) return null;
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) top = s;
        }
        return top;
    }

    // ---- Tests ----

    static void testAddStudent() {
        reset();
        addStudent(new Student(1, "John", 85.0));
        addStudent(new Student(2, "Mike", 70.0));
        check("Add 2 students -> size 2", students.size() == 2);
    }

    static void testPreventDuplicateId() {
        reset();
        addStudent(new Student(1, "John", 85.0));
        boolean second = addStudent(new Student(1, "Copy", 50.0));
        check("Duplicate ID rejected", !second);
        check("Size still 1 after duplicate", students.size() == 1);
    }

    static void testRemoveById() {
        reset();
        addStudent(new Student(1, "John", 85.0));
        addStudent(new Student(2, "Mike", 70.0));
        addStudent(new Student(3, "Shanti", 91.0));
        boolean removed = removeById(2);
        check("Remove existing ID returns true", removed);
        check("Size after remove is 2", students.size() == 2);
    }

    static void testRemoveNonExistentId() {
        reset();
        addStudent(new Student(1, "John", 85.0));
        boolean removed = removeById(99);
        check("Remove non-existent returns false", !removed);
    }

    static void testFindHighestGrade() {
        reset();
        addStudent(new Student(1, "John", 85.0));
        addStudent(new Student(2, "Mike", 70.0));
        addStudent(new Student(3, "Shanti", 95.5));
        addStudent(new Student(4, "Wajid", 88.0));
        Student top = findHighestGrade();
        check("Highest grade student is Shanti", top != null && top.getName().equals("Shanti"));
        check("Highest grade value is 95.5", top != null && top.getGrade() == 95.5);
    }

    static void testEmptyListHighestGrade() {
        reset();
        Student top = findHighestGrade();
        check("Empty list highest grade is null", top == null);
    }

    static void check(String label, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("[PASS] " + label);
        } else {
            failed++;
            System.out.println("[FAIL] " + label);
        }
    }
}
