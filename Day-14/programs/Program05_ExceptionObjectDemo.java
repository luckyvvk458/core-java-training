public class Program05_ExceptionObjectDemo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Using getMessage()");
            System.out.println(e.getMessage());

            System.out.println();

            System.out.println("Using toString()");
            System.out.println(e);

            System.out.println();

            System.out.println("Using printStackTrace()");
            e.printStackTrace();
        }

        System.out.println("Program Completed");
    }
}