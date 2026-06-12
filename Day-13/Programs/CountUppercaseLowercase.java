public class CountUppercaseLowercase {

    public static void main(String[] args) {

        String str = "JavaProgramming";

        int upper = 0;
        int lower = 0;

        for(char ch : str.toCharArray()) {

            if(Character.isUpperCase(ch)) {
                upper++;
            } else if(Character.isLowerCase(ch)) {
                lower++;
            }
        }

        System.out.println("Uppercase = " + upper);
        System.out.println("Lowercase = " + lower);
    }
}