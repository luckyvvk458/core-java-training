# Day 22 - Polymorphism

# Problem → Solution Learning Notes

## Learning Objectives

-   Explain why Polymorphism is needed.
-   Differentiate Method Overloading and Method Overriding.
-   Understand Compile-time and Runtime Polymorphism.
-   Explain Dynamic Method Dispatch.

------------------------------------------------------------------------

# Revision

Yesterday we learned **Inheritance**.

Today we answer an important question:

> **What if a child class wants a different implementation than its
> parent?**

------------------------------------------------------------------------

# Problem Statement

Suppose we are developing software for a Zoo.

The zoo has:

-   Dog
-   Cat
-   Cow
-   Lion

Each animal makes a different sound.

## First Attempt

``` java
class Animal{
    void sound(){
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal{
}
```

``` java
Dog dog = new Dog();
dog.sound();
```

Output

    Animal makes sound

Should a dog really print **Animal makes sound**?

No.

------------------------------------------------------------------------

# Existing Solution

Create different methods.

``` java
dog.dogSound();
cat.catSound();
cow.cowSound();
```

## Problem

Every programmer must remember different method names.

As more animals are added, the code becomes difficult to maintain.

------------------------------------------------------------------------

# Solution - Method Overriding

``` java
class Animal{
    void sound(){
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal{

    @Override
    void sound(){
        System.out.println("Dog Barks");
    }
}
```

Output

    Dog Barks

The child replaces the parent's implementation.

This is **Method Overriding**.

------------------------------------------------------------------------

# A Bigger Problem

Without polymorphism:

``` java
Dog dog = new Dog();
Cat cat = new Cat();
Cow cow = new Cow();

dog.sound();
cat.sound();
cow.sound();
```

Tomorrow we add Tiger, Elephant and Goat.

Our code keeps growing.

Can we write one piece of code that works for every animal?

------------------------------------------------------------------------

# Runtime Polymorphism

``` java
Animal animal;

animal = new Dog();
animal.sound();

animal = new Cat();
animal.sound();

animal = new Cow();
animal.sound();
```

Output

    Dog Barks
    Cat Meows
    Cow Moos

Notice that **only the object changes**.

The statement

``` java
animal.sound();
```

never changes.

This is **Polymorphism**.

------------------------------------------------------------------------

# Dynamic Method Dispatch

When Java executes

``` java
animal.sound();
```

The JVM checks:

    Which object is 'animal' referring to?

If it points to a Dog, `Dog.sound()` executes.

If it points to a Cat, `Cat.sound()` executes.

The decision is made **at runtime**.

------------------------------------------------------------------------

# Compile-time vs Runtime Polymorphism

Compile-time           Runtime
  ---------------------- -------------------
Method Overloading     Method Overriding
Same Class             Parent & Child
Different Parameters   Same Signature
Compiler decides       JVM decides

------------------------------------------------------------------------

# Real-world Example

``` java
Payment payment;

payment = new CreditCard();
payment.pay();

payment = new UPI();
payment.pay();
```

Same method.

Different behavior.

------------------------------------------------------------------------

# Key Takeaways

-   One interface, many forms.
-   Overloading is Compile-time Polymorphism.
-   Overriding is Runtime Polymorphism.
-   Parent references can refer to child objects.
-   JVM decides overridden method execution at runtime.

------------------------------------------------------------------------

# Practice

1.  Animal → Dog → Cat → Cow.
2.  Vehicle → Car → Bike.
3.  Payment → UPI → CreditCard.
4.  Notification → Email → SMS.

------------------------------------------------------------------------

# Interview Questions

1.  What is Polymorphism?
2.  Difference between Overloading and Overriding?
3.  What is Runtime Polymorphism?
4.  What is Dynamic Method Dispatch?
5.  Can a parent reference refer to a child object?
