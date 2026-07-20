# LinkedList & Vector

## Introduction

In the previous chapter, you learned about **ArrayList**, one of the most commonly used implementations of the `List` interface in the Java Collections Framework.

`ArrayList` is an excellent choice for storing and accessing collections of data dynamically. It provides fast random access to elements and is easy to use in most applications.

However, no single data structure is suitable for every problem. As applications become larger and more complex, certain operations performed on an `ArrayList` become inefficient.

This chapter introduces two more implementations of the `List` interface:

- **LinkedList**
- **Vector**

By the end of this chapter, you will understand why these implementations were introduced, how they work internally, and when each one should be used in real-world applications.

---

# Learning Objectives

After completing this chapter, you will be able to:

- Explain why `LinkedList` was introduced.
- Understand the limitations of `ArrayList`.
- Describe the internal structure of a `LinkedList`.
- Compare `ArrayList`, `LinkedList`, and `Vector`.
- Select the appropriate implementation based on application requirements.

---

# Revisiting ArrayList

Before learning about `LinkedList`, let us quickly recall what you already know.

The Java Collections Framework provides several interfaces and classes to store and manipulate groups of objects.

One of the most important interfaces is the **List** interface, which represents an ordered collection of elements.

One implementation of this interface is `ArrayList`.

The relationship can be represented as follows:

```
Collection
     │
     ▼
    List
     ▲
     │
 ArrayList
```

`ArrayList` stores its elements inside a **dynamic array**, allowing the collection to grow automatically when more elements are added.

For many applications, this is an excellent solution because elements can be accessed quickly using their index.

For example:

```java
List<String> students = new ArrayList<>();
```

Although `ArrayList` is widely used, it is important to understand that it is **not the best choice for every situation**.

---

# Why Isn't ArrayList Enough?

Consider an employee management system that stores information about **100,000 employees**.

Suppose a new employee joins the company and must be inserted near the beginning of the list.

The following operation appears simple:

```java
employees.add(5, newEmployee);
```

From the programmer's perspective, only one employee is being inserted.

However, internally, something very different happens.

Assume the current list looks like this:

```
Index

0    1    2    3    4    5

A    B    C    D    E    F
```

Now insert a new employee **X** at index **2**.

The final result becomes:

```
Index

0    1    2    3    4    5    6

A    B    X    C    D    E    F
```

At first glance, this looks straightforward.

Unfortunately, the insertion is not as simple as it appears.

---

# Understanding the Problem

Since an `ArrayList` stores its elements inside an array, every element occupies a fixed position.

When an element is inserted in the middle of the array, Java cannot simply overwrite the existing element.

Instead, every element after the insertion point must be moved one position to the right.

The internal process looks like this:

```
Before Insertion

A    B    C    D    E    F
          ↑
      Insert X
```

Step 1

```
Move F

Move E

Move D

Move C
```

Step 2

```
A    B    X    C    D    E    F
```

This operation is known as **element shifting**.

The larger the collection becomes, the more elements must be shifted.

For example:

- A list containing 10 elements requires only a few shifts.
- A list containing 10,000 elements requires thousands of shifts.
- A list containing 1,000,000 elements may require moving almost the entire collection.

As the number of elements increases, the insertion operation becomes increasingly expensive.

The same issue occurs when deleting elements from the middle of an `ArrayList`.

---

# Searching for a Better Solution

The main reason for this problem is that an `ArrayList` stores elements **continuously inside an array**.

This raises an important question:

> Is it possible to design a collection in which elements do not need to be shifted whenever an insertion or deletion occurs?

The answer is **yes**.

Instead of storing all elements continuously in memory, Java stores each element inside a separate object and connects these objects together using references.

This data structure is called a **LinkedList**.

In the next section, you will learn how a `LinkedList` is organized internally and why it performs insertions and deletions more efficiently than an `ArrayList`.

---

# What is a LinkedList?

A **LinkedList** is a linear data structure in which elements are stored as **individual objects called nodes**.

Unlike an `ArrayList`, the elements of a `LinkedList` are **not stored in consecutive memory locations**.

Instead, each element (node) contains the actual data along with one or more references that connect it to other nodes in the list.

You can think of a `LinkedList` as a chain, where each link is connected to the next one.

```
Node → Node → Node → Node → Node
```

Each node knows where the next node is located, allowing the entire list to be traversed from beginning to end.

This design eliminates the need to shift elements whenever a new element is inserted or an existing element is removed.

---

# Understanding a Node

The fundamental building block of a `LinkedList` is a **Node**.

A node is simply an object that stores two types of information:

1. The actual data.
2. A reference to another node.

Conceptually, a node can be represented as follows:

```
+----------------+----------------+
|      Data      |     Next       |
+----------------+----------------+
```

