# Day 16 - Interview Questions

## Exception Hierarchy

### 1. What is Throwable?

### 2. What is the difference between Error and Exception?

### 3. Should we handle Errors? Why?

### 4. Where does RuntimeException fit in the Exception hierarchy?

---

## Checked vs Unchecked Exceptions

### 5. What is a Checked Exception?

### 6. What is an Unchecked Exception?

### 7. What is the difference between Checked and Unchecked Exceptions?

### 8. Give examples of Checked Exceptions.

### 9. Give examples of Unchecked Exceptions.

### 10. Why does the compiler force us to handle Checked Exceptions?

---

## Custom Exceptions

### 11. Why do we create Custom Exceptions?

### 12. Can we create our own Exception class?

### 13. Why do Custom Exceptions extend Exception?

### 14. What is the purpose of `super(message)`?

### 15. Can we create Custom Unchecked Exceptions?

### 16. Give a real-world example where you would create a Custom Exception.

---

## throw vs throws

### 17. What is the difference between `throw` and `throws`?

### 18. Where is `throw` used?

### 19. Where is `throws` used?

### 20. Does `throws` actually throw an Exception?

### 21. Can a method declare multiple exceptions using `throws`?

Example:

```java
public void process()
        throws IOException, SQLException
```

---

## Exception Propagation

### 22. What is Exception Propagation?

### 23. How does an Exception propagate?

### 24. What happens if the current method does not handle an Exception?

### 25. At what point does Exception Propagation stop?

### 26. Can the `main()` method handle a propagated Exception?

---

## Best Practices

### 27. Why should we catch specific exceptions instead of Exception?

### 28. Why should we avoid empty catch blocks?

### 29. Why should meaningful exception messages be used?

### 30. Why should business applications use Custom Exceptions?

### 31. What are some Exception Handling best practices?

---

## Scenario Questions

### 32. Design a Custom Exception for:

* Banking Application
* Student Admission System
* Online Shopping System

### 33. Explain the complete lifecycle of an Exception from occurrence to handling.

### 34. Explain Exception Propagation using a method call diagram.

### 35. Explain the internal working of `throw` and `throws`.

### 36. Explain how the JVM searches for a matching catch block.

### 37. What is the difference between Java-generated Exceptions and programmer-created Exceptions?
