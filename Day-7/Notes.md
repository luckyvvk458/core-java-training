# Day 7 - Methods

## Objective

Understand how methods help organize code, improve reusability, and make programs easier to maintain.

---

## Why Do We Need Methods?

Consider the following program:

```java
System.out.println("Welcome");
System.out.println("Welcome");
System.out.println("Welcome");
System.out.println("Welcome");
```

The same code is repeated multiple times.

Methods help us:

* Reuse code
* Improve readability
* Reduce duplication
* Simplify maintenance

---

## What is a Method?

A method is a block of code that performs a specific task.

Example:

```java
public static void greet() {
    System.out.println("Welcome");
}
```

Calling:

```java
greet();
```

executes the method.

---

## Real-Life Example

Think of a TV Remote.

Buttons:

```text
Volume Up
Volume Down
Channel Up
Channel Down
```

Each button performs a specific operation.

Similarly, methods perform specific tasks in a program.

---

## Method Syntax

```java
accessModifier static returnType methodName() {

}
```

Example:

```java
public static void greet() {
    System.out.println("Welcome");
}
```

---

## Calling a Method

Defining a method does not execute it.

We must call it.

Example:

```java
greet();
```

---

## Method Without Parameters

Example:

```java
public static void displayMessage() {
    System.out.println("Hello Java");
}
```

Call:

```java
displayMessage();
```

---

## Method With Parameters

Parameters allow methods to receive values.

Example:

```java
public static void add(int a, int b) {
    System.out.println(a + b);
}
```

Call:

```java
add(10, 20);
```

Output:

```text
30
```

---

## Method With Return Type

Sometimes a method needs to return a value.

Example:

```java
public static int add(int a, int b) {
    return a + b;
}
```

Usage:

```java
int result = add(10, 20);
```

---

## Difference Between void and return

### void

Returns nothing.

```java
public static void greet() {

}
```

---

### return

Returns a value.

```java
public static int add(int a, int b) {
    return a + b;
}
```

---

## Method Overloading

Method overloading means:

```text
Same Method Name
Different Parameters
```

Example:

```java
add(int a, int b)
add(int a, int b, int c)
```

The compiler decides which method to execute.

---

## Benefits of Method Overloading

* Better readability
* Reusability
* Cleaner code

---

## Programs Discussed

1. Simple Method
2. Addition Method
3. Method With Parameters
4. Method With Return Type
5. Method Overloading

Refer to the Programs folder for source code.

---

## Key Takeaways

* Methods improve code reusability.
* Methods can accept parameters.
* Methods can return values.
* void means no value is returned.
* Method overloading allows multiple methods with the same name.

---

## Homework

1. Create a method to find the square of a number.
2. Create a method to find the cube of a number.
3. Create a method to check whether a number is even or odd.
4. Create overloaded methods for multiplication.
5. Create a method to find the largest of two numbers.

---

## Interview Questions

1. What is a method?
2. Why are methods important?
3. Difference between parameters and arguments?
4. Difference between void and return?
5. What is method overloading?
6. Can methods have the same name?
7. How does Java identify overloaded methods?
