# Day 15 - Exception Handling (Session 2)

## Objective

After completing this session, you should be able to:

* Understand how Java handles multiple exceptions.
* Learn how multiple `catch` blocks work.
* Use the Exception object to obtain useful debugging information.
* Understand the purpose of the `finally` block.
* Write programs that handle exceptions more effectively.

---

# Quick Revision

Before learning new concepts, let's recall what we learned in the previous session.

We learned that:

* Exceptions occur during program execution.
* Unhandled exceptions terminate the program.
* Java creates an Exception object whenever an exception occurs.
* The JVM searches for a matching `catch` block.
* If a matching `catch` block is found, the exception is handled and the remaining program continues.

---

# Can One Program Throw Multiple Exceptions?

Consider the following program.

```java
public class MultipleExceptionsDemo {

    public static void main(String[] args) {

        String name = null;

        int[] numbers = {10, 20, 30};

        int result = 10 / 0;

        System.out.println(name.length());

        System.out.println(numbers[5]);
    }
}
```

## Think Before Running

Question:

How many possible exceptions exist in this program?

Answer:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
```

Now think again.

Will all three exceptions occur?

Most beginners expect all three exceptions to occur.

Run the program and observe the output.

Only one exception is thrown.

---

# Why Does Only One Exception Occur?

Java executes statements sequentially.

Execution Flow

```text
Statement 1
      ↓
Statement 2
      ↓
Statement 3
      ↓
Exception Occurs
      ↓
Program Stops
```

As soon as an unhandled exception occurs, the JVM immediately stops executing the remaining statements.

Therefore:

* `NullPointerException` is never reached.
* `ArrayIndexOutOfBoundsException` is never reached.

Only the first exception is thrown.

This is an important concept in Java.

---

# Handling Different Types of Exceptions

Suppose our application can generate different kinds of exceptions.

Instead of writing only one catch block, Java allows us to write multiple catch blocks.

Example:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception Handled");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Array Exception Handled");

}
catch (NullPointerException e) {

    System.out.println("Null Exception Handled");

}
```

Output

```text
Arithmetic Exception Handled
```

Observation

The JVM executes only the matching catch block.

The remaining catch blocks are skipped.

---

# Another Example

```java
try {

    int[] numbers = {10,20};

    System.out.println(numbers[5]);

}
catch (ArithmeticException e){

    System.out.println("Arithmetic Exception");

}
catch (ArrayIndexOutOfBoundsException e){

    System.out.println("Array Exception");

}
catch (NullPointerException e){

    System.out.println("Null Exception");

}
```

Output

```text
Array Exception
```

The JVM compares the generated exception with each catch block from top to bottom until a matching catch block is found.

---

# How the JVM Searches for a Matching catch Block

Suppose the following exception occurs.

```text
ArithmeticException
```

The JVM checks the catch blocks one by one.

```text
catch(ArithmeticException)
        ↓
Match Found
        ↓
Execute this catch Block
        ↓
Skip Remaining catch Blocks
```

If the first catch block does not match, the JVM continues searching.

```text
ArithmeticException
        ↓
catch(NullPointerException)
        ↓
No Match
        ↓
catch(ArrayIndexOutOfBoundsException)
        ↓
No Match
        ↓
catch(ArithmeticException)
        ↓
Match Found
```

---

# What Happens If No catch Block Matches?

Consider the following example.

```java
try {

    int result = 10 / 0;

}
catch (NullPointerException e){

    System.out.println("Handled");

}
```

Question:

Will this exception be handled?

Answer:

No.

Reason:

The JVM created an `ArithmeticException` object.

The program only provides a `NullPointerException` catch block.

Since no matching catch block exists, the program terminates.

---

# The Exception Object

In the previous session, we learned that Java creates an Exception object whenever an exception occurs.

Example:

```java
catch (ArithmeticException e)
```

Here,

```text
e
```

is a reference variable pointing to the Exception object created by the JVM.

This object stores useful debugging information.

Such as:

* Exception Type
* Error Message
* Stack Trace

We can use this object to understand the problem more effectively.

---

# Useful Methods of the Exception Object

## getMessage()

Returns only the reason for the exception.

Example:

```java
try {

    int result = 10 / 0;

}
catch (Exception e){

    System.out.println(e.getMessage());

}
```

Output

```text
/ by zero
```

---

## toString()

Returns the exception type along with the message.

Example:

```java
System.out.println(e);
```

Output

```text
java.lang.ArithmeticException: / by zero
```

---

## printStackTrace()

Displays the complete stack trace.

Example:

```java
e.printStackTrace();
```

Output

```text
java.lang.ArithmeticException: / by zero
    at ExceptionDemo.main(ExceptionDemo.java:8)
```

Developers frequently use this method while debugging applications.

---

# The finally Block

Sometimes we have code that must execute whether an exception occurs or not.

Examples:

* Closing a file
* Closing a database connection
* Closing a network connection
* Releasing system resources

Java provides the `finally` block for such situations.

Example:

```java
try {

    int result = 10 / 0;

}
catch (ArithmeticException e){

    System.out.println("Arithmetic Exception Handled");

}
finally{

    System.out.println("Finally Block Executed");

}
```

Output

```text
Arithmetic Exception Handled
Finally Block Executed
```

Observation

The `finally` block executes after the `try` and `catch` blocks.

---

# finally Without an Exception

```java
try {

    System.out.println("Inside Try");

}
finally {

    System.out.println("Inside Finally");

}
```

Output

```text
Inside Try
Inside Finally
```

Even when no exception occurs, the `finally` block executes.

---

# Why Do We Use finally?

The `finally` block is generally used for cleanup activities.

Examples include:

* Closing files
* Closing database connections
* Closing sockets
* Closing input/output streams
* Releasing system resources

Using `finally` helps prevent resource leaks.

---

# Predict the Output

Example 1

```java
try {

    System.out.println("A");

    int result = 10 / 0;

    System.out.println("B");

}
catch (ArithmeticException e){

    System.out.println("C");

}

System.out.println("D");
```

Output

```text
A
C
D
```

Reason:

* "A" executes successfully.
* Exception occurs.
* "B" is skipped.
* Matching catch block executes.
* Remaining statements continue.

---

Example 2

```java
try {

    System.out.println("Hello");

}
finally {

    System.out.println("Goodbye");

}
```

Output

```text
Hello
Goodbye
```

---

# Summary

During this session, we learned:

* A program may contain multiple possible exceptions.
* Only the first unhandled exception is thrown.
* Java supports multiple `catch` blocks.
* The JVM searches for a matching `catch` block.
* The Exception object contains useful debugging information.
* `getMessage()`, `toString()`, and `printStackTrace()` help developers identify problems.
* The `finally` block is used for cleanup activities and executes after the `try`/`catch` blocks.

---

# Key Takeaways

* Programs execute sequentially.
* The JVM stops at the first unhandled exception.
* Only one matching `catch` block executes.
* The Exception object provides detailed information about the error.
* The `finally` block is commonly used for resource cleanup.
* Exception handling makes applications more robust and user-friendly.

---

# Practice Exercises

1. Write a program using three different `catch` blocks.
2. Print the exception message using `getMessage()`.
3. Print the complete stack trace using `printStackTrace()`.
4. Display the exception using `toString()`.
5. Write a program demonstrating the use of a `finally` block.
6. Predict the output of different `try-catch-finally` programs before executing them.
7. Create a calculator program that handles invalid arithmetic operations gracefully.
