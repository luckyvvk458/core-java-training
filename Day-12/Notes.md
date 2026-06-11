# Day 12 - String Methods and String Pool

## Objective

Understand how Strings are stored in memory, learn the difference between == and equals(), and explore commonly used String methods.

---

## Recap

Previously we learned:

* What is a String?
* Why Strings are needed
* String Literal
* String Creation using new
* String Immutability
* length()
* charAt()
* toUpperCase()
* toLowerCase()

---

# String Pool

Java maintains a special memory area called the String Pool.

The String Pool helps save memory by reusing String objects.

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Both variables point to the same object.

Visualization:

```text
String Pool

+--------+
| "Java" |
+--------+
   ↑   ↑
  s1  s2
```

---

## Why String Pool?

Suppose 1000 variables contain:

```text
Java
```

Without String Pool:

```text
1000 String Objects
```

With String Pool:

```text
1 String Object
1000 References
```

This improves memory utilization.

---

# Creating Strings using new

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Visualization:

```text
Heap

s1 ----> "Java"

s2 ----> "Java"
```

These are different objects.

---

# == Operator

The == operator compares references.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

Output:

```text
false
```

Because:

```text
s1 and s2 point to different objects.
```

---

# equals() Method

The equals() method compares content.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1.equals(s2));
```

Output:

```text
true
```

Because:

```text
Both Strings contain the same text.
```

---

# Difference Between == and equals()

| ==                  | equals()         |
| ------------------- | ---------------- |
| Compares References | Compares Content |
| Operator            | Method           |
| Memory Comparison   | Value Comparison |

---

# equalsIgnoreCase()

Used to compare Strings ignoring letter case.

Example:

```java
String s1 = "JAVA";
String s2 = "java";

System.out.println(s1.equalsIgnoreCase(s2));
```

Output:

```text
true
```

---

# contains()

Checks whether a String contains another String.

Example:

```java
String str = "Java Programming";

System.out.println(str.contains("Program"));
```

Output:

```text
true
```

---

# startsWith()

Checks whether a String starts with a specific value.

Example:

```java
String str = "Java Programming";

System.out.println(str.startsWith("Java"));
```

Output:

```text
true
```

---

# endsWith()

Checks whether a String ends with a specific value.

Example:

```java
String str = "Java Programming";

System.out.println(str.endsWith("ming"));
```

Output:

```text
true
```

---

# substring()

Used to extract a portion of a String.

Example:

```java
String str = "Programming";

System.out.println(str.substring(3));
```

Output:

```text
gramming
```

---

Example:

```java
System.out.println(str.substring(0,4));
```

Output:

```text
Prog
```

---

# trim()

Removes leading and trailing spaces.

Example:

```java
String str = "   Java   ";

System.out.println(str.trim());
```

Output:

```text
Java
```

---

# Programs Discussed

1. String Pool Demo
2. == vs equals()
3. equalsIgnoreCase()
4. contains(), startsWith(), endsWith()
5. substring()
6. trim()

Refer to Programs folder for source code.

---

# Key Takeaways

* Java uses String Pool for memory optimization.
* == compares references.
* equals() compares content.
* equalsIgnoreCase() ignores case differences.
* contains() checks for presence of text.
* substring() extracts part of a String.
* trim() removes unnecessary spaces.

---

# Homework

1. Compare two Strings using equals().
2. Compare two Strings using equalsIgnoreCase().
3. Extract first 5 characters using substring().
4. Check whether a String starts with "Java".
5. Remove spaces using trim().
