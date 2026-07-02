import java.io.FileReader;
import java.io.IOException;

public class Program02_CheckedExceptionDemo {

    public static void main(String[] args) {

        try {

            FileReader reader =
                    new FileReader("student.txt");

            System.out.println("File Opened");

        } catch (IOException e) {

            System.out.println("File not found.");

        }

    }
}