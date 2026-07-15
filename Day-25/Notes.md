# Day 25 – LinkedList & Vector

# Problem → Solution Learning Notes

## Learning Objectives

- Explain why ArrayList is not suitable for every situation.
- Understand why LinkedList was introduced.
- Explain the internal structure of LinkedList.
- Compare ArrayList and LinkedList.
- Understand why Vector was introduced.
- Differentiate ArrayList and Vector.

---

# Revision

Previously we learned:

Collection
|
List (Interface)
|
ArrayList

Question:
If ArrayList already exists, why did Java create LinkedList and Vector?

---

# Problem Statement

```java
List<String> students = new ArrayList<>();
students.add("A");
students.add("B");
students.add("D");
students.add("E");
```

Need to insert **C** between **B** and **D**.

```java
students.add(2, "C");
```

The code works.

But internally, ArrayList shifts every element after index 2.

For large collections this becomes expensive.

The same issue occurs during deletion.

---

# Why LinkedList?

LinkedList stores data as nodes instead of a continuous array.

Each node contains:

- Data
- Reference to next node
- (Internally, Java's LinkedList is doubly linked.)

Diagram:

A -> B -> C -> D

Insert X after B:

A -> B -> X -> C -> D

Only references change.
No shifting of elements.

---

# Why Not Always LinkedList?

Random access becomes slower.

To reach element 500, LinkedList traverses node by node.

ArrayList directly accesses index 500.

---

# Comparison

| Feature | ArrayList | LinkedList |
|---|---|---|
| Structure | Dynamic Array | Doubly Linked List |
| get(index) | Fast | Slow |
| Insert/Delete Middle | Slow | Fast |
| Memory | Less | More |

---

# Hands-on Programs

## Program 1

```java
List<String> cities = new LinkedList<>();

cities.add("Hyderabad");
cities.add("Delhi");
cities.add("Mumbai");

System.out.println(cities);
```

## Program 2

```java
cities.add(1, "Chennai");
System.out.println(cities);
```

## Program 3

```java
cities.remove("Delhi");
System.out.println(cities);
```

## Program 4

```java
for(String city : cities){
    System.out.println(city);
}
```

---

# Introducing Vector

Vector is another implementation of List.

```java
List<String> list = new Vector<>();

list.add("Java");
list.add("Spring");
```

Vector synchronizes its methods, making it thread-safe.

---

# ArrayList vs Vector

| Feature | ArrayList | Vector |
|---|---|---|
| Thread Safe | No | Yes |
| Synchronization | No | Yes |
| Performance | Faster | Slower |
| Status | Preferred | Legacy |

---

# Best Practices

- Use ArrayList for frequent reads.
- Use LinkedList for frequent insertions/deletions.
- Use Vector only when legacy synchronized behavior is required.
- Program to the List interface.

---

# Practice Programs

1. Create an ArrayList and insert at index 2.
2. Create a LinkedList and delete the second element.
3. Compare insertion in ArrayList and LinkedList.
4. Traverse a LinkedList using for and for-each.
5. Create a Vector and perform add(), remove(), contains(), size().
6. Replace an element using set().
7. Store Employee objects in a LinkedList.

---

# Interview Questions

1. Why was LinkedList introduced?
2. Difference between ArrayList and LinkedList?
3. Internal structure of LinkedList?
4. Why is get() slower in LinkedList?
5. Why is insertion faster in LinkedList?
6. Difference between ArrayList and Vector?
7. What is synchronization?
8. Why is Vector slower?
9. When should you choose LinkedList?
10. Why program to the List interface?

---

# Key Takeaways

- ArrayList uses a dynamic array.
- LinkedList uses linked nodes.
- Vector is synchronized.
- Choose the implementation based on the requirement.
