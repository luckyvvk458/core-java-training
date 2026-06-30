# Day 14 - Exception Handling (Session 1)

## Objective

After completing this session, you should be able to:

* Understand why Exception Handling is required.
* Understand what an Exception is.
* Read and analyze a Java stack trace.
* Handle runtime exceptions using `try-catch`.
* Understand what happens internally when an exception occurs.
* Understand how the JVM creates an Exception object and transfers control to a matching `catch` block.

---

# Introduction

Until now, every program we have written assumed that everything would work correctly.

For example:

* The user enters valid input.
* Arrays are accessed using valid indexes.
* Strings are never null.
* Numbers are always divided by non-zero values.

But in real-world applications, these assumptions are not always true.

Users make mistakes.

Files may not exist.

Servers may become unavailable.

Database connections may fail.

If our application terminates whenever one of these situations occurs, it will not provide a good user experience.

Java provides **Exception Handling** to deal with such situations gracefully.

---

# Why Do We Need Exception Handling?

Consider a Calculator application.

The user enters:

```text
Number 1 : 10
Number 2 : 0
Operation : Divide
```

Think about this situation.

Should the application:

Option 1

```text
Terminate Immediately
```

Option 2

```text
Return an incorrect value
```

Option 3

```text
Ignore the error and continue
```

Option 4

```text
Inform the user about the problem and continue execution
```

The fourth option is the most appropriate.

This is exactly what Exception Handling helps us achieve.

---

# Program Without Exception Handling

```java
public class Calculator {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println(result);

        System.out.println("Program Completed");
    }
}
```

Output

```text
Exception in thread "main"
java.lang.ArithmeticException: / by zero
    at Calculator.main(Calculator.java:8)
```

Observation

* The program terminates immediately.
* The remaining statements are not executed.
* The JVM stops the normal execution of the program.

Notice that the following statement is never executed.

```java
System.out.println("Program Completed");
```

---

# Analyze the Problem

Before learning Exception Handling, always identify the problem.

Question 1

Which statement caused the exception?

```java
int result = a / b;
```

Question 2

Why did it fail?

Because the denominator is zero.

Question 3

Why didn't the remaining statements execute?

Because Java encountered a situation that prevented it from continuing the normal execution of the program.

---

# What is an Exception?

During program execution, unexpected situations may occur.

Examples include:

* Dividing by zero
* Accessing an invalid array index
* Calling a method on a null object
* Opening a file that does not exist
* Connecting to a database that is unavailable

Java represents these unexpected situations as **Exceptions**.

Definition

> An Exception is an event that occurs during the execution of a program and interrupts the normal flow of program execution.

Example

```text
Division by Zero
        ↓
ArithmeticException
        ↓
Normal Execution Stops
```

---

# Are Exceptions Always Programming Mistakes?

No.

Many exceptions occur because of external conditions.

Examples:

* User enters invalid data.
* Internet connection is lost.
* File is missing.
* Database server is unavailable.

Exception Handling allows us to respond appropriately instead of terminating the application.

---

# Understanding the Stack Trace

Whenever a program terminates because of an exception, Java prints a stack trace.

Example

```text
Exception in thread "main"
java.lang.ArithmeticException: / by zero
    at Calculator.main(Calculator.java:8)
```

Understanding each part:

### Exception in thread "main"

The exception occurred while executing the `main()` method.

---

### ArithmeticException

This is the type of exception.

---

### / by zero

This is the reason for the exception.

---

### Calculator.java:8

This is the exact line where the exception occurred.

Whenever your Java program crashes, first identify:

1. Exception Type
2. Error Message
3. Line Number

This is the first step in debugging any Java application.

---

# What is Exception Handling?

Exception Handling is the mechanism provided by Java to handle runtime problems gracefully and continue the execution of the remaining program whenever possible.

The most commonly used keywords are:

```text
try
catch
```

---

# Program Using try-catch

```java
public class Calculator {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        try {

            int result = a / b;

            System.out.println(result);

        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero.");

        }

        System.out.println("Program Completed");
    }
}
```

Output

```text
Cannot divide by zero.
Program Completed
```

Observation

The program continues executing even after the exception occurs.

---

# Internal Working of Exception Handling

Understanding the execution flow is more important than memorizing the syntax.

## Step 1

The JVM starts executing the statements inside the `try` block.

```text
Enter try Block
        ↓
Statement 1
        ↓
Statement 2
        ↓
Statement 3
```

---

## Step 2

