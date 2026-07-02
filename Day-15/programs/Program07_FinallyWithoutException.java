public class Program07_FinallyWithoutException {

    public static void main(String[] args) {

        try {

            System.out.println("Inside Try Block");

        } finally {

            System.out.println("Inside Finally Block");

        }

        System.out.println("Program Completed");
    }
}