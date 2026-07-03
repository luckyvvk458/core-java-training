# Day 17 - Exception Handling Recap & Exception Propagation

## Objective

After completing this session, you should be able to:

* Revise all Exception Handling concepts learned so far.
* Understand the complete lifecycle of an Exception.
* Strengthen your understanding of Exception Propagation.
* Solve real-world Exception Handling problems with confidence.

---

# Session Overview

This session is primarily a revision session.

During this session, we will:

* Revise all concepts covered in Exception Handling.
* Complete the remaining discussion on Exception Propagation.
* Practice additional hands-on examples.
* Clarify doubts before moving to the Collections Framework.

---

# Quick Revision

During the previous sessions, we learned:

## Session 1

* Why Exception Handling is required
* What is an Exception?
* Stack Trace
* Runtime Exceptions
* try block
* catch block
* Exception Object
* Internal working of try-catch

---

## Session 2

* Multiple Exceptions
* Multiple catch blocks
* Exception Object methods

    * getMessage()
    * toString()
    * printStackTrace()
* finally block
* Execution Flow

---

## Session 3

* Exception Hierarchy
* Checked vs Unchecked Exceptions
* Custom Exceptions
* throw
* throws
* Exception Propagation
* Best Practices

---

# Complete Lifecycle of an Exception

Whenever an exception occurs, the JVM performs the following steps.

```text
Program Starts
        ↓
Execute Statements
        ↓
Unexpected Problem Occurs
        ↓
JVM Creates Exception Object
        ↓
Current try Block Exists?
        ↓
Yes
        ↓
Matching catch Block Found?
        ↓
Yes
        ↓
Execute catch Block
        ↓
Continue Remaining Program
```

If no matching catch block is found:

```text
Current Method
        ↓
Caller Method
        ↓
Caller Method
        ↓
main()
        ↓
JVM Terminates Program
```

This process is called **Exception Propagation**.

---

# Revisiting Exception Propagation

Consider the following program.

```java
public class ExceptionPropagationDemo {

    static void method3() {

        int result = 10 / 0;

    }

    static void method2() {

        method3();

    }

    static void method1() {

        method2();

    }

    public static void main(String[] args) {

        method1();

    }

}
```

---

## Execution Flow

```text
main()

↓

method1()

↓

method2()

↓

method3()
```

Inside `method3()`, the exception occurs.

Since there is no `try-catch` block inside `method3()`, the JVM looks for a handler in the calling method.

```text
method3()

↑

method2()
```

Still no handler.

The JVM continues searching.

```text
method2()

↑

method1()
```

Still no handler.

The JVM continues searching.

```text
method1()

↑

main()
```

If `main()` also does not handle the exception, the JVM terminates the program.

---

# Handling the Exception in Different Methods

One of the important observations is that the exception does **not** have to be handled where it occurs.

Example:

Exception occurs inside:

```text
method3()
```

It may be handled in:

```text
method2()
```

or

```text
method1()
```

or

```text
main()
```

Once the exception is handled, propagation stops.

---

# Relation Between throw, throws and Propagation

Suppose a method declares:

```java
public void withdraw()
        throws InsufficientBalanceException
```

This does **not** throw the exception.

It simply informs the caller that this method **may throw** an exception.

When the exception actually occurs:

```java
throw new InsufficientBalanceException(
        "Insufficient Balance");
```

The exception is created and thrown.

If the current method does not handle it, the exception propagates to its caller.

---

# Hands-on Activities

During this session, practice the following programs again.

### Program 1

ArithmeticException

Observe:

* Stack Trace
* Exception Object
* Program Termination

---

### Program 2

Multiple catch Blocks

Observe:

* Matching catch block
* Remaining catch blocks are skipped

---

### Program 3

finally Block

Observe:

* finally executes even when an exception occurs.

---

### Program 4

Custom Exception

Observe:

* Creation of Custom Exception
* throw
* throws
* try-catch

---

### Program 5

Exception Propagation

Move the `try-catch` block between different methods.

Observe:

* Where the exception occurs.
* Where it is handled.
* Where propagation stops.

---

# Best Practices (Revision)

Follow these best practices while writing Exception Handling code.

✔ Catch the most specific exception possible.

✔ Do not ignore exceptions.

✔ Display meaningful error messages.

✔ Use Custom Exceptions for business-specific problems.

✔ Read the stack trace carefully before fixing the problem.

✔ Use finally (or try-with-resources in modern Java) for resource cleanup.

---

# Common Interview Questions (Revision)

* What is an Exception?
* Why do we need Exception Handling?
* Difference between Error and Exception.
* Difference between Checked and Unchecked Exceptions.
* Difference between throw and throws.
* What is a Custom Exception?
* Why do we create Custom Exceptions?
* Explain Exception Propagation.
* What happens if no matching catch block is found?
* Explain the complete lifecycle of an Exception.

---

# Key Takeaways

* Exceptions interrupt the normal flow of program execution.
* The JVM creates an Exception object whenever an exception occurs.
* The JVM searches for a matching catch block.
* If no handler is found, the exception propagates to the calling method.
* Propagation continues until a matching handler is found or the program terminates.
* Custom Exceptions help represent business-specific problems.
* Understanding the execution flow is more important than memorizing the syntax.

---

# Practice Exercises

1. Explain the complete lifecycle of an Exception using a diagram.
2. Create a program demonstrating Exception Propagation across four methods.
3. Move the `try-catch` block between different methods and observe where propagation stops.
4. Create a Custom Exception for a real-world scenario (for example, `InvalidAgeException` or `InsufficientBalanceException`).
5. Explain the difference between `throw` and `throws` with examples.
6. Revise all programs from Day 14, Day 15, and Day 16 before starting the Collections Framework.

---

# What's Next?

In the next module, we will begin the **Collections Framework**, where we will learn:

* Why Collections are needed
* Limitations of Arrays
* Collection Hierarchy
* List, Set, Queue and Map
* Common Collection implementations such as ArrayList, LinkedList, HashSet, TreeSet, PriorityQueue, and HashMap

The concepts learned in Exception Handling will continue to be useful as we build more complex Java applications.
