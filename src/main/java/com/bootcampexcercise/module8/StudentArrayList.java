package com.bootcampexcercise.module8;

import java.util.ArrayList;



public class StudentArrayList {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Add students to arraylist declared above
        addStudent(new Student(1, "John", 85.5));
        addStudent(new Student(2, "Mike", 72.0));
        addStudent(new Student(3, "Shanti", 91.3));
        addStudent(new Student(4, "Wajid", 88.7));
        addStudent(new Student(5, "Disha", 95.0));

        // Try adding a duplicate ID - should be prevented
        addStudent(new Student(3, "Duplicate", 60.0));

        // Print all students
        System.out.println("All Students:");
        printAll();

        // Remove student by ID - remove id 3
        removeById(3);

        // Print all students after removing id 3
        System.out.println("\nAfter removing student with ID 3:");
        printAll();

        // Find highest grade student
        Student top = findHighestGrade();
        if (top != null) {
            System.out.println("\nHighest grade student: " + top);
        }
    }

    // Create method to Add student (prevent duplicate ID)
    static void addStudent(Student s) {
        for (Student existing : students) {
            if (existing.getId() == s.getId()) {
                System.out.println("Duplicate ID " + s.getId() + " - student not added.");
                return;
            }
        }
        students.add(s);
    }

    // Create method to remove student by id
    static void removeById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Removed student with ID " + id);
                return;
            }
        }
        System.out.println("No student found with ID " + id);
    }

    // Create method to Print all students
    static void printAll() {
        for (Student s : students) {
            System.out.println(" - " + s);
        }
    }

    // Find highest grade student
    static Student findHighestGrade() {
        if (students.isEmpty()) return null;
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGrade() > top.getGrade()) {
                top = s;
            }
        }
        return top;
    }
}
