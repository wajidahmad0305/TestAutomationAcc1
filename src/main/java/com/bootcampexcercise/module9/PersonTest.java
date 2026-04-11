package com.bootcampexcercise.module9;

public class PersonTest {

    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        System.out.println("==== Running PersonTest ====\n");

        testConstructorAndGetters();
        testSetters();
        testIsAdultTrue();
        testIsAdultFalse();
        testGreet();
        testNegativeAgeThrows();

        System.out.println("\n==== Results ====");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }

    static void testConstructorAndGetters() {
        Person p = new Person("John", 25, "john@test.com");
        check("Constructor - name", p.getName().equals("John"));
        check("Constructor - age", p.getAge() == 25);
        check("Constructor - email", p.getEmail().equals("john@test.com"));
    }

    static void testSetters() {
        Person p = new Person("John", 25, "john@test.com");
        p.setName("Mike");
        p.setAge(30);
        p.setEmail("mike@test.com");
        check("Setter - name", p.getName().equals("Mike"));
        check("Setter - age", p.getAge() == 30);
        check("Setter - email", p.getEmail().equals("mike@test.com"));
    }

    static void testIsAdultTrue() {
        Person p = new Person("Adult", 18, "a@a.com");
        check("isAdult (18) -> true", p.isAdult());
    }

    static void testIsAdultFalse() {
        Person p = new Person("Kid", 10, "k@k.com");
        check("isAdult (10) -> false", !p.isAdult());
    }

    static void testGreet() {
        Person p = new Person("Wajid", 22, "w@w.com");
        check("greet", p.greet().equals("Hello, my name is Wajid"));
    }

    static void testNegativeAgeThrows() {
        Person p = new Person("Test", 20, "t@t.com");
        boolean thrown = false;
        try {
            p.setAge(-5);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        check("Negative age throws", thrown);
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
