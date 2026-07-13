# Day 23 - Abstraction & Interfaces

## Learning Objectives

-   Understand why Abstraction is needed.
-   Understand Abstract Classes and Abstract Methods.
-   Understand why Interfaces exist.
-   Differentiate Abstract Classes and Interfaces.
-   Learn when to use each.

------------------------------------------------------------------------

# Revision

    Class
    ↓
    Object
    ↓
    Methods
    ↓
    Constructors
    ↓
    this
    ↓
    static
    ↓
    Inheritance
    ↓
    Polymorphism

Today we continue with:

    Abstraction
    ↓
    Interfaces

------------------------------------------------------------------------

# Problem Statement

Suppose we have an Animal class.

``` java
class Animal {
    void sound() {
        System.out.println("Animal Sound");
    }
}
```

Should every animal produce the same sound?

No.

-   Dog → Bark
-   Cat → Meow
-   Cow → Moo

The parent class cannot provide the correct implementation.

------------------------------------------------------------------------

# Solution

Use an Abstract Class.

``` java
abstract class Animal {
    abstract void sound();
}
```

Every child must implement the method.

``` java
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog Barks");
    }
}
```

------------------------------------------------------------------------

# Why Can't We Create an Abstract Object?

``` java
Animal animal = new Animal();
```

Compilation Error.

Reason:

An abstract class represents an incomplete concept.

You cannot create a generic Animal.

You create a Dog, Cat or Cow.

------------------------------------------------------------------------

# Problem Statement 2

Common behavior:

-   Bird
-   Airplane
-   Drone

All can fly.

Should Airplane extend Bird?

No.

Airplane IS-A Bird ❌

------------------------------------------------------------------------

# Interface

``` java
interface Flyable {
    void fly();
}
```

``` java
class Bird extends Animal implements Flyable {
    @Override
    public void fly() {
        System.out.println("Bird Flying");
    }

    @Override
    void sound() {
        System.out.println("Bird Sound");
    }
}
```

``` java
class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane Flying");
    }
}
```

------------------------------------------------------------------------

# IS-A vs CAN-DO

Use an Abstract Class when describing identity.

Examples:

-   Dog IS-A Animal
-   Car IS-A Vehicle

Use an Interface when describing capability.

Examples:

-   Bird CAN Fly
-   Airplane CAN Fly
-   Drone CAN Fly

------------------------------------------------------------------------

# Abstract Class vs Interface

Abstract Class          Interface
  ----------------------- ---------------------
IS-A                    CAN-DO
extends                 implements
Can have constructors   No constructors
Can have state          Represents behavior

------------------------------------------------------------------------

# Multiple Interfaces

``` java
interface Camera {}
interface GPS {}
interface MusicPlayer {}

class SmartPhone
implements Camera, GPS, MusicPlayer {
}
```

------------------------------------------------------------------------

# Key Takeaways

-   Abstract Classes model identity.
-   Interfaces model capabilities.
-   Use Abstract Classes for shared state and behavior.
-   Use Interfaces for common abilities.
-   Interfaces enable multiple inheritance of behavior.

------------------------------------------------------------------------

# Practice

1.  Animal → Dog → Cat
2.  Vehicle → Car → Bike
3.  Flyable → Bird, Airplane, Drone
4.  Printable → Invoice, Report
5.  SmartPhone → Camera, GPS, MusicPlayer

------------------------------------------------------------------------

# Interview Questions

1.  What is Abstraction?
2.  What is an Abstract Class?
3.  What is an Interface?
4.  Difference between Abstract Class and Interface?
5.  IS-A vs CAN-DO?
6.  Why is Flyable an Interface?
