# Day 5 - Operators and Conditional Statements

## Objective

Understand how Java programs perform calculations, compare values, and make decisions using conditional statements.

---

## What are Operators?

Operators are special symbols used to perform operations on variables and values.

Example:

```java
int sum = 10 + 20;
```

Here:

```text
+
```

is an operator.

---

## Types of Operators

### Arithmetic Operators

Used for mathematical calculations.

| Operator | Description    |
| -------- | -------------- |
| +        | Addition       |
| -        | Subtraction    |
| *        | Multiplication |
| /        | Division       |
| %        | Modulus        |

Example:

```java
int a = 10;
int b = 3;

System.out.println(a + b);
System.out.println(a % b);
```

---

### Relational Operators

Used to compare values.

| Operator | Description              |
| -------- | ------------------------ |
| ==       | Equal To                 |
| !=       | Not Equal To             |
| >        | Greater Than             |
| <        | Less Than                |
| >=       | Greater Than or Equal To |
| <=       | Less Than or Equal To    |

Example:

```java
System.out.println(10 > 5);
```

Output:

```text
true
```

---

### Logical Operators

Used to combine multiple conditions.

| Operator | Description |   |    |
| -------- | ----------- | - | -- |
| &&       | AND         |   |    |
|          |             |   | OR |
| !        | NOT         |   |    |

Example:

```java
age >= 18 && citizen == true
```

---

## Conditional Statements

Conditional statements help programs make decisions.

---

## if Statement

Syntax:

```java
if(condition) {
    // statements
}
```

Example:

```java
if(age >= 18) {
    System.out.println("Eligible");
}
```

---

## if-else Statement

Syntax:

```java
if(condition) {
    // statements
}
else {
    // statements
}
```

Example:

```java
if(age >= 18) {
    System.out.println("Major");
}
else {
    System.out.println("Minor");
}
```

---

## else-if Ladder

Used when multiple conditions need to be checked.

Example:

```java
if(marks >= 90) {
    System.out.println("A Grade");
}
else if(marks >= 75) {
    System.out.println("B Grade");
}
else {
    System.out.println("C Grade");
}
```

---

## Programs Discussed

1. Even or Odd Number
2. Positive or Negative Number
3. Major or Minor
4. Voting Eligibility
5. Largest of Two Numbers
6. Largest of Three Numbers

Refer to the Programs folder for source code.

---

## Key Takeaways

* Operators perform calculations and comparisons.
* Relational operators return boolean values.
* Logical operators combine conditions.
* if statements help programs make decisions.
* else-if ladders are useful for multiple conditions.

---

## Homework

1. Grade Calculator
2. Leap Year Program
3. Simple Calculator using switch
4. Find Smallest of Two Numbers
5. Find Smallest of Three Numbers

---

## Interview Questions

1. What is the difference between == and = ?
2. What is the modulus (%) operator?
3. Difference between && and || ?
4. When should we use if-else?
5. What is an else-if ladder?
6. How do you find the largest of three numbers?
