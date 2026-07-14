# Day 24 – List Interface & ArrayList (Detailed Notes)

# Problem → Solution Learning Notes

## Learning Objectives

After this session you will be able to:

- Explain why `List` is an interface.
- Explain why interfaces cannot be instantiated.
- Explain why Java provides multiple implementations of List.
- Understand the idea of programming to an interface.
- Use ArrayList with the List interface.
- Perform common List operations.

---

# Revision

In the previous class we answered:

**Why was the Collection Framework introduced?**

```
Variables
    ↓
Arrays
    ↓
Collections
```

Arrays solved one problem but introduced others:

- Fixed Size
- Manual resizing
- Costly insertion
- Costly deletion

Java introduced the Collection Framework.

```
                Iterable
                    │
               Collection
        ┌────────┼─────────┐
        │        │         │
      List      Set      Queue

Map (Separate Hierarchy)
```

Today we begin with **List**.

---

# Problem Statement

Yesterday we learned that **List is an interface**.

Question:

Can we write?

```java
List<String> list = new List<>();
```

**No.**

Compilation Error.

### Why?

Because interfaces **cannot be instantiated**.

An interface only tells us **what operations should be available**.

It never tells us **how those operations should be implemented**.

---

# Existing Solution?

Suppose Java had only one implementation.

```java
class MyList {

}
```

Everyone would use

```java
MyList list = new MyList();
```

Looks fine.

Now imagine:

Company A wants faster searching.

Company B wants faster insertion.

Company C wants thread safety.

Should Java force everyone to use the same implementation?

**No.**

---

# Java's Solution

Instead of creating one class, Java first created a **contract**.

```java
public interface List<E> {

    boolean add(E e);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    boolean remove(Object o);

    boolean contains(Object o);

    int size();

    boolean isEmpty();

    void clear();
}
```

Notice carefully.

The interface only specifies **what** every List should do.

It never explains **how** it should do it.

---

# Who Implements List?

```
                    List
                 (Interface)
                      ▲
      ┌───────────────┼────────────────┐
      │               │                │
 ArrayList      LinkedList         Vector
```

Every implementation follows the same contract.

Only the internal implementation changes.

---

# Programming to an Interface

Recommended:

```java
List<String> names = new ArrayList<>();
```

Not

```java
ArrayList<String> names = new ArrayList<>();
```

### Why?

Suppose tomorrow you decide to use LinkedList.

Only one line changes.

```java
List<String> names = new LinkedList<>();
```

All remaining code continues to work.

This is called **Programming to an Interface**.

---

# Real-world Analogy

Think of a TV Remote.

The remote has:

- Power
- Volume +
- Volume –

Every television supports these operations.

Sony, Samsung and LG implement them differently.

The **remote** is like the **List interface**.

The television is like **ArrayList** or **LinkedList**.

---

# Creating an ArrayList

```java
List<String> fruits = new ArrayList<>();
```

Break it down.

```
List<String>
```

Reference Type

```
new ArrayList<>()
```

Actual Object

---

# Program 1 – Adding Elements

```java
import java.util.*;

public class Demo {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        System.out.println(fruits);
    }
}
```

Output

```
[Apple, Banana, Mango]
```

---

# Program 2 – get()

```java
System.out.println(fruits.get(1));
```

Output

```
Banana
```

Indexes start from **0**.

---

# Program 3 – set()

```java
fruits.set(1, "Orange");

System.out.println(fruits);
```

Output

```
[Apple, Orange, Mango]
```

`set()` replaces an existing element.

---

# Program 4 – remove()

```java
fruits.remove("Apple");

System.out.println(fruits);
```

Output

```
[Orange, Mango]
```

Remove using index.

```java
fruits.remove(0);
```

Explain that `remove()` is overloaded.

---

# Program 5 – contains()

```java
System.out.println(
        fruits.contains("Mango"));
```

Output

```
true
```

---

# Program 6 – size()

```java
System.out.println(
        fruits.size());
```

Output

```
2
```

---

# Program 7 – Traversing

Using for-each.

```java
for(String fruit : fruits){

    System.out.println(fruit);

}
```

Using normal loop.

```java
for(int i=0;i<fruits.size();i++){

    System.out.println(fruits.get(i));

}
```

---

# High Level Internal Working

```
ArrayList

↓

Uses an Internal Array

↓

Array becomes full

↓

Creates Bigger Array

↓

Copies Existing Elements

↓

Continues Adding Elements
```

Detailed resizing will be covered in the next class.

---

# Summary Table

| Method | Purpose |
|---------|---------|
| add() | Add element |
| add(index,e) | Insert element |
| get() | Read element |
| set() | Replace element |
| remove() | Delete element |
| contains() | Search |
| size() | Number of elements |
| clear() | Remove all elements |
| isEmpty() | Check whether empty |

---

# Best Practices

- Prefer `List` as the reference type.
- Use Generics.
- Avoid raw collections.
- Choose implementation based on the requirement.

---

# Practice Programs

## Program 1

Store five student names.

## Program 2

Replace the third student.

## Program 3

Delete the first student.

## Program 4

Check whether "Rahul" exists.

## Program 5

Print all students using both loops.

## Program 6

Create a List<Integer> and find the sum.

## Program 7

Store Employee objects inside an ArrayList and print them.

---

# Interview Questions

1. Why is List an interface?
2. Why can't we instantiate List?
3. Why does Java provide multiple implementations?
4. What is programming to an interface?
5. Difference between add() and set()?
6. Difference between remove(int) and remove(Object)?
7. Why use List instead of ArrayList as the reference?
8. Name classes implementing List.
9. Does ArrayList allow duplicates?
10. Does ArrayList maintain insertion order?

---

# Tomorrow

Internal Working of ArrayList

- Capacity
- Size
- Dynamic Resizing
- Time Complexity
- Why ArrayList is fast for get() and slower for insert/delete.
