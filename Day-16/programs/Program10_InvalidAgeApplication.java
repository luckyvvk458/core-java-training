import java.util.Scanner;

public class Program10_InvalidAgeApplication {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        System.out.print("Enter Age : ");

        int age = scanner.nextInt();

        try {

            if (age < 18) {

                throw new InvalidAgeException(
                        "Age must be 18 or above.");

            }

            System.out.println("Eligible");

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());

        }

    }

}