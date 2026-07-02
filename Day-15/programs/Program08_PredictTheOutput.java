public class Program08_PredictTheOutput {

    public static void main(String[] args) {

        try {

            System.out.println("A");

            int result = 10 / 0;

            System.out.println("B");

        } catch (ArithmeticException e) {

            System.out.println("C");

        } finally {

            System.out.println("D");

        }

        System.out.println("E");
    }
}