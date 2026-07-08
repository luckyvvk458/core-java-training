# Day 20 - Inheritance

# Problem → Solution Learning Notes

## Learning Objectives

By the end of this session, you will be able to:

-   Explain why Inheritance is needed.
-   Use the `extends` keyword.
-   Differentiate between Parent and Child classes.
-   Access inherited variables and methods.
-   Understand constructor chaining.
-   Explain the types of inheritance supported by Java.
-   Understand why Java does not support multiple inheritance using
    classes.

------------------------------------------------------------------------

# Introduction

In the previous sessions, we learned about:

-   Constructors
-   `this` keyword
-   `static` variables
-   `static` methods

Today, we will answer an important question:

> **If multiple classes have the same properties and methods, should we
> write the same code repeatedly?**

Let's understand the problem.

------------------------------------------------------------------------

# Problem Statement

You are developing an Employee Management System.

``` java
class Employee {

    int id;
    String name;

    void login() {
        System.out.println("Employee Login");
    }
}
```

Now the company asks for a `Developer` class.

``` java
class Developer {

    int id;
    String name;

    void login() {
        System.out.println("Employee Login");
    }

    void writeCode() {
        System.out.println("Writing Code");
    }
}
```

Later, a `Manager` class is required.

``` java
class Manager {

    int id;
    String name;

    void login() {
        System.out.println("Employee Login");
    }

    void conductMeeting() {
        System.out.println("Conducting Meeting");
    }
}
```

------------------------------------------------------------------------

# Think About It

Ask yourself:

-   Which code is repeated?
-   If the `login()` method changes, how many classes should be
    modified?
-   Is copying the same code a good practice?

### Problems

-   Duplicate code
-   Difficult maintenance
-   Poor reusability
-   Higher chances of bugs

There should be a better solution.

------------------------------------------------------------------------

# Solution - Inheritance

Move the common members into a parent class.

``` java
class Employee {

    int id;
    String name;

    void login() {
        System.out.println("Employee Login");
    }
}

class Developer extends Employee {

    void writeCode() {
        System.out.println("Writing Code");
    }
}

class Manager extends Employee {

    void conductMeeting() {
        System.out.println("Conducting Meeting");
    }
}
```

------------------------------------------------------------------------

# Definition

**Inheritance** is the process by which one class acquires the
properties and behaviors of another class.

-   Parent Class (Superclass)
-   Child Class (Subclass)

Syntax:

``` java
class Parent {

}

class Child extends Parent {

}
```

------------------------------------------------------------------------

# Relationship

              Employee
          ----------------
          id
          name
          login()
               ▲
               │
       -------------------
       │                 │
    Developer         Manager
    writeCode()   conductMeeting()

This is called an **IS-A Relationship**.

-   Developer **IS-A** Employee
-   Manager **IS-A** Employee

------------------------------------------------------------------------

# Another Real-world Example

Without Inheritance:

``` java
class Car {

    String company;
    int speed;

    void start(){}
    void stop(){}
}

class Bike {

    String company;
    int speed;

    void start(){}
    void stop(){}
}
```

Again, the same code is repeated.

------------------------------------------------------------------------

# Better Solution

``` java
class Vehicle {

    String company;
    int speed;

    void start() {
        System.out.println("Started");
    }

    void stop() {
        System.out.println("Stopped");
    }
}

class Car extends Vehicle {

}

class Bike extends Vehicle {

}

class Truck extends Vehicle {

}
```

One parent class can be reused by many child classes.

------------------------------------------------------------------------

# Can a Child Access Parent Variables?

``` java
class Employee {

    int id = 101;
    String name = "Rahul";
}

class Developer extends Employee {

    void display() {

        System.out.println(id);
        System.out.println(name);

    }
}
```

Output

    101
    Rahul

The child automatically inherits the parent's accessible variables.

------------------------------------------------------------------------

# Can a Child Access Parent Methods?

``` java
class Employee {

    void login() {
        System.out.println("Employee Login");
    }
}

class Developer extends Employee {

}
```

``` java
Developer developer = new Developer();

developer.login();
```

Output

    Employee Login

------------------------------------------------------------------------

# Can a Child Have Its Own Methods?

``` java
class Developer extends Employee {

    void writeCode() {
        System.out.println("Writing Code");
    }
}
```

