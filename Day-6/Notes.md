# Day 6 - Loops

## Objective

Understand how programs perform repetitive tasks using loops.

---

## Why Do We Need Loops?

Without loops:

```java
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
```

Imagine printing "Hello" 100 times.

Loops help us avoid writing repetitive code.

---

## What is a Loop?

A loop repeatedly executes a block of code until a condition becomes false.

---

## for Loop

Used when the number of iterations is known.

Syntax:

```java
for(initialization; condition; increment/decrement) {

}
```

Example:

```java
for(int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

## Dry Run

| i | Condition | Output |
| - | --------- | ------ |
| 1 | 1 <= 5    | 1      |
| 2 | 2 <= 5    | 2      |
| 3 | 3 <= 5    | 3      |
| 4 | 4 <= 5    | 4      |
| 5 | 5 <= 5    | 5      |
| 6 | 6 <= 5    | Stop   |

---

## while Loop

Used when the number of iterations is not known beforehand.

Syntax:

```java
while(condition) {

}
```

Example:

```java
int i = 1;

while(i <= 5) {
    System.out.println(i);
    i++;
}
```

Output:

```text
1
2
3
4
5
```

---

## Difference Between for and while

### for Loop

Use when:

```text
Number of iterations is known
```

Example:

```text
Print 1 to 100
Print table of 5
```

---

### while Loop

Use when:

```text
Iterations depend on a condition
```

Example:

```text
Keep taking input until user enters 0
```

---

## do-while Loop

Executes at least once.

Syntax:

```java
do {

} while(condition);
```

Example:

```java
int i = 10;

do {
    System.out.println(i);
} while(i < 5);
```

Output:

```text
10
```

The condition is false, but the loop executes once.

---

## break Statement

Used to immediately exit a loop.

Example:

```java
for(int i = 1; i <= 10; i++) {

    if(i == 5) {
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
```

---

## continue Statement

Used to skip the current iteration.

Example:

```java
for(int i = 1; i <= 5; i++) {

    if(i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

---

## return Statement

Used to exit the current method.

Example:

```java
public static void main(String[] args) {

    System.out.println("Start");

    return;
}
```

Output:

```text
Start
```

The method ends immediately after return.

---

## Difference Between break, continue and return

| Statement | Purpose                |
| --------- | ---------------------- |
| break     | Exit loop              |
| continue  | Skip current iteration |
| return    | Exit method            |

---

## Programs Discussed

1. Print Numbers from 1 to 10
2. Print Numbers using while Loop
3. Multiplication Table
4. Sum of First N Numbers
5. break Example
6. continue Example

Refer to the Programs folder for source code.

---

## Key Takeaways

* Loops help avoid repetitive code.
* for loops are used when the number of iterations is known.
* while loops are used when iterations depend on a condition.
* do-while executes at least once.
* break exits a loop.
* continue skips an iteration.
* return exits a method.

---

## Homework

1. Print Odd Numbers from 1 to 100.
2. Find Factorial of a Number.
3. Reverse a Number.
4. Check Palindrome Number.
5. Find Sum of Digits.

---

## Interview Questions

1. Difference between for and while?
2. What is a do-while loop?
3. Difference between break and continue?
4. Difference between break and return?
5. When should we use a while loop?
