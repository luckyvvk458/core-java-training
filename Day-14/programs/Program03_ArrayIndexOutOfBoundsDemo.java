public class Program03_ArrayIndexOutOfBoundsDemo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        try {

            System.out.println(numbers[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid Array Index.");

        }

        System.out.println("Program Completed");
    }
}