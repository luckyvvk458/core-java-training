public class Program04_NullPointerExceptionDemo {

    public static void main(String[] args) {

        String name = null;

        try {

            System.out.println(name.length());

        } catch (NullPointerException e) {

            System.out.println("String reference is null.");

        }

        System.out.println("Program Completed");
    }
}