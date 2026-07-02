# Day 14 - Interview Questions

## Basic Questions

### 1. What is an Exception?

### 2. Why do we need Exception Handling?

### 3. What happens when an exception is not handled?

### 4. What is the normal flow of program execution?

### 5. What is meant by "Exception interrupts the normal flow of execution"?

### 6. What is a Stack Trace?

### 7. Which three things should you observe from a Stack Trace?

### 8. What is an ArithmeticException?

### 9. What is a NullPointerException?

### 10. What is an ArrayIndexOutOfBoundsException?

---

## try-catch

### 11. What is the purpose of a try block?

### 12. What is the purpose of a catch block?

### 13. Can a catch block exist without a try block?

### 14. What happens inside the try block when an exception occurs?

### 15. Does the remaining code inside the try block execute after an exception occurs?

---

## Exception Object

### 16. Who creates the Exception object?

### 17. What information does an Exception object contain?

### 18. What is the purpose of the variable `e` in a catch block?

Example:

```java
catch (ArithmeticException e)
```

### 19. How does the JVM find the appropriate catch block?

### 20. What happens if no matching catch block is found?

---

## Output Questions

Predict the output of the following programs before executing them.

### Program 1

```java
try{
    int result = 10 / 0;
}
catch(ArithmeticException e){
    System.out.println("Handled");
}
System.out.println("Completed");
```

---

### Program 2

```java
try{
    System.out.println("A");
    int result = 10 / 0;
    System.out.println("B");
}
catch(ArithmeticException e){
    System.out.println("C");
}
System.out.println("D");
```

---

## Practical Questions

### 21. How would you handle Division by Zero?

### 22. How would you handle an Invalid Array Index?

### 23. How would you handle a Null Object Reference?

### 24. Why is Exception Handling important in real-world applications?
