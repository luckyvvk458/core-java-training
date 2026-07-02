public class Program07_ExceptionPropagation {

    static void method3() {

        int result = 10 / 0;

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