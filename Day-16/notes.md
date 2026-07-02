# Day 16 - Exception Handling (Session 3)

# Exception Hierarchy, Checked vs Unchecked Exceptions, Custom Exceptions, Exception Propagation & Best Practices

## Objective

After completing this session, you should be able to:

* Understand the Java Exception Hierarchy.
* Differentiate between Checked and Unchecked Exceptions.
* Create your own Custom Exceptions.
* Understand the difference between `throw` and `throws`.
* Understand Exception Propagation.
* Follow Exception Handling best practices.

---

# Exception Hierarchy

All exceptions in Java are organized in a hierarchy.

```text
                    Object
                       │
                  Throwable
                 /          \
             Error       Exception
                             │
                    RuntimeException
                     /      |       \
 ArithmeticException  NullPointerException
 ArrayIndexOutOfBoundsException
```

---

## Throwable

`Throwable` is the parent class of everything that can be thrown by the JVM.

Every Exception and Error ultimately inherits from `Throwable`.

---

## Error

Errors represent serious problems that usually occur inside the JVM.

Examples:

* OutOfMemoryError
* StackOverflowError

These are generally **not handled** by application developers.

---

## Exception

Exceptions represent problems that applications are expected to handle.

Examples:

* ArithmeticException
* IOException
* SQLException
* NullPointerException

---

# Checked vs Unchecked Exceptions

Java classifies exceptions into two categories.

---

## Checked Exceptions

Checked Exceptions are verified by the compiler.

The compiler forces the developer to either:

* Handle the exception using `try-catch`
* Declare it using `throws`

Example:

```java
FileReader reader = new FileReader("student.txt");
```

The compiler immediately reports an error because the file may not exist.

Examples of Checked Exceptions:

* IOException
* FileNotFoundException
* SQLException

---

## Unchecked Exceptions

Unchecked Exceptions occur during runtime.

The compiler does not force us to handle them.

Examples:

```java
int result = 10 / 0;
```

```java
String name = null;

System.out.println(name.length());
```

```java
int[] arr = {10,20};

System.out.println(arr[5]);
```

Examples:

* ArithmeticException
* NullPointerException
* ArrayIndexOutOfBoundsException

---

# Checked vs Unchecked

| Checked Exception           | Unchecked Exception          |
| --------------------------- | ---------------------------- |
| Checked by Compiler         | Occurs at Runtime            |
| Must be handled or declared | Handling is optional         |
| Extends Exception           | Extends RuntimeException     |
| Example: IOException        | Example: ArithmeticException |

---

# Why Do We Need Custom Exceptions?

Java already provides many exceptions.

Examples:

* ArithmeticException
* NullPointerException
* IOException

But Java does not know our business rules.

Suppose we are developing a Banking Application.

Current Balance:

```text
₹5000
```

Customer wants to withdraw:

```text
₹10000
```

Question:

Which exception should Java throw?

* ArithmeticException?
* NullPointerException?
* ArrayIndexOutOfBoundsException?

None of these represent the actual business problem.

Instead, we create our own exception.

Example:

```text
InsufficientBalanceException
```

Custom Exceptions make our programs more meaningful and easier to understand.

---

# Creating a Custom Exception

```java
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message){

        super(message);

    }

}
```

---

## Why extends Exception?

By extending `Exception`, our class also becomes an Exception.

The JVM can now treat it exactly like any other Java Exception.

---

## Why super(message)?

The parent `Exception` class already knows how to store:

* Error Message
* Stack Trace
* Exception Information

Using:

```java
super(message);
```

passes the message to the parent class.

---

# Using a Custom Exception

```java
class BankAccount {

    private double balance = 5000;

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if(amount > balance){

            throw new InsufficientBalanceException(
                    "Insufficient Balance");

        }

        balance -= amount;

    }

}
```

---

# throw vs throws

These two keywords have completely different purposes.

## throw

Used to create and throw an Exception object.

Example:

```java
throw new InsufficientBalanceException(
        "Insufficient Balance");
```

Meaning:

The programmer is creating an Exception object and throwing it.

---

## throws

Used in the method declaration.

Example:

```java
public void withdraw()
        throws InsufficientBalanceException
```

Meaning:

This method **may throw** an exception.

It is informing the caller but not handling the exception.

