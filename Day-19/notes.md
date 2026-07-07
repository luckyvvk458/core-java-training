# Day 19 - `this` Keyword, `static` Variables & `static` Methods

# Understanding Current Object Reference and Class Members

---

# Learning Objectives

After completing this session, you should be able to:

* Understand why the `this` keyword is required.
* Understand Variable Shadowing.
* Use `this` to refer to the current object.
* Understand why `static` variables are required.
* Differentiate between instance variables and static variables.
* Understand static methods.
* Explain the internal working of `this` and `static`.

---

# Revision

In the previous session, we learned about Constructors.

We know that:

```java
Student student = new Student(101, "Rahul");
```

creates an object and automatically executes the constructor.

The constructor initializes the object.

Today we will answer two important questions.

1. How does Java know which object's variable should be updated?

2. Why should every object store the same information repeatedly?

---

# Part 1 - Why Do We Need the `this` Keyword?

Let's begin with a problem.

---

# Problem Statement

Consider the following program.

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {

        id = id;
        name = name;

    }

    void display() {

        System.out.println(id + " " + name);

    }

}
```

Main Program

```java
public class Main {

    public static void main(String[] args) {

        Student student = new Student(101, "Rahul");

        student.display();

    }

}
```

Output

```text
0 null
```

---

# Think About It

We passed

```text
101
Rahul
```

to the constructor.

Then why did the object still contain

```text
0
null
```

Did the constructor execute?

Yes.

Then why didn't the values get stored?

---

# Understanding the Problem

Inside the constructor, we have

```java
Student(int id, String name) {

    id = id;

    name = name;

}
```

Here we have two variables with the same name.

```
Instance Variables

id
name

-------------------

Constructor Parameters

id
name
```

Question:

Which `id` is Java referring to?

The answer is:

The constructor parameter.

The instance variable becomes hidden.

This situation is called **Variable Shadowing**.

---

# Existing Solution

One solution is to rename the parameters.

```java
Student(int studentId, String studentName) {

    id = studentId;

    name = studentName;

}
```

This works.

But imagine writing

```
employeeId

customerId

productId

studentId

accountId
```

for every constructor.

Java provides a better solution.

---

# Introducing the `this` Keyword

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;

        this.name = name;

    }

    void display() {

        System.out.println(id + " " + name);

    }

}
```

Output

```text
101 Rahul
```

---

# What is `this`?

> **`this` is a reference to the current object.**

Whenever an object is created,

Java automatically creates a reference called

```text
this
```

which points to that object.

---

# Internal Working

Suppose Java executes

```java
Student student = new Student(101, "Rahul");
```

Internally,

```
new Student()

↓

Memory Allocated

↓

Object Created

↓

this points to that object

↓

Constructor Executes

↓

this.id = parameter id

↓

this.name = parameter name

↓

Object Initialized
```

---

# Memory Representation

```
Stack Memory

student
   │
   │
   ▼

Heap Memory

------------------------

Student Object

id = 101

name = Rahul

------------------------

▲

this
```

Notice that

```text
student
```

and

```text
this
```

refer to the same object.

The difference is:

* `student` is used outside the class.
* `this` is used inside the class.

---

# Hands-on Program 1

```java
class Employee {

    int id;
    String name;

    Employee(int id, String name) {

        this.id = id;
        this.name = name;

    }

    void display() {

        System.out.println(id + " " + name);

    }

}
```

Create two Employee objects and observe that each object stores different values.

---

# Why Do We Need `static`?

Now let's look at another problem.

---

# Problem Statement

Suppose we create three Student objects.

```java
Student s1 = new Student();

Student s2 = new Student();

Student s3 = new Student();
```

Each student belongs to the same college.

```
ABC Engineering College
```

One possible solution is

```java
class Student {

    int id;

    String name;

    String college = "ABC Engineering College";

}
```

Looks fine.

But think carefully.

Every object stores

```
ABC Engineering College
```

again and again.

```
Object-1

id

name

college

------------------

Object-2

id

name

college

------------------

Object-3

id

name

college
```

Is this memory efficient?

No.

---

# Introducing `static`

Instead of storing the college name inside every object,

store it once in the class.

```java
class Student {

    int id;

    String name;

    static String college = "ABC Engineering College";

}
```

Now,

only one copy of

```text
college
```

exists.

---

# Memory Representation

```
Class Area

college

↓

ABC Engineering College

----------------------------

Student Object

id

name

----------------------------

Student Object

id

name
```

---

# Hands-on Program 2

```java
class Student {

    int id;
    String name;

    static String college = "ABC Engineering";

}
```

```java
Student s1 = new Student();
Student s2 = new Student();

System.out.println(s1.college);
System.out.println(s2.college);
```

Output

```
ABC Engineering
ABC Engineering
```

---

# Proving that `college` belongs to the Class

Modify only

```java
s1.college = "XYZ Engineering";
```

Now print

```java
System.out.println(s1.college);

System.out.println(s2.college);
```

Output

```
XYZ Engineering

XYZ Engineering
```

Question:

Why did

```
s2
```

also change?

Because

there is only one copy of

```text
college
```

shared by all objects.

---

# Proving that `id` belongs to the Object

```java
Student s1 = new Student();
Student s2 = new Student();

s1.id = 101;
s2.id = 102;

System.out.println(s1.id);
System.out.println(s2.id);
```

Output

```
101

102
```

Changing

```text
s1.id
```

does not affect

```text
s2.id
```

Therefore,

each object has its own copy of instance variables.

---

# Accessing Static Variables

Recommended way

```java
System.out.println(Student.college);
```

Although

```java
System.out.println(s1.college);
```

works,

it is not recommended.

Why?

Because

the variable belongs to the class,

not to the object.

---

# Static Methods

Suppose every student should see the welcome message.

Instead of writing

```java
student.displayWelcome();
```

for every object,

create a static method.

```java
class Student {

    static void welcome() {

        System.out.println(
                "Welcome to ABC Engineering College");

    }

}
```

Call it

```java
Student.welcome();
```

Notice

No object was created.

---

# Can Static Methods Access Instance Variables?

Consider

```java
class Student {

    int id;

    static void display() {

        System.out.println(id);

    }

}
```

Compilation Error.

Reason:

A static method belongs to the class.

It does not know which object's

```text
id
```

should be used.

However,

it can directly access

```java
static String college;
```

because both belong to the class.

---

# Summary

## `this`

* Refers to the current object.
* Resolves variable shadowing.
* Used inside constructors and instance methods.

---

## Static Variable

* Belongs to the class.
* Only one copy exists.
* Shared among all objects.

---

## Static Method

* Belongs to the class.
* Called using the class name.
* Can directly access static members.
* Cannot directly access instance members.

---

# Best Practices

✔ Use `this` whenever constructor parameters have the same names as instance variables.

✔ Use `static` for data shared by all objects.

✔ Call static methods using the class name.

✔ Avoid accessing static members through objects.

---

# Key Takeaways

* `this` refers to the current object.
* `this` helps distinguish instance variables from local variables.
* Instance variables belong to individual objects.
* Static variables belong to the class.
* Only one copy of a static variable exists.
* Static methods belong to the class and can be invoked without creating an object.

---

# Practice Exercises

### Program 1

Create a `Product` class using the `this` keyword.

---

### Program 2

Create an `Employee` class with a static company name.

---

### Program 3

Count the total number of Employee objects using a static variable.

---

### Program 4

Create a `Calculator` class with static methods:

* add()
* subtract()
* multiply()
* divide()

---

### Program 5

Predict the output of programs that use both instance and static members.