``` java
Developer developer = new Developer();

developer.login();
developer.writeCode();
```

Output

    Employee Login
    Writing Code

The child can use both inherited methods and its own methods.

------------------------------------------------------------------------

# Types of Inheritance

## 1. Single Inheritance

    Employee
        ▲
    Developer

------------------------------------------------------------------------

## 2. Multilevel Inheritance

    LivingThing
          ▲
        Animal
          ▲
          Dog

------------------------------------------------------------------------

## 3. Hierarchical Inheritance

          Animal
         /   |   \
       Dog  Cat  Cow

------------------------------------------------------------------------

# Multiple Inheritance

Java **does not support multiple inheritance using classes**.

Invalid:

``` java
class C extends A, B {

}
```

## Why?

This leads to ambiguity (Diamond Problem).

Instead, Java supports multiple inheritance using **Interfaces**.

------------------------------------------------------------------------

# Constructor Chaining

Question:

**When a child object is created, which constructor executes first?**

``` java
class P1 {

    P1() {
        System.out.println("P1()");
    }
}

class C1 extends P1 {

    C1() {
        System.out.println("C1()");
    }
}

class C2 extends C1 {

    C2() {
        System.out.println("C2()");
    }
}

class C3 extends C2 {

    C3() {
        System.out.println("C3()");
    }
}
```

``` java
new C3();
```

Output

    P1()
    C1()
    C2()
    C3()

------------------------------------------------------------------------

# Why Does This Happen?

Every constructor automatically calls its immediate parent's constructor
using `super()`.

Execution Flow

    Object()

    ↓

    P1()

    ↓

    C1()

    ↓

    C2()

    ↓

    C3()

The parent is always initialized before the child.

------------------------------------------------------------------------

# Explicit super()

``` java
class C1 extends P1 {

    C1() {
        System.out.println("C1()");
    }

    C1(int x) {
        System.out.println("C1(int)");
    }
}

class C2 extends C1 {

    C2() {

        super(100);

        System.out.println("C2()");
    }
}
```

Output

    P1()
    C1(int)
    C2()

`super(100)` selects which constructor of the immediate parent should
execute.

Constructor chaining still starts from the top of the hierarchy.

------------------------------------------------------------------------

# Rules of Constructor Chaining

-   Every constructor calls exactly one constructor of its immediate
    parent.
-   If `super()` is not written, Java inserts it automatically.
-   Parent constructors always execute before child constructors.
-   Constructor chaining continues until the `Object` class.

------------------------------------------------------------------------

# Real-world Examples

-   Employee → Developer
-   Vehicle → Car
-   Person → Student
-   Animal → Dog
-   BankAccount → SavingsAccount

------------------------------------------------------------------------

# Best Practices

-   Place common members in the parent class.
-   Avoid duplicate code.
-   Use inheritance only when an **IS-A** relationship exists.
-   Keep child classes focused on additional behavior.

------------------------------------------------------------------------

# Key Takeaways

-   Inheritance promotes code reuse.
-   Child classes inherit accessible members from the parent class.
-   `extends` creates an IS-A relationship.
-   Constructors are not inherited, but constructor chaining always
    occurs.
-   Parent constructors execute before child constructors.
-   Java supports Single, Multilevel and Hierarchical inheritance using
    classes.
-   Multiple inheritance with classes is not supported because of
    ambiguity.

------------------------------------------------------------------------

# Practice Exercises

1.  Create `Person` and `Student` classes using inheritance.
2.  Create `Vehicle`, `Car` and `Bike` classes.
3.  Create `Animal → Dog → Puppy` and observe constructor execution.
4.  Create `Shape → Circle` and add your own methods.
5.  Explain the output of a constructor chaining program.

------------------------------------------------------------------------

# Interview Questions

1.  What is Inheritance?
2.  Why do we use Inheritance?
3.  What is the `extends` keyword?
4.  Difference between Parent and Child classes?
5.  What is an IS-A relationship?
6.  Types of Inheritance in Java?
7.  Why doesn't Java support Multiple Inheritance using classes?
8.  What is Constructor Chaining?
9.  Difference between `this()` and `super()`?
10. Are constructors inherited?
11. Does creating a child object initialize the parent?
12. Explain the execution order of constructors.
