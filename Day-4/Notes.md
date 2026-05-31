# Day 4 - Variables, Data Types and Memory

## Objective

Understand how Java programs store information using variables and data types, and get a basic introduction to memory.

---

## What is a Variable?

A variable is a named memory location used to store data.

Example:

```java
int age = 25;
```

Here:

```text
Variable Name : age
Value         : 25
```

---

## Why Do We Need Variables?

Without variables:

```java
System.out.println(25);
```

We cannot reuse the value easily.

Using variables:

```java
int age = 25;
System.out.println(age);
```

makes programs more readable and maintainable.

---

## Variable Declaration

Syntax:

```java
datatype variableName = value;
```

Example:

```java
int age = 25;
```

---

## Data Types

Data types tell Java:

* What kind of data is stored
* How much memory is required

---

## Primitive Data Types

### Integer Types

```java
byte
short
int
long
```

Used for whole numbers.

Example:

```java
int age = 25;
```

---

### Decimal Types

```java
float
double
```

Used for numbers with decimal values.

Example:

```java
double salary = 55000.75;
```

---

### Character Type

```java
char
```

Stores a single character.

Example:

```java
char grade = 'A';
```

---

### Boolean Type

```java
boolean
```

Stores:

```text
true
false
```

Example:

```java
boolean isEligible = true;
```

---

## Variable Naming Rules

Valid:

```java
age
studentName
employeeId
```

Invalid:

```java
1age
student-name
```

---

## Memory Introduction

When a variable is declared:

```java
int age = 25;
```

memory is allocated to store the value.

Conceptually:

```text
age ----> 25
```

Java manages memory automatically.

We will learn more about memory and JVM internals later.

---

## User Input (Introduction)

Programs can also receive values from users.

Example:

```java
Scanner sc = new Scanner(System.in);
```

This allows users to enter values during program execution.

---

## Programs Discussed

1. Area of Rectangle
2. Student Marks Average

Refer to the Programs folder for source code.

---

## Key Takeaways

* Variables are used to store data.
* Data types define the type of information being stored.
* Primitive data types are the basic building blocks of Java.
* Memory is allocated when variables are created.
* Programs can accept input from users.

---

## Homework

1. Calculate Area of Square.
2. Calculate Area of Circle.
3. Calculate Simple Interest.
4. Create variables for:

    * Name
    * Age
    * Salary
    * Grade
      and print them.
