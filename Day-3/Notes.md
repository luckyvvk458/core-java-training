# Day 3 - First Java Program

## Objective

Understand the structure of a Java program, the role of the main() method, and how Java programs are compiled and executed.

---

## Topics Covered

### Structure of Java Program

A Java program consists of:

* Class
* Methods
* Statements

Example:

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Java");

    }
}
```

---

## Understanding Class

A class is a blueprint used to create objects.

Example:

```java
public class Main {
}
```

Here:

```text
Main
```

is the class name.

---

## Understanding main() Method

Execution of every Java application starts from:

```java
public static void main(String[] args)
```

The JVM searches for this method and starts execution from here.

---

## Breakdown of main()

### public

Allows JVM to access the method.

### static

Allows JVM to invoke the method without creating an object.

### void

Method does not return any value.

### main

Entry point of the application.

### String[] args

Used to receive command-line arguments.

---

## Compilation and Execution Flow

### Compilation

```text
Main.java
    ↓
javac
    ↓
Main.class
```

---

### Execution

```text
Main.class
    ↓
JVM
    ↓
Output
```

---

## Platform Independence

Java source code is compiled into bytecode.

The JVM converts bytecode into machine code suitable for the operating system.

```text
Java Code
    ↓
Compiler
    ↓
Bytecode
    ↓
JVM
    ↓
Operating System
```

This enables:

```text
Write Once Run Anywhere (WORA)
```

---

## Programs Discussed

1. Sum of Two Numbers
2. Calculator Program

Refer to the Programs folder for source code.

---

## Key Takeaways

* Every Java application starts from main().
* Java source code is converted into bytecode.
* JVM executes bytecode.
* Java achieves platform independence using JVM.
* A class acts as a container for methods and data.

---

## Homework

1. Modify the Sum program with different values.
2. Add modulus (%) operation to Calculator.
3. Explain each keyword in the main() method.
