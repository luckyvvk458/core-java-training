# Day 15 - Interview Questions

## Multiple Exceptions

### 1. Can one program contain multiple exceptions?

### 2. Will all exceptions occur in a single execution?

### 3. Why does only the first unhandled exception occur?

### 4. What is sequential execution?

---

## Multiple catch Blocks

### 5. Why do we use multiple catch blocks?

### 6. How does the JVM search for a matching catch block?

### 7. What happens after a matching catch block is found?

### 8. What happens if none of the catch blocks match?

---

## Exception Object

### 9. What methods are available in the Exception class?

### 10. What does `getMessage()` return?

### 11. What does `printStackTrace()` do?

### 12. What does `toString()` return?

### 13. Which method is commonly used while debugging?

---

## finally

### 14. What is the finally block?

### 15. Why do we use finally?

### 16. Does finally execute if an exception occurs?

### 17. Does finally execute if no exception occurs?

### 18. Can a try block have only a finally block?

### 19. Can a finally block exist without a try block?

---

## Scenario Questions

### 20. Where is finally commonly used?

### 21. Why is finally useful while working with files?

### 22. Why is finally useful while working with databases?

### 23. Why should resources be closed after use?

---

## Output Questions

### Program 1

```java
try{
    System.out.println("A");
}
finally{
    System.out.println("B");
}
```

---

### Program 2

```java
try{
    int result = 10 / 0;
}
catch(ArithmeticException e){
    System.out.println(e.getMessage());
}
```

---

### Program 3

```java
try{
    int result = 10 / 0;
}
catch(Exception e){
    System.out.println(e);
}
```
