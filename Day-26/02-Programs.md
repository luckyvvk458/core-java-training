# Working with LinkedList

Now that you understand the internal structure of a `LinkedList`, it is time to learn how to use it in Java applications.

The following examples gradually introduce the most commonly used operations provided by the `LinkedList` class. Each program focuses on one operation so that you can understand it thoroughly before moving to the next one.

---

# Program 1 – Creating a LinkedList

## Objective

Create a `LinkedList` and store multiple city names.

### Program

```java
import java.util.LinkedList;

public class LinkedListExample1 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Mumbai");

        System.out.println(cities);
    }
}
```

### Output

```
[Hyderabad, Chennai, Bangalore, Mumbai]
```

### Explanation

The `LinkedList` class belongs to the `java.util` package.

```java
LinkedList<String> cities = new LinkedList<>();
```

creates an empty linked list capable of storing `String` objects.

The `add()` method inserts elements at the end of the list.

Internally, Java creates a new node for every element and connects it to the previous node.

```
Head
 ↓
Hyderabad → Chennai → Bangalore → Mumbai → NULL
```

---

# Program 2 – Insert an Element at a Specific Index

## Objective

Insert an element at a specific position in the list.

### Program

```java
import java.util.LinkedList;

public class LinkedListExample2 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Bangalore");
        cities.add("Mumbai");

        cities.add(1, "Chennai");

        System.out.println(cities);
    }
}
```

### Output

```
[Hyderabad, Chennai, Bangalore, Mumbai]
```

### Explanation

Initially,

```
Hyderabad → Bangalore → Mumbai
```

After insertion,

```
Hyderabad → Chennai → Bangalore → Mumbai
```

Instead of shifting elements, Java simply updates the node references.

---

# Program 3 – Remove an Element by Object

## Objective

Remove an element by specifying its value.

### Program

```java
import java.util.LinkedList;

public class LinkedListExample3 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");

        System.out.println("Before Removal : " + cities);

        cities.remove("Delhi");

        System.out.println("After Removal  : " + cities);
    }
}
```

### Output

```
Before Removal : [Hyderabad, Delhi, Mumbai, Chennai]

After Removal  : [Hyderabad, Mumbai, Chennai]
```

### Explanation

The `remove(Object obj)` method searches for the first occurrence of the specified object.

Once found, Java removes that node from the linked list and reconnects the remaining nodes.

```
Before

Hyderabad → Delhi → Mumbai → Chennai

After

Hyderabad → Mumbai → Chennai
```

Notice that the nodes are reconnected without shifting any elements.

---

# Program 4 – Remove an Element by Index

## Objective

Remove an element using its index.

### Program

```java
import java.util.LinkedList;

public class LinkedListExample4 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");

        System.out.println("Before Removal : " + cities);

        cities.remove(2);

        System.out.println("After Removal  : " + cities);
    }
}
```

### Output

```
Before Removal : [Hyderabad, Delhi, Mumbai, Chennai]

After Removal  : [Hyderabad, Delhi, Chennai]
```

### Explanation

`remove(int index)` removes the node at the specified position.

Here,

```
Index

0  1  2  3

Hyderabad
Delhi
Mumbai
Chennai
```

The element `"Mumbai"` is stored at index `2`, so it is removed.

---

# Program 5 – Traversing a LinkedList Using a for-each Loop

## Objective

Read every element stored inside a linked list.

### Program

```java
import java.util.LinkedList;

public class LinkedListExample5 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");

        for(String city : cities){
            System.out.println(city);
        }
    }
}
```

### Output

```
Hyderabad
Delhi
Mumbai
Chennai
```

### Explanation

The enhanced for loop automatically visits every node one after another.

Conceptually, Java performs the following traversal.

```
Head

 ↓

Hyderabad

 ↓

Delhi

 ↓

Mumbai

 ↓

Chennai

 ↓

NULL
```

Every node is visited exactly once.

---

# Program 6 – Traversing a LinkedList Using an Iterator

## Objective

Learn how to traverse a collection using an `Iterator`.

### Program

```java
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample6 {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Mumbai");

        Iterator<String> iterator = cities.iterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

    }
}
```

### Output

```
Hyderabad
Delhi
Mumbai
```

### Explanation

The `iterator()` method returns an object capable of traversing the collection.

The loop continues as long as another element exists.

```
iterator.hasNext()
```

checks whether another node is available.

```
iterator.next()
```

returns the current element and automatically moves to the next node.

Using an `Iterator` is the recommended approach when elements need to be removed safely while traversing a collection.

---

# What Have You Learned So Far?

After completing these six programs, you should be able to:

✔ Create a LinkedList.

✔ Add elements.

✔ Insert elements at a specific position.

✔ Remove elements using both object and index.

✔ Traverse a LinkedList using a for-each loop.

✔ Traverse a LinkedList using an Iterator.

In the next section, you will learn how to compare the performance of `ArrayList` and `LinkedList`, work with `Vector`, and store user-defined objects inside collections.