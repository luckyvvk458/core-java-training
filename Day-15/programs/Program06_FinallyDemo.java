public class Program06_FinallyDemo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception Handled");

        } finally {

            System.out.println("Finally Block Executed");

        }

        System.out.println("Program Completed");
    }
}