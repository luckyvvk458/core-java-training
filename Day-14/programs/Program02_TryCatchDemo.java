public class Program02_TryCatchDemo {

    public static void main(String[] args) {

        System.out.println("Program Started");

        int a = 10;
        int b = 0;

        try {

            int result = a / b;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero.");

        }

        System.out.println("Program Completed");
    }
}