public class Program03_GetMessageDemo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println("Exception Message");

            System.out.println(e.getMessage());

        }
    }
}