# Queue Interface

## Introduction

In the previous chapter, we explored the **List** interface and its implementations such as **ArrayList**, **LinkedList**, and **Vector**.

The List interface is an excellent choice when we need to store elements in a sequence and access them using their index.

For example,

```java
students.get(2);
```

retrieves the third element from the list.

This makes the List interface suitable for applications where random access is important.

However, not every real-world problem requires accessing elements using an index.

In many applications, elements are processed strictly in the order in which they arrive.

Consider the following situations.

- Customers waiting in a bank.
- Vehicles waiting at a toll plaza.
- Patients waiting at a hospital.
- Print jobs waiting for a printer.
- Food orders waiting in a restaurant.
- Tasks waiting to be executed by the operating system.

In all these examples, the first item entering the line is also the first item to leave.

This processing strategy is known as **FIFO (First In, First Out).**

To represent such collections, Java provides another interface called the **Queue** interface.

---

# Why List Is Not Always Enough

Suppose you are developing a ticket booking application.

Customers join the waiting line in the following order.

```
Rahul

↓

Anita

↓

Vijay

↓

Sneha
```

When a ticket becomes available, who should receive it first?

Obviously,

```
Rahul
```

After Rahul leaves,

```
Anita

↓

Vijay

↓

Sneha
```

becomes the new waiting line.

Although we can implement this behavior using a List,

```java
customers.remove(0);
```

the code does not clearly communicate that the collection represents a waiting queue.

Java therefore provides a specialized interface whose operations clearly express queue behavior.

That interface is **Queue**.

---

# What Is a Queue?

A Queue is a collection that stores and processes elements according to the **First In, First Out (FIFO)** principle.

The first element inserted into the queue is the first element removed.

Imagine standing in a queue outside a movie theatre.

```
Front

↓

Rahul

↓

Anita

↓

Vijay

↓

Sneha

↓

Rear
```

When tickets become available,

```
Rahul
```

leaves first.

The remaining customers automatically move forward.

```
Front

↓

Anita

↓

Vijay

↓

Sneha
```

This is exactly how a Queue behaves.

---

# FIFO Principle

FIFO stands for **First In, First Out**.

Suppose the following numbers are inserted.

```
Insert

10

20

30

40
```

The queue becomes

```
Front

↓

10

↓

20

↓

30

↓

40

↓

Rear
```

When an element is removed,

```
10
```

is removed first.

After removal,

```
Front

↓

20

↓

30

↓

40
```

The remaining elements maintain their order.

---

# Queue Interface

The Queue interface belongs to the **java.util** package.

It extends the **Collection** interface.

Unlike the List interface, Queue focuses on processing elements rather than providing indexed access.

Queue provides methods for

- inserting elements
- removing elements
- viewing the front element

without exposing index-based operations.

---

# Queue Hierarchy

```
                 Iterable
                     │
                Collection
                     │
                   Queue
              ┌──────┴────────┐
              │               │
       PriorityQueue        Deque
                                 │
                            ArrayDeque

               LinkedList
                   ▲
                   │
          also implements Queue
```

Notice that **LinkedList** can also be used as a Queue because it implements the Queue interface.

---

# Characteristics of Queue

A Queue has the following characteristics.

- Follows FIFO order.
- Stores elements before processing.
- Allows duplicate elements.
- Usually does not support indexed access.
- Provides specialized insertion and removal methods.
- Different implementations may order elements differently.

---

# Common Methods of Queue

| Method | Description |
|---------|-------------|
| add() | Inserts an element into the queue. |
| offer() | Inserts an element without throwing an exception if insertion fails. |
| remove() | Removes the front element. |
| poll() | Removes and returns the front element or null if empty. |
| element() | Returns the front element without removing it. |
| peek() | Returns the front element or null if empty. |

These six methods form the core API of the Queue interface.

---

# Queue Implementations

Java provides multiple implementations of Queue.

| Class | Description |
|---------|------------|
| PriorityQueue | Maintains elements based on priority. |
| ArrayDeque | Double-ended queue implemented using a resizable array. |
| LinkedList | Can be used as a Queue as well as a List. |

Each implementation serves different purposes.

In this chapter we begin with **PriorityQueue**.

---

# Programming to an Interface

Can we write

```java
Queue<String> queue = new Queue<>();
```

No.

Queue is an interface.

Interfaces cannot be instantiated directly.

Instead,

```java
Queue<String> queue = new PriorityQueue<>();
```

creates

- Queue reference
- PriorityQueue object

This is called **Programming to an Interface**, one of the most important object-oriented design principles.

Later, if the implementation changes,

```java
Queue<String> queue = new ArrayDeque<>();
```

only one line of code changes.

The rest of the application remains unchanged.

---

# Creating Our First Queue

## Objective

Create a Queue using PriorityQueue.

### Program 1

```java
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample1 {

    public static void main(String[] args) {

        Queue<String> customers = new PriorityQueue<>();

        customers.add("Rahul");
        customers.add("Anita");
        customers.add("Vijay");
        customers.add("Sneha");

        System.out.println(customers);

    }

}
```

### Sample Output

```
[Anita, Rahul, Vijay, Sneha]
```

---

# Why Is the Output Not FIFO?

Many students expect

```
Rahul

↓

Anita

↓

Vijay

↓

Sneha
```

Instead,

```
[Anita, Rahul, Vijay, Sneha]
```

appears.

This happens because a PriorityQueue does **not** preserve insertion order.

It maintains a **priority heap** internally.

The queue guarantees that the highest-priority element is available at the front.

The printed representation does not show the processing order.

We will understand heaps later in this chapter.

---

# Queue Operations

Every Queue supports three fundamental operations.

```
Insert

↓

View Front

↓

Remove Front
```

Java provides two methods for each operation.

| Operation | Throws Exception | Returns Special Value |
|------------|------------------|-----------------------|
| Insert | add() | offer() |
| Retrieve | element() | peek() |
| Remove | remove() | poll() |

In the following sections, we will study each pair in detail.

---

# Upcoming Sections

- add() vs offer()
- remove() vs poll()
- element() vs peek()
- PriorityQueue Internal Working
- Heap Data Structure
- ArrayDeque
- Deque Interface
- Queue Programs
- Performance Comparison
- Interview Questions
- Assignments