For example, suppose we want to store the following list of cities.

```
Hyderabad
Delhi
Mumbai
Chennai
```

Instead of storing them in one continuous array, Java stores them as individual nodes.

```
+-------------+---------+
| Hyderabad   |   ●-----|------+
+-------------+---------+      |
                               |
                               ▼
                    +-------------+---------+
                    | Delhi       |   ●-----|------+
                    +-------------+---------+      |
                                                   |
                                                   ▼
                                      +-------------+---------+
                                      | Mumbai      |   ●-----|------+
                                      +-------------+---------+      |
                                                                     |
                                                                     ▼
                                                        +-------------+---------+
                                                        | Chennai     |  NULL   |
                                                        +-------------+---------+
```

Notice that each node stores a reference to the next node.

The last node does not point to any other node, so its reference is **NULL**.

---

# Why Doesn't LinkedList Need Element Shifting?

Consider the following linked list.

```
A → B → C → D
```

Now suppose we want to insert **X** between **B** and **C**.

In an `ArrayList`, Java would have to move **C** and **D** to new positions before inserting **X**.

In a `LinkedList`, no element needs to move.

Instead, Java simply creates a new node and changes a few references.

Before insertion:

```
A → B → C → D
```

Create a new node.

```
X
```

Update the references.

```
A → B → X → C → D
```

Observe that:

- Node **A** remains unchanged.
- Node **B** remains in the same memory location.
- Node **C** remains in the same memory location.
- Node **D** remains in the same memory location.

Only the references connecting the nodes have changed.

This is the biggest advantage of a `LinkedList`.

---

# Real-World Analogy

Imagine four people standing in a line holding each other's hands.

```
A —— B —— C —— D
```

Now another person, **X**, wants to stand between **B** and **C**.

Nobody needs to change their physical position.

Instead,

- B lets go of C.
- B holds X's hand.
- X holds C's hand.

The new arrangement becomes:

```
A —— B —— X —— C —— D
```

Only the connections change.

Nobody has to move.

A `LinkedList` works in exactly the same way.

---

# Does LinkedList Have Any Disadvantages?

At this point, it may seem that `LinkedList` is better than `ArrayList` in every way.

However, this is not true.

Suppose you want to access the 500th element.

With an `ArrayList`, Java can directly access the element because every element is stored in an indexed array.

```
students.get(500);
```

The required element is accessed immediately.

In a `LinkedList`, there is no direct indexing.

Java must start from the first node and continue following the references until it reaches the required node.

```
Head
 ↓
A → B → C → D → E → ...
```

If the required element is near the end of the list, Java may have to visit hundreds or even thousands of nodes before reaching it.

Therefore, although insertion and deletion are efficient, searching and random access are comparatively slower.

---

# Comparison: ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|----------|-----------|------------|
| Internal Structure | Dynamic Array | Doubly Linked List |
| Random Access | Very Fast | Slower |
| Insert at Beginning | Slow | Fast |
| Delete from Beginning | Slow | Fast |
| Memory Usage | Less | More |
| Best Choice For | Frequent Reading | Frequent Insertions and Deletions |

Both data structures are important, and neither is universally better than the other.

The correct choice depends entirely on the requirements of the application.

For example:

- Use an `ArrayList` when your application frequently reads data.
- Use a `LinkedList` when your application frequently inserts or removes elements.

Understanding this trade-off is one of the most important concepts in the Java Collections Framework.

---

# Is LinkedList the Ultimate Solution?

After learning about `LinkedList`, it may seem like we have found the perfect data structure.

- Insertions are efficient.
- Deletions are efficient.
- Elements do not need to be shifted.

So, should we always use a `LinkedList`?

The answer is **No**.

Every data structure is designed to solve a particular problem. While `LinkedList` improves insertion and deletion performance, it introduces another limitation.

Suppose your application frequently needs to access elements using an index.

```java
students.get(500);
```

An `ArrayList` can directly access the 500th element because it stores elements in a dynamic array.

A `LinkedList` cannot.

Instead, Java must start from the beginning (or, in some cases, from the end) and visit each node until it reaches the required element.

```
Head
 │
 ▼
A → B → C → D → E → F → G → ...
```

If the required element is near the end of the list, Java may have to visit hundreds or even thousands of nodes before finding it.

This means that although `LinkedList` performs insertions and deletions efficiently, random access is slower than in an `ArrayList`.

Once again, we discover an important principle in software engineering.

> **No single data structure is best for every problem.**

Choosing the correct collection depends entirely on the requirements of the application.

---

# Another Challenge

So far, we have assumed that only one part of the application is accessing the collection at a time.

Consider a banking application.

Suppose multiple users are accessing the same account information simultaneously.

One user deposits money.

Another user withdraws money.

A third user views the account balance.

