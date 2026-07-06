# Day 18 - Constructors

# Object Initialization using Constructors

## Learning Objectives

After completing this session, you should be able to:

* Understand why constructors are required.
* Understand the problem constructors solve.
* Differentiate between methods and constructors.
* Understand default constructors.
* Understand parameterized constructors.
* Understand constructor overloading.
* Explain the internal working of constructors.
* Create objects using different constructors.

---

# Introduction

In the previous sessions, we learned about:

* Classes
* Objects
* Methods
* Method Overloading

Today, we will answer one important question.

> **When we create an object, who initializes it?**

To answer this question, we first need to understand the problem.

---

# Problem Statement

Consider the following class.

```java
class Student{

    int id;
    String name;

    void display(){

        System.out.println(id + " " + name);

    }

}
```

Now create an object.

```java
public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.display();

    }

}
```

Output

```text
0 null
```

---

# Think Before Moving Forward

Ask yourself the following questions.

Why is the output:

```text
0 null
```

instead of

```text
101 Rahul
```

The answer is simple.

The object has been created, but it has not been initialized.

---

# Existing Solution

One possible solution is to assign the values manually.

```java
Student student = new Student();

student.id = 101;
student.name = "Rahul";

student.display();
```

Output

```text
101 Rahul
```

Looks good.

But let's think further.

---

# What is the Problem?

Suppose we create 100 Student objects.

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
...
```

Every time we need to write

```java
student.id = ...;
student.name = ...;
```

again and again.

Questions:

* What if we forget to assign the values?
* What if another developer forgets?
* Is there any way Java can automatically initialize the object?

The answer is **Yes**.

Java provides **Constructors**.

---

# What is a Constructor?

A constructor is a special member of a class that is automatically executed whenever an object is created.

Its primary responsibility is:

* Initializing an object.

Simply put,

> A constructor prepares the object immediately after it is created.

---

# First Constructor

```java
class Student{

    int id;
    String name;

    Student(){

        id = 101;
        name = "Rahul";

    }

    void display(){

        System.out.println(id + " " + name);

    }

}
```

Main Method

```java
Student student = new Student();

student.display();
```

Output

```text
101 Rahul
```

Notice something interesting.

We never called the constructor.

Still, it executed.

Why?

Because Java automatically calls the constructor whenever an object is created.

---

# How Does Java Execute a Constructor?

Whenever Java executes

```java
Student student = new Student();
```

the following steps happen internally.

```text
new Student()

        ↓

Memory is allocated

        ↓

Object is created

        ↓

Constructor is called automatically

        ↓

Constructor initializes object

        ↓

Reference is returned

        ↓

student stores the reference
```

Visual Representation

```text
Stack Memory

student
   │
   │
   ▼

Heap Memory

---------------------
Student Object
---------------------
id = 101
name = Rahul
---------------------
```

This is the complete lifecycle of object creation.

---

# Characteristics of Constructors

A constructor has some special characteristics.

* Constructor name must be the same as the class name.
* A constructor does not have any return type.
* Constructors are executed automatically.
* Constructors are mainly used for object initialization.
* A constructor can be overloaded.

---

# Constructor vs Method

Many beginners confuse constructors with methods.

| Constructor                    | Method                       |
| ------------------------------ | ---------------------------- |
| Same name as class             | Any valid name               |
| No return type                 | May have a return type       |
| Executes automatically         | Must be called explicitly    |
| Initializes objects            | Performs specific operations |
| Invoked during object creation | Invoked whenever required    |

Example

Method

```java
student.display();
```

Constructor

```java
new Student();
```

Notice that we never write

```java
student.Student();
```

Constructors are invoked automatically by Java.

---

# Parameterized Constructor

Until now, every Student object contains the same values.

```text
101 Rahul
```

Is this practical?

No.

Different students have different information.

We need to pass values while creating the object.

Example

```java
class Student{

    int id;
    String name;

    Student(int studentId, String studentName){

        id = studentId;
        name = studentName;

    }

    void display(){

        System.out.println(id + " " + name);

    }

}
```

Main Method

```java
Student s1 = new Student(101,"Rahul");

Student s2 = new Student(102,"Priya");

Student s3 = new Student(103,"Kiran");

s1.display();

s2.display();

s3.display();
```

Output

```text
101 Rahul

102 Priya

103 Kiran
```

Each object now stores different information.

This makes the constructor much more useful.

---

# Why Use Parameters?

Parameters allow us to initialize each object with different values.

Instead of

```java
student.id = 101;

student.name = "Rahul";
```

we simply write

```java
new Student(101,"Rahul");
```

The constructor performs the initialization.

---

# Constructor Overloading

Can constructors have the same name?

Yes.

Just like methods, constructors can also be overloaded.

Example

```java
class Student{

    Student(){

    }

    Student(int id){

    }

    Student(int id,String name){

    }

}
```

Java decides which constructor to execute based on:

* Number of parameters
* Type of parameters
* Order of parameters

Exactly the same rules that we learned in Method Overloading.

---

# Why Constructor Overloading?

Sometimes we may have different information available.

Example

Student 1

```java
new Student();
```

Student 2

```java
new Student(101);
```

Student 3

```java
new Student(101,"Rahul");
```

Instead of creating different classes, we simply overload the constructor.

---

# Common Mistakes

## Mistake 1

Giving a return type.

Incorrect

```java
void Student(){

}
```

This is **not** a constructor.

It is an ordinary method.

---

## Mistake 2

Constructor name different from class name.

Incorrect

```java
StudentData(){

}
```

This is also not a constructor.

---

## Mistake 3

Trying to call the constructor manually.

Incorrect

```java
student.Student();
```

Constructors execute automatically.

---

# Real-world Examples

Whenever you create an object, constructors are used.

Examples:

* Creating a Bank Account
* Creating an Employee
* Creating a Product
* Creating a Student
* Creating a Mobile object

Every object needs some initial information.

Constructors provide that information during object creation.

---

# Best Practices

* Use constructors to initialize mandatory fields.
* Keep constructors simple and focused on initialization.
* Use parameterized constructors when objects require different values.
* Use constructor overloading to support different ways of creating an object.
* Avoid writing complex business logic inside constructors.

---

# Summary

Today we learned:

* Why constructors are required.
* The problem of object initialization.
* How constructors solve this problem.
* Default constructors.
* Parameterized constructors.
* Constructor overloading.
* Internal working of constructors.
* Difference between constructors and methods.

---

# Key Takeaways

* A constructor is automatically executed when an object is created.
* Constructors initialize objects.
* Constructor name must match the class name.
* Constructors do not have a return type.
* Constructors can accept parameters.
* Constructors can be overloaded.
* Constructors improve code readability and reduce repetitive initialization code.

---

# Practice Exercises

## Program 1

Create a `Student` class using a default constructor.

---

## Program 2

Create an `Employee` class using a parameterized constructor.

---

## Program 3

Create a `Product` class with three overloaded constructors.

---

## Program 4

Create a `BankAccount` class that initializes account number and balance using a constructor.

---

## Program 5

Create a `Car` class and initialize brand, model, and price using a parameterized constructor.

---

# Interview Questions

* What is a constructor?
* Why do we need constructors?
* When is a constructor executed?
* What is object initialization?
* Can constructors return a value?
* Can constructors be overloaded?
* Difference between constructors and methods?
* Why is the constructor name the same as the class name?
* What happens internally when `new Student()` is executed?
* Why are parameterized constructors useful?
