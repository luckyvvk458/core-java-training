# Day 11 - Strings Basics

## Objective

Understand what Strings are, why they are needed, how to create them, and how to perform basic operations on Strings.

---

## Why Do We Need Strings?

Suppose we want to store the word:

```text
HELLO
```

Using characters:

```java
char c1 = 'H';
char c2 = 'E';
char c3 = 'L';
char c4 = 'L';
char c5 = 'O';
```

Managing multiple characters individually is difficult.

Java provides String to store a sequence of characters together.

Example:

```java
String message = "HELLO";
```

---

## What is a String?

A String is a sequence of characters.

Example:

```java
String name = "Vivek";
```

Here:

```text
V
i
v
e
k
```

are stored together as a String.

---

## Ways to Create Strings

### Method 1 - String Literal

```java
String name = "Java";
```

This is the most commonly used approach.

---

### Method 2 - Using new Keyword

```java
String name = new String("Java");
```

Both create Strings but internally they are stored differently.

We will discuss String Pool later.

---

## String is a Class

String is not a primitive data type.

Example:

```java
String city = "Hyderabad";
```

String is a predefined class available in Java.

---

## String Immutability

Strings are immutable.

Once created, their value cannot be changed.

Example:

```java
String str = "Java";

str.concat(" Programming");

System.out.println(str);
```

Output:

```text
Java
```

The original String remains unchanged.

---

## Common String Methods

### length()

Returns the number of characters.

Example:

```java
String name = "Vivek";

System.out.println(name.length());
```

Output:

```text
5
```

---

### charAt()

Returns the character at a specific index.

Example:

```java
String name = "Java";

System.out.println(name.charAt(0));
```

Output:

```text
J
```

---

### toUpperCase()

Converts String to uppercase.

Example:

```java
String name = "java";

System.out.println(name.toUpperCase());
```

Output:

```text
JAVA
```

---

### toLowerCase()

Converts String to lowercase.

Example:

```java
String name = "JAVA";

System.out.println(name.toLowerCase());
```

Output:

```text
java
```

---

## String Indexing

Just like arrays, String indexing starts from 0.

Example:

```text
String : JAVA

Index  : 0 1 2 3
```

---

## Traversing a String

We can access each character using a loop.

Example:

```java
for(int i = 0; i < name.length(); i++) {
    System.out.println(name.charAt(i));
}
```

---

## Programs Discussed

1. String Creation
2. String Length
3. Print Characters One by One

Refer to Programs folder for source code.

---

## Key Takeaways

* String is a sequence of characters.
* String is a predefined Java class.
* Strings can be created using literals or new keyword.
* Strings are immutable.
* String indexing starts from 0.
* Common methods include length() and charAt().

---

## Homework

1. Convert a String to Uppercase.
2. Convert a String to Lowercase.
3. Print the last character of a String.
4. Print all characters using a loop.
5. Count the number of characters in a String.
