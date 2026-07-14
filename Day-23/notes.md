# Day 24 – Introduction to the Collections Framework

# Problem → Solution Learning Notes

## Learning Objectives

- Explain why the Collections Framework was introduced.
- Understand the limitations of variables.
- Understand the limitations of arrays.
- Explain dynamic data structures.
- Describe the Collection Framework hierarchy.

---

# Revision

So far we have learned:

```
Class
↓
Object
↓
Methods
↓
Constructors
↓
this
↓
static
↓
Inheritance
↓
Polymorphism
↓
Abstraction
↓
Interfaces
```

Now we move from creating objects to managing **large collections of objects**.

---

# Problem Statement 1 – Variables

Suppose a company has only one employee.

```java
Employee employee = new Employee();
```

Easy.

Now imagine there are 10 employees.

```java
Employee e1;
Employee e2;
...
Employee e10;
```

Still possible.

What if there are 1000 employees?

Writing individual variables is impossible.

## Conclusion

Variables are suitable only for storing a small number of values.

---

# Problem Statement 2 – Arrays

Arrays solve the first problem.

```java
Employee[] employees = new Employee[100];
```

Now one variable stores many objects.

But arrays introduce new limitations.

## Limitation 1 – Fixed Size

```java
Employee[] employees = new Employee[100];
```

Tomorrow the company has 101 employees.

Can the array grow automatically?

**No.**

The size is fixed after creation.

---

## Limitation 2 – Resizing

The only solution is:

```java
Employee[] bigger = new Employee[200];
```

Copy every element from the old array to the new array.

This is inefficient.

---

## Limitation 3 – Memory Waste

Create an array of size 100.

Store only 10 employees.

90 positions remain unused.

Memory is wasted.

---

## Limitation 4 – Insertion

Current array:

```
A
B
D
E
```

Insert C.

Everything after B must shift.

---

## Limitation 5 – Deletion

Current array:

```
A
B
Rahul
C
D
```

Delete Rahul.

Remaining elements must shift.

Insertion and deletion become expensive.

---

# Are Arrays Bad?

No.

Arrays are excellent when:

- Size is fixed
- Fast index-based access is required
- Memory layout matters

Modern applications, however, need dynamic storage.

---

# Real-world Example

Imagine Instagram.

Every second:

- New users register
- Existing users leave
- Profiles are updated

Can Instagram keep creating larger arrays and copying millions of users?

No.

It needs a data structure that grows and shrinks automatically.

---

# Dynamic Data Structure

A dynamic data structure can:

- Grow automatically
- Shrink automatically
- Insert efficiently
- Delete efficiently

---

# Introducing the Collections Framework

**Definition**

The Java Collections Framework is a set of interfaces and classes used to store and manipulate groups of objects dynamically.

---

# Why is it called a Framework?

Java provides an entire family of interfaces and implementations working together—not just one class.

---

# Collection Hierarchy

```
Iterable
   │
Collection
├── List
├── Set
└── Queue

Map (Separate Hierarchy)
```

---

# What Will We Learn?

**List**

- Ordered
- Allows duplicates

**Set**

- Unique elements

**Queue**

- FIFO processing

**Map**

- Key–Value pairs

---

# Arrays vs Collections

| Arrays | Collections |
|--------|-------------|
| Fixed size | Dynamic size |
| Manual resizing | Automatic growth |
| Costly insert/delete | Easier insert/delete |

---

# Best Practices

- Use arrays when the size is fixed.
- Use collections when data changes frequently.
- Choose the collection based on the requirement.

---

# Key Takeaways

- Variables store one value/reference.
- Arrays store multiple values but have fixed size.
- Collections solve the limitations of arrays.
- Collections are dynamic.
- The framework mainly contains List, Set, Queue and Map.

---

# Practice Exercises

1. Store five students using variables.
2. Store ten employees in an array.
3. List five limitations of arrays.
4. Explain dynamic data structures.
5. Draw the Collections Framework hierarchy.

---

# Interview Questions

1. Why was the Collections Framework introduced?
2. What are the limitations of variables?
3. What are the limitations of arrays?
4. What is a dynamic data structure?
5. Why are collections preferred over arrays in many applications?

---

# Next Session

**List and ArrayList**
