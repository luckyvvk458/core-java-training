# Day 13 - String Problem Solving

## Objective

Apply String concepts learned so far to solve common programming problems.

---

## Recap

Previously we learned:

* String Basics
* String Pool
* == vs equals()
* equalsIgnoreCase()
* contains()
* startsWith()
* endsWith()
* substring()
* trim()

Today we will use these concepts along with loops and conditional statements.

---

# Problem 1 - Reverse a String

Input:

```text
Java
```

Output:

```text
avaJ
```

Approach:

Traverse the String from the last character to the first character.

Example:

```java
for(int i = str.length() - 1; i >= 0; i--) {
    System.out.print(str.charAt(i));
}
```

---

# Problem 2 - Palindrome String

A palindrome reads the same forward and backward.

Examples:

```text
madam
level
radar
```

Approach:

Reverse the String and compare it with the original String.

Example:

```java
if(original.equals(reversed))
```

---

# Problem 3 - Count Vowels

Vowels:

```text
a e i o u
```

Approach:

Traverse the String character by character and count vowels.

Example:

```java
if(ch == 'a' || ch == 'e' || ...)
```

---

# Problem 4 - Count Words

Input:

```text
Java Programming Language
```

Output:

```text
3
```

Approach:

Split the String using spaces.

Example:

```java
String[] words = str.split(" ");
```

---

# Problem 5 - Count Uppercase and Lowercase Characters

Input:

```text
JavaProgramming
```

Output:

```text
Uppercase : 2
Lowercase : 13
```

Approach:

Use Character utility methods.

Example:

```java
Character.isUpperCase(ch)
Character.isLowerCase(ch)
```

---

# Problem 6 - Character Frequency

Input:

```text
java
```

Output:

```text
j -> 1
a -> 2
v -> 1
```

Approach:

Traverse the String and count occurrences of each character.

---

# Problem 7 - Anagram Check

Two Strings are Anagrams if they contain the same characters in different order.

Example:

```text
listen
silent
```

Approach:

Convert to character arrays, sort them, and compare.

Example:

```java
Arrays.sort(arr1);
Arrays.sort(arr2);
```

---

# Programs Discussed

1. Reverse String
2. Palindrome String
3. Count Vowels
4. Count Words
5. Count Uppercase and Lowercase Characters
6. Character Frequency
7. Anagram Check

Refer to Programs folder for source code.

---

# Key Takeaways

* Strings can be traversed using loops.
* String problems improve logical thinking.
* equals() is commonly used for String comparison.
* Character utility methods simplify validation.
* Many interview questions are based on Strings.

---

# Homework

1. Count consonants in a String.
2. Reverse each word in a sentence.
3. Remove spaces from a String.
4. Check whether a String contains only digits.
5. Find the longest word in a sentence.