While executing the statement:

```java
int result = a / b;
```

the JVM detects:

```text
Division by Zero
```

The JVM cannot continue executing that statement.

---

## Step 3

The JVM creates an Exception Object.

In this example:

```text
ArithmeticException Object
```

This object contains important information such as:

* Exception Type
* Error Message
* Line Number
* Stack Trace

This object is referenced inside the catch block.

```java
catch (ArithmeticException e)
```

Here,

```text
e
```

is simply a reference variable pointing to the Exception object created by the JVM.

---

# Visual Representation

```text
+----------------------------------+

ArithmeticException Object

Type        : ArithmeticException

Message     : / by zero

Line Number : 8

Stack Trace : Available

+----------------------------------+
```

---

## Step 4

The JVM immediately stops executing the remaining statements inside the `try` block.

Example

```java
try{

    System.out.println("A");

    int result = 10 / 0;

    System.out.println("B");

}
```

Question

Will "B" be printed?

Answer

No.

Once an exception occurs, the remaining statements inside the `try` block are skipped.

---

## Step 5

The JVM starts searching for a matching `catch` block.

Example

```java
catch (ArithmeticException e)
```

If the generated exception is also an `ArithmeticException`, then this catch block is executed.

---

# Matching catch Block

The exception type and the catch type must match.

Example

```java
try{

    int result = 10 / 0;

}
catch (NullPointerException e){

    System.out.println("Handled");

}
```

Question

Will this exception be handled?

Answer

No.

Reason

The JVM created an:

```text
ArithmeticException
```

but only found a:

```text
NullPointerException
```

Since no matching catch block exists, the program terminates.

---

# Execution Flow

Without Exception Handling

```text
Program Starts
        ↓
Statement 1
        ↓
Exception Occurs
        ↓
Program Terminates
```

With Exception Handling

```text
Program Starts
        ↓
Enter try Block
        ↓
Statement Executes
        ↓
Exception Occurs
        ↓
JVM Creates Exception Object
        ↓
JVM Searches for Matching catch Block
        ↓
Matching catch Block Found
        ↓
catch Block Executes
        ↓
Remaining Program Continues
```

---

# Hands-on Example 1

## ArithmeticException

```java
int result = 10 / 0;
```

Handle using:

```java
try{
    int result = 10 / 0;
}
catch(ArithmeticException e){
    System.out.println("Cannot divide by zero.");
}
```

---

# Hands-on Example 2

## ArrayIndexOutOfBoundsException

```java
int[] numbers = {10,20,30};

System.out.println(numbers[5]);
```

Handle using:

```java
try{
    System.out.println(numbers[5]);
}
catch(ArrayIndexOutOfBoundsException e){
    System.out.println("Invalid Array Index.");
}
```

---

# Hands-on Example 3

## NullPointerException

```java
String name = null;

System.out.println(name.length());
```

Handle using:

```java
try{
    System.out.println(name.length());
}
catch(NullPointerException e){
    System.out.println("String reference is null.");
}
```

---

# Predict the Output

Program

```java
try{

    System.out.println("A");

    int result = 10 / 0;

    System.out.println("B");

}
catch(ArithmeticException e){

    System.out.println("C");

}

System.out.println("D");
```

Before executing the program, try to predict the output.

Correct Output

```text
A
C
D
```

Reason

* "A" executes successfully.
* Exception occurs.
* "B" is skipped.
* Matching catch block executes.
* Remaining statements continue executing.

---

# Runtime Exceptions Learned Today

| Situation               | Exception                      |
| ----------------------- | ------------------------------ |
| Division by Zero        | ArithmeticException            |
| Invalid Array Index     | ArrayIndexOutOfBoundsException |
| Accessing a Null Object | NullPointerException           |

---

# Key Takeaways

* Exceptions occur during program execution.
* Exceptions interrupt the normal flow of execution.
* Unhandled exceptions terminate the program.
* Java creates an Exception object whenever an exception occurs.
* The JVM searches for a matching `catch` block.
* If a matching `catch` block is found, the exception is handled.
* After handling the exception, the remaining program continues executing.
* Always read the Exception Type, Error Message, and Line Number while debugging.

---

# Practice Exercises

1. Write a program that handles `ArithmeticException`.
2. Write a program that handles `ArrayIndexOutOfBoundsException`.
3. Write a program that handles `NullPointerException`.
4. Predict the output of different `try-catch` programs before executing them.
5. Draw the internal execution flow of Exception Handling in your notebook.
