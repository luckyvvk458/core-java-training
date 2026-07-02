public class Program06_PredictTheOutput {

    public static void main(String[] args) {

        try {

            System.out.println("A");

            int result = 10 / 0;

            System.out.println("B");

        } catch (ArithmeticException e) {

            System.out.println("C");

        }

        System.out.println("D");
    }
}