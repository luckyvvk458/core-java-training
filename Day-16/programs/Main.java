public class Main {

    public static void main(String[] args) {

        AgeValidator validator =
                new AgeValidator();

        try {

            validator.validateAge(15);

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());

        }

    }

}