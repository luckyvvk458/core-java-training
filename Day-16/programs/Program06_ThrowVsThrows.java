public class Program06_ThrowVsThrows {

    static void vote(int age)
            throws Exception {

        if (age < 18) {

            throw new Exception(
                    "Not Eligible to Vote");

        }

        System.out.println("Eligible");

    }

    public static void main(String[] args) {

        try {

            vote(16);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}