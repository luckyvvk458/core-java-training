# Set Interface

## Introduction

In the previous chapters, we explored two important interfaces of the Java Collections Framework:

- **List**
- **Queue**

The **List** interface is useful when we want to store elements in a sequence and access them using an index.

The **Queue** interface is useful when elements need to be processed in the order they arrive (FIFO).

Both interfaces solve different types of problems, but there is another common requirement that neither List nor Queue can solve efficiently.

Before introducing the next interface, let's understand this problem.

---

# The Problem with List

Imagine that you are developing an online registration system for a Java workshop.

Students register for the workshop by entering their names.

The registrations are received in the following order.

```
Rahul
Anita
Rahul
Kiran
Vijay
Anita
Sneha
Rahul
```

If we store these names in an `ArrayList`, every registration is accepted.

```java
List<String> students = new ArrayList<>();

students.add("Rahul");
students.add("Anita");
students.add("Rahul");
students.add("Kiran");
students.add("Vijay");
students.add("Anita");
students.add("Sneha");
students.add("Rahul");
```

The output becomes

```
[Rahul, Anita, Rahul, Kiran, Vijay, Anita, Sneha, Rahul]
```

Notice that the same student appears multiple times.

Now ask yourself the following question.

> **How many students actually registered?**

Is it

- 8 registrations?

or

- 5 unique students?

The answer depends on the requirement.

If the application is counting registrations, duplicates are acceptable.

However, if the application is preparing the attendance list, duplicate names become a problem.

---

# Can We Solve This Using List?

One possible solution is to check whether the student already exists before adding the new registration.

```java
if (!students.contains("Rahul")) {
    students.add("Rahul");
}
```

Although this works, imagine a system with thousands or even millions of registrations.

Every new registration requires searching the list to determine whether the element already exists.

As the list grows, this approach becomes slower and makes the code more complex.

Wouldn't it be better if Java itself prevented duplicate elements?

That is exactly why the **Set** interface was introduced.

---

# What Is a Set?

A **Set** is a collection that stores **unique elements**.

Unlike a List, a Set automatically ignores duplicate values.

This means an element can appear **only once** in a Set.

For example,

```
Input

Rahul
Anita
Rahul
Kiran
Vijay
Anita
Sneha
Rahul
```

The Set stores

```
Rahul
Anita
Kiran
Vijay
Sneha
```

The duplicate values are ignored automatically.

The programmer does not need to write any extra code to remove them.

---

# Real-World Examples of Set

Many real-world applications require uniqueness.

### Student Registration

A student can register only once for a workshop.

Duplicate registrations should be ignored.

---

### Aadhaar Number

Every citizen has a unique Aadhaar number.

The same Aadhaar number cannot exist twice.

---

### PAN Number

Each PAN number uniquely identifies a taxpayer.

Duplicate PAN numbers are not allowed.

---

### Vehicle Registration Number

Every vehicle has a unique registration number.

For example,

```
TS09AB1234
```

The same registration number cannot belong to another vehicle.

---

### Email Address

An email address uniquely identifies a user.

```
vivek@gmail.com
```

The same email address cannot be registered twice in the same application.

---

These are perfect examples where a Set is more suitable than a List.

---

# Definition of Set

The **Set** interface belongs to the `java.util` package.

It extends the **Collection** interface.

A Set represents a collection that **does not allow duplicate elements**.

Unlike List, a Set does not provide indexed access.

Its primary purpose is to ensure uniqueness of elements.

---

# Characteristics of Set

A Set has the following characteristics.

- Does not allow duplicate elements.
- Stores only unique values.
- Part of the Java Collections Framework.
- Extends the Collection interface.
- Different implementations provide different ordering.
- Does not support index-based access.

---

# Set Hierarchy

```
                 Iterable
                     │
                Collection
                     │
                    Set
        ┌────────────┼─────────────┐
        │            │             │
    HashSet    LinkedHashSet    SortedSet
                                      │
                                NavigableSet
                                      │
                                  TreeSet
```

The Set interface has several implementations.

The most commonly used ones are:

- **HashSet**
- **LinkedHashSet**
- **TreeSet**

Each implementation stores only unique elements but differs in the way it stores and retrieves them.

We will study each implementation in detail in the following sections.

---

# Common Methods of Set

Since Set extends the Collection interface, it inherits many useful methods.

| Method | Description |
|---------|-------------|
| add(E e) | Adds an element if it is not already present. |
| remove(Object o) | Removes an element from the Set. |
| contains(Object o) | Checks whether an element exists. |
| size() | Returns the number of elements. |
| isEmpty() | Checks whether the Set is empty. |
| clear() | Removes all elements. |
| iterator() | Returns an iterator for traversing the Set. |

Notice that methods such as `get(index)` or `add(index, element)` are not available because a Set does not maintain elements using indexes.

---

# Different Types of Set Implementations

Although all Set implementations remove duplicates, they differ in how they organize elements.

| Implementation | Ordering | Internal Structure |
|----------------|----------|--------------------|
| HashSet | No guaranteed order | Hash Table |
| LinkedHashSet | Insertion Order | Hash Table + Linked List |
| TreeSet | Sorted Order | Red-Black Tree |

Choosing the correct implementation depends on the requirements of the application.

In the next section, we will begin with the most commonly used implementation of the Set interface — **HashSet**.


# Java Collections Framework – Set Interface

## Session 1 – Introduction
- Why Set?
- Unique elements
- Set hierarchy
- Common methods

## HashSet
### Introduction
HashSet stores only unique elements and uses a Hash Table internally.

### Characteristics
- No duplicates
- No insertion order
- One null allowed
- Average O(1) add, remove, contains

### Internal Working
Element -> hashCode() -> Bucket -> equals() check

### Sample
```java
Set<String> set = new HashSet<>();
set.add("Rahul");
set.add("Rahul");
System.out.println(set);
```

## LinkedHashSet
### Introduction
LinkedHashSet extends HashSet behavior by preserving insertion order.

### Characteristics
- Unique elements
- Insertion order maintained
- One null allowed
- Hash Table + Doubly Linked List

### Sample
```java
Set<String> set = new LinkedHashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");
System.out.println(set);
```

## TreeSet
### Introduction
TreeSet stores unique elements in sorted order using a Red-Black Tree.

### Characteristics
- Sorted order
- No duplicates
- No null elements
- O(log n) operations

### Sample
```java
Set<Integer> set = new TreeSet<>();
set.add(40);
set.add(10);
set.add(30);
set.add(20);
System.out.println(set);
```

## Comparison

| Feature | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| Duplicates | No | No | No |
| Order | Unordered | Insertion | Sorted |
| Internal Structure | Hash Table | Hash Table + Linked List | Red-Black Tree |
| Null | One | One | No |

## Next Chapter
Map Interface (HashMap, LinkedHashMap, TreeMap, Hashtable)
