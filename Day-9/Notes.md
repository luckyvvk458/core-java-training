# Day 9 - Arrays Continued

## Objective

Understand additional Array concepts and solve common Array problems using loops and conditional statements.

---

## Recap

In the previous class we learned:

* Why Arrays are needed
* Array Declaration
* Array Initialization
* Array Indexing
* Array Length
* Traversing Arrays
* Sum of Array Elements
* Largest Element in Array

---

## Default Values in Arrays

When an array is created using the new keyword, Java automatically assigns default values.

Example:

```java
int[] numbers = new int[5];
```

Output:

```text
0
0
0
0
0
```

Default Values:

```text
int      -> 0
double   -> 0.0
boolean  -> false
char     -> '\u0000'
String   -> null
```

---

## Array Memory Representation

Example:

```java
int[] arr = {10, 20, 30, 40, 50};
```

Visualization:

```text
Index   0   1   2   3   4
Value  10  20  30  40  50
```

Array elements are stored sequentially and accessed using indexes.

---

## ArrayIndexOutOfBoundsException

Occurs when trying to access an invalid index.

Example:

```java
int[] arr = {10, 20, 30};

System.out.println(arr[3]);
```

Valid indexes:

```text
0
1
2
```

Invalid:

```text
3
```

This results in:

```text
ArrayIndexOutOfBoundsException
```

---

## Updating Elements

Array values can be modified using indexes.

Example:

```java
int[] arr = {10, 20, 30};

arr[1] = 100;
```

Result:

```text
10 100 30
```

---

## Programs Discussed

1. Smallest Element
2. Average of Array Elements
3. Count Even Numbers
4. Count Odd Numbers
5. Linear Search

Refer to Programs folder for source code.

---

## Key Takeaways

* Arrays provide default values.
* Indexes start from 0.
* Accessing invalid indexes causes exceptions.
* Array elements can be updated.
* Loops are commonly used with Arrays.
* Searching is one of the most common Array operations.

---

## Homework

1. Find Second Largest Element.
2. Reverse an Array.
3. Count Positive Numbers.
4. Count Negative Numbers.
5. Find Sum of Even Numbers.
