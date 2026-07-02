public class Program01_ExceptionHierarchyDemo {

    public static void main(String[] args) {

        ArithmeticException arithmeticException =
                new ArithmeticException("Division by Zero");

        System.out.println(arithmeticException instanceof ArithmeticException);

        System.out.println(arithmeticException instanceof RuntimeException);

        System.out.println(arithmeticException instanceof Exception);

        System.out.println(arithmeticException instanceof Throwable);

        System.out.println(arithmeticException instanceof Object);
    }
}