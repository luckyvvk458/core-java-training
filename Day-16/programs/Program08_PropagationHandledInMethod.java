public class Program08_PropagationHandledInMethod {

    static void method3() {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println(
                    "Handled in method3");

        }

    }

    static void method2() {

        method3();

    }

    static void method1() {

        method2();

    }

    public static void main(String[] args) {

        method1();

    }

}