If all these operations occur at the same time, multiple threads may attempt to modify the same collection simultaneously.

This situation introduces a new problem called **concurrent access**.

---

# Understanding Concurrent Access

Imagine a shared list containing customer transactions.

```
Transaction 1
Transaction 2
Transaction 3
```

Now imagine that two different threads attempt to insert new transactions at exactly the same time.

```
Thread A

Add Transaction 4
```

```
Thread B

Add Transaction 5
```

If both threads modify the collection simultaneously without any coordination, unexpected results may occur.

For example:

- One transaction may overwrite another.
- The collection may become inconsistent.
- Some updates may be lost.
- The application may behave unpredictably.

These situations are known as **race conditions**.

---

# The Need for Thread Safety

To understand thread safety, consider the following real-world example.

Suppose a classroom has only one attendance register.

If every student writes in the register simultaneously, the pages become messy and some entries may be overwritten.

Instead, students are asked to form a queue.

Only one student writes in the register at a time.

After one student finishes, the next student begins.

Although this approach is slower, it ensures that every attendance entry is recorded correctly.

Collections can face a similar situation when multiple threads access them simultaneously.

Sometimes, maintaining data consistency is more important than achieving maximum performance.

---

# Introducing Vector

To solve this problem, Java introduced another implementation of the `List` interface called **Vector**.

Like `ArrayList`, a `Vector` stores elements inside a **dynamic array**.

This means that it supports:

- Indexed access
- Automatic resizing
- Duplicate elements
- Ordered collection
- Null values

At first glance, `Vector` appears almost identical to an `ArrayList`.

```java
List<String> cities = new Vector<>();

cities.add("Hyderabad");
cities.add("Delhi");
cities.add("Chennai");
```

However, there is one very important difference.

A `Vector` is **thread-safe**.

---

# What Does Thread-Safe Mean?

A thread-safe collection ensures that only one thread can modify the collection at a particular moment.

Suppose three threads want to add elements.

```
Thread 1
Thread 2
Thread 3
```

Instead of allowing all three threads to modify the collection simultaneously, `Vector` allows only one thread to execute a modifying operation.

```
Thread 1  ✓

Thread 2  Waiting...

Thread 3  Waiting...
```

After Thread 1 completes its operation,

```
Thread 2 ✓

Thread 3 Waiting...
```

Finally,

```
Thread 3 ✓
```

By allowing only one thread to modify the collection at a time, `Vector` prevents inconsistent data and race conditions.

This behavior is known as **synchronization**.

---

# What is Synchronization?

Synchronization is a mechanism that controls access to shared resources.

Only one thread is allowed to execute a synchronized operation at any given time.

You can think of synchronization as a security guard standing at the entrance of a room.

```
              Security Guard

Thread A ─────►

Thread B ─────►   Waiting

Thread C ─────►   Waiting
```

Only after the first thread leaves does the next thread enter.

This guarantees that shared data remains consistent.

---

# Why Isn't Vector Used Everywhere?

Since `Vector` is thread-safe, you might wonder why developers don't always use it instead of `ArrayList`.

The answer is performance.

Because every modifying operation is synchronized, additional checks are performed before the operation begins.

As a result, `Vector` is generally slower than `ArrayList`.

If your application is accessed by only one thread, these synchronization checks become unnecessary overhead.

Therefore:

- Use an `ArrayList` for single-threaded applications.
- Use a `Vector` only when thread safety is specifically required.

Today, however, developers often prefer newer alternatives such as `Collections.synchronizedList()` and `CopyOnWriteArrayList` instead of using `Vector`.

Nevertheless, understanding `Vector` remains important because many legacy Java applications still use it, and interview questions frequently compare it with `ArrayList`.

---

# ArrayList vs LinkedList vs Vector

| Feature | ArrayList | LinkedList | Vector |
|---------|-----------|------------|--------|
| Internal Structure | Dynamic Array | Doubly Linked List | Dynamic Array |
| Random Access | Fast | Slow | Fast |
| Insert/Delete in Middle | Slow | Fast | Slow |
| Memory Usage | Less | More | Less |
| Thread Safe | No | No | Yes |
| Performance | Fast | Moderate | Slower |
| Introduced | Java 1.2 | Java 1.2 | Java 1.0 |
| Recommended for New Projects | Yes | Yes | Rarely |

---

# Chapter Summary

In this chapter, you learned that no collection implementation is suitable for every situation.

- `ArrayList` stores elements in a dynamic array and provides very fast random access.

- `LinkedList` stores elements as connected nodes, making insertions and deletions more efficient.

- `Vector` also stores elements in a dynamic array but provides thread safety through synchronization.

Choosing the appropriate collection depends entirely on the application's requirements.

Understanding the strengths and limitations of each implementation is an essential skill for every Java developer.