---

# Difference Between throw and throws

| throw                           | throws                                        |
| ------------------------------- | --------------------------------------------- |
| Used inside a method            | Used in method declaration                    |
| Actually throws the Exception   | Declares that a method may throw an Exception |
| Followed by an Exception object | Followed by Exception class names             |

---

# Exception Propagation

Suppose we have four methods.

```java
public class ExceptionPropagationDemo {

    public static void method3() {

        int result = 10 / 0;

    }

    public static void method2() {

        method3();

    }

    public static void method1() {

        method2();

    }

    public static void main(String[] args) {

        method1();

    }

}
```

---

## Execution Flow

The program executes as follows:

```text
main()

↓

method1()

↓

method2()

↓

method3()
```

Inside `method3()`, the following statement throws an exception.

```java
int result = 10 / 0;
```

The JVM creates an `ArithmeticException` object.

---

# What Happens Next?

Question:

Is there a `try-catch` block inside `method3()`?

No.

The JVM moves to the calling method.

```text
method3()

↑

method2()
```

Question:

Is there a `try-catch` block inside `method2()`?

No.

The JVM again moves upward.

```text
method2()

↑

method1()
```

Again,

No matching `catch` block.

The JVM moves to:

```text
main()
```

If `main()` also does not handle the exception, the program terminates.

---

# Definition

> **Exception Propagation** is the process in which an Exception travels from the method where it occurred to its calling methods until it is handled.

---

# Handling the Exception

```java
public static void method1(){

    try{

        method2();

    }
    catch(ArithmeticException e){

        System.out.println("Handled in method1");

    }

}
```

Output

```text
Handled in method1
```

Observation:

The exception occurred in `method3()` but was handled in `method1()`.

Propagation stopped once a matching `catch` block was found.

---

# Visual Representation

Without Handling

```text
main()

↓

method1()

↓

method2()

↓

method3()

↓

ArithmeticException

↑

method2()

↑

method1()

↑

main()

↑

JVM Terminates Program
```

With Handling

```text
main()

↓

method1()

↓

method2()

↓

method3()

↓

ArithmeticException

↑

method2()

↑

method1()

↓

Handled

↓

Remaining Program Continues
```

---

# Relation Between throws and Propagation

```java
public static void method3()
        throws ArithmeticException{

    int result = 10 / 0;

}
```

Meaning:

`method3()` is not handling the exception.

It simply declares that it may throw an exception.

The caller is responsible for handling it.

The same declaration can continue through multiple methods until one method finally handles the exception.

---

# Best Practices

✔ Catch the most specific exception possible.

Good

```java
catch(FileNotFoundException e){

}
```

Avoid using a generic `Exception` unless necessary.

---

✔ Do not ignore exceptions.

Bad Practice

```java
catch(Exception e){

}
```

Always handle or log the exception.

---

✔ Use meaningful error messages.

Example

```java
throw new InvalidAgeException(
        "Age must be 18 or above.");
```

Meaningful messages help users and developers understand the problem.

---

✔ Use Custom Exceptions for Business Rules.

Examples:

* InvalidAgeException
* InsufficientBalanceException
* EmployeeNotFoundException
* InvalidProductException

---

✔ Read Stack Traces Carefully.

Whenever an exception occurs, first identify:

* Exception Type
* Error Message
* Line Number

This is the first step in debugging.

---

# Key Takeaways

* All Exceptions inherit from `Throwable`.
* Checked Exceptions are verified by the compiler.
* Unchecked Exceptions occur during runtime.
* Custom Exceptions represent business-specific problems.
* `throw` creates and throws an Exception object.
* `throws` declares that a method may throw an Exception.
* Exception Propagation allows an exception to travel through the method call stack until it is handled.
* Writing meaningful exceptions makes applications easier to understand and maintain.

---

# Practice Exercises

1. Create a Custom Exception named `InvalidAgeException`.
2. Create a Banking application using `InsufficientBalanceException`.
3. Demonstrate the difference between `throw` and `throws`.
4. Write a program demonstrating Exception Propagation using four methods.
5. Move the `try-catch` block from one method to another and observe how propagation changes.
6. Draw the Exception Hierarchy in your notebook.
7. Write five differences between Checked and Unchecked Exceptions.
