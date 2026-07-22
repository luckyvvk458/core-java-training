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

# Queue Implementations

The `Queue` interface is only a contract that defines how a queue should behave.

Since it is an interface, it cannot be instantiated directly.

Java provides multiple classes that implement the `Queue` interface. Each implementation is designed for a different use case and offers different performance characteristics.

The most commonly used Queue implementations are:

- PriorityQueue
- ArrayDeque
- LinkedList

The following sections introduce each implementation.

---

# PriorityQueue

## Introduction

`PriorityQueue` is the most commonly used implementation of the `Queue` interface.

Unlike a normal queue, which processes elements strictly in the order they arrive, a `PriorityQueue` processes elements according to their **priority**.

By default, the priority is determined using the **natural ordering** of the elements.

For example,

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();

queue.add(40);
queue.add(10);
queue.add(30);
queue.add(20);
```

Although the insertion order is

```
40

10

30

20
```

the element with the highest priority (smallest value by default) is always available at the front.

```
10

20

30

40
```

Internally, a `PriorityQueue` uses a **Binary Heap** data structure.

This allows insertion and removal operations to be performed efficiently while maintaining the priority ordering.

---

## Characteristics of PriorityQueue

- Implements the Queue interface.
- Internally uses a Binary Heap.
- Maintains elements according to their priority.
- Does not preserve insertion order.
- Does not allow `null` elements.
- Allows duplicate elements.
- Automatically grows as elements are added.
- Provides efficient insertion and removal operations.

---

## When Should You Use PriorityQueue?

Use a `PriorityQueue` when elements must be processed according to their priority instead of their insertion order.

Typical applications include:

- CPU Scheduling
- Hospital Emergency Systems
- Flight Boarding Priority
- Task Scheduling
- Dijkstra's Shortest Path Algorithm
- Event Scheduling
- Job Processing Systems

---

## Advantages

- Automatic priority management.
- Fast insertion and removal.
- Suitable for scheduling applications.
- Supports custom ordering using a Comparator.

---

## Limitations

- Does not preserve insertion order.
- No indexed access.
- Printing the queue does not display elements in sorted order.
- Iteration order is not guaranteed.

---

# ArrayDeque

## Introduction

`ArrayDeque` stands for **Array Double Ended Queue**.

It is another implementation of the `Deque` interface.

Unlike `PriorityQueue`, an `ArrayDeque` maintains the insertion order of elements.

It allows insertion and deletion from **both ends** of the collection.

```
Front

↓

10

20

30

40

↓

Rear
```

Elements can be inserted or removed from either the front or the rear.

```
addFirst()

↓

10

20

30

40

↑

addLast()
```

Internally, `ArrayDeque` is implemented using a **Resizable Circular Array**.

As the queue grows, Java automatically increases the capacity.

---

## Characteristics of ArrayDeque

- Implements the Deque interface.
- Uses a resizable circular array.
- Allows insertion at both ends.
- Allows removal from both ends.
- Faster than Stack for stack operations.
- Faster than LinkedList for queue operations in most cases.
- Does not allow null elements.
- Maintains insertion order.

---

## When Should You Use ArrayDeque?

Use an `ArrayDeque` when:

- A normal queue is required.
- A stack implementation is required.
- High performance is important.
- Frequent insertions and deletions occur at both ends.

Common applications include:

- Browser navigation
- Undo and Redo operations
- Expression evaluation
- Sliding Window algorithms
- Breadth First Search (BFS)
- Task scheduling

---

## Advantages

- Very fast.
- Memory efficient.
- Supports Queue and Stack operations.
- Better than Stack for LIFO operations.
- Better than LinkedList for most queue operations.

---

## Limitations

- No random access.
- Does not allow null elements.
- Capacity increases automatically but elements may be rearranged internally.

---

# LinkedList as a Queue

In the previous chapter, we learned that `LinkedList` implements the `List` interface.

Interestingly, it also implements the `Deque` and `Queue` interfaces.

This means the same `LinkedList` object can behave like a Queue.

```java
Queue<String> queue = new LinkedList<>();
```

Internally, it uses a **Doubly Linked List**.

```
NULL

←

A

⇄

B

⇄

C

→

NULL
```

Since nodes are connected using references, insertions and deletions at both ends are efficient.

---

## Characteristics of LinkedList

- Implements List, Queue and Deque.
- Uses a Doubly Linked List.
- Maintains insertion order.
- Allows duplicate elements.
- Allows null elements.
- Efficient insertion and deletion.
- Slower random access.

---

## When Should You Use LinkedList?

Use `LinkedList` when:

- Frequent insertions occur.
- Frequent deletions occur.
- Queue and List functionality are both required.
- Random access is not important.

---

# Comparison of Queue Implementations

| Feature | PriorityQueue | ArrayDeque | LinkedList |
|----------|---------------|------------|------------|
| Ordering | Priority | FIFO | FIFO |
| Internal Structure | Binary Heap | Circular Array | Doubly Linked List |
| Null Elements | No | No | Yes |
| Duplicate Elements | Yes | Yes | Yes |
| Insertion Order | No | Yes | Yes |
| Random Access | No | No | No |
| Double Ended Operations | No | Yes | Yes |
| Queue Operations | Yes | Yes | Yes |
| Stack Operations | No | Yes | Yes |
| Performance | Very Fast | Excellent | Good |

---

# Which Implementation Should You Choose?

Choose the implementation based on the application requirements.

| Requirement | Recommended Class |
|--------------|-------------------|
| Priority-based processing | PriorityQueue |
| Normal FIFO queue | ArrayDeque |
| Queue + Stack implementation | ArrayDeque |
| Frequent insertions and deletions | LinkedList |
| Queue with List functionality | LinkedList |

As a general recommendation:

- Use **PriorityQueue** when processing depends on priority.
- Use **ArrayDeque** for most queue and stack implementations due to its excellent performance.
- Use **LinkedList** only when you specifically need both `List` and `Queue` behaviors or require linked-node characteristics.