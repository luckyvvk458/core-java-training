# Day 10 - Arrays Problem Solving

## Objective

Strengthen Array concepts through problem solving and learn a new way to traverse arrays using the Enhanced For Loop.

---

## Recap

Previously we learned:

* Array Declaration
* Array Initialization
* Array Traversal
* Sum of Elements
* Largest Element
* Smallest Element
* Average of Elements
* Linear Search

---

## Enhanced For Loop

Java provides a simplified way to traverse arrays.

Traditional Loop:

```java
for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

Enhanced For Loop:

```java
for(int num : arr) {
    System.out.println(num);
}
```

---

## Syntax

```java
for(dataType variable : array) {

}
```

Example:

```java
int[] numbers = {10, 20, 30};

for(int num : numbers) {
    System.out.println(num);
}
```

---

## Advantages

* Easy to write
* Improves readability
* No index management

---

## Limitations

* Cannot directly access indexes
* Not suitable when index is required

---

## Reverse Array

Problem:

```text
Input:
10 20 30 40 50

Output:
50 40 30 20 10
```

Approach:

Start from the last index and move backwards.

```java
for(int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

---

## Second Largest Element

Problem:

```text
Input:
10 50 20 90 40

Output:
50
```

Approach:

Maintain:

```java
largest
secondLargest
```

Update them while traversing the array.

---

## Copy Array

Problem:

Create a duplicate array.

Example:

```text
Source:
10 20 30 40 50

Destination:
10 20 30 40 50
```

Approach:

Copy element by element using a loop.

---

## Programs Discussed

1. Enhanced For Loop Example
2. Reverse Array
3. Second Largest Element
4. Copy Array

Refer to Programs folder for source code.

---

## Key Takeaways

* Enhanced For Loop simplifies traversal.
* Reverse traversal starts from the last index.
* Second Largest is a common interview problem.
* Arrays can be copied using loops.
* Problem solving improves understanding of arrays.

---

## Homework

1. Find Second Smallest Element.
2. Find Sum of Even Numbers.
3. Find Sum of Odd Numbers.
4. Reverse Array using another array.
5. Count Positive and Negative Numbers.
