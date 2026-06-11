# Day 12 - String Interview Questions

## String Pool

1. What is String Pool?
2. Why does Java use String Pool?
3. What are the benefits of String Pool?
4. Where are String literals stored?

---

## String Creation

5. What is the difference between:

```java
String s = "Java";
```

and

```java
String s = new String("Java");
```

6. How many objects are created in each case?

---

## == vs equals()

7. What does == compare?
8. What does equals() compare?
9. Which one should be used to compare String values?
10. Why does this return false?

```java
new String("Java") == new String("Java")
```

11. Why does this return true?

```java
"Java" == "Java"
```

---

## String Methods

12. What does equalsIgnoreCase() do?
13. What does contains() do?
14. What does startsWith() do?
15. What does endsWith() do?
16. What does substring() do?
17. What does trim() do?

---

## Immutability

18. What is String immutability?
19. Why are Strings immutable?
20. What happens when concat() is called?

Example:

```java
String s = "Java";

s.concat(" Programming");
```

---

## Scenario Questions

21. How would you compare two Strings ignoring case?
22. How would you check whether a String contains a word?
23. How would you remove spaces from a String?
24. How would you extract the first name from a full name?
25. How would you check whether a String starts with a specific prefix?
