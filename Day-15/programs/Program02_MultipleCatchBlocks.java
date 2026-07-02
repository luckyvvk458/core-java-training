public class Program02_MultipleCatchBlocks {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20};

            System.out.println(numbers[5]);

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Exception Handled");

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Array Exception Handled");

        } catch (NullPointerException e) {

            System.out.println("Null Exception Handled");

        }

        System.out.println("Program Completed");
    }
}