// AnimalActivity.java
// Demonstrates Interfaces using Animal, Cat, Dog, Mammal

package com.bootcampexcercise.module6.activity;

// ============================================
// INTERFACE - Animal
// Interface defines WHAT to do, not HOW to do it
// Any class that implements Animal MUST define
// both animalSound() and sleep() methods
// ============================================

interface Animal {

    // Abstract methods - no body, just declaration
    // Implementing classes must provide the body
    void animalSound();   // Every animal makes a different sound
    void sleep();         // Every animal sleeps
}

// ============================================
// CLASS - Cat
// Implements Animal interface
// Provides its own implementation of both methods
// Note: No 'public' keyword since only one
// class can be public in a single file
// ============================================

class Cat implements Animal {

    // Implementing animalSound() from Animal interface
    @Override
    public void animalSound() {
        System.out.println("Cat says: 'Meow Meow'!"); // Cat specific sound
    }

    // Implementing sleep() from Animal interface
    @Override
    public void sleep() {
        System.out.println("Cat is sleeping!"); // Cat specific sleep
    }
}

// ============================================
// CLASS - Dog
// Implements Animal interface
// Provides its own implementation of both methods
// ============================================

class Dog implements Animal {

    // Implementing animalSound() from Animal interface
    @Override
    public void animalSound() {
        System.out.println("Dog says: 'Woof Woof'!"); // Dog specific sound
    }

    // Implementing sleep() from Animal interface
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping!"); // Dog specific sleep
    }
}

// ============================================
// CLASS - Mammal
// Uses Animal interface as attribute
// Can work with ANY animal (Cat, Dog, etc.)
// This is called POLYMORPHISM - one reference
// can hold different types of Animal objects
// ============================================

class Mammal {

    private Animal myAnimal;  // Animal interface reference - can hold Cat or Dog
    private String name;      // Name of the mammal

    // Constructor - sets the name of the mammal
    Mammal(String name) {
        this.name = name; // Assigns name passed during object creation
    }

    // Setter - sets which animal this mammal is
    // Can accept any class that implements Animal (Cat, Dog, etc.)
    public void setAnimal(Animal animal) {
        myAnimal = animal;
    }

    // Calls sleep() on whichever animal is currently set
    public void animalIsSleeping() {
        System.out.println("Animal with name: " + name + " is ...");
        myAnimal.sleep(); // Calls Cat's or Dog's sleep() depending on what is set
    }

    // Calls animalSound() on whichever animal is currently set
    public void animalIsSpeaking() {
        System.out.println("Animal with name: " + name + " is ...");
        myAnimal.animalSound(); // Calls Cat's or Dog's animalSound() depending on what is set
    }
}

// ============================================
// MAIN CLASS - AnimalActivity
// This is 'public' and MUST match filename
// File must be saved as AnimalActivity.java
// ============================================

public class AnimalActivity {

    public static void main(String[] args) {

        // ----------------------------------------
        // Using INTERFACE to declare identifiers
        // Animal reference can hold Cat or Dog object
        // This is Polymorphism - one type, many forms
        // ----------------------------------------

        Animal cat = new Cat(); // Cat object stored in Animal reference
        Animal dog = new Dog(); // Dog object stored in Animal reference

        // ----------------------------------------
        // MAMMAL OBJECT
        // Create Mammal with name "Kitty"
        // ----------------------------------------

        Mammal mammal = new Mammal("Kitty");

        // --- Set animal to Cat ---
        System.out.println("=== Mammal with Cat ===");
        mammal.setAnimal(cat);          // Mammal is now using Cat
        mammal.animalIsSleeping();      // Calls Cat's sleep()
        mammal.animalIsSpeaking();      // Calls Cat's animalSound()

        System.out.println("-----------------------------");

        // --- Set animal to Dog ---
        System.out.println("=== Mammal with Dog ===");
        mammal.setAnimal(dog);          // Mammal is now using Dog
        mammal.animalIsSleeping();      // Calls Dog's sleep()
        mammal.animalIsSpeaking();      // Calls Dog's animalSound()

        System.out.println("-----------------------------");
    }
}