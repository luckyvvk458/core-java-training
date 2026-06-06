# Day 8 - Arrays Basics

## Objective

Understand why Arrays are needed, how they store data, and how to access and traverse array elements.

---

## Why Do We Need Arrays?

Consider storing marks of students using variables:

```java
int mark1 = 80;
int mark2 = 75;
int mark3 = 90;
int mark4 = 85;
int mark5 = 95;
```

What if there are 100 students?

Creating 100 variables is difficult to manage.

Arrays solve this problem by allowing us to store multiple values of the same type together.

---

## What is an Array?

An Array is a collection of elements of the same data type stored together.

Example:

```java
int[] marks = {80, 75, 90, 85, 95};
```

Visualization:

```text
Index   0   1   2   3   4
Value  80  75  90  85  95
```

---

## Important Characteristics

* Stores multiple values of the same type.
* Fixed size.
* Elements are accessed using index.
* Index starts from 0.

---

## Array Declaration

```java
int[] marks;
```

---

## Array Creation

```java
marks = new int[5];
```

This creates an array of size 5.

Default values:

```text
int      → 0
double   → 0.0
boolean  → false
char     → '\u0000'
```

---

## Array Initialization

### Method 1

```java
int[] marks = {80, 75, 90, 85, 95};
```

### Method 2

```java
int[] marks = new int[5];

marks[0] = 80;
marks[1] = 75;
marks[2] = 90;
marks[3] = 85;
marks[4] = 95;
```

---

## Accessing Elements

```java
System.out.println(marks[0]);
```

Output:

```text
80
```

---

## Updating Elements

```java
marks[1] = 100;
```

Updated Array:

```text
80 100 90 85 95
```

---

## Array Length

```java
marks.length
```

Returns:

```text
5
```

---

## Traversing an Array

Instead of:

```java
System.out.println(marks[0]);
System.out.println(marks[1]);
System.out.println(marks[2]);
```

Use a loop:

```java
for(int i = 0; i < marks.length; i++) {
    System.out.println(marks[i]);
}
```

---

## Dry Run

```java
for(int i = 0; i < marks.length; i++)
```

| i | Output |
| - | ------ |
| 0 | 80     |
| 1 | 75     |
| 2 | 90     |
| 3 | 85     |
| 4 | 95     |

---

## Programs Discussed

1. Print Array Elements
2. Sum of Array Elements
3. Largest Element in Array

Refer to Programs folder for source code.

---

## Key Takeaways

* Arrays store multiple values of the same type.
* Array indexing starts from 0.
* Arrays have fixed size.
* Use .length to get array size.
* Loops are commonly used to traverse arrays.

---

## Homework

1. Find Average of Array Elements.
2. Find Smallest Element in Array.
3. Count Even Numbers in Array.
4. Count Odd Numbers in Array.
5. Reverse an Array.
